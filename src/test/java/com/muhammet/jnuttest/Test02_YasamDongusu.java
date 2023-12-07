package com.muhammet.jnuttest;

import com.muhammet.Islemler;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test02_YasamDongusu {

    private static List<String> userList;
    private static Islemler islemler;
    @BeforeAll
    void initAll(){
        islemler = new Islemler();
        System.out.println("@BeforeAll: Ben herşeyden önce başlarım");
    }

    @BeforeEach
    void init(){
        userList = new ArrayList<>();
        userList.add("Muhammet");
        userList.add("Deniz");
        System.out.println("@BeforeEach: Testleden önce Çalışır");
    }
    @Test
    void denemeTest(){
        userList.add("Yeni ekleme Yapıldı.");
        System.out.println("Deneme test çalıştı"+ userList);
    }
    @Test
    void deneme2Test(){
        userList.add("Makarna");
        System.out.println("2. test...: "+userList);
    }

    @Test
    @Disabled
    void failingTest() throws InterruptedException {
        for(int i=1; i<=5;i++){
            Thread.sleep(1000L);

            if (i==4)
                Assertions.fail("çok uzun tam sayı nedeniyle fail oldu");
            else
                System.out.println("normal çalışma durumu..: "+ i);

        }

    }

    @Test
    @Disabled("bir süreliğine kapalı")
    void gerliliginiGeciciSureyleYitirmisTest(){
        System.out.println("Testt");
    }

    @AfterEach
    void after(){
        System.out.println("@AfterEach: Her testten sonra ben varım.");
    }

    @AfterAll
    void afterAll(){
        System.out.println("@AfterAll: Ben son ütücüyüm :)");
    }
}
