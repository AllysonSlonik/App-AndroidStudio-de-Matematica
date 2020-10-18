package com.example.tcc_meu_projeto;

import java.util.Random;


public class EstruturaPergunta {

    public EstruturaPergunta(){


            Random random = new Random();
            numero1 = random.nextInt(10 - 1) + 1;
            numero2 = random.nextInt(10 - 1) + 1;
            Resposta = numero1 + numero2;


        CorpoPergunta = "Quanto é " + numero1 + " + " + numero2 + " = ? " + Resposta;

    }

    private String CorpoPergunta;
    private int Resposta;
    private int numero1;
    private int numero2;

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
