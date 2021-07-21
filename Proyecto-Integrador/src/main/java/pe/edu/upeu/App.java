package pe.edu.upeu;


import java.util.Scanner;

import static java.lang.System.out;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.fusesource.jansi.AnsiConsole;
import jline.*;

public class App {


    //crear tabla con un arreglo
    public static String tabla(String[][] adr,int[] tam,String titulo,int[] navegacion){
    	cls();
        String[][] color=new String[adr.length][adr[0].length];
        String resetC="\u001B[0m";
        for(int i=0;i<adr.length;i++){for(int j=0;j<adr[0].length;j++){
            color[i][j]="";
        }}
        color[navegacion[0]][navegacion[1]]="\u001B[41m";
        
        String []ar=adr[0];
        System.out.println(adr[0].length);
        String valor="";
        
        
        valor+=g(sumA(tam))+"+\n";
        valor+="|"+palabras(center(titulo,sumA(tam)),sumA(tam))+"|\n";
        for(int i=0;i<adr.length;i++){
            for(int w=0;w<adr[0].length;w++){
                valor+=g(tam[w]);}
            valor+="+\n";
            for(int w=0;w<adr[0].length;w++){
                valor+="|"+color[i][w]+palabras(adr[i][w],tam[w])+resetC;}
            valor+="|\n";
            
        }
        
        for(int i=0;i<tam.length;i++){
            valor+=g(tam[i]);}
        valor+="+\n";
        return valor;}

    //crear tabla con un arraylist
    public static String tabla(ArrayList<String[]> adr,int[] tam,String titulo,int[] navegacion){
    	cls();
        //tamaño del array
        int x=adr.get(0).length;
        int y=adr.size();
        int x1=tam.length;
        //if(adr.get(0).length==tam.length && tam.length>navegacion[1] && adr.size()>navegacion[0]){}else{out.print("error");return "";}
        
        
        String[][] color=new String[adr.size()][adr.get(0).length];
        String resetC="\u001B[0m";
        for(int i=0;i<adr.size();i++){
            for(int j=0;j<adr.get(0).length;j++){
            color[i][j]="";
            }
        }
        color[navegacion[0]][navegacion[1]]="\u001B[46m";
        
        String []ar=adr.get(0);
        System.out.println(adr.get(0).length);
        String valor="";
        
        int tG=sumA(tam);
        valor+=g(tG)+"+\n";
        valor+="|"+palabras(center(titulo,tG),tG)+"|\n";
        for(int i=0;i<adr.size();i++){
            for(int w=0;w<adr.get(0).length;w++){
                valor+=g(tam[w]);}
            valor+="+\n";
            for(int w=0;w<adr.get(0).length;w++){
                valor+="|"+color[i][w]+palabras(adr.get(i)[w],tam[w])+resetC;}
            valor+="|\n";
            
        }
        
        for(int i=0;i<tam.length;i++){
            valor+=g(tam[i]);}
        valor+="+\n";
        return valor;}

    //borrar la pantall
    public static void cls(){try{new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}catch(Exception e){}}
    
