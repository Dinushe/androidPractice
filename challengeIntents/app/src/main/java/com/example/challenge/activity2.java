package com.example.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class activity2 extends AppCompatActivity implements View.OnClickListener{

    EditText name,phone,web,loc;
    ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        name = findViewById(R.id.txtName);
        phone = findViewById(R.id.txtPhone);
        web = findViewById(R.id.txtWeb);
        loc = findViewById(R.id.txtLoc);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || web.getText().toString().isEmpty() || loc.getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill all the fields!!!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent();
            intent.putExtra("name",name.getText().toString().trim());
            intent.putExtra("phone",phone.getText().toString().trim());
            intent.putExtra("web",web.getText().toString().trim());
            intent.putExtra("loc",loc.getText().toString().trim());

            if(v.getId() == R.id.img1){
                intent.putExtra("mood","happy");
            }else if(v.getId() == R.id.img2){
                intent.putExtra("mood","fine");
            }else{
                intent.putExtra("mood","sad");
            }
            setResult(RESULT_OK,intent);
            activity2.this.finish();
        }
    }
}