package com.muhammet.jnuttest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test07_TekrarlananTestler {

    @RepeatedTest(12)
    void repeatTest(){
        System.out.println("Tekrarlayan testler");
    }

    @RepeatedTest(value = 14, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Tekrar!!!! ")
    void repeatTestDisplay(){
        System.out.println("Tekrarlayan testler");
    }

}
