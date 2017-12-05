package poolblue.com.br.poolblue;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rafaelcarvalho on 04/12/2017.
 */

public class DBHelp {

    private static final String DATABASE = "banco.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "contato";

    private Context context;

    private SQLiteDatabase db;
    private SQLiteStatement ss;

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (nome, endereco, empresa, sexo, cargo) VALUES (?, ?, ?, ?, ?)";

    public DBHelp(Context context) {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.ss = this.db.compileStatement(INSERT);

    }

    public long insert(String nome, String endereco, String empresa, String sexo, String cargo) {
        this.ss.bindString(1, nome);
        this.ss.bindString(2, endereco);
        this.ss.bindString(3, empresa);
        this.ss.bindString(4, sexo);
        this.ss.bindString(5, cargo);
        return this.ss.executeInsert();
    }

    public void delete() {
        this.db.delete(TABLE_NAME, null, null);
    }

    public List<Contato> getAll() {

        ArrayList<Contato> itens = new ArrayList<>();
        try {
            Cursor c = this.db.query(TABLE_NAME, new String[]{"nome", "Endereço", "Empresa", "Sexo", "Cargo"},
                    null, null, null, null, null, null);
            int nreg = c.getCount();
            if (nreg != 0) {
                c.moveToFirst();
                do {
                    Contato contato = new Contato(
                            c.getString(0),
                            c.getString(1),
                            c.getString(2),
                            c.getString(3),
                            c.getString(4)
                    );
                    itens.add(contato);

                } while (c.moveToNext());
                if (c != null && !c.isClosed())
                    c.close();
                    return itens;
            } else
                return null;

        } catch (SQLException e) {
            return null;
        }
    }

    private static class OpenHelper extends SQLiteOpenHelper {


        public OpenHelper(Context context) {
            super(context, DATABASE, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT," +
                    "endereco TEXT, empresa TEXT, sexo TEXT, cargo TEXT)";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int antigaV, int novaV) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}

