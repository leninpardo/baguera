/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.HashMap;
import orm.Baguera;

/**
 *
 * @author lenin
 */
public class Usuario extends Baguera {

    String A[][];
    private BeanLogin busuario;

    public BeanLogin login(String user, String clave) {

        String querys = " empleado where usuario='" + (user) + "' and clave='" + clave + "'";

        try {

            A = this.query(querys);
            if (A.length == 0) {
                busuario = new BeanLogin("", "", "", "", "", "");
            } else {
                // String id, String nombres, String usuario, String clave, String idperfil, String sucursal
                busuario = new BeanLogin(A[0][0], A[0][5], A[0][2], A[0][3], A[0][4], A[0][9]);
            }
        } catch (Exception ex) {
          //  Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            // String A[][]=new String[0][0];
            // A[0][0]=ex.getMessage();
            //JOptionPane.showMessageDialog(null,ex.toString());
            //ex.printStackTrace();
            //System.out.print(ex.getMessage());
            //ex.printStackTrace();
            ex.printStackTrace();
        }
        return busuario;
    }

    public String[][] getlicencia(String id) {
        this.table = "sucursal";
        String[] sucursal = FindQuery(id);
        String[][] datos_empresas = Execute("SELECT empresas.idempresa,empresas.razon_social,licencia.fecha_caduca, DATEDIFF(licencia.fecha_caduca,CURRENT_DATE()) as n_dias,ruc,direccion,telefono,tipo_impresion from empresas INNER JOIN licencia on(licencia.idempresa=empresas.idempresa)\n"
                + "WHERE empresas.idempresa=" + sucursal[0]);
//        HashMap[] ret = Execute_object(" select idproducto,descripcion_corta,marcas.nombre,familia.familia"
//                + " from producto"
//                + " inner join marcas on(marcas.idmarca=producto.marca) inner join familia on(familia.idfamilia=producto.familia)");
        return datos_empresas;
    }
}
