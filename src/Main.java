import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Models.Film;
import Models.Personne;

public class Main {

	public static void main(String[] args) {
		String command = "0";
		Scanner sc = new Scanner(System.in);
		ArrayList<Film> videotheque = new ArrayList();
		while(!command.equals("6")) {
			afficherMenuPrincipal();
			
			command = sc.next();
			
			while(!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("4") && !command.equals("5") && !command.equals("6")) {
				System.out.println("\t ATTENTION Veuillez saisir un chiffre entre 1 et 6 \n");
				afficherMenuPrincipal();
				command = sc.next();
			}
			switch (command) {
				case "1":
					videotheque = Film.ajouterFilm(videotheque);
					break;
				case "2":
					Film.search(videotheque);
					break;
				case "3":
					Film.afficheFilm(videotheque);
					break;
				case "4":
					Film.afficheFilmParSupport(videotheque);
					break;
				case "5":
					Film.delete(videotheque);
					break;
				case "6":
					return;
				default:
					return;
			}
			
		}
		return;
	}
	
	public static void afficherMenuPrincipal() {
		
		System.out.println("*************************************************");
		System.out.println("\tBienvenue sur notre vidéothèque :");
		System.out.println("*************************************************");
		System.out.println("1. Ajouter un film.");
		System.out.println("2. Rechercher un film.");
		System.out.println("3. Afficher les films par disponibilité.");
		System.out.println("4. Afficher les films par support.");
		System.out.println("5. Supprimer un film.");
		System.out.println("6. Quitter.");
	}

}
