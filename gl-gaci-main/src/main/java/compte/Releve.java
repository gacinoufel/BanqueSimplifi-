package compte;
import java.util.*; 

/* Releve represente an Account statement 
* which describes all the transactions made by the person on his account
* it is re-updated every 10 operations 
*/
public class Releve { 
	// Attributs 
	public static final double initSolde=0.00; 
	public static final int MAX_OPERATIONS_SIZE=10;
	protected List<Double> creditsList;
	protected List<Double> debitsList ; 
	double solde; 
	
	/*Constructor of Releve */
	public Releve () { 
		this.creditsList = new ArrayList<> ();
		this.debitsList= new ArrayList<> ();
		this.solde=initSolde;
	} 

	/*Enables to get all the operations maded by the person in his account 
	* @returnType List<Double> the list of credit opérations 
	*/
	public List<Double> getListeDesCredits() {
		return this.creditsList;
	} 

	/*Enables to get all the debit operations maded by the person in his account 
	* @returnType List<Double> the list of debit opérations 
	*/
	public List<Double> getListeDesDebits() {
		return this.debitsList;
	} 

	/*Enables to get the sum of all the credit operations maded by the person in his account 
	* @returnType double the amount of all operations credit 
	*/
	public double getAllCredits() { 
		return sommeList(this.creditsList);
	} 

	/*Enables to get the sum of all the debits operations maded by the person in his account 
	* @returnType double the amount of all operations debits 
	*/
	public double getAllDebits() { 
		return sommeList(this.debitsList);
	} 
	
	/*Enables to change the list of credit
	* @param index,i the position in the list credits and the amount
	*/
	public void setCreditsList(int index,double i) { 
		this.creditsList.set(index,i);
	}
	
	/*Enables to get the balance of the account
	* @returnType double the balance total of an account 
	*/
	public double getSolde() { 
		double sl=sommeList(this.creditsList)-sommeList(debitsList); 
		this.solde=sl;
		return sl;
	} 

	/*Enables to add an credit 
	* @param i the amount of credit 
	*/
	public void addCredits(double i) { 
		// bank statement size limitation
		if (this.creditsList.size()<MAX_OPERATIONS_SIZE ) { 
			this.creditsList.add(i);
		}
		else { 
			double sommeDeTout= sommeList (this.creditsList); 
			this.creditsList.clear(); 
			this.creditsList.add(sommeDeTout);  
			this.creditsList.add(i);	
		}	
	} 

	/*Enables to add a debit operation 
	* @param i the amount 
	*/
	public void addDebits(double i) { 
		// bank statement size limitation
		if (this.debitsList.size()<MAX_OPERATIONS_SIZE ) { 
			this.debitsList.add(i);
		}
		else { 
			double sommeDeTout= sommeList (this.debitsList); 
			this.debitsList.clear(); 
			this.debitsList.add(sommeDeTout);  
			this.debitsList.add(i); 
		} 
	} 

	/*Enables to change the balance 
	* @param sl the amount 
	*/
	public void setSolde(double sl) { 
		this.solde=sl;
	} 

	/*Enables to get the sum of all type operations 
	* @param List<Double> l the list of operations
	* @returnType double the sum of operations
	*/
	public double sommeList(List<Double> l) {
		double somme=0;
		 for(double i :l) {
			 somme += i;
		 }
		return somme;
	} 
		
} 
