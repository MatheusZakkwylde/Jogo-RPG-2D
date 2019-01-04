
package br.com.jogorpg.cenario;

import jplay.Window;

public class PrimeiraCena extends Cenario{
    
    public PrimeiraCena(Window janela,String nomeJogador,String NomeUsuario) {
        super(janela,"Cena1.scn",nomeJogador,NomeUsuario,"SomFundoCena_01.wav",32,50);
    } 
}

/*    private void mudarCenario() {

        if (tileCollision(4,jogador,cena) == true) {
            SomGame.stop();
            new Cenario2(janela);
        }
    }*/

