package bestGameEver.jeu;

import java.util.Scanner;

import bestGameEver.fonctions.FightFunctions;
import bestGameEver.persos.heroes.*;
import bestGameEver.persos.monsters.*;

public class BestGameEver {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		//Print heroes list3
		HeroesList.printHeroesList(HeroesList.getHeroesList());
		//select hero
		Hero hero = HeroesFunctions.selectHero(HeroesList.getHeroesList());
		//Print selected hero
		System.out.println("Vous avez selectionné:");
		HeroesFunctions.printHero(hero);	
		//Select random monster
		Monster monster = (MonstersFunctions.selectRdMonster(MonstersList.getMonstersList()));
		monster.printMonsterStats();
		monster.printMonsterWeapons();
	
		
		//Close Scanner
		scan.close();
	}	
}
