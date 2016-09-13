import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


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
		
		
		Pattern patronCom = Pattern.compile("(;.*)");
		
		Pattern LineaDeTres = Pattern.compile("^([A-Za-z0-9_]*)[\t| ]*([A-Za-z0-9_]*)[\t| ]*([A-Za-z0-9_]*)");
		Pattern LineaDeDos = Pattern.compile("([\t| ]+[A-Za-z]{1,5}[\t| ]*)");
		
		Pattern LineaDeDos2 = Pattern.compile("^([\t| ]+)([\t| ]+)([A-Za-z0-9]{1,}[\n])");
		
		Pattern LineaDeUno	= Pattern.compile("(^[\t ])([\t ])([\t ])");
		
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
		Matcher ChecaLineaDeTres = LineaDeTres.matcher(aux[i]);
		Matcher ChecaLineaDeDos = LineaDeDos.matcher(aux[i]);
		Matcher ChecaLineaDeDos2 = LineaDeDos2.matcher(aux[i]);
		Matcher ChecaLineaDeUno = LineaDeUno.matcher(aux[i]);

		if(ChecaLineaDeTres.find()){
			
			if(ChecaLineaDeTres.group(1).matches("[A-Za-z][A-Za-z0-9_]{1,8}")){
				etiq= ChecaLineaDeTres.group(1);
				ltEtiq.add(etiq);
			}else {
				ltEtiq.add("Null");
				
				
			}
				
			if(ChecaLineaDeTres.group(2).matches("[A-Za-z[[\\.]{0,1}]]{1,5}")){
				
				codo=ChecaLineaDeTres.group(2);
				ltCodo.add(codo);
				}else{
					ltCodo.add("Null");
					
				}
			if(ChecaLineaDeTres.group(3).matches("[A-Za-z0-9]+[;]*")){
				Oper=ChecaLineaDeTres.group(3);
				ltOper.add(Oper);
			}else{
				ltOper.add("Null");
				
			}
		}
		
			if(ChecaLineaDeDos2.find()){
				
				if(ChecaLineaDeDos2.group(3).matches("[A-Za-z0-9]+[;]*")){
					Oper=ChecaLineaDeTres.group(3);
					ltOper.add(Oper);
					
				}
				
			}
		if(matcherCom.find())
		{
		com=matcherCom.group(1);	
		ltCom.add(com);
		}else{
			ltCom.add("");
		}
	}
		ListIterator itEtiq = ltEtiq.listIterator();	
		ListIterator itcodo = ltCodo.listIterator();	
		ListIterator itoper = ltOper.listIterator();	
		ListIterator itcom  = ltCom.listIterator();	
		
		
		int j=0;
		while(itEtiq.hasNext()&itcodo.hasNext()&itoper.hasNext()&itcom.hasNext()){
			 result=result+j+"\t\t\t"+itEtiq.next()+"\t\t\t"+itcodo.next()+"\t\t"+itoper.next()+"\t\t\t"+itcom.next()+"\n";
			j++;
		}
		
		
		
		
		return result;
		
		}

}
