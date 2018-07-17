package com.example.shoppybuddy;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CartDao
{
    @Query("SELECT * FROM cart")
    List<Cart> getAll();

    @Insert
    void insertAll(Cart... carts);

    @Insert
    long insert(Cart cart);

    @Delete
    void delete(Cart cart);
}

