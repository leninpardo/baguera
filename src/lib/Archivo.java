/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author lenin
 */
public class Archivo {
 public String ip,base,puerto,us,pas,bd,ruta;
    private String url;
    public Archivo(String file)
    {
        super();
        this.ruta=file;
      Properties p=new Properties();
      try
      {
      p.load(new FileInputStream(file));//c:programa file//selva/tem/t.ini
      ip=p.getProperty("ip");
     // p.setProperty("lenin","1234567890");
      base=p.getProperty("bas");
      puerto=p.getProperty("port");
      us=p.getProperty("us");
      pas=p.getProperty("pas");
      bd=p.getProperty("bd");
      url=p.getProperty("url");
      //System.out.println(ip+base+puerto+us+pas);
      }
      catch(Exception e)
      {
          //JOptionPane.showMessageDialog(null,e.getMessage());
          e.printStackTrace();
      }
    }
    public void writer(String bd,String ip,String port,String bas,String us,String pas)
    {
        Properties p=new Properties();
      try
      {
      p.load(new FileInputStream(ruta));//c:programa file//selva/tem/t.ini
      p.setProperty("ip",ip);
     // p.setProperty("lenin","1234567890");
    p.setProperty("bas",bas);
      p.setProperty("port",port);
     p.setProperty("us",us);
      p.setProperty("pas",pas);
      p.put("bd",bd);
       FileOutputStream out = new FileOutputStream(ruta);
      p.save(out, "parametros");

      //System.out.println(ip+base+puerto+us+pas);
      }
      catch(Exception e)
      {
         //JOptionPane.showMessageDialog(null,e.getMessage());
         e.printStackTrace();
      }
    }

    public String getIP()
    {
        return ip;
    }
    public String getBase()
    {
        return base;
    }
    public String getPuerto()
    {
        return puerto;
    }
    public String getUs()
    {
        return us;
    }
   public String getPas()
    {
        return pas;
    }
   public String getBd()
    {
        return bd;
    }
   public String getUrl(){
   return url;
   }
}
