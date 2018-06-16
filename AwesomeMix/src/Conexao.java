import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	Connection conexao;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/";
    String bdNome = "awesomemix";
    String usuario = "root";
    String senha = "123456";

    public void conectar() {
        try {
            Class.forName(driver);
            System.out.println("Registro do driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //erro ao registrar
        }
        try {
            conexao = DriverManager.getConnection(url + bdNome+ "?useTimezone=true&serverTimezone=UTC&useSSL=false", usuario, senha);
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
