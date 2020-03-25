package com.special.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ShowTodo {
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
        TodoFragment fragment = (TodoFragment)getSupportFragmentManager().findFragmentByTag("todo");
        if(fragment == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new TodoFragment(), "todo")
                    .addToBackStack("fragment").commit();
        } else{
            fragment.updateInformation(todo);
        }
    }
}
