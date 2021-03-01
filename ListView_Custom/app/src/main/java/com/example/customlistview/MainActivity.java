package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Product> ProdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listProducts);

        ProdList = new ArrayList<Product>();

        Product product1 = new Product("Acer","supiri lapa ganna deyak neha","Lap",235.00,true);
        Product product2 = new Product("Honda","patta lapa ganna deyak neha","Lap",35.00,false);
        Product product3 = new Product("Gemba","iya ganna deyak neha","Red",25.00,true);
        Product product4 = new Product("Vehicle","wadak neha ganna deyak neha","Lap",55.00,true);
        Product product5 = new Product("Phone","badumathamai deyak neha","Lap",99.00,false);
        Product product6 = new Product("Ex","maru ganna deyak neha","Lomb",26.00,true);
        Product product7 = new Product("Knife","athal ganna deyak neha","Lap",56.00,true);
        Product product8 = new Product("Lambo","dote wanni ganna deyak neha","gas",875.00,false);
        Product product9 = new Product("Bulldog","supiri lapa ganna deyak neha","Lap",985.00,true);

        ProdList.add(product2);
        ProdList.add(product3);
        ProdList.add(product4);
        ProdList.add(product5);
        ProdList.add(product6);
        ProdList.add(product7);
        ProdList.add(product8);
        ProdList.add(product9);

        ProductAdapter adapter = new ProductAdapter(this,ProdList);

        list.setAdapter(adapter);

    }
}