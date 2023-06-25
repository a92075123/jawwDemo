package com.example.demo.XSS;

import org.owasp.esapi.ESAPI;

public class ESAPITest {
    public static void main(String[] args) {
        System.out.println(ESAPI.encoder().encodeForHTML("<a href='sdfs'></a> < script > alert(); </ script >"));

    }
}
