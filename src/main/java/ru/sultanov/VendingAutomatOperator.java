package ru.sultanov;

import java.util.InputMismatchException;
import java.util.logging.LogManager;
import java.util.logging.*;

public class VendingAutomatOperator {

    public int cash = 0;

    public void viewMainMenu() {
        System.out.println("\nНа вашем счете - " + cash + " рублей.\n " +
                "Введите цифру для действия:\n1 - Посмотреть меню" +
                " напитков\n2 - Внести деньги\n3 - Купить напиток\n" +
                "4 - Выйти");
    }

    public void viewDrinkMenu() {
        for (Drinks d : Drinks.values()) {
            System.out.println(d.getPosition() + "." + d.getName() +
                    "........." + d.getPrice() + " рублей");
        }
    }

    public void addMoney(int addedMoney)  throws InputMismatchException {
        System.out.println("Введите сумму в рублях");
        cash += addedMoney;
    }

    public void buyDrink(int drinkNumber) throws InputMismatchException {
        System.out.println("Введите позиционный номер напитка");
        if (drinkNumber > 6) {
            System.out.println("Напитка под этим номером нет");
            VendingAutomat.LOGGER.log(Level.WARNING,"Введен некорректный номер напитка");
        }
        for (Drinks d : Drinks.values()) {
            if (d.getPosition() == drinkNumber) {
                if (cash >= d.getPrice()) {
                    cash -= d.getPrice();
                } else {
                    System.out.println("Недостаточно средств");
                    VendingAutomat.LOGGER.log(Level.WARNING,"Нет средств для покупки");
                }

            }
        }

    }

}
