
package pe.edu.upeu;

import java.io.Serializable;
import java.util.ArrayList;

public class Datos implements Serializable{
    public String[] modelos={"id","nombre","tamaño","año"};
    public String[] modVa={"001","Defauld","",""};

    public String[] venta={"ID","Nombre","Modelo","Precio","Cantidad o Stock"};
    public String[] cadVa={"001",""," ","s/. 00.00","0"};
        
    public String[] venderP={"ID","Producto","Modelo","Cantida a C.","Costo","Stock"};
    public String[] venVa={"001","","","0","S/. 0.00","0"};
        
    public String[] historial={"Producto","Modelo","Cantidad","valor venta","IGV","Costo","Fecha"};
    public String[] hisVa={"","","0","S/. 0.00","S/. 0.00","S/. 0.00","00/00/00-00:00"};
      
    public ArrayList<String[]> item=new ArrayList<String[]>();
    public ArrayList<String[]> item2=new ArrayList<String[]>();
    public ArrayList<String[]> item3=new ArrayList<String[]>();
    public ArrayList<String[]> item4=new ArrayList<String[]>();
    
    public int[] tam={6,10,10,15,20};
    public int[] tam2={6,10,10,15};
    public int[] tam3={10,10,10,10,10,10};
    public int[] tam4={9,10,5,9,9,9,14};
        //String[] valores={"id","text","tabla","dinero","entero"};
    public Datos(){
        item.add(venta);
        item.add(cadVa.clone());
        item2.add(modelos);
        item2.add(modVa.clone());
        item3.add(venderP);
        item3.add(venVa.clone());
        item4.add(historial);
        item4.add(hisVa.clone());}   
}
