
package LogicaUsuario;

import UsuarioDAO.UsuarioDAO;
import Usuario.Usuario;
import static UsuarioDAO.UsuarioDAO.usuarios;

public class UsuarioLogic {

    private static UsuarioDAO usuariodao = new UsuarioDAO();

    public static boolean autentificar(String usuario, String Contraseña) {
        if (obtener(usuario)!=null)
        {
            Usuario usuarioConsulta = obtener(usuario);
            if (usuarioConsulta.getUsuario().equals(usuario) && usuarioConsulta.getContraseña().equals(Contraseña))
            {
                return true;
            }
            else{
                return false;
            }
   
        }else{
            return false;
        }
    }

    public static boolean insertar(Usuario usuario) {
        return usuariodao.insertar(usuario);
    }

    public static boolean modificar(Usuario usuario) {
        return usuariodao.modificar(usuario);
    }

    public static boolean eliminar(String usuario) {
        return usuariodao.eliminar(usuario);
    }

    public static Usuario obtener(String usuario) {
        return usuariodao.obtener(usuario);
    }
     
}
