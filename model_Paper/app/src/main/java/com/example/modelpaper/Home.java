package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button login,register;
    EditText user,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
        user = findViewById(R.id.txtUser);
        pw = findViewById(R.id.txtPwd);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,com.example.modelpaper.ProfileManagement.class);
                startActivity(intent);
            }
        });
    }

    public void btnSubmit (View v){
        String name = user.getText().toString().trim();
        String pwd = pw.getText().toString().trim();

        try {

            DBHandler db = new DBHandler(this);

            db.open();
            db.addInfo(name, pwd);
            db.close();

            Toast.makeText(this, "Successfully saved to database!!!", Toast.LENGTH_SHORT).show();
            user.setText("");
            pw.setText("");
        }catch (SQLException m){
            Toast.makeText(this, m.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}