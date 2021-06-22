import java.util.ArrayList;
import java.util.Scanner;

public class Personne {
	
	String nom,prenom,cin,tel;
	float age;

	public Personne(String nom, String prenom, String cin, float age, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.age = age;
		this.tel = tel;
	}
	
	public static Personne ajoutPersonne() {
		String nom, prenom, cin, tel;
		int age;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Nom : ");
			nom=sc.nextLine();
			System.out.println("Prenom : ");
			prenom=sc.nextLine();
			System.out.println("Age : ");
			age=sc.nextInt();
			sc.nextLine();
			System.out.println("CIN : ");
			cin=sc.nextLine();
			System.out.println("Numero telephone : ");
			tel=sc.nextLine();
			
		}while((cin.length() != 8) && (tel.length() != 8));
		return new Personne(nom,prenom,cin,age,tel);
	}
	
	
	public static void affichePersonne(Personne p) {
		
			System.out.println("Nom "+p.nom);
		    System.out.println("Prenom "+p.prenom);
		    System.out.println("CIN "+p.cin);
		    System.out.println("Age "+p.age);
		    System.out.println("Numero telephone "+p.tel);
			
	}
	
	public static void changeNom(Personne p) {
		String newNom;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nouveau nom : ");
		newNom=sc.nextLine();
		p.nom = newNom;
	}
	
	public static void changePrenom(Personne p) {
		String newPrenom;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nouveau prenom : ");
		newPrenom=sc.nextLine();
		p.prenom = newPrenom;
	}
	
	public static void changeAge(Personne p) {
		float newAge;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nouveau age : ");
		newAge=sc.nextFloat();
		p.age = newAge;
	}
	
	public static void changeTel(Personne p) {
		String newTel;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nouveau num telephone : ");
		newTel=sc.nextLine();
		p.tel = newTel;
	}
	
}
