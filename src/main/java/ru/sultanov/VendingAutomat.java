package ru.sultanov;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class VendingAutomat {

    public static Logger LOGGER;

    public static void main(String[] args) throws IOException, InputMismatchException {

        LogManager.getLogManager().readConfiguration(VendingAutomat.class.getClassLoader().getResourceAsStream("logging.properties"));
        LOGGER = Logger.getLogger(VendingAutomat.class.getName());
        FileHandler fh = new FileHandler("/Users/askarsultanov/Desktop/log.txt");
        LOGGER.addHandler(fh);
        int userChoice = 0; // Выбор в меню пользователя
        VendingAutomatOperator operator = new VendingAutomatOperator();


        try {
                while (userChoice != 4) {// Пока не выбран пункт "Выйти", выполнять программу
                    try {
                        operator.viewMainMenu();
                        Scanner sc = new Scanner(System.in);
                        userChoice = sc.nextInt();

                        switch (userChoice) {
                            case 1:
                                LOGGER.log(Level.INFO, "Запрос на просмотр меню");
                                operator.viewDrinkMenu();
                                break;
                            case 2:
                                LOGGER.log(Level.INFO, ("Запрос на внесение денег"));
                                System.out.println("Введите сумму в рублях");
                                operator.addMoney(sc.nextInt());
                                LOGGER.log(Level.INFO, "Деньги внесены");
                                break;
                            case 3:
                                LOGGER.log(Level.INFO, "Запрос на покупку товара");
                                System.out.println("Введите номер позиции напитка");
                                operator.buyDrink(sc.nextInt());
                                break;
                        }
                    } catch (InputMismatchException e1) {
                        LOGGER.log(Level.SEVERE,"Некорректный ввод");
                    }
                }
            LOGGER.log(Level.INFO, "Выход из системы");
        }catch(InputMismatchException e2) {
            LOGGER.log(Level.SEVERE,"Некорректный ввод в меню");
        }
    }
}

