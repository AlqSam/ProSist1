package Ventanas;

import java.awt.Container;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
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
		int s=0;
		/**
		 * Se carga rl tabop desde archivo para su comparacion.
		 * @param tabop.txt
		 * 
		 * 
		 * */
		
		String Val="";	
		File f;
		f= new File("TABOP.txt");
		String LeerTab="";
		String clave="";
		String Modos="";
		/**
		 * se lee el archivo y se almacena en un Hashmap
		 * 
		 * */
		try{
			
			FileReader fr =new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String ALeer;
						
			while((ALeer= br.readLine())!=null)
			{		
				LeerTab= LeerTab+ALeer+"\n";
			}
			
			br.close();
			fr.close();
				
		}catch(IOException e){
			
			JOptionPane.showMessageDialog(null,"Error de apertura IO lectura de archivo Tabop .");
		}
		
		
				
		/**
		 * Creacion de objetos de tipo LinkedList para el almacenamiento temporal
		 * 
		 * */
	
		LinkedList ltCom = new LinkedList();
		LinkedList ltEtiq = new LinkedList();
		LinkedList ltCodo = new LinkedList();
		LinkedList ltOper = new LinkedList();
		
		
		
		Pattern patronCom = Pattern.compile("(;.*)");
		Pattern LineaDeTres = Pattern.compile("^([A-Za-z0-9_]*)[\t| ]*([A-Za-z0-9_]*)[\t| ]*([A-Za-z0-9_]*)");
		Pattern LineaDeDos = Pattern.compile("([\t| ]+[A-Za-z]{1,5}[\t| ]*)");
		Pattern LineaDeDos2 = Pattern.compile("^([\t| ]+)([\t| ]+)([A-Za-z0-9]{1,}[\n])");
		
		
		/**
		 * 
		 * Se genera un hashmap con los operandos y modos de direccionamiento.
		 * 
		 * */
		
		String[]a=LeerTab.split("\n");
	
		Pattern Tablatab = Pattern.compile("([\\[A-Za-a0-9\\]]+)\\|([\\[A-Za-a0-9\\,\\]]+)\\|([\\[s|n]+)");
		Hashtable<String,String> tablaOperandos= new Hashtable<String,String>();
	
		
		for(int t=0;t<a.length ;t++){
		Matcher CodigoTab = Tablatab.matcher(a[t]);	
		
		if(CodigoTab.find()){
			
			if(CodigoTab.group(1).matches("[\\[A-Za-a0-9\\]]+")&&CodigoTab.group(2).matches("[\\[A-Za-a0-9\\,\\]]+")){
				clave=CodigoTab.group(1);
				Modos=CodigoTab.group(2);
								
			tablaOperandos.put(clave,Modos);	
		
		
		}
			
							}	
					
									}
		Iterator it= tablaOperandos.keySet().iterator();
		Iterator iv= tablaOperandos.values().iterator();
		
		
		while(it.hasNext()&iv.hasNext()){
			int i=0;
			String valor=(String) iv.next().toString();
			String  key = (String) it.next().toString();
			System.out.println(i+" Clave: " + key + " -> Valor: " +tablaOperandos.get(key));
			i++;
			}
		System.out.println("Este  "+tablaOperandos.get("SUBA"));
		
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
		
		if(s==9){
			break;
		}

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
				
			if(codo.equalsIgnoreCase("END")){
				ltCodo.add(codo);
					s=9;
					continue;
				}
				}else{//end del if de codop
					ltCodo.add("Null");
				}
		if(ChecaLineaDeTres.group(3).matches("[A-Za-z0-9]+[;]*")){
				Oper=ChecaLineaDeTres.group(3);
				ltOper.add(Oper);
				}else{
				ltOper.add("Null");
				}
		}		
		
			
		if(matcherCom.find())
		{
		com=matcherCom.group(1);	
		ltCom.add(com);
		}else{
		ltCom.add("");
		}
		
		if(ltEtiq.get(i).equals("Null")&&ltOper.get(i).equals("Null")&&ltCodo.get(i).equals("Null")){
			ltEtiq.add("");
			ltOper.add("");
			ltCodo.add("");
		}
		
		
	}
	
	
		System.out.println(" "+ltCodo.getLast());
	
		ListIterator itEtiq = ltEtiq.listIterator();	
		ListIterator itcodo = ltCodo.listIterator();	
		ListIterator itoper = ltOper.listIterator();	
		ListIterator itcom  = ltCom.listIterator();	
		
		
		int j=0;
		while(itEtiq.hasNext()&itcodo.hasNext()&itoper.hasNext()&itcom.hasNext()){
			 result=result+j+"\t\t\t"+itEtiq.next()+"\t\t\t"+itcodo.next()+"\t\t"+itoper.next()+"\n";
			j++;
		}
		
		
		
		return result;
		
		}

	

	
}
