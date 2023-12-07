package com.muhammet.jnuttest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test06_TestlerinSiraliCalismasi {

    @Test
    @Order(1)
    void test002() throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("Test 002 çalıştı");

    }


    @Test
    @Order(3)
    void test001() throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("Test 001 çalıştı");

    }

    @Test
    @Order(2)
    void test003() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("Test 003 çalıştı");
    }

}
