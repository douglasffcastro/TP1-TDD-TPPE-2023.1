import suites.SuiteTestesDeExcecao;
import suites.SuiteTestesFuncionais;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({SuiteTestesFuncionais.class, SuiteTestesDeExcecao.class})
public class AllTestes {}