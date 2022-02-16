package com.example.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=findViewById(R.id.view);

        findViewById(R.id.bswap).setOnClickListener(this::changeColor);

    }

    public void changeColor(View v){
        view.changeColor();
    }
}