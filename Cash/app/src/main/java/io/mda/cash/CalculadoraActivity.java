package io.mda.cash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * Created by rafael on 07/01/18.
 */

public class CalculadoraActivity extends AppCompatActivity {

    private ImageButton btn;
    private Boolean flag=true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        btn = (ImageButton) findViewById(R.id.btn);

        final MaterialCalendarView m = (MaterialCalendarView) findViewById(R.id.calendarView);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(flag){
                    btn.setBackgroundColor(R.drawable.fundo_botao);
                    btn.setBackgroundResource(R.drawable.ic_calendario);
                    m.setVisibility(View.VISIBLE);
                    flag = false;
                }else{
                    m.setVisibility(View.GONE);
                    btn.setBackgroundResource(R.drawable.ic_action_calendar_day);
                    flag = true;
                }

            }
        });


    }


}
