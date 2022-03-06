import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PolynomialAdditionTest.class, PolynomialSubtractionTest.class,
        PolynomialMultiplicationTest.class,PolynomialDivisionTest.class,
        PolynomialDerivativeTest.class,PolynomialIntegrationTest.class,
        PolynomialBuilderTest.class
})
public class PolynomialTestSuite {
}
