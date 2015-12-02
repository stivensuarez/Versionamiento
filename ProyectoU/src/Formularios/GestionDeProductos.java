package Formularios;

import java.awt.Color;

/**
 * Clase que representa los productos que van a ser gestionados
 *
 * @author stiven Fecha de creación : 25/11/2015
 * @version 1.0
 */
public class GestionDeProductos extends javax.swing.JFrame {
    ListaDeProcedimientos listaProce;
    ListaDeProductos listaPro;// Lista de productos agregados  
    Operaciones operaciones;
    String cVent; // Tipo de venta que el usuario ingresa o ingresó
    String cCarac; // Característica de la venta 
    String cNombre; // Nombre del producto o procedimiento 
    String cPrec; // Precio del servicio 
    String cCosto; // Costo del servicio 
    String cUnidad; // Número de unidades 
    String cHora; // horas del procedimiento 
     String cMin; // minutos  del procedimiento 
    int sw; // Sirve para idénticar si es un producto o un procedimiento 

    public GestionDeProductos() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        sw = 0;
        operaciones = new Operaciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        unidades = new javax.swing.JTextField();
        venta = new javax.swing.JComboBox();
        caracteristica = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        costo = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        hora = new javax.swing.JComboBox<>();
        mins = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de productos");

        jLabel1.setText("Elemento:");

        jLabel2.setText("Característica:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Precio:");

        jLabel5.setText("Unidades:");

        nombre.setColumns(8);
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        unidades.setColumns(8);

        venta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---------", "Producto", "Procedimiento", " " }));
        venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaActionPerformed(evt);
            }
        });

        jLabel6.setText("Costo:");

        costo.setColumns(8);
        costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoActionPerformed(evt);
            }
        });

        precio.setColumns(8);
        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/left_blue-32.png"))); // NOI18N
        jButton4.setText("Atrás");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/solicitar.png"))); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Duración:");

        jLabel8.setText("Hora");

        jLabel9.setText("minutos");

        hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        mins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel9))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(venta, 0, 102, Short.MAX_VALUE)
                                .addComponent(unidades)
                                .addComponent(costo)
                                .addComponent(caracteristica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombre)
                                .addComponent(precio))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(caracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed

    }//GEN-LAST:event_nombreActionPerformed

    private void costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoActionPerformed
        //
    }//GEN-LAST:event_costoActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed

    }//GEN-LAST:event_precioActionPerformed
    /**
     * Boton aceptar que lleva toda la incormacion a los archivos
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (sw == 1) {
            listaPro = operaciones.leerProducto("C:\\Users\\stiven\\Documents\\productos.txt", listaPro);
            cVent = venta.getSelectedItem().toString();
            cCarac = caracteristica.getSelectedItem().toString();
            cNombre = nombre.getText();
            cPrec = precio.getText();
            cCosto = costo.getText();
            cUnidad = unidades.getText();
            listaPro = operaciones.nuevoProducto(listaPro, cVent, cCarac, cNombre, cPrec, cCosto, cUnidad, "C:\\Users\\stiven\\Documents\\productos.txt");
        } else {
            if (sw == 0) {
                listaProce = operaciones.leerProcedimiento("C:\\Users\\stiven\\Documents\\proce.txt", listaProce);
                cVent = venta.getSelectedItem().toString();
                cCarac = caracteristica.getSelectedItem().toString();
                cNombre = nombre.getText();
                cPrec = precio.getText();
                cHora = hora.getSelectedItem().toString();
                cMin = mins.getSelectedItem().toString();
                listaProce = operaciones.nuevoProcedimiento(listaProce, cVent, cCarac, cNombre, cPrec, cHora, cMin, "C:\\Users\\stiven\\Documents\\proce.txt");

            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        Menu Menu5 = new Menu();
        Menu5.setVisible(true);
        Menu5.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed
    /**
     * En este evento se organizan los datos que elija el usuario, sea un
     * producto o un procedimiento
     *
     * @param evt
     */

    private void ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaActionPerformed
        String respuesta;
        respuesta = venta.getSelectedItem().toString();
        if (respuesta.equalsIgnoreCase("procedimiento")) {
            unidades.setVisible(false);
            jLabel5.setVisible(false);
            jLabel7.setVisible(true);
            hora.setVisible(true);
            mins.setVisible(true);
            jLabel9.setVisible(true);
            jLabel8.setVisible(true);

            caracteristica.removeAllItems();
            caracteristica.addItem("Rayitos");
            caracteristica.addItem("Corte");
            caracteristica.addItem("Manicure");
            caracteristica.addItem("Pedicure");
            sw = 0;

        } else if (respuesta.equalsIgnoreCase("producto")) {
            unidades.setVisible(true);
            jLabel5.setVisible(true);
            jLabel7.setVisible(false);
            hora.setVisible(false);
            mins.setVisible(false);
            jLabel9.setVisible(false);
            jLabel8.setVisible(false);
            caracteristica.removeAllItems();
            caracteristica.addItem("Belleza");
            caracteristica.addItem("Bisuteria");
            caracteristica.addItem("Marroquineria");
            sw = 1;

        }

    }//GEN-LAST:event_ventaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDeProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox caracteristica;
    private javax.swing.JTextField costo;
    private javax.swing.JComboBox<String> hora;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> mins;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField unidades;
    private javax.swing.JComboBox venta;
    // End of variables declaration//GEN-END:variables
}
