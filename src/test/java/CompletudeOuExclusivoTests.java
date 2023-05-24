import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CompletudeOuExclusivoTests {
    AvaliadorCompletude avaliadorCompletude;
    Object[][] camposCompostos;
    int completudeEsperada;

    @Before
    public void setup() {
        avaliadorCompletude = new AvaliadorCompletude();
    }

    public CompletudeOuExclusivoTests(Object[][] camposCompostos, int completudeEsperada) {
        this.camposCompostos = camposCompostos;
        this.completudeEsperada = completudeEsperada;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        String campo = "authors";
        Object[][] respostas = new Object[][] {
                {new Object[][] {{"authors", new Object[] {}}}, 0},
                {
                        new Object[][] {
                                {
                                    "authors", new Object[]{
                                                            "name", "Dulce Helena Gonçalves Orofino",
                                                            "ordemAutoria", "10",
                                                            "identifier.lattes", "0009277151089005",
                                                            "nationality", "Brasil",
                                                            "birthCity", "rio de janeiro",
                                                            "birthState", "RJ",
                                                            "birthCountry", "Brasil"
                                                    }
                                }
                        }, 1
                },
                {
                        new Object[][] {
                                {
                                        "authors", new Object[]{
                                                                "name", "Dulce Helena Gonçalves Orofino",
                                                                "ordemAutoria", "10",
                                                                "identifier.orcid", "0009277151089005",
                                                                "nationality", "Brasil",
                                                                "birthCity", "rio de janeiro",
                                                                "birthState", "RJ",
                                                                "birthCountry", "Brasil"
                                                            }
                                }
                        }, 1
                },
                {
                        new Object[][] {
                                {
                                        "authors", new Object[]{
                                        "name", "Dulce Helena Gonçalves Orofino",
                                        "ordemAutoria", "10",
                                        "identifier.lattes", "0009277151089005",
                                        "identifier.orcid", "0009277151089005",
                                        "nationality", "Brasil",
                                        "birthCity", "rio de janeiro",
                                        "birthState", "RJ",
                                        "birthCountry", "Brasil"
                                }
                                }
                        }, 0
                }
        };

        return Arrays.asList(respostas);
    }

    @Test
    public void testCalcularCompletudeOuExclusivo () {
        for (Object[] campo: camposCompostos) {
            avaliadorCompletude.adicionarComposto((String) campo[0], campo[1]);
        }

        int completudeAtual = avaliadorCompletude.calcularCompletudeOuExclusivo();

        Assertions.assertEquals(completudeEsperada, completudeAtual);
    }
}
