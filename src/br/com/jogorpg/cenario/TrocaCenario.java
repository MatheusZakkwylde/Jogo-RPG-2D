
package br.com.jogorpg.cenario;

import br.com.jogorpg.pessonagens.Jogador;
import jplay.GameObject;
import java.awt.Point;
import java.util.Vector;
import jplay.Scene;
import jplay.TileInfo;

public abstract class TrocaCenario {

    protected boolean colisaoComTiles(int value, Jogador jogador, Scene cena) {

        Point min = new Point((int) jogador.x, (int) jogador.y);//PEGANDO O TAMANHO DO JOGADOR MINIMO
        Point max = new Point((int) (jogador.x + jogador.width), (int) (jogador.y + jogador.height));//PEGANDO O TAMANHO DO JOGADOR MAXIMO
        
        Vector<?> Tiles = cena.getTilesFromPosition(min, max); //VETOR TILES RECEBE AS POSIÇÕES DO JOGADOR NA CENA

        for (int i = 0; i < Tiles.size(); i++) {

            TileInfo tile = (TileInfo) Tiles.elementAt(i); //TILE RECEBE OS ELEMENTOS DOS INDICES DO VETOR TILES

            if (colidio(jogador, tile, value) == true) {// SE O JOGADOR COLIDIR COM TILE 4 RETURN TRUE
                return true;
            }// A CLASSE É ABISTRATA POR QUE ELA NÃO PODE SER ESTANCIADA DIRETAMENTE
        }
        return false;
    }

    private boolean colidio(GameObject pessonagem, TileInfo tile, int valorTile) {
        
        if ((tile.id == valorTile) && pessonagem.collided(tile)) {// SE O INDICE DO TILE FOR IGUAIL A VALOR E O OBJETO COLIDIR COM ELE
            
            return true;//RETURN VERDADEIRO 
        }
        return false;

    }// esse metodo vai retorna true se os tiles forem pecoriveis 

    
}
