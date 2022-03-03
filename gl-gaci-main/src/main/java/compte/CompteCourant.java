package compte;

import exception.*; 

/* CompteCourant represente an account benefiting from a prized interest
*/

public class CompteCourant extends CompteGeneral { 
	/*Constructor of the saving account 
	* @param nom,prenom the firstand Last name of the person 
	*/
	public CompteCourant (String nom,String prenom) {
		super(nom,prenom); 	
	} 

	/*Enables to debit an account with an amount 
	* @param cre the amount
	*/
	public void debiter (double cre) throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException{ 
		super.debiter(cre);
		if (cre>0.0){ 
			this.releve.addDebits(cre); 
		}	
	}
	
} 
