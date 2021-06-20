/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.view;

import agroshift.controller.UserController;
import agroshift.model.Usuario;
import agroshift.util.MyConnectionDB;
import agroshift.util.UserLogin;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author victo
 */
public class UserMgmtView extends javax.swing.JFrame {

    /**
     * Creates new form UserMgmtView
     */
    public UserMgmtView() {
        initComponents();
        txtNewUsername.setEnabled(false);
        agregarUsuariosTabla();
        setLocationRelativeTo(null);
        setTitle("Gestión de credenciales | Administrador");
    }

    private void formatoTabla(){
                
        int[] weights = {200,200,192};
            
        for(int i = 0; i < tblUsuarios.getColumnCount(); i++){
            tblUsuarios.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(0, 139, 139));
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setFont(new Font("Segoe UI",Font.BOLD,14));
        headerRenderer.setOpaque(true);
        headerRenderer.setForeground(Color.BLACK);
  
        for (int i = 0; i < tblUsuarios.getModel().getColumnCount(); i++) {          //Recorro y se lo aplico a cada header
            tblUsuarios.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);    
        }
    }
    
    private void agregarUsuariosTabla(){
        UserController userController = new UserController();
        int numberColumns = 3;
        try{
            DefaultTableModel model = new DefaultTableModel();
            tblUsuarios.setModel(model);
            model.addColumn("Username");
            model.addColumn("Alias");
            model.addColumn("Rol");
            
            formatoTabla();
            
            ArrayList<Usuario> list = userController.obtenerUsuarios();
            
            for(Usuario user: list){
                Object[] rows = new Object[numberColumns];
                rows[0] = user.getUsername();
                rows[1] = user.getAlias();
                if(user.isIsAdmin()){
                    rows[2] = "ADMINISTRADOR";
                }else rows[2] = "USUARIO";
                model.addRow(rows);
            }
                
        } catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error al cargar los usuarios");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtAlias = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNewUsername = new javax.swing.JTextField();
        chkIsAdmin = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JPasswordField();
        btnNuevo = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));

        tblUsuarios.setBackground(new java.awt.Color(204, 204, 204));
        tblUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "Alias", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setFocusable(false);
        tblUsuarios.setRowHeight(20);
        tblUsuarios.setSelectionBackground(new java.awt.Color(255, 255, 102));
        tblUsuarios.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTIONANDO CREDENCIALES");

        jLabel2.setText("Usuario");

        jLabel3.setText("Clave");

        jLabel4.setText("Alias");

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        jLabel5.setText("Nuevo nombre");

        txtNewUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNewUsernameKeyPressed(evt);
            }
        });

        chkIsAdmin.setBackground(new java.awt.Color(153, 255, 102));
        chkIsAdmin.setText("Administrador");

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        jLabel7.setText("(Colocar aquí el nuevo nombre del usuario a actualizar)");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        jLabel8.setText("En caso de dejarlo vacío, el nombre quedará igual");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkIsAdmin)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtAlias, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNewUsername))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNewUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(chkIsAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        try {
            int FILA = tblUsuarios.getSelectedRow();
            if(FILA != -1){
                txtUsername.setText(tblUsuarios.getValueAt(FILA,0).toString());
                txtAlias.setText(tblUsuarios.getValueAt(FILA,1).toString());
                if("ADMINISTRADOR".equals(tblUsuarios.getValueAt(FILA, 2).toString())){
                    chkIsAdmin.setSelected(true);
                } else chkIsAdmin.setSelected(false);
                txtNewUsername.setEnabled(true);
            }
        } catch(Exception e){
            e.getMessage();
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if(txtUsername.getText().contains(" ")){
            JOptionPane.showMessageDialog(null, "El nombre de usuario no debe contener espacios");
            txtUsername.requestFocus();
        }
        else if(txtUsername.getText().length() > 0){
            if("" != String.valueOf(txtPassword.getPassword())){
                //ACA HABRIA QUE VALIDAR LA CONTRASEÑA
                if("" != txtAlias.getText()){
                    try{
                        PreparedStatement ps = null;
                        MyConnectionDB mycon = new MyConnectionDB();
                        Connection conn = mycon.getMyConnection();
                        String sql = "INSERT INTO usuario(username,clave,alias,is_admin) VALUES(?,?,?,?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, txtUsername.getText());
                        ps.setString(2, String.valueOf(txtPassword.getPassword()));
                        ps.setString(3, txtAlias.getText());
                        ps.setBoolean(4, chkIsAdmin.isSelected());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Usuario añadido con éxito!");
                        UserMgmtView newForm = new UserMgmtView();
                        newForm.setVisible(true);
                        this.dispose();
                    
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR EL NUEVO USUARIO");
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else{
                    JOptionPane.showMessageDialog(null,"DEBE INGRESAR EL ALIAS DEL NUEVO USUARIO");
                    txtAlias.requestFocus();
                }
            } else{
                JOptionPane.showMessageDialog(null,"DEBE INGRESAR LA CONTRASEÑA DEL NUEVO USUARIO");
                txtPassword.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null,"DEBE INGRESAR EL NOMBRE DEL NUEVO USUARIO");
            txtUsername.requestFocus();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if("".equals(txtNewUsername.getText())){ //SI ESTA VACIO HAGO UN UPDATE SIN EL USERNAME
            if("".equals(String.valueOf(txtPassword.getPassword()))){
                PreparedStatement ps = null;
                MyConnectionDB mycon = new MyConnectionDB();
                Connection conn = mycon.getMyConnection();
                try{
                    String sql = "UPDATE usuario SET alias = ?, is_admin= ? WHERE username = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, txtAlias.getText());
                    ps.setBoolean(2, chkIsAdmin.isSelected());
                    if(tblUsuarios.getSelectedRow() != -1){
                       ps.setString(3, tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),0).toString()); 
                    } else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE DE LA TABLA EL USUARIO A ACTUALIZAR");
                        return;
                    } 
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO CON ÉXTIO");
                    UserMgmtView newForm = new UserMgmtView();
                    newForm.setVisible(true);
                    this.dispose();
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR USUARIO");
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } finally{
                    try {
                        ps.close();
                    } catch (Exception e) {
                    }
                    try {
                        conn.close();
                    } catch (Exception e) {
                    }
                }
            } else{
                PreparedStatement ps = null;
                MyConnectionDB mycon = new MyConnectionDB();
                Connection conn = mycon.getMyConnection();
                try{                
                    String sql = "UPDATE usuario SET clave = ?, alias = ?, is_admin= ? WHERE username = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, String.valueOf(txtPassword.getPassword()));
                    ps.setString(2, txtAlias.getText());
                    ps.setBoolean(3, chkIsAdmin.isSelected());
                    if(tblUsuarios.getSelectedRow() != -1){
                       ps.setString(4, tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),0).toString()); 
                    } else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE DE LA TABLA EL USUARIO A ACTUALIZAR");
                        return;
                    } 
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO CON ÉXTIO");
                    UserMgmtView newForm = new UserMgmtView();
                    newForm.setVisible(true);
                    this.dispose();
                } catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR USUARIO");
                JOptionPane.showMessageDialog(null, e.getMessage());
                }finally{
                    try {
                        ps.close();
                    } catch (Exception e) {
                    }
                    try {
                        conn.close();
                    } catch (Exception e) {
                    }
                }
            }
            
        } else {                    //UPDATE CON NUEVO USERNAME                              
            if(txtNewUsername.getText().contains(" ")){
                JOptionPane.showMessageDialog(null, "El nuevo nombre de usuario no puede contener espacios");
                txtNewUsername.requestFocus();
            }else{                  //NO TIENE ESPACIOS
                if("".equals(String.valueOf(txtPassword.getPassword()))){   //MISMA CONTRASEÑA
                    PreparedStatement ps = null;
                    MyConnectionDB mycon = new MyConnectionDB();
                    Connection conn = mycon.getMyConnection();
                    try{
                        String sql = "UPDATE usuario SET username = ?, alias = ?, is_admin= ? WHERE username = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, txtNewUsername.getText());
                        ps.setString(2, txtAlias.getText());
                        ps.setBoolean(3, chkIsAdmin.isSelected());
                        if(tblUsuarios.getSelectedRow() != -1){
                           ps.setString(4, tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),0).toString()); 
                        } else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE DE LA TABLA EL USUARIO A ACTUALIZAR");
                            return;
                        } 
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO CON ÉXTIO");
                        UserMgmtView newForm = new UserMgmtView();
                        newForm.setVisible(true);
                        this.dispose();
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR USUARIO");
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } finally{
                        try {
                            ps.close();
                        } catch (Exception e) {
                        }
                        try {
                            conn.close();
                        } catch (Exception e) {
                        }
                    }
                } else{                         //NUEVA CONTRASEÑA
                    PreparedStatement ps = null;
                        MyConnectionDB mycon = new MyConnectionDB();
                        Connection conn = mycon.getMyConnection();
                    try{ 
                        String sql = "UPDATE usuario SET username = ?, clave = ?, alias = ?, is_admin= ? WHERE username = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, txtNewUsername.getText());
                        ps.setString(2, String.valueOf(txtPassword.getPassword()));
                        ps.setString(3, txtAlias.getText());
                        ps.setBoolean(4, chkIsAdmin.isSelected());
                        if(tblUsuarios.getSelectedRow() != -1){
                           ps.setString(5, tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),0).toString()); 
                        } else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE DE LA TABLA EL USUARIO A ACTUALIZAR");
                            return;
                        } 
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO CON ÉXTIO");
                        UserMgmtView newForm = new UserMgmtView();
                        newForm.setVisible(true);
                        this.dispose();
                    } catch(Exception e){
                    JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR USUARIO");
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    } finally{
                        try {
                            ps.close();
                        } catch (Exception e) {
                        }
                        try {
                            conn.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MainView form = new MainView();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            PreparedStatement ps = null;
            MyConnectionDB mycon = new MyConnectionDB();
            Connection con = mycon.getMyConnection();
            try{
                int FILA = tblUsuarios.getSelectedRow();
                String sql = "DELETE FROM usuario WHERE username = ?";
                ps = con.prepareStatement(sql);
                if(FILA != -1){
                    if(!tblUsuarios.getValueAt(FILA, 0).toString().equals(UserLogin.getInstance().username)){
                        ps.setString(1,tblUsuarios.getValueAt(FILA, 0).toString());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CON EXITO");
                        UserMgmtView newForm = new UserMgmtView();
                        newForm.setVisible(true);
                        this.dispose();
                    } else JOptionPane.showMessageDialog(null, "USTED NO PUEDE ELIMINARSE A SI MISMO, ACASO QUIERE HACER EXPLOTAR AL UNIVERSO?");   
                } else JOptionPane.showMessageDialog(null, "SELECCIONE EL USUARIO A ELIMINAR");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL USUARIO");
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally{
                try {
                    ps.close();
                } catch (Exception e) {
                }
                try {
                    con.close();
                } catch (Exception e) {
                }
            }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if(evt.getKeyChar() == 32){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se permiten espacios");
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtNewUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewUsernameKeyPressed
        if(evt.getKeyChar() == 32){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se permiten espacios");
        }
    }//GEN-LAST:event_txtNewUsernameKeyPressed

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
            java.util.logging.Logger.getLogger(UserMgmtView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMgmtView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMgmtView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMgmtView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMgmtView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkIsAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtNewUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
