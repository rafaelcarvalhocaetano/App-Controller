package io.mda.cash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
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

    private TextInputLayout textNome;
    private TextInputLayout textEmail;
    private TextInputLayout textSenha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (AppCompatEditText) findViewById(R.id.nome);
        email = (AppCompatEditText) findViewById(R.id.email);
        senha = (AppCompatEditText) findViewById(R.id.senha);

        textNome = (TextInputLayout) findViewById(R.id.text_nome);
        textEmail = (TextInputLayout) findViewById(R.id.text_email);
        textSenha = (TextInputLayout) findViewById(R.id.text_senha);

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void validationForm(){
        if(nome.getText().toString().isEmpty() ){
            textNome.setErrorEnabled( true );
            textNome.setError("Preencha o campo nome");
        }else{
            textNome.setErrorEnabled( false );
        }
        if(email.getText().toString().isEmpty() ){
            textEmail.setErrorEnabled( true );
            textEmail.setError("Preencha o campo email");
        }else{
            textEmail.setErrorEnabled( false );
        }
        if(senha.getText().toString().isEmpty() ){
            textSenha.setErrorEnabled( true );
            textSenha.setError("Preencha o campo senha");
        }else{
            textSenha.setErrorEnabled( false );
        }
    }
}
