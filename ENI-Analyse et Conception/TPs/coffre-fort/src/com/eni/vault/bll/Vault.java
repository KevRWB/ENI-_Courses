package com.eni.vault.bll;

import java.util.ArrayList;


public class Vault {
	

		private ArrayList<Storable> objectsInside;
		private String password;
		
		private boolean locked ;
		
		public Vault() {
			this.locked = false;			
			objectsInside = new ArrayList<Storable>();
		}
		
		public boolean isLocked() {
			return locked;
		}
		
		
		/*
		 * Description : Verrouille le coffre-fort
		 */
		public boolean lock(String password) throws BLLException {
			if(locked) {
				throw new BLLException("Coffre déjà fermé.");
			}
			this.password = password;
			locked = true;
			return locked;
		}
		
		/*
		 * Description : D�verrouille le coffre-fort
		 */
		public void unlock(String password) throws BLLException {
			if(!locked) {
				throw new BLLException("Coffre déjà ouvert.");
			}
			locked =  !password.equals(this.password);
		}
		
		/*
		 * Description : Ajoute un objet dans le coffre fort
		 * Retourne : le nombre d'objets dans le coffre
		 */
		public int addObject(Storable object) throws BLLException {
			if(locked) {
				throw new BLLException("Coffre fermé");
			}
			objectsInside.add(object);
			return objectsInside.size() ;
			
		}
	
		/*
		 * Description : Enl�ve un objet du coffre fort
		 */
		public int removeObject(Storable object) throws BLLException {
			if(locked) {
				throw new BLLException("Coffre déjà ouvert.");
			}
			objectsInside.remove(object);
			return  objectsInside.size() ;
		}

		
		//GETTERS SETTERS
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public ArrayList<Storable> getObjectsInside() {
			return objectsInside;
		}

		public void setObjectsInside(ArrayList<Storable> objectsInside) {
			this.objectsInside = objectsInside;
		}

		


}
