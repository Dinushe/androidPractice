package com.mad2020reg.tasty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mad2020reg.tasty.Database.DBHelper;

public class TakeAway extends AppCompatActivity {
    Double[] Values = {0.0,1200.00, 1500.00,1000.00,1300.00,800.00,1200.00,2200.00, 2500.00};

    EditText edtTotal,edtGid;
    Spinner spnItem;

    Double total = 0.00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);


        /****Question 08 (a) & (b)  ****/

    }

    public void homeTakeaway(View view){

        /****Question 08 (d)  ****/
    }

    public void tableBook(View view){

        /****Question 08 (c)  ****/
    }

    public void submitTakeaway(View view){

      // save takeaway details (connected with Question 08 (a)

    }


}