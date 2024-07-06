package com.example.groceryapp;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListner{

    ImageView imageView;
    List<Item> itemList;
    private android.util.Log Log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        if (recyclerView == null) {
            Log.e("MainActivity", "RecyclerView is null");
            return; // Exit early if the RecyclerView is not found
        }

        imageView = findViewById(R.id.imageView);
        if (imageView == null) {
            Log.e("MainActivity", "ImageView is null");
            return; // Exit early if the ImageView is not found
        }
        
        itemList = new ArrayList<>();

        Item item1 = new Item("Fruits", "Fresh Fruits", R.drawable.fruit);
        Item item2 = new Item("Vegetables", "Tomato, Potato", R.drawable.vegitables);
        Item item3 = new Item("Bakery", "Bread, Pastry", R.drawable.bread);
        Item item4 = new Item("Beverage", "Coffee, Tea", R.drawable.beverage);
        Item item5 = new Item("Milk", "Yogurt, Dairy", R.drawable.milk);
        Item item6 = new Item("Snacks", "Popcorn, Drinks", R.drawable.popcorn);

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyCustomAdapter adapter = new MyCustomAdapter(itemList);
        recyclerView.setAdapter(adapter);

        adapter.setClickListner(this);

    }

    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(this,
                "You chose: "+itemList.get(pos).getTitle(),
                Toast.LENGTH_SHORT).show();
    }
}