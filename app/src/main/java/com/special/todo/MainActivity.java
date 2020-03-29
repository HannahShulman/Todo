package com.special.todo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShowTodo {
    TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //create and access db
        TodoDaoDatabase db = Room.databaseBuilder(getApplicationContext(),
                TodoDaoDatabase.class, "database-name")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        db.todoDao().insertAll(getList());


        RecyclerView rv = findViewById(R.id.todo_list);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new TodoAdapter(this);
        adapter.setList(db.todoDao().getAll());
        rv.setAdapter(adapter);

//        final RedButton redBtn = findViewById(R.id.redBtn);
//        redBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                redBtn.moveToCompletedTasks();
//            }
//        });
    }


    //generate information
    public ArrayList<Todo> getList(){
        ArrayList<Todo> list = new ArrayList<>();
        list.add(new Todo(0, "title "+0, "description "+0, Status.COMPLETED));
        for (int i = 1; i < 50; i++) {
            list.add(new Todo(i, "title "+i, "description "+i, Status.TODO));
        }
        return list;
    }

    @Override
    public void showTodo(Todo todo){
        TodoFragment fragment = (TodoFragment)getSupportFragmentManager().findFragmentByTag("todo");
        if(fragment == null){
            TodoFragment fragment1 = new TodoFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1, "todo")
                    .addToBackStack("fragment").commit();
        } else {
            fragment.updateInformation(todo);
        }
    }

    @Override
    public void updateStatus(int id, Status status) {
        Todo getTodo;
       List<Todo> list = adapter.getList();
        for (int i = 0; i < list.size(); i++) {
            if (adapter.getList().get(i).getId() == id){
                getTodo = adapter.getList().get(i);
                getTodo.setStatus(status);
                list.set(i, getTodo);
                adapter.setList(list);
                return;
            }
        }
        Toast.makeText(this, status.name(), Toast.LENGTH_SHORT).show();
    }
}
