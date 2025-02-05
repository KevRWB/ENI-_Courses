package fr.eni.vault;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Storable;
import com.eni.vault.bll.Vault;
import com.eni.vault.bo.Gold;

public class TestAjouterObjet {
	Vault vault = new Vault();
	
	@Test
	public void testAddObject() throws BLLException {
		//Arrange
		Storable gold = new Gold(20);
		
		//Act add Object in the vault
		int listObjDansCoffre = vault.addObject(gold);

		//Assert
		assertEquals(listObjDansCoffre, 1, "Echec fonction addObject");
	
	}
	

	@Test
	public void testItemIsInTheVault() throws BLLException {
		//Arrange
		Storable gold = new Gold(20);
		ArrayList<Storable> listObjects = vault.getObjectsInside();
		
		//Act add Object in the vault
		vault.addObject(gold);

		//Assert
		assertEquals(listObjects.get(0), gold,"Echec fonction addObject");
	
	}
}
