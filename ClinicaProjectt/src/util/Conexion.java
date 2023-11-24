/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jx
 */
public class Conexion {
     
    public Conexion(){}
    public static Connection ObtenerConexion(){
    Connection cn = null; //Creando la variable conexion
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdclinica","root","");
        System.out.println("Conexion exitosa!!!");
    }
    catch(Exception ex)
    {
        System.out.println("Error al conectar con la BD" +
        ex.getMessage());
    }
    return cn;//si hay una conexion
}
    
    
    
    
   
    
}


  
