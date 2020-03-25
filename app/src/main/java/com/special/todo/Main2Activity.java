package com.special.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements ShowTodo {

    TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.todo_list);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new TodoAdapter(this);
        adapter.setList(getList());
        rv.setAdapter(adapter);
    }

    //generate information
    public ArrayList<Todo> getList(){
        ArrayList<Todo> list = new ArrayList<>();
        list.add(new Todo("title "+0, "description "+0, Status.COMPLETED));
        for (int i = 1; i < 50; i++) {
            list.add(new Todo("title "+i, "description "+i, Status.TODO));
        }
        return list;
    }

    @Override
    public void showTodo(Todo todo){
        Toast.makeText(this, "jfvajgfv", Toast.LENGTH_SHORT).show();
    }
}
