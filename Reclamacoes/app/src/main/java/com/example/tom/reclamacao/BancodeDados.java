package com.example.tom.reclamacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by tecnico on 15/06/2015.
 */
public class BancodeDados extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_USUARIO = "CREATE TABLE USER (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NOME TEXT , SOBRENOME TEXT, CEP TEXT,ENDERECO TEXT ,COMPLEMENTO TEXT ,BAIRRO TEXT ,TELEFONE TEXT,SENHA TEXT ,USUARIO TEXT )";

    private static final String CREATE_RECLAMACAO = "CREATE TABLE RECLAMACAO(ID INTEGER PRIMARY KEY AUTOINCREMENT,RECLAMACAO TEXT,INFRA TEXT,DOCENTES TEXT)";

    BancodeDados(Context context) {
        super(context, "exempo_de_banco", null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USUARIO);
        db.execSQL(CREATE_RECLAMACAO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertUsuario(CadastroPessoas cadastro) throws Exception {
        SQLiteDatabase sqlLite = this.getWritableDatabase();
        ContentValues context = new ContentValues();

        context.put("ID", cadastro.getId());
        context.put("NOME", cadastro.getNome());
        context.put("SOBRENOME", cadastro.getEndereco());
        context.put("CEP", cadastro.getCep());
        context.put("ENDERECO", cadastro.getEndereco());
        context.put("COMPLEMENTO", cadastro.getComplemento());
        context.put("BAIRRO", cadastro.getBairro());
        context.put("TELEFONE", cadastro.getTelefone());
        context.put("USUARIO", cadastro.getUsuario());
        context.put("SENHA", cadastro.getSenha());

        return sqlLite.insert("USER", null, context);
    }

    public long insertReclamacao(Reclamacao reclamacao) throws Exception {
        SQLiteDatabase sqlLite = this.getWritableDatabase();
        ContentValues context = new ContentValues();


        context.put("ID", reclamacao.getId());
        context.put("RECLAMACAO", reclamacao.getReclamacao());
        context.put("INFRA", reclamacao.getInfra());
        context.put("DOCENTES", reclamacao.getDocente());

        return sqlLite.insert("RECLAMACAO", null, context);
    }


    public ArrayList<CadastroPessoas> getuser(String usuario) throws Exception {
        ArrayList<CadastroPessoas> cadastros = new ArrayList<CadastroPessoas>();

        Cursor cursor = null;
        SQLiteDatabase sqlLite = this.getReadableDatabase();
        String[] colunas = new String[]{"ID", "NOME", "SOBRENOME", "CEP", "ENDERECO", "COMPLEMENTO", "BAIRRO", "TELEFONE", "USUARIO", "SENHA"};
        String[] argumets = new String[]{usuario};
        cursor = sqlLite.query("USER", colunas, "USUARIO=?", argumets, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                CadastroPessoas u = new CadastroPessoas();

                u.setId(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                u.setSobrenome(cursor.getString(2));
                u.setCep(cursor.getString(3));
                u.setEndereco(cursor.getString(4));
                u.setComplemento(cursor.getString(5));
                u.setBairro(cursor.getString(6));
                u.setTelefone(cursor.getString(7));
                u.setUsuario(cursor.getString(8));
                u.setSenha(cursor.getString(9));
                cadastros.add(u);

            } while (cursor.moveToNext());
            cursor.close();

        }
        return cadastros;


    }

    public ArrayList<Reclamacao> getAllReclamacoes() throws Exception {
        ArrayList<Reclamacao> reclamacaos = new ArrayList<Reclamacao>();

        Cursor cursor = null;
        SQLiteDatabase sqlLite = this.getReadableDatabase();
        String[] colunas = new String[]{"ID", "RECLAMACAO", "INFRA", "DOCENTES"};
        cursor = sqlLite.query("RECLAMACAO", colunas, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Reclamacao p = new Reclamacao();

                p.setId(cursor.getInt(0));
                p.setReclamcao(cursor.getString(1));
                p.setInfra(cursor.getString(2));
                p.setDocente(cursor.getString(3));
                reclamacaos.add(p);

            } while (cursor.moveToNext());
            cursor.close();

        }
        return reclamacaos;


    }


    public int deletarReclamacao(Reclamacao ReclamacaoExcuir) {

        SQLiteDatabase sqlLite = this.getWritableDatabase();
        String where = "ID=?";
        String[] args = {ReclamacaoExcuir.getId().toString()};
        return sqlLite.delete("RECLAMACAO", where, args);


    }


}
