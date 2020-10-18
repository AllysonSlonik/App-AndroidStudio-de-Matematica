package com.example.tcc_meu_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //Variáveis de Layout
    TextView exibirPerguntaTV, exibirPontuacaoTV, numeroPerguntaTV;
    Button btnResponder, btnStartAdd, btnStartSub;
    EditText escrevaRespostaET;
    private SoundPool efeitosSonoros;
    private int efeitoAcertou, efeitoErrou;
    //Variáveis de Layout Fim.

    //Variáveis de inicialização
    int numbCorretas = 0;
    int perguntaIndex = 0;
    String codigoenvio;

    ArrayList<EstruturaPerguntaSub> estruturaPergunta = new ArrayList<EstruturaPerguntaSub>();


    // Variáveis de Inicialização Fim.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        efeitosSonoros = new SoundPool(1, AudioManager.STREAM_MUSIC,0);


        //Conexão Layout
        exibirPerguntaTV = findViewById(R.id.tv_exibirPergunta);
        exibirPontuacaoTV = findViewById(R.id.tv_pontuacao);
        numeroPerguntaTV = findViewById(R.id.numeroPergunta);
        btnResponder = findViewById(R.id.btn_responder);
        escrevaRespostaET = findViewById(R.id.et_escreva_resposta);
        btnStartAdd = findViewById(R.id.btnStart);
        btnStartSub = findViewById(R.id.btnStartSub);
        efeitoAcertou = efeitosSonoros.load(this, R.raw.acerto, 1);
        efeitoErrou = efeitosSonoros.load(this, R.raw.errado, 1);

        if(getIntent().getStringExtra("codigo").equals("adicao")){
            codigoenvio = "adicao";
        } if(getIntent().getStringExtra("codigo").equals("subtracao")){
            codigoenvio = "subtracao";
        } if(getIntent().getStringExtra("codigo").equals("multiplicacao")){
            codigoenvio = "multiplicacao";
        } if(getIntent().getStringExtra("codigo").equals("divisao")){
            codigoenvio = "divisao";
        }

        //Métodos inicialização
        novaPergunta();
        questoesFormatar();

        //Botões e ações
        btnResponder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                verificarResposta();
            }
        });

    }


    //Verificar Resposta/*
    public void verificarResposta(){

        if(escrevaRespostaET.getText().toString().equals(null) || escrevaRespostaET.getText().toString().equals("")) {
            Toast.makeText(this,"Por favor, digite sua resposta.",Toast.LENGTH_SHORT).show();
        } else {

            String escrevaResposta = escrevaRespostaET.getText().toString();
            double escrevaRespostaFinal = Double.parseDouble(escrevaResposta);

            if (escrevaRespostaFinal == estruturaPergunta.get(perguntaIndex).getResposta()) {
                Toast.makeText(MainActivity.this, "Correto!!", Toast.LENGTH_SHORT).show();
                numbCorretas++;
                perguntaIndex++;
                efeitosSonoros.play(efeitoAcertou, 1.0f, 1.0f, 1, 0, 1.0f);
                questoesFormatar();
                escrevaRespostaET.setText(null);

            } else {
                Toast.makeText(MainActivity.this, "Errado!!", Toast.LENGTH_SHORT).show();
                numbCorretas--;
                perguntaIndex++;
                efeitosSonoros.play(efeitoErrou, 1.0f, 1.0f, 1, 0, 1.0f);
                questoesFormatar();
                escrevaRespostaET.setText(null);
            }
        }
    }

    public void novaPergunta(){

           for (int i = 0; i < 3; i++) {
               estruturaPergunta.add(new EstruturaPerguntaSub(codigoenvio));
           }

    }

    public void questoesFormatar() {

        if (perguntaIndex < estruturaPergunta.size()) {

            exibirPontuacaoTV.setText("Pontuação: " + numbCorretas);
            numeroPerguntaTV.setText("Pergunta Número #" + (perguntaIndex + 1));
            exibirPerguntaTV.setText(estruturaPergunta.get(perguntaIndex).getCorpoPergunta());

        } else {

            AlertDialog.Builder alertar = new AlertDialog.Builder(MainActivity.this);

            alertar.setTitle("Parabéns!");
            alertar
                    .setIcon(R.mipmap.ic_launcher_round)
                    .setMessage("Você completou o QUIZ!")
                    .setCancelable(true)

                    .setPositiveButton("Menu Principal", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
                            startActivity(intent);
                        }
                    });

            AlertDialog alertDialog = alertar.create();
            alertDialog.show();

            exibirPontuacaoTV.setText("PONTUAÇÃO FINAL: " + numbCorretas);
            exibirPerguntaTV.setText("FIM DE QUIZ.");
            numeroPerguntaTV.setText("Parabéns,");
            btnResponder.setVisibility(View.INVISIBLE);
            escrevaRespostaET.setVisibility(View.INVISIBLE);
        }
    }
}