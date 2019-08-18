package com.example.exercicioaula7bv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Consultar extends AppCompatActivity {

    private ArrayListAlunos base = new ArrayListAlunos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
    }

    public void consultarDados(View v){
        Aluno a = base.select(((EditText)findViewById(R.id.editRgm)).getText().toString());
        if (a != null){
            ((EditText)findViewById(R.id.editNome)).setText(a.getNome());
            ((EditText)findViewById(R.id.editParcial)).setText(a.getNota_parcial()+"");
            ((EditText)findViewById(R.id.editTrabalhos)).setText(a.getNota_trabs()+"");
            ((EditText)findViewById(R.id.editPri)).setText(a.getNota_reg()+"");
        }else{
            Toast.makeText(getApplicationContext(), "Rgm inválido", Toast.LENGTH_LONG).show();
        }
    }
}
