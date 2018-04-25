public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Usuario usuario1 = new Usuario();
		
		usuario1.criaUsuario("thamiris", 21, "thrabbit", "blablabla");
		usuario1.criaPlayListPrivada("favoritos");
		usuario1.criaPlayListPublica("ouvir no banho");
		usuario1.criaPlayListPrivada("ble");
		usuario1.criaPlayListPrivada("ble");
		
		usuario1.removePlayListPrivada("ble");
		
		Musica musica = new Musica("do i wanna know?", 4.32, new Album("AM", "Arctic Monkeys", 2013, 9.0, EstilosMusicais.Indie));
		usuario1.adicionaMusicaPlaylist("ouvir no banho", 0, musica);
		usuario1.adicionaMusicaPlaylist("ouvir no banho", 1, musica);
		//usuario1.adicionaMusicaPlaylist("ouvir no banho", 0, new Musica("do i wanna know?", 4.32, new Album("AM", "Arctic Monkeys", 2013, 9.0, EstilosMusicais.Indie)));
		//usuario1.adicionaMusicaPlaylist("favoritos", 1, new Musica("do i wanna know?", 4.32, new Album("AM", "Arctic Monkeys", 2013, 9.0, EstilosMusicais.Indie)));
		
		System.out.println(usuario1);
		
	}

}
