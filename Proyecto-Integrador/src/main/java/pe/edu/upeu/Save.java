
package pe.edu.upeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save {
    public String path;
    String nombre="\\hola";
    FileOutputStream fos = null;
    ObjectOutputStream salida = null;
    FileInputStream fis = null;
    ObjectInputStream entrada = null;
    Datos d;
    public void dave(){
        File file = new File(nombre);
        if(!file.exists() && !file.isDirectory()){
            file.mkdirs();
            path=file.getAbsoluteFile().toString()+nombre;
        }
        path=file.getAbsoluteFile().toString()+"sdsd";
        System.out.println();
    }
    public static boolean serializarObjeto(String direccionArchivo, Serializable objeto) {
        boolean sw = false;
        try (FileOutputStream fos = new FileOutputStream(direccionArchivo);
                ObjectOutputStream salida = new ObjectOutputStream(fos);) {
            salida.writeObject(objeto);
            sw = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sw;
    }

    public static <E> E deserializarObjeto(String direccionArchivo, Class<E> claseObjetivo) {
        E objeto = null;
        try (FileInputStream fis = new FileInputStream(direccionArchivo);
                ObjectInputStream entrada = new ObjectInputStream(fis);) {
            objeto = (E) entrada.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }
    public static Datos deserializarObjeto(String direccionArchivo) {
        Datos objeto = null;
        try (FileInputStream fis = new FileInputStream(direccionArchivo);
                ObjectInputStream entrada = new ObjectInputStream(fis);) {
            objeto = (Datos) entrada.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }

}
