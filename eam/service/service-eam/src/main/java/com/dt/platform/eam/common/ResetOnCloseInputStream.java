package com.dt.platform.eam.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResetOnCloseInputStream  extends BufferedInputStream {
    private final InputStream decorated;
    public ResetOnCloseInputStream(InputStream anInputStream) {
        super(anInputStream);
        if (!anInputStream.markSupported()) {
            throw new IllegalArgumentException("marking not supported");
        }
        anInputStream.mark( 1 << 24); // magic constant: BEWARE
        decorated = anInputStream;
    }

    @Override
    public void close() throws IOException {
        decorated.reset();
    }
    public void realClose() throws IOException {
        decorated.close();
    }

    @Override
    public int read() throws IOException {
        return decorated.read();
    }

}
