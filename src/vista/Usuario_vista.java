/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Image;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BeanLogin;
import javax.swing.JOptionPane;
import lib.clases_cripto;
import lib.principal;
import orm.Baguera;
import lib.Clases_method;
import model.Usuario;

/**
 *
 * @author lenin
 */
public class Usuario_vista extends javax.swing.JFrame implements principal {

    private static int visible;
    public static String clase;
    public static String idusuario;
    public static String usuario;
    public static String idsucursal;
    public static String sucursal;
    public static String idperfil;
    private static String idempresa;
    private static String empresa;
    private static String fecha_cad;

    /**
     * @return the visible
     */
    public static int getVisible() {
        return visible;
    }

    /**
     * @param aVisible the visible to set
     */
    public static void setVisible(int aVisible) {
        visible = aVisible;
    }

    /**
     * @return the idperfil
     */
    public static String getIdperfil() {
        return idperfil;
    }

    /**
     * @param aIdperfil the idperfil to set
     */
    public static void setIdperfil(String aIdperfil) {
        idperfil = aIdperfil;
    }

    /**
     * @return the idempresa
     */
    public static String getIdempresa() {
        return idempresa;
    }

    /**
     * @param aIdempresa the idempresa to set
     */
    public static void setIdempresa(String aIdempresa) {
        idempresa = aIdempresa;
    }

    /**
     * @return the empresa
     */
    public static String getEmpresa() {
        return empresa;
    }

    /**
     * @param aEmpresa the empresa to set
     */
    public static void setEmpresa(String aEmpresa) {
        empresa = aEmpresa;
    }

    /**
     * @return the fecha_cad
     */
    public static String getFecha_cad() {
        return fecha_cad;
    }

    /**
     * @param aFecha_cad the fecha_cad to set
     */
    public static void setFecha_cad(String aFecha_cad) {
        fecha_cad = aFecha_cad;
    }
    private String n_dias;
    public static String ruc;
    public static String direccion;
    public static String telefono;
    public static String tipo_imp;

    /**
     * Creates new form Usuario
     */
    public Usuario_vista() {
        initComponents();
        //
          java.awt.Dimension dim = getToolkit().getScreenSize();
        java.awt.Rectangle abounds = getBounds();
        setLocation((dim.width - abounds.width) / 2,
        (dim.height - abounds.height) / 2);
        //
           Image imagen=getToolkit().getImage(getClass().getResource("/img/sumak.jpg"));
        setIconImage(imagen);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        usuario_text = new javax.swing.JTextField();
        clave_text = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO DE SESION");
        setLocation(new java.awt.Point(300, 150));

        jLabel1.setText("Usuario");

        jLabel2.setText("Clave");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Plataforma comercial SUMAK");

        jLabel4.setText("Cloudtic inc. @Derechos reservados 2013-2015");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(usuario_text, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clave_text, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(80, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(65, 65, 65))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuario_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(clave_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Usuario us = new Usuario();
        clases_cripto crip = new clases_cripto();
        String usuario = usuario_text.getText();
        String clave = crip.Encriptar(clave_text.getText());
        BeanLogin datos_login = us.login(usuario, clave);
        if ("".equals(datos_login.getId())) {
            JOptionPane.showMessageDialog(this, "El usuario o contraseña no es correcta");
            
        } else {
            
            setVisible(false);
            setIdusuario(datos_login.getId());
            setUsuario(datos_login.getUsuario());
            setIdsucursal(datos_login.getIdsursal());
            setLicencia();
            setIdperfil(datos_login.getIdperfil());

            if (Integer.parseInt(this.getNdias()) > 0) {
                if (Integer.parseInt(this.getNdias()) <= 30) {
                    JOptionPane.showMessageDialog(this, "Le faltan " + this.getNdias() + " Dia(s), Contacte con el proveedor para renovar su licencia!");

                }
                Clases_method cm = new Clases_method() {
                };
                cm.setClase_lib(this.clase);
                cm.setMethod_lib("init");
                cm.set_run_principal();
            } else {                
                JOptionPane.showMessageDialog(this, "Lo Sentimos Su Periodo de Licencia se Terminó!");
              
                 System.exit(0);
            }

//            Principal_vista psv=new Principal_vista();
//            psv.show();
//            psv.setVisible(true);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuario_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario_vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField clave_text;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField usuario_text;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getIdusuario() {
        return this.idusuario;
    }

    @Override
    public void setIdusuario(String aIdusuario) {
        this.idusuario = aIdusuario;
    }

    @Override
    public String getUsuario() {
        return this.usuario;
    }

    @Override
    public void setUsuario(String aUsuario) {
        this.usuario = aUsuario;
    }

    @Override
    public String getIdsucursal() {
        return this.idsucursal;
    }

    @Override
    public void setIdsucursal(String aIdsucursal) {
        this.idsucursal = aIdsucursal;
    }

    @Override
    public String getSucursal() {
        return this.sucursal;
    }

    @Override
    public void setSucursal(String aSucursal) {
        this.sucursal = aSucursal;
    }

    private void setLicencia() {
        Usuario us = new Usuario();
        String[][] datos_lic = us.getlicencia(this.getIdsucursal());
        this.setIdempresa(datos_lic[0][0]);
        this.setEmpresa(datos_lic[0][1]);
        ////////////////
        this.setruc(datos_lic[0][4]);
        this.setDireccion(datos_lic[0][5]);
        this.setTelefono(datos_lic[0][6]);
        ////////////////////////
        this.setFecha_cad(datos_lic[0][2]);
        this.setNdias(datos_lic[0][3]);
        this.setTipoImp(datos_lic[0][7]);
    }

    private void setNdias(String datos_lic) {
        this.n_dias = datos_lic;
    }

    private String getNdias() {
        return this.n_dias;
    }

    private void setruc(String ruc) {
    this.ruc=ruc;
    }

    private void setDireccion(String direccion) {
    this.direccion=direccion;
    }

    private void setTelefono(String telefono) {
    this.telefono=telefono; 
    }

    private void setTipoImp(String imp) {
    this.tipo_imp =imp;
    }
    public  String getTipoImp(){
    return this.tipo_imp;
    }

}
