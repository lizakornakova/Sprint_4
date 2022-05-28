import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedAccountTest {

    private final String name;
    private final boolean expectedResult;

    public ParameterizedAccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    // передали тестовые данные
    @Parameterized.Parameters
    public static Object[] getName() {
        return new Object[][] {
                { "Тимоти Шаламе", true}, //длина строки между 3 и 19 (внутри КЭ)
                { "Т Ш", true}, // длина строки 3 символа (граница КЭ)
                { "Елизавета Вороноова", true}, // длина строки 19 символов (граница КЭ)
                { "Елизавета Лебедева-Кумачева", false}, // длина строки больше 19 символов (вне КЭ)
                { "Елизавета Воронооова", false}, // длина строки 20 символов (граница КЭ+значение на границе)
                { "По", false}, // длина строки меньше 3 символов (вне КЭ+значение на границе)
                { " Тимоти Шаламе", false}, // пробел в начале строки
                { "Тимоти Шаламе ", false}, // пробел в конце строки
                { null, false}, // значение null
                { "ТимотейШевроле", false}, // нет хотя бы 1 пробела
                { "Тимотей   Шевроле", false}, // два пробела в середине
        };
    }

    @Test
    public void checkingNameForCorrectness() {
        Account account = new Account(name);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals(expectedResult, actualResult); // сравнили ожидаемый и фактический результат
    }

}