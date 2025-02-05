package bonus_tp_Rally;

import java.util.Date;

public class Speciale {
	private String nom;
	private Date jour_heure;
	private double distance;
	private Type_Epreuve type;
	private int resultatIndex = 0;
	private Resultat[] resultats = new Resultat[50];
	//CONSTRUCTOR
	public Speciale(String nom, Date jour_heure, double distance, Type_Epreuve type) {
		super();
		this.nom = nom;
		this.jour_heure = jour_heure;
		this.distance = distance;
		this.type = type;	
	}
		
	//---methods
	public String getNom() {
		return nom;
	}
	
	public void ajouterResultat(Resultat resultat) {
		resultats[resultatIndex] = resultat;
		resultatIndex++;
	}
	
	public Resultat[] getClassement() {
		return ClassementUtil.classerParTemps(resultats);
	}

	//toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Speciale [nom=");
		builder.append(nom);
		builder.append(", jour_heure=");
		builder.append(jour_heure);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
