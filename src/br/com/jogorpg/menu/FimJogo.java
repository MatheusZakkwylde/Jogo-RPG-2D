
package br.com.jogorpg.menu;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;


public class FimJogo {
    private Window Janela;
    private Keyboard Teclado;
    private GameImage Fundo = new GameImage(URL.sprite("Fim.png"));
    private Menu Menu;
    boolean condicao = true;
    
    public FimJogo(Window janela) {
       Janela = janela;   
       Teclado = Janela.getKeyboard();
    }
    
    public void janela (){
      while (condicao){
        
            Fundo.draw();
            if (Teclado.keyDown(Keyboard.ENTER_KEY)){
                 condicao = false;
                 Menu = new Menu (Janela);
                 Menu.Janela();
            }
            Janela.update();
      }
    }
    
}
