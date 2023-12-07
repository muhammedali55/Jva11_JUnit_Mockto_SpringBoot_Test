package com.muhammet.jnuttest;

import static org.junit.jupiter.api.Assertions.*;

import com.muhammet.jnuttest.entity.User;
import com.muhammet.jnuttest.utility.Cinsiyet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.*;

import java.io.ObjectOutputStream;
import java.util.EnumSet;

public class Test08_ParametreliTestler {

    @ParameterizedTest
    @ValueSource(ints = {5,4324,234,23423,43,4})
    void testParameterValue(int sayi){
        assertTrue(sayi >50);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"","   ", "\t", "\n", "Muhammet"})
    void testNullOrEptyData(String ifade){
        /**
         * String ifade = null;
         * ifade "" -> empty
         * ifade " " -> blank
         */
        assertTrue(ifade==null || ifade.trim().isEmpty());
    }

    @ParameterizedTest
    @EnumSource(names = {"ERKEK","KADIN","BELIRTMEK_ISTEMIYOR"})
    void testWithEnums(Cinsiyet cinsiyet){
        assertTrue(EnumSet.of(Cinsiyet.ERKEK, Cinsiyet.KADIN).contains(cinsiyet));
    }

    /**
     * Test işlemlerinde CSV dosya türünü kullanarak çoklu testler yapabiliriz ve
     * sistemimizi doğru test etmek için faydalı oalcaktır.
     * datasource.csv ->muhamet,ahmet,canan,hakan,......
      */
    @ParameterizedTest
    @CsvSource({
            "Muhammet,  40",
            "Canan,     33",
            "Berfin,    23",
            "Tuna,      45",
            "Tekin,     66",
    })
    void  testWithCSV(String userName, int age){
        System.out.println("Kullanıcı Adı...: "+ userName);
        System.out.println("Kullanıcı yaşı..: "+ age);
        System.out.println("----------------------------");
        assertTrue(age<=40);

    }

    /**
     * File file = new File("user.csv");
     * FileOutputStream out = new FileOutpuStream("user.csv");
     * ObjectOutputStream obj = new ObjectOutputStream(out);
     * userList.forEach(o->{
     *     obj.writeObject(o);
     * })
     * obj.close();
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/userlist.csv", numLinesToSkip = 10)
    void testWithCvsFile(String name, int yas){
        assertTrue(yas<50);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/userlist.csv", numLinesToSkip = 10)
    void testWithCvsFileAgumentAccessor(ArgumentsAccessor accessor){
        User user = new User(
                accessor.getString(0),
                accessor.getInteger(1)
        );
        System.out.println(user);
        assertTrue(user.getYas()<50);
    }


}
