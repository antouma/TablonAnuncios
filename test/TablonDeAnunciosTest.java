import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junio2013.Anuncio;
import junio2013.IBaseDeDatosDeAnunciantes;
import junio2013.IBaseDeDatosDePagos;
import junio2013.TablonDeAnuncios;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;




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
	@Test
		
	public void test2() {
		
		IBaseDeDatosDeAnunciantes bd = mock(IBaseDeDatosDeAnunciantes.class);
		when(bd.buscarAnunciante("LA EMPRESA")).thenReturn(true);
		
		IBaseDeDatosDePagos bp = mock(IBaseDeDatosDePagos.class);
		
		Anuncio anu = new Anuncio("Titulo","Nuevo anuncio","LA EMPRESA");
	
		
		
		tablon.publicarAnuncio(anu, bd, bp);
		assertEquals(2, tablon.anunciosPublicados());
	

		
		//sin yo meterle ningun anuncio ya tenemos 1 publicado..
	}

}
