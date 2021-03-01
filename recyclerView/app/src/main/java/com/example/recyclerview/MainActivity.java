package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        btnadd = findViewById(R.id.btnAdd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Dinushe","Jayasekera","plane"));
                myAdapter.notifyDataSetChanged();
            }
        });

        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL,false);
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("Jhon","Rambo","plane"));
        people.add(new Person("Manil","Harris","bus"));
        people.add(new Person("Kamal","Apron","plane"));
        people.add(new Person("Madala","Denne","bus"));
        people.add(new Person("Udara","Ranbanda","plane"));
        people.add(new Person("Jhon","Rambo","plane"));
        people.add(new Person("Manil","Harris","bus"));
        people.add(new Person("Kamal","Apron","plane"));
        people.add(new Person("Madala","Denne","bus"));
        people.add(new Person("Udara","Ranbanda","plane"));
        people.add(new Person("Jhon","Rambo","plane"));
        people.add(new Person("Manil","Harris","bus"));
        people.add(new Person("Kamal","Apron","plane"));
        people.add(new Person("Madala","Denne","bus"));
        people.add(new Person("Udara","Ranbanda","plane"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: "+people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}