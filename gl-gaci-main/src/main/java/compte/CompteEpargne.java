package compte;
import exception.*; 

/*the savings account represents an account 
*which benefiting an interest rate
* @Author GACI Noufel
* Java v11
*/
public class CompteEpargne extends CompteGeneral { 
	public static final double TAUX=0.05; 
	protected double interet ; 

	/*Constructor of saving account 
	* @param nom,prenom the name of the person 
	*/
	public CompteEpargne (String nom,String prenom) {
		super(nom,prenom);
		this.setInteret(TAUX) ;
	} 
	
	/*Enables to debit an account with an amount 
	* @param cre the amount
	*/
	public void debiter (double cre) throws CrediterOrDebiterAvecZeroException,DebiterAvecDepassementDuSoldeEpargneException, DebiterAvecDepassementDuSoldeEpargneException, LimiteDepasser100kEurosException{ 
		super.debiter(cre);
		if (cre>0.0){ 
			if (cre>this.releve.getSolde()) {
				throw new DebiterAvecDepassementDuSoldeEpargneException("Erreur: solde insuffisant pour ce débits"); 
			} 
			else { this.releve.addDebits(cre); 
			} 
		} 
	} 
	
	/*Enables to add un interest to account 
	*/  
	public void addInteret() {
			try {
				this.crediter(this.calculInteret());
			} catch (CrediterOrDebiterAvecZeroException | LimiteDepasser100kEurosException e) {
				e.printStackTrace();
			}
	} 

	/*Enables to calculate the interest amount 
	* @returnType double the interest amount 
	*/
	public double calculInteret() { 
		return this.getReleve().getAllCredits()*TAUX;
	}
	
	/*Enables to add and change the amount of account  
	* @returnType double the balance of the account 
	*/
	public double echeance() { 
		this.addInteret(); 
		return this.getSolde(); 	
	} 

	/*Enables to get the interest rate 
	* @returnType double the interest rate 
	*/
	public double getInteret() {
		return interet;
	} 

	/*Enables to change the interest rate 
	* @param interet the interest rate 
	*/
	public void setInteret(double interet) {
		this.interet = interet;
	}
}
