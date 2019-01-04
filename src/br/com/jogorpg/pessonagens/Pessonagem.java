package br.com.jogorpg.pessonagens;

import br.com.jogorpg.controleTile.ControleTile;
import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Pessonagem extends Sprite {

    protected int  Direcao = 0;
    public double  Velocidade = 1;
    public boolean Movendo = false;

    public Pessonagem(String fileName, int numFrames) {
        super(fileName, numFrames);
    }

   ControleTile controleTile = new ControleTile();

    public void caminhoPecorer(Scene cena) {
        
     Point mim = new Point((int) this.x, (int) this.y);
     Point max = new Point((int) this.x + this.width, (int) this.y + this.height);

     Vector<?> tiles = cena.getTilesFromPosition(mim, max);
        
        for (int i = 0; i < tiles.size(); i++) {
         TileInfo tile = (TileInfo) tiles.elementAt(i);

          if (controleTile.colisao(this, tile) == true) {
            if (colisaoVertical(this, tile)) {
              if (tile.y + tile.height - 2 < this.y) {
                      this.y = tile.y + tile.height;
                    
              } else if (tile.y > this.y + this.height - 2) {
                   this.y = tile.y - this.height;
               }
            }

                if (colisaoHorizontal(this, tile)) {
                 if (tile.x > this.x + this.width - 2) {
                   this.x = tile.x - this.width;
                 } else {
                        this.x = tile.x + tile.width;
                    }
                }
            }
        }
    }

    private boolean colisaoVertical(GameObject pessonagem, GameObject cenarioTile) {
        
     if (cenarioTile.x + cenarioTile.width <= pessonagem.x) {
        return false;
     }
     if (pessonagem.x + pessonagem.width <= cenarioTile.x) {
         return false;
     } 
     return true;
    }

    private boolean colisaoHorizontal(GameObject pessonagem, GameObject cenarioTile) {

        if (cenarioTile.y + cenarioTile.height <= pessonagem.y) {
            return false;
        }
        if (pessonagem.y + pessonagem.height <= cenarioTile.y) {
            return false;
        }
        return true;
    }
}
