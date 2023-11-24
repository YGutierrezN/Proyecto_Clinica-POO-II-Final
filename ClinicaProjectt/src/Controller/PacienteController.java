/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Paciente;
import Service.PacienteRepository;
import java.util.List;

/**
 *
 * @author Jx
 */
public class PacienteController {
    
    public List<Paciente> getAllPacientesController()
    {
        return new PacienteRepository().getAllPacientes();
        
    } 
    
    
    public void addPacienteController (Paciente obj)
    {
        new PacienteRepository().addPaciente(obj);
    }
    
    public void updatePacienteController (Paciente obj)
    {
        new PacienteRepository().updatePaciente(obj);
    }
    
    public void EliminarPacienteController(Paciente obj)
    {
        new PacienteRepository().removePaciente(obj);
    }
    
    public List<Paciente> getBuscarPacienteController(Paciente obj)
    {
        return new PacienteRepository().getAllBuscarPaciente(obj);
    } 
    
    
}
