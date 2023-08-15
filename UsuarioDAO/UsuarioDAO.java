
package UsuarioDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import Usuario.Usuario;


public class UsuarioDAO {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public UsuarioDAO() {}

    
    
    public int buscar(String usuario) {
        int n = -1;
        for (int i = 0; i < usuarios.size(); i++)
        {
            if (usuarios.get(i).getUsuario().equals(usuario))
            {
                n = i;
                break;
            }
        }
        return n;
    }

    public boolean insertar(Usuario usuario) {
        if (buscar(usuario.getUsuario()) == -1)
        {
            usuarios.add(usuario);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean modificar(Usuario usuario) {
        if (buscar(usuario.getUsuario()) != -1)
        {
            Usuario usuarioaux = obtener(usuario.getUsuario());
            usuarioaux.setContraseña(usuario.getContraseña());
            usuarioaux.setNombres(usuario.getNombres());
           

            return true;
        } else
        {
            return false;
        }
    }

    public boolean eliminar(String usuario) {
        if (buscar(usuario) != -1)
        {
            usuarios.remove(buscar(usuario));
            return true;
        } else
        {
            return false;
        }
    }

    public Usuario obtener(String usuario) {
        if (buscar(usuario) != -1)
        {
            return usuarios.get(buscar(usuario));
        } else
        {
            return null;
        }
    }
    
    public static void ListaJuegos (String usuario,String modogane){
         for(Usuario user: usuarios){
             if (user.usuario.equals(usuario)){
                 user.partidas.add(modogane);
             }
         }
     }

    public static void agregarPuntos(Usuario usr){
        int _puntos = usr.getPuntos();
        usr.setPunto(_puntos+3);
    }
    
    public static void agregarReportes(Usuario usr, String _mensaje){
        usr.getListaJuegos().add(_mensaje);
    }
    
}
