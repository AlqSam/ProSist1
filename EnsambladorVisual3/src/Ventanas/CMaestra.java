package Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

/**
 * @author Leonardo D. Gtz. Medellin.
 * Clase principal 
 * 
 * 
 * */

public class CMaestra {

	public static void main(String[] args) {
		
		CMaestra sl = new CMaestra();
		String t = sl.Select();
		Clasificar cf = new Clasificar();
		cf.Divide(t);
		System.out.println(t);	
	
		
	}
	/**
	 * Se carga un archivo atravez de la clase JfileChooser
	 * 
	 * */
	private String Select(){
		
		File f;
		JFileChooser j = new JFileChooser();
		j.showOpenDialog(j);
		String rout = j.getSelectedFile().getAbsolutePath();
		
		String read="";
		
		f= new File(rout);
		
		/**Si en la lectura en cuentra un end suspende la carga del archivo */
		try{
			
			FileReader fr =new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String aux;
			
			while((aux=br.readLine())!=null)
			{
				if(aux.equalsIgnoreCase("end")){
					read= read+"\t"+aux+"\n";	
					break;				
			}else
				read=read+aux+"\n";
			}
			br.close();
			fr.close();
			
		}catch(IOException e){
			
		System.out.print("Error de apertura  de archivo.");
				}
		
			return read;
	}

}
