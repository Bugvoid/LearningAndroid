package com.beginvoid.execiciojson1;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog ;
    private int qualSolicitacao = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // android:onClick="lerJSON"

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent i = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void lerJSON(View view) {  //este método atende o evento de click no botão Funcionários
        qualSolicitacao = 1;
        if (checkInternetConection()){
            progressDialog = ProgressDialog.show(this, "", "Baixando dados");
            new DownloadJson().execute("http://mfpledon.com.br/receita.json");
        } else{
            Toast.makeText(getApplicationContext(),"Sem conexão. Verifique.",Toast.LENGTH_LONG).show();
        }
    }




    public boolean checkInternetConection() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void mostrarJSONReceita(String strjson){
        //recebe uma String com os dados do JSON
        String data = "";
        try {
            JSONObject objRaiz = new JSONObject(strjson);
            JSONArray jsonArray = objRaiz.optJSONArray("receita");
            JSONObject jsonObject = null;
            //percorre o vetor de funcionarios e pega o nome para imprimir
            for(int i=0; i < jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.optString("cpf");
                String rg = jsonObject.optString("rg");
                String nome = jsonObject.optString("nome");
                String datanasc = jsonObject.optString("datanasc");
                String sexo = jsonObject.optString("sexo");
                String salario = jsonObject.optString("salario");
                data += " \n cpf= " + id + ", rg=" + rg + ", nome = "+ nome + ", data de nascimento=" + datanasc + " sexo=" + sexo +", salário R$ " + salario;
                jsonObject = null;
            }
            ((TextView)findViewById(R.id.dados)).setText(data);
            progressDialog.dismiss();
        } catch (JSONException e) {}
    }



    private class DownloadJson extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            // params[0] é o URL.
            try {
                return downloadJSON(params[0]);
            } catch (IOException e) {
                return "URL inválido";
            }
        }

        // onPostExecute exibe o resultado do AsyncTask
        @Override
        protected void onPostExecute(String result) {
            if(qualSolicitacao == 1)mostrarJSONReceita(result);

        }

        private String downloadJSON(String myurl) throws IOException {
            InputStream is = null;
            String respostaHttp = "";
            HttpURLConnection conn = null;
            InputStream in = null;
            ByteArrayOutputStream bos = null;
            try {
                URL u = new URL(myurl);
                conn = (HttpURLConnection) u.openConnection();
                conn.setConnectTimeout(7000); // 7 segundos de timeout
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                in = conn.getInputStream();
                bos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) > 0) {
                    bos.write(buffer, 0, len);
                }
                respostaHttp = bos.toString("UTF-8");
                return respostaHttp;
            } finally {
                if (in != null) in.close();
            }
        }

    }

}
