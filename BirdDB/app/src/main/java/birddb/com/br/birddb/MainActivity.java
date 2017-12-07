package birddb.com.br.birddb;


import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
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
    private Mensagem msn = new Mensagem(MainActivity.this);

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
        db = openOrCreateDatabase("alunoDB", Context.MODE_PRIVATE,  null);

        //Criando a tabela
        db.execSQL("CREATE TABLE IF NOT EXISTS aluno(nome varchar, ra varchar, curso varchar)");

    }

    //Verifica se os campos não tem nada, se tiver salva caso contrario não salva
    public boolean verificaCampo(){
        return (ra.trim().length() == 0 || nome.trim().length() == 0 || curso.trim().length() == 0);
    }

    @Override
    public void onClick(View view) {
        //implementar o CRUD do android com SQLite
        //Pegando os valores dos campos
        ra = eRa.getText().toString();
        nome = eNome.getText().toString();
        curso = eCurso.getText().toString();

        if(view == btnAdd){
            if(verificaCampo()){
                msn.show("Erro", "Verifique os campos");
                return;
            }
            //insert
            db.execSQL("INSERT INTO aluno VALUES(' "+ra+"',' "+nome+"','"+curso+"');");
            msn.show("SUCESSO", "Aluno Cadastrados");
            limparCampos();

        }
        if(view == btnListar){
            //list
            Cursor c = db.rawQuery("SELECT * FROM aluno", null);
            if(c.getCount() == 0){
                msn.show("AVISO", "Sem dados no banco SQLite");
                return;
            }
            StringBuffer s = new StringBuffer();
            while (c.moveToNext()){
                s.append("RA:"+c.getString(0)+"\n");
                s.append("NOME:"+c.getString(1)+"\n");
                s.append("CURSO:"+c.getString(2)+"\n\n");
            }
            //Exibir os registros
            msn.show("ALUNOS", s.toString());
        }
        if(view == btnInfo){
            msn.show("Info - Exemplo Android e SQLite", "By Rafael Carvalho Caetano");
        }
        if(view == btnPesquisar){
            if(ra.trim().length()==0){
                msn.show("Erro", "Informe o RA");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM aluno WHERE ra='"+ ra +"' ", null);
            if(c.moveToFirst()){
                eNome.setText(c.getString(1));
                eCurso.setText(c.getString(2));
            }else{
                msn.show("Erro","RA inválido ou não localizado!");
                return;
            }
        }
        if(view == btnAtualizar){
            //verificando se o ra é maior que zero
            if(ra.trim().length()==0){
                msn.show("Erro", "Informe o RA");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM aluno WHERE ra='"+ra+"'", null);
            if(c.moveToFirst()){
                db.execSQL("UPDATE aluno SET nome='"+nome+"', curso='"+curso+"' WHERE ra='"+ra+"';");
                msn.show("SUCESSO","Dados Atualizados com sucesso !");
            }else{
                msn.show("Erro","RA inválido ou não localizado!");
                return;
            }
            limparCampos();
        }
        if(view == btnExcluir){
            //verificando se o ra é maior que zero
            if(ra.trim().length()==0){
                msn.show("Erro", "Informe o RA");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM aluno WHERE ra='"+ra+"'", null);
            if(c.moveToFirst()){
                db.execSQL("DELETE FROM aluno WHERE ra='"+ra+"';");
                msn.show("SUCESSO", "Registro excluído com sucesso !");
            }else{
                msn.show("Erro", "RA não localizado");
                return;
            }
            limparCampos();
        }
    }
    //Limpa o campo dos EditText
    public void limparCampos(){
        eNome.setText("");
        eRa.setText("");
        eCurso.setText("");
        eRa.requestFocus();
    }
}
