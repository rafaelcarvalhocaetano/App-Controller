package io.mda.cash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

/**
 * Created by rafael on 05/01/18.
 */

public class CadastroActivity extends AppCompatActivity {

    private AppCompatEditText nome;
    private AppCompatEditText email;
    private AppCompatEditText senha;
    private AppCompatButton btn_salvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (AppCompatEditText) findViewById(R.id.nome);
        email = (AppCompatEditText) findViewById(R.id.email);
        senha = (AppCompatEditText) findViewById(R.id.senha);

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });


    }
}
