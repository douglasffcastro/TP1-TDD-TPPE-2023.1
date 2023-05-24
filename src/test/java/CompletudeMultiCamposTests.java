import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CompletudeMultiCamposTests {
    AvaliadorCompletude avaliadorCompletude;

    @Before
    public void setup() {
        avaliadorCompletude = new AvaliadorCompletude();
    }

    @Test
    public void testCalcularCompletudeMultiCamposTotal () {
        avaliadorCompletude.adicionarAtomico("title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils");
        avaliadorCompletude.adicionarAtomico("publicationDate", "2003");
        avaliadorCompletude.adicionarAtomico("language", "Inglês");
        avaliadorCompletude.adicionarComposto("authors", new Object[] {"name", "Dulce Helena Gonçalves Orofino",
                                                                              "ordemAutoria", "10",
                                                                              "identifier.lattes", "0009277151089005",
                                                                              "nationality", "Brasil",
                                                                              "birthCity", "rio de janeiro",
                                                                              "birthState", "RJ",
                                                                              "birthCountry", "Brasil"});

        Assertions.assertEquals(100, avaliadorCompletude.calcularCompletudeMultiCampos());
    }
}
