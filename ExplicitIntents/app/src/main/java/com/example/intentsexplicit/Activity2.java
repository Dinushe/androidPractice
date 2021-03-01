package com.example.intentsexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    EditText inputName;
    Button submit,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        submit = findViewById(R.id.btnSubmit);
        inputName = findViewById(R.id.txtInputName);
        cancel = findViewById(R.id.btnCancel);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputName.getText().toString().isEmpty()){
                    Toast.makeText(Activity2.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }else{
                    String surname = inputName.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("surname",surname);
                    setResult(RESULT_OK,intent);
                    Activity2.this.finish();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity2.this.finish();
            }
        });
    }
}