/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cita;
import Model.Doctor;
import Model.DoctorxEspecialidad;
import Service.CitaRepository;
import Service.DoctorRepository;
import java.util.List;

/**
 *
 * @author Jx
 */
public class CitaController {
    
    public List<Cita> getAllCitasController()
    {
        return new CitaRepository().getAllCitas();
        
    } 
     public List<DoctorxEspecialidad> getAllDoctoresxEspecialidadController(DoctorxEspecialidad obj)
    {
        return new CitaRepository().getAllDoctoresxEspecialidad(obj);
        
    } 
     
     public void addCitaController (Cita obj)
    {
        new CitaRepository().addCita(obj);
    }
    
     public void updateCitaController (Cita obj)
    {
        new CitaRepository().updateCita(obj);
    }
    
    public void EliminarCitaController(Cita obj)
    {
        new CitaRepository().removeCita(obj);
    }
    
    public List<Cita> getBuscarCitaController(Cita obj)
    {
        return new CitaRepository().getAllBuscarCita(obj);
    } 
     
     
}
