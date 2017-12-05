package birddb.com.br.birddb;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by rafaelcarvalho on 05/12/2017.
 */

public class Mensagem {

    private Context c;

    public Mensagem(Context context){
        this.c = context;
    }
    //Método de mensagem
    public void show(String titulo, String texto){
        AlertDialog.Builder adb = new AlertDialog.Builder();
        adb.setTitle(titulo);
        adb.setMessage(texto);
        adb.setNeutralButton("OK", null);
        adb.show();

    }
}
