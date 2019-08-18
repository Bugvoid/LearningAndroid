package com.example.logonaf.exerccioarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Cadastrar extends AppCompatActivity {


    private Global array = new Global();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);


    }

    public void CadastrarAluno(View view) {
        String rgm = ((EditText)findViewById(R.id.RGM)).getText().toString();
        String nome = ((EditText) findViewById(R.id.Nome)).getText().toString();
        Float notaparcial = Float.parseFloat(((EditText)findViewById(R.id.NotaParcial)).getText().toString()) ;
        Float trabalhos = Float.parseFloat(((EditText)findViewById(R.id.Trabalhos)).getText().toString()) ;
        Float NotaPri = Float.parseFloat(((EditText)findViewById(R.id.NotaPri)).getText().toString()) ;

        if(array.Create(new Aluno(rgm,nome,notaparcial,trabalhos,NotaPri)) == true){
            Toast toast = Toast.makeText(getApplicationContext(), "Cadastrado Com sucesso",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Erro",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
