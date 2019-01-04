package br.com.jogorpg.menu;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class TelaInicio{

    private Window    Janela = new Window(800,600); 
    private Keyboard  Teclado = Janela.getKeyboard();   
    private GameImage Fundo = new GameImage(URL.sprite("TelaInicial.png"));
    private Menu Menu;
    
    public void Janela(){
        
    boolean Condicao = true; 
    
     while (Condicao) {
      Fundo.draw();
        if (Teclado.keyDown(Keyboard.ENTER_KEY)) {
                Condicao = false;
                Menu = new Menu (Janela);
                Menu.Janela();
        }
           Janela.update();
     }
    }
}
