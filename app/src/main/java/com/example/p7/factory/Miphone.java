package com.example.p7.factory;

import android.util.Log;

public class Miphone implements Phone {
    @Override
    public void makephone() {
        Log.e("TAG","Miphone");
    }
}
