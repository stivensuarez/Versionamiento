package Formularios;

public class UsuariosYcontraseñas {

    private String usu;
    private String cont;
    private String perf;

    String usuT;
     String contT;
     String perfT;

    private String usuA = "stiven";
    private String contA = "suarez";
    private String perfA = "Administrador";

    public UsuariosYcontraseñas(String usu, String cont, String perf) {
        this.usu = usu;
        this.cont = cont;
        this.perf = perf;
        usuT = "anderson";
        contT = "patiño";
        perfT = "Trabajador";
    }

    public boolean Verfificar() {
        if (perf.equals(perfT) && usu.equals(usuT) && cont.equals(contT)) {
            return (true);
        } else if (perf.equals(perfA) && usu.equals(usuA) && cont.equals(contA)) {

            return (true);
        } else {
            return (false);
        }
    }

}
