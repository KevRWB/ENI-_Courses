package fr.eni.ecole;

public class ReversiTest {

	public static void main(String[] args) {
		PlateauDeReversi plateau = new PlateauDeReversi();
		
		plateau.afficher();
		
		int test = plateau.testNbPionRetournable(Pion.NOIR, 4, 3);
		System.out.println(plateau.getPions()[3][3]);
		
		System.out.println(test);
	}
	
}
