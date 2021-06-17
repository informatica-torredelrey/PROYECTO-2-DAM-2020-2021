/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import ProgramaPrincipal.Login;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
//Clase para el icono
public class Utilidades {
    
    //Para poner un icono en las pantallas
    public static Image ponerIcono() {
        Image img = null;
        try {
            img = ImageIO.read(Utilidades.class.getResourceAsStream("/Recursos/icon.png"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }
    
    //Genera un codigo aleatorio
    public static String generaCodigo() {
        String mayusculas="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String minusculas="abcdefghijklmnopqrstuvwxyz";
	String numeros="1234567890";
        
        StringBuilder sb=new StringBuilder("");
        
        for(int x=0;x<9;x++) {
            int aleatorio=(int)(Math.random()*3)+1;
			
            switch(aleatorio) {
		case 1:
                    int aleatorioMay=(int)(Math.random()*mayusculas.length());
                    sb.append(mayusculas.charAt(aleatorioMay));
                    break;
		case 2:
                    int aleatorioMin=(int)(Math.random()*minusculas.length());
                    sb.append(minusculas.charAt(aleatorioMin));
                    break;
                case 3:
                    int aleatorioNum=(int)(Math.random()*numeros.length());
                    sb.append(numeros.charAt(aleatorioNum));
                    break;
		}
	}
        
        return sb.toString();
    }
    
    //Genera un fichero
    public static void generaFichero(String codigo) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream("codigo.txt");
        fos.write(codigo.getBytes());
        fos.flush();
        fos.close();
    }
    
}
