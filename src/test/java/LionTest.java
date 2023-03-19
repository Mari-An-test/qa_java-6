import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, actualHasMane);
    }
    @Test
    public void testGetFoodReturnListEatOfMeat() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
