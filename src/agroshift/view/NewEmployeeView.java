/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.view;

import agroshift.controller.EmployeeController;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author victo
 */
public class NewEmployeeView extends javax.swing.JFrame {

    /**
     * Creates new form NewEmployeeView
     */
    public NewEmployeeView() {
        initComponents();
        setTitle("Nuevo Empleado");
        setLocationRelativeTo(null);
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
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDocument = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnRebootInfo = new javax.swing.JButton();
        txtDayBirth = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMonthBirth = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtYearBirth = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDayRegistr = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMonthregistr = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtYearRegistr = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVO EMPLEADO");

        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        txtDocument.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Documento");

        txtNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Numero");

        txtRole.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Rol/Cargo");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nacimiento");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Alta");

        btnCreate.setText("CREAR");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnBack.setText("VOLVER");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRebootInfo.setText("REINICIAR");
        btnRebootInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRebootInfoActionPerformed(evt);
            }
        });

        txtDayBirth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDayBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDayBirthActionPerformed(evt);
            }
        });

        jLabel8.setText("D??a");

        txtMonthBirth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMonthBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthBirthActionPerformed(evt);
            }
        });

        jLabel9.setText("Mes");

        txtYearBirth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtYearBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearBirthActionPerformed(evt);
            }
        });

        jLabel10.setText("A??o");

        jLabel11.setText("D??a");

        txtDayRegistr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDayRegistr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDayRegistrActionPerformed(evt);
            }
        });

        jLabel12.setText("Mes");

        txtMonthregistr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMonthregistr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthregistrActionPerformed(evt);
            }
        });

        jLabel13.setText("A??o");

        txtYearRegistr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtYearRegistr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearRegistrActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Clarendon Lt BT", 2, 11)); // NOI18N
        jLabel14.setText("dd-MM-yyyy");

        jLabel15.setFont(new java.awt.Font("Clarendon Lt BT", 2, 11)); // NOI18N
        jLabel15.setText("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRebootInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDocument)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumber)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRole)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDayRegistr, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonthregistr, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtYearRegistr, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDayBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonthBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtYearBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel14)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDayBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMonthBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtYearBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDayRegistr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMonthregistr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtYearRegistr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRebootInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentActionPerformed

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void txtRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoleActionPerformed

    private void btnRebootInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRebootInfoActionPerformed
        Component[] components = jPanel1.getComponents();
        for(Component c: components){
            if(c instanceof JTextField){
                ((JTextField) c).setText("");
            }
        }
    }//GEN-LAST:event_btnRebootInfoActionPerformed

    private void txtDayBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDayBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDayBirthActionPerformed

    private void txtMonthBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthBirthActionPerformed

    private void txtYearBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearBirthActionPerformed

    private void txtDayRegistrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDayRegistrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDayRegistrActionPerformed

    private void txtMonthregistrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthregistrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthregistrActionPerformed

    private void txtYearRegistrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearRegistrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearRegistrActionPerformed

    private String validarCampos(){
        if(txtName.getText().length() > 1){
            if(txtDocument.getText().length() > 5){
                if(txtNumber.getText().length() > 0 && txtNumber.getText().length() < 5){
                    String aux = txtNumber.getText();
                    txtNumber.setText("0".repeat(4-aux.length())+aux);
                    return "OK";
                } return "Ingrese un numero valido (maximo 4 caracteres)";
            } else{
                return "Ingrese un documento valido";
            }
        } else{
            return "Ingrese un nombre";
        }
    }
    
    private boolean validarFechas(){
        return true;        //implementar
    }
    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String validate = validarCampos();
        if(validate == "OK"){
            if(validarFechas()){
                String documento = txtDocument.getText();
                String nombre = txtName.getText().toUpperCase();
                String dia_nacim="";
                if(txtDayBirth.getText().length() == 1){
                    dia_nacim = "0"+txtDayBirth.getText();
                } else dia_nacim = txtDayBirth.getText();
                String mes_nacim="";
                if(txtMonthBirth.getText().length() == 1){
                    mes_nacim = "0"+txtMonthBirth.getText();
                } else mes_nacim = txtMonthBirth.getText();
                String anio_nacim = "";
                if(txtYearBirth.getText().length() != 4){
                    JOptionPane.showMessageDialog(null, "Ingrese el a??o correctamente");
                    txtYearBirth.requestFocus();
                    return;
                } else{
                    anio_nacim = txtYearBirth.getText();
                }
                String nacimiento = anio_nacim+"-"+mes_nacim+"-"+dia_nacim;
                
                String dia_alta = "";
                if(txtDayRegistr.getText().length() == 1){
                    dia_alta = "0"+txtDayRegistr.getText();
                } else dia_alta = txtDayRegistr.getText();
                String mes_alta = "";
                if(txtMonthregistr.getText().length() == 1){
                    mes_alta = "0"+txtMonthregistr.getText();
                } else mes_alta = txtMonthregistr.getText();
                String anio_alta = "";
                if(txtYearRegistr.getText().length() != 4){
                    JOptionPane.showMessageDialog(null, "Ingrese el a??o correctamente");
                    txtYearRegistr.requestFocus();
                    return;
                } else{
                    anio_alta = txtYearRegistr.getText();
                }
                String alta = anio_alta+"-"+mes_alta+"-"+dia_alta;
                
                String numero = txtNumber.getText();
                String rol = "";
                if(!"".equals(txtRole.getText())){
                    rol = txtRole.getText();
                }
                
                EmployeeController.nuevoEmpleado(documento,nombre,nacimiento,alta, numero, rol);
                EmployeesView form = new EmployeesView();
                form.setVisible(true);
                this.dispose();
            } else{
                JOptionPane.showMessageDialog(null, "Error en las fechas");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, validate);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        EmployeesView form = new EmployeesView();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(NewEmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewEmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewEmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewEmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewEmployeeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRebootInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDayBirth;
    private javax.swing.JTextField txtDayRegistr;
    private javax.swing.JTextField txtDocument;
    private javax.swing.JTextField txtMonthBirth;
    private javax.swing.JTextField txtMonthregistr;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtYearBirth;
    private javax.swing.JTextField txtYearRegistr;
    // End of variables declaration//GEN-END:variables
}
