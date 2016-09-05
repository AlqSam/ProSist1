package Ventanas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Leonardo D. Gtz. Medellin.
 * Clase principal 
 * 
 * 
 * */

public class CMaestra {
	public String rout;
	public String result;
	public void CargaArchivo(){
		
		File f;
		JFileChooser j = new JFileChooser();
		j.showOpenDialog(j);
		 rout = j.getSelectedFile().getAbsolutePath();
		
		String read="";
		
		f= new File(rout);
		

		try{
			
			FileReader fr =new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String aux;
			
			while((aux= br.readLine())!=null)
			{
				if(aux.equalsIgnoreCase("end")){
						break;				
			}else
				read= read+aux+"\n";
			}
			
			br.close();
			fr.close();
			
			Clasificar wk = new Clasificar();
			
			String ver= wk.Divide(read);
			System.out.println(ver);
			
			File fl;
			
			FileWriter grabar;
			String rutaNew=rout;
			fl= new File(rutaNew.substring(0,rutaNew.length()-3)+"INST");
			grabar = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(grabar);
			PrintWriter Cod = new PrintWriter(bw);
			
			Cod.println(ver);
			
			Cod.close();
			bw.close();
			System.out.println(read);
			
		}catch(IOException e){
			
			
			
		System.out.print("Error");
		
		JOptionPane.showMessageDialog(null,"Error de apertura IO lectura de archivo.");
				}
		
		
		
	
		
		
		
	}

}
