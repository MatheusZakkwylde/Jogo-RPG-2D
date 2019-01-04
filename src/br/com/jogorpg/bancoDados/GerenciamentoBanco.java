
package br.com.jogorpg.bancoDados;

import br.com.jogorpg.menu.Ranking;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciamentoBanco {
     
    public void inserindoDados ( Ranking dados){
        
        try {
           FileOutputStream URLArquivo = new FileOutputStream ("C:\\Users\\Usuario\\Pictures\\JOGO RPG\\src\\Recursos\\Banco\\BancoDados.txt");//pegando o caminho do arquivo
               try {
                     ObjectOutputStream EntradaBanco = new ObjectOutputStream (URLArquivo); //banco
                     EntradaBanco.writeObject (dados);
                     EntradaBanco.close();
               } catch (IOException ex) {
                   Logger.getLogger(GerenciamentoBanco.class.getName()).log(Level.SEVERE, null, ex);
               }
       } catch (FileNotFoundException ex) {
              Logger.getLogger(GerenciamentoBanco.class.getName()).log(Level.SEVERE, null, ex);
       }   
    }
    
    public void inicializandoDados (Ranking dados){
        try {
           FileInputStream UrlArquivo = new FileInputStream ("C:\\Users\\Usuario\\Pictures\\JOGO RPG\\src\\Recursos\\Banco\\BancoDados.txt");//pegando o caminho do arquivo
              try {
                      ObjectInputStream SaidaBanco = new ObjectInputStream (UrlArquivo);
                      try {
                           Ranking Dados = (Ranking)SaidaBanco.readObject();
                       } catch (ClassNotFoundException ex) {
                          Logger.getLogger(GerenciamentoBanco.class.getName()).log(Level.SEVERE, null, ex);
                      }
              } catch (IOException ex) {
                   Logger.getLogger(GerenciamentoBanco.class.getName()).log(Level.SEVERE, null, ex);
              }
       } catch (FileNotFoundException ex) {
          Logger.getLogger(GerenciamentoBanco.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
