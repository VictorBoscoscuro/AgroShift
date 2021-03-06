/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.view;

import agroshift.controller.ClientController;
import agroshift.model.Cliente;
import agroshift.model.Rent;
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
public class SelectClientRentView extends javax.swing.JFrame {

    /**
     * Creates new form SelectClientRentView
     */
    public SelectClientRentView() {
        initComponents();
    }
    public SelectClientRentView(Rent renta){
        initComponents();
        agregarClientesTabla();
        this.renta = renta;
        setTitle("Seleccionar Cliente");
    }
    private Rent renta;

    private void formatoTabla(){
                
        int[] weights = {235,150,205,225};
            
        for(int i = 0; i < tblClientes.getColumnCount(); i++){
            tblClientes.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(0, 139, 139));
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setFont(new Font("Segoe UI",Font.BOLD,14));
        headerRenderer.setOpaque(true);
        headerRenderer.setForeground(Color.BLACK);
  
        for (int i = 0; i < tblClientes.getModel().getColumnCount(); i++) {          //Recorro y se lo aplico a cada header
            tblClientes.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);    
        }
    }
    
     ArrayList<Cliente> list;
     
    private void agregarClientesTabla(){

        int numberColumns = 4;
        try{
            DefaultTableModel model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            tblClientes.setModel(model);
            model.addColumn("Nombre");
            model.addColumn("Codigo");
            model.addColumn("Telefono");
            model.addColumn("Mail");
            
            formatoTabla();
            
           this.list = new ClientController().obtenerClientes();
            
            for(Cliente cliente: list){
                Object[] rows = new Object[numberColumns];
                rows[0] = cliente.getNombre();
                rows[1] = cliente.getCodigo();
                rows[2] = cliente.getTelefono();
                rows[3] = cliente.getMail();
                model.addRow(rows);
            }
                
        } catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error al cargar los clientes");
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
        btnSelectEquipment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSelectEquipment1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        btnSelectEquipment.setText("<html><center>Avanzar a equipos</html>");
        btnSelectEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectEquipmentActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Codigo", "Telefono", "Mail"
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
        tblClientes.setRowHeight(23);
        jScrollPane1.setViewportView(tblClientes);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELEGIR CLIENTE");

        btnSelectEquipment1.setText("<html><center>Volver atras</html>");
        btnSelectEquipment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectEquipment1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSelectEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelectEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnSelectEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectEquipmentActionPerformed
        int FILA = tblClientes.getSelectedRow();
        if(FILA != -1){
            Long id_cliente = ClientController.obtenerIdClientePorCodigo(tblClientes.getValueAt(FILA, 1).toString());
            if(id_cliente != null){
                renta.setId_cliente(id_cliente);
                SelectEquipmentRentView form = new SelectEquipmentRentView(renta);
                form.setVisible(true);
                this.dispose();
            }
        } else JOptionPane.showMessageDialog(null, "Elegir el cliente primero");
    }//GEN-LAST:event_btnSelectEquipmentActionPerformed

    private void btnSelectEquipment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectEquipment1ActionPerformed
        RentsView form = new RentsView();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSelectEquipment1ActionPerformed

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
            java.util.logging.Logger.getLogger(SelectClientRentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectClientRentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectClientRentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectClientRentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectClientRentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectEquipment;
    private javax.swing.JButton btnSelectEquipment1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
