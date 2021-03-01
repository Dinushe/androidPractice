package com.mad2020reg.tasty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mad2020reg.tasty.Database.DBHelper;

import java.util.List;

public class GuestRegister extends AppCompatActivity {
    DBHelper dbHelper;
    String GId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_register);
        dbHelper = new DBHelper(this);
        try{
            List guests= dbHelper.getGuests();
            String[] guest = (String[])guests.get(0);
            GId = guest[2];


            if(Integer.parseInt(GId.substring(1,GId.length()))+1<10){
                GId = "G00" + (Integer.parseInt(GId.substring(1,GId.length()))+1);
            }else if(Integer.parseInt(GId.substring(1,GId.length()))+1<100){
                GId = "G0" + (Integer.parseInt(GId.substring(1,GId.length()))+1);
            }else {
                GId = "G" + (Integer.parseInt(GId.substring(1,GId.length()))+1);
            }

        }catch (Exception e){
            GId = "G001";

        }
    }

    public void insertGuest(View view){


        /****Question 05 ****/

    }
}