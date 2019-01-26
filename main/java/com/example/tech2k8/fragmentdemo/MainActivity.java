package com.example.tech2k8.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loadNext;
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadNext=findViewById(R.id.load);
        loadNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag)
                {
                    loadViews();
                    flag=false;
                }
                else
                {
                    loadSecondViews();
                    flag=true;
                }

            }
        });
    }

    private void loadViews()
    {
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentOneDemo demo=new FragmentOneDemo();
        transaction.replace(R.id.container,demo).commit();
    }

    private void loadSecondViews()
    {
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentTwoDemo demo=new FragmentTwoDemo();
        transaction.replace(R.id.container,demo).commit();
    }
}
