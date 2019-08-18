package com.example.exercicioaula7bv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Alterar extends AppCompatActivity {

    private ArrayListAlunos base = new ArrayListAlunos();
    private Aluno a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
    }

    public  void consultarDados(View v){
        a = base.select(((EditText)findViewById(R.id.editRgm)).getText().toString());
        if (a != null){
            ((EditText)findViewById(R.id.editNome)).setText(a.getNome());
            ((EditText)findViewById(R.id.editParcial)).setText(a.getNota_parcial()+"");
            ((EditText)findViewById(R.id.editTrabalhos)).setText(a.getNota_trabs()+"");
            ((EditText)findViewById(R.id.editPri)).setText(a.getNota_reg()+"");
        }else{
            Toast.makeText(getApplicationContext(), "Rgm inválido", Toast.LENGTH_LONG).show();
        }
    }

    public  void alterarDados(View v){
        if (a != null) {
            a.setNome(((EditText) findViewById(R.id.editNome)).getText().toString());
            a.setNota_parcial(Float.parseFloat(((EditText) findViewById(R.id.editParcial)).getText().toString()));
            a.setNota_trabs(Float.parseFloat(((EditText) findViewById(R.id.editTrabalhos)).getText().toString()));
            a.setNota_reg(Float.parseFloat(((EditText) findViewById(R.id.editPri)).getText().toString()));
            if (base.update(a)) {
                Toast.makeText(getApplicationContext(), "Dados alterados", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "ERRO", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Pesquise primeiro o aluno", Toast.LENGTH_LONG).show();
        }
    }
}
