package com.example.aplikasihitunggajikaryawan;

//main activity.java source code

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	EditText editUser,editPass;
	Button btnLogin;
	String username = "Admin";
	String pass = "admin";
	
	@Override

	protected void onCreate(Bundle savedInstanceState) {
	         super.onCreate(savedInstanceState);
	         setContentView(R.layout.form_login);
	         editUser = (EditText)findViewById(R.id.txtUser);
	         editUser.getText();
	         editPass = (EditText)findViewById(R.id.txtPass);
	         editPass.getText();
	         btnLogin = (Button)findViewById(R.id.Login2);
	         btnLogin.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View arg0) {
	// TODO Auto-generated method stub
		if(editUser.getText().toString().length()==0){
        			    editUser.setError("Masukkan Username!");
        }else if(editPass.getText().toString().length()==0){
        			    editPass.setError("Masukkan Password!");
        }else{
        	if(editUser.getText().toString().equals(username) && editPass.getText().toString().equals(pass))
			{
			editUser.setText("");
			editPass.setText("");
			Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
			Intent intentpindah = new Intent(LoginActivity.this, Proses_activity.class);
            startActivity(intentpindah);
			}
		else
			Toast.makeText(getApplicationContext(), "Login Gagal. Username / Password Salah", Toast.LENGTH_SHORT).show();
		}
        }
		
	});

}
}