/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import Service.UsuarioRepository;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jx
 */
public class UsuarioController {
    
    public List<Usuario> getAllUsuariosController()
    {
        return new UsuarioRepository().getAllUsuarios();
        
    } 
    
    public void ValidarUsuarioController(JTextField usu, JPasswordField contra) 
    {
        new UsuarioRepository().ValidarUsuario(usu, contra);
    }
    
    public void addUsuarioController (Usuario obj)
    {
        new UsuarioRepository().addUsuario(obj);
    }
    
    public void updateUsuarioController (Usuario obj)
    {
        new UsuarioRepository().updateUsuario(obj);
    }
    
    public void EliminarUsuarioController(Usuario obj)
    {
        new UsuarioRepository().removeUsuario(obj);
    }
    
    public List<Usuario> getBuscarPorNombreController(Usuario obj)
    {
        return new UsuarioRepository().getAllBuscarPorNombre(obj);
    } 
    
    public void ValidarMantenimientoController(JTextField usu, JPasswordField contra) 
    {
        new UsuarioRepository().ValidarMantenimiento(usu, contra);
    }
}