    //funcion main
    public static void main(String[] args) {
    	//out.print(Console.lTecla(""));
        Scanner sc=new Scanner(System.in);
        Datos Do=new Datos();
        Datos D=new Datos();
        AnsiConsole.systemInstall();
        /*try{
        D=Save.deserializarObjeto(System.getProperty("user.dir")+"\\a.txt");}catch(Exception e){D=new Datos();}*/
        D.tam=Do.tam;D.tam2=Do.tam2;D.tam3=Do.tam3;D.tam4=Do.tam4;
        //out.print(j==true?"serializado":"");
        String[] d={"VER PRODUCTOS","VENDER PRODUCTOS","VER HISTORIAL","CONFIGURACIONES","SALIR"};
        String titulo="ventas";
        String titulo2="modelo";
        int[] navegacion={0,0};
        int[] navegacion2={0,0};
        int navMenu=0;
        int[] navConfig={0,0};
        int[] navegacionVP={0,0};
        int[] navegacionHis={0,0};
        boolean salir=true;

        while(salir){
           dMenu(d,20,navMenu); 
        while(true){String entrada=Console.lTecla();navMenu=navBasicaH(navMenu,5,entrada);dMenu(d,20,navMenu);if(entrada.equals("e")){break;}}
        switch(navMenu){
            case 0:
                String f=compTecls(navegacion,D.item,D.tam,titulo,D.cadVa,D.item2);
                while(true){
                    if(f.equals("space")){f=compTecls(navegacion2,D.item2,D.tam2,titulo2,D.modVa,D.item2);D.item.get(1)[2]=D.item2.get(1)[1];}
                    else if(f.equals("quitMenu")){break;}
                    else if(f.equals("quit")){f=compTecls(navegacion,D.item,D.tam,titulo,D.cadVa,D.item2);}
                }break;
            case 1:
                ArrayList<String[]> array=new ArrayList<String[]>();
                for(int i=0;i<D.item.size();i++){
                    array.add(D.item.get(i).clone());
                }
                String w=compTecls(navegacionVP,D.item3,D.tam3,"Vender producto",D.venVa,array,D.item2,D.item4,D.item);
                //out.print(tabla(item3,tam3,"Vender productos",navegacionVP));
                break;
            case 2:
                out.print(D.tam4[6]);
                String b=compTecls(navegacionHis,D.item4,D.tam4,"Historial",D.hisVa);
                break;
            case 3:
                int[] tamC={10,10};
                String[][] valores={{"IGV","00.0%"},{"Prec","00.0%"}};
                String valor=compTecls2(navConfig,valores,tamC,"CONFIGURACION");
                break;
            case 4:
                //salir del menu
                salir=false;
                boolean j=Save.serializarObjeto(System.getProperty("user.dir")+"\\a.txt", D);
                
                break;
        }       
    }}

    //recorta o alarga palabras segun se lo pidas
    //navegacion en w d s a
    public static int[] nav(int[] navegacion,int i,int j,String entrada){
        if(entrada.equals("s")){if(navegacion[0]<i-1){navegacion[0]+=1;}}
        else if(entrada.equals("w")){if(navegacion[0]>0){navegacion[0]-=1;}}
        else if(entrada.equals("d")){if(navegacion[1]<j-1){navegacion[1]+=1;}}
        else if(entrada.equals("a")){if(navegacion[1]>0){navegacion[1]-=1;}}
        return navegacion;
    }

    //navegacion vertical
    public static int navBasica(int navegacion,int tam,String entrada){
        if(entrada.equals("d")){if(navegacion<tam-1){navegacion+=1;}}
        else if(entrada.equals("a")){if(navegacion>1){navegacion-=1;}}
        return navegacion;
    }

    //navegacion horizontal
    public static int navBasicaH(int navegacion,int tam,String entrada){
        if(entrada.equals("s")){if(navegacion<tam-1){navegacion+=1;}}
        else if(entrada.equals("w")){if(navegacion>0){navegacion-=1;}}
        return navegacion;
    }

