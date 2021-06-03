import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Main extends JFrame {
	public static void main(String[] args) {
		int n = 10;
		int numero = (int) (Math.random() * n) + 1;
        System.out.println(numero);

        String[] cadena = new String[3];
        
        Main ma = new Main();
        ma.menu();
	}

	public void menu(){
		String Columna = JOptionPane.showInputDialog(null, "Nombre de la Columna");

		String[] TipoDato = {
			"Integer", 
			"Varchar", 
			"Boolen", 
			"Date" 
		};
		String resp = (String) JOptionPane.showInputDialog(null, "Tipo de dato", "Dato", 
			JOptionPane.DEFAULT_OPTION, null, TipoDato, TipoDato[1]);
	}
}