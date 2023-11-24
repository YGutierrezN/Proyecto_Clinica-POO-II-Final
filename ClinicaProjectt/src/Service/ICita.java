/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Cita;
import Model.DoctorxEspecialidad;
import java.util.List;

/**
 *
 * @author Jx
 */
public interface ICita {
    
    List<Cita> getAllCitas();
    List<DoctorxEspecialidad> getAllDoctoresxEspecialidad( DoctorxEspecialidad obj);
    
    void addCita(Cita obj);
    
    void updateCita(Cita obj); 
    
    void removeCita(Cita obj);
    
    List<Cita> getAllBuscarCita(Cita obj);
    
    
}
