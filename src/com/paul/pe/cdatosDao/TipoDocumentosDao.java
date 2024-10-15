/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paul.pe.cdatosDao;

import com.paul.pe.cmodelos.TipoDocumento;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
//cuarto metodo  - listar tipo dcumento
            public void listarTipoDocumento(Connection conn, JTable table){
                DefaultTableModel model;
                Statement Statement = null;
                resultedSet resultedSet = null;
                
                String[] columnas("ID","NOMBRE","SIGLA","ESTADO","ORDEN","FECHAACTUALIZACION");
                model = new DefaultTableModel(null, columnas);
                
                String sql ="SELEC * FROM TIPO DOCUEMENTO";
                String[]datosTP =new String[6];
                   try {
                    Statement = (Statement) conn.createStatement();
                    resultedSet= Statement.executeQuery(sql);
                    while(resultedSet.next()){
                        TipoDocumento td = new TipoDocumento();
                        td.setIdTipoDocumento(resultSet.getInt("ID_TIPO_DOCUMENTO"));
                        td.setNombre(resultSet.getString("NOMBRE"));
                        td.setEstado(resultSet.getString("ESTADO");
                        td.setOrden(resultSet.getInt("ORDEN");
                        td.setSigla(resultSet.getString("SIGLA");
                        td.setFechaActualiza(resultSet.getString("FECHA_REGISTRO");
                        
                        
                        datosTP[0] =td.getIdTipoDocumento()+"";
                        datosTP[1] =td.getNombre()+"";
                        datosTP[2] =""+td.getSigla();
                        datosTP[3] =td.getEstado()+"";
                        datosTP[4] =td.getOrden()+"";
                        datosTP[5] =td.getFechaActualiza()+"";
                        
                        model.addRow(datosTP);
                    }
                    table.setModel(model);
                } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, mensaje, sql, 0);
                       System.out.println(e.getMessage());

                }
                   
            }
}
//


