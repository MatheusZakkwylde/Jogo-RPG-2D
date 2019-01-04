package br.com.jogorpg.controleTile;

import jplay.GameObject;
import jplay.TileInfo;

public class ControleTile {

    public boolean colisao(GameObject obj, TileInfo tile) {
        if ((tile.id >= 189) && obj.collided(tile)) {
            return true;
        }
        return false;
    }
}
