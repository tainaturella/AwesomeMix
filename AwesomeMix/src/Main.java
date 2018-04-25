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
		usuario1.removePlayListPrivada("ble");
		
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
		
	}

}
