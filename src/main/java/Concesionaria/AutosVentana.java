package Concesionaria;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AutosVentana extends javax.swing.JInternalFrame {

    // Atributo para manejar si hay una ventana abierta de este tipo
    public static boolean abierta = false;

    // Modelo de datos para lista de autos
    DefaultListModel modeloAutos = new DefaultListModel();

    public AutosVentana() {

        // Llama al constructor de la superclase y establece las caracteristicas de ventana
        super("Administracion de Autos",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        // Establece en true el atributo abierto representando que hay una ventana de este tipo abierta
        abierta = true;

        // Invoca al metodo initComponents()
        initComponents();

        // Carga las marcas
        cargarMarcas();

        // Carga los modelos
        cargarModelos();

        // Carga los colores
        cargarColores();

        // Relaciona el modelo de autos con la lista de autos
        listAutos.setModel(modeloAutos);

        // Carga la lista con autos
        llenarListaDeAutos();

    }

    private void cargarMarcas() {

        //  Obtiene la ubicacion del archivo marcas.txt
        String ubicacion = "src/main/resources/marcas.txt";

        try {
            // Obtiene las marcas como un vector
            ArrayList marcas = LectorDeArchivos.obtenerContenidoDeArchivoComoVector(ubicacion);
            Iterator itMarcas = marcas.iterator();

            // Agrega la opcion "Seleccione..."
            cmbMarca.addItem("Seleccione...");

            // Carga las marcas
            while (itMarcas.hasNext()) {

                // Obtiene la marca
                String m = (String) itMarcas.next();

                // Agrega la marca al combo
                cmbMarca.addItem(m);
            }
        } catch (Exception e) {

            // Muestra el mensaje de error
            JOptionPane.showMessageDialog(this, "Error al cargar las marcas!\n" + "ERROR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarColores() {

        //  Obtiene la ubicacion del archivo colores.txt
        String ubicacion = "src/main/resources/colores.txt";

        try {
            // Obtiene los colores como un vector
            ArrayList colores = LectorDeArchivos.obtenerContenidoDeArchivoComoVector(ubicacion);
            Iterator itColores = colores.iterator();

            // Agrega la opcion "Seleccione..."
            cmbColor.addItem("Seleccione...");

            // Carga los colores
            while (itColores.hasNext()) {

                // Obtiene el color
                String c = (String) itColores.next();

                // Agrega el color al combo
                cmbColor.addItem(c);
            }
        } catch (Exception e) {

            // Muestra el mensaje de error
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los colores!\n" + "ERROR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarModelos() {

        // Agrega la opcion "Seleccione..."
        cmbModelo.addItem("Seleccione...");

        // Carga el combo con los modelos
        for (int i = 1995; i <= 2018; i++) {
            cmbModelo.addItem(String.valueOf(i));
        }
    }

    public void limpiarFormulario() {
        txtAltura.setText("");
        txtAncho.setText("");
        txtLargo.setText("");
        txtPrecio.setText("");
        txtEquipamiento.setText("");
        cmbMarca.setSelectedIndex(0);
        cmbModelo.setSelectedIndex(0);
        cmbColor.setSelectedIndex(0);
    }

    public boolean validarFormulario() {

        // Valida que la altura no este vacio
        if (txtAltura.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "La altura no puede estar vacio!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtAltura.requestFocus();
            return false;
        }

        // Valida que la altura sea un numero entero
        try {
            Integer.parseInt(txtAltura.getText());
        } catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(this, "La altura debe ser un numero entero!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtAltura.requestFocus();
            return false;
        }

        // Valida que el ancho no este vacio
        if (txtAncho.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El ancho no puede estar vacio!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtAncho.requestFocus();
            return false;
        }

        // Valida que el ancho sea un numero entero
        try {
            Integer.parseInt(txtAncho.getText());
        } catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(this, "El ancho debe ser un numero entero!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtAncho.requestFocus();
            return false;
        }

        // Valida que el largo no este vacio
        if (txtLargo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El largo no puede estar vacio!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtLargo.requestFocus();
            return false;
        }

        // Valida que el largo sea un numero entero
        try {
            Integer.parseInt(txtLargo.getText());
        } catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(this, "El largo debe ser un numero entero!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtLargo.requestFocus();
            return false;
        }

        // Valida que el precio no este vacio
        if (txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El precio no puede estar vacio!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtPrecio.requestFocus();
            return false;
        }

        // Valida que el precio sea un numero que puede tener decimales
        try {
            Double.parseDouble(txtPrecio.getText());
        } catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un numero!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtPrecio.requestFocus();
            return false;
        }

        // Valida que el equipamiento no este vacio
        if (txtEquipamiento.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El equipamiento no puede estar vacio!", "Guardar", JOptionPane.WARNING_MESSAGE);
            txtEquipamiento.requestFocus();
            return false;
        }

        return true;
    }

    private void llenarListaDeAutos() {

        // Variables
        Connection c = null;

        try {
            // Obtiene la conexion
            c = AdministradorDeConexiones.getConnection();

            // Obtiene todos los autos
            List autos = Auto.obtenerTodos(c);

            // Llena la lista de autos
            listAutos.setListData(new Vector(autos));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Disculpe, no se ha podido obtener los autos", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbModelo = new javax.swing.JComboBox();
        cmbColor = new javax.swing.JComboBox();
        cmbMarca = new javax.swing.JComboBox();
        txtPrecio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtAltura = new javax.swing.JTextField();
        txtAncho = new javax.swing.JTextField();
        txtLargo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAutos = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEquipamiento = new javax.swing.JTextArea();
        btnCerrar = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Precio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 225, -1, -1));

        jLabel3.setText("Color");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 193, -1, -1));

        jLabel2.setText("Modelo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 163, -1, -1));

        jLabel1.setText("Marca");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 133, -1, -1));

        getContentPane().add(cmbModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 160, 181, -1));

        getContentPane().add(cmbColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 190, 181, -1));

        getContentPane().add(cmbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 130, 124, -1));

        txtPrecio.setFont(new java.awt.Font("Ubuntu", 3, 17)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 220, 181, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dimensiones"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 26, 130, -1));
        jPanel1.add(txtAncho, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 56, 130, -1));
        jPanel1.add(txtLargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 86, 130, -1));

        jLabel6.setText("Altura");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 29, -1, -1));

        jLabel7.setText("Ancho");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 59, -1, -1));

        jLabel8.setText("Largo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 89, -1, -1));

        jLabel9.setText("cm");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jLabel10.setText("cm");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jLabel11.setText("cm");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 6, 256, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 501, 508, 10));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 517, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 517, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 517, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Autos"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listAutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listAutos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 26, 201, 223));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Caracteristicas / Equipamiento"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEquipamiento.setColumns(20);
        txtEquipamiento.setRows(5);
        jScrollPane2.setViewportView(txtEquipamiento);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 478, 189));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 508, 220));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 517, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // Si hay un elemento seleccionado, lo elimina
        if (listAutos.getSelectedIndex() != -1) {

            // Consulta si desea eliminar el item
            int rta = JOptionPane.showConfirmDialog(this, "Desea eliminar el auto " + listAutos.getSelectedValue() + " ?", "Eliminar", JOptionPane.YES_NO_OPTION);

            // Si no desea borrarlo, entonces no lo borra
            if (rta == JOptionPane.NO_OPTION) {
                return;
            }

            // Elimina el auto
           
            Auto a = new Auto();
            a.setId(listAutos.getSelectedIndex()+1);
            System.out.println(a.getId());
            // Declara una variable del tipo Connection
            Connection conn = null;
            try {

                // Obtiene la conexion
                conn = AdministradorDeConexiones.getConnection();
            a.eliminar(conn);
            } catch (Exception e) {

                // Informa que la operacion no pudo ser realizada
                JOptionPane.showMessageDialog(this, "La operacion no pudo ser realizada: " + e.getMessage(), "Operacion", JOptionPane.INFORMATION_MESSAGE);
                return;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
            
           // modeloAutos.remove(listAutos.getSelectedIndex());
            // Deshabilita el boton 'eliminar'
            btnEliminar.setEnabled(false);

            // Deshabilita el boton 'guardar'
            btnGuardar.setEnabled(false);

            // Limpia el formulario
            limpiarFormulario();
            
            // No deja ningun item seleccionado en la lista
            listAutos.clearSelection();

            // Informa que el auto ha sido eliminado
            JOptionPane.showMessageDialog(this, "El auto ha sido eliminado!", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
            
            this.llenarListaDeAutos();
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void listAutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAutosMouseClicked

        // Activa el boton 'eliminar'
        btnEliminar.setEnabled(true);

        // Activa el boton 'guardar'
        btnGuardar.setEnabled(true);

        // Obtiene el item seleccionado
        Auto a = (Auto) listAutos.getSelectedValue();

        // Completa las cajas de texto segun el elemento
        txtAltura.setText(String.valueOf(a.getAltura()));
        txtAncho.setText(String.valueOf(a.getAncho()));
        txtLargo.setText(String.valueOf(a.getLargo()));
        txtPrecio.setText(String.valueOf(a.getPrecio()));
        txtEquipamiento.setText(a.getEquipamiento());

        // Completa los combos segun corresponda
        cmbColor.setSelectedItem(a.getColor());
        cmbMarca.setSelectedItem(a.getMarca());
        cmbModelo.setSelectedItem(a.getModelo());

    }//GEN-LAST:event_listAutosMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        // Variables
        boolean esNuevo = true;

        // Valida el formulario
        boolean validacionOk = validarFormulario();

        // Si el formulario es valido, informa
        if (validacionOk) {

            // Instancia un auto
            Auto a = new Auto();

            // Si hay un item seleccionado lo obtiene
            if (listAutos.getSelectedIndex() != -1) {
                a = (Auto) listAutos.getSelectedValue();
                esNuevo = false;
            }

            // Construye el auto
            a.setAltura(Integer.parseInt(txtAltura.getText()));
            a.setAncho(Integer.parseInt(txtAncho.getText()));
            a.setLargo(Integer.parseInt(txtLargo.getText()));
            a.setPrecio(Double.parseDouble(txtPrecio.getText()));
            a.setEquipamiento(txtEquipamiento.getText());
            a.setMarca((String) cmbMarca.getSelectedItem());
            a.setColor((String) cmbColor.getSelectedItem());
            a.setModelo((String) cmbModelo.getSelectedItem());

            // Declara una variable del tipo Connection
            Connection conn = null;

            // Realiza la gestion con la base de datos
            try {

                // Obtiene la conexion
                conn = AdministradorDeConexiones.getConnection();

                // Si es un auto nuevo lo inserta y agrega a la lista
                if (esNuevo) {

                    // Inserta el auto en la tabla
                    a.insertar(conn);

                    // Agrega el elemento a la lista
                    modeloAutos.addElement(a);
                } // Si no es un auto nuevo lo modifica
                else {

                    // Modifica el auto en la tabla
                    a.actualizar(conn);
                }

            } catch (Exception e) {

                // Informa que la operacion no pudo ser realizada
                JOptionPane.showMessageDialog(this, "La operacion no pudo ser realizada: " + e.getMessage(), "Operacion", JOptionPane.INFORMATION_MESSAGE);
                return;
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }

            // Limpia el formulario
            limpiarFormulario();

            //  Desactiva boton 'guardar'
            btnGuardar.setEnabled(false);

            //  Desactiva boton 'eliminar'
            btnEliminar.setEnabled(false);

            // Activa boton 'nuevo'
            btnNuevo.setEnabled(true);

            // Establece el foco en el boton 'nuevo'
            btnNuevo.requestFocus();

            // No deja ningun item seleccionado en la lista
            listAutos.clearSelection();

            // Infoma OK!
            JOptionPane.showMessageDialog(this, "El auto ha sido guardado!", "Guardar", JOptionPane.INFORMATION_MESSAGE);
            
            this.llenarListaDeAutos();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        // Limpia las cajas de texto
        limpiarFormulario();

        // Limpia la seleccion
        listAutos.clearSelection();

        // Deshabilita boton 'nuevo'
        btnNuevo.setEnabled(false);

        // Deshabilita boton 'eliminar'
        btnEliminar.setEnabled(false);

        // Habilita boton 'guardar'
        btnGuardar.setEnabled(true);

        // Ubica el curso en la primer caja de texto
        txtAltura.requestFocus();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        // Cuando cierra la ventana, establece 'abierto' en falso
        abierta = false;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbColor;
    private javax.swing.JComboBox cmbMarca;
    private javax.swing.JComboBox cmbModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listAutos;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextArea txtEquipamiento;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
