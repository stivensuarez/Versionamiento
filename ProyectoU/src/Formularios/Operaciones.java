package Formularios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * Con la clase operaciones se gestionara la lectura y escritura de todos los
 * datos ingresados por el usuario Esta clase tiene métodos repetidos ya que
 * sirve dependiendo del dato, sea una cita o un producto
 *
 * @author stiven Fecha de creación: 20/11/2015
 * @version 2.0
 */
public class Operaciones {

    File ruta; // Con este objeto se manipulara el archivo donde se almacenara la información
    ListaDeFechas auxFech; // Es el apuntador auxiliar de la lista de fechas 
    ListaDeFechas cabFech; // Es la cabeza de la lista de fechas
    ListaDeProductos auxProdu;  // Es el apuntador auxiliar de la lista de productos
    ListaDeProductos cabProdu; // Es la cabeza de la lista de productos 
    ListaDeProcedimientos auxProce;  // Es el apuntador auxiliar de la lista de procedimientos 
    ListaDeProcedimientos cabProce; // Es la cabeza de la lista de procedimientos 

    /**
     * Con este método agregamos una nueva cita a la lista y a la lista grafica
     *
     * @param cab Es necesario para poder recorrer la lista
     * @param dia Dato ingresado por el usuario para ser guardado
     * @param mes Dato ingresado por el usuario para ser guardado
     * @param hora Dato ingresado por el usuario para ser guardado
     * @param min Dato ingresado por el usuario para ser guardado
     * @param cedula Dato ingresado por el usuario para ser guardado
     * @param lista Este elemento es muy importante ya que es la interfaz
     * gráfica donde se ven los datos guardados
     * @param m1 Sirve para facilitar el uso de la listas graficas
     * @param rut Ruta del archivo que se va a gestionar
     * @return Despues de agregar la cita, retorna la lista modificada
     */
    public ListaDeFechas nuevaCita(ListaDeFechas cab, String dia, String mes, String hora, String min, String cedula, JList lista, DefaultListModel m1, String rut) {
        String[] hor;
        auxFech = cab;
        if (cab == null) {
            cab = new ListaDeFechas();
            cab.dia = dia;
            cab.mes = mes;
            cab.hora = hora;
            cab.minuto = min;
            cab.cedula = cedula;
            m1.addElement(dia + "     " + mes + "     " + hora + "        " + min);

        } else {
            while (auxFech.liga != null) {
                auxFech = auxFech.liga;
            }
            ListaDeFechas aux = new ListaDeFechas();
            auxFech.liga = aux;
            auxFech = auxFech.liga;
            auxFech.dia = dia;
            auxFech.mes = mes;
            auxFech.hora = hora;
            auxFech.minuto = min;
            auxFech.cedula = cedula;
            m1.addElement(dia + "      " + mes + "      " + hora + "           " + min);
        }
        escribirCita(rut, cab);
        return cab;
    }

    /**
     * Método que escribe los datos de una lista
     *
     * @param rut Ruta del archivo a buscar
     * @param cab Lista con los datos que se guardaran
     */
    public void escribirCita(String rut, ListaDeFechas cab) {
        auxFech = cab;
        try {
            ruta = new File(rut);
            FileWriter escritor = new FileWriter(ruta);
            while (auxFech != null) {
                escritor.write(auxFech.cedula + "/" + auxFech.dia + "/" + auxFech.mes + "/" + auxFech.hora + "/" + auxFech.minuto + "-");
                auxFech = auxFech.liga;
            }
            escritor.close();
        } catch (IOException e) {
            System.out.printf(rut, "No se encontro");
        }
    }

    /**
     * Método que sirve para la lectura de datos en un archivo este crea una
     * lista dependiendo del numero de datos que encuentre
     *
     * @param rut Ruta del archivo a buscar
     * @param cab Lista que se creara
     * @return retorna cab con todos los datos del archivo en este caso citas
     */
    public ListaDeFechas leerCita(String rut, ListaDeFechas cab) {
        auxFech = new ListaDeFechas();
        cab = auxFech;
        int i;
        String[] numcitas, elementos;
        try {
            ruta = new File(rut);
            FileReader lector = new FileReader(ruta);
            BufferedReader linea = new BufferedReader(lector);
            String le = linea.readLine();
            System.out.print(le);
            if (le != null) {
                numcitas = le.split("-");
                for (i = 0; i < numcitas.length; i++) {
                    elementos = numcitas[i].split("/");
                    auxFech.cedula = elementos[0];
                    auxFech.dia = elementos[1];
                    auxFech.mes = elementos[2];
                    auxFech.hora = elementos[3];
                    auxFech.minuto = elementos[4];
                    if (i + 1 != numcitas.length) {
                        auxFech.liga = new ListaDeFechas();
                        auxFech = auxFech.liga;
                    }
                }
                lector.close();
                linea.close();
            } else {
                cab = null;

            }
        } catch (IOException e) {
            cab = null;
        }
        return cab;
    }
    //operaciones para productos 

