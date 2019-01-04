package br.com.jogorpg.menu;

import br.com.jogorpg.pessonagens.Jogador;
import br.com.jogorpg.somgame.SomGame;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class Menu{
       
  private Window       Janela;
  private Keyboard     Teclado;
  private Historia     Historia;
  private Ranking ranking;
  private Configuracao ConfiguracaoMenu;
  private GameImage Fundo    = new GameImage(URL.sprite("Fundo.png"));
  private Sprite    Jogo = new Sprite (URL.sprite("jogo.png"),2);
  private Sprite    Ranking  = new Sprite (URL.sprite("Ranking.png"),2);
  private Sprite    configuracao =  new Sprite (URL.sprite("Configurações.png"),2);
  private Sprite    Sair =          new Sprite (URL.sprite("Sair.png"),2);
  private int Opcao = 1;
  
   public Menu (Window janela){ 
    Janela = janela;
    Teclado = Janela.getKeyboard();
    
     if (Configuracao.opcao){
         SomGame.play("EntroduçãoMedieval.wav");
     }else {
         SomGame.stop();
     }
   }
   
public void Janela(){
 
 boolean  Condicao = true;
 
  while (Condicao) {
      
     if (Teclado.keyDown(Keyboard.ENTER_KEY)){
           Condicao = false;
           switch (Opcao){
              case 1:
                       Historia = new Historia (Janela);
                       Historia.Janela();
                   break;
              case 2:
                       int pontuacao = 0;
                       String nome = null;
                       ranking = new Ranking (Janela,MenuJogador.NomeUsuario, (int) Jogador.Energia);
                       ranking.Janela();
                    break;
              case 3 :  
                       ConfiguracaoMenu = new Configuracao (Janela);
                       ConfiguracaoMenu.Janela();
                    break;
              case 4 :
                           Janela.exit();
                    break;
           }
       }
                    botao ();
                    Fundo.draw();
                    Jogo.draw();
                    Ranking.draw();
                    configuracao.draw();
                    Sair.draw();
                   Janela.update();
     }
   }
   
   private void botao (){
       
     Jogo.x = 310;configuracao.x = 200; Ranking.x = 270;
     Jogo.y = 310;configuracao.y = 460; Ranking.y = 380;
                Sair.x = 320; Sair.y = 530;
     
      if (Teclado.keyDown(Keyboard.A_KEY)){
          if (Opcao > 0 && Opcao < 4){
                Opcao+= 1;
          }else{
            Opcao = 1;
         }somclick();
      }
    
        if (Opcao == 1){
            Jogo.setCurrFrame(1);
        }else {
           Jogo.setCurrFrame(0);
        }
    
         if (Opcao == 2){
             Ranking.setCurrFrame(1);
        }else {
             Ranking.setCurrFrame(0);
        }
         
        if (Opcao == 3){
            configuracao.setCurrFrame(1);
        }else {
            configuracao.setCurrFrame(0);
       }
        
       if (Opcao == 4){
          Sair.setCurrFrame(1);
      }else {
          Sair.setCurrFrame(0);
      }
    
   }
   
  private final void somclick() {
    if (Configuracao.opcao){
       new Sound(URL.audio("click.wav")).play();
    }else {
       new Sound(URL.audio("click.wav")).stop();
    }
  }
}

   
    