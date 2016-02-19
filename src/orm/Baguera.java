/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import java.awt.Frame;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.Conexion;
import lib.DatabaseFactory;
import lib.lib_buscar;
import lib.Clases_method;

/**
 *
 * @author lenin
 */
public class Baguera extends Clases_method {

    static Statement s;

    public static Connection Cone;
    private static ResultSet r;
    private static ResultSetMetaData resulsetmd;
    private static int numColumn;
    private static int numfilas;
    private static String[][] A;
    public static String[] LabelColum;
    public Conexion C, c1;
    static String db;
    static String e;
    static String Data[];
    static Object param[];
    private CallableStatement pa;
    public String table;
    public String consulta = "";
    public String[] dato_dev;
    public int click = 0;
    public static String Clase_lib;
    public static String Method_lib;
    public String consulta_bus;
    private String[] campos_busqueda;

    public Baguera() {
        super();

        File miDir = new File("");

        String ruta = miDir.getAbsolutePath() + "/conf/config.ini";//local cunDO ESTA EN PRODUCCION
        //System.out.println(ruta);
        //String ruta="/root/NetBeansProjects/TarapotoInn/config.ini";
        //String ruta = "/home/lenin/config.ini";
        //String ruta="C://config.ini";
        try {

            DatabaseFactory dbf = new DatabaseFactory();
            String cadena = dbf.create(ruta);
            // JOptionPane.showInputDialog(null, cadena);
            C = new Conexion(cadena, ruta);
            Cone = C.getConexion();
            this.e = C.getError();
        } catch (Exception ex) {
            this.e = ex.getMessage();
        }

    }

    public void commit() throws SQLException {
        Cone.commit();
    }

    public void rolkback() throws SQLException {
        Cone.rollback();
    }

    public void select(String campos) {

        if (campos == null) {
            this.consulta = this.consulta + "select * from " + this.table;
        } else {
            this.consulta = this.consulta + "select " + campos + " from " + this.table;
        }

    }

    public void joins(String joins) {
        this.consulta = this.consulta + " " + joins;
    }

    public void where(String condicion) {
        if (condicion == null) {
            this.consulta = this.consulta + "";
        } else {
            this.consulta = this.consulta + " where " + condicion;
        }
    }

    public void order_by(String order) {
        if (order == null) {
            this.consulta = this.consulta + " ";
        } else {
            this.consulta = this.consulta + " order by " + order;
        }

    }

    public void group_by(String order) {
        if (order == null) {
            this.consulta = this.consulta + " ";
        } else {
            this.consulta = this.consulta + " group by " + order;
        }
    }

    public void limit(String limit) {
        if (limit == null) {
            this.consulta = this.consulta + " ";
        } else {
            this.consulta = this.consulta + " limit " + limit;
        }
    }

    public void last() {
        this.order_by(" 1 desc ");
        this.limit(" 1");
    }

    public void firts() {
        this.order_by(" 1 asc");
        this.limit(" 1");
    }

    public void offset(String page) {
        if (page == null) {
            this.consulta = this.consulta + "";
        } else {
            this.consulta = this.consulta + " offset " + page;
        }
    }

    public String getConsulta() {
        return this.consulta;
    }

    public void consulta_search(String[] campos) {
        this.consulta_bus = getConsulta();
        this.campos_busqueda = campos;
    }

    public String getTable() {
        return this.table;
    }

    public Connection conectar() {
        return this.Cone;
    }

    public static String getError() {
        // return e;
        return e;
    }

    public int getfilas() {
        return numfilas;
    }

    public void init_search(String[] campos) {
        Frame f = new Frame();
        lib_buscar lb = new lib_buscar(f, true);
        lb.campos = campos;
        lb.consulta_bus = this.consulta_bus;
        lb.campos_busqueda = this.campos_busqueda;
        lb.Clase_lib = this.Clase_lib;
        lb.Method_lib = this.Method_lib;
        lb.datos = Execute(this.consulta);
        lb.iniciar();
        lb.setVisible(true);

    }

    public String Ejecute_query(String Q) {
        String b;
        try {
            b = "true";
            s = Cone.createStatement();
            r = s.executeQuery(Q);
            r.close();
        } catch (Exception e) {
            b = e.getMessage();
        }
        return b;
    }

    public String Ejecute(String Q) {
        String b;
        try {
            b = "true";
            s = Cone.createStatement();
            s.executeUpdate(Q);
            s.close();
        } catch (Exception e) {
            b = e.getMessage();
        }
        return b;
    }

