package br.com.jogorpg.menu;

import java.awt.event.KeyEvent;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Configuracao {

    private Window Janela;
    private Keyboard Teclado;
    private Menu Menu;
    private GameImage Fundo = new GameImage(URL.sprite("configuracao.png"));
    private boolean Condicao = true;
    private boolean troca = true;
    private boolean trocaSom = true;
    public static boolean opcao = true;

    public Configuracao(Window janela) {
        Janela = janela;
        Teclado = Janela.getKeyboard();
    }

    public void Janela() {

      while (Condicao) {
          
         if (Teclado.keyDown(KeyEvent.VK_D)){
             if (troca) {
                Janela.setFullScreen();
                troca = false;
         } else {
                Janela.restoreScreen();
                troca = true;
         }
       }else if (Teclado.keyDown(Keyboard.S_KEY)){
                 if (opcao) {
                     opcao = false;
                 } else {    
                      opcao = true;
                  }
       }else if (Teclado.keyDown( Keyboard.ENTER_KEY)){
              Condicao = false;
              Menu = new Menu (Janela); 
              Menu.Janela();
       }
               Fundo.draw();
               Janela.update();
        }  
    }
}
    

