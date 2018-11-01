package com.example.ndpsh.ejercicio_03.Activities;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
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
    private OnItemClickListener itemClickListener;



    public MyAdapter(List<Fruits> fruits, int layout, OnItemClickListener listener) {
        this.fruits = fruits;
        this.layout = layout;
        this.itemClickListener = listener;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(fruits.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textName;
        public TextView textSpecs;
        public TextView textQuantity;
        public ImageView imgFruit;



        public ViewHolder(View v) {
            super(v);
            textName = itemView.findViewById(R.id.textName);
            textSpecs = itemView.findViewById(R.id.textSpecs);
            textQuantity = itemView.findViewById(R.id.textQuantity);
            imgFruit =  itemView.findViewById(R.id.imgFruit);



        }

        public void bind(final Fruits fruit, final OnItemClickListener listener) {
            this.textName.setText(fruit.getName());
            this.textSpecs.setText(fruit.getSpecs());
            this.textQuantity.setText(fruit.getQuantity() + "");
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
    }

    public interface OnItemClickListener {
        void onItemClick(Fruits fruit, int position);
    }
}

