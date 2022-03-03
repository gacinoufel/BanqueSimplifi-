import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import compte.CompteCourant;
import compte.CompteGeneral;
import exception.CrediterOrDebiterAvecZeroException;
import exception.DebiterAvecDepassementDuSoldeEpargneException;
import exception.LimiteDepasser100kEurosException; 

public class CompteCourantTest { 
	
	protected CompteGeneral cp; 
	
	@BeforeEach
	public void init() { 
		this.cp=new CompteCourant("Gaci","Noufel");
	}
	
	@Test
	public void testDeCreationdeCompteCourant() { 
		assertEquals(cp.getCredits(),0);
		assertEquals(cp.getDebits(),0);
	} 
	
	@Test
	public void testDeCrediterOrDebiter()  throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException{ 
		cp.crediter(3000.0); 
		cp.debiter(1000); 
		assertEquals(cp.getCredits(),3000.0);
		assertEquals(cp.getDebits(),1000); 
	}
	
	@Test
	public void testWhenCrediterOrDebiterWhenNegative() throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException { 
		// After a negative transaction 
		cp.crediter(-100.50); 
		cp.debiter(-200.10); 
		assertEquals(cp.getCredits(),0);//rien a changer 
		assertEquals(cp.getDebits(),0);//rien a changer aussi en debitons
	} 
	
	@Test
	public void testWhenTableauDeCreditEstPlein() throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException { 
		for (int i=0; i<11;i++) { 
			cp.crediter(100);
		}
		assertEquals(cp.getCredits(),1100); // Credit total est a 100*11= 1000 
		assertEquals(cp.getReleve().getListeDesCredits().get(0),1000);// le premier dans la liste des credits serra 100*10=1000€ 
							// et avec le seconde element de la liste serra 100 
							// donc au total sa nous fait 1000+100=1100€
	}
	
	@Test
	public void testWhenCrediterOrDebiterWithZero() throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException { 
		// After Créditer or débiter avec un 0€ 		
		assertThrows(CrediterOrDebiterAvecZeroException.class,() -> {cp.debiter(0);}); 
		assertThrows(CrediterOrDebiterAvecZeroException.class,() -> {cp.crediter(0);}); 
	}
	
	@Test
	public void testWhenDepassementDeLimiteFraude() throws CrediterOrDebiterAvecZeroException,LimiteDepasser100kEurosException, DebiterAvecDepassementDuSoldeEpargneException  { 
		// Before Créditer or débiter sans dépassement de 100K€  
		cp.crediter(9000);
		cp.debiter(700); 
		// Maintenant on vas franchir la barre des 100000 
		assertThrows(LimiteDepasser100kEurosException.class,() -> {cp.crediter(150000)/* =>déclenchement*/ ;}); 
		assertThrows(LimiteDepasser100kEurosException.class,() -> {cp.debiter(160000);/*=>déclenchement*/}); 
	} 
	
	
}

