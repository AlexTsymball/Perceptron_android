package com.example.perceptron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button deadline;
    public double fastLearning = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        deadline = (Button) findViewById(R.id.butDead);
        deadline.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.perceptron.Deadline");
                        intent.putExtra("fast", Double.toString(fastLearning));
                        startActivity(intent);
                    }
                }
        );
    }

    public void onCheckboxClicked(View view) {
        CheckBox fast = (CheckBox) view;
        boolean checked = fast.isChecked();

        switch (view.getId()) {
            case R.id.sh0_001:
                if (checked) {
                    fastLearning = 0.001;
                }
                break;
            case R.id.sh0_01:
                if (checked) {
                    fastLearning = 0.01;
                }
                break;
            case R.id.sh0_05:
                if (checked) {
                    fastLearning = 0.05;
                }
                break;
            case R.id.sh0_1:
                if (checked) {
                    fastLearning = 0.1;
                }
                break;

            case R.id.sh0_2:
                if (checked) {
                    fastLearning = 0.2;
                }
                break;
            case R.id.sh0_3:
                if (checked) {
                    fastLearning = 0.3;
                }
                break;

        }
    }


}
