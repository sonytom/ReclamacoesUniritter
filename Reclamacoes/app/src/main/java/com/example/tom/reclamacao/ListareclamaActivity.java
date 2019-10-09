package com.example.tom.reclamacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListareclamaActivity extends AppCompatActivity {

    private ListView mlistview;
    private BancodeDados banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_reclama_activity);
        banco = new BancodeDados(this);
        mlistview = (ListView) findViewById(R.id.listviewreclama);
        try {

            mlistview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Reclamacao ReclamacaoExcuir = (Reclamacao) parent.getItemAtPosition(position);
                    banco.deletarReclamacao(ReclamacaoExcuir);
                    onResume();

                    return true;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Reclamacao> reclamacaos = new ArrayList<Reclamacao>();
        try {
            reclamacaos = banco.getAllReclamacoes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mlistview.setAdapter(new ReclamacaoAdapter(this, reclamacaos));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pedidos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            ReclamacaoActivity.userlogado = null;
            Toast.makeText(ListareclamaActivity.this, "Voce Deslogou", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, ReclamacaoActivity.class);
            startActivity(i);
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}


