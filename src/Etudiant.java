import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Etudiant extends Personne {

	
	String classe;
	String appreciationEtudiant;
	
	
	public static HashMap<String, Etudiant> etudiants = new HashMap<String,Etudiant>();
	
	public ArrayList<Matiere> matieres = new ArrayList<Matiere>();
	
	public Etudiant(String nom, String prenom, String cin, float age, String tel, String classe) {
		super(nom, prenom, cin, age, tel);
		this.classe = classe;
	}


	public static void ajoutEtudiant() {
		String classe;
		Scanner sc = new Scanner(System.in);
		
		Personne p = Personne.ajoutPersonne();
		
		System.out.println("Classe de l etudiant : ");
		classe = sc.nextLine();
		
		Etudiant e = new Etudiant(p.nom,p.prenom,p.cin,p.age,p.tel,classe);
		
		etudiants.put(p.cin,e);
		
		Matiere.affectNote(e);
		
	}
	
	public static void changeClasse(Etudiant e) {
		String newClasse;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nouveau classe : ");
		newClasse=sc.nextLine();
		e.classe = newClasse;
	}
	
	public static void changeApprec(Etudiant e) {
		String newAppreciation;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nouvelle appreciation : ");
		newAppreciation=sc.nextLine();
		e.appreciationEtudiant = newAppreciation;
	}
	
	public static void modifEtudiant() {
		String editCIN;
		int modifChamp;
		Etudiant e;
		
		do {
			System.out.println("Le CIN de l etudiant a modifier : ");
			Scanner scCIN = new Scanner(System.in);
			editCIN=scCIN.nextLine();
		}while(editCIN.length() != 8);
		
			e = etudiants.get(editCIN);
			afficheEtudiant(e);
			do {
				System.out.println("Le champ a modifier : ");
				System.out.println("1-Nom");
			    System.out.println("2-Prenom");
			    System.out.println("3-Age");
			    System.out.println("4-Classe");
			    System.out.println("5-Numero tel");
			    System.out.println("6-Appreciation");
				Scanner sc = new Scanner(System.in);
				modifChamp=sc.nextInt();
			}while(modifChamp < 1 || modifChamp > 6);
			
		switch(modifChamp){
	        case 1 : changeNom(e);break;
	        case 2 : changePrenom(e);break;
	        case 3 : changeAge(e);break;
	        case 4 : changeClasse(e);break;
	        case 5 : changeTel(e);break;
	        case 6 : changeApprec(e);break;
		}
	}
	
	public static void afficheEtudiant(Etudiant e) {
		Personne.affichePersonne(e);
		System.out.println("Classe "+e.classe);
		System.out.println("Appreciation "+e.appreciationEtudiant);
		e.moyenne();
	}
	
	public static void consultEtudiant() {
		String editCIN;
		do {
			System.out.println("Le CIN de l etudiant a consulter : ");
			Scanner scCIN = new Scanner(System.in);
			editCIN=scCIN.nextLine();
			
		}while(editCIN.length() == 8);
		Etudiant e = etudiants.get(editCIN);
		afficheEtudiant(e);
	}
	
	public static void appreciation() {
		Etudiant e;
		Enseignant en;
		String appEtud,etudCIN,profID;
		
		System.out.println("Votre CIN : ");
		Scanner profCIN = new Scanner(System.in);
		profID = profCIN.nextLine();
		en = Enseignant.enseignants.get(profID);
		
		System.out.println("Le CIN de l etudiant a apprecier : ");
		Scanner scCIN = new Scanner(System.in);
		etudCIN = scCIN.nextLine();
		
		e = etudiants.get(etudCIN);
		afficheEtudiant(e);
			
			System.out.println("Donnez votre appreciation a propos : "+e.nom);
			appEtud=scCIN.nextLine();
			e.appreciationEtudiant = appEtud;
		System.out.println("Appreciation enregistree");
		afficheEtudiant(e);
	}
	
	public int moyenne() {
		int sum = 0,sumCoef = 0;
		
		for(Matiere m : matieres) {
			sum += (m.noteMatiere*m.coefMatiere);
			sumCoef += m.coefMatiere;
		}
		
		System.out.println("la moyenne de l'etudiant est " + (float)sum/sumCoef);
		return sum;
	}
	
}
