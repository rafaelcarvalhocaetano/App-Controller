package io.mda.cash;

import android.content.Intent;
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

    //private AppCompatButton btn_logar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


    }
    /*

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
    */
}
