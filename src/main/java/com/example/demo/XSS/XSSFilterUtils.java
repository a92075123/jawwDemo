package com.example.demo.XSS;

import java.util.regex.Pattern;

public class XSSFilterUtils {
    private static final Pattern[] XSS_PATTERNS = {
            Pattern.compile("<", Pattern.CASE_INSENSITIVE),
            Pattern.compile(">", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\(", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("'", Pattern.CASE_INSENSITIVE),
            Pattern.compile("eval\\((.*)\\)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", Pattern.CASE_INSENSITIVE),
            Pattern.compile("script", Pattern.CASE_INSENSITIVE)
    };
    public static void main(String[] args) {
        System.out.println(stripXSS("1<script>"));
    }
    public static String stripXSS(String value) {
        if (value != null) {
            for (Pattern pattern : XSS_PATTERNS) {
                value = pattern.matcher(value).replaceAll("");
            }
        }
        return value;
    }
}
