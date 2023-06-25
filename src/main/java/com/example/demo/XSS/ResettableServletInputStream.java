package com.example.demo.XSS;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResettableServletInputStream extends ServletInputStream {

    private InputStream inputStream;

    public ResettableServletInputStream(byte[] bytes) {
        this.inputStream = new ByteArrayInputStream(bytes);
    }

    @Override
    public boolean isFinished() {
        try {
            return inputStream.available() == 0;
        } catch (IOException e) {
            return true;
        }
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        // 不需要实现
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }
}
