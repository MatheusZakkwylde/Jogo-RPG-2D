package br.com.jogorpg.pessonagens;

import jplay.URL;

public class Inimigo extends Pessonagem {

    private int AtaqueDoInimigo = 1;
    public int  energiaInimigo = 4000;

    public Inimigo(int x, int y) {
        
      super(URL.sprite("Inimigo.png"),12);
      this.x = x;
      this.y = y;
      this.setTotalDuration(2000);
      this.Velocidade = 0.1;
    }

    public void perseguirJogador(double x,double y) {

     if (this.x > x && this.y <= y + 50 && this.y >= y - 50) {

           moveTo(x,y,Velocidade);
       
          if (Direcao != 1) {
              setSequence(3,6);
              Direcao = 1;
           }
              Movendo = true;
               
     } else if (this.x < x && this.y <= y + 50 && this.y >= y - 50) {

             moveTo(x,y,Velocidade);
             
             if (Direcao != 2) {
                 setSequence(7,9);
                 Direcao = 2;
             }
             
            Movendo = true;
     } else if (this.y > y) {

        moveTo(x,y,Velocidade);
        if (Direcao != 4) {
            setSequence(10,12);//para cima 
            Direcao = 4;
        }
              Movendo = true;
     } else if (this.y < y) {
            
        moveTo(x, y, Velocidade);//função que erda de sprites 
        
        if (Direcao != 5) {
           setSequence(1,3);//para baixo
           Direcao = 5;
        }
         Movendo = true;
   }
         if (Movendo) {
             update();
             Movendo = false;
        }
    }

   public void morrerInimigo() {

        if (energiaInimigo <= 0) {// se a energia do zumbi for menor do que zero ele morrer e zera todos
            //seus paramentro.
            Velocidade = 0;
            AtaqueDoInimigo = 0;
            Direcao = 0;
            Movendo = false;
            this.x = 1_0000_000;//joga-se o inimigo para fora do jogo.
        }
    }

    public void atacar(Jogador jogador) {// se o INIMIGO colide com o jogador a energia do jogador diminuir do valor de cada ataque do zumbi.

        if (this.collided(jogador)) {
           Jogador.Energia -= AtaqueDoInimigo;
        }
    }
}
    