    public void escribirProducto(String rut, ListaDeProductos cab) {
        auxProdu = cab;
        try {
            ruta = new File(rut);
            FileWriter escritor = new FileWriter(ruta);
            while (auxProdu != null) {
                escritor.write(auxProdu.tipoVenta + "/" + auxProdu.caracte + "/" + auxProdu.nom + "/"
                        + auxProdu.prec + "/" + auxProdu.costo + "/" + auxProdu.unidad + "-");
                auxProdu = auxProdu.liga;
            }
            escritor.close();
        } catch (IOException e) {
            System.out.printf(rut, "No se encontro");
        }
    }

    public ListaDeProductos leerProducto(String rut, ListaDeProductos cab) {
        auxProdu = new ListaDeProductos();
        cab = auxProdu;
        int i;
        String[] numProd, elementos;
        try {
            ruta = new File(rut);
            FileReader lector = new FileReader(ruta);
            BufferedReader linea = new BufferedReader(lector);
            String le = linea.readLine();
            System.out.print(le);
            if (le != null) {
                numProd = le.split("-");
                for (i = 0; i < numProd.length; i++) {
                    elementos = numProd[i].split("/");
                    auxProdu.tipoVenta = elementos[0];
                    auxProdu.caracte = elementos[1];
                    auxProdu.nom = elementos[2];
                    auxProdu.prec = elementos[3];
                    auxProdu.costo = elementos[4];
                    auxProdu.unidad = elementos[5];
                    if (i + 1 != numProd.length) {
                        auxProdu.liga = new ListaDeProductos();
                        auxProdu = auxProdu.liga;
                    }
                }
                lector.close();
                linea.close();
            } else {
                cab = null;
            }
        } catch (IOException e) {
            cab = null;
        }
        return cab;
    }

    public ListaDeProductos nuevoProducto(ListaDeProductos cab, String venta, String caracteristica, String nombre, String precio, String costo, String unidad, String rut) {

        auxProdu = cab;

        if (cab == null) {
            cab = new ListaDeProductos();
            cab.tipoVenta = venta;
            cab.caracte = caracteristica;
            cab.nom = nombre;
            cab.prec = precio;
            cab.costo = costo;
            cab.unidad = unidad;

        } else {
            while (auxProdu.liga != null) {
                auxProdu = auxProdu.liga;
            }
            ListaDeProductos aux = new ListaDeProductos();
            auxProdu.liga = aux;
            auxProdu = auxProdu.liga;
            auxProdu.tipoVenta = venta;
            auxProdu.caracte = caracteristica;
            auxProdu.nom = nombre;
            auxProdu.prec = precio;
            auxProdu.costo = costo;
            auxProdu.unidad = unidad;
        }
        escribirProducto(rut, cab);
        return cab;
    }
    // Operaciones para procedimientos 

    public void escribirProcedimiento(String rut, ListaDeProcedimientos cab) {
        auxProce = cab;
        try {
            ruta = new File(rut);
            FileWriter escritor = new FileWriter(ruta);
            while (auxProce != null) {
                escritor.write(auxProce.tipoVenta + "/" + auxProce.caracte + "/" + auxProce.nom + "/"
                        + auxProce.prec + "/" + auxProce.hora + "/" + auxProce.min + "-");
                auxProce = auxProce.liga;
            }
            escritor.close();
        } catch (IOException e) {
            System.out.printf(rut, "No se encontro");
        }
    }

    public ListaDeProcedimientos leerProcedimiento(String rut, ListaDeProcedimientos cab) {
        auxProce = new ListaDeProcedimientos();
        cab = auxProce;
        int i;
        String[] numProce, elementos;
        try {
            ruta = new File(rut);
            FileReader lector = new FileReader(ruta);
            BufferedReader linea = new BufferedReader(lector);
            String le = linea.readLine();
            System.out.print(le);
            if (le != null) {
                numProce = le.split("-");
                for (i = 0; i < numProce.length; i++) {
                    elementos = numProce[i].split("/");
                    auxProce.tipoVenta = elementos[0];
                    auxProce.caracte = elementos[1];
                    auxProce.nom = elementos[2];
                    auxProce.prec = elementos[3];
                    auxProce.hora = elementos[4];
                    auxProce.min = elementos[5];
                    if (i + 1 != numProce.length) {
                        auxProce.liga = new ListaDeProcedimientos();
                        auxProce = auxProce.liga;
                    }
                }
                lector.close();
                linea.close();
            } else {
                cab = null;
            }
        } catch (IOException e) {
            cab = null;
        }
        return cab;
    }

