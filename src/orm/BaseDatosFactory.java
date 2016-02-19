/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

/**
 *
 * @author lenin
 */
public class BaseDatosFactory {

 public String create_bd(String bd_clas, String ruta_archivo) {
    try
    {
           // File file = new File(bd_clas + ".java");
          // if(file.exists()){
               Archivo a=new Archivo(ruta_archivo);
               if(a.getBd() == null ? "mysql" == null : a.getBd().equals("mysql"))
               {
             bd_clas="com.mysql.jdbc.Driver";
               }
               else if(a.getBd() == null ? "postgresql" == null : a.getBd().equals("postgresql"))
               {
                 bd_clas="org.postgresql.Driver";
               }
               else if(a.getBd() == null ? "sqlserver" == null : a.getBd().equals("sqlserver"))
               {
                   bd_clas="com.microsoft.sqlserver.jdbc.SQLServerDriver";
               }
               
           //}

    }
    catch(Exception e)
    {

     bd_clas=e.getMessage();
    }
  return bd_clas;
}
}
