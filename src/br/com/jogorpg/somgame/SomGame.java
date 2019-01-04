package br.com.jogorpg.somgame;

import jplay.Sound;
import jplay.URL;

public class SomGame {

    private static Sound musica; // variavel de som estatica

    public static void play(String audio) {

        stop(); // vai para o som caso tenhamos uma trasição de senario e tenha que troca o som para não da erro
        musica = new Sound(URL.audio(audio)); //estanciando o objeto audio e passando o parametro audio com o nome da musica
        SomGame.musica.play(); //chamando a propria função musica dentro da função musica
        SomGame.musica.setRepeat(true);// repetindo o som caso ele acabe.
    }

    public static void stop() {

        if (SomGame.musica != null) {
            musica.stop();
        }
    }
}
