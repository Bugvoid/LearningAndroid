package com.example.exercicioaula7bv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    private ArrayListAlunos base = new ArrayListAlunos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void salvarDados(View v){
        String rgm = ( (EditText)findViewById(R.id.editRgm)).getText().toString();
        String nome = ( (EditText)findViewById(R.id.editNome)).getText().toString();
        float np = Float.parseFloat(( (EditText)findViewById(R.id.editParcial)).getText().toString());
        float nt = Float.parseFloat(( (EditText)findViewById(R.id.editTrabalhos)).getText().toString());
        float nr = Float.parseFloat(( (EditText)findViewById(R.id.editPri)).getText().toString());
        if (base.insert(new Aluno(rgm,nome,np,nt,nr))){
            Toast.makeText(getApplicationContext(), "Dados gravados", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"ERRO",Toast.LENGTH_LONG).show();
        }
    }
}
