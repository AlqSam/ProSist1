package Ventanas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.IIOException;

public class Clasificar {

	public String Divide(String read){
		String[] aux=read.split("\n");
		String result="";
		String com;
		String etiq;
		String codo;
		String Oper;
				
		/**
		 * Creacion de objetos de tipo LinkedList para el almacenamiento temporal
		 * 
		 * */
	
		LinkedList ltCom = new LinkedList();
		LinkedList ltEtiq = new LinkedList();
		LinkedList ltCodo = new LinkedList();
		LinkedList ltOper = new LinkedList();
		LinkedList lau	  = new LinkedList();
		LinkedList ltErrors = new LinkedList();
		
		Pattern patronCom = Pattern.compile("(;.*)");
		
		Pattern patronE = Pattern.compile("^([A-Za-z][A-Za-z0-9_]{1,8}[\t| ]*)");
		Pattern patronCod = Pattern.compile("([\t| ]+[A-Za-z]{1,5}[\t| ]*)");
		Pattern patronOper = Pattern.compile("([\t| ]+[A-Za-z0-9]{1,}[\t| ])");
		Pattern patronL	= Pattern.compile("(^[\t ])([\t ])([\t ])");
		
		/**
		 * Se aplica split para para separa el string obtenido del jfilechooser
		 * @param String aux.
		 * 
		 * */
		
	
		
	
		
		
	for(int i=0;i<aux.length;i++)
	{	
		/**
		 * @param reciben un string inical y se compara en los diversos casos.
		 * */
		
		Matcher matcherCom = patronCom.matcher(aux[i]);
		Matcher matcherE = patronE.matcher(aux[i]);
		Matcher matcherCod = patronCod.matcher(aux[i]);
		Matcher matcherOper = patronOper.matcher(aux[i]);
		Matcher matcherL = patronL.matcher(aux[i]);

		if(matcherL.find())
		{
		
		}
		
		if(matcherCom.find())
		{
		com=matcherCom.group(1);	
		ltCom.add(com);
		}else{
			ltCom.add("");
		}
		
		if(matcherE.find())
		{	
			etiq= matcherE.group();
			ltEtiq.add(etiq);
					
		
		}else {
			ltEtiq.add("Null");
			
		}
		
		
		if (matcherCod.find())
		{	
			
			codo=matcherCod.group();
			ltCodo.add(codo);
			
		}	else {
			ltCodo.add("Null");
			
		}
			
			if(matcherOper.find())
			{	Oper=matcherOper.group();
				ltOper.add(Oper);
				
			}else {
			
			ltOper.add("NULL");
		}
		
	}
		ListIterator itEtiq = ltEtiq.listIterator();	
		ListIterator itcodo = ltCodo.listIterator();	
		ListIterator itoper = ltOper.listIterator();	
		ListIterator itcom  = ltCom.listIterator();	
		/*while(itEtiq.hasNext()){
			
			System.out.println(itEtiq.next());
		}*/
		int j=0;
		while(itEtiq.hasNext()&itcodo.hasNext()&itoper.hasNext()&itcom.hasNext()){
			 result=result+j+"\t"+itEtiq.next()+"\t"+itcodo.next()+"\t"+itoper.next()+"\t"+itcom.next()+"\n";
			j++;
		}
		

		System.out.println(result+"________________________________");
		System.out.println(ltCom.getFirst());
		System.out.println(ltEtiq.getFirst());
		//System.out.println(result);
		return result;
		
		}

	}

		
		
	
	
	
	
	

	
	

