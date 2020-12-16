package com.example.p7.factory;

import android.util.Log;

public class Iphone implements Phone {
    @Override
    public void makephone() {
        Log.e("TAG","Iphone");
    }
}
