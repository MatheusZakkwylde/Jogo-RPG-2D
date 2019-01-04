package br.com.jogorpg.pessonagens.tiro;

import br.com.jogorpg.menu.Configuracao;
import br.com.jogorpg.pessonagens.Inimigo;
import java.util.LinkedList;
import jplay.Scene;
import jplay.Sound;
import jplay.URL;

public class ControleTiro {

  LinkedList<Tiro> SequenciaTiros = new LinkedList<>();//lista de tiros 

  public void adicionaTiro(double x,double y,int direcao,Scene cena) {
    
    Tiro Tiros = new Tiro(x,y,direcao); // estanciando a list de tiros e passando os parametro para ela.
    SequenciaTiros.add(Tiros);//colocando a variavel tiro dentro da lista  
    cena.addOverlay(Tiros);//adionando o tiro na tela 
       somTiro(); //chamada do som do tiro.
  }
    
  public void run(Inimigo inimigo) {
   
   for (int i = 0; i < SequenciaTiros.size(); i++) {// pecorendo a lista

      Tiro TiroDisparado = SequenciaTiros.removeFirst(); //pegando o primeiro objeto da lista 
      TiroDisparado.TiroMover();//move o tiro
      SequenciaTiros.addLast(TiroDisparado);// adicona no ultimo indice da lista Tiro 

        if (TiroDisparado.collided(inimigo)) {
             TiroDisparado.x = 10000_00000; // se o tiro colide com o inimigo ele sair da tela
             inimigo.energiaInimigo -= 250;// a energia do inimigo perde 250 pontos
        }
   }
 }
  
  private final void somTiro() {
    if (Configuracao.opcao){
    new Sound(URL.audio("Flecha.wav")).play();
    }else {
      new Sound(URL.audio("Flecha.wav")).stop();
    }
  }
}
