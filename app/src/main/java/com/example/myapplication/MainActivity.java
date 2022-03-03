package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textField;

    private int firstValue = 0, second = 0;
    private String selectedOperator;
    private boolean isOperatorSel = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        findViewById(R.id.button_next).setOnClickListener(view -> startActivity(intent));

        textField = findViewById(R.id.result);
        List<Button> x = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            String string = "button" + i;
            int resid = getResources().getIdentifier(string, "id", getPackageName());
            x.add(findViewById(resid));
            listener(x.get(i));
        }

        findViewById(R.id.buttonadd).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttonminus).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttondivide).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttonx).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttonclear).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttonequate).setOnClickListener(view -> performCalculation());
    }


    public void listener(Button a) {
        a.setOnClickListener(view -> {
            Button b = (Button) view;
            Log.d(TAG, "button clicked " + b.getText());
            textField.append(b.getText());
        });
    }

    private void operandSelected(Button button) {
        if (!(textField.getText().toString().isEmpty())) {
            firstValue = Integer.parseInt(textField.getText().toString());
            isOperatorSel = true;
        }
        if (button.getText().toString().toLowerCase(Locale.ROOT).equals("c")) {
            firstValue = 0;
            textField.setText("");
        }
        selectedOperator = button.getText().toString();
        textField.setText("");
    }

    private void performCalculation() {

        int val = 0;

        if (textField.getText().toString().isEmpty()) {
            return ; }
        second = Integer.parseInt(textField.getText().toString());
        if (isOperatorSel && !textField.getText().toString().isEmpty()) {
            second = Integer.parseInt(textField.getText().toString());
        }
        if (selectedOperator == null) {
            if (firstValue == 0 && !textField.getText().toString().isEmpty()) {
                firstValue = Integer.parseInt(textField.getText().toString());
            }
            textField.setText(String.valueOf(firstValue));
            return;
        }

        switch (selectedOperator) {
            case "+":
                val = firstValue + second;
                break;
            case "-":
                val = firstValue - second;
                break;
            case "x":
                val = firstValue * second;
                break;
            case "/":
                if(second==0)
                {
                    textField.setText("");
                    return;
                }
                val = firstValue / Integer.parseInt(textField.getText().toString());
                break;
            case "C":
                val = firstValue / Integer.parseInt(textField.getText().toString());
                firstValue = 0;
                second = 0;
                textField.setText("");
                break;
            default:
                textField.setText(String.valueOf(val));
                break;
        }
        firstValue = val;
        isOperatorSel = false;
        textField.setText(String.valueOf(val));
    }
}