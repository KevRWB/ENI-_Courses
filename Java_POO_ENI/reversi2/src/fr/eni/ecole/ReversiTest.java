package fr.eni.ecole;

public class ReversiTest {

	public static void main(String[] args) {
		PlateauDeReversi plateau = new PlateauDeReversi();
		
		plateau.afficher();
		
		plateau.poser(Pion.NOIR, 5, 4);
				
		plateau.afficher();
		
	}
	
}
