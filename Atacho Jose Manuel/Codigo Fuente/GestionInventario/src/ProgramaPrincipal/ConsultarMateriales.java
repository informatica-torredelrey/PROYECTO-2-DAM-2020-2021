/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaPrincipal;

import Recursos.Conexion;
import Recursos.Utilidades;
import Recursos.Material;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import static java.awt.Dialog.ModalityType.APPLICATION_MODAL;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author admin
 */
public class ConsultarMateriales extends javax.swing.JDialog {

    private List<Material> materiales = new ArrayList<>();
    private List<MaterialesInforme> materialesInforme = new ArrayList<>();
    /**
     * Creates new form ConsultarMateriales
     */
    public ConsultarMateriales() {
        initComponents();
        this.setModalityType(APPLICATION_MODAL);
        rellenarTabla(null,null);
        cmbMulti.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        lblListado = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jrbNombre = new javax.swing.JRadioButton();
        jrbTipo = new javax.swing.JRadioButton();
        jrbMarca = new javax.swing.JRadioButton();
        jrbLocalizacion = new javax.swing.JRadioButton();
        jrbProveedor = new javax.swing.JRadioButton();
        jrbDisponible = new javax.swing.JRadioButton();
        btnbuscar = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        cmbMulti = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Materiales");
        setIconImage(Utilidades.ponerIcono());
        setResizable(false);

        lblListado.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblListado.setText("Hacer un listado PDF");
        lblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblListadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblListadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblListadoMouseExited(evt);
            }
        });

        lblBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscar.setText("Buscar:");

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Marca", "Stock", "Precio Unitario", "Localización", "Proveedor", "Disponible"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTabla);
        if (tblTabla.getColumnModel().getColumnCount() > 0) {
            tblTabla.getColumnModel().getColumn(0).setResizable(false);
            tblTabla.getColumnModel().getColumn(1).setResizable(false);
            tblTabla.getColumnModel().getColumn(2).setResizable(false);
            tblTabla.getColumnModel().getColumn(3).setResizable(false);
            tblTabla.getColumnModel().getColumn(4).setResizable(false);
            tblTabla.getColumnModel().getColumn(5).setResizable(false);
            tblTabla.getColumnModel().getColumn(6).setResizable(false);
            tblTabla.getColumnModel().getColumn(7).setResizable(false);
        }

        btnGrupo.add(jrbNombre);
        jrbNombre.setSelected(true);
        jrbNombre.setText("Nombre");
        jrbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNombreActionPerformed(evt);
            }
        });

        btnGrupo.add(jrbTipo);
        jrbTipo.setText("Tipo");
        jrbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTipoActionPerformed(evt);
            }
        });

        btnGrupo.add(jrbMarca);
        jrbMarca.setText("Marca");
        jrbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMarcaActionPerformed(evt);
            }
        });

        btnGrupo.add(jrbLocalizacion);
        jrbLocalizacion.setText("Localizacion");
        jrbLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbLocalizacionActionPerformed(evt);
            }
        });

        btnGrupo.add(jrbProveedor);
        jrbProveedor.setText("Proveedor");
        jrbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbProveedorActionPerformed(evt);
            }
        });

        btnGrupo.add(jrbDisponible);
        jrbDisponible.setText("Disponible");
        jrbDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDisponibleActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInfo.setText("Pantalla de busqueda de materiales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblListado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jrbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jrbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jrbDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblBuscar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblInfo)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblInfo)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(cmbMulti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNombre)
                    .addComponent(jrbTipo)
                    .addComponent(jrbMarca)
                    .addComponent(jrbLocalizacion)
                    .addComponent(jrbProveedor)
                    .addComponent(jrbDisponible))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblListado)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        //Relleno la tabla con los datos buscados
        if(txtBuscar.isEnabled()){
            if(!(txtBuscar.getText().equals(""))){
                rellenarTabla(txtBuscar.getText(),recogeRadio());
            }else{
                JOptionPane.showMessageDialog(null,"Introduzca algun item a buscar","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            if(recogeRadio().equals("Tipo") || recogeRadio().equals("Proveedor")){
                rellenarTabla(cmbMulti.getSelectedItem().toString().substring(0, cmbMulti.getSelectedItem().toString().indexOf("#")),recogeRadio());
            }else{
                rellenarTabla(cmbMulti.getSelectedItem().toString(), recogeRadio());
            }
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jrbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNombreActionPerformed
        habilitaTexto();
    }//GEN-LAST:event_jrbNombreActionPerformed

    private void jrbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMarcaActionPerformed
        habilitaTexto();
    }//GEN-LAST:event_jrbMarcaActionPerformed

    private void jrbLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbLocalizacionActionPerformed
        habilitaCombo("localizacion");
    }//GEN-LAST:event_jrbLocalizacionActionPerformed

    private void jrbDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDisponibleActionPerformed
        habilitaCombo("disponible");
    }//GEN-LAST:event_jrbDisponibleActionPerformed

    private void jrbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTipoActionPerformed
        habilitaCombo("tipo_material");
    }//GEN-LAST:event_jrbTipoActionPerformed

    private void jrbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbProveedorActionPerformed
        habilitaCombo("proveedor");
    }//GEN-LAST:event_jrbProveedorActionPerformed

    private void lblListadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListadoMouseEntered
        //Cuando paso por encima, cambio el color a azul, cambio el icono del cursos, para que sea como un enlace
        lblListado.setForeground(Color.BLUE);
        lblListado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblListadoMouseEntered

    private void lblListadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListadoMouseExited
        //Cuando salgo, cambio el color al que tiene por defecto
        lblListado.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblListadoMouseExited

    private void lblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListadoMouseClicked
        //Al hacer click, genera un pdf con los datos de la tabla filtrado
        materialesInforme.clear();
        
        if(!materiales.isEmpty()){
            try {
                InputStream archivojasper = getClass().getResourceAsStream("/Recursos/InformeInventarioV2.jasper");
                
                for (Material material : materiales) {
                    materialesInforme.add(new MaterialesInforme(
                            primLetraMayus(material.getNombre()),
                            primLetraMayus(material.getTipo().substring(material.getTipo().indexOf("#")+2)),
                            primLetraMayus(material.getMarca()),
                            String.valueOf(material.getStock()),
                            material.getLocalizacion(),
                            primLetraMayus(material.getProveedor().substring(material.getProveedor().indexOf("#")+2)),
                            (material.isDisponible()?"Si":"No"),
                            String.valueOf(material.getPrecio())));
                }                
                JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(materialesInforme);
                JasperPrint print = JasperFillManager.fillReport(archivojasper, null, datasource);
                JasperExportManager.exportReportToPdfFile(print, "Informe de materiales.pdf");
                File path = new File ("Informe de materiales.pdf");
                Desktop.getDesktop().open(path);
                
            } catch (JRException ex) {
                Logger.getLogger(ConsultarMateriales.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConsultarMateriales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"La tabla no tiene información para pasar a un pdf","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_lblListadoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarMateriales().setVisible(true);
            }
        });
    }

    //Relleno la tabla de materiales, este metodo tambien lo utiliza el boton de actualizar tabla
    private void rellenarTabla(String buscar , String campo) {
        DefaultTableModel tableModel = (DefaultTableModel) tblTabla.getModel();
        tableModel.getDataVector().removeAllElements();
        materiales.clear();
        if(buscar == null || campo == null){
            materiales = Conexion.recogeMateriales();
        }else{
            materiales = Conexion.recogeMateriales(buscar,campo);
        }
        for (int x = 0; x< materiales.size();x++){
            //String nombre = materiales.get(x).getNombre();
            String nombre = materiales.get(x).getNombre();
            String tipo = materiales.get(x).getTipo().substring(materiales.get(x).getTipo().indexOf("#")+2);
            String marca = materiales.get(x).getMarca();
            String stock = String.valueOf(materiales.get(x).getStock());
            String precio = String.valueOf(materiales.get(x).getPrecio())+" €";
            String localizacion = materiales.get(x).getLocalizacion();
            String proveedor = materiales.get(x).getProveedor().substring(materiales.get(x).getProveedor().indexOf("#")+2);
            String disponible = (materiales.get(x).isDisponible()?"Si":"No");
            
            Object[] data = {nombre,tipo,marca,stock,precio,localizacion,proveedor,disponible};
            
            tableModel.addRow(data);

        }
        if(materiales.isEmpty()){
            JOptionPane.showMessageDialog(null,"No se ha encontrado datos","Informacion",JOptionPane.INFORMATION_MESSAGE);
            tableModel.getDataVector().removeAllElements();
        }
    }
    
    //Recoje el valor del boton
    private String recogeRadio(){
        String valor = null;
        for (Enumeration<AbstractButton> botones = btnGrupo.getElements(); botones.hasMoreElements();) {
            AbstractButton boton = botones.nextElement();
            if (boton.isSelected()) {
                    valor = boton.getText();
            }
        }
        return valor;
    }
    
    //Habiilito el texto de busqueda
    private void habilitaTexto() {
        txtBuscar.setText("");
        txtBuscar.setEnabled(true);
        cmbMulti.setEnabled(false);
    }
    
    //Habilito y relleno el combo
    private void habilitaCombo(String columna) {
        txtBuscar.setText("");
        txtBuscar.setEnabled(false);
        cmbMulti.setEnabled(true);
        
        cmbMulti.removeAllItems();
        if(!(columna.equals("disponible"))){
            String[] datos = Conexion.getDatos(columna);
            for (String dato : datos){
                cmbMulti.addItem(dato);
            }
        }else{
            cmbMulti.addItem("si");
            cmbMulti.addItem("no");
        }


    }
    
    //Primera letra mayuscula
    private String primLetraMayus(String letra){
        return letra.substring(0,1).toUpperCase()+letra.substring(1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> cmbMulti;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbDisponible;
    private javax.swing.JRadioButton jrbLocalizacion;
    private javax.swing.JRadioButton jrbMarca;
    private javax.swing.JRadioButton jrbNombre;
    private javax.swing.JRadioButton jrbProveedor;
    private javax.swing.JRadioButton jrbTipo;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblListado;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    
    //Clase que sirve para formatear al formato que jasperreport quiere
    public class MaterialesInforme{
        private String nombre,tipo,marca,stock,localizacion,proveedor,disponible,precio;

        public MaterialesInforme(String nombre, String tipo, String marca, String stock, String localizacion, String proveedor, String disponible, String precio) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.marca = marca;
            this.stock = stock;
            this.localizacion = localizacion;
            this.proveedor = proveedor;
            this.disponible = disponible;
            this.precio = precio;
        }

        public MaterialesInforme() {
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getLocalizacion() {
            return localizacion;
        }

        public void setLocalizacion(String localizacion) {
            this.localizacion = localizacion;
        }

        public String getProveedor() {
            return proveedor;
        }

        public void setProveedor(String proveedor) {
            this.proveedor = proveedor;
        }

        public String getDisponible() {
            return disponible;
        }

        public void setDisponible(String disponible) {
            this.disponible = disponible;
        }

        public String getPrecio() {
            return precio;
        }

        public void setPrecio(String precio) {
            this.precio = precio;
        }
        
    }
}