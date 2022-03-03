package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //private static final String TAG = "MainActivity2";
    private TextView textfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textfield = findViewById(R.id.EditView_activity2);

        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);


        findViewById(R.id.floatingActionButton).setOnClickListener(view -> {
            intent.putExtra("First", textfield.getText().toString());
            startActivity(intent);
        });

    }
}