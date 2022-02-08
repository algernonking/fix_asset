package com.dt.platform.ops.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.InteractiveCallback;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.github.foxnic.commons.log.Logger;

public class RemoteShellExecutor {

    private Connection conn;
    /** 远程机器IP */
    private String ip;
    /** 用户名 */
    private String osUsername;
    /** 密码 */
    private String password;
    private String charset = Charset.defaultCharset().toString();

    private int port = 22;
    private static final int TIME_OUT = 1000 *8;

    private Session session;

    /**
     * 构造函数
     *
     * @param ip
     * @param usr
     * @param pasword
     */
    public RemoteShellExecutor(String ip, String usr, String pasword) {
        this.ip = ip;
        this.osUsername = usr;
        this.password = pasword;
    }

    public RemoteShellExecutor(String ip, String usr, String pasword, int port) {
        this.ip = ip;
        this.osUsername = usr;
        this.password = pasword;
        this.port = port;
    }

    /**
     * 登录
     *
     * @return
     * @throws IOException
     */
    public class UsernamePasswordInteractiveCallback implements InteractiveCallback {

        public String[] replyToChallenge(String s, String instruction, int numPrompts, String[] arg3, boolean[] arg4) {
            final String[] result2 = new String[numPrompts];
            System.out.println("numPrompts:" + numPrompts);
            if (numPrompts > 0) {
                Arrays.fill(result2, password);
            }
            return result2;
        }

    }

    public boolean login() {

        conn = new Connection(ip, port);
        boolean result = false;
        try {
            conn.connect();
            result = conn.authenticateWithPassword(osUsername, password);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("authenticateWithPassword failed,try to authenticateWithKeyboardInteractive");
        }
        if (result) {
            return result;
        }
        // login for the first time
        UsernamePasswordInteractiveCallback il = new UsernamePasswordInteractiveCallback();
        boolean loginSuccess = false;
        try {
            conn = new Connection(ip, port);
            conn.connect();
            loginSuccess = conn.authenticateWithKeyboardInteractive(osUsername, il);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            Logger.info("authenticateWithKeyboardInteractive failed.");
        }
        return loginSuccess;

    }

    /**
     * 执行脚本
     *
     * @param cmds
     * @return
     * @throws Exception
     */
    public RemoteShellResult exec(List<String> cmds) {
        String cmdstr = "";
        for (int i = 0; i < cmds.size(); i++) {
            cmdstr += cmds.get(i) + ";";
        }
        return exec(cmdstr);

    }

    public void close() {
        conn.close();
    }

    public RemoteShellResult exec(String cmds) {
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr = "";
        String outErr = "";
        StringBuffer result = new StringBuffer();
        int ret = -1;
        try {
            Logger.info("login status:" + login() + "," + cmds);
            if (login()) {
                // Open a new {@link Session} on this connection
                session = conn.openSession();
                session.requestPTY("vt100", 80, 24, 640, 480, null);
                session.execCommand(cmds);
                stdOut = new StreamGobbler(session.getStdout());
                outStr = processStream(stdOut, charset);
                stdErr = new StreamGobbler(session.getStderr());
                outErr = processStream(stdErr, charset);
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                result.append(outStr.trim());
                result.append(outErr.trim());
                ret = session.getExitStatus();
                session.close();
            } else {
                ret = -101;
                result.append("登录远程机器失败" + ip);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ret = -102;
            result.append("执行异常IO" + e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
            ret = 0;
            result.append("");
            if (stdOut != null) {
                try {
                    stdOut.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (stdErr != null) {
                try {
                    stdErr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return RemoteShellResult.setData(ret, result.toString().trim());
    }

    /**
     * @param in
     * @param charset
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    private String processStream(InputStream in, String charset) {
        String str = "";
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try {
            while ((length = in.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            str = result.toString(StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        RemoteShellExecutor rmt=new RemoteShellExecutor("121.43.103.102","root","1@",22);
        RemoteShellResult r=rmt.exec("df");

        RemoteShellResult r2=rmt.exec("df");
        RemoteShellResult r3=rmt.exec("df");
        System.out.println(r.result);
    }

}