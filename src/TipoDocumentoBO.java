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
   public void listarTipoDocumento(jTable table){

       

}
