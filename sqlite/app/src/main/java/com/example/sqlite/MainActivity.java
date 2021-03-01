package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText name,cell,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.txtName);
        cell = (EditText) findViewById(R.id.txtCell);
        id = (EditText) findViewById(R.id.txtID);
    }

    public void btnSubmit(View v){

        String tname = name.getText().toString().trim();
        String tcell = cell.getText().toString().trim();

        DatabaseContact dc = new DatabaseContact(this);

        dc.open();
        dc.createEntry(tname,tcell);
        dc.close();

        Toast.makeText(this, "Successfully saved to database!!!", Toast.LENGTH_SHORT).show();
        name.setText("");
        cell.setText("");

        //must use the below part for exam
/*
        try{

            DatabaseContact dc = new DatabaseContact(this);

            dc.open();
            dc.createEntry(tname,tcell);
            dc.close();

            Toast.makeText(this, "Successfully saved to database!!!", Toast.LENGTH_SHORT).show();
            name.setText("");
            cell.setText("");
        }
        catch(SQLException e)
        {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
*/
    }

    public void btnEdit(View v){

        DatabaseContact db = new DatabaseContact(this);
        db.open();
        db.updateEntry(id.getText().toString().trim(),name.getText().toString().trim(),cell.getText().toString().trim());
        db.close();
        Toast.makeText(this, "Successfully updated!!!", Toast.LENGTH_SHORT).show();
    }
    public void btnShow(View v){

        startActivity(new Intent(this,data.class));

    }
    public void btnDelete(View v){

        DatabaseContact db = new DatabaseContact(this);
        db.open();
        db.deleteEntry(id.getText().toString().trim());
        db.close();

        Toast.makeText(this, "Successfully deleted!!!", Toast.LENGTH_SHORT).show();

    }
}