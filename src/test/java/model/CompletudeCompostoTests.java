package model;

import excecoes.CampoCompostoNuloException;
import excecoes.NomeCampoIsBlankException;
import suites.TesteDeExcecao;
import suites.TesteFuncional;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CompletudeCompostoTests {

    AvaliadorCompletude avaliadorCompletude;
    Object[][] camposCompostos;
    List<Object> valorEsperado;

    @Before
    public void setup() {
        avaliadorCompletude = new AvaliadorCompletude();
    }

    public CompletudeCompostoTests(Object[][] camposCompostos, List<Object> valorEsperado) {
        this.camposCompostos = camposCompostos;
        this.valorEsperado = valorEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        String campo = "authors";
        Object[][] respostas = new Object[][] {
                {new Object[][] {{"authors", new Object[] {}}}, List.of((Object) new Object[]{})},
                {
                    new Object[][] {
                            {"authors", new Object[] {"name", "Sheila Albert dos Reis", "ordemAutoria", "1", "citationName", new String[]{"REIS, S. A."}}},
                    },
                    List.of((Object) new Object[]{"name", "Sheila Albert dos Reis", "ordemAutoria", "1", "citationName", new String[]{"REIS, S. A."}})
                },
                {
                    new Object[][] {
                        {"authors", new Object[] {"name", "Sheila Albert dos Reis", "ordemAutoria", "1", "citationName", new String[]{"REIS, S. A."}}},
                        {"authors", new Object[] {"name", "E. D. C. Cavalcanti", "ordemAutoria", "1", "citationName", new String[]{"CAVALCANTI, E. D. C."}}}
                    },
                    Arrays.asList(
                        (Object) new Object[]{"name", "Sheila Albert dos Reis", "ordemAutoria", "1", "citationName", new String[]{"REIS, S. A."}},
                        (Object) new Object[]{"name", "E. D. C. Cavalcanti", "ordemAutoria", "1", "citationName", new String[]{"CAVALCANTI, E. D. C."}}
                    )
                },
                {
                    new Object[][] {
                        {"authors", new Object[] {"name", "Sheila Albert dos Reis", "ordemAutoria", "1", "citationName", new String[]{"REIS, S. A."}}},
                        {"authors", new Object[] {"name", "E. D. C. Cavalcanti", "ordemAutoria", "1", "citationName", new String[]{"CAVALCANTI, E. D. C."}}},
                        {"authors", new Object[] {
                                "name", "Dulce Helena Gonçalves Orofino",
                                "ordemAutoria", "10",
                                "citationName", new String[]{"OROFINO, D. H. G.",
                                                            "OROFINO, DH",
                                                            "OROFINO, DULCE HELENA GONÇALVES",
                                                            "OROFINO, DULCE H. G.",
                                                            "OROFINO, DULCE"
                                                             },
                                "identifier.lattes", "0009277151089005",
                                "identifier.orcid", "0000-0002-0953-1831",
                                "nationality", "Brasil",
                                "birthCity", "rio de janeiro",
                                "birthState", "RJ",
                                "birthCountry", "Brasil"
                                }
                        }
                    },
                    Arrays.asList(
                        (Object) new Object[]{"name", "Sheila Albert dos Reis", "ordemAutoria", "1", "citationName", new String[]{"REIS, S. A."}},
                        (Object) new Object[]{"name", "E. D. C. Cavalcanti", "ordemAutoria", "1", "citationName", new String[]{"CAVALCANTI, E. D. C."}},
                        (Object) new Object[]{
                                "name", "Dulce Helena Gonçalves Orofino",
                                "ordemAutoria", "10",
                                "citationName", new String[]{"OROFINO, D. H. G.",
                                "OROFINO, DH",
                                "OROFINO, DULCE HELENA GONÇALVES",
                                "OROFINO, DULCE H. G.",
                                "OROFINO, DULCE"
                        },
                                "identifier.lattes", "0009277151089005",
                                "identifier.orcid", "0000-0002-0953-1831",
                                "nationality", "Brasil",
                                "birthCity", "rio de janeiro",
                                "birthState", "RJ",
                                "birthCountry", "Brasil"
                        }
                    )
                }
        };

        return Arrays.asList(respostas);
    }

    @Test
    @Category(TesteFuncional.class)
    public void testAdicionaCamposAtomicos () throws NomeCampoIsBlankException {
        for (Object[] campo: camposCompostos) {
            avaliadorCompletude.adicionarComposto((String) campo[0], campo[1]);
        }

        List<Object> campoCompostoAtual = avaliadorCompletude.getCamposCompostos().get("authors");

        Assertions.assertArrayEquals(valorEsperado.toArray(), campoCompostoAtual.toArray());
    }

    @Test(expected = CampoCompostoNuloException.class)
    @Category(TesteDeExcecao.class)
    public void testCampoCompostoNuloOuExclusivo() throws CampoCompostoNuloException {
        avaliadorCompletude.calcularCompletudeOuExclusivo();
    }

    @Test(expected = CampoCompostoNuloException.class)
    @Category(TesteDeExcecao.class)
    public void testCampoCompostoNuloOuInclusivo() throws CampoCompostoNuloException {
        avaliadorCompletude.calcularCompletudeOuInclusivo();
    }
}
