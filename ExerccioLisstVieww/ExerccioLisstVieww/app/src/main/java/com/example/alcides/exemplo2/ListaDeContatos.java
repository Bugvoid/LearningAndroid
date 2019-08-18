package com.example.alcides.exemplo2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListaDeContatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_alunos);

        List<Contato> alunos = new ContatoDAO(getApplicationContext()).listarAlunos();
        int i = 0;
        if (alunos.size()>0){
            String dados[]=new String[alunos.size()];
            final String rgms[]=new String[alunos.size()];
            final String c[]=new String[alunos.size()];
            while (i < alunos.size()) {
                Contato a = alunos.get(i);
                dados[i] = "NOME: " + a.getNome() + "\n" + a.getCelular();
                rgms[i] = a.getNome();
                c[i] = a.getCelular();
                i++;
            }
            final ArrayAdapter<String> myadapter = new ArrayAdapter<String>(getApplicationContext(),
                                                R.layout.item_list,
                                                R.id.item_list,
                                                dados);
            ListView lista = (ListView)findViewById(R.id.listview);
            lista.setAdapter(myadapter);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mostraDadosDoAluno(rgms[position]); //para mostrar dados do aluno "clicado"
                }
            });
            lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @SuppressLint("MissingPermission")
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:12154546"));
                    startActivity(intent);
                    return true;
                }
            });
        }
        else
            Toast.makeText(getApplicationContext(), "Banco de dados vazio", Toast.LENGTH_LONG).show();
    }

    public void mostraDadosDoAluno(String rgm) {
        Contato aluno =  new ContatoDAO(getApplicationContext()).select(rgm);
        Toast.makeText(getApplicationContext(), aluno.getNome() + ", " +
                            aluno.getCelular() + ", " + aluno.getEmail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_de_alunos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
