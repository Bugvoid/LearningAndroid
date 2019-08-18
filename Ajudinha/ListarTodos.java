package com.example.exercicioaula7bv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListarTodos extends AppCompatActivity {

    private ArrayListAlunos base = new ArrayListAlunos();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_todos);
        listarTodos();
    }

    public void listarTodos(){
        List<Aluno> lista = new ArrayList<Aluno>();
        String saida="Alunos cadastrados\n\n";
        lista = base.selectAll();
        for (int i=0;i < lista.size();i++){
            saida +=(lista.get(i)).getRgm()      + " - " +
                    (lista.get(i)).getNome()     + "  "  +
                    (lista.get(i)).getNota_parcial()+ ", "  +
                    (lista.get(i)).getNota_trabs()   + ", "  +
                    (lista.get(i)).getNota_reg()    + " \n\n ";
        }
        ((TextView)findViewById(R.id.todos)).setText(saida);
    }
}
