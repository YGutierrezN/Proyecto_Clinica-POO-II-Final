/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Doctor;
import java.util.List;


/**
 *
 * @author Jx
 */
public interface IDoctor {
    
    List<Doctor> getAllDoctors();
    
    void addDoctor(Doctor obj);
    
    void updateDoctor(Doctor obj); 
    
    void removeDoctor(Doctor obj);
    
    List<Doctor> getAllBuscarDoctor(Doctor obj);
    
}
