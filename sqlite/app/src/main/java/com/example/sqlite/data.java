package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class data extends AppCompatActivity {

    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        data = (TextView) findViewById(R.id.txtData);

        DatabaseContact db = new DatabaseContact(this);
        db.open();
        data.setText(db.getData());
        db.close();
    }
}