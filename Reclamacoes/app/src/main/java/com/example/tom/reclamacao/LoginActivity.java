package com.example.tom.reclamacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final EditText txtUser = (EditText) findViewById(R.id.textloguin);
        final EditText txtPass = (EditText) findViewById(R.id.textsenha);
        Button EntrarLoginCon = (Button) findViewById(R.id.EntrarLogin);
        EntrarLoginCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancodeDados bd = new BancodeDados(LoginActivity.this);
                try {
                    ArrayList<CadastroPessoas> cadastro = bd.getuser(txtUser.getText().toString());
                    if (cadastro.size() > 0) {
                        if (cadastro.get(0).getSenha().equals(txtPass.getText().toString())) {
                            Toast.makeText(LoginActivity.this, "entrou", Toast.LENGTH_LONG).show();
                            ReclamacaoActivity.userlogado = cadastro.get(0);
                            Intent i = new Intent(LoginActivity.this, ReclamacaoActivity.class);
                            startActivity(i);
                            finish();


                        } else {
                            Toast.makeText(LoginActivity.this, "senha invalida", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "nao encontrou", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnnovocadastro(View view) {
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
        finish();
    }
}
