package com.mad2020reg.tasty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mad2020reg.tasty.Database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
    }

    public void openRegister(View view){
        Intent intent = new Intent(this, GuestRegister.class);
        startActivity(intent);
    }

    public void login(View view){


        /****Question 04 ****/

        }


    }
}