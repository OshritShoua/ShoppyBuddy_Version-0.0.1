package com.example.shoppybuddy;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CartListActivity extends AppCompatActivity
{

    private AppDataBase _db;
    private List<Cart> _carts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        init();
    }

    private void init()
    {
        _db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "userShoppings").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        _carts = _db.cartDao().getAll();
        ArrayAdapter<Cart> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, _carts);
        final ListView cartListView = findViewById(R.id._dynamic_cart_list);
        cartListView.setAdapter(adapter);
        cartListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Cart selectedCart = (Cart)adapterView.getItemAtPosition(position);
                Intent intent = new Intent(CartListActivity.this, CartReviewActivity.class);
                intent.putExtra("calling activity", getLocalClassName());
                intent.putExtra("cart id", selectedCart.getId());
                startActivity(intent);
            }
        });
    }
}