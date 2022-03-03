import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import compte.CompteEpargne;
import exception.*;


public class CompteEpargneTest { 
	protected CompteEpargne cpEp; 
	@BeforeEach
	public void init() { 
		cpEp=new CompteEpargne("Gaci","Noufel"); 
	}

	@Test
	public void testDeCreationDeCompteEpargne() { 
		List<Double> l =new ArrayList<Double> ();
		assertEquals(cpEp.getReleve().getListeDesCredits(),l); 
		assertEquals(cpEp.getReleve().getListeDesDebits(),l); 
		assertEquals(cpEp.getReleve().getAllCredits(),0); 
		assertEquals(cpEp.getReleve().getAllDebits(),0); 
		} 
	
	@Test
	public void testWhenDebiterDeCompteEpargneException() throws DebiterAvecDepassementDuSoldeEpargneException, CrediterOrDebiterAvecZeroException, LimiteDepasser100kEurosException  { 
		
		cpEp.crediter(8000); 
		//cpEp.debiter(9000); // Ce teste c'est une trace question 3.2 1ere version 
		//assertEquals(cpEp.getSolde(),8000); // verification que rien a changer
		// commentez l'exception 'DebiterAvecDepassementDuSoldeEpargneException' ); 
		// N'oubliez pas de commentez 'assertThrows...' 
	 
		assertThrows(DebiterAvecDepassementDuSoldeEpargneException.class,() -> {cpEp.debiter(9000)/* =>déclenchement*/ ;}); 
		} 
	
	@Test
	public void testCalculInteret()  { 
		try {
			cpEp.crediter(4000);
		} catch (CrediterOrDebiterAvecZeroException | LimiteDepasser100kEurosException e) {
			e.printStackTrace();
		}
		
		assertEquals (cpEp.calculInteret(),4000*0.05); 	
	}
	
	@Test
	public void testWhenTauxInteretAppliquer() throws CrediterOrDebiterAvecZeroException, LimiteDepasser100kEurosException  { 
		cpEp.crediter(1000); 
		assertEquals (cpEp.echeance(),1000+1000*0.05); 	
	} 
	
}