    public ListaDeProcedimientos nuevoProcedimiento(ListaDeProcedimientos cab, String venta, String caracteristica, String nombre, String precio, String hora, String minutos, String rut) {

        auxProce = cab;

        if (cab == null) {
            cab = new ListaDeProcedimientos();
            cab.tipoVenta = venta;
            cab.caracte = caracteristica;
            cab.nom = nombre;
            cab.prec = precio;
            cab.hora = hora;
            cab.min = minutos;

        } else {
            while (auxProce.liga != null) {
                auxProce = auxProce.liga;
            }
            ListaDeProcedimientos aux = new ListaDeProcedimientos();
            auxProce.liga = aux;
            auxProce = auxProce.liga;
            auxProce.tipoVenta = venta;
            auxProce.caracte = caracteristica;
            auxProce.nom = nombre;
            auxProce.prec = precio;
            auxProce.hora = hora;
            auxProce.min = minutos;
        }
        escribirProcedimiento(rut, cab);
        return cab;
    }
    
    public DefaultListModel llenarListaCitas(DefaultListModel m1, String rut) {
        auxFech = new ListaDeFechas();
        int i;
        String[] numcitas, elementos;
        try {
            ruta = new File(rut);
            FileReader lector = new FileReader(ruta);
            BufferedReader linea = new BufferedReader(lector);
            String le = linea.readLine();
            System.out.print(le);
            if (le != null) {
                numcitas = le.split("-");
                for (i = 0; i < numcitas.length; i++) {
                    elementos = numcitas[i].split("/");
                    auxFech.cedula = elementos[0];
                    auxFech.dia = elementos[1];
                    auxFech.mes = elementos[2];
                    auxFech.hora = elementos[3];
                    auxFech.minuto = elementos[4];
                    m1.addElement(auxFech.cedula + " " + auxFech.dia + " " + auxFech.mes + " " + auxFech.dia + " " + auxFech.hora + " " + auxFech.minuto);
                    if (i + 1 != numcitas.length) {
                        auxFech = auxFech.liga = new ListaDeFechas();
                    }
                }
                lector.close();
                linea.close();
             
            } else {
                return null;
            }
        } catch (IOException e) {

        }
        return m1;
    }
    public DefaultListModel llenarListaProductos(DefaultListModel m1, String rut) {
        auxProdu = new ListaDeProductos();
        double a,b;
        int i;
        String[] numPro, elementos;
        try {
            ruta = new File(rut);
            FileReader lector = new FileReader(ruta);
            BufferedReader linea = new BufferedReader(lector);
            String le = linea.readLine();
            System.out.print(le);
            if (le != null) {
                numPro = le.split("-");
                for (i = 0; i < numPro.length; i++) {
                    elementos = numPro[i].split("/");
                    auxProdu.tipoVenta = elementos[0];
                    auxProdu.caracte = elementos[1];
                    auxProdu.nom = elementos[2];
                    auxProdu.prec = elementos[3];
                    auxProdu.costo = elementos[4];
                    auxProdu.unidad = elementos[5];
                    
                    m1.addElement(auxProdu.nom + " " + auxProdu.tipoVenta + " " + auxProdu.caracte + " " + auxProdu.costo + " " +
                            auxProdu.prec + " " + auxProdu.unidad+ " " + " Ganancia: " + (a = Double.parseDouble(auxProdu.prec) -( b = Double.parseDouble(auxProdu.costo))));
                    if (i + 1 != numPro.length) {
                        auxProdu = auxProdu.liga = new ListaDeProductos();
                    }
                }
                lector.close();
                linea.close();
             
            } else {
                return null;
            }
        } catch (IOException e) {

        }
        return m1;
    }
    public DefaultListModel llenarListaProcedimientos(DefaultListModel m1, String rut) {
        auxProce = new ListaDeProcedimientos();
        double a,b;
        int i;
        String[] numProce, elementos;
        try {
            ruta = new File(rut);
            FileReader lector = new FileReader(ruta);
            BufferedReader linea = new BufferedReader(lector);
            String le = linea.readLine();
            System.out.print(le);
            if (le != null) {
                numProce = le.split("-");
                for (i = 0; i < numProce.length; i++) {
                    elementos = numProce[i].split("/");
                    auxProce.tipoVenta = elementos[0];
                    auxProce.caracte = elementos[1];
                    auxProce.nom = elementos[2];
                    auxProce.prec = elementos[3];
                    auxProce.hora = elementos[4];
                    auxProce.min = elementos[5];
                    
                    m1.addElement(auxProce.nom + " " + auxProce.tipoVenta + " " + auxProce.caracte + " " + auxProce.hora + " " +
                            auxProce.min + " " +auxProce.prec );
                    if (i + 1 != numProce.length) {
                        auxProce = auxProce.liga = new ListaDeProcedimientos();
                    }
                }
                lector.close();
                linea.close();
             
            } else {
                return null;
            }
        } catch (IOException e) {

        }
        return m1;
    }

}
