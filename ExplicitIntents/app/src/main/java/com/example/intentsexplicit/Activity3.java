package com.example.intentsexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        result = findViewById(R.id.textView3);

        String name = getIntent().getStringExtra("name");
        result.setText(name + ", Welcome to Activity 3!");
    }
}