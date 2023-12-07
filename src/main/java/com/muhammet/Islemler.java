package com.muhammet;

public class Islemler {

    public int AlanHesaplama(int uzuluk, int genislik, Tur tur){
       return switch (tur){
           case KARE -> uzuluk*genislik;
           case DIKTORTGEN -> uzuluk*genislik;
           case UCGEN -> (uzuluk*genislik)/2;
           default -> 0;
        };
    }

    public String ifadeBuyutme(String ifade){
        String result="";
        if(ifade.length()<5){
                result = ifade.substring(0,1).toUpperCase()+ ifade.substring(1);
        }else if(ifade.length()<10){
            result = ifade.toUpperCase();
        }else{
            result = ifade.toLowerCase();
        }
        return result;
    }

    public String getUserIdFromToken(String token){
        if(token.contains("Bearer ")){
            String id = token.substring(7);
            if(id.contains("mk"))
                return id;
            throw new RuntimeException("Geçersiz id");
        }
        throw new RuntimeException("geçersiz token");
    }
}
