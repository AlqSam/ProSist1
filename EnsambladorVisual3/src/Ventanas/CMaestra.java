package Ventanas;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class CMaestra {

	public String rout;
	public String result;
	public final String lineFormat ="Linea		Etiqueta		Codop		Operando ";	
	public final String lineFormat2="::::::::::::::::::::::::::::::::::::::::::::::::::";
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
			
				read= read+aux+"\n";
				
			}
			
			br.close();
			fr.close();
			
			Clasificar wk = new Clasificar();
			
			String ver= wk.Divide(read);
			
			
			File fl;
			
			FileWriter grabar;
			String rutaNew=rout;
			fl= new File(rutaNew.substring(0,rutaNew.length()-3)+"INST");
			grabar = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(grabar);
			PrintWriter Cod = new PrintWriter(bw);
			Cod.println(lineFormat);
			Cod.println(lineFormat2);
			Cod.println(ver);
			
			Cod.close();
			bw.close();
			JOptionPane.showMessageDialog(null,"Proceso terminado archivos generados ");
			
		}catch(IOException e){
			
			
			
		System.out.print("Error");
		
		JOptionPane.showMessageDialog(null,"Error de apertura IO lectura de archivo. Primario");
				}
		
		
		Cerros cr = new Cerros();
		String []gr = read.split("\n");
		String error=cr.Genera(gr);	
		
File flE;
		
		try{
			
		FileWriter grE;
		String log=rout;
		flE= new File(log.substring(0,log.length()-3)+"Err");
		grE = new FileWriter(flE);
		BufferedWriter bw = new BufferedWriter(grE);
		PrintWriter codE = new PrintWriter(bw);
		
		codE.println(error);
		
		codE.close();
		bw.close();
		}
		catch(IOException e){
			
			JOptionPane.showMessageDialog(null,"Error de Creacion  IO lectura de archivo.");
		}
		
		
	
		
		
		
	}
}
