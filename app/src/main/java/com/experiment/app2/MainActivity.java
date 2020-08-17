package com.experiment.app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private TextView input;
    private TextView output;
    private ConstraintLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        parentLayout = findViewById(R.id.parentLayout);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
    }

    public void fact(View v){
        long n = (long) getInput();
        String result = "";
        if (n > 25)
            result = "Factorial too big to display!";
        else if (n < 0)
            result = "Factorial of -ve numbers don't exist!";
        else
            result = n + "! = " + getFact(n);
        output.setText(result);
    }

    private long getFact(long x){
        if (x <= 1)
            return 1;
        return x * getFact(x - 1);
    }

    public void evenOdd(View v){
        int n = (int) getInput();
        String result = "";
        if (n%2 == 0) {
            result =  n + " is even";
        } else {
            result =  n + " is odd";
        }
        output.setText(result);
    }

    public void checkPrime(View v){
        int n = (int) getInput();
        String result = "";
        boolean isFact = true;
        if (n<2)
            isFact = false;
        for(int i = 2; i <= n/2; i++){
            if (n%i == 0){
                isFact = false;
                break;
            }
        }
        if (isFact)
            result = n + " is Prime";
        else
            result = n + " is not Prime";
        output.setText(result);
    }

    public void checkArmstrong(View v){
        long n = (long) getInput();
        String result = "";
        long temp = n;
        long sum = 0;
        int digits = getDigits(n);
        while(temp>0){
            int r = (int)temp%10;
            temp /= 10;
            sum += Math.pow(r, digits);
        }
        if (sum == n)
            result = n + " is an Armstrong Number";
        else
            result = n + " is not an Armstrong Number";
        output.setText(result);
    }

    private int getDigits(long n){
        int digits = 0;
        while( n>0 ){
            n /= 10;
            digits++;
        }
        return digits;
    }

    private double getInput(){
        String inputText = input.getText().toString();
        if (inputText.isEmpty()){
            Snackbar.make(parentLayout, "Please input a number!", Snackbar.LENGTH_SHORT).show();
            return 0;
        }
        return Double.parseDouble(inputText);
    }
}