package com.example.sl_id_identifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtID;
    Button btnSbmt;
    TextView txt;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = findViewById(R.id.txtID);
        number = findViewById(R.id.txtNumber);
        btnSbmt = findViewById(R.id.btnSbmt);
        txt = findViewById(R.id.txt);
        txt.setVisibility(View.GONE);


        btnSbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nabs = Integer.parseInt(number.getText().toString().trim());
                String input = txtID.getText().toString().trim();
                String year = input.substring(0,2);
                int date = Integer.parseInt(input.substring(2,5));
                String province;
                String month;
                int dob;

                if(nabs == 1){
                    province = "Western";
                }else if(nabs == 2){
                    province = "Central";
                }else if(nabs == 3){
                    province = "Southern";
                }else if(nabs == 4){
                    province = "Northern";
                }else if(nabs == 5){
                    province = "Eastern";
                }else if(nabs == 6){
                    province = "North Western";
                }else if(nabs == 7){
                    province = "North Central";
                }else if(nabs == 8){
                    province = "Uva";
                }else if(nabs == 9){
                    province = getString(R.string.sabaragamuwa);
                }else{
                    province = "Not a valid NIC";
                }





                if(date >= 367) {
                    date = date - 500;
                }

                if(date <= 0 || date >= 367){
                    month = "not a valid NIC";
                    dob = date;
                }else {

                    if (date <= 31) {
                        month = "January";
                        dob = date;
                    } else if (date <= 60) {
                        month = "February";
                        dob = date - 31;
                    } else if (date <= 91) {
                        month = "March";
                        dob = date - 60;
                    } else if (date <= 121) {
                        month = "April";
                        dob = date - 91;
                    } else if (date <= 152) {
                        month = "May";
                        dob = date - 121;
                    } else if (date <= 182) {
                        month = "June";
                        dob = date - 152;
                    } else if (date <= 213) {
                        month = "July";
                        dob = date - 182;
                    } else if (date <= 244) {
                        month = "August";
                        dob = date - 213;
                    } else if (date <= 274) {
                        month = "September";
                        dob = date - 244;
                    } else if (date <= 305) {
                        month = "October";
                        dob = date - 274;
                    } else if (date <= 335) {
                        month = "November";
                        dob = date - 305;
                    } else {
                        month = "December";
                        dob = date - 335;
                    }
                }


                int gender = Integer.parseInt(Character.toString(input.charAt(2)));

                String sGender;

                if(gender < 5){
                    sGender = "Male";
                }else{
                    sGender="Female";
                }

                String vote = Character.toString(input.charAt(9));

                String votePower;

                if (vote.equals("v") || vote.equals("V")){
                    votePower = "Can vote and born citizen";
                }else{
                    votePower = "Can't vote and not a born citizen";
                }

                String text = getString(R.string.dob) + year +" / "+ month + " / "+ dob + "\n" +
                        getString(R.string.gender) + sGender + "\n" +
                        getString(R.string.citizenship) + votePower + "\n" +
                        "Province : " + province + " Province";

                txt.setText(text);
                txt.setVisibility(View.VISIBLE);
            }
        });
    }
}