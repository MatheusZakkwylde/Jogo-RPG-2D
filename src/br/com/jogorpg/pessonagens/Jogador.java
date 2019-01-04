
package br.com.jogorpg.pessonagens;

import br.com.jogorpg.pessonagens.tiro.ControleTiro;
import java.awt.Color;
import java.awt.Font;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Jogador extends Pessonagem{
   
  Font fonte = new Font("Times New Roman",Font.CENTER_BASELINE,30);  
  ControleTiro Tiros = new ControleTiro();
  
  public static double Energia = 6000;
  private int FrameDirecao = 0;
  
     public Jogador(String nomeJogador, int numFrame) {
         super(URL.sprite(nomeJogador),numFrame);
         this.x = 640;
         this.y = 410; 
         this.setTotalDuration(2000);
     }
     
     public void energiajogador(Window janela){
        janela.drawText("[ Vida "+Energia+" ]",30,30,Color.BLACK,fonte);
     }
     
    public void controleJogador(Window Janela, Keyboard Teclado){ 

        if (Teclado.keyDown(Keyboard.LEFT_KEY) && x > 0) {//PARA ESQUERDA
             this.x -= Velocidade;
                  if (Direcao != 1){
                      Direcao = 1;
                  }   Movendo = true;
        }else if (Teclado.keyDown(Keyboard.RIGHT_KEY)&& x < Janela.getWidth() - 60){//PARA ESQUERDA
            this.x += Velocidade;
                 if (Direcao != 2) {
                     Direcao = 2;
                 }   Movendo = true;
        } else if (Teclado.keyDown(Keyboard.UP_KEY) && y > 0) { //PARA CIMA
             this.y -= Velocidade;
                if (Direcao != 3) {
                    Direcao = 3;
                }   Movendo = true;
        } else if (Teclado.keyDown(Keyboard.DOWN_KEY) && y < Janela.getHeight() - 60) { //PARA BAIXO
             this.y += Velocidade;
               if (Direcao != 4) {
                   Direcao = 4;
                }  Movendo = true;
        }
 }

    public void atirar(Scene cena,Keyboard Teclado,Inimigo inimigo) {
       
        if (Teclado.keyDown(Keyboard.A_KEY)) {
            Tiros.adicionaTiro(this.x + 15,this.y + 30,Direcao,cena);
            switch (Direcao) {
                case 1:
                    if (FrameDirecao != 1){
                        setSequence(21,24);
                        FrameDirecao = 1;
                    }   Movendo = true;
                    break;
                case 2:
                    if (FrameDirecao !=2){
                        setSequence(25,28);
                        FrameDirecao = 2;
                    }   Movendo = true;
                    break;
                case 3:
                    if (FrameDirecao != 3){
                        setSequence(29,32);
                        FrameDirecao = 3;
                    }   Movendo = true;
                    break;
                case 4:
                    if (FrameDirecao != 4){
                        setSequence(16,20);
                        FrameDirecao = 4;  
                    }   Movendo = true;
                    break;
            }
        }else if (Teclado.keyDown(Keyboard.LEFT_KEY)){
              if (FrameDirecao != 5){
                  setSequence(4,8);
                  FrameDirecao = 5;
              }
                  Movendo = true;
        }else if (Teclado.keyDown(Keyboard.RIGHT_KEY)){
              if (FrameDirecao != 6){
                  setSequence(9,12);
                  FrameDirecao = 6;
              } 
                 Movendo = true;
        }else if (Teclado.keyDown(Keyboard.UP_KEY)){
              if (FrameDirecao != 7){
                  setSequence(13,16);
                  FrameDirecao = 7;
              }
               Movendo = true;
        }else if (Teclado.keyDown(Keyboard.DOWN_KEY)){
              if (FrameDirecao != 8){
                  setSequence(0,4);
                  FrameDirecao = 8;
             }
        }
                  if (Movendo) {
                       update();
                      Movendo = false;
                 }
            Tiros.run(inimigo);       
    }
}




