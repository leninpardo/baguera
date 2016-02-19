/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

/**
 *
 * @author lenin
 */
abstract class BaseDatos {
       public String bd,host,puerto,user,clave,base;
   public void getDatos(Archivo a)
   {
       bd=a.bd;
     host=a.ip;
     puerto=a.puerto;
     user=a.us;
     clave=a.pas;
     base=a.base;
   }

}
