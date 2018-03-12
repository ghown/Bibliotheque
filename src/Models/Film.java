package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Film {
	
	    protected String nomFilm;
	    protected String acteurPrincipal;
	    protected String anneeSortie;
	    protected String realisateur;
	    protected String support;
	    protected String statut;
	    protected Personne pers;

	    public Film(String nomFilm, String acteurPrincipal, String anneeSortie, String realisateur, String support, String statut){
	        this.nomFilm = nomFilm;
	        this.acteurPrincipal = acteurPrincipal;
	        this.anneeSortie=anneeSortie;
	        this.realisateur = realisateur;
	        this.support = support;
	        this.statut = statut;
	    }


	    /////////////////  set ////////////
	    public void setNomFilm(String nomFilm) {
	        this.nomFilm = nomFilm;
	    }

	    public void setActeurPrincipal(String acteurPrincipal) {
	        this.acteurPrincipal = acteurPrincipal;
	    }

	    public void setAnneeSortie(String anneeSortie) {
	        this.anneeSortie = anneeSortie;
	    }

	    public void setRealisateur(String realisateur) {
	        this.realisateur = realisateur;
	    }

	    public void setSupport(String support) {
	        this.support = support;
	    }
	    
	    public void setStatut(String statut) {
	    	this.statut = statut;
	    }
	    
	    public void setPersonne(Personne pers) {
	    	this.pers = pers;
	    }

	    /////////////////  get ////////////
	    public String getActeurPrincipal() {
	        return acteurPrincipal;
	    }

	    public String getAnneeSortie() {
	        return anneeSortie;
	    }

	    public String getNomFilm() {
	        return nomFilm;
	    }

	    public String getRealisateur() {
	        return realisateur;
	    }

	    public String getSupport() {
	        return support;
	    }
	    
	    public String getStatut() {
	    	return statut;
	    }
	    
	    public Personne getPersonne() {
	    	return pers;
	    }






	    public static void afficheFilm(ArrayList<Film> listeFilm){
	    	Film film;
	    	Film filmDispo;
	    	Film filmLoue;
	    	ArrayList<Film> filmDisponibles = new ArrayList<Film>();
	    	ArrayList<Film> filmLoues = new ArrayList<Film>();
	    	for(int i = 0; i < listeFilm.size(); i++) {
	    		film = listeFilm.get(i);
	    		if(film.getStatut().toLowerCase().equals("loué")) {
	    			filmLoues.add(film);
	    		}else {
	    			filmDisponibles.add(film);
	    		}
	    	}
	    	System.out.println("Liste des films DISPONIBLES :\n");
	    	for(int j = 0; j < filmDisponibles.size(); j++) {
	    		filmDispo = filmDisponibles.get(j);
	    		System.out.println("titre: "+filmDispo.nomFilm+
	                    "\t acteur principal: "+filmDispo.acteurPrincipal+
	                    "\t annee de sortie: "+filmDispo.anneeSortie+
	                    "\t realisateur: "+filmDispo.realisateur+
	                    "\t support: "+filmDispo.support+
	                    "\t disponibilité : "+filmDispo.statut);
	    	}
	    	System.out.println("\nListe des films loués et des personnes associées.");
	    	for(int k = 0; k < filmLoues.size(); k++) {
	    		filmLoue = filmLoues.get(k);
	    		System.out.println("titre: "+filmLoue.nomFilm + 
	                    "\t acteur principal: "+filmLoue.acteurPrincipal+
	                    "\t annee de sortie: "+filmLoue.anneeSortie +
	                    "\t réalisateur: "+filmLoue.realisateur+
	                    "\t support: "+filmLoue.support+
	                    "\t disponibilité : "+filmLoue.statut+
	                    "\t loué par : M."+filmLoue.getPersonne().getNom());    		
	    	}
	    }
	    
	    
	    public static void afficheFilmParSupport(ArrayList<Film> listeFilm){
	    	Film film;
	    	ArrayList<Film> filmK7 = new ArrayList<>();
	    	ArrayList<Film> filmCle = new ArrayList<>();
	    	ArrayList<Film> filmBR = new ArrayList<>();
	    	ArrayList<Film> filmDvd = new ArrayList<>();
	    	ArrayList<Film> filmAutre = new ArrayList<>();
	    	
	    	for(int i = 0; i < listeFilm.size(); i++) {
	    		film = listeFilm.get(i);
	    		if(film.getSupport().equals("K7")) {
	    			filmK7.add(film);
	    		}else if(film.getSupport().equals("Clé USB")) {
	    			filmCle.add(film);
	    		}else if(film.getSupport().equals("Blue-ray")) {
	    			filmBR.add(film);
	    		}else if(film.getSupport().equals("DVD")) {
	    			filmDvd.add(film);
	    		}else{
	    			filmAutre.add(film);
	    		}
	    	}
	    	
	    	System.out.println("CASSETTE : \n");
	    	for(int k7 = 0; k7 < filmK7.size(); k7++) {
	    		afficherUnFilm(filmK7.get(k7));
	    	}
	    	
	    	System.out.println("CLE USB : \n");
	    	for(int cle = 0; cle < filmCle.size(); cle++) {
	    		afficherUnFilm(filmCle.get(cle));
	    	}
	    	
	    	System.out.println("BLUE-RAY: \n");
	    	for(int BR = 0; BR < filmBR.size(); BR++) {
	    		afficherUnFilm(filmBR.get(BR));
	    	}
	    	
	    	System.out.println("DVD : \n");
	    	for(int dvd = 0; dvd < filmDvd.size(); dvd++) {
	    		afficherUnFilm(filmDvd.get(dvd));
	    	}
	    	
	    	System.out.println("\nLes films suivants sont sur un support inconnu : \n");
	    	for(int autre = 0; autre < filmAutre.size(); autre++) {
	    		afficherUnFilm(filmAutre.get(autre));
	    	}
	    	
	    }

	
	public static ArrayList<Film> ajouterFilm(ArrayList<Film> listeFilms){
		Scanner sc = new Scanner(System.in);
		
        System.out.println("Veuillez saisir le nom du film :");
        String nomFilm = sc.nextLine();
        
        System.out.println("Veuillez saisir le nom de l'acteur principal :");
        String acteurPrincipal = sc.nextLine();
        
        System.out.println("Veuillez saisir l'année de sortie :");
        String anneeSortie = sc.nextLine();
        
        System.out.println("Veuillez saisir le réalisateur :");
        String realisateur = sc.nextLine();
        
        System.out.println("Veuillez saisir le support (K7, Clé USB, Blue-ray, DVD :");
        String support = sc.nextLine();

        Film nvFilm = new Film(nomFilm, acteurPrincipal, anneeSortie, realisateur, support, "Disponible");
        listeFilms.add(nvFilm);
        System.out.println("\nLe film "+nvFilm.getNomFilm().toUpperCase()+" est desormais disponible dans la vidéothèque.\n");
        return listeFilms;
		
	}
	
	public static void afficherUnFilm(Film film) {
		System.out.println("titre: "+film.getNomFilm()+"\t acteur principal: "+film.getActeurPrincipal()
		+"\t année de sortie:"+film.getAnneeSortie()+"\t réalisateur: "+film.getRealisateur()+
		"\t support: "+film.getSupport()+"\t disponibilité:"+film.getStatut()+".");
	}
	
    
    public static ArrayList<Film> search(ArrayList<Film> listeFilm){
        Scanner sc = new Scanner(System.in);
        String keyword;
        Film film;
        Personne p = new Personne();
        String nom;
        String prenom;
        
        
        ArrayList<Film> filmTrouves = new ArrayList<Film>();
        System.out.println("Veuillez saisir le nom du film que vous recherchez :");
        keyword = sc.nextLine();
        boolean count = false;
        for(int i = 0; i < listeFilm.size(); i++)
        {
        	film = listeFilm.get(i);
            if(film.getNomFilm().toLowerCase().equals(keyword.toLowerCase()) && film.statut != "Loué")
            {
            	listeFilm.remove(film);
            	System.out.println("Le film "+film.getNomFilm().toUpperCase()+" est disponible.");
            	System.out.println("Pour louer ce film, veuillez saisir votre nom : ");
            	nom = sc.next();
            	System.out.println("Veuillez saisir votre prénom : ");
            	prenom = sc.next();
            	p.setNom(nom);
            	p.setPrenom(prenom);
            	film.setPersonne(p);
            	film.setStatut("Loué");
            	listeFilm.add(film);
            	System.out.println("Le film "+film.getNomFilm().toUpperCase()+" a bien été loué.\n");
            	return listeFilm;
            }
        }
        System.out.println("Le film est loué ou n'existe pas.");
        return listeFilm;
    }
    
    public static ArrayList<Film> delete(ArrayList<Film> listeFilm){
    	String keyword;
    	Film film;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du film a supprimer :");
        keyword = sc.nextLine();
        for(int i = 0; i < listeFilm.size(); i++)
        {
        	film = listeFilm.get(i);
            if(film.getNomFilm().toLowerCase().equals(keyword.toLowerCase())){
                listeFilm.remove(film);
                System.out.println("Le film "+film.getNomFilm()+" a bien été supprimé.\n");
            }
        }
        return listeFilm;
    }
}
