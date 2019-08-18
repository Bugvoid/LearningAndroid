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

public class Main2Activity extends AppCompatActivity {

    private ProgressDialog progressDialog ;
    private int qualSolicitacao = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // android:onClick="lerJSON"

        TextView output = (TextView) findViewById(R.id.dados);
        String data = "";
        try {
            // loadJSON() retorna uma String com os dados em res/raw/dados.json:
            JSONObject objRaiz = new JSONObject(loadJSON());
            JSONArray jsonArray = objRaiz.optJSONArray("tempo");
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String temp_min = jsonObject.optString("temp.min");
                String temp_max = jsonObject.optString("temp.max");
                data += " \n Temp.min = "+ temp_min + " , Temp.max" + temp_max;
            }
            output.setText(data);
        } catch (JSONException e) {}

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
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public String loadJSON() {
        String json = null;
        try {
            //fluxo de entrada que se encontra em res/raw/dados.json:
            InputStream is = this.getResources().openRawResource(R.raw.dados);
            int size = is.available();//retorna o n de bytes do arquivo
            byte[] buffer = new byte[size];
            final int res = is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json; //retorna uma String com os dados do vetor JSON
    }

    public void lerJSON(View view) {  //este método atende coisa nenhuma
        if (checkInternetConection()){
            progressDialog = ProgressDialog.show(this, "", "Baixando dados");
            new DownloadJson().execute("https://samples.openweathermap.org/data/2.5/forecast?q=M%C3%BCnchen,DE&appid=b6907d289e10d714a6e88b30761fae22");
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

    public void mostrarJSONTemp(String strjson){
        //recebe uma String com os dados do JSON
        String data = "";
        try {

            JSONObject objRaiz = new JSONObject(strjson);
            JSONArray jsonArray = objRaiz.optJSONArray("main");
            JSONObject jsonObject = null;
            //percorre o vetor de funcionarios e pega o nome para imprimir
            for(int i=0; i < jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);
                String temp_min = jsonObject.optString("temp_min");
                String temp_max = jsonObject.optString("temp_max");

                data += " \n Temp.min= " + temp_min + ", Temp.max=" + temp_max;
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
            if(qualSolicitacao == 1)mostrarJSONTemp(result);

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
