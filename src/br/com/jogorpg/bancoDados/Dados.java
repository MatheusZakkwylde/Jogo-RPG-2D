
package br.com.jogorpg.bancoDados;

public class Dados implements Comparable <Dados>{
    
     private String NomeUsuario;
     private int Pontuacao ;
     
    public Dados(String nomeUsuario,int pontuacao) {
        Pontuacao  = pontuacao;
        NomeUsuario = nomeUsuario;
    }

    public int getPontuacao() {
        return Pontuacao;
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public int compareTo(Dados outroDados) {
        
        if (Pontuacao > outroDados.getPontuacao()){
            return -1;
        }else if (Pontuacao < outroDados.getPontuacao()){
            return 1;
        }
        return 0;
    }
  
}
