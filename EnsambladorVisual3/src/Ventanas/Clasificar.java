package Ventanas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.IIOException;

public class Clasificar {

	public void Divide(String st){
		String[] aux;
		
		String com;
		String etiq;
		String codo;
		String Oper;
		String pasaEtiq="Null";
		String pasaCodo="Null";
		String pasaComs="Null";
		String pasaOper="Null";
		
		
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
		
		aux=st.split("\n");
		
		File f;
		FileWriter g;
		
	try{
	
		f= new File("p2.txt");
		g = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(g);
		PrintWriter grabarCod = new PrintWriter(bw);
		
		
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
		pasaComs= ltCom.toString();
	
		}
		
		if(aux[i].matches("^[A-Za-z]+[A-Za-z0-9_]{1,8}[\t| ].*"))
		{	String[] auxEtq=aux[i].split("\t| ");
			etiq=auxEtq[0];
			ltEtiq.add(etiq);
			String eta=auxEtq[1];
			String eta2=auxEtq[2];
			grabarCod.append(etiq+"\t\t");
			if(eta.matches("[A-Za-z]{1,5}[\t| ]*")){
			ltCodo.add(eta);
			grabarCod.append(eta+"\t\t");
			}else {
				String e1=eta+"No cumple con las reglas de los Codops ";
				ltErrors.add(e1);	}
			
			if(eta2.matches("[A-Za-z0-9$%@_]+[\t|\n]")){
			ltOper.add(eta2);	
			grabarCod.append(eta2+"\n");
			}else {
				String e2=eta+"No cumple con las reglas de los Codops ";
				ltErrors.add(e2);
			}
			
			pasaEtiq=ltEtiq.toString();
		
		}else {
			ltEtiq.add("Null");
			grabarCod.append("Null\t\t");
		}
		
		
		if (aux[i].matches("^.*|[\t| ]+[A-Za-z]{1,5}[\t| ]*[\n]*"))
		{	String auxCodo=aux[i];
			
			codo=auxCodo;
			grabarCod.append(codo+"\t\t");
			ltCodo.add(codo);
			
			String[] auxcodo=aux[i].split("\t| ");
			String ct=auxcodo[0];
			
			if(ct.matches("[A-Za-z0-9$%@_\\.]+[\n]"))
			{
				ltOper.add(ct);
				grabarCod.append(ct+"\n");
			}
			else {
				String e3=ct+"No cumple con las reglas de los Codops ";
				ltErrors.add(e3);
			}
			pasaCodo=ltCodo.toString();
		
		}else {
			ltCodo.add("Null");
			grabarCod.append("NULL\t");
		}
		
		if (aux[i].matches("^[\t| ]+[A-Za-z0-9$%@_\\.]+[\n]"))
		{	String auxOper=aux[i];
			Oper=auxOper;
			ltOper.add(Oper);
			grabarCod.append(Oper+"\n");
			pasaOper=ltOper.toString();
		
		}else {
			grabarCod.append("Null\n");
			ltOper.add("NULL");
		}
		
		Archivos arc = new Archivos();
		arc.ArchivosF(pasaEtiq, pasaCodo,pasaOper ,pasaComs);
		
		
		grabarCod.close();
		bw.close();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(ltOper.size());
	}
	
	}

	
	

