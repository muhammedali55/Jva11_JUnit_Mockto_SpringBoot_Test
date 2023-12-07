package com.muhammet.jnuttest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.condition.OS.*;

public class Test05_KosulaUygunYurutme {

    @Test
    @EnabledOnOs(MAC)
    void runTestOnMAC(){
        System.out.println("MAC işletim sisteminde çalışır");
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void runTestOnWindows(){
        System.out.println("Windows işletim siteminde çalışır.");
    }

    @Test
    @EnabledOnOs({LINUX,MAC})
    void runTestOnMultiOS(){
        System.out.println("Linux ya da MacOS ta çalışır");
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs({WINDOWS,MAC})
    @interface benimTanimliTestim{
    }

    @benimTanimliTestim
    void ozelTestDenemesi(){
        System.out.println("Özel test denemesi");
    }

    @Test
    @EnabledOnOs(architectures = "x86_64")
    void runTestOnItel(){
        System.out.println("İntel işlemciler için çalışır");
    }

    @Test
    @EnabledOnOs(architectures = "aarch64")
    void runTestOnMX(){
        System.out.println("Mac Mx Chipset lerde çalışır");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void runTestOnJre17(){
        System.out.println("Java 17 çalıştı");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void runTestOnJre21(){
        System.out.println("Java 21 çalıştı");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    void runTestOnJreRange11_17(){
        System.out.println("Java 11 - 17 çalıştı");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CONFIG_SERVER", matches = "http://*:8888")
    void runTestEnv(){
        System.out.println("env çalışma koşulu");
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = "aarch64")
    void runTestOnSystemProperties(){
        System.out.println("Sistem Properties çalıştı");
    }

}
