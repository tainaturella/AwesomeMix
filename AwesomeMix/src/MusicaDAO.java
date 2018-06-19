import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusicaDAO {
	
	private PreparedStatement pstmt; 
	private ResultSet resultado;
    
    public MusicaDAO() {
        pstmt = null; 
        resultado = null; 
    }
    
    public int inserirMusica(Musica musica)  {

        int resultado = 0; //numero de registros alterados com a insercao
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para insercao!");
        	return 0;
        }
        
        try {
            sql = "INSERT INTO musica (idMusica, nomeMusica, tempoDuracaoMusica, avaliacaoMusica,"+
            	  " idAlbum) VALUES (?,?,?,?,?)";
            pstmt = conector.getConexao().prepareStatement(sql);  
            pstmt.setInt(1, musica.getId()); 
            pstmt.setString(2, musica.getNomeMusica());
            pstmt.setDouble(3, musica.getTempoDuracao());
            pstmt.setDouble(4, musica.getAvaliacaoMusica());
            pstmt.setInt(5,  musica.getAlbum().getId());
            resultado = pstmt.executeUpdate(); 
        } catch (SQLException exSQL) { //erro ao inserir no banco
        	System.err.println("\nExcecao na Insercao: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
		} finally {
        	try {
        		if (pstmt != null) pstmt.close();
        	} catch (SQLException exSQL) { //erro ao fechar statement
            	System.err.println("\nExcecao no fechamento do Statement: "+exSQL);
            	exSQL.getMessage();
            	exSQL.printStackTrace();
        	} catch (Exception ex) { //erro generico
            	System.err.println("\nExcecao: "+ex);
            	ex.getMessage();
            	ex.printStackTrace();
        	}
        	conector.desconectar();
        }
		
        return resultado;
    }
  
    //retorna todos os usuarios do banco de dados
    public ArrayList<Usuario> buscarUsuarios() {
    	
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idUsuario, nomeUsuario, idadeUsuario,"
            		+ " loginUsuario, senhaUsuario FROM usuario";
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	Usuario usuario = new Usuario();
            	usuario.setId(resultado.getInt(1)); 
            	usuario.setNome(resultado.getString(2));
            	usuario.setIdade(resultado.getInt(3));
            	usuario.setLogin(resultado.getString(4));
            	usuario.setSenha(resultado.getString(5));
            	usuarios.add(usuario);         	
            }
        } catch (SQLException exSQL) { //erro ao buscar no banco
        	System.err.println("\nExcecao na Busca: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
		} finally {
        	try {
        		if (pstmt != null) pstmt.close();
        	} catch (SQLException exSQL) { //erro ao fechar statement
            	System.err.println("\nExcecao no fechamento do Statement: "+exSQL);
            	exSQL.getMessage();
            	exSQL.printStackTrace();
        	} catch (Exception ex) { //erro generico
            	System.err.println("\nExcecao: "+ex);
            	ex.getMessage();
            	ex.printStackTrace();
        	}
        	conector.desconectar();
        }

        return usuarios;
    } 
    
    public ArrayList<Usuario> buscarUsuarioId(int idUsuario) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idUsuario, nomeUsuario, idadeUsuario,"
            		+ "loginUsuario, senhaUsuario FROM usuario WHERE idUsuario="+idUsuario;
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	Usuario usuario = new Usuario();
            	usuario.setId(resultado.getInt(1)); 
            	usuario.setNome(resultado.getString(2));
            	usuario.setIdade(resultado.getInt(3));
            	usuario.setLogin(resultado.getString(4));
            	usuario.setSenha(resultado.getString(5));
            	usuarios.add(usuario);
            }

        } catch (SQLException exSQL) { //erro ao buscar no banco
        	System.err.println("\nExcecao na Busca: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
		} finally {
        	try {
        		if (pstmt != null) pstmt.close();
        	} catch (SQLException exSQL) { //erro ao fechar statement
            	System.err.println("\nExcecao no fechamento do Statement: "+exSQL);
            	exSQL.getMessage();
            	exSQL.printStackTrace();
        	} catch (Exception ex) { //erro generico
            	System.err.println("\nExcecao: "+ex);
            	ex.getMessage();
            	ex.printStackTrace();
        	}
        	conector.desconectar();
        }

        return usuarios;

    }
    
    public ArrayList<Usuario> buscarUsuarioLogin(String login) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idUsuario, nomeUsuario, idadeUsuario,"
            		+ "loginUsuario, senhaUsuario FROM usuario WHERE loginUsuario='"+login+"'";
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	Usuario usuario = new Usuario();
            	usuario.setId(resultado.getInt(1)); 
            	usuario.setNome(resultado.getString(2));
            	usuario.setIdade(resultado.getInt(3));
            	usuario.setLogin(resultado.getString(4));
            	usuario.setSenha(resultado.getString(5));
            	usuarios.add(usuario);            	
            }

        } catch (SQLException exSQL) { //erro ao buscar no banco
        	System.err.println("\nExcecao na Busca: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
		} finally {
        	try {
        		if (pstmt != null) pstmt.close();
        	} catch (SQLException exSQL) { //erro ao fechar statement
            	System.err.println("\nExcecao no fechamento do Statement: "+exSQL);
            	exSQL.getMessage();
            	exSQL.printStackTrace();
        	} catch (Exception ex) { //erro generico
            	System.err.println("\nExcecao: "+ex);
            	ex.getMessage();
            	ex.printStackTrace();
        	}
        	conector.desconectar();
        }

        return usuarios;

    }
    
    //alterar tudo menos o atributo id
    public int alterarUsuarioId(int idUsuario, Usuario novoUsuario)  {
   
    	String sql;
    	int resultado = 0; //retorna qtd de registros alterados no banco
    	Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para alteracao!");
        	return 0;
        }
        
        try { 
            sql = "UPDATE usuario SET "
            		+ "nomeUsuario = ?, idadeUsuario = ?, loginUsuario = ?, "
            		+ "senhaUsuario = ? WHERE idUsuario = "+idUsuario;
            pstmt = conector.getConexao().prepareStatement(sql); 
            pstmt.setString(1, novoUsuario.getNome()); 
            pstmt.setInt(2, novoUsuario.getIdade());
            pstmt.setString(3, novoUsuario.getLogin());
            pstmt.setString(4, novoUsuario.getSenha());
            resultado = pstmt.executeUpdate(); 
            
        } catch (SQLException exSQL) { //erro ao buscar no banco
        	System.err.println("\nExcecao na Alteracao: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
		} finally {
        	try {
        		if (pstmt != null) pstmt.close();
        	} catch (SQLException exSQL) { //erro ao fechar statement
            	System.err.println("\nExcecao no fechamento do Statement: "+exSQL);
            	exSQL.getMessage();
            	exSQL.printStackTrace();
        	} catch (Exception ex) { //erro generico
            	System.err.println("\nExcecao: "+ex);
            	ex.getMessage();
            	ex.printStackTrace();
        	}
        	conector.desconectar();
        }
		
        return resultado;
    }
    
    public int apagarUsuarioId(int idUsuario) {

        int resultado = 0;
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para exclusao!");
        	return 0;
        }
        
        try { 
            sql = "DELETE FROM usuario WHERE idUsuario="+idUsuario;
            pstmt = conector.getConexao().prepareStatement(sql);  
            resultado = pstmt.executeUpdate(); 
        } catch (SQLException exSQL) { //erro ao excluir do banco
        	System.err.println("\nExcecao na Exclusao: "+exSQL);
        	exSQL.getMessage();
        	exSQL.printStackTrace();
        } catch (Exception ex) { //erro generico
        	System.err.println("\nExcecao: "+ex);
        	ex.getMessage();
        	ex.printStackTrace();
		} finally {
        	try {
        		if (pstmt != null) pstmt.close();
        	} catch (SQLException exSQL) { //erro ao fechar statement
            	System.err.println("\nExcecao no fechamento do Statement: "+exSQL);
            	exSQL.getMessage();
            	exSQL.printStackTrace();
        	} catch (Exception ex) { //erro generico
            	System.err.println("\nExcecao: "+ex);
            	ex.getMessage();
            	ex.printStackTrace();
        	}
        	conector.desconectar();
        }
		
        return resultado;
    }
}
