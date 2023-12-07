package com.muhammet.jnuttest;

import com.muhammet.Islemler;
import com.muhammet.Tur;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Test04_AssetionUsing {

    private static Islemler islemler = new Islemler();

    @Test
    void standartAssertEquals(){
        // olması gereken değer, işlem sonucu dönen değer
        /**
         * üçgen: 5,12 -> 30 alan
         */
        assertEquals(30,islemler.AlanHesaplama(5,12, Tur.UCGEN));
        //assertEquals(30,islemler.AlanHesaplama(5,12,Tur.KARE),"Yanlış olmuş, git düzelt öyle gel");
        assertTrue(30==islemler.AlanHesaplama(12,5,Tur.UCGEN));
        assertTrue(30==islemler.AlanHesaplama(12,5,Tur.KARE),()-> "Hata mı yapmışım?");
        // tam tersi de aynı kullanım için geçerlidir. assertFalse();

    }

    @Test
    void grouppedAssertions(){
        /**
         * normal bir akışta işlem
         * assertEquals();
         * assertEquals();
         * assertEquals();
         * şeklinde yazılırsa tüm işlemler sıra ile işletilir. Bu durum bir işlem bitmeden diğerinin
         * kontrol edilmeyeceği anlamına gelir.
         * Bu durumun şöyle bir dez avantajı vardır, sizin methodunuz diyelim ki 1-2 dakika sürede test ediliyor olsun.
         * böyle bir durumda çoklu testlerde işlem test süresi çok uzayacktır.
         * assertAll da ise durum şöyledir;
         * her bir işlem için ayrı bir thread çalıştırılır böylece işlemler aynı anda başlatılır ve neredeyse aynı
         * sürelerde biter, yani şöyle düşünecek olursak;
         * 2 dakika süren 10 iş testi için klasik yolla test yaparsanız 20DK sürerken
         * 10 iş testi gruplama da 2DK 15sn gibi bir sürede tamamlanacaktır.
         *
         *
        */
        assertAll("İşlem Gruplarının Test Edilmesi",
                ()-> assertEquals(30, islemler.AlanHesaplama(5,12,Tur.UCGEN)),
                ()-> assertEquals(60, islemler.AlanHesaplama(12,5,Tur.DIKTORTGEN)),
                ()-> assertEquals(100,islemler.AlanHesaplama(10,10,Tur.KARE))
        );
    }

    @Test
    void exceptionTest(){
       assertEquals("mk0001",islemler.getUserIdFromToken("Bearer mk0001"));
       RuntimeException hata = assertThrows(RuntimeException.class,
               ()-> islemler.getUserIdFromToken("Bearer kf0001"));
        assertEquals("geçersiz token", hata.getMessage());

    }

    @Test
    void timeoutTest(){
        // Bir işlemin(Method) çalışma zaman aşımını test etmek için kullanılır.
        assertTimeout(Duration.ofMinutes(2),()->{
            // buraya kodlarınızı ekleyiniz. genellikle tek method test etmeniz doğru olacaktır.
        });
        assertTimeout(Duration.ofMillis(2),()->{
            try{
                System.out.println("Muhammet");
                Thread.sleep(1);
                System.out.println("Uygluma bitti");
            }catch (Exception exception){

            }
        });

        int alan = assertTimeout(Duration.ofMillis(5),()->{
            return islemler.AlanHesaplama(5,12,Tur.UCGEN);
        });
        assertEquals(30,alan);
    }



}
