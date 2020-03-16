package com.example.perceptron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Deadline extends AppCompatActivity {
    private Button time, iter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadline);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        time = (Button) findViewById(R.id.butTime);
        iter = (Button) findViewById(R.id.butIter);
        time.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.perceptron.Time");
                        String fast = getIntent().getStringExtra("fast");

                        intent.putExtra("fast", fast);
                        startActivity(intent);
                    }
                }
        );
        iter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.perceptron.Iteration");
                        String fast = getIntent().getStringExtra("fast");

                        intent.putExtra("fast", fast);
                        startActivity(intent);
                    }
                }
        );
    }
}
