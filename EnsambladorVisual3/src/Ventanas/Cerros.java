package Ventanas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class Cerros {
	
		
	public String Genera(String []r){
		
	String error1="";
	String []aux=r;	
	String err,errEt,errEt2,errOp,errOp2;
	
	CMaestra cf = new CMaestra();
	LinkedList ltErr = new LinkedList();
	LinkedList ltend = new LinkedList();
	
	Pattern patronCom = Pattern.compile("(;.*)");
	Pattern LineaDeTres = Pattern.compile("^([A-Za-z0-9_]*)[\t| ]*([A-Za-z0-9_]*)[\t| ]*([A-Za-z0-9_]*)");
	
	for(int i=0;i<aux.length;i++)
	{	
		/**
		 * @param reciben un string inical y se compara en los diversos casos.
		 * */
		
		Matcher ChecaLineaDeTres = LineaDeTres.matcher(aux[i]);
		

		if(ChecaLineaDeTres.find()){
			
			if(ChecaLineaDeTres.group(1).matches("[A-Za-z][A-Za-z0-9_]{9,}")){
				errEt= ChecaLineaDeTres.group(1);
				ltErr.add(errEt+" Logitud de Etiqueta invalida");
			}else{
				
				if(ChecaLineaDeTres.group(1).matches("[0-9][A-Za-z0-9_]+")){
					errEt2= ChecaLineaDeTres.group(1);
					ltErr.add(errEt2+" Etiqueta Invalida inicia con numero");
				}
							
			}
			
			}
			
		if(ChecaLineaDeTres.group(2).matches("[A-Za-z[[\\.]{0,1}]]{6,}")){
				
				errOp=ChecaLineaDeTres.group(2);
				ltErr.add(errOp+" Longitud de Codigo de Operacion invalido");
				}
		
		if(ChecaLineaDeTres.group(2).matches("[0-9][A-Za-z]+")){
					errOp2=ChecaLineaDeTres.group(2);
					ltErr.add(errOp2+" Formato de codigo de operacion invalido ");
					}
		if(ChecaLineaDeTres.group(2).matches("[A-Za-z[[\\.]{0,1}]]{1,5}")){
			errOp2=ChecaLineaDeTres.group(2);
			ltend.add(errOp2);
			}
			}
	if(ltend.contains("end")||ltend.contains("END")){
		JOptionPane.showMessageDialog(null,"Terminacion con END.");
	}else{
			ltErr.add("No se encontro terminacion end");
			JOptionPane.showMessageDialog(null,"No se encontro END.");
		}	
								
		ListIterator itErr	= ltErr.listIterator();		
		
		
while(itErr.hasNext()){
	int j=0;
	error1=error1+j+"\t"+itErr.next()+"\n";
	j++;
}
	

	
	return error1;
	
	
}
	
	
	}
	

