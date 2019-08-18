package com.example.exercicioaula7bv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private Button btn_cad, btn_con, btn_alt, btn_apa, btn_edi,btn_sob, btn_lis;
    private ArrayListAlunos base = new ArrayListAlunos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_cad = (Button)findViewById(R.id.button);
        btn_alt = (Button)findViewById(R.id.button2);
        btn_apa = (Button)findViewById(R.id.button3);
        btn_edi = (Button)findViewById(R.id.button4);
        btn_sob = (Button)findViewById(R.id.button5);
        btn_lis = (Button)findViewById(R.id.button6);

        btn_cad.setOnClickListener(this);
        btn_alt.setOnClickListener(this);
        btn_apa.setOnClickListener(this);
        btn_edi.setOnClickListener(this);
        btn_sob.setOnClickListener(this);
        btn_lis.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Class classe = null;
        switch (v.getId()){
            case R.id.button: classe = Cadastrar.class;     break;
            case R.id.button2: classe = Consultar.class;    break;
            case R.id.button3: classe = Alterar.class;      break;
            case R.id.button4: classe = Apagar.class;       break;
            case R.id.button5: classe = ListarTodos.class;  break;
            case R.id.button6: classe = Sobre.class;        break;
        }
        if (classe != null){
            Intent myIntent = new Intent(getApplicationContext(),classe);
            startActivity(myIntent);
        }
    }
}
