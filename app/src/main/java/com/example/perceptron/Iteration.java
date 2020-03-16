package com.example.perceptron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Iteration extends AppCompatActivity {
    private Button res;
    public double iter = 0;
    public double time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteration);
        addListenerOnButton();
    }

    private void addListenerOnButton() {

        res = (Button) findViewById(R.id.butRes2);
        res.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.perceptron.Result");
                        intent.putExtra("iter", Double.toString(iter));
                        String fast = getIntent().getStringExtra("fast");
                        intent.putExtra("fast", fast);

                        intent.putExtra("time", Double.toString(time));
                        startActivity(intent);
                    }
                }
        );

    }

    public void onCheckboxClicked(View view) {
        CheckBox timeBox = (CheckBox) view;
        boolean checked = timeBox.isChecked();

        switch (view.getId()) {
            case R.id.i100:
                if (checked) {
                    iter = 100;
                }
                break;
            case R.id.i200:
                if (checked) {
                    iter = 200;
                }
                break;
            case R.id.i500:
                if (checked) {
                    iter = 500;
                }
                break;
            case R.id.i1000:
                if (checked) {
                    iter = 1000;
                }
                break;
        }
    }
}
