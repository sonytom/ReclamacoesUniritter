package com.example.tom.reclamacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ReclamacaoActivity extends AppCompatActivity {
    public static CadastroPessoas userlogado = null;
    private BancodeDados banco;
    private EditText textreclama;
    private CheckBox infrackbox;
    private CheckBox docentschk;
    private ListView listview;

    private void findViews() {
        textreclama = (EditText) findViewById(R.id.textpedido);
        infrackbox = (CheckBox) findViewById(R.id.maquinackbox);
        docentschk = (CheckBox) findViewById(R.id.receitachk);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reclamacao_activity);
        banco = new BancodeDados(this);
        findViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent i = new Intent(this, ListareclamaActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void enviarrr(View view) {
        if (!textreclama.getText().toString().isEmpty()) {
            Reclamacao pedido = new Reclamacao();
            pedido.setReclamcao(textreclama.getText().toString());
            pedido.setInfra(infrackbox.isChecked() ? "S" : "N");
            pedido.setDocente(docentschk.isChecked() ? "S" : "N");
            try {
                banco.insertReclamacao(pedido);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ReclamacaoActivity.userlogado == null) {
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
            } else {
                Intent i = new Intent(this, ListareclamaActivity.class);
                startActivity(i);
            }
        } else {
            Toast.makeText(ReclamacaoActivity.this, "Voce nao Digitou Nenhum Pedido", Toast.LENGTH_LONG).show();
        }
    }

}
