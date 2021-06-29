/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.view;

import agroshift.controller.EquipmentController;
import agroshift.model.EquipoAgricola;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author victo
 */
public class EquipmentView extends javax.swing.JFrame {

    /**
     * Creates new form EquipmentView
     */
    public EquipmentView() {
        initComponents();
        setTitle("Equipo Agricola");
        setLocationRelativeTo(null);
        cargarEquipoTabla();
        cargarEstados();
        cargarTipos();
    }

    ArrayList<EquipoAgricola> equipos = new ArrayList<>();
    
    private void formatoTabla(){
                
        int[] weights = {25,25,20,25};
            
        for(int i = 0; i < tblEquipos.getColumnCount(); i++){
            tblEquipos.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(0, 139, 139));
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setFont(new Font("Segoe UI",Font.BOLD,14));
        headerRenderer.setOpaque(true);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
  
        for (int i = 0; i < tblEquipos.getModel().getColumnCount(); i++) {          //Recorro y se lo aplico a cada header
            tblEquipos.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);    
        }
        
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(244, 244, 230));
        cellRenderer.setForeground(Color.BLACK);
        cellRenderer.setFont(new Font("Segoe UI",Font.PLAIN,13));
        cellRenderer.setOpaque(true);
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < tblEquipos.getColumnCount(); i++) {          //Recorro y se lo aplico a cada header
            tblEquipos.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);    
        }
    }
    
    private void cargarEquipoTabla(){
        equipos = EquipmentController.obtenerTodosEquipos();
        int numberColumns = 4;
        try{
            DefaultTableModel model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            tblEquipos.setModel(model);
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Codigo");
            model.addColumn("Estado");
            
            formatoTabla();
            
            for(EquipoAgricola equipo: equipos){
                Object[] rows = new Object[numberColumns];
                rows[0] = EquipmentController.obtenerTipoPorId(equipo.getId_tipo());
                rows[1] = equipo.getMarca();
                rows[2] = equipo.getCodigo();
                rows[3] = EquipmentController.obtenerEstadoPorId(equipo.getId_estado());
                model.addRow(rows);
            }
                
        } catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error al cargar los clientes");
        }
    
    }
    
     private void cargarTipos(){
        ArrayList<String> tipos = EquipmentController.obtenerTodosTipos();
        for(String tipo:tipos){
            cbxTipo.addItem(tipo);
        }
    }
    private void cargarEstados(){
        ArrayList<String> estados = EquipmentController.obtenerTodosEstados();
        for(String est:estados){
            cbxEstado.addItem(est);
        }
    }
    
    private void cargarEquiposFiltradosTabla(String estado, String tipo){
        equipos = EquipmentController.obtenerEquipos(tipo, estado);
        int numberColumns = 4;
        try{
            DefaultTableModel model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            tblEquipos.setModel(model);
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Codigo");
            model.addColumn("Estado");
            
            formatoTabla();
            
            for(EquipoAgricola equipo: equipos){
                Object[] rows = new Object[numberColumns];
                rows[0] = EquipmentController.obtenerTipoPorId(equipo.getId_tipo());
                rows[1] = equipo.getMarca();
                rows[2] = equipo.getCodigo();
                rows[3] = EquipmentController.obtenerEstadoPorId(equipo.getId_estado());
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
        btnFilter = new javax.swing.JButton();
        cbxEstado = new javax.swing.JComboBox<>();
        cbxTipo = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JLabel();
        btnNew = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFilter.setText("FILTRAR");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel1.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 130, 40));

        jPanel1.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, -1));

        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 230, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agroshift/img/back-arrow-75.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agroshift/img/add_eq_agr.png"))); // NOI18N
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 170, 140));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agroshift/img/delete_eq_agr.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 180, 130));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agroshift/img/view_details_50.png"))); // NOI18N
        jLabel3.setText("EDITAR DATOS");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, -1, -1));

        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Marca", "Codigo", "Estado"
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
        tblEquipos.setRowHeight(27);
        tblEquipos.setSelectionBackground(new java.awt.Color(255, 255, 204));
        tblEquipos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblEquipos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 20, 690, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agroshift/img/fondo_maquinaria1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        MainView form = new MainView();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        NewEquipmentView form = new NewEquipmentView();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int FILA = tblEquipos.getSelectedRow();
        if(FILA != -1){
            EquipoAgricola equipo = equipos.get(FILA);
            if(EquipmentController.eliminarEquipo(equipo.getId_equipo())){
                this.dispose();
                EquipmentView form = new EquipmentView();
                form.setVisible(true);              
            }
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione el equipo a eliminar");
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        int FILA = tblEquipos.getSelectedRow();
        if(FILA != -1){
            UpdateEquipmentView form = new UpdateEquipmentView(equipos.get(FILA));
            form.setVisible(true);
            this.dispose();
        }else JOptionPane.showMessageDialog(null, "Seleccione el equipo!");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        cargarEquiposFiltradosTabla(String.valueOf(cbxEstado.getSelectedItem()), String.valueOf(cbxTipo.getSelectedItem()));
    }//GEN-LAST:event_btnFilterActionPerformed

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
            java.util.logging.Logger.getLogger(EquipmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipmentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel btnNew;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEquipos;
    // End of variables declaration//GEN-END:variables
}
