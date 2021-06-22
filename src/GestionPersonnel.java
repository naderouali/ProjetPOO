//CE PROJET EST REALISEE PAR NADER OUALI ET YOUSSEF BEN OUIRANE

import java.util.Scanner;

public class GestionPersonnel {
	public static void main (String[] args) {
		
		int repeteurMenu;
		do {
			repeteurMenu=affichMenuPrincipal();
			switch (repeteurMenu) {
				case 1 : menuEtudiant();    break;
	            case 2 : menuEnseignant();  break;
	            case 3 : menuApprec();    break;
	            case 4 : menuStat();	break;
	            }
		}while(repeteurMenu < 0 || repeteurMenu > 4);
	}


static int affichMenuPrincipal (){
    int x;
    Scanner sc = new Scanner(System.in) ;
    do{
	   System.out.println("MENU PRINCIPALE");
	   System.out.println("1-Gestion etudiant");
	   System.out.println("2-Gestion enseignant");
	   System.out.println("3-Affecter appreciation");
	   System.out.println("4-Statistiques");
	   x=sc.nextInt();
	   sc.nextLine();
   
    }while(x < 0 || x > 4);
    return x;
}

	static void menuEtudiant(){
    int x;
     Scanner sca = new Scanner(System.in) ;
     do{
	    System.out.println("MENU ETUDIANT");
	    System.out.println("1-Ajouter un etudiant");
	    System.out.println("2-Modifier un etudiant");
	    System.out.println("3-Consulter un etudiant");
	    x=sca.nextInt();
	    sca.nextLine();
     	}while(x < 1 || x > 3);
     switch(x){
            case 1 : Etudiant.ajoutEtudiant();break;
            case 2 : Etudiant.modifEtudiant();break;
            case 3 : Etudiant.consultEtudiant();break;
        }
	}
	
	static void menuEnseignant(){
	    int x;
	     Scanner sca = new Scanner(System.in) ;
	     do{
		    System.out.println("MENU ETUDIANT");
		    System.out.println("1-Ajouter un enseignant");
		    System.out.println("2-Modifier un enseignant");
		    System.out.println("3-Consulter un enseignant");
		    x=sca.nextInt();
		    sca.nextLine();
		    }while(x < 1 || x > 3);
	     switch(x){
	            case 1 : Enseignant.ajoutEnseignant();break;
	            case 2 : Enseignant.modifEnseignant();break;
	            case 3 : Enseignant.consultEnseignant();break;
	        }
		}
	
	static void menuApprec(){
		Etudiant.appreciation();
		}
	
	static void menuStat(){
		Statistiques.tauxReussite();
		}
}