public class Main {
	
	public static void main(String[] args) {
		
		//instanciando um usuario
		Usuario usuario1 = new Usuario();
		usuario1.criaUsuario("thamiris", 21, "thrabbit", "blablabla");
		
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
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println("Inserindo user:\n"+usuarioDAO.inserirUsuario(usuario1));
		
		JanelaAwesomeMix janela = new JanelaAwesomeMix();
		janela.setVisible(true);
	}

}
