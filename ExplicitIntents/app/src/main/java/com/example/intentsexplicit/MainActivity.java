package com.example.intentsexplicit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btnAct2,btnAct3;
    TextView txtResult;
    int ACTIVITY3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.txtName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        txtResult = findViewById(R.id.txtResult);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,com.example.intentsexplicit.Activity2.class);
                startActivityForResult(intent, ACTIVITY3);

            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(input.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!!!", Toast.LENGTH_SHORT).show();
                }else{
                    String name = input.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this, com.example.intentsexplicit.Activity3.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY3){
            if (resultCode == RESULT_OK){
                txtResult.setText(data.getStringExtra("surname"));
            }

            if(resultCode == RESULT_CANCELED){
                txtResult.setText("No data recieved!");
            }
        }
    }
}