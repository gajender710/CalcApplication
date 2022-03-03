package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private static final String TAG="MainActivity3";
    private TextView textfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textfield=findViewById(R.id.textView_activity3);

        String first=getIntent().getStringExtra("First");

        Log.d(TAG, "onCreate: "+first);
        Log.e(TAG, "onCreate: "+first);

        textfield.setText(first);

        Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
        intent.putExtra("First","helloworld2");
        findViewById(R.id.floatingActionButton2).setOnClickListener(view -> startActivity(intent));



    }
}