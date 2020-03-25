package com.special.todo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private ArrayList<Todo> list = new ArrayList<>();
    private Context context;

    public TodoAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Todo> getList() {
        return list;
    }

    public void setList(ArrayList<Todo> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_todo_cell_layout, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, final int position) {
        final Todo todo = list.get(position);
        holder.cell.setTodoInfo(todo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ShowTodo)context).showTodo(todo);
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
//        int color = 0;
//        switch (todo.getStatus()){
//            case TODO:
//                color = Color.RED;
//                break;
//            case IN_PROGRESS:
//                color = Color.YELLOW;
//                break;
//
//            case COMPLETED:
//                color = Color.GREEN;
//                break;
//        }
//        holder.statusIndicator.setBackgroundColor(color);
//        holder.todoTitle.setText(todo.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder{

        SingleTodoCell cell;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            cell = itemView.findViewById(R.id.cell);
        }
    }
}
