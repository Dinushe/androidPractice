package com.example.customlistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final ArrayList<Product> values;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> list) {
        super(context, R.layout.raw_res, list);
        this.context = context;
        this.values = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.raw_res, parent, false);

        TextView product = (TextView) rowView.findViewById(R.id.txtProduct);
        TextView price = (TextView) rowView.findViewById(R.id.txtPrice);
        TextView desc = (TextView) rowView.findViewById(R.id.txtDescription);

        ImageView imgPrd = (ImageView) rowView.findViewById(R.id.imgProduct);
        ImageView imgSale = (ImageView) rowView.findViewById(R.id.imgSale);

        product.setText(values.get(position).getTitle());
        price.setText("R" + values.get(position).getPrice());
        desc.setText(values.get(position).getDescription());

        if(values.get(position).getSale()){
            imgSale.setImageResource(R.mipmap.ic_launcher_round);
        }else{
            imgSale.setImageResource(R.mipmap.ex);
        }

        if (values.get(position).getType().equals("Lap")){
            imgPrd.setImageResource(R.mipmap.ex_foreground);
        }else {
            imgPrd.setImageResource(R.mipmap.ex_round);
        }

        return rowView;
    }
}
