package dados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//para executar as operções CRUD (INSERT
public class SistemaDao {

    private Connection conectado; //guardar coneção
    private PreparedStatement st; // execulta comando SQL
    private ResultSet resultado; // buscar o select, fica na varia vel resultado
    
    private final String url = "jdbc:mysql://localhost:3306/sistemabd";
    private final String user = "root";
    private final String senha = "admin";

    //conectar com o banco de dados
    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectado = DriverManager.getConnection(url, user, senha);
    }

    //verificar se o usuario esta na tabela BD
    public ResultSet validarUsuario(String usuario, String senha) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM usuario WHERE usuario = ? AND senha = ?");
        st.setString(1, usuario);
        st.setString(2, senha);
        resultado = st.executeQuery();
        return resultado;
    }

    // Inserir usuario na tabela do BD
    public void salvarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        conectar();
        //4 - Inserir os dados digitados, na tabela do banco de dados.
        st = conectado.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?)");
        st.setString(1, usuario.getUsuario());
        st.setString(2, usuario.getSenha());
        st.setString(3, usuario.getNome());
        st.setString(4, usuario.getCargo());
        st.executeUpdate();

    }

    //Excluir usuário
    public void excluirUsuario(String u) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM usuario WHERE usuario = ?");
        st.setString(1, u);
        st.executeUpdate(); //INSERT, UPDATE, DELETE
    }

    //Buscar o Usuario
    public Usuario buscarUsuario(String u) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM usuario WHERE usuario = ?");
        st.setString(1, u);
        resultado = st.executeQuery();
        if(resultado.next()){
        Usuario usuario;
        usuario = new Usuario();
        usuario.setUsuario(resultado.getString("usuario"));
        usuario.setSenha(resultado.getString("senha"));
        usuario.setNome(resultado.getString("nome"));
        usuario.setCargo(resultado.getString("cargo"));
        return usuario;
        } else {
              return null;
        }
        
    }

    public void alterarUsuario(String s, String n, String c, String u) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE usuario SET senha = ?, nome = ?, cargo = ? WHERE usuario = ?");
        st.setString(1, s);
        st.setString(2, n);
        st.setString(3, c);
        st.setString(4, u);
        st.executeUpdate();
    }
      
   //Buscar todos os usuários
    public ResultSet listarUsuarios() throws ClassNotFoundException, SQLException{
        conectar();
        st = conectado.prepareStatement("SELECT * FROM usuario ORDER BY nome DESC");
        resultado = st.executeQuery();  
        return resultado;
    }
    
   //Buscar usuários po cargo
    public ResultSet buscarUsuarioPorCargo(String c) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM usuario WHERE cargo = ?");
        st.setString(1, c);
        resultado = st.executeQuery();
        return resultado;
    
    }
    
    // tabela produtos
    
    public void salvarProduto (Produto produto) throws ClassNotFoundException, SQLException{  
        // 3 - conectar nop BD
        conectar();
        
        //4 - enviar os dados pra tebela no BD  
        st = conectado.prepareStatement("INSERT INTO produto VALUES(?,?,?,?)");
       
        st.setInt(1, produto.getCodigo());  // o codigo é inteiro
        st.setString(2, produto.getNome()); // String
        st.setString(3, produto.getMarca());
        st.setDouble(4, produto.getPreco()); // quanto é double
        st.executeUpdate();
        
    }
    
    public ResultSet buscarTodosProdutos() throws ClassNotFoundException, SQLException{
        //1 - conectar com o BD
        conectar();     
       //2 - selecionar todos os produtos na tabela do BD
        st = conectado.prepareStatement(" SELECT * FROM produto");
        resultado = st.executeQuery();
        return resultado;  
    }
    
    public ResultSet buscarProdutosPorNome (String n) throws ClassNotFoundException, SQLException{
        //1 - conectar com o BD
        conectar();     
       //2 - selecionar todos os produtos na tabela do BD
        st = conectado.prepareStatement(" SELECT * FROM produto WHERE nome LIKE ?");
        st.setString(1, "%" + n + "%");
        resultado = st.executeQuery();
        return resultado;  
    }
    
    
    
}
