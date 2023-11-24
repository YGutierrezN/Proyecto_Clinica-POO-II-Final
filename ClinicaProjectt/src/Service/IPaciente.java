/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;


import Model.Paciente;
import java.util.List;


/**
 *
 * @author Jx
 */
public interface IPaciente {
    
    List<Paciente> getAllPacientes();
    
    
    void addPaciente(Paciente obj);
    
    void updatePaciente(Paciente obj); 
    
    void removePaciente(Paciente obj);
    
    List<Paciente> getAllBuscarPaciente(Paciente obj);
    
}
