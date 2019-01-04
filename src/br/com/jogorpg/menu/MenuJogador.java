package br.com.jogorpg.menu;
import br.com.jogorpg.cenario.PrimeiraCena;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class MenuJogador{

    private Window    Janela;
    private Keyboard  Teclado;
    private PrimeiraCena cena;
    private GameImage Fundo = new GameImage(URL.sprite("TelaFundo.png"));
    private Sprite    Jogadores = new Sprite (URL.sprite("Jogadores.png"),2);
    private boolean   Opcao = false;
    private boolean   Condicao = true;
    private String    NomeJogador = "Alice.png";
    public static  String    NomeUsuario;
    
    public MenuJogador(Window janela) {
     Janela = janela;
     Teclado = janela.getKeyboard();
     Jogadores.x = 270;
     Jogadores.y = -30;
    }

    public void OpcaoJogador(){
     
     while (Condicao) {
         
       if (Teclado.keyDown(Keyboard.A_KEY)){      
         if (Opcao == true){      
             Jogadores.setCurrFrame(0);
             NomeJogador = "Alice.png";
             Opcao = false;
         }else{
             Jogadores.setCurrFrame(1);
             NomeJogador = "Joh Insnol.png";
             Opcao = true;
         }somclick();
       } 
    
       if (Teclado.keyDown(Keyboard.ENTER_KEY)) {
           Condicao = false;
           NomeUsuario = JOptionPane.showInputDialog ("Digite o nome do seu jogador (Opcional)");
           cena = new PrimeiraCena (Janela,NomeJogador,NomeUsuario);
       }
              Fundo.draw();
              Jogadores.draw();
              Janela.update();
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
