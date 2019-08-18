package com.example.exercicio05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final Button btn1 = (Button) findViewById(R.id.button3);
btn1.setOnClickListener((OnClickListener) this);
   }
   // Implement the OnClickListener callback
   public void onClick(View v) {
	   EditText et = (EditText)findViewById(R.id.txtpeso);
	   String sTextFromET = et.getText().toString();
	   int pesso = new Integer(sTextFromET).intValue();
	   EditText et2 = (EditText)findViewById(R.id.txtaltura);
	   String sTextFromET2 = et.getText().toString();
	   int alt = new Integer(sTextFromET).intValue();
	   int total = pesso / (alt+alt);
	   
	   TextView quantityTextView = (TextView) findViewById(R.id.Resultado);
	    quantityTextView.setText(total);
     // do something when the button is clicked
	    
	    
	    
	    final Button btn2 = (Button) findViewById(R.id.button1);
	    btn2.setOnClickListener((OnClickListener) this);  
   }
   
   // Implement the OnClickListener callback
   public void onClick1(View v) {
	   Intent intent = new Intent(this, SegundaActivity.class);
       startActivity(intent);}
   
	    
	    
	    
	    final Button btn3 = (Button) findViewById(R.id.button2);
	    public void onClick2(View v) {
	    	Intent intent = new Intent(this, MainActivity.class);
	        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |    Intent.FLAG_ACTIVITY_CLEAR_TASK);
	        startActivity(intent);
	        finish();    
	    
   }
	    
	    

       

        //
        
        
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
