package com.special.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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


    public ArrayList<Todo> getList(){
        ArrayList<Todo> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new Todo("title "+i, "description "+i, Status.TODO));
        }
        return list;
    }

    public void showTodo(Todo todo){
        Toast.makeText(this, todo.getDescription(), Toast.LENGTH_SHORT).show();

        TodoFragment fragment = (TodoFragment)getSupportFragmentManager().findFragmentByTag("todo");
        if(fragment == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new TodoFragment(), "todo")
                    .addToBackStack("fragment").commit();
        } else{
            fragment.updateInformation(todo);
        }
    }
}
