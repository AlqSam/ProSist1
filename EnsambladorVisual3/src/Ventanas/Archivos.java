package Ventanas;


import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;


/**

* Esta clase realiza la construccion del archivo .INST Y ERR

* @author: Leonardo D. Gtz Medellin

* @version: 30/08/16

* 

*/


public class Archivos {
	public final String lineFormat ="Linea		Etiqueta		Codop		Operando ";	
	public final String lineFormat2="::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
	/**
	 *Recibe esta funcion 4 parametros de tipo String 
	 *
	 *@param string etq string codo	string oper	string com
	 * 
	 * */
	
	public void ArchivosF(String etq , String codo, String oper,String com)
	{
		String EtiqF=etq;
		String  CodopF=codo;
		String OperF=oper;
		String ComsF=com;
		
		/**
		 * 
		 * Se crea un flujo hacia un archivo y se da tramiento de los parametros recibidos.
		 * 
		 * 
		 * */
		
		System.out.println("Contenidp"+EtiqF);
		
		File fl;
		FileWriter grabar;
		int i=0;
		try{
			
			fl= new File("p1.txt");
			grabar = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(grabar);
			PrintWriter grabarCod = new PrintWriter(bw);
			grabarCod.write(lineFormat);
			bw.newLine();
			grabarCod.write(lineFormat2);
			bw.newLine();
				
			grabarCod.write(i+"	"+"	"+EtiqF+"		"+CodopF+"		"+OperF+"		");
			bw.newLine();
		
			
			
			
				
			grabarCod.close();
			bw.close();
			
						
			
		}
		catch(IOException e)
		{
			
		}
		
		
	}
	
	
	
	

}
