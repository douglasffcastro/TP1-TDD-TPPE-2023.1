import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CompletudeMultiCamposTests {
    AvaliadorCompletude avaliadorCompletude;
    Object[][] campos;
    float completudeEsperada;

    @Before
    public void setup() {
        avaliadorCompletude = new AvaliadorCompletude();
    }

    public CompletudeMultiCamposTests(Object[][] campos, float completudeEsperada) {
        this.campos = campos;
        this.completudeEsperada = completudeEsperada;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] respostas = new Object[][] {
                {new Object[][] {
                        {"type", "journal article"},
                        {"volume", "37"},
                        {"startPage", "138"},
                        {"endPage", "143"},
                        {"authors", new Object[] {"name", "Dulce Helena Gonçalves Orofino", "ordemAutoria", "10"}}
                }, 0F},
                {
                    new Object[][] {
                        {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                        {"publicationDate", "2003"},
                        {"language", "Inglês"},
                        {"authors", new Object[] {"name", "Dulce Helena Gonçalves Orofino",
                                "ordemAutoria", "10",
                                "identifier.lattes", "0009277151089005",
                                "nationality", "Brasil",
                                "birthCity", "rio de janeiro",
                                "birthState", "RJ",
                                "birthCountry", "Brasil"}}
                    },  100F
                },
                {
                    new Object[][] {
                        {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                        {"publicationDate", "2003"},
                        {"authors", new Object[] {"name", "Dulce Helena Gonçalves Orofino",
                                                  "ordemAutoria", "10",
                                                  "birthCountry", "Brasil"}
                        }
                    }, 60F
                },
                {new Object[][] {
                        {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                }, 20F},
                {new Object[][] {
                        {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                        {"authors", new Object[] {"name", "Dulce Helena Gonçalves Orofino",
                                "ordemAutoria", "10",
                                "identifier.lattes", "0009277151089005"}
                        }
                }, 40F},
                {new Object[][] {
                        {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                        {"publicationDate", "2003"},
                        {"language", "Inglês"},
                        {"authors", new Object[] {"name", "Dulce Helena Gonçalves Orofino",
                                "ordemAutoria", "10",
                                "identifier.lattes", "0009277151089005"}
                        }
                }, 80F},
                {new Object[][] {
                        {"title", "Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils"},
                        {"publicationDate", "2003"},
                        {"language", "Inglês"},
                        {"authors", new Object[] {"name", "Dulce Helena Gonçalves Orofino",
                                                  "ordemAutoria", "10",
                                                  "identifier.lattes", "0009277151089005",
                                                  "identifier.orcid",
                                                  "nationality", "Brasil",
                                                 }
                        }
                }, 80F}
        };

        return Arrays.asList(respostas);
    }

    @Test
    public void testAdicionaCamposAtomicos () {
        for (Object[] campo: campos) {
            if (campo[0] == "authors") {
                avaliadorCompletude.adicionarComposto((String) campo[0], campo[1]);
            } else {
                avaliadorCompletude.adicionarAtomico((String) campo[0], (String) campo[1]);
            }

        }

        float completudeAtual = avaliadorCompletude.calcularCompletudeMultiCampos();

        Assertions.assertEquals(completudeEsperada, completudeAtual, 0F);
    }
}
