package com.muhammet.jnuttest;

import com.muhammet.Islemler;
import com.muhammet.Tur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test01_Giris {
    /**
     * Uygulamaları geliştirirken en çok düşülen sorunlardan birini gidermek için yapılır. Kodun
     * düzenlenmesi ve revizyonu.
     * Test bir method için yazılır. Ancak bir methodun tüm ihtimalleri için ayrı ayrı testler yazılmalıdır.
     * Testlerin erişim belirteçleri olmaz,
     * İşlem yapıp bittikleri için geri değer dönmelerine gerek yoktur. Void
     * Bir methodun test olarak çalışması için üzerinde @Test anotasyonu eklenir.
     */

    @Test
    void ilkTest(){
        System.out.println("İlk Test Denemesi");
    }

    @Test
    void dogruDegerDogruCevapTest(){
        Islemler islemler = new Islemler();
        int alan = islemler.AlanHesaplama(10,3, Tur.UCGEN);
        Assertions.assertEquals(15, alan);
    }

    @Test
    void ifadeBuyut5TenKucukOlmaDurumTest(){
        Islemler islemler = new Islemler();
        String deger = islemler.ifadeBuyutme("mert");
        Assertions.assertEquals("Mert",deger);
    }

    @Test
    void ifadeBuyut5TenBuyuk10DanKucukOlmaDurumTest(){
        Islemler islemler = new Islemler();
        String deger = islemler.ifadeBuyutme("mertali");
        Assertions.assertEquals("MERTALİ",deger);
    }

    @Test
    void ifadeBuyut10DanBuyukOlmaDurumTest(){
        Islemler islemler = new Islemler();
        String deger = islemler.ifadeBuyutme("MERT Ali Hasan Can");
        Assertions.assertEquals("mert ali hasan can",deger);
    }


}
