package com.example.logonaf.exerccioarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListarTodos extends AppCompatActivity {

    private Global base = new Global();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_todos);
        listarTodos();
    }

    public void listarTodos(){
        List<Aluno> lista = new ArrayList<Aluno>();
        String saida="Alunos cadastrados \n";
        TextView textView = (TextView) findViewById(R.id.txtMostra);
        lista = base.tudo();

        for (int i=0;i < lista.size();i++){
            saida +=(lista.get(i)).getRgm()      + " - " +
                    (lista.get(i)).getNome()     + "  "  +
                    (lista.get(i)).getNota_parcial()+ ", "  +
                    (lista.get(i)).getNota_trabs()   + ", "  +
                    (lista.get(i)).getNota_reg()    + " \n\n ";
        }
        textView.setText(saida);
    }
}
