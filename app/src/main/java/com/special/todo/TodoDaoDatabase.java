package com.special.todo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class, User.class}, version = 2, exportSchema = false)
public abstract class TodoDaoDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
}