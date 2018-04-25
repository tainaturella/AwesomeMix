/*Classe Main - teste
 *Autora: Naomi Takemoto
 * */
public class Main {
	public static void main(String[] args) {

		//cria e instancia um objeto do tipo musica.
		Musica musica1 = new Musica();
		musica1.setAnoLancamento(1979);
		musica1.setArtista("Pink Floyd");
		musica1.setAvaliacao(10);
		musica1.setNomeAlbum("The Wall");
		musica1.setNomeMusica("Another Brick In The Wall");
		musica1.setTempoDuracao(6.0);
		
		//Cria e instancia Usuario 's
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Peter Quill");
		usuario1.setLogin("starlord@galaxy.com");
		usuario1.setIdade(31);
		usuario1.setSenha("pass");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Groot");
		usuario2.setLogin("iamgroot@galaxy.com");
		usuario2.setIdade(100);
		usuario2.setSenha("iamgroot");
		
		Usuario usuario3 = new Usuario();
		usuario3.setNome("Gamora");
		usuario3.setLogin("gamora@galaxy.com");
		usuario3.setIdade(30);
		usuario3.setSenha("green");
		
		
		//Cria e instancia uma PlayListPublica, o usuario 1 eh o autor
		String out = "";
		PlayListPublica playList1 = new PlayListPublica("My AwesomeMix vol1", usuario1);
		System.out.println("Adiconando musica1 na playList1" + " " + playList1.adicionarMusica(musica1));	 		//esperamos true		
		System.out.println("Adiconando musica1 na playList1 novamante" + " " + playList1.adicionarMusica(musica1));	//esperamos false		
		System.out.println("Adiconando usuario1" + " " + playList1.adicionarContribuinte(usuario1));				//esperamos true
		System.out.println("Adiconando usuario2" + " " + playList1.adicionarContribuinte(usuario2));				//esperamos true
		System.out.println(playList1);
		System.out.print("Lista de playLists do usuario 2: ");
		for (int i = 0; i < usuario2.getPlayLists().size(); i++){
			out += usuario2.getPlayLists().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		out = "";
		System.out.println("Removendo o usuario 2" + " " + playList1.removerContribuinte(usuario2));				//esperamos true
		System.out.print("Lista de playLists do usuario 2 depois da remocao: ");
		for (int i = 0; i < usuario2.getPlayLists().size(); i++){
			out += usuario2.getPlayLists().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		out = "";
		System.out.println(playList1);
		
		//Cria e instancia uma PlayListPrivada
		PlayListPrivada playList2 = new PlayListPrivada("My Private AwesomeMix vol2", usuario3);
		System.out.println("\nAdiconando musica1 na playList2" +playList2.adicionarMusica(musica1));	 //esperamos true		
		System.out.println("Adiconando usuario " + usuario1.getId() + " " + playList2.adicionarContribuinte(usuario1));		//esperamos true
		System.out.println("Adiconando usuario " + usuario3.getId() + " " + playList2.adicionarContribuinte(usuario3));		//esperamos true
		System.out.println(playList2);
		System.out.print("Lista de playLists do usuario 1:");
		for (int i = 0; i < usuario1.getPlayLists().size(); i++){
			out += usuario1.getPlayLists().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		out = "";
		System.out.println("Removendo o usuario 1" + " " + playList2.removerContribuinte(usuario1));				//esperamos true
		System.out.println("Lista de playLists do usuario1: " + " " + playList2.removerContribuinte(usuario1));
		System.out.print("Lista de playLists do usuario 1 depois da remocao:");
		for (int i = 0; i < usuario1.getPlayLists().size(); i++){
			out += usuario1.getPlayLists().get(i).getPlayList().getNome();
		}
		System.out.print(out + "\n");
		System.out.println(playList2);
	}

}
