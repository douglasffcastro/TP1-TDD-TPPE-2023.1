package model;

import excecoes.NomeCampoIsBlankException;
import suites.TesteDeExcecao;
import suites.TesteFuncional;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CompletudeAtomicoTests {

    AvaliadorCompletude avaliadorCompletude;
    Object[][] camposAtomicos;
    String valorEsperado;
    int completudeEsperada;

    @Before
    public void setup() {
        avaliadorCompletude = new AvaliadorCompletude();
    }

    public CompletudeAtomicoTests(Object[][] camposAtomicos, String valorEsperado, int completudeEsperada) {
        this.camposAtomicos = camposAtomicos;
        this.valorEsperado = valorEsperado;
        this.completudeEsperada = completudeEsperada;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] respostas = new Object[][] {
                {new Object[][] {}, "", 0
                },
                {new Object[][] {
                    {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                }, "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils", 1},
                {new Object[][] {
                    {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                    {"publicationDate", "2003"}
                }, "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils2003", 2},
                {new Object[][] {
                    {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                    {"publicationDate", "2003"},
                    {"language", "Inglês"}
                }, "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils2003Inglês", 3}
        };

        return Arrays.asList(respostas);
    }

    @Test
    @Category(TesteFuncional.class)
    public void testAdicionaCamposAtomicos () throws NomeCampoIsBlankException {
        for (Object[] campo: camposAtomicos) {
            avaliadorCompletude.adicionarAtomico((String) campo[0], (String) campo[1]);
        }

        String atomicosAdicionados = "";
        if (avaliadorCompletude.getCamposAtomicos().get("title") != null) {
            atomicosAdicionados = avaliadorCompletude.getCamposAtomicos().get("title");
        }
        if (avaliadorCompletude.getCamposAtomicos().get("publicationDate") != null) {
            atomicosAdicionados +=  avaliadorCompletude.getCamposAtomicos().get("publicationDate");
        }
        if (avaliadorCompletude.getCamposAtomicos().get("language") != null){
            atomicosAdicionados += avaliadorCompletude.getCamposAtomicos().get("language");
        }

        Assertions.assertEquals(valorEsperado, atomicosAdicionados);
    }

    @Test
    @Category(TesteFuncional.class)
    public void testCalcularCompletudeAtomicos() throws NomeCampoIsBlankException {
        for (Object[] campo: camposAtomicos) {
            avaliadorCompletude.adicionarAtomico((String) campo[0], (String) campo[1]);
        }

        Assertions.assertEquals(completudeEsperada, avaliadorCompletude.calcularCompletudeAtomicos());
    }

    @Test(expected = NomeCampoIsBlankException.class)
    @Category(TesteDeExcecao.class)
    public void testNomeCampoEmBrancoAtomico() throws NomeCampoIsBlankException {
        avaliadorCompletude.adicionarAtomico("", "O título");
    }

    @Test(expected = NomeCampoIsBlankException.class)
    @Category(TesteDeExcecao.class)
    public void testNomeCampoEmBrancoComposto() throws NomeCampoIsBlankException {
        avaliadorCompletude.adicionarComposto("", new Object());
    }
}
