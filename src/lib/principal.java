/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author lenin
 */
public interface principal {
      public  String getIdusuario();

    /**
     * @param aIdusuario the idusuario to set
     */
    public  void setIdusuario(String aIdusuario);

    /**
     * @return the usuario
     */
    public  String getUsuario();

    /**
     * @param aUsuario the usuario to set
     */
    public  void setUsuario(String aUsuario) ;

    /**
     * @return the idsucursal
     */
    public  String getIdsucursal() ;
    /**
     * @param aIdsucursal the idsucursal to set
     */
    public  void setIdsucursal(String aIdsucursal) ;

    /**
     * @return the sucursal
     */
    public  String getSucursal();

    /**
     * @param aSucursal the sucursal to set
     */
    public  void setSucursal(String aSucursal) ;

}
