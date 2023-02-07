package view;

import dados.SistemaDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;  

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
             
public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acesso ao Sistema");
        getContentPane().setLayout(null);

        lblSenha.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(0, 0, 153));
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(40, 90, 80, 30);

        txtUsuario.setBackground(new java.awt.Color(204, 204, 255));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(140, 50, 170, 30);

        lblUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 0, 153));
        lblUsuario.setText("Usuário");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(40, 50, 80, 30);

        txtSenha.setBackground(new java.awt.Color(204, 204, 255));
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(140, 90, 170, 30);

        btnEntrar.setBackground(new java.awt.Color(0, 153, 153));
        btnEntrar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(50, 150, 100, 40);

        setSize(new java.awt.Dimension(485, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        try {
            String usuario, senha;
            usuario = txtUsuario.getText();
            senha = txtSenha.getText();
            
            //Chamar a classe SistemaDao
            SistemaDao x;
            x = new SistemaDao();
            
            ResultSet resultado = x.validarUsuario(usuario, senha);
            
            //4 - Verificar se o usuário foi encontrado na tabela usuario do banco de dados.
            if(resultado.next()){
                //pega o nome e o cargo que veio na consulta do banco de dados
                String nome;
                String cargo;
                nome = resultado.getString("nome");
                cargo = resultado.getString("cargo");
                 //Abrir o formulário Menu.java
                Menu tela;
                tela = new Menu(nome, cargo);
                tela.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null,"Usuário e/ou senha inválidos");
            } 
        
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
       if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            txtSenha.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
       if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            btnEntrar.requestFocus();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
             btnEntrar.doClick();
        }
    }//GEN-LAST:event_btnEntrarKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
