
package br.com.jogorpg.menu;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Historia {
    
    private Window Janela;
    private Keyboard Teclado;
    private MenuJogador Menu;
    private GameImage Fundo = new GameImage(URL.sprite("Historia.png"));
    private boolean condicao = true;
    
    public Historia(Window janela) {
        Janela = janela;
        Teclado = Janela.getKeyboard();
    }
    
    public void Janela (){
        
        while (condicao){
            Fundo.draw();
            if (Teclado.keyDown(Keyboard.ENTER_KEY)){
                condicao = false;
                Menu = new MenuJogador (Janela);
                Menu.OpcaoJogador();
            }
            Janela.update();
        }
    }
    
}
