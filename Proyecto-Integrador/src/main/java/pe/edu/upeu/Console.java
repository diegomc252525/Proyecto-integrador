package pe.edu.upeu;

import jline.*;
//import org.jline.terminal.TerminalBuilder;

public class Console{
	
	public static String lTecla(String ho){
		try{ConsoleReader consoleReader = new ConsoleReader();
			int key = consoleReader.readVirtualKey();
			return ""+key;
		}catch(Exception e){return "";}
	}
	public static String lTecla(){
		try{ConsoleReader consoleReader = new ConsoleReader();
			int key = consoleReader.readVirtualKey();
			return tranformarTecla(key);
		}catch(Exception e){return "";}
	}
	public static String tranformarTecla(int tecla){
		switch(tecla){
			case 16:
				return "w";
			case 2:
				return "a";
			case 6:
				return "d";
			case 14:
				return "s";
			case 13:
				return "e";
			case 9:
				return "t";
			case 27:
				return "q";
			case 32:
				return "b";
			default: 
				return "";

		}
		//return null;
	}
	
	
}