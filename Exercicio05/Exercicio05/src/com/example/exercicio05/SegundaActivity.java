package com.example.exercicio05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends MainActivity {
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.calc);
	        
	        
	        final Button btM = (Button) findViewById(R.id.button1);
	        btM.setOnClickListener((OnClickListener) this);}
	        public void onClick(View v) {
	     	   EditText et = (EditText)findViewById(R.id.num1);
	     	   String sTextFromET = et.getText().toString();
	     	   int pesso = new Integer(sTextFromET).intValue();
	     	   EditText et2 = (EditText)findViewById(R.id.num2);
	     	   String sTextFromET2 = et.getText().toString();
	     	   int alt = new Integer(sTextFromET).intValue();
	     	   
	     	   int total = pesso / alt;
	     	   
	     	  TextView quantityTextView = (TextView) findViewById(R.id.result);
	        final Button btMe = (Button) findViewById(R.id.button2);
	        btMe.setOnClickListener((OnClickListener) this);}
	        public void onClick2(View v) {
	     	   EditText et = (EditText)findViewById(R.id.num1);
	     	   String sTextFromET = et.getText().toString();
	     	   int pesso = new Integer(sTextFromET).intValue();
	     	   EditText et2 = (EditText)findViewById(R.id.num2);
	     	   String sTextFromET2 = et.getText().toString();
	     	   int alt = new Integer(sTextFromET).intValue();
	     	   
	     	   int total = pesso * alt;
	     	   
	     	  TextView quantityTextView = (TextView) findViewById(R.id.result);
	        
	        final Button btD = (Button) findViewById(R.id.button3);
	        btD.setOnClickListener((OnClickListener) this);}
	        public void onClick3(View v) {
	     	   EditText et = (EditText)findViewById(R.id.num1);
	     	   String sTextFromET = et.getText().toString();
	     	   int pesso = new Integer(sTextFromET).intValue();
	     	   EditText et2 = (EditText)findViewById(R.id.num2);
	     	   String sTextFromET2 = et.getText().toString();
	     	   int alt = new Integer(sTextFromET).intValue();
	     	   
	     	   int total = pesso + alt;
	     	   
	     	  TextView quantityTextView = (TextView) findViewById(R.id.result);
	        
	        final Button btMu = (Button) findViewById(R.id.button4);
	        btMu.setOnClickListener((OnClickListener) this);}
	        public void onClick4(View v) {
	     	   EditText et = (EditText)findViewById(R.id.num1);
	     	   String sTextFromET = et.getText().toString();
	     	   int pesso = new Integer(sTextFromET).intValue();
	     	   EditText et2 = (EditText)findViewById(R.id.num2);
	     	   String sTextFromET2 = et.getText().toString();
	     	   int alt = new Integer(sTextFromET).intValue();
	     	   
	     	   int total = pesso - alt;
	     	   
	     	  TextView quantityTextView = (TextView) findViewById(R.id.result);
	     	  
	     	 final Button btn2 = (Button) findViewById(R.id.button1);
	 	    btn2.setOnClickListener((OnClickListener) this);  
	    }
	        final Button btn7 = (Button) findViewById(R.id.Button01);
	 	   
	        
	    public void onClick7(View v) {
	 	   Intent intent = new Intent(this, MainActivity.class);
	        startActivity(intent);}
	    
	 	    
	 	    
	 	    
	 	    final Button btn9 = (Button) findViewById(R.id.Button02);
	 	    public void onClick6(View v) {
	 	    	Intent intent = new Intent(this, MainActivity.class);
	 	        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |    Intent.FLAG_ACTIVITY_CLEAR_TASK);
	 	        startActivity(intent);
	 	        finish();    
	 	    
	    }

	        
	        
}
