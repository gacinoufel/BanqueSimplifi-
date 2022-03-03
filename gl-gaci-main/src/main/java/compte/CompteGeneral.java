package compte;

import exception.*;

/*CompteGeneral represents an account in general with these features*/ 

public abstract  class  CompteGeneral { 
	protected String nom;
	protected String prenom;
	Releve releve; 

	/*Constructor of the CompteGeneral 
	* @param nom,prenom the name of the account 
	*/
	public CompteGeneral (String nom,String prenom) {
		this.nom=nom;
		this.prenom=prenom;
		this.releve=new Releve(); 
	} 

	/*Enables to get the bank statement
	* @returnType Releve 
	*/
	public Releve getReleve() {
		return this.releve;
	} 

	/*Enables to get the credits*/
	public double getCredits() { 
		return getReleve().getAllCredits();
	} 

	/*Enables to get the debits */
	public double getDebits() { 
		return this.releve.getAllDebits();
	} 
	
	/*Enables to get the balance of an account 
	* @returnType double the balance 
	 */
	public double getSolde() { 
		return this.releve.getSolde();
	} 

	/*Enables to credit an account with an amount 
	* @param cre the amount
	*/
	public void crediter (double cre) throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException{ 
		if(cre>=100000) { 
			throw new LimiteDepasser100kEurosException("Erreur: Depassement de Limite 100000FRAUDE ");
		}
		if(cre==0.0) { 
			throw new CrediterOrDebiterAvecZeroException("Erreur: du montant 0 ");
		} 
		if (cre>0.0){ 
			this.releve.addCredits(cre); 
		}
	} 
	
	/*Enables to debit an account with an amount 
	* @param cre the amount
	*/
	public void debiter (double cre) throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException, CrediterOrDebiterAvecZeroException { 
		if(cre>=100000) { 
			throw new LimiteDepasser100kEurosException("Erreur: Depassement de Limite 100K euros FRAUDE ");
		}
		if(cre==0.0) { 
					throw new CrediterOrDebiterAvecZeroException("Erreur: du montant 0 ");
		} 
	} 
	
	
} 
