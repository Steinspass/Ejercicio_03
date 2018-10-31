package com.example.ndpsh.ejercicio_03.Activities.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ndpsh.ejercicio_03.Activities.MyAdapter;
import com.example.ndpsh.ejercicio_03.Activities.models.Fruits;
import com.example.ndpsh.ejercicio_03.R;

import java.util.ArrayList;
import java.util.List;


/**
 *  Created by Naim on 31/10/18
 */

public class MainActivity extends AppCompatActivity {

    private List<Fruits> fruits;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruits = this.getAllFruits();

        // Estilo de layout que utilizar
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);


       mAdapter = new MyAdapter(fruits, R.layout.recyclerview, this, new MyAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(Fruits fruit, int position) {
                fruit.addQuantity(1);
                mAdapter.notifyItemChanged(position);
           }
       });


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_fruit:
                // Rescatamos el número de frutas para saber en que posición insertaremos
                int position = fruits.size();
                fruits.add(position, new Fruits("Plum " + (++counter), "Fruit added by the user", R.drawable.plum_bg, R.mipmap.ic_plum, 0));
                mAdapter.notifyItemInserted(position);
                mLayoutManager.scrollToPosition(position);
                return true;
            default:
                return super.onOptionsItemSelected(item);

    }

    //Lista de frutas
    private List<Fruits> getAllFruits() {
        return new ArrayList<Fruits>() {{
            add(new Fruits("Manzana", "Aragon", 0, R.drawable.apple_bg));
            add(new Fruits("Pera", "Zaragoza", 7, R.drawable.pear_bg));
            add(new Fruits("Platano", "Gran Canarias", 9, R.drawable.banana_bg));
            add(new Fruits("Cereza", "Leon", 6, R.drawable.cherry_bg));
            add(new Fruits("Arandanos", "Rioja", 3, R.drawable.raspberry_bg ));
            add(new Fruits("Naranja", "Almeria", 10, R.drawable.orange_bg));
            add(new Fruits("Fresa","Huelva", 2, R.drawable.strawberry_bg));
            add(new Fruits("Ciruela", "Murcia", 8, R.drawable.plum_bg));
        }};
    }

}
