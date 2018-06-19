import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioPlayListDAO {

	private PreparedStatement pstmt; 
	private ResultSet resultado;
    
    public UsuarioPlayListDAO() {
        pstmt = null; 
        resultado = null; 
    }
    
    public int inserirUsuarioPlayList(UsuarioPlayList usuarioPlayList)  {

        int resultado = 0; //numero de registros alterados com a insercao
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para insercao!");
        	return 0;
        }
        
        try {
            sql = "INSERT INTO usuarioPlayList (idUsuarioPlayList, idUsuario, idPlayList) VALUES (?,?,?)";
            pstmt = conector.getConexao().prepareStatement(sql);  
            pstmt.setInt(1, usuarioPlayList.getId()); 
            pstmt.setInt(2, usuarioPlayList.getUsuario().getId());
            pstmt.setInt(3, usuarioPlayList.getPlayList().getId());
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
  
    //retorna todos os albuns
    /*public ArrayList<Album> buscarAlbuns() {
    	
        ArrayList<Album> albuns = new ArrayList<Album>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idAlbum, nomeAlbum, artistaAlbum,"
            		+ " anoLancamentoAlbum, qtdMusicas, avaliacaoAlbum, estiloMusicalAlbum FROM album";
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	Album album = new Album();
            	album.setId(resultado.getInt(1)); 
            	album.setNomeAlbum(resultado.getString(2));
            	album.setArtista(resultado.getString(3));
            	album.setAnoLancamento(resultado.getInt(4));
            	album.setQtdMusicas(resultado.getInt(5));
            	album.setAvaliacaoAlbum(resultado.getDouble(6));
            	album.setEstiloMusical(EstilosMusicais.values()[resultado.getInt(7)]);
            	albuns.add(album);         	
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
 
    //retorna playList pelo idUsuario
    /*
    public ArrayList<PlayList> buscarPlayListUsuario(int idUsuario) {

        ArrayList<PlayList> playLists = new ArrayList<PlayList>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idPlayList FROM usuarioPlayList WHERE idUsuario="+idUsuario;
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	PlayList playList = new PlayList();
            	playList.setId(resultado.getInt(1)); 
            	
            	//procurar a playList que tem esse id na tabela de playlists e adiciona pro arraylist
            	usuarioPlayList.setUsuario(resultado.getString(2));
            	usuarioPlayList.setPlayList(resultado.getString(3));
            	usuarioPlayLists.add(usuarioPlayList);     
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
    
    public ArrayList<Album> buscarAlbumArtista(String artista) {

        ArrayList<Album> albuns = new ArrayList<Album>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idAlbum, nomeAlbum, artistaAlbum,"
            		+ " anoLancamentoAlbum, qtdMusicas, avaliacaoAlbum, estiloMusicalAlbum FROM album WHERE artistaAlbum='"+artista+"'";
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	Album album = new Album();
            	album.setId(resultado.getInt(1)); 
            	album.setNomeAlbum(resultado.getString(2));
            	album.setArtista(resultado.getString(3));
            	album.setAnoLancamento(resultado.getInt(4));
            	album.setQtdMusicas(resultado.getInt(5));
            	album.setAvaliacaoAlbum(resultado.getDouble(6));
            	album.setEstiloMusical(EstilosMusicais.values()[resultado.getInt(7)]);
            	albuns.add(album);               	
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
    
    //alterar tudo menos o atributo id
    public int alterarAlbumId(int idAlbum, Album novoAlbum)  {
   
    	String sql;
    	int resultado = 0; //retorna qtd de registros alterados no banco
    	Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para alteracao!");
        	return 0;
        }
        
        try { 
            sql = "UPDATE album SET "
            		+ "nomeAlbum = ?, artistaAlbum = ?, anoLancamentoAlbum = ?, "
            		+ "qtdMusicas = ?, avaliacaoAlbum = ?, estiloMusicalAlbum = ? WHERE idAlbum = "+idAlbum;
            pstmt = conector.getConexao().prepareStatement(sql); 
            pstmt.setString(1, novoAlbum.getNomeAlbum()); 
            pstmt.setString(2, novoAlbum.getArtista());
            pstmt.setInt(3, novoAlbum.getAnoLancamento());
            pstmt.setInt(4, novoAlbum.getQtdMusicas());
            pstmt.setDouble(5, novoAlbum.getAvaliacaoAlbum());
            pstmt.setInt(6, novoAlbum.getEstiloMusical().ordinal());
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
    
    public int apagarAlbumId(int idAlbum) {

        int resultado = 0;
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para exclusao!");
        	return 0;
        }
        
        try { 
            sql = "DELETE FROM album WHERE idAlbum="+idAlbum;
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
    }*/
}