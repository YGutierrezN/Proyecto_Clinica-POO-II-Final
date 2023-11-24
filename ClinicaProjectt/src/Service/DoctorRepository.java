/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Doctor;
import Model.Doctor;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.Conexion;
import view.menuPrincipal;

/**
 *
 * @author Jx
 */
public class DoctorRepository implements IDoctor {

    @Override
    public List<Doctor> getAllDoctors() {
       try
        {
            /*Crear arreglo dinamico*/
            List<Doctor> lstDoctor = new ArrayList<>();
            
            /*Llamar al Store Procedure*/
            
            CallableStatement ceDoctor = Conexion.ObtenerConexion().prepareCall("{CALL USPListarDoctores()}");
            ResultSet rsDoctor = ceDoctor.executeQuery();
            while(rsDoctor.next())
            {
                Doctor objDoctor = new Doctor();
                
                objDoctor.setId(rsDoctor.getString("Id_doctor"));
                objDoctor.setNombre(rsDoctor.getString("nombre_doctor"));
                objDoctor.setEspecialidad(rsDoctor.getString("nombre_especialidad"));
                
                lstDoctor.add(objDoctor);
                
                
            }
            return lstDoctor;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

   

    @Override
    public void addDoctor(Doctor obj) {
       
         try
        {
            PreparedStatement stDoctor = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPAgregarDoctor(?,?,?)}");
            
            stDoctor.setString(1,obj.getId());
            stDoctor.setString(2,obj.getNombre());
            
            if(obj.getEspecialidad().equals("Medicina general"))
            {
                stDoctor.setString(3,"1");
            }
            else if (obj.getEspecialidad().equals("Pediatria"))
            {
                stDoctor.setString(3,"2");
            }
            else if(obj.getEspecialidad().equals("Ginecologia"))
            {
                 stDoctor.setString(3,"3");
            }
            else
            {
                 stDoctor.setString(3,"4");
            }
            
            
            
            stDoctor.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        
    }

    @Override
    public void updateDoctor(Doctor obj) {
        
        try
        {
            PreparedStatement stDoctor = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEditarDoctor(?,?,?)}");
             stDoctor.setString(1,obj.getId());
            stDoctor.setString(2,obj.getNombre());
            
            if(obj.getEspecialidad().equals("Medicina general"))
            {
                stDoctor.setString(3,"1");
            }
            else if (obj.getEspecialidad().equals("Pediatria"))
            {
                stDoctor.setString(3,"2");
            }
            else if(obj.getEspecialidad().equals("Ginecologia"))
            {
                 stDoctor.setString(3,"3");
            }
            else
            {
                 stDoctor.setString(3,"4");
            }
            
            
            
            stDoctor.executeUpdate();/*Grabar en la BD*/              
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void removeDoctor(Doctor obj) {
        try
        {
            PreparedStatement stDoctor = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEliminarDoctor(?)}");
            stDoctor.setString(1,obj.getId());
            
            stDoctor.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public List<Doctor> getAllBuscarDoctor(Doctor obj) {
         
        try
        {
            /*Crear el arreglo dinamico*/
            List<Doctor> lstDoctor = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceDoctor = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarDoctor(?)}");
            ceDoctor.setString(1,obj.getNombre());

            ResultSet rsDoctor = ceDoctor.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            while(rsDoctor.next())    
            {
                Doctor objUsu = new Doctor();
                
                objUsu.setId(rsDoctor.getString("Id_doctor"));
                objUsu.setNombre(rsDoctor.getString("nombre_doctor"));
                
                
                if(rsDoctor.getString("nombre_especialidad").equals("1"))
                {
                    objUsu.setEspecialidad("Medicina general");
                }
                else if(rsDoctor.getString("nombre_especialidad").equals("2"))
                {
                    objUsu.setEspecialidad("Pediatria");
                }
                else if(rsDoctor.getString("nombre_especialidad").equals("3"))
                {
                    objUsu.setEspecialidad("Ginecologia");
                }
                else
                {
                    objUsu.setEspecialidad("Cardiologia");
                }
                
                
                lstDoctor.add(objUsu);
            }
            return lstDoctor;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }
        
    
}
