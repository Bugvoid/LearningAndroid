package com.example.logonaf.exerccioarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Excluir extends AppCompatActivity {

    private Global base = new Global();
    private Aluno a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir);
    }

    public void consultarDados(View v){
        a = base.consultar(((EditText)findViewById(R.id.RGM)).getText().toString());
        if (a != null){
            ((EditText)findViewById(R.id.Nome)).setText(a.getNome());
            ((EditText)findViewById(R.id.NotaParcial)).setText(a.getNota_parcial()+"");
            ((EditText)findViewById(R.id.Trabalhos)).setText(a.getNota_trabs()+"");
            ((EditText)findViewById(R.id.NotaPri)).setText(a.getNota_reg()+"");
        }else{
            Toast.makeText(getApplicationContext(), "Rgm inválido", Toast.LENGTH_LONG).show();
        }
    }

    public void apagarDados(View v){
        if (a != null) {
            a.setNome(((EditText) findViewById(R.id.Nome)).getText().toString());
            a.setNota_parcial(Float.parseFloat(((EditText) findViewById(R.id.NotaParcial)).getText().toString()));
            a.setNota_trabs(Float.parseFloat(((EditText) findViewById(R.id.Trabalhos)).getText().toString()));
            a.setNota_reg(Float.parseFloat(((EditText) findViewById(R.id.NotaPri)).getText().toString()));
            if (base.Excluir(a)) {
                Toast.makeText(getApplicationContext(), "Registro apagado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "ERRO", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Pesquise primeiro o aluno", Toast.LENGTH_LONG).show();
        }
    }
}


