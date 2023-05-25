package suites;

import model.*;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({
        CompletudeAtomicoTests.class,
        CompletudeCompostoTests.class,
        CompletudeOuExclusivoTests.class,
        CompletudeOuInclusivoTests.class,
        CompletudeMultiCamposTests.class
})
@IncludeCategory(TesteFuncional.class)
public class SuiteTestesFuncionais {}