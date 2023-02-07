
package view;

import dados.SistemaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaProdutos extends javax.swing.JFrame {

    
    public ListaProdutos() {
        initComponents();
        carregaProdutos();
    }

    private void carregaProdutos(){
       //3 - Carregar os produtos selecionados na tblProdutos 
       SistemaDao dao;
       dao = new SistemaDao();
       
        try {
            ResultSet resultado = dao.buscarTodosProdutos();
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblProdutos.getModel();

           while (resultado.next()){
                Object dados[] =
                {
                    resultado.getInt("codigo"),
                    resultado.getString("nome"),
                    resultado.getString("marca"),
                    resultado.getDouble("preco")
                };
                tblModelo.addRow(dados);
            }
           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        lblProduto = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();

        setTitle("Lista de produtos");
        getContentPane().setLayout(null);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Marca", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 490, 280);

        lblProduto.setText("Nome do Produto");
        getContentPane().add(lblProduto);
        lblProduto.setBounds(40, 30, 110, 40);
        getContentPane().add(txtNomeProduto);
        txtNomeProduto.setBounds(170, 30, 130, 40);

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFiltrar);
        btnFiltrar.setBounds(330, 30, 120, 40);

        setSize(new java.awt.Dimension(569, 447));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String n;
        n = txtNomeProduto.getText();
        //3 - Carregar os produtos selecionados na tblProdutos 
       SistemaDao dao;
       dao = new SistemaDao();
       
        try {
            ResultSet resultado = dao.buscarProdutosPorNome(n);
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblProdutos.getModel();
            tblModelo.setRowCount(0); //limpar a tabela antes de carregar os dados
           while (resultado.next()){
                Object dados[] =
                {
                    resultado.getInt("codigo"),
                    resultado.getString("nome"),
                    resultado.getString("marca"),
                    resultado.getDouble("preco")
                };
                tblModelo.addRow(dados);
            }
           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtNomeProduto;
    // End of variables declaration//GEN-END:variables
}
