/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paul.pe.ctest;



import com.paul.pe.cmodelos.TipoDocumento;
import com.paul.pe.cnegocio.TipoDocumentoBO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;


public class Test {
    TipoDocumentoBO tdbo = new TipoDocumentoBO();
    TipoDocumento td = new TipoDocumento();
    
    public void insertar()  throws SQLException, ParseException{
        td.setNombre("Registro Nacional de Identidad");
        td.setEstado("1");
        td.setOrden(1);
        td.setSigla("DNI");
        td.setFechaActualiza("09-10-24");
        //tdbo.agregarTipoDocumento(td
        td.setIdTipoDocumento(11);
    }
    

     public void eliminar()  throws SQLException, ParseException{
        td.setIdTipoDocumento(9);
        tdbo.modificarTipoDocumento(td);
        
    }
     
      public void modificar()  throws SQLException, ParseException{
        td.setNombre("Registro Nacional de Identidad");
        td.setEstado("1");
        td.setOrden(1);
        td.setSigla("DNI");
        //td.setFechaActualiza("09-10-24");
        td.setIdTipoDocumento(1);
        tdbo.modificarTipoDocumento(td);
        
    }
    

    public static void main(String[] args) throws SQLException, ParseException{
        Test t = new Test();
        //t.eliminar();
        t.modificar();
    }
    
    
    
            
}