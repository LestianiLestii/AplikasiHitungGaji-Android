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


public class MainActivity extends Activity {
	Button Login1, Keluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Login1 = (Button)findViewById (R.id.login);
       
        Login1.setOnClickListener(new View.OnClickListener() {
        
        
            @Override
            public void onClick(View arg0) {
                    // Implementasikan pindah menggunakan Intent
                    Intent intentpindah = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intentpindah);
           }
   });   
        Keluar = (Button)findViewById (R.id.exit);
        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      		 builder.setMessage("Yakin Keluar Aplikasi?")
      		  .setCancelable(false)//tidak bisa tekan tombol back
      		  //jika pilih yess
      		  .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
      		   public void onClick(DialogInterface dialog, int id) {
               System.exit(0);
      		 }
    		  })
    		  //jika pilih no
    		  .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    		   public void onClick(DialogInterface dialog, int id) {
    		    dialog.cancel();
    		   }
    		  }).show();
           }
   });   
    }

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
