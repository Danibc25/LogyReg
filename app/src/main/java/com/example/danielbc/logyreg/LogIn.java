package com.example.danielbc.logyreg;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class LogIn extends Activity {
    private Button bLogin, bReg;
    private EditText etUserName, etPassword;
    static int REQUES_CODE = 1;

    private ArrayList<Usuario> Usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button)findViewById(R.id.bLogin);
        bReg = (Button)findViewById(R.id.bReg);


        Usuarios = new ArrayList<Usuario>();

        Usuario u1 = new Usuario("Manel", "Viel", "mviel@florida-uni.es", "1234", "654321098", "1");
        Usuarios.add(u1);

    }


    public void bRegPuls(View v){


        Intent r = new Intent(getApplicationContext(), Registro.class);
        startActivityForResult(r,REQUES_CODE);
    }


    public void bLoginPuls(View v){

        String uName = etUserName.getText().toString();
        String uPass = etPassword.getText().toString();
        boolean result;
       result = compararLog(uName, uPass);
            if(result== true){

                Intent lr = new Intent(LogIn.this, LogyReg.class);
                startActivity(lr);

            }

        }


    private boolean compararLog(String uName, String uPass) {

        boolean valido = false;

        Iterator<Usuario> it =Usuarios.iterator();

        while (it.hasNext()){

            Usuario us1 =(Usuario) it.next();

                if(us1.getUserName().compareTo(uName)==0 && us1.getPassword().compareTo(uPass)==0){
                    valido = true;
                }
        }
    return valido;

       /*SharedPreferences guardarPref = getSharedPreferences
                ("preferencias", Context.MODE_PRIVATE);

        String user = guardarPref.getString("userName", "0");
        String pass = guardarPref.getString("password", "0");

        String userName = etUserName.getText().toString();
        String passW = etPassword.getText().toString();


        if (userName.compareTo(user)==0) {

            Intent lr = new Intent(LogIn.this, LogyReg.class);
            startActivity(lr);
        }*/

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {

        super.onActivityResult(requestCode, resultCode, i);

        //comprovem des de quin subactivity venim
        if(requestCode==REQUES_CODE){  // Venim del subactivity2



            if(resultCode==RESULT_OK){ //Posem en Majuscules el nom
                Usuario us1 = i.getExtras().getParcelable("User");
                Usuarios.add(us1);

            }

        }}
}
