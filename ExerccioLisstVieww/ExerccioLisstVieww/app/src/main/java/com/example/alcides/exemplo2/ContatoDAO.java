package com.example.alcides.exemplo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private Context ctx;

    public ContatoDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(Contato aluno) {
        SQLiteDatabase db = new HelperDB(ctx).getWritableDatabase(); //conecta e abre o banco para gravação
        //insere alunos no ContentValues
        ContentValues values = new ContentValues();

        values.put("nome",aluno.getNome());
        values.put("celular", aluno.getCelular());
        values.put("email", aluno.getEmail());
        //insert retorna o ID da linha inserido ou -1 para erro
        //se der erro retorna FALSE senão TRUE
        return (db.insert(HelperDB.TABELA, null, values) > 0);
    }

    public boolean delete(String rgm) {
        SQLiteDatabase db = new HelperDB(ctx).getWritableDatabase(); //conecta e abre o banco para gravação
        String[] whereArgs = new String[]{rgm};
        //delete retorna o num de linhas deletadas ou 0 para nenhuma
        //se der erro retorna FALSE senão TRUE
        return (db.delete(HelperDB.TABELA, "nome=?", whereArgs) > 0);
    }

    public boolean update(Contato aluno) {
        SQLiteDatabase db = new HelperDB(ctx).getWritableDatabase(); //conecta e abre o banco para gravação
        ContentValues values = new ContentValues();

        values.put("nome",aluno.getNome());
        values.put("celular", aluno.getCelular());
        values.put("email", aluno.getEmail());
        String[] whereArgs = new String[]{aluno.getNome()};
        return (db.update(HelperDB.TABELA,values , "nome=?" ,whereArgs) > 0);
    }

    public Contato select(String rgm) {
        SQLiteDatabase db = new HelperDB(ctx).getReadableDatabase(); //conecta e abre o banco para leitura
        String[] selectionArgs = new String[]{rgm};
        Contato aluno=new Contato();
        Cursor cursor = db.query(HelperDB.TABELA, null, "nome= ?", selectionArgs, null, null, null);
        if (cursor.getCount()>0)
        {
            cursor.moveToNext();
            aluno.setNome(rgm);
            //exemplos com os índices dos campos
            aluno.setCelular(cursor.getString(1));
            aluno.setEmail(cursor.getString(2));
            return aluno;
        }
        return null;
    }

    public List<Contato> listarAlunos() {
        SQLiteDatabase db = new HelperDB(ctx).getReadableDatabase(); //conecta e abre o banco para leitura
        List<Contato> lista = new ArrayList<Contato>();

        Cursor cursor = db.query(HelperDB.TABELA, null, null, null, null, null, "nome");
        while (cursor.moveToNext()) {
            Contato aluno = new Contato();
            //exemplos capturando o indice dos campos a partir do nome
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setCelular(cursor.getString(cursor.getColumnIndex("celular")));
            aluno.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            //adiciona o aluno na lista
            lista.add(aluno);
        }
        return lista;
    }

    public String listarTodos() {
        String todos = "";
        SQLiteDatabase db = new HelperDB(ctx).getReadableDatabase(); //conecta e abre o banco para leitura
        Cursor cursor = db.query(HelperDB.TABELA, null, null, null, null, null, "nome");
        while (cursor.moveToNext()) {
            todos += cursor.getString(cursor.getColumnIndex("nome")) + ", " +
                     cursor.getString(cursor.getColumnIndex("celular")) + ", " +
                     cursor.getString(cursor.getColumnIndex("email")) + "\n";
        }
        return todos;
    }

}
