public class Praktikum {

    public static void main(String[] args) {
        String ownersName = "Василий Пупкин";
        Account account = new Account(ownersName); //Создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
        account.checkNameToEmboss(); //Вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
    }

}
