package com.example.ndpsh.ejercicio_03.Activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.ndpsh.ejercicio_03.Activities.Activities.MainActivity;
import com.example.ndpsh.ejercicio_03.Activities.models.Fruits;
import com.example.ndpsh.ejercicio_03.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *  Created by Naim on 31/10/18
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // Constructor
    private List<Fruits> fruits;
    private int layout;
    private Activity activity;
    private OnItemClickListener itemClickListener;



    public MyAdapter(List<Fruits> fruits, int layout, Activity activity, OnItemClickListener listener) {
        this.fruits = fruits;
        this.layout = layout;
        this.activity = activity;
        this.itemClickListener = listener;
    }



    @Override
    public MyAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View v= LayoutInflater.from(activity).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.bind(fruits.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        public TextView textName;
        public TextView textSpecs;
        public TextView textQuantity;
        public ImageView imgFruit;


        public ViewHolder (View v) {
            super(v);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textSpecs = (TextView) itemView.findViewById(R.id.textSpecs);
            textQuantity = (TextView) itemView.findViewById(R.id.textQuantity);
            imgFruit = (ImageView) itemView.findViewById(R.id.imgFruit);
            itemView.setOnCreateContextMenuListener(this);
        }

        public void bind(final Fruits fruit, final OnItemClickListener listener) {
            this.textName.setText(fruit.getName());
            this.textSpecs.setText(fruit.getSpecs());
            this.textQuantity.setText(fruit.getQuantity() + "");
            // Lógica aplicada para la limitación de la cantidad en cada elemento fruta
            if (fruit.getQuantity() == Fruits.LIMIT_QUANTITY) {
                textQuantity.setTextColor(ContextCompat.getColor(null, R.color.colorPrimaryDark));
                textQuantity.setTypeface(null, Typeface.BOLD);
            } else {
                textQuantity.setTextColor(ContextCompat.getColor(null, R.color.colorAccent));
                textQuantity.setTypeface(null, Typeface.NORMAL);
            }
            // Cargamos la imagen con Picasso
            Picasso.get().load(fruit.getImgback()).fit().into(this.imgFruit);
            // Añadimos el listener click para cada elemento fruta
            this.imgFruit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(fruit, getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return false;
        }


        public interface OnItemClickListener{
        void onItemClick(Fruits fruit, int position);
    }
}
