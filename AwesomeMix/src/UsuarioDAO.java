import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	private PreparedStatement pstmt; 
	private ResultSet resultado;
    
    public UsuarioDAO() {
        pstmt = null; 
        resultado = null; 
    }
    
    public int inserirUsuario(Usuario usuario)  {

        int resultado = 0; //numero de registros alterados
        String sql;
        Conexao conector = new Conexao();
        
        try {
        	conector.conectar();
            sql = "INSERT INTO usuario (idUsuario, nomeUsuario, idadeUsuario, loginUsuario,"+
            	  " senhaUsuario) VALUES (?,?,?,?,?)";
            pstmt = conector.getConexao().prepareStatement(sql);  
            pstmt.setInt(1, usuario.getId()); 
            pstmt.setString(2, usuario.getNome());
            pstmt.setInt(3, usuario.getIdade());
            pstmt.setString(4, usuario.getLogin());
            pstmt.setString(5, usuario.getSenha());
            resultado = pstmt.executeUpdate(); 
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
        	try{
        		if (pstmt != null) pstmt.close();
        	}catch (SQLException se){
        		System.out.print("Erro Statement - SQLException que ocorreu: \n" + se );
        	}
            
        	if (conector.getConexao() != null) conector.desconectar();
	    	
        }
		
        return resultado;
	
    }
    /*
    public ArrayList<Usuario> buscarUsuarios() {
    	
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            connection = Conexao.getConnection();
            String sql = "SELECT id_usuario, nome_usuario, email_usuario,"
            		+ "senha_usuario, telefone_usuario, celular_usuario,"
            		+ "ativo_usuario, habilitado_usuario, confirmacao_usuario, "
            		+ "data_acesso_usuario, admin_usuario FROM usuario";
            pstmt = connection.prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	
            	Usuario usuario = new Usuario();
            	usuario.setIdUsuario(resultado.getInt(1)); 
            	usuario.setNomeUsuario(resultado.getString(2));
            	usuario.setEmailUsuario(resultado.getString(3));
            	usuario.setSenhaUsuario(resultado.getString(4));
            	usuario.setTelefoneUsuario(resultado.getString(5));
            	usuario.setCelularUsuario(resultado.getString(6));
            	usuario.setAtivoUsuario(resultado.getBoolean(7));
            	usuario.setHabilitadoUsuario(resultado.getBoolean(8));
            	usuario.setConfirmacaoUsuario(resultado.getString(9));
            	
            	Calendar calendario = Calendar.getInstance();
                calendario.setTime(resultado.getDate(10));   
                usuario.setDataAcessoUsuario(calendario.getTime());
            	
                usuario.setAdminUsuario(resultado.getBoolean(11));
                
            	usuarios.add(usuario);
            	
            }

        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			
        } finally {
            
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Statement - SQLException que ocorreu: \n" + se);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Connection - SQLException que ocorreu: \n" + se);
            }
            
        }

        return usuarios;

    } 
    
    
    public ArrayList<Usuario> buscarUsuarioId(int idUsuario) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            connection = Conexao.getConnection();
            String sql = "SELECT id_usuario, nome_usuario, email_usuario,"
            		+ "senha_usuario, telefone_usuario, celular_usuario,"
            		+ "ativo_usuario, habilitado_usuario, confirmacao_usuario, "
            		+ "data_acesso_usuario, admin_usuario FROM usuario WHERE id_usuario="+idUsuario;
            pstmt = connection.prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	
            	Usuario usuario = new Usuario();
            	usuario.setIdUsuario(resultado.getInt(1)); 
            	usuario.setNomeUsuario(resultado.getString(2));
            	usuario.setEmailUsuario(resultado.getString(3));
            	usuario.setSenhaUsuario(resultado.getString(4));
            	usuario.setTelefoneUsuario(resultado.getString(5));
            	usuario.setCelularUsuario(resultado.getString(6));
            	usuario.setAtivoUsuario(resultado.getBoolean(7));
            	usuario.setHabilitadoUsuario(resultado.getBoolean(8));
            	usuario.setConfirmacaoUsuario(resultado.getString(9));
            	
            	Calendar calendario = Calendar.getInstance();
                calendario.setTime(resultado.getDate(10));   
                usuario.setDataAcessoUsuario(calendario.getTime());
            	
                usuario.setAdminUsuario(resultado.getBoolean(11));
                
            	usuarios.add(usuario);
            	
            }

        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			
        } finally {
            
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Statement - SQLException que ocorreu: \n" + se);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Connection - SQLException que ocorreu: \n" + se);
            }
            
        }

        return usuarios;

    }
    
    public ArrayList<Usuario> buscarUsuarioEmail(String emailUsuario) {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            connection = Conexao.getConnection();
            String sql = "SELECT id_usuario, nome_usuario, email_usuario,"
            		+ "senha_usuario, telefone_usuario, celular_usuario,"
            		+ "ativo_usuario, habilitado_usuario, confirmacao_usuario, "
            		+ "data_acesso_usuario, admin_usuario FROM usuario WHERE email_usuario='"+emailUsuario+"'";
            pstmt = connection.prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	
            	Usuario usuario = new Usuario();
            	usuario.setIdUsuario(resultado.getInt(1)); 
            	usuario.setNomeUsuario(resultado.getString(2));
            	usuario.setEmailUsuario(resultado.getString(3));
            	usuario.setSenhaUsuario(resultado.getString(4));
            	usuario.setTelefoneUsuario(resultado.getString(5));
            	usuario.setCelularUsuario(resultado.getString(6));
            	usuario.setAtivoUsuario(resultado.getBoolean(7));
            	usuario.setHabilitadoUsuario(resultado.getBoolean(8));
            	usuario.setConfirmacaoUsuario(resultado.getString(9));
            	
            	Calendar calendario = Calendar.getInstance();
                calendario.setTime(resultado.getDate(10));   
                usuario.setDataAcessoUsuario(calendario.getTime());
            	
                usuario.setAdminUsuario(resultado.getBoolean(11));
                
            	usuarios.add(usuario);
            	
            }

        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			
        } finally {
            
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Statement - SQLException que ocorreu: \n" + se);
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Connection - SQLException que ocorreu: \n" + se);
            }
            
        }

        return usuarios;

    }
    
    //alterar tudo menos o atributo ativo, id e data
    public int alterarUsuarioId(int idUsuario, Usuario usuario)  {
        
    	String sql;
    	int resultado = 0;
   
        try {
            
            connection = Conexao.getConnection();  
            sql = "UPDATE usuario SET "
            		+ "nome_usuario = ?, email_usuario = ?, senha_usuario = ?, "
            		+ "celular_usuario = ?, telefone_usuario = ?, habilitado_usuario = ?, "
            		+ "confirmacao_usuario = ? WHERE id_usuario = "+idUsuario;
            pstmt = connection.prepareStatement(sql); 
            pstmt.setString(1, usuario.getNomeUsuario()); 
            pstmt.setString(2, usuario.getEmailUsuario());
            pstmt.setString(3, usuario.getSenhaUsuario());
            pstmt.setString(4, usuario.getCelularUsuario());
            pstmt.setString(5, usuario.getTelefoneUsuario());
            pstmt.setBoolean(6, usuario.isHabilitadoUsuario());
            pstmt.setString(7, usuario.getConfirmacaoUsuario());
            resultado = pstmt.executeUpdate(); 
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
        
		} finally {
            
        	try{
        		if( pstmt != null ){
        			pstmt.close(); 
        		}
        	}catch (SQLException se){
        		System.out.print("Erro Statement SQLException que ocorreu: \n" + se );
        	}
            
        	try{
        		if( connection != null ) {
        			connection.close();
        		}
        	}catch (SQLException se) {
        		System.out.print("Erro Connection SQLException que ocorreu: \n" + se );
        	}
	    	
        }
		
        return resultado;
	
    }
    
    //parâmetros: atributo id do usuario e o ativo a ser inserido
    public int alterarUsuarioAtivoId(int idUsuario, boolean ativoUsuario)  {
        
    	String sql;
    	int resultado = 0;
   
        try {
            
            connection = Conexao.getConnection();   
            sql = "UPDATE usuario SET ativo_usuario = ? WHERE id_usuario = "+idUsuario;
            pstmt = connection.prepareStatement(sql);  
            pstmt.setBoolean(1, ativoUsuario); 
            resultado = pstmt.executeUpdate(); 
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
        
		} finally {
            
        	try{
        		if( pstmt != null ){
        			pstmt.close(); 
        		}
        	}catch (SQLException se){
        		System.out.print("Erro Statement SQLException que ocorreu: \n" + se );
        	}
            
        	try{
        		if( connection != null ) {
        			connection.close();
        		}
        	}catch (SQLException se) {
        		System.out.print("Erro Connection SQLException que ocorreu: \n" + se );
        	}
	    	
        }
		
        return resultado;
	
    }
    
    //parâmetros: atributo id do usuario e a data a ser inserida
    public int alterarUsuarioDataAcessoId(int idUsuario, Date dataAcessoUsuario)  {
        
    	String sql;
    	int resultado = 0;
   
        try {
            
            connection = Conexao.getConnection();   
            sql = "UPDATE usuario SET data_acesso_usuario = ? WHERE id_usuario = "+idUsuario;
            pstmt = connection.prepareStatement(sql);  
            pstmt.setDate(1, new java.sql.Date(dataAcessoUsuario.getTime()));
            resultado = pstmt.executeUpdate(); 
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
        
		} finally {
            
        	try{
        		if( pstmt != null ){
        			pstmt.close(); 
        		}
        	}catch (SQLException se){
        		System.out.print("Erro Statement SQLException que ocorreu: \n" + se );
        	}
            
        	try{
        		if( connection != null ) {
        			connection.close();
        		}
        	}catch (SQLException se) {
        		System.out.print("Erro Connection SQLException que ocorreu: \n" + se );
        	}
	    	
        }
		
        return resultado;
	
    }
    
  
    public int alterarUsuarioHabilitadoId(int idUsuario, boolean habilitadoUsuario)  {
        
    	String sql;
    	int resultado = 0;
   
        try {
            
            connection = Conexao.getConnection();   
            sql = "UPDATE usuario SET habilitado_usuario = ? WHERE id_usuario = "+idUsuario;
            pstmt = connection.prepareStatement(sql);  
            pstmt.setBoolean(1, habilitadoUsuario); 
            resultado = pstmt.executeUpdate(); 
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
        
		} finally {
            
        	try{
        		if( pstmt != null ){
        			pstmt.close(); 
        		}
        	}catch (SQLException se){
        		System.out.print("Erro Statement SQLException que ocorreu: \n" + se );
        	}
            
        	try{
        		if( connection != null ) {
        			connection.close();
        		}
        	}catch (SQLException se) {
        		System.out.print("Erro Connection SQLException que ocorreu: \n" + se );
        	}
	    	
        }
		
        return resultado;
	
    }
    
    
    //parâmetros: atributo id do usuario e a String confirmação a ser inserido
    public int alterarUsuarioConfirmacaoId(int idUsuario, String confirmacaoUsuario)  {
        
    	String sql;
    	int resultado = 0;
   
        try {
            
            connection = Conexao.getConnection();   
            sql = "UPDATE usuario SET confirmacao_usuario = ? WHERE id_usuario = '"+idUsuario;
            pstmt = connection.prepareStatement(sql);  
            pstmt.setString(1, confirmacaoUsuario); 
            resultado = pstmt.executeUpdate(); 
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
        
		} finally {
            
        	try{
        		if( pstmt != null ){
        			pstmt.close(); 
        		}
        	}catch (SQLException se){
        		System.out.print("Erro Statement SQLException que ocorreu: \n" + se );
        	}
            
        	try{
        		if( connection != null ) {
        			connection.close();
        		}
        	}catch (SQLException se) {
        		System.out.print("Erro Connection SQLException que ocorreu: \n" + se );
        	}
	    	
        }
		
        return resultado;
	
    }
    
    public int apagarUsuarioId(int idUsuario)  {

        int resultado = 0;
        String sql;
        
        try {
            
            connection = Conexao.getConnection();   
            sql = "DELETE FROM usuario WHERE id_usuario="+idUsuario;
            pstmt = connection.prepareStatement(sql);  
            resultado = pstmt.executeUpdate(); 
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
        
		} finally {
            
        	try{
        		if( pstmt != null ){
        			pstmt.close(); 
        		}
        	}catch (SQLException se){
        		System.out.print("Erro Statement SQLException que ocorreu: \n" + se );
        	}
            
        	try{
        		if( connection != null ) {
        			connection.close();
        		}
        	}catch (SQLException se) {
        		System.out.print("Erro Connection SQLException que ocorreu: \n" + se );
        	}
	    	
        }
		
        return resultado;
	
    }*/
}
