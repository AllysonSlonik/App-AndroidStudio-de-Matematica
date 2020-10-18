package com.example.tcc_meu_projeto;
import android.widget.Switch;

import java.util.Random;


public class EstruturaPerguntaSub {

    public EstruturaPerguntaSub(String codigoenvio) {

        Random random = new Random();
        numero1 = random.nextInt(10 - 1) + 1;
        numero2 = random.nextInt(10 - 1) + 1;

        numero3 = random.nextInt(10 - 1) + 1;
        numero4 = random.nextInt(10 - 1) + 1;
        if(numero3 % numero4 != 0 || numero4 % numero3 != 0) {
            numero3 = random.nextInt(10 - 1) + 1;
            numero4 = random.nextInt(10 - 1) + 1;
        }


        switch(codigoenvio) {
            case "adicao":
                Resposta = numero1 + numero2;
                CorpoPergunta = "Quanto é " + numero1 + " + " + numero2 + " = ? " + Resposta;
                break;

            case "subtracao":
                if (numero1 >= numero2) {
                    Resposta = numero1 - numero2;
                    CorpoPergunta = "Quanto é " + numero1 + " - " + numero2 + " = ? " + Resposta;
                } else {
                    Resposta = numero2 - numero1;
                    CorpoPergunta = "Quanto é " + numero2 + " - " + numero1 + " = ? " + Resposta;
                }
                break;

            case "multiplicacao":
                Resposta = numero1 * numero2;
                CorpoPergunta = "Quanto é " + numero1 + " X " + numero2 + " = ? " + Resposta;
                break;

            case "divisao":

                if (numero3 >= numero4) {
                    Resposta = numero3 / numero4;
                    CorpoPergunta = "Quanto é " + numero3 + "  ÷ " + numero4 + " = ? " + Resposta;
                } else {
                    Resposta = numero4 / numero3;
                    CorpoPergunta = "Quanto é " + numero4 + "  ÷ " + numero3 + " = ? " + Resposta;
                }

                break;

        }

    }
        private String CorpoPergunta;
        private int Resposta;
        private int numero1;
        private int numero2;
        private int numero3;
        private int numero4;

        //GET SET
        public int getNumero1() {
            return numero1;
        }

        public void setNumero1(int numero1) {
            this.numero1 = numero1;
        }

        public int getNumero2() {
            return numero2;
        }

        public void setNumero2(int numero2) {
            this.numero2 = numero2;
        }

        public String getCorpoPergunta(){
            return this.CorpoPergunta;
        }

        public void setCorpoPergunta(String corpoPergunta){
            this.CorpoPergunta = corpoPergunta;
        }

        public int getResposta(){
            return this.Resposta;
        }

        public void setResposta(int resposta){
            this.Resposta = resposta;
        }
    }


