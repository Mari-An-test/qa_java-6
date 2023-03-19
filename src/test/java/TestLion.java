import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)

public class TestLion {
    @Mock
    Feline feline;

    @Test
    public void testGetKittensReturnOne() throws Exception {
        int expected = 1;
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(expected, lion.getKittens());
    }


    @Test
    public void testDoesHeHaveManeException() {
        String sex = "другой";
        String expected = "Используйте допустимые значения пола животного - самец или самка";

        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(sex, feline);
            lion.doesHaveMane();
        });
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void testGetFoodReturnListEatOfMeat() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
