/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

/**
 *
 * @author lenin
 */


import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion extends BaseDatos {
String e;
public static Conexion singleton=null;
 private Connection con = null;
 

 public Conexion(String cadena,String ruta) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  try {
      
   Class.forName(cadena);
   getDatos(new Archivo(ruta));
   String cad="jdbc:"+bd+"://"+host+":"+puerto+"/"+base;
//jdbc:mysql://localhost:3306/tarapotoinn
  //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarapotoinn", "root","123456");
   //System.out.print(cad);
   
 con = DriverManager.getConnection(cad, user,clave);
 
  } catch (SQLException e) {
      this.e=e.getMessage();
      //JOptionPane.showMessageDialog(null,e.toString());
   e.printStackTrace();
  }
  
 }
 /*public static Conexion getSingleton(String cadena,String ruta) throws ClassNotFoundException {
if(singleton==null){
singleton=new Conexion(cadena,ruta);
}
return singleton;
}*/
public String getError()
{
    return e;
}
 public Connection getConexion(){
  return con;
 }

 public void cerrarConexion(){
  try {
   con.close();
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }
}