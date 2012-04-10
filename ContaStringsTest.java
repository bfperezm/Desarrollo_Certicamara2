import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ContaStringsTest {
	private ContaStrings cs;
	@Before
	public void setUp() throws Exception {
		 cs= new ContaStrings();
	}

	@After
	public void tearDown() throws Exception {
		cs=null;
	}

	@Test
	public void testAdd() {		
		int actual = cs.Add("1,2,3");
		int esperado = 6;
		assertEquals(esperado,actual);
	}

	@Test
	public void testVerificar_Vacio() {
		boolean actual = cs.Verificar_Vacio("");
		boolean esperado = true;
		assertEquals(esperado, actual);
	}

	@Test
	public void testLeer_Cadena() throws IOException {
		String actual= cs.Leer_Cadena();
		String esperado = "1,2,3";
		assertEquals(esperado, actual);
	}

	@Test
	public void testSumar_Num() {
		int actual = cs.Sumar_Num("1,2,3");
		int esperado = 6;
		assertEquals(esperado,actual);
	}

	@Test
	public void testValidador_Negativos() throws NegativosNoPermitidos {
		String actual = cs.Validador_Negativos("1,2,3");
		String esperado = null;
		assertEquals(esperado, actual);
	}

}
