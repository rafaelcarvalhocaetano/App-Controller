package poolblue.com.br.poolblue;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DBHelp db;
    private EditText nome, endereco, empresa, sexo, cargo;
    private Button btnEnviar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.tNome);
        endereco = (EditText) findViewById(R.id.tEndereco);
        empresa = (EditText) findViewById(R.id.tEmpresa);
        sexo = (EditText) findViewById(R.id.tSexo);
        cargo = (EditText) findViewById(R.id.tCargo);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnListar = (Button) findViewById(R.id.btn2);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nome.getText().length()> 0
                        && endereco.getText().length()>0
                        && empresa.getText().length()>0
                        && sexo.getText().length()>0
                        && cargo.getText().length()>0){

                    db.insert(
                            nome.getText().toString(),
                            endereco.getText().toString(),
                            empresa.getText().toString(),
                            sexo.getText().toString(),
                            cargo.getText().toString()
                    );
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("SUCESSO ...");
                    adb.setMessage("SALVO COM SUCESSO ... ");
                    adb.show();

                    nome.setText("");
                    endereco.setText("");
                    empresa.setText("");
                    sexo.setText("");
                    cargo.setText("");

                }else{
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("ERROS ...");
                    adb.setMessage("CAMPOS SÃO NECESSÁRIOS ... ");
                    adb.show();
                }
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Contato> contatos = db.getAll();
                if(contatos == null){
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("INFO");
                    adb.setMessage("SEM REGISTROS");
                    adb.show();
                    return;
                }
                for (Contato c : contatos){
                    int i = 0;
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("LISTA DE CONTATOS "+i);
                    adb.setMessage("NOME :"+c.getNome()+"\nENDEREÇO : "+c.getEndereco()+"\nEMPRESA : "+c.getEmpresa()+"\nSEXO : "+c.getSexo()+"\nCARGO : "+c.getCargo());
                    i++;
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface d, int i) {
                            d.dismiss();
                        }
                    });
                    adb.show();
                }
            }
        });
    }
}
