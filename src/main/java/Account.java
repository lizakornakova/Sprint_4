import java.util.regex.Pattern;

public class Account {

    private final String name;
    private final Pattern cardPattern = Pattern.compile("(?=(^\\S+\\s\\S+$))(.{3,19})"); //паттерн регулярка для надписи на карте


    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Метод проверяет что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        return name!=null && cardPattern.matcher(name).matches();
    }

}