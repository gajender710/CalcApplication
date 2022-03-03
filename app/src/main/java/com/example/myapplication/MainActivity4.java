package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent=new Intent(MainActivity4.this,MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        findViewById(R.id.floatingActionButton3).setOnClickListener(view -> startActivity(intent));

        Intent intent2=new Intent(MainActivity4.this,MainActivity.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        findViewById(R.id.button_calculator).setOnClickListener(view -> startActivity(intent2));


    }
}