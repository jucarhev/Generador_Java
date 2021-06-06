/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author carlos
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Generador gen = new Generador();
        gen.menu();
    }
    
    public void menu(){
        String Columna = JOptionPane.showInputDialog(null, "Nombre de la Columna");
        
        String[] Lista = {
            "Email", 
            "Random", 
            "Password", 
            "Code", 
            "Telephone", 
            "Boolean", 
            "Date", 
            "Fusion", 
            "Entre"
        };
        
        String tipolista = (String) JOptionPane.showInputDialog(null, "Tipo de dato", "Dato", 
            JOptionPane.DEFAULT_OPTION, null, Lista, Lista[1]);
        
         String Configuraciones = JOptionPane.showInputDialog(null, "Configuracion");

        String[] TipoDato = {
            "Integer", 
            "Varchar", 
            "Boolen", 
            "Date" 
        };
        String typedato = (String) JOptionPane.showInputDialog(null, "Tipo de dato", "Dato", 
            JOptionPane.DEFAULT_OPTION, null, TipoDato, TipoDato[1]);
        
        data(Columna,tipolista,Configuraciones,typedato);
    }
    
    public void data(String col, String lista, String config, String dato){
       System.out.println(col + " " + lista+ " " +config+" "+ dato);
       System.out.println(col +"="+ convertItoS(generarRandom(config)) ); 
    }
    
    public int generarRandom(String Configuracion){
        String [] vect = Configuracion.split(",");
        int numero = ThreadLocalRandom.current().nextInt(convertStoI(vect[0]), convertStoI(vect[1]) + 1);
        return numero;
    }
    
    public int convertStoI(String numero){
        int varI = Integer.parseInt(numero);
        return varI;
    }
    
    public String convertItoS(int numero){
        return numero+"";
    }
    
}
