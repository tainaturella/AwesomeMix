import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusicaPlayListPublicaDAO {

	private PreparedStatement pstmt; 
	private ResultSet resultado;
    
    public MusicaPlayListPublicaDAO() {
        pstmt = null; 
        resultado = null; 
    }

    //insere MusicaPlayListPublica no banco de dados
    //retorna o numero de registros inseridos
    public int inserirMusicaPlayListPublica(MusicaPlayListPublica playMusica)  {

        int resultado = 0; //numero de registros alterados com a insercao
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para insercao!");
        	return 0;
        }
        
        try {
            sql = "INSERT INTO playListPublicaMusica (idPlayListPublicaMusica, idPlayListPublica, idMusica"+
            	  ") VALUES (?,?,?)";
            pstmt = conector.getConexao().prepareStatement(sql);  
            pstmt.setInt(1, playMusica.getId()); 
            pstmt.setInt(2, playMusica.getPlayList().getId());
            pstmt.setInt(3, playMusica.getMusica().getId());
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
  
    //retorna todas as MusicaPlayListPublica da tabela
    //entra com o arraylist de playlistspublicas e musicas para relacionar
    public ArrayList<MusicaPlayListPublica> buscarMusicaPlayListPublica(ArrayList<PlayListPublica> publicas, ArrayList<Musica> musicas) {
    	
        ArrayList<MusicaPlayListPublica> musicaPlayLists = new ArrayList<MusicaPlayListPublica>();
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para busca!");
        	return null;
        }
        
        try {
            String sql = "SELECT idPlayListPublicaMusica, idPlayListPublica, idMusica FROM playListPublicaMusica";
            pstmt = conector.getConexao().prepareStatement(sql);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
            	MusicaPlayListPublica musicaPlay = new MusicaPlayListPublica();
            	musicaPlay.setId(resultado.getInt(1)); 
            	
            	//procura a playlist publica na lista de publicas
            	int idPublica = resultado.getInt(2);
            	for(int i = 0; i < publicas.size(); i++) {
            		if(publicas.get(i).getId() == idPublica) {
            			musicaPlay.setPlayList(publicas.get(i));
            			break;
            		}
            	}
            	
            	//procura a musica na lista de musicas
            	int idMusica = resultado.getInt(3);
            	for(int i = 0; i < musicas.size(); i++) {
            		if(musicas.get(i).getId() == idMusica) {
            			musicaPlay.setMusica(musicas.get(i));
            			break;
            		}
            	}
            	
            	musicaPlayLists.add(musicaPlay);         	
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

        return musicaPlayLists;
    } 
    
    //apaga todas as relacoes do banco de dados
    public int apagarMusicaPlayListPublica() {

        int resultado = 0;
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para exclusao!");
        	return 0;
        }
        
        try { 
            sql = "DELETE FROM playListPublicaMusica";
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
    /*public ArrayList<PlayListPrivada> buscarPlayListPrivadaIdUsuario(int idUsuario, ArrayList<Usuario> usuarios) {

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
    }
    
    public int apagarMusicaPlayListPublicaId(int idMusicaPlayList) {

        int resultado = 0;
        String sql;
        Conexao conector = new Conexao();
        
        if(conector.conectar() == false) {
        	System.out.println("Sem conexao para exclusao!");
        	return 0;
        }
        
        try { 
            sql = "DELETE FROM playListPublicaMusica WHERE idPlayListPublicaMusica="+idMusicaPlayList;
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
