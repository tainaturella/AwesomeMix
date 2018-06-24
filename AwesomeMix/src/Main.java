import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		/*
		//instanciando um usuario
		Usuario usuario1 = new Usuario();
		usuario1.criaUsuario("thamiris", 21, "thrabbit", "blablabla");
		
=======
		
		/*
>>>>>>> branch 'master' of https://github.com/tainaturella/AwesomeMix.git
		//instanciando playlist publica e privada para o usuario, removendo algumas
		usuario1.criaPlayListPrivada("favoritos");
		usuario1.criaPlayListPublica("ouvir no banho");
		usuario1.criaPlayListPrivada("ble");
		usuario1.criaPlayListPrivada("ble");
	
		
		//instanciando albuns e musicas e atribuindo notas a eles
		Album album = new Album("AM", "Arctic Monkeys", 2013, EstilosMusicais.Indie);
		album.atribuirNota(9.0);
		Musica m1 = new Musica("do i wanna know?", 4.32, album);
		Musica m2 = new Musica("Are U Mine?", 3.21, album);
		m1.atribuirNota(7.0);
		m2.atribuirNota(5.0);
		usuario1.adicionaAlbumPlaylist("ouvir no banho", 0, album);
		
		//imprimindo o album e o usuario para analisar se tudo foi feito corretamente
		System.out.println(album);
		System.out.println(usuario1);
		
		
		//-------------------------------------------------------------------------------//
		//      TESTANDO FUNCIONALIDADES DAS CLASSES PLAYLIST E SUBLCASSES               //
		//-------------------------------------------------------------------------------//
		
		//cria e instancia um objeto do tipo musica.
		Album theWall= new Album("The Wall", "Pink Floyd", 1979, EstilosMusicais.Rock);
		Musica anotherBrick =  new Musica("Another Brick in The Wall", 6.0 ,theWall);
		
		//Cria e instancia Usuario 's
		Usuario usuarioA = new Usuario();
		usuarioA.setNome("Peter Quill");
		usuarioA.setLogin("starlord@galaxy.com");
		usuarioA.setIdade(31);
		usuarioA.setSenha("pass");
		
		Usuario usuarioB = new Usuario();
		usuarioB.setNome("Groot");
		usuarioB.setLogin("iamgroot@galaxy.com");
		usuarioB.setIdade(100);
		usuarioB.setSenha("iamgroot");
		
		Usuario usuarioC = new Usuario();
		usuarioC.setNome("Gamora");
		usuarioC.setLogin("gamora@galaxy.com");
		usuarioC.setIdade(30);
		usuarioC.setSenha("green");
		
		//Cria e instancia uma PlayListPublica, o usuario A eh o autor
		System.out.println("\n\nTESTANDO FUNCIONALIDADES DAS PLAYLISTS\n");
		String out = "";
		//PlayListPublica playList1 = new PlayListPublica("My AwesomeMix vol1", usuarioA);
		
		//Imprime os dados dos usuarios
		System.out.println("Dados dos usuarios A, B e C resectivamente");
		System.out.println("A " + usuarioA);
		System.out.println("B " + usuarioB);
		System.out.println("C " + usuarioC);
		
		//Adiciona Musicas nas playlist Publica
		//System.out.println("\nAdiconando musica anotherBrick na Playlist Publica playList1"
		//				  + " " + playList1.adicionarMusica(anotherBrick));	 	//esperamos true		
		//System.out.println("Adiconando musica m1 na playList1" + " " + playList1.adicionarMusica(m1));//esperamos true		
		//System.out.println("Adiconando anotherBrick na playList1 novamante"
		//				  + " "  playList1.adicionarMusica(anotherBrick));	//esperamos false
		
		//Adiciona Contribuintes na playlist publica
		//System.out.println("Adiconando usuarioA" + " " + playList1.adicionarContribuinte(usuarioA));	//esperamos true
		//System.out.println("Adiconando usuarioB" + " " + playList1.adicionarContribuinte(usuarioB));	//esperamos true
		//System.out.println(playList1);
		System.out.print("Lista de playLists do usuario B: ");
		for (int i = 0; i < usuarioB.getPlaylistsPublicas().size(); i++){
			out += usuarioB.getPlaylistsPublicas().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		out = "";
		
		//Remove o usuario B da lista de Contribuintes
		//System.out.println("Removendo o usuario B" + " " + playList1.removerContribuinte(usuarioB));	//esperamos true
		System.out.print("Lista de playLists do usuario B depois da remocao: ");
		for (int i = 0; i < usuarioB.getPlaylistsPublicas().size(); i++){
			out += usuarioB.getPlaylistsPublicas().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		out = "";
		//System.out.println(playList1);
		
		
		//Cria e instancia uma PlayListPrivada
		//PlayListPrivada playList2 = new PlayListPrivada("My Private AwesomeMix vol2", usuarioC);
		//System.out.println("\nAdiconando anotherBrick Privada na playList2 "
		//				  +playList2.adicionarMusica(anotherBrick)); 			//esperamos true		
		//System.out.println("Adiconando usuario A " + usuarioA.getId() + " " 
		//				  + playList2.adicionarContribuinte(usuarioA));			//esperamos true
		//System.out.println("Adiconando usuario B " + usuarioB.getId() + " " 
		//				  + playList2.adicionarContribuinte(usuarioB));			//esperamos true
		//System.out.println(playList2);
		System.out.print("Lista de playLists Privadas do usuario A:");
		for (int i = 0; i < usuarioA.getPlaylistsPrivadas().size(); i++){
			out += usuarioA.getPlaylistsPrivadas().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		out = "";
		
		//Remove o usuarioA da lista de Contribuintes
		
		//System.out.println("Removendo o usuario A " + " " + playList2.removerContribuinte(usuarioA));			//esperamos true
		System.out.print("Lista de playLists do usuario A depois da remocao:");
		for (int i = 0; i < usuarioA.getPlaylistsPrivadas().size(); i++){
			out += usuarioA.getPlaylistsPrivadas().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		//System.out.println(playList2);
		
		//******* USUARIOS
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		//System.out.println("Inserindo user:\n"+usuarioDAO.inserirUsuario(usuario1));
		

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Usuario> usuariosRetirados = new ArrayList<Usuario>();
		
		//******** GRAVANDO USUARIOS NO BANCO ******************
		/*Usuario usuario = new Usuario("Thamiris", 21, "thrabbit", "blablabla");
		usuarios.add(usuario);
		usuario = new Usuario("Thiago", 22, "thiag", "1234");
		usuarios.add(usuario);
		for(int i = 0; i < usuarios.size(); i++) {
			System.out.println("Inserindo user:\n"+usuarioDAO.inserirUsuario(usuarios.get(i)));
		}*/
		
		/*
		//********* PEGANDO USUARIOS DO BANCO ******************
		usuariosRetirados = usuarioDAO.buscarUsuarios();
		for(int i = 0; i < usuariosRetirados.size(); i++) {
			System.out.println("User do banco:\n"+usuariosRetirados.get(i));
		}
		
		
		//*******PLAYLISTS PRIVADAS
		PlayListPrivadaDAO playListPrivadaDAO = new PlayListPrivadaDAO();
		ArrayList<PlayListPrivada> privadas = new ArrayList<PlayListPrivada>();
		ArrayList<PlayListPrivada> privadasRetiradas = new ArrayList<PlayListPrivada>();
		
		PlayListPrivada priv = usuariosRetirados.get(0).criaPlayListPrivada("Bad vibes");
		System.out.println("Id da playpriv\n"+priv.getId());
		privadas.add(priv);
		
		// ***** GRAVA NO BANCO
		/*for(int i = 0; i < privadas.size(); i++) {
			System.out.println("Inserindo PlayListPrivada: \n"+playListPrivadaDAO.inserirPlayListPrivada(privadas.get(i)));
		}*/
		/*
		// **** PEGA DO BANCO
		privadasRetiradas = playListPrivadaDAO.buscarPlayListPrivadaIdUsuario(usuariosRetirados.get(0).getId(), usuarios);
		for(int i = 0; i < privadasRetiradas.size(); i++) 
			System.out.println("PlayListPrivada do cara de id "+ usuariosRetirados.get(1).getId()+":\n"+privadasRetiradas.get(i));
		
		
		//***********PLAYLISTS PUBLICAS
		PlayListPublicaDAO playListPublicaDAO = new PlayListPublicaDAO();
		ArrayList<PlayListPublica> publicas = new ArrayList<PlayListPublica>();
		ArrayList<PlayListPublica> publicasRetiradas = new ArrayList<PlayListPublica>();
		
		PlayListPublica pub = usuariosRetirados.get(0).criaPlayListPublica("Good vibes");
		System.out.println("Id da playpub\n"+pub.getId());
		publicas.add(pub);
		*/
		// ***** GRAVA NO BANCO
		/*for(int i = 0; i < privadas.size(); i++) {
			System.out.println("Inserindo PlayListPublica: \n"+playListPublicaDAO.inserirPlayListPublica(publicas.get(i)));
		}
		
		
		// **** PEGA DO BANCO
		publicasRetiradas = playListPublicaDAO.buscarPlayListsPublicas();
		for(int i = 0; i < publicasRetiradas.size(); i++) 
			System.out.println("PlayListPublica:\n"+publicasRetiradas.get(i));
		*/

		
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@ CRIACAO NA MEMORIA @@@@@@@@@@@@@@@@@@@@@@@@
		
		//*********************** USUARIOS ****************************
		
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
		
		BaseDeDados.shared.playListsPublicas.add(publica);
		
		//************************ PLAYLIST PRIVADA ***********************
		
		PlayListPrivada privada = usuarioC.criaPlayListPrivada("Pra ficar feliz");
		
		usuarioC.adicionaMusicaPlayList(m1, privada);
		
		BaseDeDados.shared.playListsPrivadas.add(privada);
		
		//**************************************************************
		
		//@@@@@@@@@@@@@@@@@@ INSERE NO BANCO DE DADOS @@@@@@@@@@@@@@@@@@@@@@
		/*
		// ************************** USUARIOS ******************************
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		for(int i = 0; i < BaseDeDados.shared.usuarios.size(); i++) 
			usuarioDAO.inserirUsuario(BaseDeDados.shared.usuarios.get(i));
		
		// ************************** ALBUM **********************************
		
		AlbumDAO albumDAO = new AlbumDAO();
		
		for(int i = 0; i < BaseDeDados.shared.albuns.size(); i++) 
			albumDAO.inserirAlbum(BaseDeDados.shared.albuns.get(i));
		
		// ***************************** MUSICAS *****************************
		
		MusicaDAO musicaDAO = new MusicaDAO();
		
		for(int i = 0; i < BaseDeDados.shared.musicas.size(); i++) 
			musicaDAO.inserirMusica(BaseDeDados.shared.musicas.get(i));
		
		// ***************************** PLAYLISTS PUBLICAS *******************
		
		PlayListPublicaDAO playPublicaDAO = new PlayListPublicaDAO();
		
		for(int i = 0; i < BaseDeDados.shared.playListsPublicas.size(); i++) 
			playPublicaDAO.inserirPlayListPublica(BaseDeDados.shared.playListsPublicas.get(i));
		
		// **************************** PLAYLISTS PRIVADAS ********************
		
		PlayListPrivadaDAO playPrivadaDAO = new PlayListPrivadaDAO();
		
		for(int i = 0; i < BaseDeDados.shared.playListsPrivadas.size(); i++) 
			playPrivadaDAO.inserirPlayListPrivada(BaseDeDados.shared.playListsPrivadas.get(i));
		
		// *************************** ASSOCIATIVOS *****************************
		
		UsuarioMusicaDAO usuarioMusicaDAO = new UsuarioMusicaDAO();
		
		for(int i = 0; i < BaseDeDados.shared.usuariosMusica.size(); i++) 
			usuarioMusicaDAO.inserirUsuarioMusica(BaseDeDados.shared.usuariosMusica.get(i));
		
		
		UsuarioPlayListPublicaDAO usuPlayPublicaDAO = new UsuarioPlayListPublicaDAO();
		
		for(int i = 0; i < BaseDeDados.shared.usuariosPlayListPublicas.size(); i++) 
			usuPlayPublicaDAO.inserirUsuarioPlayListPublica(BaseDeDados.shared.usuariosPlayListPublicas.get(i));
		
		
		MusicaPlayListPrivadaDAO musicaPlayPrivadaDAO = new MusicaPlayListPrivadaDAO();
		
		for(int i = 0; i < BaseDeDados.shared.musicasPlayListPrivada.size(); i++) 
			musicaPlayPrivadaDAO.inserirMusicaPlayListPrivada(BaseDeDados.shared.musicasPlayListPrivada.get(i));
		
		
		MusicaPlayListPublicaDAO musicaPlayPublicaDAO = new MusicaPlayListPublicaDAO();
		
		for(int i = 0; i < BaseDeDados.shared.musicasPlayListPublica.size(); i++) 
			musicaPlayPublicaDAO.inserirMusicaPlayListPublica(BaseDeDados.shared.musicasPlayListPublica.get(i));
		
		
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
				
		for(int i = 0; i < musicas.size(); i++) 
			BaseDeDados.shared.musicas.add(musicas.get(i));
				
		// ***************************** PLAYLISTS PUBLICAS *******************
				
		PlayListPublicaDAO playPublicaDAO = new PlayListPublicaDAO();
		ArrayList<PlayListPublica> playsPublica = playPublicaDAO.buscarPlayListsPublicas();	
		
		for(int i = 0; i < playsPublica.size(); i++) 
			BaseDeDados.shared.playListsPublicas.add(playsPublica.get(i));
				
		// **************************** PLAYLISTS PRIVADAS ********************
				
		PlayListPrivadaDAO playPrivadaDAO = new PlayListPrivadaDAO();
		ArrayList<PlayListPrivada> playsPrivadas = playPrivadaDAO.buscarPlayListPrivada(BaseDeDados.shared.usuarios);		
		
		for(int i = 0; i < playsPrivadas.size(); i++) 
			BaseDeDados.shared.playListsPrivadas.add(playsPrivadas.get(i));
				
		// *************************** ASSOCIATIVOS *****************************
				
		UsuarioMusicaDAO usuarioMusicaDAO = new UsuarioMusicaDAO();
		ArrayList<UsuarioMusica> ususMusica = usuarioMusicaDAO.buscarUsuarioMusica(BaseDeDados.shared.usuarios, BaseDeDados.shared.musicas);		
		
		for(int i = 0; i < ususMusica.size(); i++) 
			BaseDeDados.shared.usuariosMusica.add(ususMusica.get(i));
				
				
		UsuarioPlayListPublicaDAO usuPlayPublicaDAO = new UsuarioPlayListPublicaDAO();
		ArrayList<UsuarioPlayListPublica> usuPlayPublica = usuPlayPublicaDAO.buscarUsuarioPlayListPublica(BaseDeDados.shared.playListsPublicas, BaseDeDados.shared.usuarios);	
				
		for(int i = 0; i < usuPlayPublica.size(); i++) 
			BaseDeDados.shared.usuariosPlayListPublicas.add(usuPlayPublica.get(i));
				
				
		MusicaPlayListPrivadaDAO musicaPlayPrivadaDAO = new MusicaPlayListPrivadaDAO();
		ArrayList<MusicaPlayListPrivada> musicasPlayPrivada = musicaPlayPrivadaDAO.buscarMusicaPlayListPrivada(BaseDeDados.shared.playListsPrivadas, BaseDeDados.shared.musicas);	
		
		for(int i = 0; i < musicasPlayPrivada.size(); i++) 
			BaseDeDados.shared.musicasPlayListPrivada.add(musicasPlayPrivada.get(i));
				
				
		MusicaPlayListPublicaDAO musicaPlayPublicaDAO = new MusicaPlayListPublicaDAO();
		ArrayList<MusicaPlayListPublica> musicasPlayPublica = musicaPlayPublicaDAO.buscarMusicaPlayListPublica(BaseDeDados.shared.playListsPublicas, BaseDeDados.shared.musicas);
		
		for(int i = 0; i < musicasPlayPublica.size(); i++) 
			BaseDeDados.shared.musicasPlayListPublica.add(musicasPlayPublica.get(i));
				
		*/
		// @@@@@@@@@@@@@@@@@@@@@@@@ IMPRIME O ESTADO DO SISTEMA @@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		for(int i = 0; i < BaseDeDados.shared.usuarios.size(); i++) 
			System.out.println(BaseDeDados.shared.usuarios.get(i)+"\n");
				
		for(int i = 0; i < BaseDeDados.shared.albuns.size(); i++) 
			System.out.println(BaseDeDados.shared.albuns.get(i)+"\n");
				
		for(int i = 0; i < BaseDeDados.shared.musicas.size(); i++) 
			System.out.println(BaseDeDados.shared.musicas.get(i)+"\n");
				
		for(int i = 0; i < BaseDeDados.shared.playListsPublicas.size(); i++) 
			System.out.println(BaseDeDados.shared.playListsPublicas.get(i)+"\n");
				
		for(int i = 0; i < BaseDeDados.shared.playListsPrivadas.size(); i++) 
			System.out.println(BaseDeDados.shared.playListsPrivadas.get(i)+"\n");
				
				
		for(int i = 0; i < BaseDeDados.shared.usuariosMusica.size(); i++) 
			System.out.println(BaseDeDados.shared.usuariosMusica.get(i)+"\n");
				
				
		for(int i = 0; i < BaseDeDados.shared.usuariosPlayListPublicas.size(); i++) 
			System.out.println(BaseDeDados.shared.usuariosPlayListPublicas.get(i)+"\n");
				
				
		for(int i = 0; i < BaseDeDados.shared.musicasPlayListPrivada.size(); i++) 
			System.out.println(BaseDeDados.shared.musicasPlayListPrivada.get(i)+"\n");
				
				
		for(int i = 0; i < BaseDeDados.shared.musicasPlayListPublica.size(); i++) 
			System.out.println(BaseDeDados.shared.musicasPlayListPublica.get(i)+"\n");
				
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ APAGANDO DO BANCO @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		MusicaPlayListPrivadaDAO musicaPlayPrivadaDAO = new MusicaPlayListPrivadaDAO();
		musicaPlayPrivadaDAO.apagarMusicaPlayListPrivada();		
				
		MusicaPlayListPublicaDAO musicaPlayPublicaDAO = new MusicaPlayListPublicaDAO();
		musicaPlayPublicaDAO.apagarMusicaPlayListPublica();
		
		UsuarioPlayListPublicaDAO usuPlayPublicaDAO = new UsuarioPlayListPublicaDAO();
		usuPlayPublicaDAO.apagarUsuarioPlayListPublica();
		
		UsuarioMusicaDAO usuarioMusicaDAO = new UsuarioMusicaDAO();
		usuarioMusicaDAO.apagarUsuarioMusica();
		
		PlayListPublicaDAO playPublica = new PlayListPublicaDAO();
		playPublica.apagarPlayListPublica();
		
		PlayListPrivadaDAO playPrivada = new PlayListPrivadaDAO();
		playPrivada.apagarPlayListPrivada();
		
		MusicaDAO musicaDAO = new MusicaDAO();
		musicaDAO.apagarMusicas();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.apagarUsuario();
		
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.apagarAlbuns();
		
		JanelaAwesomeMix janela = new JanelaAwesomeMix();
		janela.setVisible(true);
		
		
	}

}
