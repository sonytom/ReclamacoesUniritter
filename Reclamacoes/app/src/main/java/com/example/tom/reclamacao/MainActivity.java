package com.example.tom.reclamacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void voltar2(View view) {
        Intent i = new Intent(this, ReclamacaoActivity.class);
        startActivity(i);
        finish();
    }

}
