package com.example.falsecall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = findViewById(R.id.txtOut);

        if(getIntent().getData() != null){
            out.setText(getIntent().getData().toString());
        }else{
            out.setText("No data to be shown here");
        }
    }
}