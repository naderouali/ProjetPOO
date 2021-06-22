import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistiques {
	
	public static void tauxReussite() {
		int sum = 0,i,taux,admisEtudiant = 0,totalEtudiant = 0;
		
		for(HashMap.Entry<String, Etudiant> e : Etudiant.etudiants.entrySet()) {
			if(e.getValue().moyenne() >= 10) {
				System.out.println("Admis");
				admisEtudiant++;
			}
			else
				System.out.println("Controle");
			sum += e.getValue().moyenne();
			totalEtudiant++;
		}
		taux = admisEtudiant/totalEtudiant;
		
		System.out.println("Taux de reussite est : " + (float)taux);
	}
	
}
