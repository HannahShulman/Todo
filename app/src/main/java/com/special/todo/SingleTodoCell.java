package com.special.todo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SingleTodoCell extends ConstraintLayout {
    TextView todoTitle;
    View statusIndicator;

    public SingleTodoCell(Context context) {
        super(context);
        init();
    }

    public SingleTodoCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SingleTodoCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.single_todo_cell, this, true);
        todoTitle = findViewById(R.id.todo_title);
        statusIndicator = findViewById(R.id.status_indicator);

       setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)findViewById(R.id.todo_title)).setText("clicked");
            }
        });
    }

    public void setTodoInfo(Todo todo){
        todoTitle.setText(todo.getTitle());
        if(todo.getStatus() == null) return;
        int color = 0;
        switch (todo.getStatus()){
            case TODO:
                color = Color.RED;
                break;
            case IN_PROGRESS:
                color = Color.YELLOW;
                break;

            case COMPLETED:
                color = Color.GREEN;
                break;
        }
        statusIndicator.setBackgroundColor(color);
    }
}
