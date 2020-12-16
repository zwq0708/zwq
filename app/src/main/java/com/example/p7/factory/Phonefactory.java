package com.example.p7.factory;

/**
 * 工厂方法
 */
public class Phonefactory {

    public static Phone createphone(String type){
        if(type.equals("Miphone")){
            return new Miphone();
        }else if (type.equals("Iphone")){
            return new Iphone();
        }
        return null;
    }
}
