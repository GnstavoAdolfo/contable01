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
import javax.swing.table.DefaultTableModel;
import modelos.Tarea_plan;

/**
 * 
 * @author Fernando
 */
public class Tareas_crear_plan {
    
    private final String tabla = "db_plan";

    
    public void guardar(Connection conexion, Tarea_plan tarea) throws SQLException{
        try{
            PreparedStatement consulta;
            if(tarea.getA1() == null){
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(a1, a2, a3) VALUES(NULL, ?, ?)");
                consulta.setString(1, tarea.getA2());
                consulta.setString(2, tarea.getA3());
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET a2 = ?, a3 = ? WHERE a1 = ?");
                consulta.setString(1, tarea.getA2());
                consulta.setString(2, tarea.getA3());
                consulta.setInt(3, tarea.getA1());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Tarea_plan recuperarPorId(Connection conexion, Integer a1) throws SQLException {
        Tarea_plan tarea_plan = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT a1, a2, a3 FROM " + this.tabla + " WHERE a1 = ?" );
            consulta.setInt(1, a1);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tarea_plan = new Tarea_plan(a1, resultado.getString("a2"), resultado.getString("a3"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tarea_plan;
    }
    
    public void eliminar(Connection conexion, Tarea_plan tarea_plan) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE a1 = ?");
            consulta.setInt(1, tarea_plan.getA1());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<Tarea_plan> recuperarTodas(Connection conexion) throws SQLException{
        List<Tarea_plan> tareas = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT a1, a2, a3 FROM `" + this.tabla + "` ORDER BY `" + this.tabla + "`.`a1`  ASC");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tareas.add(new Tarea_plan(resultado.getInt("a1"), resultado.getString("a2"), resultado.getString("a3")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tareas;
    }
    
}
