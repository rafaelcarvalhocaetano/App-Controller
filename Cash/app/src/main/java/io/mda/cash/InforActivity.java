package io.mda.cash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;


/**
 * Created by rafael on 06/01/18.
 */

public class InforActivity extends AppCompatActivity {

    private AppCompatButton btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        btn = (AppCompatButton) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaterialCalendarView cal = (MaterialCalendarView) findViewById(R.id.calendario);
                cal.setVisibility(View.VISIBLE);
                



            }
        });


    }
}
