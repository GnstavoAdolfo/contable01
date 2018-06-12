/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Tarea;

/**
 * 
 * @author Fernando
 */
public class Tareas_servicio {
    
    private final String tabla = "db_cliente";
    
    public void guardar(Connection conexion, Tarea tarea) throws SQLException{
        try{
            PreparedStatement consulta;
            if(tarea.getUno() == null){
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(uno, dos, tres, cuatro, cinco) VALUES(NULL, ?, ?, ?, ?)");
                //consulta.setInt(1, tarea.getUno());
                consulta.setString(1, tarea.getDos());
                consulta.setString(2, tarea.getTres());
                consulta.setInt(3, tarea.getCuatro());
                consulta.setString(4, tarea.getCinco());
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET dos = ?, tres = ?, cuatro = ?, cinco = ? WHERE uno = ?");
                consulta.setString(1, tarea.getDos());
                consulta.setString(2, tarea.getTres());
                consulta.setInt(3, tarea.getCuatro());
                consulta.setString(4, tarea.getCinco());
                consulta.setInt(5, tarea.getUno());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Tarea recuperarPorId(Connection conexion, Integer uno) throws SQLException {
        Tarea tarea = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT uno, dos, tres, cuatro, cinco FROM " + this.tabla + " WHERE uno = ?" );
            consulta.setInt(1, uno);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tarea = new Tarea(uno, resultado.getString("dos"), resultado.getString("tres"), resultado.getInt("cuatro"), resultado.getString("cinco"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tarea;
    }
    
    public void eliminar(Connection conexion, Tarea tarea) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE uno = ?");
            consulta.setInt(1, tarea.getUno());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<Tarea> recuperarTodas(Connection conexion) throws SQLException{
        List<Tarea> tareas = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT uno, dos, tres, cuatro, cinco FROM " + this.tabla);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tareas.add(new Tarea(resultado.getInt("uno"), resultado.getString("dos"), resultado.getString("tres"), resultado.getInt("cuatro"), resultado.getString("cinco")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tareas;
    }
    
}
