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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by rafael on 07/01/18.
 */

public class CalculadoraActivity extends AppCompatActivity {

    private ImageView btn;
    private Boolean flag=true;
    private int dia = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        btn = (ImageView) findViewById(R.id.btn);

        final MaterialCalendarView m = (MaterialCalendarView) findViewById(R.id.calendarView);

        



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(flag){
                    btn.setBackgroundColor(R.drawable.fundo_botao);
                    btn.setBackgroundResource(R.drawable.ic_calendario);
                    m.setVisibility(View.VISIBLE);
                    Toast.makeText(CalculadoraActivity.this, dia+"", Toast.LENGTH_SHORT).show();
                    dia ++;
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
