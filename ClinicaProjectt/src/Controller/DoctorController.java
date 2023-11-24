/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Doctor;
import Service.DoctorRepository;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jx
 */
public class DoctorController {
    public List<Doctor> getAllDoctoresController()
    {
        return new DoctorRepository().getAllDoctors();
        
    } 
    
    
    public void addDoctorController (Doctor obj)
    {
        new DoctorRepository().addDoctor(obj);
    }
    
    public void updateDoctorController (Doctor obj)
    {
        new DoctorRepository().updateDoctor(obj);
    }
    
    public void EliminarDoctorController(Doctor obj)
    {
        new DoctorRepository().removeDoctor(obj);
    }
    
    public List<Doctor> getBuscarDoctorController(Doctor obj)
    {
        return new DoctorRepository().getAllBuscarDoctor(obj);
    } 
}
