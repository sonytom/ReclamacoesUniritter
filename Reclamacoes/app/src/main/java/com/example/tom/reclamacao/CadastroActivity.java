package com.example.tom.reclamacao;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


public class CadastroActivity extends ActionBarActivity {
    private BancodeDados banco;
    private ListView listView;

    private EditText textnome;
    private EditText textSobrenome;
    private EditText textcep;
    private EditText textendereco;
    private EditText textcomplemento;
    private EditText textBairro;
    private EditText txttelefone;
    private EditText txtusuario;
    private EditText txtsenha;

    private void findViews() {
        textnome = (EditText) findViewById(R.id.textnome);
        textSobrenome = (EditText) findViewById(R.id.textSobrenome);
        textcep = (EditText) findViewById(R.id.textcep);
        textendereco = (EditText) findViewById(R.id.textendereco);
        textcomplemento = (EditText) findViewById(R.id.textcomplemento);
        textBairro = (EditText) findViewById(R.id.textBairro);
        txttelefone = (EditText) findViewById(R.id.txttelefone);
        txtusuario = (EditText) findViewById(R.id.txtusuario);
        txtsenha = (EditText) findViewById(R.id.txtsenha);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_activity);
        banco = new BancodeDados(this);
        findViews();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
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

    public void btnenviar(View view) {
        if (!txtsenha.getText().toString().isEmpty() && !txtusuario.getText().toString().isEmpty()) {

            CadastroPessoas cadastro = new CadastroPessoas();
            cadastro.setNome(textnome.getText().toString());
            cadastro.setSobrenome(textSobrenome.getText().toString());
            cadastro.setCep(textcep.getText().toString());
            cadastro.setEndereco(textendereco.getText().toString());
            cadastro.setComplemento(textcomplemento.getText().toString());
            cadastro.setBairro(textBairro.getText().toString());
            cadastro.setTelefone(txttelefone.getText().toString());

            cadastro.setUsuario(txtusuario.getText().toString());
            cadastro.setSenha(txtsenha.getText().toString());

            try {
                banco.insertUsuario(cadastro);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finish();
        } else {
            txtusuario.setError("Obrigatorio");
            txtsenha.setError("Obrigatorio");
        }
    }
}
