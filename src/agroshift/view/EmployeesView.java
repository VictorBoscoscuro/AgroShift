/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.view;

import agroshift.controller.EmployeeController;
import agroshift.controller.UserController;
import agroshift.model.Empleado;
import agroshift.model.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victo
 */
public class EmployeesView extends javax.swing.JFrame {

    /**
     * Creates new form EmployeesView
     */
    public EmployeesView() {
        initComponents();
        agregarEmpleadosTabla();
    }

    private ArrayList<Empleado> empleados = new ArrayList<>();
    
     private void formatoTabla(){
                
        int[] weights = {215,150,225,225};
            
        for(int i = 0; i < tblEmployees.getColumnCount(); i++){
            tblEmployees.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(0, 139, 139));
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setFont(new Font("Segoe UI",Font.BOLD,14));
        headerRenderer.setOpaque(true);
        headerRenderer.setForeground(Color.BLACK);
  
        for (int i = 0; i < tblEmployees.getModel().getColumnCount(); i++) {          //Recorro y se lo aplico a cada header
            tblEmployees.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);    
        }
    }
    
    private void agregarEmpleadosTabla(){
        UserController userController = new UserController();
        int numberColumns = 4;
        try{
            DefaultTableModel model = new DefaultTableModel();
            tblEmployees.setModel(model);
            model.addColumn("Empleado");
            model.addColumn("Documento");
            model.addColumn("Numero");
            model.addColumn("Rol/Cargo");
            
            formatoTabla();
            
            ArrayList<Empleado> list = new EmployeeController().obtenerEmpleados();
            
            for(Empleado empleado: list){
                Object[] rows = new Object[numberColumns];
                rows[0] = empleado.getNombre();
                rows[1] = empleado.getDocumento();
                rows[2] = empleado.getNumero();
                rows[3] = empleado.getRol();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSeeInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLEADOS");

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Empleado", "Documento", "Numero", "Rol/Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployees.setRowHeight(32);
        jScrollPane1.setViewportView(tblEmployees);

        btnBack.setText("VOLVER");

        btnNew.setText("AGREGAR");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setText("ELIMINAR");

        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSeeInfo.setText("VER INFORMACION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addGap(248, 248, 248)
                        .addComponent(btnSeeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 340, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnSeeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        NewEmployeeView form = new NewEmployeeView();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int FILA = tblEmployees.getSelectedRow();
        UpdateEmployeeView form = new UpdateEmployeeView(tblEmployees.getValueAt(FILA, 1).toString(),tblEmployees.getValueAt(FILA, 0).toString(),tblEmployees.getValueAt(FILA, 2).toString(),tblEmployees.getValueAt(FILA, 3).toString());
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed


    
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
            java.util.logging.Logger.getLogger(EmployeesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSeeInfo;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployees;
    // End of variables declaration//GEN-END:variables
}
