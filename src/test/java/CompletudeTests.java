import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CompletudeTests {

    AvaliadorCompletude avaliadorCompletude;
    Object[][] camposAtomicos;
    String valorEsperado;

    @Before
    public void setup() {
        avaliadorCompletude = new AvaliadorCompletude();
    }

    public CompletudeTests(Object[][] camposAtomicos, String valorEsperado) {
        this.camposAtomicos = camposAtomicos;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] respostas = new Object[][] {
                {new Object[][] {
                    {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                }, "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils", },
                {new Object[][] {
                    {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                    {"publicationDate", "2003"}
                }, "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils2003"
                },
                {new Object[][] {
                    {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                    {"publicationDate", "2003"},
                    {"language", "Inglês"}
                }, "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils2003Inglês"}
        };

        return Arrays.asList(respostas);
    }

    @Test
    public void testAdicionaCamposAtomicos () {
        for (Object[] campo: camposAtomicos) {
            avaliadorCompletude.adicionarAtomico((String) campo[0], (String) campo[1]);
        }

        String atomicosAdicionados = "";
        if (avaliadorCompletude.getCampoAtomico().get("title") != null) {
            atomicosAdicionados = avaliadorCompletude.getCampoAtomico().get("title");
        }
        if (avaliadorCompletude.getCampoAtomico().get("publicationDate") != null) {
            atomicosAdicionados +=  avaliadorCompletude.getCampoAtomico().get("publicationDate");
        }
        if (avaliadorCompletude.getCampoAtomico().get("language") != null){
            atomicosAdicionados += avaliadorCompletude.getCampoAtomico().get("language");
        }

        Assertions.assertEquals(valorEsperado, atomicosAdicionados);
    }

    @Test
    public void testCalcularCompletudeAtomicosVazios() {
        Assertions.assertEquals(0F, avaliadorCompletude.calcularCompletudeAtomicos(), 0F);
    }
    @Test
    public void testCalcularCompletudeAtomicosApenasUm() {
        avaliadorCompletude.adicionarAtomico("title",  "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils");
        Assertions.assertEquals(0.33F, avaliadorCompletude.calcularCompletudeAtomicos(), 0F);
    }

    @Test
    public void testCalcularCompletudeAtomicosTodos() {
        avaliadorCompletude.adicionarAtomico("title",  "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils");
        avaliadorCompletude.adicionarAtomico("publicationDate", "2003");
        avaliadorCompletude.adicionarAtomico("language", "Inglês");

        Assertions.assertEquals(1F, avaliadorCompletude.calcularCompletudeAtomicos(), 0F);
    }
}
