package com.example.perceptron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Time extends AppCompatActivity {
    private Button res;
    public double time = 0;
    public double iter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        res = (Button) findViewById(R.id.butRes1);
        res.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.perceptron.Result");
                        intent.putExtra("time", Double.toString(time));
                        String fast = getIntent().getStringExtra("fast");
                        System.out.println(fast);
                        System.out.println(fast);
                        System.out.println(fast);
                        System.out.println(fast);
                        System.out.println(fast);
                        System.out.println(fast);
                        intent.putExtra("fast", fast);
                        intent.putExtra("iter", Double.toString(iter));
                        startActivity(intent);
                    }
                }
        );

    }

    public void onCheckboxClicked(View view) {
        CheckBox timeBox = (CheckBox) view;
        boolean checked = timeBox.isChecked();

        switch (view.getId()) {
            case R.id.s0_5:
                if (checked) {
                    time = 0.5;
                }
                break;
            case R.id.s1:
                if (checked) {
                    time = 1;
                }
                break;
            case R.id.s2:
                if (checked) {
                    time = 2;
                }
                break;
            case R.id.s5:
                if (checked) {
                    time = 5;
                }
                break;
        }
    }
}
