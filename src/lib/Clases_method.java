/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

/**
 *
 * @author lenin
 */
public abstract class Clases_method {

    Class clase;
    private String Clase_lib;
    private String Method_lib;
    private String[] datos;
    public Vector Datos_devol;

    public void set_run() {
        try {

            Datos_devol = new Vector();

            clase = Class.forName(this.getClase_lib());
            // Instanciamos un objeto de la clase
            try {
                Object objeto = clase.newInstance();
                try {
                    Class[] params = new Class[1];
                    params[0] = Class.forName("java.lang.String");
                    Method metGetEmail = clase.getMethod(getMethod_lib(), params);

//                    Object datos_obj;
//                    datos_obj = this.getDatos();
                    String resultado = (String) metGetEmail.invoke(objeto, this.getId());
                } catch (NoSuchMethodException e) {
                    System.out.println("Error al acceder al metodo. " + e);
                } catch (SecurityException e) {
                    System.out.println("Error al acceder al metodo. " + e);
                } catch (InvocationTargetException e) {
                    System.out.println("Error al ejecutar el metodo. " + e);
                }
            } catch (InstantiationException e) {
                System.out.println("Error al instanciar el objeto. " + e);
            } catch (IllegalAccessException e) {
                System.out.println("Error al instanciar el objeto. " + e);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase. " + e);
        }

    }
   public void set_run_principal() {
        try {

            Datos_devol = new Vector();

            clase = Class.forName(this.getClase_lib());
            // Instanciamos un objeto de la clase
            try {
                Object objeto = clase.newInstance();
                try {
                    Class[] params = new Class[1];
                    params[0] = Class.forName("java.lang.String");
                    Method metGetEmail = clase.getMethod(getMethod_lib(),null);

//                    Object datos_obj;
//                    datos_obj = this.getDatos();
                    String resultado = (String) metGetEmail.invoke(objeto,null);
                } catch (NoSuchMethodException e) {
                    System.out.println("Error al acceder al metodo. " + e);
                } catch (SecurityException e) {
                    System.out.println("Error al acceder al metodo. " + e);
                } catch (InvocationTargetException e) {
                    System.out.println("Error al ejecutar el metodo. " + e);
                }
            } catch (InstantiationException e) {
                System.out.println("Error al instanciar el objeto. " + e);
            } catch (IllegalAccessException e) {
                System.out.println("Error al instanciar el objeto. " + e);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase. " + e);
        }

    }
    /**
     * @return the Clase_lib
     */
    public String getClase_lib() {
        return Clase_lib;
    }

    /**
     * @param Clase_lib the Clase_lib to set
     */
    public void setClase_lib(String Clase_lib) {
        this.Clase_lib = Clase_lib;
    }

    /**
     * @return the Method_lib
     */
    public String getMethod_lib() {
        return Method_lib;
    }

    /**
     * @param Method_lib the Method_lib to set
     */
    public void setMethod_lib(String Method_lib) {
        this.Method_lib = Method_lib;
    }

    /**
     * @return the datos
     */
    public String[] getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(String[] datos) {
        this.datos = datos;
    }

    public String getId() {
        String[] datos_r = this.getDatos();

        return datos_r[0];
    }

}
