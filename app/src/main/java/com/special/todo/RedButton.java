package com.special.todo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;

public class RedButton extends androidx.appcompat.widget.AppCompatButton {
    public RedButton(Context context) {
        super(context);
        init();
    }

    public RedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
       setBackgroundColor(Color.RED);
    }

    public void moveToCompletedTasks(){
        Intent intent = new Intent(getContext(), Main2Activity.class);
        getContext().startActivity(intent);
    }
}
