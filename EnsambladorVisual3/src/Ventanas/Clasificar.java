package Ventanas;

import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Clasificar {

	public void Divide(String st){
		String aux="";
		String com="";
		String etiq="";
		String codo="";
		
		LinkedList ltCom = new LinkedList();
		LinkedList ltEtiq = new LinkedList();
		LinkedList ltCodo = new LinkedList();
		StringTokenizer tok2 = new StringTokenizer(st);
	while(tok2.hasMoreTokens())
	{	
		
		if(tok2.nextToken().matches(";.*"))
		{
			com=tok2.nextToken();
			ltCom.add(com);
		}
		
	}
	System.out.println("Result "+ltCom.getFirst());	
	System.out.println("Result "+ltCom.get(1));	
	}
}
	
	

