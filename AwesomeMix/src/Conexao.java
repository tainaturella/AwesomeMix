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
        senha = "123456";
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

	public void conectar() {
        try {
            Class.forName(driver);
            System.out.println("Registro do driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //erro ao registrar
        }
        
        try {
            conexao = DriverManager.getConnection(url + bancoNome+ "?useTimezone=true&serverTimezone=UTC&useSSL=false", usuario, senha);
            System.out.println("Conexao foi!!!!!");
        } catch (SQLException se) {
        	se.printStackTrace();
            System.out.println("Erro na conexao!!!!!");
        }
    }

    public void desconectar() {
        try {
            conexao.close();
            System.out.println("Desconectou!!!");
        } catch (SQLException se) {
            System.out.println("Erro ao desconetar");
        }
    }
	
}
