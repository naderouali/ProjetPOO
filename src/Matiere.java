import java.util.ArrayList;
import java.util.Scanner;

public class Matiere {
	String nomMatiere;
	int noteMatiere;
	int coefMatiere;
	int nbHrParMat;
	Enseignant en;
	
	public static ArrayList<Matiere> matieres = new ArrayList<Matiere>();
	
	public Matiere(String nomMatiere, int nbHrParMat, Enseignant en) {
		this.nomMatiere = nomMatiere;
		this.nbHrParMat = nbHrParMat;
		this.en = en;
	}


	public Matiere(String nomMatiere, int noteMatiere, int coefMatiere) {
		
		this.nomMatiere = nomMatiere;
		this.noteMatiere = noteMatiere;
		this.coefMatiere = coefMatiere;
	}

	
	public static void affectNote(Etudiant e) {
		String nomMatiere = "";
		int i,nbMatiere,coefMatiere =1,noteMatiere=0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre du matieres : ");
		nbMatiere=sc.nextInt();
			sc.nextLine();
		for(i=0;i<nbMatiere;i++) {
			System.out.println("Nom matiere "+i);
			nomMatiere = sc.nextLine();
			do {
				System.out.println("Coef matiere "+i);
				coefMatiere = sc.nextInt();
				sc.nextLine();
			}while(coefMatiere <= 0);
			do {
				System.out.println("Votre note en "+ nomMatiere);
				noteMatiere = sc.nextInt();
				sc.nextLine();
			}while((noteMatiere <= 0) || (noteMatiere >= 20));
		}
		
		Matiere m = new Matiere(nomMatiere,noteMatiere,coefMatiere);		
		e.matieres.add(m);
		
	}
	
	public static void ajoutMatiere(Enseignant en) {
		String nomMatiere = "";
		int i,nbMatiere,nbHrParMat = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre du matieres : ");
		nbMatiere=sc.nextInt();
			sc.nextLine();
		for(i=0;i<nbMatiere;i++) {
			System.out.println("Nom matiere "+i);
			nomMatiere = sc.nextLine();
			do {
				System.out.println("Nombre d'heures par matiere : "+ nbHrParMat);
				nbHrParMat = sc.nextInt();
				sc.nextLine();
			}while(nbHrParMat <= 0);
		}
		
		Matiere m = new Matiere(nomMatiere,nbHrParMat,en);		
		en.matieres.add(m);
		
	}
	
	
	public static void afficheMatiere(Matiere m) {
		
		System.out.println("Nom matiere : "+m.nomMatiere);
		System.out.println("Coef matiere : "+m.coefMatiere);
		System.out.println("Note dans cette matiere : "+m.noteMatiere);
	}
	
	
	
}
