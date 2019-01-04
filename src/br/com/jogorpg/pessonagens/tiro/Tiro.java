package br.com.jogorpg.pessonagens.tiro;

import jplay.Sprite;
import jplay.URL;

public class Tiro extends Sprite {

    protected static final int LEFT = 1,RIGHT = 2,UP = 3,DOWN = 4;
    protected static final float   VelocidadeTiro = (float) 00.1;
    protected              int     Caminho = 0;
    protected              int     Direcao = 0;
    protected              boolean Movendo = false;
  
    public Tiro(double x,double y,int direcao) {
        
        super(URL.sprite("flecha.png"),12);
        Caminho = direcao;
        this.x = x;
        this.y = y;
    }

    public void TiroMover() {

     if (Caminho == LEFT){
       this.x -= VelocidadeTiro;
          if (Direcao != 1) {
           setSequence(3,6);
          }
           Movendo = true;
     }
     if (Caminho == RIGHT) {
       this.x += VelocidadeTiro;
          if (Direcao != 2) {
             setSequence(6,9);
           }
               Movendo = true;
     }
     if (Caminho == UP) {
       this.y -= VelocidadeTiro;
         if (Direcao != 4) {
            setSequence(9,12);
         }
       Movendo = true;
    }
    if (Caminho == DOWN || Caminho == 0) {
      this.y += VelocidadeTiro;
        if (Direcao != 5) {
            setSequence(0,3);
        }
            Movendo = true;
    }

         if (Movendo) {
             update();
           Movendo = false;
         }
   }
}
