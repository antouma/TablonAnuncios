import static org.junit.Assert.*;
import junio2013.TablonDeAnuncios;

import org.junit.Before;
import org.junit.Test;


public class TablonDeAnunciosTest {

	private TablonDeAnuncios tablon;
	
	
	@Before
	public void setUp(){
		tablon = new TablonDeAnuncios();
	}
	@Test
	public void test1() {
		assertEquals(1, tablon.anunciosPublicados());
		//sin yo meterle ningun anuncio ya tenemos 1 publicado..
	}

}
