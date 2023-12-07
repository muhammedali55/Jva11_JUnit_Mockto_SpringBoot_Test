package com.muhammet.jnuttest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class Test09_ZamanAsimi {

    @Test
    @Timeout(1)
    void testTimeout() throws InterruptedException {
        Thread.sleep(990L);
        System.out.println("Süreeeee");
    }

    @Test
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    void testTimeout2(){
        System.out.println("süreç uzun sürebilir");
        int toplam=0;
        for(int i=0;i<2_000_000_000;i++){
            toplam += i;
        }
       // Assertions.assertTrue(toplam>1_000);
    }


}
