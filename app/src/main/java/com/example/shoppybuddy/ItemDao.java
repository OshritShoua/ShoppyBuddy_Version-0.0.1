package com.example.shoppybuddy;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;

import java.util.List;

@Dao
public interface ItemDao
{
    @Query("SELECT * FROM item")
    List<Item> getAll();

    @Query("SELECT * FROM item WHERE `cart id` = :id")
    List<Item> getItemsByCartId(int id);

    @Insert
    void insertAll(Item... items);

    @Delete
    void delete(Item item);
}

