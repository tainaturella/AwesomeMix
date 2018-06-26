import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		//1459187676
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ RETIRANDO DO BANCO @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

		// ************************** USUARIOS ******************************

		UsuarioDAO usuarioDAO = new UsuarioDAO();		
		ArrayList<Usuario> usus = usuarioDAO.buscarUsuarios();

		for(int i = 0; i < usus.size(); i++) 
			BaseDeDados.shared.usuarios.add(usus.get(i));

		// ************************** ALBUM **********************************

		AlbumDAO albumDAO = new AlbumDAO();
		ArrayList<Album> albuns = albumDAO.buscarAlbuns();

		for(int i = 0; i < albuns.size(); i++) 
			BaseDeDados.shared.albuns.add(albuns.get(i));

		// ***************************** MUSICAS *****************************

		MusicaDAO musicaDAO = new MusicaDAO();
		ArrayList<Musica> musicas = musicaDAO.buscarMusicas(BaseDeDados.shared.albuns);

		for(int i = 0; i < musicas.size(); i++) {
			musicas.get(i).getAlbum().adicionarMusica(musicas.get(i));
			BaseDeDados.shared.musicas.add(musicas.get(i));
		}

		// ***************************** PLAYLISTS PUBLICAS *******************

		PlayListPublicaDAO playPublicaDAO = new PlayListPublicaDAO();
		ArrayList<PlayListPublica> playsPublica = playPublicaDAO.buscarPlayListsPublicas();	

		for(int i = 0; i < playsPublica.size(); i++) 
			BaseDeDados.shared.playListsPublicas.add(playsPublica.get(i));

		// **************************** PLAYLISTS PRIVADAS ********************

		PlayListPrivadaDAO playPrivadaDAO = new PlayListPrivadaDAO();
		ArrayList<PlayListPrivada> playsPrivadas = playPrivadaDAO.buscarPlayListPrivada(BaseDeDados.shared.usuarios);		

		for(int i = 0; i < playsPrivadas.size(); i++) {
			playsPrivadas.get(i).getDono().getPlayListsPrivadas().add(playsPrivadas.get(i));
			BaseDeDados.shared.playListsPrivadas.add(playsPrivadas.get(i));
		}

		// *************************** ASSOCIATIVOS *****************************

		UsuarioMusicaDAO usuarioMusicaDAO = new UsuarioMusicaDAO();
		ArrayList<UsuarioMusica> ususMusica = usuarioMusicaDAO.buscarUsuarioMusica(BaseDeDados.shared.usuarios, BaseDeDados.shared.musicas);		

		for(int i = 0; i < ususMusica.size(); i++) {
			ususMusica.get(i).getUsuario().getMusicasAvaliadas().add(ususMusica.get(i));
			BaseDeDados.shared.usuariosMusica.add(ususMusica.get(i));
		}

		UsuarioPlayListPublicaDAO usuPlayPublicaDAO = new UsuarioPlayListPublicaDAO();
		ArrayList<UsuarioPlayListPublica> usuPlayPublica = usuPlayPublicaDAO.buscarUsuarioPlayListPublica(BaseDeDados.shared.playListsPublicas, BaseDeDados.shared.usuarios);	

		for(int i = 0; i < usuPlayPublica.size(); i++) {
			usuPlayPublica.get(i).getUsuario().getPlayListsPublicas().add(usuPlayPublica.get(i));
			BaseDeDados.shared.usuariosPlayListPublicas.add(usuPlayPublica.get(i));
		}


		MusicaPlayListPrivadaDAO musicaPlayPrivadaDAO = new MusicaPlayListPrivadaDAO();
		ArrayList<MusicaPlayListPrivada> musicasPlayPrivada = musicaPlayPrivadaDAO.buscarMusicaPlayListPrivada(BaseDeDados.shared.playListsPrivadas, BaseDeDados.shared.musicas);	

		for(int i = 0; i < musicasPlayPrivada.size(); i++) {
			musicasPlayPrivada.get(i).getPlayList().adicionarMusica(musicasPlayPrivada.get(i).getMusica());
			BaseDeDados.shared.musicasPlayListPrivada.add(musicasPlayPrivada.get(i));
		}


		MusicaPlayListPublicaDAO musicaPlayPublicaDAO = new MusicaPlayListPublicaDAO();
		ArrayList<MusicaPlayListPublica> musicasPlayPublica = musicaPlayPublicaDAO.buscarMusicaPlayListPublica(BaseDeDados.shared.playListsPublicas, BaseDeDados.shared.musicas);

		for(int i = 0; i < musicasPlayPublica.size(); i++) {
			musicasPlayPublica.get(i).getPlayList().adicionarMusica(musicasPlayPublica.get(i).getMusica());
			BaseDeDados.shared.musicasPlayListPublica.add(musicasPlayPublica.get(i));
		}


		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@ CRIACAO NA MEMORIA @@@@@@@@@@@@@@@@@@@@@@@@

		//*********************** USUARIOS ****************************
		/*
		Usuario usuarioA = new Usuario("Peter Quill", 31, "starlord@galaxy.com", "pass");
		Usuario usuarioB = new Usuario("Groot", 100, "iamgroot@galaxy.com", "iamgroot");
		Usuario usuarioC = new Usuario("Gamora", 30, "gamora@galaxy.com", "green");

		BaseDeDados.shared.usuarios.add(usuarioA);
		BaseDeDados.shared.usuarios.add(usuarioB);
		BaseDeDados.shared.usuarios.add(usuarioC);

		//********************** ALBUM ********************************

		Album album = new Album("AM", "Arctic Monkeys", 2013, EstilosMusicais.INDIE);

		BaseDeDados.shared.albuns.add(album);

		//*********************** MUSICAS *****************************

		Musica m1 = new Musica("Do i wanna know?", 4.5, album);
		Musica m2 = new Musica("Are U Mine?", 3.0, album);

		usuarioA.avaliaMusica(m1, 3.0);
		usuarioA.avaliaMusica(m2, 5.0);

		usuarioB.avaliaMusica(m1, 2.5);
		usuarioB.avaliaMusica(m2, 4.0);

		usuarioC.avaliaMusica(m1, 4.5);
		usuarioC.avaliaMusica(m2, 3.8);

		BaseDeDados.shared.musicas.add(m1);
		BaseDeDados.shared.musicas.add(m2);


		//************************ PLAYLIST PUBLICA ***********************

		PlayListPublica publica = usuarioA.criaPlayListPublica("Comunidade Artic");

		usuarioA.adicionaMusicaPlayList(m1, publica);
		usuarioC.adicionaMusicaPlayList(m2, publica);

*/


		JanelaAwesomeMix janela = new JanelaAwesomeMix();
		janela.setVisible(true);
		
		for(int i=0; i< BaseDeDados.shared.usuariosPlayListPublicas.size(); i++) {
			System.out.println(BaseDeDados.shared.usuariosPlayListPublicas.get(i).toString());
		}

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ APAGANDO DO BANCO @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

				musicaPlayPrivadaDAO.apagarMusicaPlayListPrivada();		

				musicaPlayPublicaDAO.apagarMusicaPlayListPublica();

				usuPlayPublicaDAO.apagarUsuarioPlayListPublica();

				usuarioMusicaDAO.apagarUsuarioMusica();

				PlayListPublicaDAO playPublica = new PlayListPublicaDAO();
				playPublica.apagarPlayListPublica();

				PlayListPrivadaDAO playPrivada = new PlayListPrivadaDAO();
				playPrivada.apagarPlayListPrivada();

				musicaDAO.apagarMusicas();

				usuarioDAO.apagarUsuario();

				albumDAO.apagarAlbuns();

				
				
				//@@@@@@@@@@@@@@@@@@ INSERE NO BANCO DE DADOS @@@@@@@@@@@@@@@@@@@@@@

				// ************************** USUARIOS ******************************


				for(int i = 0; i < BaseDeDados.shared.usuarios.size(); i++) 
					usuarioDAO.inserirUsuario(BaseDeDados.shared.usuarios.get(i));
				
				// ************************** ALBUM **********************************

				
				for(int i = 0; i < BaseDeDados.shared.albuns.size(); i++) 
					albumDAO.inserirAlbum(BaseDeDados.shared.albuns.get(i));
				
				// ***************************** MUSICAS *****************************


				for(int i = 0; i < BaseDeDados.shared.musicas.size(); i++) {
					System.out.println(BaseDeDados.shared.musicas.get(i).getAvaliacaoMusica());
					musicaDAO.inserirMusica(BaseDeDados.shared.musicas.get(i));
				}

				// ***************************** PLAYLISTS PUBLICAS *******************
				

				for(int i = 0; i < BaseDeDados.shared.playListsPublicas.size(); i++) 
					playPublicaDAO.inserirPlayListPublica(BaseDeDados.shared.playListsPublicas.get(i));

				// **************************** PLAYLISTS PRIVADAS ********************
				
				
				for(int i = 0; i < BaseDeDados.shared.playListsPrivadas.size(); i++) 
					playPrivadaDAO.inserirPlayListPrivada(BaseDeDados.shared.playListsPrivadas.get(i));

				// *************************** ASSOCIATIVOS *****************************

				

				for(int i = 0; i < BaseDeDados.shared.usuariosMusica.size(); i++) 
					usuarioMusicaDAO.inserirUsuarioMusica(BaseDeDados.shared.usuariosMusica.get(i));



				for(int i = 0; i < BaseDeDados.shared.usuariosPlayListPublicas.size(); i++) {
					System.out.println(BaseDeDados.shared.usuariosPlayListPublicas.get(i).toString());
					usuPlayPublicaDAO.inserirUsuarioPlayListPublica(BaseDeDados.shared.usuariosPlayListPublicas.get(i));
				}



				for(int i = 0; i < BaseDeDados.shared.musicasPlayListPrivada.size(); i++) 
					musicaPlayPrivadaDAO.inserirMusicaPlayListPrivada(BaseDeDados.shared.musicasPlayListPrivada.get(i));



				for(int i = 0; i < BaseDeDados.shared.musicasPlayListPublica.size(); i++) 
					musicaPlayPublicaDAO.inserirMusicaPlayListPublica(BaseDeDados.shared.musicasPlayListPublica.get(i));
					

			}
		}, "Shutdown-thread"));


	}

}
