package com.example.challenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnnew;
    int act2 = 1;
    TextView main;
    ImageView imgFace,imgCall,imgWeb,imgLoc;
    String name = "", web = "", call = "", loc = "", mood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnew = findViewById(R.id.btnNew);
        main = findViewById(R.id.txtMainOut);
        imgFace = findViewById(R.id.imgFace);
        imgCall = findViewById(R.id.imgCall);
        imgWeb = findViewById(R.id.imgWeb);
        imgLoc = findViewById(R.id.imgLoc);


        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.challenge.activity2.class);
                startActivityForResult(intent, act2);
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+call));
                startActivity(intent);
            }
        });

        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);
            }
        });

        imgLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+loc));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == act2){
            if (resultCode == RESULT_OK){
                main.setText("Hello "+name+"!!!");
                imgFace.setVisibility(View.VISIBLE);
                imgCall.setVisibility(View.VISIBLE);
                imgWeb.setVisibility(View.VISIBLE);
                imgLoc.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                call = data.getStringExtra("phone");
                web = data.getStringExtra("web");
                loc = data.getStringExtra("loc");
                mood = data.getStringExtra("mood");

                main.setText("Hello "+name+"!!!");

                if(mood.equals("happy")){
                    imgFace.setImageResource(R.drawable.smile);
                }else if(mood.equals("fine")){
                    imgFace.setImageResource(R.drawable.fine);
                }else{
                    imgFace.setImageResource(R.drawable.sad);
                }

            }else{
                main.setText("No data parsed");
            }
        }
    }
}