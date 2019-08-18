package com.example.alcides.exemplo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Contato aluno;
    DecimalFormat formato = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_list) {
            Intent i = new Intent(getApplicationContext(),ListaDeContatos.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sobre) {
            Intent i = new Intent(getApplicationContext(),Activity_sobre.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void gravarAluno(View v){
        aluno = new Contato();
        aluno.setNome(((EditText) findViewById(R.id.edt_nome)).getText().toString());
        aluno.setCelular(((EditText) findViewById(R.id.edt_celular)).getText().toString());
        aluno.setEmail(((EditText) findViewById(R.id.edt_email)).getText().toString());

        if (new ContatoDAO(getApplicationContext()).insert(aluno))
            ((TextView) findViewById(R.id.resp)).setText("O Contato foi cadastrado.");
        else
            ((TextView) findViewById(R.id.resp)).setText("Por favor, verifique os dados.");
        limparCampos();
    }

    public void consultarAluno(View v){
        aluno = new ContatoDAO(getApplicationContext()).select(((EditText) findViewById(R.id.edt_nome)).getText().toString());
        if (aluno != null) {
            ((EditText) findViewById(R.id.edt_celular)).setText(aluno.getCelular() + "");
            ((EditText) findViewById(R.id.edt_email)).setText(aluno.getEmail() + "");
        } else
            ((TextView) findViewById(R.id.resp)).setText("Contato não encontrado pelo Nome.");
    }

    public void alterarAluno(View v){
        aluno = new Contato();
        aluno.setNome(((EditText) findViewById(R.id.edt_nome)).getText().toString());
        aluno.setCelular(((EditText) findViewById(R.id.edt_celular)).getText().toString());
        aluno.setEmail(((EditText) findViewById(R.id.edt_email)).getText().toString());


        if (new ContatoDAO(getApplicationContext()).update(aluno))
            ((TextView) findViewById(R.id.resp)).setText("O aluno foi alterado.");
        else
            ((TextView) findViewById(R.id.resp)).setText("Por favor, verifique os dados.");
        limparCampos();
    }

    public void excluirAluno(View v){
        if (new ContatoDAO(getApplicationContext()).delete(((EditText) findViewById(R.id.edt_nome)).getText().toString()))
            ((TextView) findViewById(R.id.resp)).setText("O Contato foi eliminado.");
        else
            ((TextView) findViewById(R.id.resp)).setText("Por favor, verifique o Nome do Contato a eliminar.");
        limparCampos();
    }

    public void listarTodos(View v) {
        String todos = (new ContatoDAO(getApplicationContext()).listarTodos());
        ((TextView) findViewById(R.id.resp)).setText(todos);
    }

    public void limparCampos(){
        ((EditText) findViewById(R.id.edt_nome)).setText("");
        ((EditText) findViewById(R.id.edt_celular)).setText("");
        ((EditText) findViewById(R.id.edt_email)).setText("");
    }
}
