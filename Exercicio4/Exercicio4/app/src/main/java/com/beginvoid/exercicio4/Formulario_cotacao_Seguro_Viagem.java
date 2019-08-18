package com.beginvoid.exercicio4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Formulario_cotacao_Seguro_Viagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cotacao__seguro__viagem);
    }
    public void telaprinci(View view) {
        setContentView(R.layout.activity_main);
    }
    public void telaauto(View view) {
        setContentView(R.layout.formulario_cotacao_auto);
    }
    public void telaportateis(View view) {
        setContentView(R.layout.activity_formulario_cotacao__equipamentos__portateis);
    }
    public void telaempresarial(View view) {
        setContentView(R.layout.activity_formulario_cotacao__seguro__empresarial);
    }
    public void telaresidencial(View view) {
        setContentView(R.layout.activity_formulario_cotacao__seguro__residencial);
    }
    public void telaviagem(View view) {
        setContentView(R.layout.activity_formulario_cotacao__seguro__viagem);
    }
}
