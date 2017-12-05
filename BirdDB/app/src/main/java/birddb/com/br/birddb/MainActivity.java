package birddb.com.br.birddb;


import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

    Button btnAdd, btnExcluir, btnPesquisar, btnListar, btnInfo, btnAtualizar;
    EditText eNome, eRa, eCurso;
    private String nome, ra, curso;

    //Chamando o banco
    SQLiteDatabase db;
    //Instancia uma caixa de mensagem
    private Mensagem show = new Mensagem(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNome = (EditText) findViewById(R.id.nome);
        eRa = (EditText) findViewById(R.id.ra);
        eCurso = (EditText) findViewById(R.id.curso);

        btnAdd = (Button) findViewById(R.id.btnEnviar);
        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        btnPesquisar = (Button) findViewById(R.id.btnPesquisar);
        btnListar = (Button) findViewById(R.id.btnListar);
        btnAtualizar = (Button) findViewById(R.id.btnAlterar);
        btnInfo = (Button) findViewById(R.id.btnInfor);

        btnAdd.setOnClickListener(this);
        btnExcluir.setOnClickListener(this);
        btnPesquisar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
        btnAtualizar.setOnClickListener(this);
        btnInfo.setOnClickListener(this);

        //SQLITE
        db = openOrCreateDatabase("AlunoDB", Context.MODE_PRIVATE,  null);

        //Criando a tabela
        db.execSQL("CREATE TABLE IF NOT EXISTS aluno(nome varchar, ra varchar, curso varchar)");

    }

    //Verifica se os campos não tem nada, se tiver salva caso contrario não salva
    public boolean verificaCampo(){
        return (ra.trim().length() == 0 || nome.trim().length() == 0 || curso.trim().length() == 0)
    }

    @Override
    public void onClick(View view) {
        //implementar o CRUD do android com SQLite

    }
    //Limpa o campo dos EditText
    public void limparCampos(){
        eNome.setText("");
        eRa.setText("");
        eCurso.setText("");
        eRa.requestFocus();
    }
}
