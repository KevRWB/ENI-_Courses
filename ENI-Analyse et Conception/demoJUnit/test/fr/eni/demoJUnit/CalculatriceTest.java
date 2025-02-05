package fr.eni.demoJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatriceTest {
	@Test
	public void testAdditionerCasPositif() {
		//Arrange - préparerletest
		Calculatrice calc = new Calculatrice();
		long nombre1 = 30;
		long nombre2= 10;
		
		//Act -Vérifierlaméthode
		long resultat = calc.additionner(nombre1, nombre2);
		
		//Assert -Comparer le resultat renvoyé avec le résultat attendu
		assertEquals(resultat, 50, "Echec Additionner cas nominal");
	}
	
	@Test
	public void testDiviserCasNegatif() throws DivisionParZero {
		//Arrange
		Calculatrice calc = new Calculatrice();
		double nombre1= 30;
		double nombre2= 0;
		//Act / Assert
		assertThrows(DivisionParZero.class,() -> calc.diviser(nombre1, nombre2));
	}
}
