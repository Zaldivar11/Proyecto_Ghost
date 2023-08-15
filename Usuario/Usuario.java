
package Usuario;

import java.util.ArrayList;

public class Usuario {

    public String usuario;
    private String Contraseña;
    private String nombres;
    private int puntos;
    public ArrayList<String> partidas;

    public Usuario(String usuario, String Contraseña, String nombres,  int puntos) {
        this.usuario = usuario;
        this.Contraseña = Contraseña;
        this.nombres = nombres;
        this.puntos = puntos;
        this.partidas = new ArrayList();
    }

    public String getUsuario() {
        return usuario;

    }

    public ArrayList<String> getListaJuegos() {
        return partidas;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public int getPuntos() {
        return puntos;
    }

    public void setPunto(int _puntos) {
        this.puntos = _puntos;
    }
//_______________________________________________________________________________________________________________________________________    

}