    //comprobaciones1
    public static String compTecls(int[] navegacion,ArrayList<String[]> item,int[] tam,String titulo,String[] cadVa,ArrayList<String[]> item2){
        Scanner sc=new Scanner(System.in);
        out.println(tabla(item,tam,titulo,navegacion));
        while(true){
        //String modelo=tabla(item2,tam2,"Modelos",navegacion2);
        //out.println(modelo);
        
        int x,y;
        x=item.size();y=item.get(0).length;
        String entrada=Console.lTecla();
        int nivel=0;
        nivel=titulo.equals("ventas")?1:2;
        int[] navg=nav(navegacion,x,y,entrada);
        if(entrada.equals("q")&& nivel==1){return "quitMenu";}
        if(entrada.equals("q")){return "quit";}
        if(entrada.equals("b")){return "space";}
        if(entrada.equals("e") && navegacion[0]>=1){
            //edicion de tabla nombres venta
            //String tex=sc.nextLine();
            if(navegacion[1]==1){
                String textos=sc.next();
                try{item.get(navg[0])[navg[1]]=textos;}catch(Exception e){}
                
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
            }
            
                //precio   
            }
            //edicion del modelo
            if(navegacion[1]==2 && titulo.equals("ventas")){
                
                String tecla=sc.next();
                int nav=1;
                while(!tecla.equals("e")){
                    
                    int size=item2.size();
                    nav=navBasica(nav,size,tecla);
                    //out.print(size+"sd"+nav);
                    item.get(navg[0])[navg[1]]=item2.get(nav)[1];
                    String tab=tabla(item,tam,titulo,navg);
                    out.println(tab);
                    tecla=sc.next();}
            }
            //ediocion de precio
            if(navegacion[1]==3 && titulo.equals("ventas")){
                
                try{float texto=sc.nextFloat();item.get(navg[0])[navg[1]]="S/. "+(Math.ceil(texto*10)/10)+"0";}catch(Exception e){}
                //float s=200;s=Math.ceil(s);
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            //cantidad stock
            if(navegacion[1]==4 && titulo.equals("ventas")){

                try{
                    int texto=sc.nextInt();
                    String te=texto+"";
                    item.get(navg[0])[navg[1]]=te;
                }catch(Exception e){}
                
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            if(navegacion[1]==2 && titulo.equals("modelo")){}
            if(navegacion[1]==3 && titulo.equals("modelo")){
                try{
                    int texto=sc.nextInt();
                    String te;
                    if(texto<=2021 && texto>=1900){te=texto+"";}else{te="";}
                    if(texto>=10 && texto<100){te=texto>21?"19"+texto:"20"+texto;}
                    if(texto>=0 && texto<=9){te="200"+texto;}
                    item.get(navg[0])[navg[1]]=te;
                }catch(Exception e){}
                
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            }
        String tab=tabla(item,tam,titulo,navg);
        out.println(tab);
        }
    }

    //comprobaciones2
    public static String compTecls(int[] navegacion,ArrayList<String[]> item,int[] tam,String titulo,String[] cadVa){
        Scanner sc=new Scanner(System.in);

        out.println(tabla(item,tam,titulo,navegacion));
        while(true){
        //String modelo=tabla(item2,tam2,"Modelos",navegacion2);
        //out.println(modelo);
        
        int x,y;
        x=item.size();y=item.get(0).length;
        String entrada=Console.lTecla();
        int nivel=0;
        nivel=titulo.equals("ventas")?1:2;
        int[] navg=nav(navegacion,x,y,entrada);
        if(entrada.equals("q")&& nivel==1){return "quitMenu";}
        if(entrada.equals("q")){return "quit";}
        if(entrada.equals("b")){return "space";}
        if(entrada.equals("e") && navegacion[0]>=1){
            //edicion de tabla nombres venta
            //String tex=sc.nextLine();
            if(navegacion[1]==1){
                String textos=sc.next();
                try{item.get(navg[0])[navg[1]]=textos;}catch(Exception e){}
                
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
            }
            
                //precio   
            }
            //edicion del modelo
            if(navegacion[1]==2 && titulo.equals("ventas")){
                
                String tecla=sc.next();
                int nav=1;
            }
            //ediocion de precio
            if(navegacion[1]==3 && titulo.equals("ventas")){
                
                try{float texto=sc.nextFloat();item.get(navg[0])[navg[1]]="S/. "+(Math.ceil(texto*10)/10)+"0";}catch(Exception e){}
                //float s=200;s=Math.ceil(s);
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            //cantidad stock
            if(navegacion[1]==4 && titulo.equals("ventas")){

                try{
                    int texto=sc.nextInt();
                    String te=texto+"";
                    item.get(navg[0])[navg[1]]=te;
                }catch(Exception e){}
                
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            if(navegacion[1]==2 && titulo.equals("modelo")){}
            if(navegacion[1]==3 && titulo.equals("modelo")){
                try{
                    int texto=sc.nextInt();
                    String te;
                    if(texto<=2021 && texto>=1900){te=texto+"";}else{te="";}
                    if(texto>=10 && texto<100){te=texto>21?"19"+texto:"20"+texto;}
                    if(texto>=0 && texto<=9){te="200"+texto;}
                    item.get(navg[0])[navg[1]]=te;
                }catch(Exception e){}
                
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            }
        String tab=tabla(item,tam,titulo,navg);
        out.println(tab);
        }
    }

    //comprobaciones3
    public static String compTecls(int[] navegacion,ArrayList<String[]> item,int[] tam,String titulo,String[] cadVa,ArrayList<String[]> item2,ArrayList<String[]> item3,ArrayList<String[]> item4,ArrayList<String[]> item5){
        Scanner sc=new Scanner(System.in);
        String tab;
        tab=tabla(item,tam,titulo,navegacion);
        out.println(tab);
        out.print(dCuadrado("buy",10,"",100));
        String estado="";
        ArrayList<String> valores=new ArrayList<String>();
        ArrayList<Integer> direcciones=new ArrayList<Integer>();
        //int[] direcciones = new int[item.size()];
            for(int i=0;i<item.size();i++){
                valores.add("S/. 00.0");
                direcciones.add(item2.size()-1);
            }
            for(int i=0;i<item2.size();i++){
                out.print(item2.get(i)[4]);
            }
        int[] stock=new int[item2.size()];
        for(int i=1;i<item2.size();i++){stock[i]=Integer.parseInt(item2.get(i)[4]);}
                    
        while(true){
        //String modelo=tabla(item2,tam2,"Modelos",navegacion2);
        //out.println(modelo);
        
        int x,y;
        x=item.size();y=item.get(0).length;
        String entrada=Console.lTecla();
        int nivel=0;
        nivel=titulo.equals("ventas")?1:2;
        int[] navg=nav(navegacion,x,y,entrada);
        if(entrada.equals("t") && estado.equals("")){estado="\u001B[41m";}else if(entrada.equals("t")){estado="";}
        if(entrada.equals("q")&& nivel==1){return "quitMenu";}
        if(entrada.equals("q")){return "quit";}
        if(entrada.equals("b")){return "space";}
        
        if(entrada.equals("e") && estado.equals("\u001B[41m")){
            boolean e= false;
            for(int w=1;w<direcciones.size();w++){
                        item5.get(direcciones.get(w))[4]=item.get(w)[5];
                        out.print("a"+direcciones.get(w)+" ");
                    }
            for(int i=1;i<item.size();i++){
                if(!item.get(i)[1].equals("") && !item.get(i)[2].equals("") && !item.get(i)[3].equals("0") && !item.get(i)[4].equals("S/. 0.00")){
                    if(e==false){if(item4.get(1)[1].equals("")){item4.remove(item4.size()-1);e=true;}}
                    String[] temp={item.get(i)[1],item.get(i)[2],item.get(i)[3],item.get(i)[4],"","",LocalDateTime.now().toString().substring(0,16).replace('T', ' ')};
                    direcciones.remove(i);
                    item4.add(temp);
                    item.remove(i);
                    valores.remove(i);                    
                    i--;
                    estado="";
                }
            }
            e=false;
            navg[0]=0;navg[1]=0;
            navegacion[0]=0;navegacion[1]=0;
        }
        if(entrada.equals("e") && navegacion[0]>=1){
            //edicion de tabla nombres venta
            //out.print(item.size()+" "+navegacion[0]);
            
            //nombre del producto
            if(navegacion[1]==1){
                
                try{
                    out.print("ingrese");
                    int numero=sc.nextInt();
                    String [] Stack={"00"+navg[0],item2.get(numero)[1],item2.get(numero)[2],"0",item2.get(numero)[3],item2.get(numero)[4]};
                    item.remove(navg[0]);
                    item.add(navg[0], Stack);
                    direcciones.set(navg[0],numero);
                    //out.print(direcciones.get(navg[0]));
                }catch(Exception e){}
                
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
            }
            
                //precio   
            }
            //edicion del modelo
            
            //ediocion de precio
            
            //cantidad stock
            //modelo
            if(navegacion[1]==2){
                try{
                    
                    int texto=sc.nextInt();
                    out.print("hola"+item3.get(texto)[1]);
                    item.get(navg[0])[2]=item3.get(texto)[1];
              
                }catch(Exception e){out.print("error");}
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            //cantidad stock
            if(navegacion[1]==3){
                try{
                    
                    
                    int num=sc.nextInt();
                    num=Math.abs(num);
                    String te;
                    out.print("hola");
                    int sto=Integer.parseInt(item.get(navg[0])[5]);
                    int canti=Integer.parseInt(item.get(navg[0])[3]);
                    if(num<sto){
                        if(num<canti){
                            sto+=canti-num;
                        }
                        else if(num>canti){
                            sto-=num-canti;
                        } 
                    }else if(num>=sto){
                        if(num>canti && sto>0){num=sto+canti;sto=0;}else if(num<canti){sto+=canti-num;}else if(num>canti){num=canti;}
                    }
                    item2.get(direcciones.get(navg[0]))[4]=""+sto;
                    item.get(navg[0])[3]=""+num;
                    for(int i=1;i<item.size();i++){
                            item.get(i)[5]=item2.get(direcciones.get(i))[4];
                    }
                    int cantidad=Integer.parseInt(item.get(navg[0])[3]);
                    float costo=Float.parseFloat(item2.get(direcciones.get(navg[0]))[3].substring(3,7));
                    item.get(navg[0])[4]="S/. "+cantidad*costo;
                    
                    
                    
                }catch(Exception e){out.print("error");}
                if(navegacion[0]==item.size()-1){
                    item.add(cadVa.clone());
                    item.get(item.size()-1)[0]="00"+(item.size()-1);
                }
            }
            }
        
        tab=tabla(item,tam,titulo,navg);
        tab+=dCuadrado("buy",10,estado,100);
        out.println(tab);
        }
    }

    //comprobaciones4
    public static String compTecls2(int[] navegacion,String[][] adr,int[] tam,String titulo){
        out.print(tabla(adr,tam,"configuracion",navegacion));
        while(true){
        	
            Scanner sc = new Scanner(System.in);
            String entrada = Console.lTecla();
            navegacion=nav(navegacion,adr.length,adr[0].length,entrada);
            out.print(tabla(adr,tam,"configuracion",navegacion));
            try{
            if(entrada.equals("e") && navegacion[1]==1){
                float porcentaje=sc.nextFloat();
                adr[navegacion[0]][navegacion[1]]=porcentaje+"%";
            }
            else if(entrada.equals("q")){break;}
            }catch(Exception e){}
            out.print(tabla(adr,tam,"configuracion",navegacion));
        }
        return "quit";
    }
    
    //corta las palabras tress puntos
    public static String palabras(String palabra,int tam){
        String valor="";
        if(palabra.length()>tam){
            int tamRed=tam-3;
            valor=palabra.substring(0,tamRed)+"...";
        }
        else if(palabra.length()==tam){valor=palabra;}
        else if(palabra.length()<tam){
            valor=palabra;
            for(int i=0;i<(tam)-palabra.length();i++){
                //System.out.print(" "+palabra.length());
                valor+=" ";
            }
        }
        return valor;
    }

    //genera guiones la cantidad dde veces que le pidas
    public static String g(int n){
        String valor="+";
        for(int i=0;i<n;i++){valor+="-";}
        return valor;
    }

    //suma los valores de un array mas sus divisiones
    public static int sumA(int[]ar){
        int suma=0;
        for(int i=0;i<ar.length;i++){suma+=ar[i];}
        suma+=ar.length-1;
        return suma;
    }

    //centra las letras
    public static String center(String v,int total){
        String valor="";
        int relleno=total-v.length();
        for(int i=0;i<relleno/2;i++){valor+=" ";}valor+=v;
        return valor;
    }

    //dibuja
    public static String dCuadrado(String nombre,int tam,String estado){
        String valor="";
        valor+=g(tam)+"+\n";
        valor+="|"+""+estado+palabras(center(nombre,tam),tam)+"|\n";
        valor+=g(tam)+"+\n";
        return valor;
    }

    //dibujar cuadrado centrado
    public static String dCuadrado(String nombre,int tam,String estado,int centerOn){
        String resetC="\u001B[0m";
        String valor="";
        int centerOnM=centerOn;
        valor+=center(g(tam)+"+\n",centerOn);
        if (estado.equals("")){centerOnM+=4;}else{centerOnM+=8;}
        valor+=center("|"+""+estado+palabras(center(nombre,tam),tam)+resetC+"|\n",centerOnM);
        valor+=center(g(tam)+"+\n",centerOn);
        return valor;
    }

    //dibujar configuracion
    public static String dConfig(String[][] estado){
        String valor="";
        String reset="";
        int tam=20;
        valor+=g(tam)+g(tam)+"+\n";
        valor+="|"+estado[0][0]+palabras("IGV",tam)+reset+"|"+estado[0][1]+palabras("00",tam)+reset+"|\n";
        valor+=g(tam)+g(tam)+"+\n";
        valor+=g(tam)+g(tam)+"+\n";
        valor+="|"+estado[1][0]+palabras("valor",tam)+reset+"|"+estado[1][1]+palabras("00",tam)+reset+"|\n";
        valor+=g(tam)+g(tam)+"+\n";
        return valor;
    }

    //dibujar menu
    public static void dMenu(String[] nombres,int tam, int nav){
        cls();
        int terminalWidth=160;

        out.print("\n\n\n\n\n\n");

        terminalWidth/=2;
        if (nav<nombres.length){
            for(int i=0;i<nombres.length;i++){
                if(nav==i){
                    out.print(dCuadrado(nombres[i],tam,"\u001B[46m",terminalWidth));
                }
                else{
                    out.print(dCuadrado(nombres[i],tam,"",terminalWidth));}
            }
        }     
    }
    //----
}
