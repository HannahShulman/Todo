package com.special.todo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo")
    List<Todo> getAll();

    @Insert(onConflict = REPLACE)
    void insertAll(List<Todo> todo);

    @Query("SELECT * FROM Todo WHERE id = :todoId")
    Todo getTodoById(int todoId);

    @Delete
    void delete(Todo todo);
}