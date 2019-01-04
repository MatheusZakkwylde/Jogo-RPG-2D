
package br.com.jogorpg.cenario;
import br.com.jogorpg.bancoDados.GerenciamentoBanco;
import br.com.jogorpg.menu.Configuracao;
import br.com.jogorpg.menu.FimJogo;
import br.com.jogorpg.menu.Menu;
import br.com.jogorpg.menu.MenuJogador;
import br.com.jogorpg.menu.Ranking;
import br.com.jogorpg.pessonagens.Inimigo;
import br.com.jogorpg.pessonagens.Jogador;
import br.com.jogorpg.somgame.SomGame;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario{

    private Window    Janela;
    private Keyboard  Teclado;
    private Scene     Cena;
    private Jogador   Jogador;
    private Menu      Menu;
    private Configuracao configuracao;
    private Ranking Ranking;
    private FimJogo FimJogo;
    private Inimigo   InimigoVector[];
    private String NomeUsuario;
    private int Aleatoriosx [];
    private int Aleatoriosy [];
    private int valor,i = 0,f = 0;
    private boolean condicao = true;
    private GerenciamentoBanco Gerenciador;
    private int pontuacao;
  
    
    
    public Cenario(Window janela,String Nomecena,String nomeJogador,String nomeUsuario,String SomCena,
                   int numFrameJogador,int quantInimigo) {

       Janela = janela;
        Teclado = Janela.getKeyboard();
         Cena = new Scene();
         Cena.loadFromFile(URL.scenario(Nomecena));
              Aleatoriosx = new int [quantInimigo];
                Aleatoriosy = new int [quantInimigo];
                  InimigoVector = new Inimigo[quantInimigo];
                    Jogador = new Jogador(nomeJogador,numFrameJogador);
                     FimJogo = new FimJogo (Janela);
                       NomeUsuario = nomeUsuario;
                       
                          if (Configuracao.opcao){
                           SomGame.play(SomCena);
                          }else {
                           SomGame.stop();
                          }
                            GerandoNumerosx ();
                            GerandoNumerosy ();
                            run();
    }

   public void run() {
        
   for (int indice = 0; indice < InimigoVector.length;indice++){
     InimigoVector[indice] = new Inimigo(i* Aleatoriosx[indice],i* Aleatoriosy [indice]);
   }
     distaniciaInimigo();
     
        while (condicao) {
          
            Jogador.caminhoPecorer(Cena);
            Jogador.controleJogador(Janela,Teclado);
            Cena.moveScene(Jogador);
            Jogador.x += Cena.getXOffset();
            Jogador.y += Cena.getYOffset();
            Jogador.draw();
            Jogador.energiajogador(Janela);

                for (int c = 0; c < InimigoVector.length; c++) {

                    InimigoVector[c].caminhoPecorer(Cena);
                    InimigoVector[c].perseguirJogador(Jogador.x, Jogador.y);
                    InimigoVector[c].x += Cena.getXOffset();
                    InimigoVector[c].y += Cena.getYOffset();
                    Jogador.atirar(Cena,Teclado,InimigoVector[c]);
                    InimigoVector[c].morrerInimigo();
                    InimigoVector[c].atacar(Jogador);
                    InimigoVector[c].draw();
                }
                     menuCenario();
                     fimJogo ();   
                    Janela.update();
        }
    }
    
    private final void GerandoNumerosx (){
        
     valor = 20 + ((int)(1 + Math.random() * (InimigoVector.length-1+1)));
       Aleatoriosx [i] = valor;
         for (i = 1; i < InimigoVector.length; i++) {
           valor = ((int)(1 + Math.random() * (InimigoVector.length-1+1)));
             Aleatoriosx [i] = valor; 
               for (int j = 0; j < i;j++){
                   if (Aleatoriosx [j] == Aleatoriosx[i] || Aleatoriosx[i] > Janela.getWidth() - 100){
                         i--; 
                   }
              }
        }
    }
    private final void GerandoNumerosy (){
     valor = 20 + ((int)(1 + Math.random() * (InimigoVector.length-1+1)));
       Aleatoriosy [f] = valor;
         for (f = 1; f < InimigoVector.length; f++) {
           valor = ((int)(1 + Math.random() * (InimigoVector.length-1+1)));
             Aleatoriosy [f] = valor; 
               for (int j = 0; j < f;j++){
                   if (Aleatoriosy [j] == Aleatoriosy[f] || Aleatoriosy [f] > Janela.getHeight() - 500 ){
                         f--; 
                   }
              }
        }
    }
      
    private final void distaniciaInimigo(){
        int Distancia;
        for (int c = 0; c < InimigoVector.length;c++){
            for (int l = 1;l < InimigoVector.length;l++){
               Distancia = (int)Math.sqrt(Math.pow((InimigoVector[l].x - InimigoVector[c].x),2) + 
                                          Math.pow((InimigoVector[l].y - InimigoVector[c].y),2));
               if (Distancia <= 40){
                   InimigoVector [l].x +=100;
                   InimigoVector [l].y +=100;
               }
            }
        }
    }
    
  private final void menuCenario (){
      
  if ( Teclado.keyDown(KeyEvent.VK_M) ){
       JOptionPane.showMessageDialog (null,"                   Menu\n"+
                                           "               Novo jogo - D\n"+
                                           "          Configurações - S\n"+
                                           "                    Sair - ESC\n");
               }
  if (Teclado.keyDown(Keyboard.D_KEY)){
       condicao = false; 
       banco();
       //Jogador.Energia = 6000;
       Menu = new Menu (Janela);
       Menu.Janela();
  }
  if (Teclado.keyDown(Keyboard.S_KEY)){
       configuracao = new Configuracao (Janela);
       configuracao.Janela();
  }
  if (Teclado.keyDown(Keyboard.ESCAPE_KEY)){
       banco();
      Janela.exit();
  }
 }
  private final void fimJogo(){
      if (Jogador.Energia <= 0){
           condicao = false;
           banco();
           FimJogo.janela();
      }
  }
  private final void banco (){
    pontuacao = (int) Jogador.Energia;
    Ranking = new Ranking (Janela,MenuJogador.NomeUsuario,pontuacao);
    //Gerenciador.inserindoDados(Ranking);
  }
  
}