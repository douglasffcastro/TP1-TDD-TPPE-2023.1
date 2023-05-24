import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CompletudeAtomicoTests.class,
        CompletudeCompostoTests.class,
        CompletudeOuExclusivoTests.class,
        CompletudeOuInclusivoTests.class,
        CompletudeMultiCamposTests.class
})
public class TestSuite {
}
