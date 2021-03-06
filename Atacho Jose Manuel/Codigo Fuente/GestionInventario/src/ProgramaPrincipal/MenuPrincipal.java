/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaPrincipal;

import Recursos.Conexion;
import Recursos.Utilidades;
import Recursos.Material;
import Recursos.Proveedor;
import Recursos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private static Usuario userRegistrado=null;
    private JMenu[] controlAdmin;
    private List<Material> materiales = new ArrayList<>();
    private HelpSet hs;
    private  HelpBroker hb;
    
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    public MenuPrincipal(Usuario user) {
        initComponents();
        try {
            this.setIconImage(ImageIO.read(getClass().getResourceAsStream("/Recursos/icon.png")));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        controlAdmin = new JMenu[]{mnuUsuario,mnuOtros};
        userRegistrado = user;
        lblNombreUser.setText(user.getNombre()+" "+user.getApellido());
        
        //Si el user es admin, entonces muestro el apartado de administrador
        if(user.getTipo().equals("admin")){
            for (JMenu control : controlAdmin) {
                control.setVisible(true);
            }
        }else{
            for (JMenu control : controlAdmin) {
                control.setVisible(false);
            }
        }
        
        rellenarTabla();

        //Codigo para javahelp
        try {
            // localiza el fichero helpset
            URL hsURL = HelpSet.findHelpSet(null, "help/helpset.hs"); 
            // crea un objeto Helpset
            hs = new HelpSet (null, hsURL);  
            hb = hs.createHelpBroker();
            // Ayuda al hacer click en el JMenuItem itemAyuda.
            hb.enableHelpOnButton(mniAcercaDe, "aplicacion", hs);
            // Ayuda al pulsar F1 sobre la ventana principal
            hb.enableHelpKey(mniAcercaDe, "aplicacion", hs);
        } catch (HelpSetException ex) {
            JOptionPane.showMessageDialog(null,"No se ha podido cargar el fichero de ayuda","Error",JOptionPane.ERROR_MESSAGE);
        }

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        lblInfoTabla = new javax.swing.JLabel();
        lblNombreUser = new javax.swing.JLabel();
        mnbMenu = new javax.swing.JMenuBar();
        mnuGestion = new javax.swing.JMenu();
        mnuCredenciales = new javax.swing.JMenu();
        mniInfo = new javax.swing.JMenuItem();
        mniCambioPass = new javax.swing.JMenuItem();
        mniIdentificarse = new javax.swing.JMenuItem();
        mnuMateriales = new javax.swing.JMenu();
        mnuGestionMateriales = new javax.swing.JMenu();
        mniAltaMaterial = new javax.swing.JMenuItem();
        mniModifMaterial = new javax.swing.JMenuItem();
        mniBajaMaterial = new javax.swing.JMenuItem();
        mniConsultarMaterial = new javax.swing.JMenuItem();
        mniAsignarLocalizacion = new javax.swing.JMenuItem();
        mniHistorial = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        mniNuevoUsuario = new javax.swing.JMenuItem();
        mniModificarUsuario = new javax.swing.JMenuItem();
        mniBajaUsuario = new javax.swing.JMenuItem();
        mnuOtros = new javax.swing.JMenu();
        mnuGestionLocalizacion = new javax.swing.JMenu();
        mniAltaLocalizacion = new javax.swing.JMenuItem();
        mniBajaLocalizacion = new javax.swing.JMenuItem();
        mnuGestionProveedor = new javax.swing.JMenu();
        mniAltaProveedor = new javax.swing.JMenuItem();
        mniEditarProveedor = new javax.swing.JMenuItem();
        mniEliminarProveedor = new javax.swing.JMenuItem();
        mnuGestionTipos = new javax.swing.JMenu();
        mniAltaTipo = new javax.swing.JMenuItem();
        mniBajaTipo = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mniAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setIconImage(Utilidades.ponerIcono());
        setResizable(false);

        lblBienvenida.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblBienvenida.setText("Usted esta registrado como: ");

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Marca", "Stock", "Localizaci??n", "Proveedor", "Disponible"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        btnActualizar.setText("Actualizar Tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblInfoTabla.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInfoTabla.setText("Materiales registrados en el sistema");

        lblNombreUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        mnuGestion.setText("Gestionar");

        mnuCredenciales.setText("Credenciales");

        mniInfo.setText("Consultar su id");
        mniInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniInfoActionPerformed(evt);
            }
        });
        mnuCredenciales.add(mniInfo);

        mniCambioPass.setText("Cambiar Contrase??a");
        mniCambioPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCambioPassActionPerformed(evt);
            }
        });
        mnuCredenciales.add(mniCambioPass);

        mniIdentificarse.setText("Identificarse");
        mniIdentificarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniIdentificarseActionPerformed(evt);
            }
        });
        mnuCredenciales.add(mniIdentificarse);

        mnuGestion.add(mnuCredenciales);

        mnuMateriales.setText("Materiales");

        mnuGestionMateriales.setText("Gestion de materiales");

        mniAltaMaterial.setText("Agregar un material");
        mniAltaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAltaMaterialActionPerformed(evt);
            }
        });
        mnuGestionMateriales.add(mniAltaMaterial);

        mniModifMaterial.setText("Modificar Material");
        mniModifMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniModifMaterialActionPerformed(evt);
            }
        });
        mnuGestionMateriales.add(mniModifMaterial);

        mniBajaMaterial.setText("Dar de baja un material");
        mniBajaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBajaMaterialActionPerformed(evt);
            }
        });
        mnuGestionMateriales.add(mniBajaMaterial);

        mnuMateriales.add(mnuGestionMateriales);

        mniConsultarMaterial.setText("Consultar");
        mniConsultarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniConsultarMaterialActionPerformed(evt);
            }
        });
        mnuMateriales.add(mniConsultarMaterial);

        mniAsignarLocalizacion.setText("Asignar Localizaci??n");
        mniAsignarLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAsignarLocalizacionActionPerformed(evt);
            }
        });
        mnuMateriales.add(mniAsignarLocalizacion);

        mniHistorial.setText("Historial de material");
        mniHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHistorialActionPerformed(evt);
            }
        });
        mnuMateriales.add(mniHistorial);

        mnuGestion.add(mnuMateriales);

        mnuUsuario.setText("Usuarios");

        mniNuevoUsuario.setText("Nuevo");
        mniNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNuevoUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(mniNuevoUsuario);

        mniModificarUsuario.setText("Modificar");
        mniModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniModificarUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(mniModificarUsuario);

        mniBajaUsuario.setText("Dar de baja");
        mniBajaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBajaUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(mniBajaUsuario);

        mnuGestion.add(mnuUsuario);

        mnuOtros.setText("Otros");

        mnuGestionLocalizacion.setText("Gestion de localizacion");

        mniAltaLocalizacion.setText("Alta de localizacion");
        mniAltaLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAltaLocalizacionActionPerformed(evt);
            }
        });
        mnuGestionLocalizacion.add(mniAltaLocalizacion);

        mniBajaLocalizacion.setText("Baja de localizacion");
        mniBajaLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBajaLocalizacionActionPerformed(evt);
            }
        });
        mnuGestionLocalizacion.add(mniBajaLocalizacion);

        mnuOtros.add(mnuGestionLocalizacion);

        mnuGestionProveedor.setText("Gestion de Proveedores");

        mniAltaProveedor.setText("Alta de proveedor");
        mniAltaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAltaProveedorActionPerformed(evt);
            }
        });
        mnuGestionProveedor.add(mniAltaProveedor);

        mniEditarProveedor.setText("Modificar proveedor");
        mniEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditarProveedorActionPerformed(evt);
            }
        });
        mnuGestionProveedor.add(mniEditarProveedor);

        mniEliminarProveedor.setText("Eliminar proveedor");
        mniEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEliminarProveedorActionPerformed(evt);
            }
        });
        mnuGestionProveedor.add(mniEliminarProveedor);

        mnuOtros.add(mnuGestionProveedor);

        mnuGestionTipos.setText("Gestion de tipos");

        mniAltaTipo.setText("Alta de tipo");
        mniAltaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAltaTipoActionPerformed(evt);
            }
        });
        mnuGestionTipos.add(mniAltaTipo);

        mniBajaTipo.setText("Baja de tipo");
        mniBajaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBajaTipoActionPerformed(evt);
            }
        });
        mnuGestionTipos.add(mniBajaTipo);

        mnuOtros.add(mnuGestionTipos);

        mnuGestion.add(mnuOtros);

        mnbMenu.add(mnuGestion);

        mnuAyuda.setText("Ayuda");

        mniAcercaDe.setText("Acerca de");
        mnuAyuda.add(mniAcercaDe);

        mnbMenu.add(mnuAyuda);

        setJMenuBar(mnbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreUser)
                .addContainerGap(482, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInfoTabla)
                        .addGap(153, 153, 153))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBienvenida)
                    .addComponent(lblNombreUser))
                .addGap(26, 26, 26)
                .addComponent(lblInfoTabla)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        rellenarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void mniIdentificarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniIdentificarseActionPerformed
        //Pregunto si quiere cerrar sesion
        Object[] opciones = { "Si", "No"};
        int opcion = JOptionPane.showOptionDialog(null, "??Desea cerrar sesi??n?", "Confirmaci??n",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        
        if(opcion==0){
            Login login = new Login();
            login.setVisible(true);
            
            this.dispose();
        }
    }//GEN-LAST:event_mniIdentificarseActionPerformed

    private void mniNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNuevoUsuarioActionPerformed
        GestionUsuarios nuevo = new GestionUsuarios("A??adiendo Usuario",null);
        nuevo.setVisible(true);
    }//GEN-LAST:event_mniNuevoUsuarioActionPerformed

    private void mniModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniModificarUsuarioActionPerformed
        String entrada = comboBoxMulti("usuario");
        boolean selfModif = false;
        if(entrada != null){
            if(!(Integer.valueOf(entrada.substring(0,entrada.indexOf("#"))) == 1)){
                Usuario modif = Conexion.recogeUsuarioId(entrada.substring(0,entrada.indexOf("#")));
                if(userRegistrado.toString().equals(modif.toString())){
                    selfModif = true;
                }            
                GestionUsuarios modificar = new GestionUsuarios("Modificando usuario",modif);
                modificar.setVisible(true);
                if(selfModif == true){
                    comprobarUsuario(entrada.substring(0,entrada.indexOf("#")));
                }  
            }else{
                JOptionPane.showMessageDialog(null,"No puede modificar al root del sistema","Error",JOptionPane.ERROR_MESSAGE);
            }
        }        
    }//GEN-LAST:event_mniModificarUsuarioActionPerformed

    private void mniBajaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBajaUsuarioActionPerformed
        String entrada = comboBoxMulti("usuario");
        if(entrada!=null){    
            if(!(Integer.valueOf(entrada.substring(0,entrada.indexOf("#"))) == 1)){
                Usuario user = Conexion.recogeUsuario(entrada);

                Object[] opciones = { "Si", "No"};
                int opcion = JOptionPane.showOptionDialog(null, "??Est?? seguro de querer eliminar a este usuario?", "Confirmaci??n",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                if(opcion==0){
                    Conexion.deleteUser(entrada.substring(0,entrada.indexOf("#")));
                    if(Integer.valueOf(entrada.substring(0,entrada.indexOf("#"))) == userRegistrado.getIdUsuario()){
                        //Si se elimina a si mismo entonces vuelvo al menu principal

                        Login login = new Login();
                        login.setVisible(true);

                        this.dispose();                    
                    }
                }                    
            }else{
                JOptionPane.showMessageDialog(null,"No puede eliminar al root del sistema","Error",JOptionPane.ERROR_MESSAGE);
            }        
        }
    }//GEN-LAST:event_mniBajaUsuarioActionPerformed

    private void mniConsultarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConsultarMaterialActionPerformed
        ConsultarMateriales consulta = new ConsultarMateriales();
        consulta.setVisible(true);
    }//GEN-LAST:event_mniConsultarMaterialActionPerformed

    private void mniAltaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAltaProveedorActionPerformed
        GestionProveedor proveedor = new GestionProveedor("Alta",null);
        proveedor.setVisible(true);
    }//GEN-LAST:event_mniAltaProveedorActionPerformed

    private void mniCambioPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCambioPassActionPerformed
        //Aqui le paso un parametro adicional para despues poder cambiar la contrase??a
        CambiarPass cambiar = new CambiarPass(userRegistrado.getIdUsuario(),userRegistrado.getPass());
        cambiar.setVisible(true);
    }//GEN-LAST:event_mniCambioPassActionPerformed

    private void mniInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInfoActionPerformed
        //Muestro un mensaje con los datos del usuario
        JOptionPane.showMessageDialog(null,"Su id es: "+String.valueOf(userRegistrado.getIdUsuario())+"\nSu nombre es: "+userRegistrado.getNombre()+" "+userRegistrado.getApellido()+"\n"
                + "Su email es: "+userRegistrado.getEmail()+"\nSu usuario es de tipo: "+userRegistrado.getTipo(),"Informacion",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mniInfoActionPerformed

    private void mniAltaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAltaMaterialActionPerformed
        //Boton para dar de alta un material
        GestionMateriales alta = new GestionMateriales("Dar de alta",null);
        alta.setVisible(true);
    }//GEN-LAST:event_mniAltaMaterialActionPerformed

    private void mniModifMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniModifMaterialActionPerformed
        //Boton para modificar material
        String entrada = comboBoxMulti("material");
        if(entrada != null){
            Material materialModif = Conexion.recogeMaterial(entrada);
            if(materialModif.isDisponible()){
                GestionMateriales modif = new GestionMateriales("Modificar",materialModif);
                modif.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Ese material esta dado de baja","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mniModifMaterialActionPerformed

    private void mniBajaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBajaMaterialActionPerformed
        //Boton para eliminar material
        String entrada = comboBoxMulti("material");
        if(entrada != null){
            Material materialDelete = Conexion.recogeMaterial(entrada);
            if(materialDelete.isDisponible()){
                Object[] opciones = { "Si", "No"};
                int opcion = JOptionPane.showOptionDialog(null, "??Est?? seguro de querer dar de baja?", "Confirmaci??n",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if(opcion==0){
                    Conexion.deleteMaterial(entrada,"si");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ese material ya esta dado de baja","Error",JOptionPane.ERROR_MESSAGE);
                Object[] opciones = { "Si", "No"};
                int opcion = JOptionPane.showOptionDialog(null, "??Desea volver a darlo de alta?", "Confirmaci??n",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if(opcion==0){
                    Conexion.deleteMaterial(entrada,"no");
                }
            }
        }
    }//GEN-LAST:event_mniBajaMaterialActionPerformed

    private void mniAsignarLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAsignarLocalizacionActionPerformed
        // Para asignar una localizacion a un material
        String entrada = comboBoxMulti("material");
        if(entrada != null){
            Material materialModifLoc = Conexion.recogeMaterial(entrada);
            if(materialModifLoc.isDisponible()){
                AsignarLocalizacion modif = new AsignarLocalizacion(materialModifLoc,lblNombreUser.getText());
                modif.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Ese material esta dado de baja","Error",JOptionPane.ERROR_MESSAGE);
            }
        }        
    }//GEN-LAST:event_mniAsignarLocalizacionActionPerformed

    private void mniAltaLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAltaLocalizacionActionPerformed
        //Para dar de alta una localizacion
        String entrada = JOptionPane.showInputDialog(null, "Introduzca el nombre de la nueva localizacion");
        if(entrada!=null){
            if(!(entrada.equals(""))){
                Conexion.a??adirLoc(entrada.toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null,"No deje el campo vacio","Error",JOptionPane.ERROR_MESSAGE);  
            }
        }

    }//GEN-LAST:event_mniAltaLocalizacionActionPerformed

    private void mniEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEliminarProveedorActionPerformed
        //Eliminar un proveedor
        String entrada = comboBoxMulti("proveedor");
        if(entrada != null){
            Proveedor proveedorDelete = Conexion.recogeProveedor(entrada.substring(0,entrada.indexOf("#")));
            if(proveedorDelete.getIdProveedor()!=1){
                Object[] opciones = { "Si", "No"};
                int opcion = JOptionPane.showOptionDialog(null, "??Est?? seguro de querer dar de baja?", "Confirmaci??n",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if(opcion==0){
                    Conexion.deleteProveedor(entrada.substring(0,entrada.indexOf("#")));
                }
            }else{
                JOptionPane.showMessageDialog(null,"No puede dar de baja a la Junta den Andalucia","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mniEliminarProveedorActionPerformed

    private void mniEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditarProveedorActionPerformed
        //Boton para modificar el proveedor
        String entrada = comboBoxMulti("proveedor");
        if(entrada != null){
            Proveedor provModif = Conexion.recogeProveedor(entrada.substring(0,entrada.indexOf("#")));
            if(provModif.getIdProveedor() != 1){
                GestionProveedor modif = new GestionProveedor("Modificar",provModif);
                modif.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"No puede modificar a la junta de andalucia","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mniEditarProveedorActionPerformed

    private void mniBajaLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBajaLocalizacionActionPerformed
        //Para dar de baja una localizacion
        String eleccion = comboBoxMulti("localizacion");
        if(eleccion != null){
            Conexion.eliminaLoc(eleccion);
        }
    }//GEN-LAST:event_mniBajaLocalizacionActionPerformed

    private void mniAltaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAltaTipoActionPerformed
        //Para dar de alta un tipo
        String entrada = JOptionPane.showInputDialog(null, "Introduzca el nombre del nuevo tipo");
        String codigo = Utilidades.generaCodigo();
        
        if(entrada!=null){
            if(!(entrada.equals(""))){
                Conexion.a??adirTipo(entrada,codigo);
            }else{
                JOptionPane.showMessageDialog(null,"No deje el campo vacio","Error",JOptionPane.ERROR_MESSAGE);  
            }
        }
    }//GEN-LAST:event_mniAltaTipoActionPerformed

    private void mniBajaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBajaTipoActionPerformed
        //Para dar de baja un tipo
        String eleccion = comboBoxMulti("tipo_material");
        if(eleccion != null){
            Conexion.eliminaTipo(eleccion.substring(0,eleccion.indexOf("#")));
        }
    }//GEN-LAST:event_mniBajaTipoActionPerformed

    private void mniHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHistorialActionPerformed
        // Para ver el historial del material
        HistorialMaterial historial = new HistorialMaterial();
        historial.setVisible(true);
    }//GEN-LAST:event_mniHistorialActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
    
    //---------------------------------------------------------------METODOS EXTRA---------------------------------------------------------------

    //Getter para la actualizacion de la contrase??a
    public static Usuario getUserRegistrado() {
        return userRegistrado;
    }
    
    //Este metodo sirve para ver si el usuario que ha sido modificado es el mismo que est?? registrado
    private void comprobarUsuario(String entrada) {
        Usuario user = Conexion.recogeUsuarioId(entrada);
        if(!(user.toString().equals(userRegistrado.toString()))){
            Login login = new Login();
            login.setVisible(true);

            this.dispose();  
        }
    }
    
    //Relleno la tabla de materiales, este metodo tambien lo utiliza el boton de actualizar tabla
    private void rellenarTabla() {
        DefaultTableModel tableModel = (DefaultTableModel) tblTabla.getModel();
        tableModel.getDataVector().removeAllElements();
        materiales.clear();
        materiales = Conexion.recogeMateriales();
        for (int x = 0; x< materiales.size();x++){
            //String nombre = materiales.get(x).getNombre();
            String nombre = materiales.get(x).getNombre();
            String tipo = materiales.get(x).getTipo().substring(materiales.get(x).getTipo().indexOf("#")+1);
            String marca = materiales.get(x).getMarca();
            String stock = String.valueOf(materiales.get(x).getStock());
            String localizacion = materiales.get(x).getLocalizacion();
            String proveedor = materiales.get(x).getProveedor().substring(materiales.get(x).getProveedor().indexOf("#")+1);
            String disponible = (materiales.get(x).isDisponible()?"Si":"No");
            
            Object[] data = {nombre,tipo,marca,stock,localizacion,proveedor,disponible};
            
            tableModel.addRow(data);

        }
    }
    
    private String comboBoxMulti(String dato){
        String[] opciones = Conexion.getDatos(dato);
        if(dato.equals("localizacion")){
            List<String> array = new LinkedList<>(Arrays.asList(opciones));
            array.remove(array.indexOf("SIN ASIGNAR"));
            opciones = array.stream().toArray(String[]::new);
        }
        JFrame frame = new JFrame("");
        String opcion = (String) JOptionPane.showInputDialog(frame, 
                "Elija una opcion",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]);
        return opcion;
    }   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblInfoTabla;
    private javax.swing.JLabel lblNombreUser;
    private javax.swing.JMenuBar mnbMenu;
    private javax.swing.JMenuItem mniAcercaDe;
    private javax.swing.JMenuItem mniAltaLocalizacion;
    private javax.swing.JMenuItem mniAltaMaterial;
    private javax.swing.JMenuItem mniAltaProveedor;
    private javax.swing.JMenuItem mniAltaTipo;
    private javax.swing.JMenuItem mniAsignarLocalizacion;
    private javax.swing.JMenuItem mniBajaLocalizacion;
    private javax.swing.JMenuItem mniBajaMaterial;
    private javax.swing.JMenuItem mniBajaTipo;
    private javax.swing.JMenuItem mniBajaUsuario;
    private javax.swing.JMenuItem mniCambioPass;
    private javax.swing.JMenuItem mniConsultarMaterial;
    private javax.swing.JMenuItem mniEditarProveedor;
    private javax.swing.JMenuItem mniEliminarProveedor;
    private javax.swing.JMenuItem mniHistorial;
    private javax.swing.JMenuItem mniIdentificarse;
    private javax.swing.JMenuItem mniInfo;
    private javax.swing.JMenuItem mniModifMaterial;
    private javax.swing.JMenuItem mniModificarUsuario;
    private javax.swing.JMenuItem mniNuevoUsuario;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuCredenciales;
    private javax.swing.JMenu mnuGestion;
    private javax.swing.JMenu mnuGestionLocalizacion;
    private javax.swing.JMenu mnuGestionMateriales;
    private javax.swing.JMenu mnuGestionProveedor;
    private javax.swing.JMenu mnuGestionTipos;
    private javax.swing.JMenu mnuMateriales;
    private javax.swing.JMenu mnuOtros;
    private javax.swing.JMenu mnuUsuario;
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables

}