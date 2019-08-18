package com.example.logonaf.exerccioarray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AbrirSobre(View view) {
        Intent it = new Intent(MainActivity.this, Sobre.class);
        startActivity(it);
    }
    public void AbrirCadastrar(View view) {
        Intent it = new Intent(MainActivity.this, Cadastrar.class);
        startActivity(it);
    }
    public void AbrirExcluir(View view) {
        Intent it = new Intent(MainActivity.this, Excluir.class);
        startActivity(it);
    }
    public void AbrirAlterar(View view) {
        Intent it = new Intent(MainActivity.this, Editar.class);
        startActivity(it);
    }
    public void AbrirLista(View view) {
        Intent it = new Intent(MainActivity.this, ListarTodos.class);
        startActivity(it);
    }
    public void AbrirConsultar(View view) {
        Intent it = new Intent(MainActivity.this, Consultar.class);
        startActivity(it);
    }

}
