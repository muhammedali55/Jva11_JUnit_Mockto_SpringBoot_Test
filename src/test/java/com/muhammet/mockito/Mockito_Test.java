package com.muhammet.mockito;

import com.muhammet.mockito.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;


import java.sql.Array;
import java.util.*;

public class Mockito_Test {
    /**
     * Mock - Mock Data Nedir?
     *
     * Mock List
     *
     *
     *
     */
    @Test
    void firtMock(){
        List mockList = mock(ArrayList.class);
        mockList.add("Ahmet");
        mockList.add("Deniz");
        mockList.clear();
        mockList.forEach(System.out::println);
        verify(mockList).add("Ahmet");
        verify(mockList).add("Deniz");
        verify(mockList).clear();
    }
    @Test
    void cevapDonmek(){
        LinkedList list = mock(LinkedList.class);
        LinkedList list1 = new LinkedList();
        when(list.get(9)).thenReturn("selamlar");
        when(list.get(0)).thenReturn(new ArrayIndexOutOfBoundsException());
        when(list.get(1)).thenReturn(List.of("baksen","neler","var mış"));

        System.out.println("10. değeri çek....: "+list.get(9));
        System.out.println("1. değer..........: "+ list.get(0));
        System.out.println("2. değer..........: "+ list.get(1));
        // System.out.println("10. değeri çek....: "+ list1.get(9)); // hata verir.
    }
    @Test
    void bagimsizDegisken(){
        Map<Integer,String> mockmap = mock(HashMap.class);
        when(mockmap.get(anyInt())).thenReturn("bişey dön");
        System.out.println("3. index...: " + mockmap.get(3));
        System.out.println("43. index..: "+ mockmap.get(43));
        verify(mockmap).get(anyInt());
    }
    @Test
    void methodCagrimSayisi(){
        LinkedList mockList = mock(LinkedList.class);
        mockList.add("ilk ekleme");

        verify(mockList).add("ilk ekleme");

        mockList.add("2 li 1. tur ekleme");
        mockList.add("2 li 1. tur ekleme");

        mockList.add("Ayşe");
        mockList.add("Ayşe");
        mockList.add("Ayşe");
        // 2 li 1. tur ekleme ifadesinin add methosu çağrımının 2 kez yapılmış olma durumu kontrolü
        verify(mockList,times(2)).add("2 li 1. tur ekleme");
        // Muhammet ifadesinin add methosu ile hiç çağrımının yapmamış olma durumu
        verify(mockList, never()).add("Muhammet");
        // Ayşe ifadesinin en fazla bir kez çağrımının yapılmış olma durumu
        verify(mockList,atMostOnce()).add("ilk ekleme");
        // Ayşe ifadesinin en az bir kez çağrımının yapılmış olma durumu
        verify(mockList,atLeastOnce()).add("Ayşe");
        // ilk ekleme en az 2 çağrım yapılmış olma durumu
        // verify(mockList,atLeast(2)).add("ilk ekleme"); hata verir.
        // Ayşe ifadesinin en fazla 3 cağrım yapılmış olma durumu
        verify(mockList,atMost(3)).add("Ayşe");
    }
    @Test
    void istisnaFirlatma(){
        LinkedList mockList = mock(LinkedList.class);
        doThrow(new RuntimeException("olmadı tekrar dene")).when(mockList).get(90);
        doThrow(new RuntimeException("HATAA :))")).when(mockList).clear();
        System.out.println("98. index...: "+ mockList.get(98));
        System.out.println("91. index...: "+ mockList.get(91));
        mockList.clear();
    }
    @Test
    void testleriSiraliYapmak(){
        List mockList = mock(ArrayList.class);

        mockList.add("1. ekleme");
        mockList.add("2. ekleme");

        InOrder sirali = inOrder(mockList);

        sirali.verify(mockList).add("1. ekleme");
        sirali.verify(mockList).add("2. ekleme");

    }




    @Test
    void findAllTest(){
        UserRepository repository = new UserRepository();
        repository.save();
        repository.update();
        repository.save();
        List<String> userList = repository.findAll();
        assertFalse(userList.isEmpty());
    }
    @Test
    void findAllMockTest(){
        UserRepository repository = mock(UserRepository.class);
        when(repository.findAll()).thenReturn(List.of("ahmet","turna"));
        List<String> userList = repository.findAll();
        assertFalse(userList.isEmpty());
    }

}
