
package principal;

public class Datos {
    public boolean validarUsuario(String usuario, String contraseña)
    {
        if(usuario.equals("usuario") && contraseña.equals("usuarioa"))
        {
            return true;      
        }
        else
        {
            return false;
        }
    }
}
