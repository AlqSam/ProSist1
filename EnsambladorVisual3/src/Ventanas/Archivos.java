package Ventanas;


import java.io.*;
import java.nio.file.Files;

public class Archivos {
	public final String lineFormat ="Linea		Etiqueta		Codop		Operando ";	
	public final String lineFormat2=":::::::::::::::::::::::::::::::::::::::::::::::::";
	
	public Archivos(String name,String Etiq,String Codop,String Oper )
	{
		String EtiqF="NULL";
		String CodopF="NULL";
		String OperF="NULL";
		
		
		File fl;
		FileWriter grabar;
		try{
			
			fl= new File(name+".INST");
			grabar = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(grabar);
			PrintWriter grabarCod = new PrintWriter(bw);
			grabarCod.write(lineFormat+"\n");
			grabarCod.write(lineFormat2+"\n");
			
			grabarCod.close();
			bw.close();
		}
		catch(IOException e)
		{
			
		}
		
		
	}
	
	
	
	public String ArchFinal(String fuente){
		
		
	}

}
