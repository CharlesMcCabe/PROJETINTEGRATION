package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) throws IOException {
ArrayList<String> symboles = new ArrayList<>();
symboles.add("AAPL");
            ActionsJson actions = new ActionsJson(symboles);
            actions.getActionsJson();

        }
        public static ArrayList<String> faireListeSymboles(String nomFichier){
            ArrayList<String> symboles = new ArrayList<>();
            try {
                BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
              String ligne = lecteur.readLine();
              while(ligne != null){
                  symboles.add(ligne);
                  ligne = lecteur.readLine();
              }
            }catch(FileNotFoundException e){
               e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
            return symboles;
        }
    }