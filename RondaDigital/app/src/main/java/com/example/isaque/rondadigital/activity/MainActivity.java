package com.example.isaque.rondadigital.activity;

import android.content.Intent;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isaque.rondadigital.R;
import com.example.isaque.rondadigital.model.ListenerWhenAutenticado;
import com.example.isaque.rondadigital.model.ModelUsuario;
import com.example.isaque.rondadigital.objetos.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListenerWhenAutenticado {

    public static final String IP = "192.168.0.1";

    private TextView email, senha, logar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.textEmail);
        senha = (TextView) findViewById(R.id.textSenha);
        logar = (Button) findViewById(R.id.btnLogar);


            //Toast.makeText( this , "TEXTO QUALQUER", Toast.LENGTH_LONG ).show();

        logar.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {



        Toast.makeText( this , "Verificando no servidor!", Toast.LENGTH_LONG ).show();

        Usuario usuario = new Usuario();
        usuario.setEmail( email.getText().toString() );
        usuario.setSenha( senha.getText().toString() );


        new ModelUsuario().tentarAutenticar( this , usuario );
    }

    @Override
    @WorkerThread
    public void whenFinish(boolean autenticou) {


        if( autenticou ) {
            startActivity( new Intent( this , SecondActivity.class ) );
        } else {
            Toast.makeText( this , "Campos incorretos!", Toast.LENGTH_LONG ).show();
        }
    }

}
