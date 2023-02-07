package view;


import dados.SistemaDao;
import dados.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    //contrutor da classe
    public Menu(String nome, String cargo) {
        initComponents();
        itmListarUsuario.setVisible(false);
        lblSaudacao.setText("Bem Vindo! " + nome + " - Cargo: " + cargo);
        if (cargo.equalsIgnoreCase("gerente")) {
            itmListarUsuario.setVisible(true);
        } else if (cargo.equalsIgnoreCase("estagiario")) {
            itmExcluirProdutos.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaudacao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        mnuProdutos = new javax.swing.JMenu();
        itmCadastrarProdutos = new javax.swing.JMenuItem();
        itmAlterarProdutos = new javax.swing.JMenuItem();
        itmExcluirProdutos = new javax.swing.JMenuItem();
        itmListaProdutos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itmSair = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenu();
        mnuFuncionarios = new javax.swing.JMenu();
        itmListarUsuario = new javax.swing.JMenu();
        itmAlterarDadosUsuario = new javax.swing.JMenuItem();
        itmExcluirUsuario = new javax.swing.JMenuItem();
        itmExcluirTodosUsuarios = new javax.swing.JMenuItem();
        itmAdcUser = new javax.swing.JMenuItem();
        itmListaUsuarios = new javax.swing.JMenuItem();
        mnuAjuda = new javax.swing.JMenu();

        setTitle("menu do sistema");
        getContentPane().setLayout(null);

        lblSaudacao.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblSaudacao.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblSaudacao);
        lblSaudacao.setBounds(170, 10, 360, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo (1).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 530, 310);

        mnuProdutos.setText("Produtos");
        mnuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProdutosActionPerformed(evt);
            }
        });

        itmCadastrarProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmCadastrarProdutos.setText("Cadastrar");
        itmCadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastrarProdutosActionPerformed(evt);
            }
        });
        mnuProdutos.add(itmCadastrarProdutos);

        itmAlterarProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmAlterarProdutos.setText("Alterar");
        mnuProdutos.add(itmAlterarProdutos);

        itmExcluirProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmExcluirProdutos.setText("Excluir");
        mnuProdutos.add(itmExcluirProdutos);

        itmListaProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmListaProdutos.setText("relatorios");
        itmListaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaProdutosActionPerformed(evt);
            }
        });
        mnuProdutos.add(itmListaProdutos);
        mnuProdutos.add(jSeparator1);

        itmSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmSair.setText("Sair");
        mnuProdutos.add(itmSair);

        barMenu.add(mnuProdutos);

        mnuClientes.setText("Clientes");
        barMenu.add(mnuClientes);

        mnuFuncionarios.setText("Funcionarios");
        barMenu.add(mnuFuncionarios);

        itmListarUsuario.setText("Admin");

        itmAlterarDadosUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        itmAlterarDadosUsuario.setText("Alterar Dados de usuario");
        itmAlterarDadosUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAlterarDadosUsuarioActionPerformed(evt);
            }
        });
        itmListarUsuario.add(itmAlterarDadosUsuario);

        itmExcluirUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        itmExcluirUsuario.setText("Excluir usuario");
        itmExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirUsuarioActionPerformed(evt);
            }
        });
        itmListarUsuario.add(itmExcluirUsuario);

        itmExcluirTodosUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        itmExcluirTodosUsuarios.setText("Excluir todos os usuários");
        itmListarUsuario.add(itmExcluirTodosUsuarios);

        itmAdcUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        itmAdcUser.setText("Adicionar novo usuário");
        itmAdcUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAdcUserActionPerformed(evt);
            }
        });
        itmListarUsuario.add(itmAdcUser);

        itmListaUsuarios.setText("Lista Usuarios");
        itmListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaUsuariosActionPerformed(evt);
            }
        });
        itmListarUsuario.add(itmListaUsuarios);

        barMenu.add(itmListarUsuario);

        mnuAjuda.setText("Ajuda");
        barMenu.add(mnuAjuda);

        setJMenuBar(barMenu);

        setSize(new java.awt.Dimension(539, 348));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itmAdcUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAdcUserActionPerformed
        TelaUsuario tela;
        tela = new TelaUsuario();
        tela.setVisible(true);
    }//GEN-LAST:event_itmAdcUserActionPerformed

    private void itmExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExcluirUsuarioActionPerformed
        abrirTelaUsuario("excluir");
        
    }//GEN-LAST:event_itmExcluirUsuarioActionPerformed

    private void itmListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaUsuariosActionPerformed
        new ListaUsuario().setVisible(true);
    }//GEN-LAST:event_itmListaUsuariosActionPerformed

    private void itmAlterarDadosUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAlterarDadosUsuarioActionPerformed
        abrirTelaUsuario ("alterar");
        
    }//GEN-LAST:event_itmAlterarDadosUsuarioActionPerformed

    private void mnuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProdutosActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuProdutosActionPerformed

    private void itmCadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastrarProdutosActionPerformed
        new CadastroProdutos().setVisible(true);
    }//GEN-LAST:event_itmCadastrarProdutosActionPerformed

    private void itmListaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaProdutosActionPerformed
            new ListaProdutos().setVisible(true);
       
    }//GEN-LAST:event_itmListaProdutosActionPerformed

    private void abrirTelaUsuario (String operacao){
       
        // 1 - Solicitar o usuário a ser alterado
        String u;
        u = JOptionPane.showInputDialog(null, "Digite o usuário a " + operacao, "Usuario", 1);
        try { // ETAPA 1
            SistemaDao dao;
             dao = new SistemaDao();
             Usuario usuario = dao.buscarUsuario(u);
           
            //4 - Verificar se o usuário foi encontrado na tabela usuario do banco de dados.
            if (usuario!=null) {
                //Abrir o formulário Menu.java
                TelaUsuario tela;
                tela = new TelaUsuario(usuario, operacao);
                tela.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Usuário Não cadastrado");
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JMenuItem itmAdcUser;
    private javax.swing.JMenuItem itmAlterarDadosUsuario;
    private javax.swing.JMenuItem itmAlterarProdutos;
    private javax.swing.JMenuItem itmCadastrarProdutos;
    private javax.swing.JMenuItem itmExcluirProdutos;
    private javax.swing.JMenuItem itmExcluirTodosUsuarios;
    private javax.swing.JMenuItem itmExcluirUsuario;
    private javax.swing.JMenuItem itmListaProdutos;
    private javax.swing.JMenuItem itmListaUsuarios;
    private javax.swing.JMenu itmListarUsuario;
    private javax.swing.JMenuItem itmSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblSaudacao;
    private javax.swing.JMenu mnuAjuda;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenu mnuFuncionarios;
    private javax.swing.JMenu mnuProdutos;
    // End of variables declaration//GEN-END:variables
}