    public HashMap[] Execute_object(String Q) {
        HashMap ht[] = null;
        HashMap htt;
        String sql = Q;
        try {

            s = Cone.createStatement();
            r = s.executeQuery(sql);

            resulsetmd = r.getMetaData();
            //System.out.print(r.getRow());
            numColumn = resulsetmd.getColumnCount();
            String LabelColumn[];
            LabelColumn = new String[numColumn];
            for (int k = 0; k < numColumn; k++) {
                LabelColumn[k] = resulsetmd.getColumnName(k + 1);
            }

            numfilas = 0;
            while (r.next()) {
                numfilas++;

            }
            ht = new HashMap[numfilas];
            A = new String[numfilas][numColumn];
            r.beforeFirst();
            for (int i = 0; i < numfilas; i++) {
                r.next();
                htt = new HashMap();
                for (int j = 0; j < numColumn; j++) {
                    A[i][j] = r.getString(j + 1);
                    //System.out.print(LabelColumn[j]);
                    htt.put(LabelColumn[j], r.getString(j + 1));

                    //ht[i].put(LabelColumn[j], r.getObject(j+1));
                }
                //System.out.print(htt);
                ht[i] = (htt);
            }
            r.close();
            ///finalizamos para retornar
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ht;
    }

    public String[][] Execute(String Q) {

        String sql = Q;
        try {

            s = Cone.createStatement();
            r = s.executeQuery(sql);

            resulsetmd = r.getMetaData();
            //System.out.print(r.getRow());
            numColumn = resulsetmd.getColumnCount();

            numfilas = 0;
            while (r.next()) {
                numfilas++;

            }

            A = new String[numfilas][numColumn];
            r.beforeFirst();
//            r.close();
//            r = s.executeQuery(sql);
            for (int i = 0; i < numfilas; i++) {

                //Va a la siguiente fila
                r.next();

                for (int j = 0; j < numColumn; j++) {

                    //Obtiene el valor de cada una de las columnas en la fila actual
                    //System.out.println(r.getString(j+1));
                    A[i][j] = r.getString(j + 1);
                }

            }
            r.close();

            ///finalizamos para retornar
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        return A;

    }

    //@SuppressWarnings("static-access")
    public String[][] query(String Q) {
        /* cone=(Connection) new conexion();*/
        //conexion c=new conexion();
        // System.out.print(db);
        String sql = "select * from " + Q;

        try {

            //Conexion c=new Conexion();
            //   c1=new Conexion("","");
            // Cone=c1.getConexion();
            //System.out.print(Cone);
            s = Cone.createStatement();
            r = s.executeQuery(sql);
            resulsetmd = r.getMetaData();
            //Obtiene los metadatos del ResultSet
            numColumn = resulsetmd.getColumnCount();
            /* LabelColum=new String[numColumn];
             for(int k=0;k<numColumn;k++)
             {
             LabelColum[k]=resulsetmd.getColumnName(k+1);
             }*/

            //System.out.println(numColumn);
            // numfilas=r.getRow();
            numfilas = 0;
            while (r.next()) {
                numfilas++;

            }
            //System.out.println( numfilas);
            // LabelColum=new String[numfilas];
            //LabelColum=new String[numColumn];
            A = new String[numfilas][numColumn];

            //Ubica el cursor antes del a primera fila
            //r.beforeFirst();
            //obtenemos el array de datos de la base de datos
          /* int k=0;
             while(r.next())
             {
             for(int j=0;j<numColumn;j++)
             {
             A[k][j]=r.getString(j+1);
             }
             k++;
             }*/
//            r.close();
//            r = s.executeQuery(sql);
            r.beforeFirst();
            for (int i = 0; i < numfilas; i++) {

                //Va a la siguiente fila
                r.next();

                for (int j = 0; j < numColumn; j++) {

                    //Obtiene el valor de cada una de las columnas en la fila actual
                    //System.out.println(r.getString(j+1));
                    A[i][j] = r.getString(j + 1);
                }

            }
            r.close();

            ///finalizamos para retornar
        } catch (SQLException ex) {
            // Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null,ex.toString());
            //A[0][0]="error de conexion"+ex.getMessage();
            ex.printStackTrace();

        }
        return A;

    }

    public String[] FindQuery(String camp) {

        try {
            s = Cone.createStatement();
            r = s.executeQuery("select * from " + this.table + " limit 1");

            //System.out.println(Q+" where "+id+"= "+camp);
            resulsetmd = r.getMetaData();
            //Obtiene los metadatos del ResultSet
            numColumn = resulsetmd.getColumnCount();
            Data = new String[numColumn];
            String id = resulsetmd.getColumnName(1);
            r.close();
            String sql = "select * from " + this.table + " where " + id + "= " + camp;
            // System.out.println(sql);
            r = s.executeQuery(sql);

            while (r.next()) {
                for (int k = 0; k < numColumn; k++) {
                    Data[k] = r.getString(k + 1);
                }
            }
            r.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Data;
    }

    ///
    public String[] getMaxId(String Q) {
        try {
            s = Cone.createStatement();
            r = s.executeQuery("select *from " + Q + " limit 1");
            //System.out.println(Q+" where "+id+"= "+camp);
            resulsetmd = r.getMetaData();
            //Obtiene los metadatos del ResultSet
            numColumn = resulsetmd.getColumnCount();
            Data = new String[numColumn];
            String id = resulsetmd.getColumnName(1);
            r.close();
            String sql = "select max(" + id + ") from " + Q;
            // System.out.println(sql);
            r = s.executeQuery(sql);

            while (r.next()) {
                for (int k = 0; k < numColumn; k++) {
                    Data[k] = r.getString(k + 1);
                }
            }
            r.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Data;
    }

    //
    public String[] getLabelColumn(String Q) {

        try {

            //Conexion c=new Conexion();
            //   c1=new Conexion("","");
            // Cone=c1.getConexion();
            //System.out.print(Cone);
            String sql = "select *from " + Q + " limit 1";
            s = Cone.createStatement();
            r = s.executeQuery(sql);
            resulsetmd = r.getMetaData();
            //Obtiene los metadatos del ResultSet
            numColumn = resulsetmd.getColumnCount();
            LabelColum = new String[numColumn];
            for (int k = 0; k < numColumn; k++) {
                LabelColum[k] = resulsetmd.getColumnName(k + 1);
            }
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LabelColum;
    }

    public CallableStatement getCadenaProcedure(String procedure, int cant) {

        String llaves;
        String call = "{call " + procedure + "(";
        for (int j = 1; j <= cant; j++) {
            if (j == 1) {
                llaves = "?";
            } else {
                llaves = ",?";
            }
            call = call + llaves;
        }
        call = call + ")}";
        // System.out.print(call);

        try {
            pa = Cone.prepareCall(call);
            /*
             for(int k=0;k<param.length;k++)
             {
             pa.setObject(k+1, param[k]);
             }
             pa.execute();
             msg="Datos llenados correctamente";*/
        } catch (SQLException ex) {
            Logger.getLogger(Baguera.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return pa;
    }

    public String delete(String table, String cod) {
        String msg = null;
        try {
            msg = "true";
            s = Cone.createStatement();
            r = s.executeQuery("select *from " + table + " limit 1");
            //System.out.println(Q+" where "+id+"= "+camp);
            resulsetmd = r.getMetaData();
            //Obtiene los metadatos del ResultSet
            numColumn = resulsetmd.getColumnCount();
            Data = new String[numColumn];
            String id = resulsetmd.getColumnName(1);
            r.close();

            String sql = "delete from " + table + " where " + id + "= " + cod;
            s.executeUpdate(sql);
            r.close();

        } catch (SQLException ex) {
            //ex.getMessage();
            msg = ex.getMessage();

        }

        return msg;
    }

    public Object[] Save(String[] campos, Object[] object) {
        Object[] camp = null;
        //String[] labelColumn = getLabelColumn(" "+table);
        String sql = "insert into " + this.table + " (";
        String pos_camp = "";
        String values_camp = "";
        String campo_val = "";
        for (int i = 0; i < campos.length; i++) {
            String campo = campos[i];

            campo_val = (String) object[i];

            if (i == ((campos.length) - 1)) {
                pos_camp = pos_camp + "," + campo;
                values_camp = values_camp + ",'" + campo_val + "'";
            } else if (i == 0) {
                pos_camp = pos_camp + " " + campo;
                values_camp = values_camp + "'" + campo_val + "'";
            } else {
                pos_camp = pos_camp + "," + campo;
                values_camp = values_camp + ",'" + campo_val + "'";
            }

        }
        sql = sql + " " + pos_camp + ") values(" + values_camp + ")";

        String resp = Ejecute(sql);

        if (resp == "true") {
            camp = new Object[]{"ok", "Se Ejecuto Correctamente"};
        } else {
            camp = new Object[]{"error", resp};
        }
        return camp;

    }

    public Object[] Edit(String[] campos, Object[] object) {
        Object[] camp = null;
        //String[] labelColumn = getLabelColumn(" "+table);
        String sql = "update  " + this.table + " ";
        String pos_camp = "";
        String values_camp = "";
        String campo_val = "";
        for (int i = 0; i < campos.length; i++) {
            String campo = campos[i];

            campo_val = (String) object[i];

            if (i == ((campos.length) - 1)) {

                values_camp = values_camp + " " + campo + "='" + campo_val + "'";
            } else if (i == 0) {

                values_camp = values_camp + " set ";
            } else {

                values_camp = values_camp + " " + campo + "='" + campo_val + "',";
            }
            // sql=sql+" "+campo+"="+campo_val; 
        }
        sql = sql + " " + values_camp + " where " + campos[0] + "=" + object[0] + " ";

        String resp = Ejecute(sql);

        if (resp == "true") {
            camp = new Object[]{"ok", "Se Ejecuto Correctamente"};
        } else {
            camp = new Object[]{"error", resp};
        }
        return camp;

    }

    public void setExecute() {
        this.setClase_lib(Clase_lib);
        this.setMethod_lib(Method_lib);
        this.setDatos(this.dato_dev);
        this.set_run();
    }
}
