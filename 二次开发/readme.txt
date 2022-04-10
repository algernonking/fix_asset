二次开发说明
   所有需要二次开发的代码均已开放，确保不影响二次开发

二次开发说明
- 1、正常情况下使用IDE maven3.6版本可以正常下载,如果未下载，可以在private_lib.tar.gz压缩包内找到所有私有库,进行手动安装即可
- 2、SQL文件:(每日更新):http://121.43.103.102/upload/sql.tar.gz
- 3、运行环境要求:mysql版:5.7.X,Java版本:1.8
- 4、部署请参考Git目录文档目录下的《EAM安装部署维护手册.docx》
- 5、数据库jdbc信息默认为密文模式,当需要明文信息，
    则把配置文件中的druid.primary.encrypt.enable:false
    另外密文的连接信息，账户，密码，改成明文的jdbc连接信息即可
        url: jdbc:mysql://121.43.103.102:3306/eam?tinyInt1isBit=false&useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&allowPublicKeyRetrieval=true
        username: root
        password: 12345
    特别注意:url:这行比较长，不能换行，否则会报异常问题
- 6、二次开发的时候，优先关注自动代码生产部分(common/generator/src/main/java/module/eam)，比较关键，
    每张数据库表，都会建立一个自动代码生产类(必须的)，自动代码生产可以为你生成所有前后端代码，以及关键的关联操作等，具体使用依样画葫芦就行。



问题清单:
- 1、如果系统启动都正常，在新增数据时报错，可能生成序列的存储过程未成功执行



