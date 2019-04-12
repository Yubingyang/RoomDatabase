package com.example.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TaskDao
{
    @Query("SELECT *FROM task")
    List<Task> getAll();

    @Insert
    public void insert(Task task);
    @Delete
    public void delete(Task task);
    @Update
    public void update(Task task);

}
