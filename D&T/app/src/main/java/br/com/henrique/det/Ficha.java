package br.com.henrique.det;

import java.io.Serializable;

/**
 * Created by Henrique on 25/03/2015.
 */
public class Ficha implements Cloneable, Serializable {

    Ficha personagem;

    //Atualizaçao
    private String f = "0";
    private String h = "0";
    private String a = "0";
    private String r = "0";
    private String p = "0";
    private String m = "0";
    private String v = "0";

    //Características
    private String nome;
    private int forca;
    private int habilidade;
    private int resistencia;
    private int armadura;
    private int pdf;
    private int pm;

    //Vantagens e Desvantagens
    private String vantagem1;
    private String vantagem2;
    private String vantagem3;
    private String vantagem4;
    private String desvantagem1;
    private String desvantagem2;
    private String desvantagem3;
    private String desvantagem4;

    //Tipos de dano
    private String tdd1;
    private String tdd2;

    //Magias conhecidas
    private String magia1;
    private String magia2;
    private String magia3;
    private String magia4;
    private String magia5;

    //Dinheiros e Itens + História
    private String itens;
    private String historia;

    private int vida;
    private int experiencia;

    public Ficha() {

    }

    public void criaPersonagem(){

        try {
            personagem = (Ficha) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

      }

    public Ficha getPersonagem(){

        return personagem;

    }

    public String getNome() {

        return this.nome;

    }

    public int[] getCaracteristicas() {
        //PM seta separado
        int[] array = {this.forca, this.habilidade, this.armadura, this.resistencia, this.pdf, this.pm};

        return array;

    }

    public void setCaracteristicas(String nome, int forca, int habilidade, int resistencia, int armadura, int pdf) {

        this.nome = nome;
        this.forca = forca;
        this.habilidade = habilidade;
        this.resistencia = resistencia;
        this.armadura = armadura;
        this.pdf = pdf;

    }

    public void setAtualizacoes(String f, String h, String r, String a, String p, String m, String v){
        this.f = f;
        this.h = h;
        this.r = r;
        this.a = a;
        this.p = p;
        this.m = m;
        this.v = v;
    }

    public String[] getAtualizacoes(){
        String[] at = {this.f, this.h, this.r, this.a, this.p, this.m, this.v};
        return at;
    }

    public String[] getVantagens() {

        String[] array = {this.vantagem1, this.vantagem2, this.vantagem3, this.vantagem4};
        return array;
    }

    public String[] getDesvantagens(){

        String[] array = {this.desvantagem1, this.desvantagem2, this.desvantagem3, this.desvantagem4};

        return array;

    }

    public void setVantagensEDesvantagens(String v1, String v2, String v3, String v4, String d1, String d2, String d3, String d4) {

        this.vantagem1 = v1;
        this.vantagem2 = v2;
        this.vantagem3 = v3;
        this.vantagem4 = v4;

        this.desvantagem1 = d1;
        this.desvantagem2 = d2;
        this.desvantagem3 = d3;
        this.desvantagem4 = d4;

    }

    public String[] getTiposDeDano(){

        String[] array = {this.tdd1, this.tdd2};

        return array;

    }

    public String[] getMagiasConhecidas(){

        String[] array = {this.magia1, this.magia2, this.magia3, this.magia4, this.magia5};

        return array;

    }

    public void setTiposDeDanoEMagiasConhecidas(String tdd1, String tdd2, String m1, String m2, String m3, String m4, String m5) {

        this.tdd1 = tdd1;
        this.tdd2 = tdd2;

        this.magia1 = m1;
        this.magia2 = m2;
        this.magia3 = m3;
        this.magia4 = m4;
        this.magia5 = m5;


    }

    public String getItens() {
        return this.itens;
    }

    public String getHistoria() {
        return this.historia;
    }

    public void setItensEHistoria(String itens, String historia) {

        this.itens = itens;
        this.historia = historia;

    }


    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    @Override
    public boolean equals(Object o) {
        Ficha ob = (Ficha) o;
        if(ob.getNome().equals(this.getNome())){
            return true;
        } else {
            return false;
        }
    }
}
