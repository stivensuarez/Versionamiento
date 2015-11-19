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
    ListaDeFechas p;

    public ListaDeFechas nuevaCita(ListaDeFechas listacab, String dia, String mes, String hora, String cedula, JList lista, DefaultListModel m1, String rut) {
        String[] hor;
        p = listacab;

        if (listacab == null) {
            listacab = new ListaDeFechas();
            listacab.dia = dia;
            listacab.mes = mes;
            hor = hora.split(":");
            listacab.hora = hor[0];
            listacab.minuto = hor[1];
            listacab.cedula = cedula;
            m1.addElement(mes + "     " + dia + "      " + hora);

        } else {
            while (p.liga != null) {
                p = p.liga;
            }
            ListaDeFechas aux = new ListaDeFechas();
            p.liga = aux;
            p = p.liga;
            p.dia = dia;
            p.mes = mes;
            hor = hora.split(":");
            p.hora = hor[0];
            p.minuto = hor[1];
            p.cedula = cedula;
            m1.addElement(mes + "     " + dia + "      " + hora);
        }
        escribir(rut, listacab);
        return listacab;
    }

    public void escribir(String rut, ListaDeFechas listacab) {
        p = listacab;
        try {
            ruta = new File(rut);
            FileWriter escritor = new FileWriter(ruta);
            while (p != null) {
                escritor.write(p.cedula + "/" + p.dia + "/" + p.mes + "/" + p.hora + "/" + p.minuto + "-");
                p = p.liga;
            }
            escritor.close();
        } catch (IOException e) {
            System.out.printf(rut, "No se encontro");
        }
    }

    public ListaDeFechas leer(String rut, ListaDeFechas cab) {
        p = new ListaDeFechas();
        cab = p;
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
                    p.cedula = elementos[0];
                    p.dia = elementos[1];
                    p.mes = elementos[2];
                    p.hora = elementos[3];
                    p.minuto = elementos[4];
                    if(i + 1 != numcitas.length){
                    p.liga = new ListaDeFechas();
                    p = p.liga;
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
}
