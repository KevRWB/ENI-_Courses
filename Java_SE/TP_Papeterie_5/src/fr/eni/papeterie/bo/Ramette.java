package fr.eni.papeterie.bo;

public class Ramette extends Article {
	
	private int grammage;
	
	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	public Ramette(int idArticle, String reference, String marque, String designation, float prixUnitaire,
			int qteStock, int grammage) {
		super(idArticle, reference, marque, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	public Ramette(String reference, String marque, String designation, float prixUnitaire, int qteStock, int grammage) {
		super(reference, marque, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" Ramette [grammage=");
		builder.append(grammage);		
		builder.append("]\n");
		return builder.toString();
	}

	
}
