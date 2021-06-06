package Consola;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author carlos
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    
    String[] Vocals = {"A","E","I","O","U"};
    String[] Consonant = {"B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
    String[] Alphabet = {"A","E","I","O","U","B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
    String[] Numbers = {"1","2","3","4","5","6","7","8","9","0"};
    String[] extensiones = {"@gmail.com","@outlook.com"};
    
    Calendar unaFecha;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Generador gen = new Generador();
        gen.menu();
    }
    
    // @Funcion de tetting
    public void test(){
        
    }
    
    public void menu(){
        String Columna = JOptionPane.showInputDialog(null, "Nombre de la Columna");
        
        String[] Lista = {"Email","Random","Password","Code","Telephone","Boolean","Date","Fusion","Entre"};
        
        String tipolista = (String) JOptionPane.showInputDialog(null, "Tipo de dato", "Dato", 
            JOptionPane.DEFAULT_OPTION, null, Lista, Lista[1]);
        
         String Configuraciones = JOptionPane.showInputDialog(null, "Configuracion");

        String[] TipoDato = {"Integer", "Varchar", "Boolen", "Date" };
        String typedato = (String) JOptionPane.showInputDialog(null, "Tipo de dato", "Dato", 
            JOptionPane.DEFAULT_OPTION, null, TipoDato, TipoDato[1]);
        
        data(Columna,tipolista,Configuraciones,typedato);
    }
    
    public void data(String col, String lista, String config, String dato){
       System.out.println(col + " " + lista+ " " +config+" "+ dato);
       
       //System.out.println(col +"="+ convertItoS(generarRandom(config)) ); 
       
       if(lista =="Email"){
           JOptionPane.showMessageDialog(null, generarEmail( convertStoI(config) ));
       }
    }
    
    public String generarEmail(int number){
        String cadena = "";
        for (int i = 0; i < (number/2); i++) {
            cadena += DataRandomFromArray(Consonant);
            cadena += DataRandomFromArray(Vocals);
        }
        cadena+=DataRandomFromArray(extensiones);
        System.out.println(cadena);
        return cadena;
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
    
    public String convertMtoC(String palabra, String reversa){
        String cadena="";
        if(reversa == "mayusculas"){
            cadena = palabra.toUpperCase();
        }else if(reversa == "minusculas"){
            cadena = palabra.toLowerCase();
        }
        return cadena;
    }
    
    public String DataRandomFromArray(String[] array){
        int numero = ThreadLocalRandom.current().nextInt( 0, array.length );
        return array[numero];
    }
    
    public String generarCode(int cantidad, String tipo){
        String cadena="";
        for (int i = 0; i <(cantidad/2); i++) {
            if(tipo=="Number"){
                cadena += DataRandomFromArray(Numbers);
                cadena += DataRandomFromArray(Numbers);
            }else if(tipo=="Letters"){
                cadena += DataRandomFromArray(Alphabet)+DataRandomFromArray(Alphabet);
            }else if(tipo=="Mixto"){
                String[] array = arrayFusion(Alphabet,Numbers);
                cadena += DataRandomFromArray(array)+DataRandomFromArray(array);
            }
        }
        
        return cadena;
    }
    
    public String[] arrayFusion(String[] array1, String[] array2){
        String[] nuevo = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, nuevo, 0, array1.length);
        System.arraycopy(array2, 0, nuevo, array1.length, array2.length);
        
        return nuevo;
    }
    
    public String generarFecha() {
        int numero = 0;
        Random aleatorio;
        aleatorio = new Random();

        unaFecha = Calendar.getInstance();
        unaFecha.set (aleatorio.nextInt(10)+2014, aleatorio.nextInt(12)+1, aleatorio.nextInt(30)+1);
        
        Date myDate = new Date();
        
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(myDate);
        return fecha;
    }
    
}
