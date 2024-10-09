/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paul.pe.cnegocio;
import com.paul.pe.cdatosDao.TipoDocumentosDao;
import com.paul.pe.cmodelos.TipoDocumento;
 

import com.paul.pe.db.Conexion;
import java.sql.SQLException;
import java.sql.Connection;

public class TipoDocumentoBO {
    private String mensaje;
    TipoDocumentosDao tdd = new TipoDocumentosDao();
    
    public String modificarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.modificarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
}


