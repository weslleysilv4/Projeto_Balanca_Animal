package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Wes
 */
public class Cadastro_Equino extends javax.swing.JFrame {
    private Equino cav;
    private GerEquino ge = GerEquino.getGerEquinoUnic();
    static Cadastro_Equino cadEquiUnic;
    
    private Cadastro_Equino() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public static Cadastro_Equino getCadEquiUnic(){
        if(cadEquiUnic == null){
            cadEquiUnic = new Cadastro_Equino();
        }
        return cadEquiUnic;
    }
    
    public void insEquino(){
        try{
            cav = new Equino();
        
            cav.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));
            cav.setIdadeAnimal(Integer.parseInt(cx_IdadeEquino.getText()));
            cav.setAlturaEquino(Double.parseDouble(cx_AlturaEquino.getText()));
            cav.setPerimetroToracico(Double.valueOf(cx_PerimetroEquino.getText()));
        
            cav.setDoencaAnimal(btn_DoencaSim.isSelected() ? "Doente" : "Sem doenças");

            cav.setPesoAnimal(cav.calcPeso(cav.getPerimetroToracico()));

            cav = ge.cadEquino(cav);

            if(cav != null){
                JOptionPane.showMessageDialog(
                        null,
                        "Animal Cadastrado com Sucesso!",
                        "Inserção de Animal",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            else{
                JOptionPane.showMessageDialog(
                    null,
                    "O Animal já está cadastrado!",
                    "Erro Inserção de Animal",
                    JOptionPane.ERROR_MESSAGE
                );
            }
            limpar();
        }
        catch(AlturaException| PesoException pe){
            JOptionPane.showMessageDialog(
                    null,
                    pe.getMessage(),
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO, o valor precisa ser numérico.",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void consEquino(){
        try{
            cav = new Equino();
        
            cav.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));

            cav = ge.consEquino(cav);

            if(cav != null){
                cx_CodAnimal.setText(Integer.toString(cav.getCodAnimal()));
                cx_IdadeEquino.setText(Integer.toString(cav.getIdadeAnimal()));
                cx_AlturaEquino.setText(Double.toString(cav.getAlturaEquino()));
                cx_PerimetroEquino.setText(Double.toString(cav.getPerimetroToracico()));

                JOptionPane.showMessageDialog(
                        null,
                        "Animal encontrado com sucesso! - Verifique os dados",
                        "CONSULTA DE ANIMAL",
                        1
                );
            }
            else{
                        JOptionPane.showMessageDialog(
                        null,
                        "NÃO EXISTE ANIMAL COM ESTE CODIGO",
                        "CONSULTA DE ANIMAL",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        catch(PesoException pe){
            JOptionPane.showMessageDialog(
                    null,
                    pe.getMessage(),
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO, o valor precisa ser numérico.",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void altEquino(){
        try{
            cav = new Equino();
        
            cav.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));

            cav = ge.attEquino(cav);

                if(cav != null){
                cx_CodAnimal.setText(Integer.toString(cav.getCodAnimal()));
                cx_IdadeEquino.setText(Integer.toString(cav.getIdadeAnimal()));
                cx_AlturaEquino.setText(Double.toString(cav.getAlturaEquino()));
                cx_PerimetroEquino.setText(Double.toString(cav.getPerimetroToracico()));

                JOptionPane.showMessageDialog(
                        null,
                        "Confira do dados!",
                        "ALTERAÇÃO DE ANIMAL",
                        1
                );
                limpar();
            }
            else{
                        JOptionPane.showMessageDialog(
                        null,
                        "NÃO EXISTE ANIMAL COM ESTE CODIGO",
                        "ALTERAÇÃO DE ANIMAL",
                        JOptionPane.ERROR_MESSAGE
                );
            }  
        }
        catch(AlturaException | PesoException pe){
            JOptionPane.showMessageDialog(
                    null,
                    pe.getMessage(),
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO, o valor precisa ser numérico.",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void delEquino(){
        try{
            cav = new Equino();
        
            cav.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));

            cav = ge.remEquino(cav);

                if(cav == null){

                JOptionPane.showMessageDialog(
                        null,
                        "Animal excluido com sucesso!",
                        "EXCLUSÃO DE ANIMAL",
                        1
                );
                limpar();
            }
            else{
                        JOptionPane.showMessageDialog(
                        null,
                        "NÃO EXISTE ANIMAL COM ESTE CODIGO",
                        "EXCLUSÃO DE ANIMAL",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            
        }
        catch(PesoException pe){
            JOptionPane.showMessageDialog(
                    null,
                    pe.getMessage(),
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO, o valor precisa ser numérico.",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void limpar (){
        cx_AlturaEquino.setText("");
        cx_CodAnimal.setText("");
        cx_IdadeEquino.setText("");
        cx_PerimetroEquino.setText("");
        cx_CodAnimal.requestFocus();
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
        
        for(Equino cav : ge.getBdEquino()){ //for each
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
        posLin += 1;
        JOptionPane.showMessageDialog(
                null,
                "Conteudo: "+valLinTab,
                "VALORES DA LINHA --> "+posLin,
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

        lb_CodAnimal = new javax.swing.JLabel();
        cx_CodAnimal = new javax.swing.JTextField();
        lb_IdadeAnimal = new javax.swing.JLabel();
        cx_IdadeEquino = new javax.swing.JTextField();
        lb_AlturaEquino = new javax.swing.JLabel();
        cx_AlturaEquino = new javax.swing.JTextField();
        lb_PerimetroToracico = new javax.swing.JLabel();
        cx_PerimetroEquino = new javax.swing.JTextField();
        btn_Cadastrar = new javax.swing.JButton();
        btn_Limpar = new javax.swing.JButton();
        lb_DoencaEquino = new javax.swing.JLabel();
        btn_DoencaSim = new javax.swing.JRadioButton();
        btn_DoencaNao = new javax.swing.JRadioButton();
        btn_Sair = new javax.swing.JButton();
        lb_CadastroEquino = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRelEquino = new javax.swing.JTable();
        btn_Consultar = new javax.swing.JButton();
        btn_Alterar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        cx_DoencaAnimal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Equino");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lb_CodAnimal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_CodAnimal.setText("Cod. Animal:");

        cx_CodAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_CodAnimalActionPerformed(evt);
            }
        });

        lb_IdadeAnimal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_IdadeAnimal.setText("Idade:");

        cx_IdadeEquino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_IdadeEquinoActionPerformed(evt);
            }
        });

        lb_AlturaEquino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_AlturaEquino.setText("Altura:");

        cx_AlturaEquino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_AlturaEquinoActionPerformed(evt);
            }
        });

        lb_PerimetroToracico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_PerimetroToracico.setText("Perimetro Toracico:");

        cx_PerimetroEquino.setToolTipText("Ex: 1.24");
        cx_PerimetroEquino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cx_PerimetroEquinoFocusLost(evt);
            }
        });
        cx_PerimetroEquino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_PerimetroEquinoActionPerformed(evt);
            }
        });

        btn_Cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        lb_DoencaEquino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_DoencaEquino.setText("O Animal possui alguma doença?");

        btn_DoencaSim.setText("Sim");
        btn_DoencaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoencaSimActionPerformed(evt);
            }
        });

        btn_DoencaNao.setText("Não");
        btn_DoencaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoencaNaoActionPerformed(evt);
            }
        });

        btn_Sair.setText("Sair");
        btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SairActionPerformed(evt);
            }
        });

        lb_CadastroEquino.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_CadastroEquino.setText("Cadastro Equino");

        jButton1.setText("Abrir Relatório de Animais");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbRelEquino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
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
        jScrollPane2.setViewportView(tbRelEquino);

        btn_Consultar.setText("Consultar");
        btn_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarActionPerformed(evt);
            }
        });

        btn_Alterar.setText("Alterar");
        btn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarActionPerformed(evt);
            }
        });

        btn_Excluir.setText("Excluir");
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });

        cx_DoencaAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_DoencaAnimalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_DoencaSim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_DoencaNao)
                                .addGap(18, 18, 18)
                                .addComponent(cx_DoencaAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Consultar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Alterar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Excluir))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Cadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Sair))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_CodAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cx_CodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lb_IdadeAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cx_IdadeEquino, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(358, 358, 358)
                                .addComponent(jButton1)))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_PerimetroToracico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cx_PerimetroEquino, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_DoencaEquino)
                            .addComponent(lb_CadastroEquino)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_AlturaEquino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cx_AlturaEquino, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lb_CadastroEquino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lb_CodAnimal)
                    .addComponent(cx_CodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cx_IdadeEquino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_IdadeAnimal)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cx_AlturaEquino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_AlturaEquino))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cx_PerimetroEquino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_PerimetroToracico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_DoencaEquino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_Alterar)
                    .addComponent(btn_Excluir)
                    .addComponent(btn_Consultar)
                    .addComponent(btn_DoencaNao)
                    .addComponent(btn_DoencaSim)
                    .addComponent(cx_DoencaAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cadastrar)
                    .addComponent(btn_Limpar)
                    .addComponent(btn_Sair))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cx_CodAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_CodAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_CodAnimalActionPerformed

    private void cx_IdadeEquinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_IdadeEquinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_IdadeEquinoActionPerformed

    private void cx_AlturaEquinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_AlturaEquinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_AlturaEquinoActionPerformed

    private void cx_PerimetroEquinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_PerimetroEquinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_PerimetroEquinoActionPerformed

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        insEquino();
        listTab();
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void btn_DoencaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoencaSimActionPerformed
        btn_DoencaNao.setSelected(false);
        cx_DoencaAnimal.setVisible(true);
    }//GEN-LAST:event_btn_DoencaSimActionPerformed

    private void btn_DoencaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoencaNaoActionPerformed
        btn_DoencaSim.setSelected(false);
        cx_DoencaAnimal.setVisible(false);
    }//GEN-LAST:event_btn_DoencaNaoActionPerformed

    private void btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SairActionPerformed
        sair();
        limpar();
    }//GEN-LAST:event_btn_SairActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        limpar();
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void cx_PerimetroEquinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cx_PerimetroEquinoFocusLost

    }//GEN-LAST:event_cx_PerimetroEquinoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Relatorio_Equino.getRelAnimaisUniq().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbRelEquinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelEquinoMouseClicked
        selectTab();
    }//GEN-LAST:event_tbRelEquinoMouseClicked

    private void btn_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarActionPerformed
        consEquino();
        listTab();
    }//GEN-LAST:event_btn_ConsultarActionPerformed

    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
       altEquino();
       listTab();
    }//GEN-LAST:event_btn_AlterarActionPerformed

    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed
        delEquino();
        listTab();
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void cx_DoencaAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_DoencaAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_DoencaAnimalActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        cx_DoencaAnimal.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Cadastro_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Equino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_Equino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Alterar;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Consultar;
    private javax.swing.JRadioButton btn_DoencaNao;
    private javax.swing.JRadioButton btn_DoencaSim;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JButton btn_Sair;
    private javax.swing.JTextField cx_AlturaEquino;
    private javax.swing.JTextField cx_CodAnimal;
    private javax.swing.JTextField cx_DoencaAnimal;
    private javax.swing.JTextField cx_IdadeEquino;
    private javax.swing.JTextField cx_PerimetroEquino;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb_AlturaEquino;
    private javax.swing.JLabel lb_CadastroEquino;
    private javax.swing.JLabel lb_CodAnimal;
    private javax.swing.JLabel lb_DoencaEquino;
    private javax.swing.JLabel lb_IdadeAnimal;
    private javax.swing.JLabel lb_PerimetroToracico;
    private javax.swing.JTable tbRelEquino;
    // End of variables declaration//GEN-END:variables
}
