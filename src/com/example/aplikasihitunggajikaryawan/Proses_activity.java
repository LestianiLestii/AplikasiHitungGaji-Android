package com.example.aplikasihitunggajikaryawan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Proses_activity extends Activity {
	Button Hitung,selesai;
	EditText nama,nik,hari,lembur;
	RadioButton golA, golB, golC, golD;
	RadioGroup GolKar;
	private double gajilembur = 0;
	private double Totalgaji = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proses_activity);
		 nama = (EditText)findViewById(R.id.txtnama);
         nama.getText();
         nik = (EditText)findViewById(R.id.txtnik);
         nik.getText();
         hari = (EditText)findViewById(R.id.txtkerja);
         hari.getText();
         lembur = (EditText)findViewById(R.id.txtlembur);
         lembur.getText();
         Hitung = (Button)findViewById(R.id.Buttonhitung);
         selesai = (Button)findViewById(R.id.Buttonselesai);
         selesai.setOnClickListener(new View.OnClickListener() {
        	 public void onClick(View arg0) {
                 // Implementasikan pindah menggunakan Intent
        		 AlertDialog.Builder builder = new AlertDialog.Builder(Proses_activity.this);
        		  builder.setMessage("Yakin Sudah selesai dan keluar?")
        		  .setCancelable(false)//tidak bisa tekan tombol back
        		  //jika pilih yess
        		  .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        		   public void onClick(DialogInterface dialog, int id) {
        			   Intent intentpindah = new Intent(Proses_activity.this, Interface_Akhir.class);
                       startActivity(intentpindah);
                       System.exit(0);
        		   }
        		  })
        		  //jika pilih no
        		  .setNegativeButton("No", new DialogInterface.OnClickListener() {
        		   public void onClick(DialogInterface dialog, int id) {
        		    dialog.cancel();
        		   }
        		  }).show();

        }
});   
         final TextView Total = (TextView) findViewById(R.id.totalview);
         Hitung.setOnClickListener(new View.OnClickListener() {
        		@Override
        		public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        			GolKar = (RadioGroup) findViewById(R.id.radioGroup);
        	        int gol = GolKar.getCheckedRadioButtonId();
        			if(nama.getText().toString().length()==0){
        			    nama.setError("Masukkan Nama!");
        			}else if(nik.getText().toString().length()==0){
        			    nik.setError("Masukkan Nik!");
        			}else if(lembur.getText().toString().length()==0){
        			    lembur.setError("Masukkan Jam Lembur!");
        			}else if(hari.getText().toString().length()==0){
        			    hari.setError("Masukkan Hari Kerja!");
        			}else{
            			double gajiharian = 0;
    					if (gol == R.id.radioButton1) {
            	            gajiharian = 50000.0;
            	        } else if (gol == R.id.radioButton2) {
            	            gajiharian= 40000.0;
            	        } else if (gol == R.id.radioButton3) {
            	            gajiharian= 30000.0;
            	        } else if (gol == R.id.radioButton4) {
            	        	gajiharian= 20000.0;
            	        } else{
            				gajiharian=0;
            			}	
    					double harikerja = Double.parseDouble(hari.getText().toString());
            			double jamlembur = Double.parseDouble(lembur.getText().toString());
            			if(gajiharian==0){
            				Toast.makeText(getApplicationContext(), "Pilih Golongan Terlebih Dahulu!!", Toast.LENGTH_SHORT).show();
            			}
            			else {
            				Totalgaji = (harikerja*gajiharian)+(jamlembur*15000);
                			Total.setText(String.valueOf(Totalgaji));
            			}
            		}
        			}
        			
        		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.proses_activity, menu);
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
