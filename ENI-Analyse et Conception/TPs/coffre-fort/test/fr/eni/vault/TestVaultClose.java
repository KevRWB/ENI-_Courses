package fr.eni.vault;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Vault;

public class TestVaultClose {

	@Test
	public void testFermetureCode() throws BLLException {
		//Arrange - préparerletest
		Vault vault = new Vault();
		
		//Act -Vérifierlaméthode
		boolean canLock = vault.lock("1234");
		//Assert -Comparer le resultat renvoyé avec le résultat attendu
		assertEquals(canLock, true, "Echec fonction lock");
		

		//Act -Vérifierlaméthode
		boolean isLocked = vault.isLocked();
		//Assert isClosed
		assertEquals(isLocked, true, "Echec fonction est ferme");
		
		//Act / Assert
		assertThrows(BLLException.class,() -> vault.lock("1234"));
	}
	
}
