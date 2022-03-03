
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import compte.*;
import banque.*;
import exception.*; 

public class BanqueTest { 
	protected CompteCourant cp;
	protected CompteCourant autreCpCourant;
	protected CompteEpargne cpEp; 
	protected CompteEpargne autreCpEpargne;
	protected Banque banque;
	
	@BeforeEach
	 public void init() { 
		this.cp=new CompteCourant("Gaci","Noufel"); 
		this.cpEp=new CompteEpargne("Gaci","Noufel"); 
		this.banque=new Banque("LCL"); 
		this.autreCpCourant = new CompteCourant("Autre","Utilisateur"); 
		this.autreCpEpargne = new CompteEpargne("AutreEpargne","EpargneUtilisateur"); 
	}
	
	@Test
	public void testOuvertureDeBanque() { 
		List<CompteGeneral> l =new ArrayList<> ();
		assertEquals(this.banque.getListeDesComptes(),l); 
	}
	
	@Test
	public void testOuvertureCompteEpargne() { 
		this.banque.addComptes(cpEp);
		assertEquals(this.banque.getSoldeDeCompte(0),0); 
	} 
	
	@Test
	public void testOuvertureCompteCourant()   { 
		this.banque.addComptes(cp);
		assertEquals(this.banque.getSoldeDeCompte(0),0); 	
	} 
	
	@Test
	public void testCrediteretDebiterUnCompteCourant () throws InexistantCompteException, CrediterOrDebiterAvecZeroException, LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException   { 
		this.banque.addComptes(cp); 
		this.banque.crediterNumeroCompte(0, 560);
		this.banque.debiterNumeroCompte(0, 140);
		assertEquals(this.banque.getSoldeDeCompte(0),420);
		
	} 
	
	@Test
	public void testCrediteretDebiterUnCompteEpargne ()    { 
		this.banque.addComptes(cpEp); 
		try { 
			this.banque.crediterNumeroCompte(0, 560);
			this.banque.debiterNumeroCompte(0, 140); 
		} catch (InexistantCompteException | CrediterOrDebiterAvecZeroException | LimiteDepasser100kEurosException
				| DebiterAvecDepassementDuSoldeEpargneException e) {
			
			e.printStackTrace();
		}
		assertEquals(this.banque.getSoldeDeCompte(0),420); 
	}  
	
	@Test
	public void testCrediteretDebiterUnCompteEpargneWhenCompteEstInexistant ()  { 
		assertThrows(Exception.class,() -> {this.banque.crediterNumeroCompte(7, 100)/* =>déclenchement*/ ;}); 
		assertThrows(Exception.class,() -> {this.banque.debiterNumeroCompte(11, 444)/* =>déclenchement*/ ;}); 
	} 
	
	@Test
	public void testVirementEntreCompte() throws InexistantCompteException, CrediterOrDebiterAvecZeroException, LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException  { 
		this.banque.addComptes(cp); 
		this.banque.addComptes(cpEp);
		this.banque.crediterNumeroCompte(0, 1000);
		this.banque.virer(0, 1, 20); // cp fait un virement de 20euros vers cpEp
		assertEquals(this.banque.getSoldeDeCompte(0),980); 
		assertEquals(this.banque.getSoldeDeCompte(1),20); 
	} 
	
}
