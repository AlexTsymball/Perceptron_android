package com.example.perceptron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void Result(View v) {
        double[] result;
        TextView w1 = (TextView) findViewById(R.id.w1);
        TextView w2 = (TextView) findViewById(R.id.w2);
        String el1 = (getIntent().getStringExtra("time"));
        String el2 = (getIntent().getStringExtra("iter"));
        String el3 = (getIntent().getStringExtra("fast"));

        if(el1.equals("0.0")){
            double iter = Double.parseDouble(el2);
            double fast = Double.parseDouble(el3);
            result = iterDeadline((iter), (fast));
        }else{
            double time = Double.parseDouble(el1);
            double fast = Double.parseDouble(el3);
            result = timeDeadline((time), (fast));
        }

        w1.setText(Double.toString(result[0]));
        w2.setText(Double.toString(result[1]));
    }

    private int k = 0;

    private double[] iterDeadline(Double iter, Double fast) {
        double[] w = {0, 0};
        int count = 0;
        while (count != iter) {
            w = function(fast, w);
            if (k == 4) {
                return w;
            }else{
                k = 0;
            }
            count += 4;
        }
        return w;
    }


    private double[] timeDeadline(Double time, Double fast) {
        double[] w = {0, 0};
        double stop = 0;
        double timeBefore =  System.nanoTime()*Math.pow(10,-9);
        while (stop < time) {
            w = function(fast, w);
            if (k == 4) {
                return w;
            }else{
                k = 0;
            }
            double timeAfter = System.nanoTime()*Math.pow(10,-9);
            stop = (timeAfter - timeBefore);
//            System.out.println(stop);
//            System.out.println("time " + time);
        }
        return w;
    }

    private double[] function(Double fast, double[] w) {
        w = first(w, fast,  0, 6);
        w = second(w, fast, 1, 5);
        w = first(w, fast ,3, 3);
        w = second(w, fast,  2, 4);
        return w;
    }

    private int P = 4;

    private double[] first(double[] w, Double fast, int a, int b) {
        double delta = 5;
        double y = a * w[0] + b * w[1];
        if (y < P) {
            delta -= y;
            w[0] = w[0] + delta * fast * a;
            w[1] = w[1] + delta * fast * b;
        }else{
            k++;
        }
        return w;
    }

    private double[] second(double[] w, Double fast, int a, int b) {
        double delta = 3;
        double y = a * w[0] + b * w[1];
        if (y > P) {
            delta -= y;
            w[0] = w[0] + delta * fast * a;
            w[1] = w[1] + delta * fast * b;
        }else{
            k++;
        }
        return w;
    }
}
