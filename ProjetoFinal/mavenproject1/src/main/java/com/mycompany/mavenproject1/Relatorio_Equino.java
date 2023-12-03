/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Família Silva
 */
public class Relatorio_Equino extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioAnimais
     */
    static Relatorio_Equino relAnimaisUniq;
    
    private Relatorio_Equino() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public static Relatorio_Equino getRelAnimaisUniq(){
        if(relAnimaisUniq == null){
            relAnimaisUniq = new Relatorio_Equino();
        }
        return relAnimaisUniq;
    }
     public void sair(){
        int resp = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente sair?",
                "Saida",
                JOptionPane.YES_NO_OPTION
        );
        if(resp == 0){
            dispose();
        }
    }
     
      public void listTab(){
        DefaultTableModel modelo = (DefaultTableModel)tbRelEquino.getModel();
        int posLin = 0;
        
        modelo.setRowCount(posLin);
        
        for(Equino cav:GerEquino.getGerEquinoUnic().getBdEquino()){ //for each
            modelo.insertRow(posLin, new Object[]{
                cav.getCodAnimal(),
                cav.getIdadeAnimal(),
                cav.getAlturaEquino(),
                cav.getPerimetroToracico(),
                cav.getPesoAnimal(),
                cav.getDoencaAnimal()
            });
            posLin++;
        }
    }
    
    public void selectTab(){
    
        String valLinTab = "";
        
        int posLin = tbRelEquino.getSelectedRow();
        int col = 0;
        for(col = 0; col < tbRelEquino.getColumnCount(); col++){
            valLinTab += tbRelEquino.getModel().getValueAt(posLin, col).toString();
            
            if(col+1 < tbRelEquino.getColumnCount()){
                valLinTab += " - ";
            }
        }
        
        JOptionPane.showMessageDialog(
                null,
                "Conteudo: "+valLinTab,
                "VALORES DA LINHA --> "+col,
                1
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelEquino = new javax.swing.JTable();
        btn_SAir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Relatório Equinos");

        tbRelEquino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "IDADE", "ALTURA", "P.T", "PESO", "DOENÇA"
            }
        ));
        tbRelEquino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRelEquinoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRelEquino);

        btn_SAir.setText("Sair");
        btn_SAir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SAirActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_SAir)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_SAir)
                    .addComponent(jButton2))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_SAirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SAirActionPerformed
        sair();
    }//GEN-LAST:event_btn_SAirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listTab();
    }//GEN-LAST:event_formWindowActivated

    private void tbRelEquinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelEquinoMouseClicked
        selectTab();
    }//GEN-LAST:event_tbRelEquinoMouseClicked

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
            java.util.logging.Logger.getLogger(Relatorio_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio_Equino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SAir;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbRelEquino;
    // End of variables declaration//GEN-END:variables
}
