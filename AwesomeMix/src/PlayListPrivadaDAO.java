import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayListPrivadaDAO {

	private PreparedStatement pstmt; 
	private ResultSet resultado;
    
    public PlayListPrivadaDAO() {
        pstmt = null; 
        resultado = null; 
    }
    
    public int inserirPlayListPrivada(PlayListPrivada playList)  {

        int resultado = 0; //numero de registros alterados com a insercao
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para insercao!");
        	return 0;
        }
        
        try {
            sql = "INSERT INTO playListPrivada (idPlayListPrivada, nomePlayListPrivada, qtdMusicasPlayListPrivada,"+
            	  " idUsuario) VALUES (?,?,?,?)";
            pstmt = conector.getConexao().prepareStatement(sql);  
            pstmt.setInt(1, playList.getId()); 
            pstmt.setString(2, playList.getNome());
            pstmt.setInt(3, playList.getQuantidadeMusicas());
            pstmt.setInt(4, playList.getDono().getId());
            System.out.println("foi");
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
  
    //retorna todos as playlists
    /*
    public ArrayList<PlayList> buscarPlayLists() {
    	
        ArrayList<PlayList> playLists = new ArrayList<PlayList>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idPlayList, nomePlayList, qtdMusicasPlayList, tipoPlayList FROM playList";
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	PlayList playList = new PlayList();
            	playList.setId(resultado.getInt(1)); 
            	playList.setNomeAlbum(resultado.getString(2));
            	playList.setArtista(resultado.getString(3));
            	playList.setAnoLancamento(resultado.getInt(4));
            	playList.setQtdMusicas(resultado.getInt(5));
            	playList.setAvaliacaoAlbum(resultado.getDouble(6));
            	playList.setEstiloMusical(EstilosMusicais.values()[resultado.getInt(7)]);
            	playLists.add(playList);         	
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

        return albuns;
    } 
    */
 
    //retorna todas as playlists publicas
    /*public ArrayList<PlayListPublica> buscarPlayListPublica() {

        ArrayList<PlayListPublica> playLists = new ArrayList<PlayListPublica>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idPlayList, nomePlayList, qtdMusicasPlayList FROM playListPublica";
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	PlayListPublica playList = new PlayListPublica();
            	playList.setId(resultado.getInt(1)); 
            	playList.setNome(resultado.getString(2));
            	playList.setQuantidadeMusicas(resultado.getInt(3));
            	playLists.add(playList);     
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

        return playLists;

    }*/
    
    //retorna todas as playlists privadas
    /*public ArrayList<PlayList> buscarPlayListPrivada() {

        ArrayList<PlayList> playLists = new ArrayList<PlayList>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idPlayList, nomePlayList, qtdMusicasPlayList, tipoPlayList FROM playList WHERE tipoPlayList="+2;
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	PlayList playList = new PlayListPrivada();
            	playList.setId(resultado.getInt(1)); 
            	playList.setNome(resultado.getString(2));
            	playList.setQuantidadeMusicas(resultado.getInt(3));
            	playLists.add(playList);     
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

        return playLists;

    }*/
    
    //busca playlist pelo id do usuario
    public ArrayList<PlayListPrivada> buscarPlayListPrivadaIdUsuario(int idUsuario, ArrayList<Usuario> usuarios) {

        ArrayList<PlayListPrivada> playLists = new ArrayList<PlayListPrivada>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idPlayListPrivada, nomePlayListPrivada, qtdMusicasPlayListPrivada, idUsuario FROM playListPrivada WHERE idUsuario="+idUsuario;
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	PlayListPrivada playList = new PlayListPrivada();
            	playList.setId(resultado.getInt(1)); 
            	playList.setNome(resultado.getString(2));
            	playList.setQuantidadeMusicas(resultado.getInt(3));
            	
            	int idDono = resultado.getInt(4);
            	//procura o usuario na lista de usuarios
            	for(int i = 0; i < usuarios.size(); i++) {
            		if(usuarios.get(i).getId() == idDono) {
            			playList.setDono(usuarios.get(i));
            			break;
            		}
            	}
            	playLists.add(playList);     
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

        return playLists;

    }
    
    //altera somente o nome da playlist pelo id
    /*public int alterarPlayListId(int idPlayList, String novoNome)  {
   
    	String sql;
    	int resultado = 0; //retorna qtd de registros alterados no banco
    	Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para alteracao!");
        	return 0;
        }
        
        try { 
            sql = "UPDATE playList SET nomePlayList = ? WHERE idPlayList = "+idPlayList;
            pstmt = conector.getConexao().prepareStatement(sql); 
            pstmt.setString(1, novoNome); 
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
    }*/
    
    public int apagarPlayListPrivadaId(int idPlayList) {

        int resultado = 0;
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para exclusao!");
        	return 0;
        }
        
        try { 
            sql = "DELETE FROM playListPrivada WHERE idPlayListPrivada="+idPlayList;
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