package Ventanas;

import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clasificar {

	public void Divide(String st){
		String[] aux;
		String com;
		String etiq="";
		String codo="";
		
	
		LinkedList ltCom = new LinkedList();
		LinkedList ltEtiq = new LinkedList();
		LinkedList ltCodo = new LinkedList();
	
		aux=st.split("\n");
		
	for(int i=0;i<aux.length;i++)
	{	
		
		if(aux[i].matches(".*;.*"))
		{
		
		String comAux=aux[i];	
		com=comAux.substring(comAux.indexOf(";"),comAux.length());	
		ltCom.add(com);
		}
		if(aux[i].matches("^[A-Z].*[a-z0-9][_]"))
		{
			ltEtiq.add(aux[i]);
		}
	}
	
	}
}
	
	

