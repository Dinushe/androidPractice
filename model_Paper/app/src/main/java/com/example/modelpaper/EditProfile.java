package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    Button srch;
    EditText name,pw,dob;
    RadioButton gMal,gFe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        srch = findViewById(R.id.btnSrch);
        name = findViewById(R.id.txtName);
        pw = findViewById(R.id.txtPwrd);
        dob = findViewById(R.id.txtDate);
        gMal = findViewById(R.id.rdMale);
        gFe = findViewById(R.id.rdFemale);

    }

    public void btnSrch (View v){

        try {

            DBHandler db = new DBHandler(this);

            db.open();
            db.readAllInfor("1");

            db.close();

            Toast.makeText(this, "Successfully saved to database!!!", Toast.LENGTH_SHORT).show();

        }catch (SQLException m){
            Toast.makeText(this, m.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}