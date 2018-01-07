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

    private Button btn;
    private Boolean flag=true;
    private int contador = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        btn = (Button) findViewById(R.id.btn);

        final MaterialCalendarView m = (MaterialCalendarView) findViewById(R.id.calendarView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(contador % 2 == 0){
                    m.setVisibility(View.VISIBLE);
                    contador ++;
               }else{
                   m.setVisibility(View.GONE);
                   contador ++;
               }

            }
        });


    }


}
