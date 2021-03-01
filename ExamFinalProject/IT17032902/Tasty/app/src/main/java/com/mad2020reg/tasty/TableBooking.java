package com.mad2020reg.tasty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mad2020reg.tasty.Database.DBHelper;

public class TableBooking extends AppCompatActivity {
    EditText edtId, edtBooking, edtSCharge, edtTotal;


    String[][] Meal = {{"Submarine","Vegan Wrap", "Cheesy Toast", "Soy Iced Cofee"},
            {"Chicken Fried Rice","Nasi Gourang", "Mutton Palandey", "Hot butter Cuttle Fish"},
            {"Cheesy Delight","Happy Rice","Spider Man Cheesy Delight"},
            {"Sushi","Unagi","Sashimi","Tempura"},{"All"}};
    Double[][] prices = {{400.00,450.00,200.00,250.00},{500.00,500.00,650.00,350.00},{450.00,400.00,350.00},{1000.00,1200.00,1250.00,1500.00},{1200.00}};
    public int position_i,position_j;
    Double serviceCharge = 300.00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_booking);
        Intent intent = getIntent();

        edtId = findViewById(R.id.edtID);
        edtBooking = findViewById(R.id.edtBooking);
        edtSCharge = findViewById(R.id.edtSCharge);
        edtTotal = findViewById(R.id.edtTotal);

        /****Question 07 (a)  ****/



        /****Question 07 (b)  ****/



        /****Question 07 (d)  ****/



    }
    public static double calculateTotal(double tblFee, double serviceFee){

        /****Question 07 (c)  ****/

    }

    public void home(View view){

        // Opens MainMenu Activity
    }

    public void submit(View view){

        /****Question 07 (e)  ****/

    }
}