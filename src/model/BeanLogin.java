/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenin
 */
public class BeanLogin {

    private final String id;
    private final String nombre;
    private final String usuario;
    private final String clave;
    private final String idperfil;
    private final String sucursal;

    public BeanLogin(String id, String nombres, String usuario, String clave, String idperfil, String sucursal) {
        super();
        this.id = id;
        this.nombre = id;
        this.usuario = nombres;
        this.clave = clave;
        this.idperfil = idperfil;
        this.sucursal = sucursal;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public String getIdperfil() {
        return this.idperfil;
    }

    public String getIdsursal() {
        return this.sucursal;
    }
    
}
