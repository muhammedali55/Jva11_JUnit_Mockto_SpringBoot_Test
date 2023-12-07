package com.muhammet.mockito.repository;

import java.util.List;

public class UserRepository {

    public void save(){
        System.out.println("Kullanıcı Kayıt edildi.");
    }

    public void update(){
        System.out.println("Kullanıcı güncellendi.");
    }

    public List<String> findAll(){
        return  List.of();
    }
}
