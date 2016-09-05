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
		if(aux[i].matches(".*;.*"))
		{
		
		String comAux=aux[i];	
		com=comAux.substring(comAux.indexOf(";"),comAux.length());	
		ltCom.add(com);
		
	
		}
		
		if(aux[i].matches("^[A-Za-z]+[A-Za-z0-9_]{1,8}[\t| ].*"))
		{	String[] auxEtq=aux[i].split("\t| ");
			etiq=auxEtq[0];
			ltEtiq.add(etiq);
			String eta=auxEtq[1];
			String eta2=auxEtq[2];
			
			if(eta.matches("[A-Za-z]{1,5}[\t| ]*")){
			ltCodo.add(eta);
			
			}else {
				String e1=eta+"No cumple con las reglas de los Codops ";
				ltErrors.add(e1);	}
			
			if(eta2.matches("[A-Za-z0-9$%@_]+[\t|\n]")){
			ltOper.add(eta2);	
			
			}else {
				String e2=eta+"No cumple con las reglas de los Codops ";
				ltErrors.add(e2);
			}
			
			
		
		}else {
			ltEtiq.add("Null");
			
		}
		
		
		if (aux[i].matches("^.*|[\t| ]+[A-Za-z]{1,5}[\t| ]*[\n]*"))
		{	String auxCodo=aux[i];
			
			codo=auxCodo;
			ltCodo.add(codo);
			
			String[] auxcodo=aux[i].split("\t| ");
			String ct=auxcodo[0];
			
			if(ct.matches("[A-Za-z0-9$%@_\\.]+[\n]"))
			{
				ltOper.add(ct);
				
			}
			else {
				String e3=ct+"No cumple con las reglas de los Codops ";
				ltErrors.add(e3);
			}
			
		
		}else {
			ltCodo.add("Null");
			
		}
		
		if (aux[i].matches("^[\t| ]+[A-Za-z0-9$%@_\\.]+[\n]"))
		{	String auxOper=aux[i];
			Oper=auxOper;
			ltOper.add(Oper);
		
		
		}else {
			
			ltOper.add("NULL");
		}
		
		
		ListIterator itEtiq = ltEtiq.listIterator();	
		ListIterator itcodo = ltCodo.listIterator();	
		ListIterator itoper = ltOper.listIterator();	
		while(itEtiq.hasNext()&itcodo.hasNext()&itoper.hasNext()){
			 result=result+itEtiq.next()+"\t"+itcodo.next()+"\t"+itoper.next()+"\n";
			
		}
		
		}
	System.out.println(result+"________________________________");
	return result;
	}
}
		
		
	
	
	
	
	

	
	

