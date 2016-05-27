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
	
	@Test 
	
	public void test3(){
		
		
		Anuncio anuncio = new Anuncio("hola", "prueba", "OTRA EMPRESA");
		IBaseDeDatosDeAnunciantes bd = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos bp = mock(IBaseDeDatosDePagos.class);
		
		when(bd.buscarAnunciante("OTRA EMPRESA")).thenReturn(true);
		when(bp.anuncianteTieneSaldo("OTRA EMPRESA")).thenReturn(false);
		tablon.publicarAnuncio(anuncio, bd, bp);
		
		assertEquals(1, tablon.anunciosPublicados());
		
	}
	
	@Test
	
	public void test4(){
		
		
		IBaseDeDatosDeAnunciantes bd = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos bp = mock(IBaseDeDatosDePagos.class);
		Anuncio anuncio = new Anuncio("holaa", "prueba", "OTRA EMPRESA");
		
		when(bd.buscarAnunciante(anuncio.anunciante_)).thenReturn(true);
		when(bp.anuncianteTieneSaldo(anuncio.anunciante_)).thenReturn(true);
		
		tablon.publicarAnuncio(anuncio, bd, bp);
		assertEquals(2, tablon.anunciosPublicados());
	}
	
	@Test
	
	public void test5(){
		
		Anuncio anuncio = new Anuncio("antonio", "martos", "LA EMPRESA");
		Anuncio anuncio2 = new Anuncio("felipe", "molina", "LA EMPRESA");
		
		IBaseDeDatosDeAnunciantes bd = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos bp = mock(IBaseDeDatosDePagos.class);
		
		tablon.publicarAnuncio(anuncio, bd, bp);
		tablon.publicarAnuncio(anuncio2, bd, bp);
		
		assertEquals(anuncio2, tablon.buscarAnuncioPorTitulo(anuncio2.titulo_));
		assertEquals(3, tablon.anunciosPublicados());
	}
	

}
