package view;


import dados.SistemaDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaUsuario extends javax.swing.JFrame {

    // construtor da classe, chamado pelo new lista usuarios
    public ListaUsuario() {
        initComponents();
        // carregamento da tabela (tblUsuarios)
        preencherTabela();
    }

    private void preencherTabela() {
        try {
            //Busca todos os usuários
            SistemaDao dao;
            dao = new SistemaDao();
            ResultSet resultado = dao.listarUsuarios();

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblUsuarios.getModel();
            // fazer até chegar no final da tebela (enquanto tiver proximo usuario)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("usuario"),
                    resultado.getString("senha"),
                    resultado.getString("nome"),
                    resultado.getString("cargo")
                };
                tblModelo.addRow(dados);
            }

            //4 - Desconectar do banco de dados
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
        tblUsuarios = new javax.swing.JTable();
        lblCargo = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox<>();

        setTitle("Relatorios de Usuarios");
        getContentPane().setLayout(null);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Senha", "Nome", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 510, 300);

        lblCargo.setText("Cargo");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(20, 20, 60, 40);

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ver Todos", "Gerente", "Analista", "Estagiário", "Vendendor", "Programador", "Segurança", "Professor", " " }));
        cmbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCargoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCargo);
        cmbCargo.setBounds(70, 20, 190, 40);

        setSize(new java.awt.Dimension(551, 448));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCargoActionPerformed
        //pega o cargo selecionado pelo usuario
        String c;
        c = cmbCargo.getSelectedItem().toString();
        if (c.equalsIgnoreCase("Ver Todos")) {
            preencherTabela();
            return; //stop
        }

        try {
            //Busca usuários por cargo
            SistemaDao dao;
            dao = new SistemaDao();
            ResultSet resultado = dao.buscarUsuarioPorCargo(c);

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblUsuarios.getModel();
            tblModelo.setRowCount(0);
            // fazer até chegar no final da tebela (enquanto tiver proximo usuario)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("usuario"),
                    resultado.getString("senha"),
                    resultado.getString("nome"),
                    resultado.getString("cargo")
                };
                tblModelo.addRow(dados);
            }

            //4 - Desconectar do banco de dados
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_cmbCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
