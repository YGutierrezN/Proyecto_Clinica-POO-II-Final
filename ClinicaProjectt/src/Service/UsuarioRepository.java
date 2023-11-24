/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.UsuarioController;
import Model.Usuario;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.Conexion;
import view.FormUsuario;
import view.menuPrincipal;

/**
 *
 * @author Jx
 */
public class UsuarioRepository implements IUsuario{

    @Override
    public List<Usuario> getAllUsuarios() {
       try
        {
            /*Crear arreglo dinamico*/
            List<Usuario> lstCuenta = new ArrayList<>();
            
            /*Llamar al Store Procedure*/
            
            CallableStatement ceCuenta = Conexion.ObtenerConexion().prepareCall("{CALL USPListarUsuarios()}");
            ResultSet rsCuenta = ceCuenta.executeQuery();
            while(rsCuenta.next())
            {
                Usuario objCuenta = new Usuario();
                
                objCuenta.setId(rsCuenta.getString("Id_usuario"));
                objCuenta.setNombre(rsCuenta.getString("nombre_usuario"));
                objCuenta.setContraseña(rsCuenta.getString("contrasena"));
                objCuenta.setTipo(rsCuenta.getString("tipo_descripcion"));
                
                lstCuenta.add(objCuenta);
                
                
            }
            return lstCuenta;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void ValidarUsuario(JTextField usu, JPasswordField contra) {
        
         try{
            
            PreparedStatement ceCuenta = Conexion.ObtenerConexion().prepareStatement("{CALL USPValidarUsuario(?,?)}");
            
            ceCuenta.setString(1, usu.getText());
            
            String con = String.valueOf(contra.getPassword());
            
            ceCuenta.setString(2, con );
            
            ResultSet rsCuenta = ceCuenta.executeQuery();
            
            if(rsCuenta.next())
            {
                JOptionPane.showMessageDialog(null,"BIENVENID@");
                menuPrincipal men = new menuPrincipal();
                
                men.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"USUARIO O CONTRASEÑA INVALIDA");
            }
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"ERROR" + e.toString());
        }
        
        
    }

    @Override
    public void addUsuario(Usuario obj) {
       
         try
        {
            PreparedStatement stUsuario = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPInsertarUsuario(?,?,?,?)}");
            
            stUsuario.setString(1,obj.getId());
            stUsuario.setString(2,obj.getNombre());
            stUsuario.setString(3,obj.getContraseña());
            if(obj.getTipo().equals("administrador") )
            {
                stUsuario.setString(4,"1");
            }
            else
            {
                stUsuario.setString(4,"2");
            }
            
            
            
            stUsuario.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        
    }

    @Override
    public void updateUsuario(Usuario obj) {
        
        try
        {
            PreparedStatement stUsuario = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEditarUsuario(?,?,?,?)}");
             stUsuario.setString(1,obj.getId());
            stUsuario.setString(2,obj.getNombre());
            stUsuario.setString(3,obj.getContraseña());
            if(obj.getTipo().equals("administrador") )
            {
                stUsuario.setString(4,"1");
            }
            else
            {
                stUsuario.setString(4,"2");
            }
            
            
            
            stUsuario.executeUpdate();/*Grabar en la BD*/              
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void removeUsuario(Usuario obj) {
        try
        {
            PreparedStatement stUsuario = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPEliminarUsuario(?)}");
            stUsuario.setString(1,obj.getId());
            
            stUsuario.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public List<Usuario> getAllBuscarPorNombre(Usuario obj) {
         
        try
        {
            /*Crear el arreglo dinamico*/
            List<Usuario> lstUsuario = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceUsuario = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarPorNombre(?)}");
            ceUsuario.setString(1,obj.getNombre());

            ResultSet rsUsuario = ceUsuario.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            while(rsUsuario.next())    
            {
                Usuario objUsu = new Usuario();
                
                objUsu.setId(rsUsuario.getString("Id_usuario"));
                objUsu.setNombre(rsUsuario.getString("nombre_usuario"));
                objUsu.setContraseña(rsUsuario.getString("contrasena"));
                
                if(rsUsuario.getString("Id_tipo").equals("1"))
                {
                    objUsu.setTipo("administrador");
                }
                else
                {
                    objUsu.setTipo("secretaria");
                }
                
                
                lstUsuario.add(objUsu);
            }
            return lstUsuario;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void ValidarMantenimiento(JTextField usu, JPasswordField contra) {
       
        try{
            
            
            UsuarioController us = new UsuarioController();
            
            
            List<Usuario> lstUs = us.getAllUsuariosController();
            
            
            
            PreparedStatement ceCuenta = Conexion.ObtenerConexion().prepareStatement("{CALL USPValidar(?,?,?)}");
            
            ceCuenta.setString(1, usu.getText());
            
            String con = String.valueOf(contra.getPassword());
            
            ceCuenta.setString(2, con );
            
           
            
            
            ceCuenta.setString(3, "1" );
            
            ResultSet rsCuenta = ceCuenta.executeQuery();
            
            if(rsCuenta.next())
            {
                JOptionPane.showMessageDialog(null,"BIENVENID@");
                menuPrincipal men = new menuPrincipal();
                FormUsuario usuario = new FormUsuario();
                
                men.setVisible(true);
                men.nuevoPanel(usuario);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"USUARIO O CONTRASEÑA INVALIDA");
            }
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"ERROR" + e.toString());
        }
        
        
        
        
    }
        
        
    

    
    
}
