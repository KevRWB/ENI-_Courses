package fr.eni.vault;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Vault;

public class TestOpenVault {
	
	@Test
	public void testOpenVaultPasswordOk() throws BLLException {
		//Arrange - préparerletest
		Vault vault = new Vault();
		
		//Act -lock the vault
		vault.lock("1234");
		
		//Act open with code
		vault.unlock("1234");
		String password = vault.getPassword();
		//Assert
		assertEquals(password, "1234", "Echec fonction unLock");
	
	}
	
	@Test
	public void testOpenVaultIsOpened() throws BLLException {
		//Arrange - préparerletest
		Vault vault = new Vault();
		
		//Act -lock the vault
		vault.lock("1234");

		//Act open with code
		vault.unlock("1234");
		boolean isLocked = vault.isLocked(); 
		//Assert
		assertEquals(isLocked, false, "Echec fonction unLock");
	
	}
	
	@Test
	public void testWrongPassword() throws BLLException {
		//Arrange - préparerletest
		Vault vault = new Vault();
		
		//Act -lock the vault
		vault.lock("1234");
		
		//Act open with code with wrong password
		vault.unlock("1235");
		boolean isLocked = vault.isLocked(); 
		//Assert
		assertEquals(isLocked, true, "Echec fonction unLock - mauvais password");
	
	}
	
	@Test
	public void testDejaOuvert() throws BLLException {
		//Arrange - préparerletest
		Vault vault = new Vault();
		
		//Act / Assert
		assertThrows(BLLException.class,() -> vault.unlock("1235"));
	
	}

}
