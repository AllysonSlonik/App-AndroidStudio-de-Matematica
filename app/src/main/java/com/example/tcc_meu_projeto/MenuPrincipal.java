package com.example.tcc_meu_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {

    Button btnStart, btnStartSub, btnStartMulti, btnStartDivisao, btnAprenderMais;
    TextView tv_QuizTitulo;
    String botaoCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnStart = findViewById(R.id.btnStart);
        btnStartSub = findViewById(R.id.btnStartSub);
        btnStartMulti = findViewById(R.id.btnStartMulti);
        btnStartDivisao = findViewById(R.id.btnStartDivisao);
        btnAprenderMais = findViewById(R.id.btnAprenderMais);
        tv_QuizTitulo = findViewById(R.id.tv_QuizTitulo);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoCodigo = "adicao";
                Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
                intent.putExtra("codigo", botaoCodigo);
                startActivity(intent);

            }
        });

        btnStartSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoCodigo = "subtracao";
                Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
                intent.putExtra("codigo", botaoCodigo);
                startActivity(intent);

            }
        });

        btnStartMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoCodigo = "multiplicacao";
                Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
                intent.putExtra("codigo", botaoCodigo);
                startActivity(intent);

            }
        });

        btnStartDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoCodigo = "divisao";
                Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
                intent.putExtra("codigo", botaoCodigo);
                startActivity(intent);

            }
        });

        btnAprenderMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAprender = new Intent(MenuPrincipal.this, AprenderMais.class);
                startActivity(intentAprender);
            }
        });
    }
}