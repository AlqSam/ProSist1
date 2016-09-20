import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Tabop {

	public String Tabop(){
	String Val="";	
	File f;
	f= new File("TABOP.txt");
	String read="";

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
		
		
	}catch(IOException e){
		
		JOptionPane.showMessageDialog(null,"Error de apertura IO lectura de archivo Tabop .");
	}
	return Val;
}
	
}