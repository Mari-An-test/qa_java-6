import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionTest {
    @Mock
    Feline feline;
    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void doesHaveManeReturnCorrectValue() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void doesHaveManeMaleReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("Самец doesHaveMane() должен вернуть true", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemaleReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse("Самка doesHaveMane() должен вернуть false", lion.doesHaveMane());
    }
}
