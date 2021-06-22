import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Enseignant extends Personne {

	int tarifHoraire;
	
	public static HashMap<String, Enseignant> enseignants = new HashMap<String,Enseignant>();
	
	public ArrayList<Matiere> matieres = new ArrayList<Matiere>();
	
	public Enseignant(String nom, String prenom, String cin, float age, String tel) {
		super(nom, prenom, cin, age, tel);
	}

	public static void ajoutEnseignant() {
		int i, nbMatEns;
		
		Scanner sc = new Scanner(System.in);
		
		Personne p = Personne.ajoutPersonne();
		
		Enseignant en = new Enseignant(p.nom,p.prenom,p.cin,p.age,p.tel);
		
		enseignants.put(p.cin,en);
		
		Matiere.ajoutMatiere(en);
		
	}
	
	public static void modifEnseignant() {
		String editCIN;
		int modifChamp;
		Enseignant en;
		
		do {
			System.out.println("Le CIN de l'enseignant a modifier : ");
			Scanner scCIN = new Scanner(System.in);
			editCIN=scCIN.nextLine();
		}while(editCIN.length() != 8);
		
			en = enseignants.get(editCIN);
			afficheEnseignant(en);
			do {
				System.out.println("Le champ a modifier : ");
				System.out.println("1-Nom");
			    System.out.println("2-Prenom");
			    System.out.println("3-Age");
			    System.out.println("4-Numero tel");
				Scanner sc = new Scanner(System.in);
				modifChamp=sc.nextInt();
			}while(modifChamp < 1 || modifChamp > 4);
			
		switch(modifChamp){
	        case 1 : changeNom(en);break;
	        case 2 : changePrenom(en);break;
	        case 3 : changeAge(en);break;
	        case 4 : changeTel(en);break;
		}
	}
	
	public static void afficheEnseignant(Enseignant en) {
		Personne.affichePersonne(en);
		
		int sum = 0, nbHrParMat;
		
		for(Matiere m : en.matieres) {
			System.out.println("Nombre d'heure de "+ m.nomMatiere + " est " + m.nbHrParMat);
			sum += m.nbHrParMat;
		}
		
		System.out.println("Tarif horaire " + en.tarifHoraire);
		System.out.println("Nombre d'heure totale " + sum);
		System.out.println("Cout de l'enseignant " + (en.tarifHoraire * sum));
		
	}
	
	public static void consultEnseignant() {
		String editCIN;
		do {
			System.out.println("Le CIN de l'enseignant a consulter : ");
			Scanner scCIN = new Scanner(System.in);
			editCIN=scCIN.nextLine();
		}while(editCIN.length() == 8);
		Enseignant en = enseignants.get(editCIN);
		afficheEnseignant(en);
	}
	
}
	

