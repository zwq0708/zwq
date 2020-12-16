package com.example.p7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7.factory.Phone;
import com.example.p7.factory.Phonefactory;
import com.example.p7.factory2.ThreadPoolfactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button single;
    private Button factory;
    private Button easyfactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        single = (Button) findViewById(R.id.single);
        factory = (Button) findViewById(R.id.factory);

        single.setOnClickListener(this);
        factory.setOnClickListener(this);
        easyfactory = (Button) findViewById(R.id.easyfactory);
        easyfactory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.single:

                break;
            case R.id.factory:
                Phone miphone = Phonefactory.createphone("Miphone");
                miphone.makephone();
                Phone iphone = Phonefactory.createphone("Iphone");
                iphone.makephone();
                break;
            case R.id.easyfactory:
                ThreadPoolfactory
                        .getexecute(ThreadPoolfactory.CACHE_THREADPOOL)
                        .executeTask(new Runnable() {
                            @Override
                            public void run() {
                                //耗时操作
                            }
                        });
                break;
        }
    }
}