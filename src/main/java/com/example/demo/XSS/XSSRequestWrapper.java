package com.example.demo.XSS;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;


public class XSSRequestWrapper extends HttpServletRequestWrapper {


    public XSSRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        System.out.println("ok2");

    }

    @Override
    public String getParameter(String parameter) {
        System.out.println("1"+parameter);
        String value = super.getParameter(parameter);

        return stripXSS(value);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        System.out.println("2"+parameter);
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = stripXSS(values[i]);
        }
        return encodedValues;
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        System.out.println("3"+name);
        Enumeration<String> headers = super.getHeaders(name);

        List<String> result = new ArrayList<>();
        while (headers.hasMoreElements()) {
            String[] tokens = headers.nextElement().split(",");
            for (String token : tokens) {
                result.add(StringEscapeUtils.escapeHtml4(token));
            }
        }

        return Collections.enumeration(result);
    }


    public static String stripXSS(String value) {

        if (value != null) {
            // 使用正則表達式去除潛在的XSS攻擊腳本

            value = StringEscapeUtils.escapeHtml4(value);

        }

        return value;

    }




}