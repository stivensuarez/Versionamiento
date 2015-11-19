package Formularios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Operaciones {

    File ruta;
    int sw;
    ListaDeFechas auxFech, cabFech;
    ListaDeProductos auxProdu, cabProdu;

    public ListaDeFechas nuevaCita(ListaDeFechas cab, String dia, String mes, String hora, String cedula, JList lista, DefaultListModel m1, String rut) {
        String[] hor;
        auxFech = cab;

        if (cab == null) {
            cab = new ListaDeFechas();
            cab.dia = dia;
            cab.mes = mes;
            hor = hora.split(":");
            cab.hora = hor[0];
            cab.minuto = hor[1];
            cab.cedula = cedula;
            m1.addElement(mes + "     " + dia + "      " + hora);

        } else {
            while (auxFech.liga != null) {
                auxFech = auxFech.liga;
            }
            ListaDeFechas aux = new ListaDeFechas();
            auxFech.liga = aux;
            auxFech = auxFech.liga;
            auxFech.dia = dia;
            auxFech.mes = mes;
            hor = hora.split(":");
            auxFech.hora = hor[0];
            auxFech.minuto = hor[1];
            auxFech.cedula = cedula;
            m1.addElement(mes + "     " + dia + "      " + hora);
        }
        escribirCita(rut, cab);
        return cab;
    }

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
            }
        } catch (IOException e) {
            cab = null;
        }
        return cab;
    }

    public void escribirProducto(String rut, ListaDeProductos cab) {
        auxProdu = cab;
        try {
            ruta = new File(rut);
            FileWriter escritor = new FileWriter(ruta);
            while (auxProdu != null) {
                escritor.write(auxProdu.tipoVenta + "/" + auxProdu.caracte + "/" + auxProdu.nom + "/"
                        + auxProdu.prec + "/" + auxProdu.costo + "/" + auxProdu.unidad + "/" + auxProdu.tiempo + "-");
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
                    auxProdu.tiempo = elementos[6];
                    if (i + 1 != numProd.length) {
                        auxProdu.liga = new ListaDeProductos();
                        auxProdu = auxProdu.liga;
                    }
                }
                lector.close();
                linea.close();
            }
        } catch (IOException e) {
            cab = null;
        }
        return cab;
    }

    public ListaDeProductos nuevoProducto(ListaDeProductos cab, String venta, String caracteristica, String nombre, String precio, String costo, String unidad, String tiempo, String rut) {

        auxProdu = cab;

        if (cab == null) {
            cab = new ListaDeProductos();
            cab.tipoVenta = venta;
            cab.caracte = caracteristica;
            cab.nom = nombre;
            cab.prec = precio;
            cab.costo = costo;
            cab.unidad = unidad;
            cab.tiempo = tiempo;

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
            auxProdu.tiempo = tiempo;
        }
        escribirProducto(rut, cab);
        return cab;
    }

}
