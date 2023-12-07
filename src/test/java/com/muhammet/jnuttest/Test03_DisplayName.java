package com.muhammet.jnuttest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Test03_DisplayName {

    @Test
    @DisplayName("User Servis için Kayıt etme kontrolü null değer işlemi")
    void test01(){
        System.out.println("1. test");
    }

    @Test
    @DisplayName("Test0002")
    void test02(){
        System.out.println("2. Test");
    }

    @Test
    @DisplayName("\uD83D\uDE31")
    void testNeyyy(){

    }

    @Test
    void testFail(){
        Assertions.fail();
    }

    @Nested
    class IcSinif{
        @Test
        void Test(){

        }

        @Test
        void yeniTest(){

        }
    }

}
