/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paul.pe.cdatosDao;

import com.paul.pe.cmodelos.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alumno-PB203
 */
public class TipoDocumentosDao {
    private String mensaje;
    //primer metodo-insertar tipo documentos a la db
        public String agregarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "INSERT INTO TIPO_DOCUMENTO(NOMBRE,SIGLA,ESTADO,ORDEN,FECHA_ACTUALIZA) "
        + "VALUES(?,?,?,?,?)";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
            ps.setString(5, tipoDocumento.getFechaActualiza());
            
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue creado correctamente";
        } catch (Exception e) {
            mensaje = "Alto error al crear tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

//segundo metodo eliminar 
    
        public String eliminarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "DELETE FROM TIPO_DOCUMENTO WHERE ID_TIPO_DOCUMENTO =?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoDocumento.getIdTipoDocumento());
            
          
            
            ps.execute();
            ps.close();
            mensaje ="EL TELIPO DE DOCUMENTO FUE eliminado CORRECTAMENTE";
            System.out.println("");
        } catch (SQLException e) {
            mensaje= "!ALTO¡ERROR AL eliminar TIPO DOCUMENTO. "+ e.getMessage();
            System.out.println(e.getMessage());
        }finally{
            
        }
        return mensaje;
    }
        //TERCER METODO MODIFICAR 
            public String modificarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "UPDATE TIPO_DOCUMENTO "
                + " SET NOMBRE=?,SIGLA=?,ESTADO=?,ORDEN=?"
                + " WHERE ID_TIPO_DOCUMENTO =?";
      try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
            
            //ps.setString(5, tipoDocumento.getFechaActualiza());
            ps.setInt(5, tipoDocumento.getIdTipoDocumento());

            
        ps.executeUpdate();
   
       
            
            
            
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue modificado correctamente";
        } catch (Exception e) {
            mensaje = "Alto error al modificar el tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

}


