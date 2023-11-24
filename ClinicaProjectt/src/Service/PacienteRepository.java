/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Paciente;
import Model.Paciente;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

/**
 *
 * @author Jx
 */
public class PacienteRepository implements IPaciente{

   @Override
    public List<Paciente> getAllPacientes() {
       try
        {
            /*Crear arreglo dinamico*/
            List<Paciente> lstPaciente = new ArrayList<>();
            
            /*Llamar al Store Procedure*/
            
            CallableStatement cePaciente = Conexion.ObtenerConexion().prepareCall("{CALL USPListarPacientes()}");
            ResultSet rsPaciente = cePaciente.executeQuery();
            while(rsPaciente.next())
            {
                Paciente objPaciente = new Paciente();
                
                objPaciente.setId(rsPaciente.getString("Id_paciente"));
                objPaciente.setNombre(rsPaciente.getString("nombre_paciente"));
                objPaciente.setApellidos(rsPaciente.getString("apellidos"));
                objPaciente.setEdad(rsPaciente.getString("edad"));
                objPaciente.setDni(rsPaciente.getString("dni"));
                
                if((rsPaciente.getString("sexo").equals("M")))
                {
                    objPaciente.setSexo("Masculino");
                }
                else
                {
                    objPaciente.setSexo("Femenino");
                }
                  
                        
                
                
                
                lstPaciente.add(objPaciente);
                
                
            }
            return lstPaciente;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

   

    @Override
    public void addPaciente(Paciente obj) {
       
         try
        {
            PreparedStatement stPaciente = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPAgregarPaciente(?,?,?,?,?,?) }");
            
            stPaciente.setString(1,obj.getId());
            stPaciente.setString(2,obj.getNombre());
            stPaciente.setString(3,obj.getApellidos());
            stPaciente.setString(4,obj.getEdad());
            stPaciente.setString(5,obj.getDni());
            
            if(obj.getSexo().equals("Masculino"))
            {
                stPaciente.setString(6,"M");
            }
            
            else
            {
                 stPaciente.setString(6,"F");
            }
            
            
            
            stPaciente.executeUpdate();//Grabar en la BD                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        
    }

    @Override
    public void updatePaciente(Paciente obj) {
        
        try
        {
            PreparedStatement stPaciente = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEditarPaciente(?,?,?,?,?,?)}");
             stPaciente.setString(1,obj.getId());
            stPaciente.setString(2,obj.getNombre());
            stPaciente.setString(3,obj.getApellidos());
            stPaciente.setString(4,obj.getEdad());
            stPaciente.setString(5,obj.getDni());
            
            if(obj.getSexo().equals("Masculino"))
            {
                stPaciente.setString(6,"M");
            }
            
            else
            {
                 stPaciente.setString(6,"F");
            }
            
            
            
            stPaciente.executeUpdate();//Grabar en la BD              
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void removePaciente(Paciente obj) {
        try
        {
            PreparedStatement stPaciente = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEliminarPaciente(?)}");
            stPaciente.setString(1,obj.getId());
            
            stPaciente.executeUpdate();//Grabar en la BD                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public List<Paciente> getAllBuscarPaciente(Paciente obj) {
         
        try
        {
            
            List<Paciente> lstPaciente = new ArrayList<>();
            
            CallableStatement cePaciente = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarPaciente(?)}");
            cePaciente.setString(1,obj.getNombre());

            ResultSet rsPaciente = cePaciente.executeQuery();
            while(rsPaciente.next())    
            {
                Paciente objUsu = new Paciente();
                
                objUsu.setId(rsPaciente.getString("Id_paciente"));
                objUsu.setNombre(rsPaciente.getString("nombre_paciente"));
                objUsu.setApellidos(rsPaciente.getString("apellidos"));
                objUsu.setEdad(rsPaciente.getString("edad"));
                objUsu.setDni(rsPaciente.getString("dni"));
                
                
                
                if(rsPaciente.getString("sexo").equals("M"))
                {
                    objUsu.setSexo("Masculino");
                }
                
                else
                {
                    objUsu.setSexo("Femenino");
                }
                
                
                lstPaciente.add(objUsu);
            }
            return lstPaciente;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }
        
    
}
