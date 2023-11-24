/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Usuario;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jx
 */
public interface IUsuario {
    
    List<Usuario> getAllUsuarios();
    
    void ValidarUsuario(JTextField usu, JPasswordField contra);
    
    void addUsuario(Usuario obj);
    
    void updateUsuario(Usuario obj); 
    
    void removeUsuario(Usuario obj);
    
    List<Usuario> getAllBuscarPorNombre(Usuario obj);
    
    void ValidarMantenimiento(JTextField usu, JPasswordField contra);
    
}
