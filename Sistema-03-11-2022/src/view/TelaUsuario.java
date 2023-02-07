package view;


import dados.SistemaDao;
import dados.Usuario;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TelaUsuario extends javax.swing.JFrame {

    //Será chamado pela op do menu "Adicionar usuário"
    public TelaUsuario() {
        initComponents(); //coloca que você desenhou na tela
        btnExcluir.setVisible(false);
        btnSalvarAlteracao.setVisible(false);
    }

    //Será chamado pela op do menu "Excluir Usuário"
    //ou "Alterar Dados do Usuário".
    //Receberá os dados do usuário e exibirá nos campos

    public TelaUsuario(Usuario usuario, String operacao) {
        initComponents();
        txtUsuario.setText(usuario.getUsuario());
        txtSenha.setText(usuario.getSenha());
        txtNome.setText(usuario.getNome());
        cmbCargo.setSelectedItem(usuario.getCargo());
        if(operacao.equals("excluir")){
            btnSalvar.setVisible(false);
            btnSalvarAlteracao.setVisible(false);
        } else if(operacao.equals("alterar")){
           btnSalvar.setVisible(false);
           btnExcluir.setVisible(false);  
           txtUsuario.setEnabled(false);
        }
        btnSalvar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvarAlteracao = new javax.swing.JButton();

        setTitle("Controle de Usuários");
        getContentPane().setLayout(null);

        lblUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 0, 153));
        lblUsuario.setText("Usuário");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(30, 30, 80, 40);

        txtUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(90, 30, 240, 40);

        lblSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(0, 0, 153));
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(30, 90, 80, 40);

        txtSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(90, 90, 240, 40);

        lblNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(0, 0, 153));
        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(30, 150, 80, 40);

        txtNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(90, 150, 240, 40);

        lblCargo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblCargo.setForeground(new java.awt.Color(0, 0, 153));
        lblCargo.setText("Cargo");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(30, 210, 80, 40);

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Analista", "Estagiário", "Vendendor", "Programador", "Segurança", "Professor", " " }));
        cmbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCargoActionPerformed(evt);
            }
        });
        cmbCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCargoKeyPressed(evt);
            }
        });
        getContentPane().add(cmbCargo);
        cmbCargo.setBounds(90, 210, 180, 40);

        btnSalvar.setBackground(new java.awt.Color(0, 153, 153));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(40, 270, 90, 40);

        btnExcluir.setBackground(new java.awt.Color(0, 153, 153));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(170, 270, 100, 40);

        btnSalvarAlteracao.setBackground(new java.awt.Color(0, 153, 153));
        btnSalvarAlteracao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnSalvarAlteracao.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarAlteracao.setText("Salvar alteração");
        btnSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracaoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarAlteracao);
        btnSalvarAlteracao.setBounds(310, 270, 130, 40);

        setSize(new java.awt.Dimension(517, 383));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCargoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // 1 pegar os dados
        Usuario usuario;
        usuario = new Usuario();
        usuario.setUsuario(txtUsuario.getText());
        usuario.setSenha(txtSenha.getText());
        usuario.setNome(txtNome.getText());
        usuario.setCargo(cmbCargo.getSelectedItem().toString());
        

        //2 - Verificar se o campo txtUsuario do formulário, que é chave primária na tabela, não está vazio. 
        if (txtUsuario.getText().isEmpty()) { // se usuário está vazio
            JOptionPane.showMessageDialog(null, "É obrigatório digitar o usuário");
            txtUsuario.requestFocus();
            return; // stop
        }
        if (txtSenha.getText().isEmpty()) { // se a senha está vazio
            JOptionPane.showMessageDialog(null, "É obrigatório digitar a senha");
            txtUsuario.requestFocus();
            return; // stop
        }
        try {
            //Salvar os dados do usuário
            SistemaDao dao;
            dao = new SistemaDao();
            dao.salvarUsuario(usuario);

            // 4.1 Mostrar a mensagem "Usuário salvo com sucesso" e limpar os campos.
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
            txtUsuario.setText("");
            txtSenha.setText("");
            txtNome.setText("");
            cmbCargo.setSelectedIndex(0);
            txtUsuario.requestFocus();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Mensagem de erro:" + ex.getMessage());
        } catch (SQLException ex) {
            int erro = ex.getErrorCode();
            if (erro == 1062) {
                JOptionPane.showMessageDialog(null, "Usuário Já cadastrado");
                txtUsuario.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "ENtre em contato com o administrador do sistema e informe o erro: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtSenha.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtNome.requestFocus();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            cmbCargo.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void cmbCargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCargoKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_cmbCargoKeyPressed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnSalvar.doClick();
        }
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // 1 -  perguntar se tem certeza que deseja excluir
        int resposta; // 0 - yes; 1 - no; 
        resposta = JOptionPane.showConfirmDialog(null, "Confirma?", "Confirmação", 0);
        //  1.1 - Se a responta for sim
        if (resposta == 0) { // resposte yes
            //1.1.1 Obter o usuário no txtUsuario.
            String u = txtUsuario.getText();
         
            try {
                SistemaDao dao;
                dao = new SistemaDao();
                dao.excluirUsuario(u);
               
                //1.1.4 Mostrar a mensagem "Usuário excluido com sucesso" e fechar a tela
                JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso");

                //1.1.5
                dispose(); // comando que fecha a tela


            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Mensagem de erro:" + ex.getMessage());
            }
        } else { // Resposta foi Não
            dispose();
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracaoActionPerformed
        // 1 pegar os dados
        String u, s, n, c;
        u = txtUsuario.getText();
        s = txtSenha.getText();
        n = txtNome.getText();
        c = cmbCargo.getSelectedItem().toString();

        //2 - Verificar se o campo txtUsuario do formulário, que é chave primária na tabela, não está vazio. 
        if (u.isEmpty()) { // se usuário está vazio
            JOptionPane.showMessageDialog(null, "É obrigatório digitar o usuário");
            txtUsuario.requestFocus();
            return; // stop
        }
        if (u.isEmpty()) { // se a senha está vazio
            JOptionPane.showMessageDialog(null, "É obrigatório digitar a senha");
            txtUsuario.requestFocus();
            return; // stop
        }
        try {
            //alterar dados do usuario [UPDATE]
           SistemaDao dao;
           dao = new SistemaDao();
           dao.alterarUsuario(s, n, c, u);
           
            // 4.1 Mostrar a mensagem "Usuário salvo com sucesso" e limpar os campos.
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
           
           
                dispose();
                
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Mensagem de erro:" + ex.getMessage());
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }//GEN-LAST:event_btnSalvarAlteracaoActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarAlteracao;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
