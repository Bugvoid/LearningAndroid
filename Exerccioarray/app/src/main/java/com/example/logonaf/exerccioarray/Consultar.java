package com.example.logonaf.exerccioarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Consultar extends AppCompatActivity {

    private Global base = new Global();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
    }

    public void consultarDados(View v){
        Aluno a = base.consultar(((EditText)findViewById(R.id.RGM)).getText().toString());
        if (a != null){
            ((EditText)findViewById(R.id.Nome)).setText(a.getNome());
            ((EditText)findViewById(R.id.NotaParcial)).setText(a.getNota_parcial()+"");
            ((EditText)findViewById(R.id.Trabalhos)).setText(a.getNota_trabs()+"");
            ((EditText)findViewById(R.id.NotaPri)).setText(a.getNota_reg()+"");
        }else{
            Toast.makeText(getApplicationContext(), "Rgm inválido", Toast.LENGTH_LONG).show();
        }
    }
}
