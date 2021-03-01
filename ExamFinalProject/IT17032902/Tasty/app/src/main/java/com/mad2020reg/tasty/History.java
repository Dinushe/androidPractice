package com.mad2020reg.tasty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mad2020reg.tasty.Database.DBHelper;

import java.util.List;

public class History extends AppCompatActivity {

    LinearLayout LLBookings, LLTakeaway;
    String gID;
    DBHelper dbHelper;
    private static final String TAG = "History";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        /****Question 09  ****/




    }
}