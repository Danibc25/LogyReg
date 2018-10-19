package com.example.danielbc.logyreg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registro extends Activity {
    private EditText etNombre, etApellido,etCorreo,etTelefono, etUserName, etPassword;
    private RadioButton rbutton;
    private Button bRegistro, bCancelar;
    private RadioGroup rGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);

        rGroup=(RadioGroup) findViewById(R.id.rGroup);

        /*rbHombre= (RadioButton) findViewById(R.id.rbHombre);
        rbMujer= (RadioButton) findViewById(R.id.rbMujer);*/

        bRegistro=(Button) findViewById(R.id.bRegistro);
        bCancelar=(Button) findViewById(R.id.bCancelar);
    }

    public void bRegistroPuls(View v){
        Usuario usuario1 = guardarRegistro();

        if (usuario1 != null) {
            Intent i = new Intent();
            i.putExtra("Usuario", usuario1);
            setResult(RESULT_OK, i);
            finish();
        }
        else{
            Intent i = new Intent();
            setResult(RESULT_CANCELED, i);
            finish();

        /*Intent r = new Intent(Registro.this, LogIn.class);
        startActivity(r);*/
    }}

    public void bCancelarPuls(View v){
        finish();
    }

    private Usuario guardarRegistro(){

        //Intent i = new Intent();
        //Bundle b = new Bundle();


        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String correo = etCorreo.getText().toString();
        String telefono = etTelefono.getText().toString();
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if((nombre.compareTo("")!=0)&&(apellido.compareTo("")!=0)
                &&(correo.compareTo("")!=0)&&(telefono.compareTo("")!=0)
                    &&(userName.compareTo("")!=0)&&(password.compareTo("")!=0)) {

            Usuario u1 = new Usuario(nombre, apellido, correo, telefono, password, userName);
            return u1;
        }else{
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Completa todos los campos :)", Toast.LENGTH_SHORT);

            toast1.show();
        }

        /*
        SharedPreferences.Editor editor1 = guardarPref.edit();

        rbutton.findViewById(sexo);
        String sex = rbutton.getText().toString();

        editor1.putString("nombre",nombre);
        editor1.putString("apellido", apellido);
        editor1.putString("correo", correo);
        editor1.putString("telefono", telefono);
        editor1.putString("userName", userName);
        editor1.putString("password", password);
        editor1.putString("sexo",sex);

        editor1.commit();*/


        return null;
    }


}
