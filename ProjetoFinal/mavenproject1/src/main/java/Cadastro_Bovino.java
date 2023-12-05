// DISCENTE: WESLLEY SILVA - RA: 2410257



import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Cadastro_Bovino extends javax.swing.JFrame {
    private Bovino bov;
    private GerBovino gb = GerBovino.getBovUnic();
    private static Cadastro_Bovino cadBovUnic;
    
    private Cadastro_Bovino() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public static Cadastro_Bovino getCadBovUnic(){
        if(cadBovUnic == null){
            cadBovUnic = new Cadastro_Bovino();
        }
        return cadBovUnic;
    }
    
    public void insBovino(){
        try{
            bov = new Bovino();
        
            bov.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));
            bov.setIdadeAnimal(Integer.parseInt(cx_Idade.getText()));        
            bov.setDoencaAnimal(btn_DoencaSim.isSelected() ? cx_DoencaAnimal.getText() : "Sem doenças");
            bov.setPesoAnimal(Double.valueOf(cx_PesoBruto.getText()));
            bov.setPesoEmArroba(bov.calcPeso(
                    Double.parseDouble(cx_PesoBruto.getText())
            ));
            System.out.println(bov.getPesoEmArroba());
            bov = gb.cadBovino(bov);

            if(bov != null){
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
    
    public void consBovino(){
        try{
            bov = new Bovino();
        
            bov.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));

            bov = gb.consBovino(bov);

            if(bov != null){
                cx_CodAnimal.setText(Integer.toString(bov.getCodAnimal()));
                cx_Idade.setText(Integer.toString(bov.getIdadeAnimal()));
                cx_PesoBruto.setText(Double.toString(bov.getPesoAnimal()));
                lb_PesoArroba.setText(Double.toString(bov.getPesoEmArroba()));

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
    
    public void altBovino(){
        try{
            bov = new Bovino();
        
            bov.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));

            bov = gb.attBovino(bov);

                if(bov != null){
                    cx_CodAnimal.setText(Integer.toString(bov.getCodAnimal()));
                    cx_Idade.setText(Integer.toString(bov.getIdadeAnimal()));
                    cx_PesoBruto.setText(Double.toString(bov.getPesoAnimal()));
                    lb_PesoArroba.setText(Double.toString(bov.getPesoEmArroba()));

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
    
    public void delBovino(){
        try{
            bov = new Bovino();
        
            bov.setCodAnimal(Integer.parseInt(cx_CodAnimal.getText()));

            bov = gb.remBovino(bov);

            if(bov == null){
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
            }catch(PesoException pe){
                JOptionPane.showMessageDialog(
                    null,
                    pe.getMessage(),
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE
                );
            } catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(
                null,
                "ERRO, o valor precisa ser numérico.",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void limpar (){
        cx_CodAnimal.setText("");
        cx_Idade.setText("");
        cx_PesoBruto.setText("");
        lb_PesoArroba.setText(Double.toString(0.0));
        cx_DoencaAnimal.setText("");
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
        DefaultTableModel modelo = (DefaultTableModel)tbRelBovino.getModel();
        int posLin = 0;
        
        modelo.setRowCount(posLin);
        
        for(Bovino bov : gb.getBdBovino()){ //for each
            modelo.insertRow(posLin, new Object[]{
                bov.getCodAnimal(),
                bov.getIdadeAnimal(),
                bov.getPesoAnimal(),
                bov.getPesoEmArroba(),
                bov.getDoencaAnimal()
            });
            posLin++;
        }
    }
    
    public void selectTab(){
    
        String valLinTab = "";
        
        int posLin = tbRelBovino.getSelectedRow();
        int col = 0;
        for(col = 0; col < tbRelBovino.getColumnCount(); col++){
            valLinTab += tbRelBovino.getModel().getValueAt(posLin, col).toString();
            
            if(col+1 < tbRelBovino.getColumnCount()){
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_Limpar = new javax.swing.JButton();
        btn_Consultar = new javax.swing.JButton();
        lb_DoencaEquino = new javax.swing.JLabel();
        btn_Alterar = new javax.swing.JButton();
        btn_DoencaSim = new javax.swing.JRadioButton();
        btn_Excluir = new javax.swing.JButton();
        btn_DoencaNao = new javax.swing.JRadioButton();
        cx_DoencaAnimal = new javax.swing.JTextField();
        btn_Sair = new javax.swing.JButton();
        lb_CadastroBovino = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lb_CodAnimal = new javax.swing.JLabel();
        cx_CodAnimal = new javax.swing.JTextField();
        lb_Idade = new javax.swing.JLabel();
        cx_Idade = new javax.swing.JTextField();
        lb_PesoBruto = new javax.swing.JLabel();
        cx_PesoBruto = new javax.swing.JTextField();
        cx_PesoArroba = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRelBovino = new javax.swing.JTable();
        btn_Cadastrar = new javax.swing.JButton();
        lb_PesoArroba = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btn_Limpar.setText("Limpar campos");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        btn_Consultar.setText("Consultar");
        btn_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarActionPerformed(evt);
            }
        });

        lb_DoencaEquino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_DoencaEquino.setText("O Animal possui alguma doença?");

        btn_Alterar.setText("Alterar");
        btn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarActionPerformed(evt);
            }
        });

        btn_DoencaSim.setText("Sim");
        btn_DoencaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoencaSimActionPerformed(evt);
            }
        });

        btn_Excluir.setText("Excluir");
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });

        btn_DoencaNao.setText("Não");
        btn_DoencaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoencaNaoActionPerformed(evt);
            }
        });

        cx_DoencaAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_DoencaAnimalActionPerformed(evt);
            }
        });

        btn_Sair.setText("Sair");
        btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SairActionPerformed(evt);
            }
        });

        lb_CadastroBovino.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_CadastroBovino.setText("Cadastro Bovino");

        jButton1.setText("Abrir Relatório de Animais");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lb_CodAnimal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_CodAnimal.setText("Cod. Animal:");

        cx_CodAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_CodAnimalActionPerformed(evt);
            }
        });

        lb_Idade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Idade.setText("Idade:");

        cx_Idade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_IdadeActionPerformed(evt);
            }
        });

        lb_PesoBruto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_PesoBruto.setText("Peso Bruto:");

        cx_PesoBruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cx_PesoBrutoActionPerformed(evt);
            }
        });

        cx_PesoArroba.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cx_PesoArroba.setText("Peso em Arroba:");

        tbRelBovino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "IDADE", "PESO", "PESO EM @", "DOENÇA"
            }
        ));
        tbRelBovino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRelBovinoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbRelBovino);

        btn_Cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        lb_PesoArroba.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_PesoArroba.setText("0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cx_PesoArroba)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_PesoArroba))
                            .addComponent(lb_DoencaEquino)
                            .addComponent(lb_CadastroBovino)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_PesoBruto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cx_PesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(499, 499, 499))
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lb_Idade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cx_Idade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lb_CodAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cx_CodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lb_CadastroBovino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cx_CodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_CodAnimal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cx_Idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Idade)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_PesoBruto)
                    .addComponent(cx_PesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cx_PesoArroba)
                    .addComponent(lb_PesoArroba))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_DoencaEquino)
                .addGap(12, 12, 12)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cadastrar)
                    .addComponent(btn_Limpar)
                    .addComponent(btn_Sair))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        limpar();
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void btn_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarActionPerformed
        consBovino();
        listTab();
    }//GEN-LAST:event_btn_ConsultarActionPerformed

    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
        altBovino();
        listTab();
    }//GEN-LAST:event_btn_AlterarActionPerformed

    private void btn_DoencaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoencaSimActionPerformed
        btn_DoencaNao.setSelected(false);
        cx_DoencaAnimal.setVisible(true);
    }//GEN-LAST:event_btn_DoencaSimActionPerformed

    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed
        delBovino();
        listTab();
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void btn_DoencaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoencaNaoActionPerformed
        btn_DoencaSim.setSelected(false);
        cx_DoencaAnimal.setVisible(false);
    }//GEN-LAST:event_btn_DoencaNaoActionPerformed

    private void cx_DoencaAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_DoencaAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_DoencaAnimalActionPerformed

    private void btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SairActionPerformed
        sair();
        limpar();
    }//GEN-LAST:event_btn_SairActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Relatorio_Bovino.getRelBovinoUniq().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cx_CodAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_CodAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_CodAnimalActionPerformed

    private void cx_IdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_IdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_IdadeActionPerformed

    private void cx_PesoBrutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cx_PesoBrutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cx_PesoBrutoActionPerformed

    private void tbRelBovinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelBovinoMouseClicked
        selectTab();
    }//GEN-LAST:event_tbRelBovinoMouseClicked

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        insBovino();
        listTab();
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cx_DoencaAnimal.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Cadastro_Bovino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Bovino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Bovino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Bovino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_Bovino().setVisible(true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cx_CodAnimal;
    private javax.swing.JTextField cx_DoencaAnimal;
    private javax.swing.JTextField cx_Idade;
    private javax.swing.JLabel cx_PesoArroba;
    private javax.swing.JTextField cx_PesoBruto;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb_CadastroBovino;
    private javax.swing.JLabel lb_CodAnimal;
    private javax.swing.JLabel lb_DoencaEquino;
    private javax.swing.JLabel lb_Idade;
    private javax.swing.JLabel lb_PesoArroba;
    private javax.swing.JLabel lb_PesoBruto;
    private javax.swing.JTable tbRelBovino;
    // End of variables declaration//GEN-END:variables
}
