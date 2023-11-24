/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.DoctorController;
import Controller.PacienteController;
import Model.Cita;
import Model.Cita;
import Model.Doctor;
import Model.DoctorxEspecialidad;
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
public class CitaRepository implements ICita{

    @Override
    public List<Cita> getAllCitas() {
        try
        {
            /*Crear arreglo dinamico*/
            List<Cita> lstCita = new ArrayList<>();
            
            /*Llamar al Store Procedure*/
            
            CallableStatement ceCita = Conexion.ObtenerConexion().prepareCall("{CALL USPListarCitas()}");
            ResultSet rsCita = ceCita.executeQuery();
            while(rsCita.next())
            {
                Cita objCita = new Cita();
                
                objCita.setId(rsCita.getString("Id_cita"));
                objCita.setFecha(rsCita.getString("fec_cita"));
                objCita.setNom_paciente(rsCita.getString("nombre_paciente"));
                objCita.setNom_doctor(rsCita.getString("nombre_doctor"));
                objCita.setEstado_cita(rsCita.getString("estado_cita"));
                objCita.setNom_especialidad(rsCita.getString("nombre_especialidad"));
                
                
                
                lstCita.add(objCita);
                
                
            }
            return lstCita;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<DoctorxEspecialidad> getAllDoctoresxEspecialidad(DoctorxEspecialidad obj) {
       
        
        try
        {
            /*Crear arreglo dinamico*/
            List<DoctorxEspecialidad> lstDoc = new ArrayList<>();
            
            /*Llamar al Store Procedure*/
            
            CallableStatement ceDoc = Conexion.ObtenerConexion().prepareCall("{CALL USPDoctorxEspecialidad(?)}");
            ceDoc.setString(1,obj.getDoc());
            ResultSet rsDoc = ceDoc.executeQuery();
            while(rsDoc.next())
            {
                DoctorxEspecialidad objDoc = new DoctorxEspecialidad();
                
                objDoc.setEspec(rsDoc.getString("nombre_doctor"));
                
                
                
                
                lstDoc.add(objDoc);
                
                
            }
            return lstDoc;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
        
        
    }

    @Override
    public void addCita(Cita obj) {
        try
        {
            DoctorController doc = new DoctorController();
            PacienteController pac = new PacienteController();
            
            List<Doctor> lstDoc = doc.getAllDoctoresController();
            List<Paciente> lstPac = pac.getAllPacientesController();
            
            PreparedStatement stCita = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPAddCita(?,?,?,?,?)}");
            
            stCita.setString(1,obj.getId());
            stCita.setString(2,obj.getFecha());
            
            for(Doctor x : lstDoc)
            {
                if(obj.getNom_doctor().equals(x.getNombre()))
            {
                stCita.setString(3,x.getId());
            }
            }
            
            for(Paciente y : lstPac)
            {
                if(obj.getNom_paciente().equals(y.getNombre()))
            {
                stCita.setString(4,y.getId());
            }
            }
            
            
            
            if(obj.getEstado_cita().equals("PENDIENTE"))
            {
                stCita.setString(5,"PENDIENTE");
            }
            else if (obj.getEstado_cita().equals("CONFIRMADA"))
            {
                stCita.setString(5,"CONFIRMADA");
            }
            else 
            {
                 stCita.setString(5,"ESPERA");
            }
           
            
            
            
            
            stCita.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void updateCita(Cita obj) {
        
        try
        {
            DoctorController doc = new DoctorController();
            PacienteController pac = new PacienteController();
            
            List<Doctor> lstDoc = doc.getAllDoctoresController();
            List<Paciente> lstPac = pac.getAllPacientesController();
            
            PreparedStatement stCita = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEditarCita(?,?,?,?,?)}");
            
            stCita.setString(1,obj.getId());
            stCita.setString(2,obj.getFecha());
            
            for(Doctor x : lstDoc)
            {
                if(obj.getNom_doctor().equals(x.getNombre()))
            {
                stCita.setString(3,x.getId());
            }
            }
            
            for(Paciente y : lstPac)
            {
                if(obj.getNom_paciente().equals(y.getNombre()))
            {
                stCita.setString(4,y.getId());
            }
            }
            
            
            
            if(obj.getEstado_cita().equals("PENDIENTE"))
            {
                stCita.setString(5,"PENDIENTE");
            }
            else if (obj.getEstado_cita().equals("CONFIRMADA"))
            {
                stCita.setString(5,"CONFIRMADA");
            }
            else 
            {
                 stCita.setString(5,"ESPERA");
            }
           
            
            
            
            
            stCita.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        
    }

    @Override
    public void removeCita(Cita obj) {
        
        try
        {
            PreparedStatement stCita = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEliminarCita(?)}");
            stCita.setString(1,obj.getId());
            
            stCita.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
    }

    @Override
    public List<Cita> getAllBuscarCita(Cita obj) {
        
        
        
        try
        {
            
            DoctorController doc = new DoctorController();
            PacienteController pac = new PacienteController();
            
            List<Doctor> lstDoc = doc.getAllDoctoresController();
            List<Paciente> lstPac = pac.getAllPacientesController();
            
            /*Crear el arreglo dinamico*/
            List<Cita> lstCita = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceCita = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarCita(?)}");
            String id = "";
            for(Paciente y : lstPac)
            {
                if(obj.getNom_paciente().equals(y.getNombre()))
                {
                    
                    id = y.getId();
                    
                }
            }
            
            ceCita.setString(1,id);
             ResultSet rsCita = ceCita.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/

           
            while(rsCita.next())    
            {
                Cita objUsu = new Cita();
                
                objUsu.setId(rsCita.getString("Id_cita"));
                objUsu.setFecha(rsCita.getString("fec_cita"));
                
                
                
                 for(Doctor x : lstDoc)
            {
                if(rsCita.getString("Id_doctor").equals(x.getId()))
            {
                objUsu.setNom_doctor(x.getNombre());
            }
            }
                 
                 for(Paciente y : lstPac)
            {
                if(rsCita.getString("Id_paciente").equals(y.getId()))
            {
                objUsu.setNom_paciente(y.getNombre());
            }
            }
            
              objUsu.setEstado_cita(rsCita.getString("estado_cita"));
                
                
                
                
                lstCita.add(objUsu);
            }
            return lstCita;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }
        
        
    
    
}
