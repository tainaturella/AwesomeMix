import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection conexao;
    private final String driver;
    private final String url;
    private final String bancoNome;
    private final String usuario;
    private final String senha;

    public Conexao() {
    	conexao = null;
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://127.0.0.1:3306/";
        bancoNome = "awesomemix";
        usuario = "root";
        senha = "12345678";
    }
    
    public Connection getConexao() {
		return conexao;
	}
    
	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}
	
	public String getBancoNome() {
		return bancoNome;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public boolean conectar() {
        try {
            Class.forName(driver);
            System.out.println("Registro do driver!");
            conexao = DriverManager.getConnection(url + bancoNome+ "?useTimezone=true&serverTimezone=UTC&useSSL=false", usuario, senha);
            System.out.println("Conexao estabelecida!");
            return true;
        } catch (ClassNotFoundException exClass) { //erro ao registrar o driver
        	System.err.println("\nExcecao no Registro do Driver: "+exClass);
        	exClass.getMessage();
            exClass.printStackTrace(); 
            return false;
        } catch (SQLException exSQL) { //erro ao conectar ao banco de dados
        	System.err.println("\nExcecao na Conexao ao Banco: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        	return false;
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
        	return false;
        }
    }

    public boolean desconectar() {
        try {
            conexao.close();
            System.out.println("Desconectado!");
            return true;
        } catch (SQLException exSQL) { //erro ao desconectar do banco
        	System.err.println("\nExcecao na Desconexao ao Banco: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        	return false;
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
        	return false;
        }
    }
	
}
