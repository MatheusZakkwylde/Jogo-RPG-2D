
package br.com.jogorpg.menu;
import br.com.jogorpg.bancoDados.Dados;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Ranking implements java.io.Serializable {
    
   private transient Window Janela;
   private transient Keyboard Teclado;
   private transient Menu Menu;
   private transient boolean Condicao = true;
   private transient GameImage Fundo = new GameImage(URL.sprite("TelaRanking.png"));
   private transient Font fonte = new Font("Times New Roman",Font.BOLD,50);
   private transient Dados Dados;
   private transient Dados Dados1 = new Dados ("Jeferson",5000);
   private transient Dados Dados2 = new Dados ("Daline",8000);
   
   ArrayList <Dados> dadosJogo = new ArrayList<>();
  
    
    public Ranking(Window janela, String NomeJogador,int pontuacao) {
        Janela = janela;
        Teclado = Janela.getKeyboard();
        if (NomeJogador != null && pontuacao != 0){
          Dados = new Dados (NomeJogador,pontuacao);
        }
        dadosJogo.add(Dados);
        dadosJogo.add(Dados1);
        dadosJogo.add(Dados2);
        Collections.sort(dadosJogo);
    }

    
    public void Janela (){
        
        while (Condicao){
            if (Teclado.keyDown(Keyboard.ENTER_KEY)){
                Menu = new Menu (Janela);
                Menu.Janela();
            }
             
           Fundo.draw();
           Janela.drawText(""+dadosJogo.get(0).getNomeUsuario()+" - "+dadosJogo.get(0).getPontuacao(),380,285,Color.WHITE,fonte);
           Janela.drawText(""+dadosJogo.get(1).getNomeUsuario()+" - "+dadosJogo.get(1).getPontuacao(),380,370,Color.WHITE,fonte);
           Janela.drawText(""+dadosJogo.get(2).getNomeUsuario()+" - "+dadosJogo.get(2).getPontuacao(),380,465,Color.WHITE,fonte);
           Janela.update();
        }
   
    }
}
