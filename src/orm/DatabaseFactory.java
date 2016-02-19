/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

/**
 *
 * @author lenin
 */
public class DatabaseFactory implements DbFactory_Interface{
    public String  create(String ruta_archivo)
    {
     String bd_clas,bd;
     Archivo ar=new Archivo(ruta_archivo);
     bd_clas=ar.getBd();
     //String DirArchivo;
     BaseDatosFactory bdf=new BaseDatosFactory();
    bd= bdf.create_bd(bd_clas,ruta_archivo);
     return bd;

     }

}
