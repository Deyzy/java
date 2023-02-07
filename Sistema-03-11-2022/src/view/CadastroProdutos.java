package view;

import dados.Produto;
import dados.SistemaDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroProdutos extends javax.swing.JFrame {

    public CadastroProdutos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvarAlteracao = new javax.swing.JButton();

        setTitle("Cadastro de produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(20, 20, 70, 40);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(80, 20, 200, 40);

        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(20, 80, 70, 40);
        getContentPane().add(txtNome);
        txtNome.setBounds(80, 80, 320, 40);

        lblMarca.setText("Marca");
        getContentPane().add(lblMarca);
        lblMarca.setBounds(20, 140, 60, 40);
        getContentPane().add(txtMarca);
        txtMarca.setBounds(80, 142, 320, 40);

        lblPreco.setText("Preço");
        getContentPane().add(lblPreco);
        lblPreco.setBounds(20, 200, 50, 40);
        getContentPane().add(txtPreco);
        txtPreco.setBounds(80, 202, 200, 40);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(40, 270, 70, 40);

        btnExcluir.setText("Excluir");
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(150, 270, 80, 40);

        btnSalvarAlteracao.setText("Salvar alterações");
        getContentPane().add(btnSalvarAlteracao);
        btnSalvarAlteracao.setBounds(270, 270, 130, 40);

        setSize(new java.awt.Dimension(499, 365));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

          //1 - Verificar se o código está vazio        
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Código não pode estar vazio");
            txtCodigo.requestFocus();
            return; //stop no programa
        }
        //2 - Pegar as informações dos campos e jogar no obj produto
        Produto produto;
        produto = new Produto();
        produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
        produto.setNome(txtNome.getText());
        produto.setMarca(txtMarca.getText());
        produto.setPreco(Double.parseDouble(txtPreco.getText()));
       

        SistemaDao dao;
        dao = new SistemaDao();
        
        try {
           dao.salvarProduto(produto);
           JOptionPane.showMessageDialog(null,"Produto gravado com sucesso");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());            
        }


    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarAlteracao;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
