package banque;
import java.util.*;
import exception.*;
import compte.*;
	/**
 * A Bank represente represents the list of accounts 
 * with their different operations and services offered 
 *for a quality service such as: 
 *adding an account and deleting and even seeing its balance.
 * @author  GACI Noufel
 * @version 2.0
 */

public class Banque {
	protected String nom;
	protected List<CompteGeneral> listeDesComptes; 
	/* Constructor that creates a Bank   with the given name
	 * @param name name of Bank 
	*/
	public Banque (String nom) {
		this.setNom(nom);
		this.listeDesComptes=new ArrayList<>(); 
	}

	/*Enables to add an account to the bank 
	* @param cp account to add
	*/
	public void addComptes(CompteGeneral cp) {
		this.listeDesComptes.add(cp);
	} 

	/*Enables to get an acount  
	 * @param index a number of acount that we want to get it 
	 * @returnType CompteGeneral the account 
	*/
	public CompteGeneral getCompte(int index) {
		return this.listeDesComptes.get(index);
	} 

	/*Enables to remove an acount in the bank 
	 * @param cp a count to remove
	*/
	public void removeCompte(CompteGeneral cp) {
		this.listeDesComptes.remove(cp);

	} 

	/*Enables to get balance of account
	 * @param numeroCompte number of account
	 * @returnType double the balance of account 
	*/
	public double getSoldeDeCompte(int numeroCompte) {
		return this.getCompte(numeroCompte).getSolde(); 
	} 
	
	/*Enables to get all acount in the bank 
	* @returnType List<CompteGeneral> a list of account 
	*/
	public List<CompteGeneral> getListeDesComptes() {
		return this.listeDesComptes;
	} 

	/*Enables to check is an account is existed 
	* @param cp an account 
	* @returnType boolean response about existence
	 */
	public boolean isExisteCompte(CompteGeneral cp) {
		return this.getListeDesComptes().contains(cp);
	} 

	/*Enables to find the number of an account in the bank
	* @param cp the account 
	* @returnType int 
	*/
	public int trouverNumeroCompte(CompteGeneral cp) {
		int indexOfCompte = this.getListeDesComptes().indexOf(cp);
		return indexOfCompte;
	} 

	/*To check if the number of an account is existed in the bank 
	* @param int the number of the account 
	* @returnType boolean the reponse of existence 
	*/
	public boolean isExisteNumeroCompte(int numeroCompte) {
		return this.getCompte(numeroCompte)!=null;
	} 

	/*Enables to credited an amount to an account 
	* @param numeroCompte the number of the account in the bank 
	* @param montant the amount 
	*/
	public void crediterNumeroCompte(int numeroCompte,double montant) throws InexistantCompteException, CrediterOrDebiterAvecZeroException, LimiteDepasser100kEurosException {
		if (!this.isExisteNumeroCompte(numeroCompte)) {
			throw new InexistantCompteException ("Erreur: Compte Inexistant ");
		}
		else {
			this.listeDesComptes.get(numeroCompte).crediter(montant);
		}
	} 

	/*Enables to debited an amount on an account 
	* @param numeroCompte the number of the account in the bank 
	* @param montant the amount 
	*/
	public void debiterNumeroCompte(int numeroCompte,double montant) throws InexistantCompteException, CrediterOrDebiterAvecZeroException, DebiterAvecDepassementDuSoldeEpargneException, LimiteDepasser100kEurosException {
		if (!this.isExisteNumeroCompte(numeroCompte)) {
			throw new InexistantCompteException ("Erreur: Compte Inexistant ");
		}
		else { 
			this.getCompte(numeroCompte).debiter(montant); 
		}
	} 

	/*Enables make a transfer from one account to another
	* @param numeroCompteSource the source account number 
	* @param numeroCompteDestinataire recipient account number 
	* @param montantEnvoyer the amount 
	*/
	public void virer(int numeroCompteSource,int numeroDestinataire,double montantEnvoyer) throws InexistantCompteException, CrediterOrDebiterAvecZeroException, LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException {
		this.debiterNumeroCompte(numeroCompteSource, montantEnvoyer);
		this.crediterNumeroCompte(numeroDestinataire, montantEnvoyer);
	} 

	/*Enables to get the name of the bank 
	* @returnType String the name of the bank 
	*/
	public String getNom() {
		return nom;
	} 
	/*Enables to change the name of the bank 
	* @paramType String the name of the bank 
	*/
	public void setNom(String nom) {
		this.nom = nom;
	} 
	
}
