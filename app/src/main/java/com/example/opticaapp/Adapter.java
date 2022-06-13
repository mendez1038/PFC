package com.example.opticaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private final Context context;
    private final int layout;
    private final ArrayList<String> names;

    public Adapter(Context context, int layout, ArrayList<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(R.layout.adapter,null);
        // Valor actual según la posición
        String currentName = names.get(position);
        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(currentName);
        //Devolvemos la vista inflada
        return convertView;
    }

}
