package Company_docs_core;

import java.util.Scanner;

public class Program {
    public void runProgram() {
        ContractManager ListOfContracts = ContractManager.create();
        call(ListOfContracts);
    }

    public static void call(ContractManager ListOfContracts){
        Scanner sc = new Scanner(System.in);
        callMenu();
        try {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("Введите номер договора и дату (дата состоит из 8 цифр подряд ГГГГММДД)");
                try {
                    ListOfContracts.addContract(sc.nextInt(), sc.nextInt());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен, пожалуйста, уточните данные и попытайтесь заново.");
                }
                System.out.println();
                call(ListOfContracts);

            } else if (n == 2) {
                try {
                    System.out.println("Введите сумму платежа, номер документа, тип документа(BankOrder или PaymentOrder), номер договора и дату");
                    ListOfContracts.registerDocument(sc.nextInt(), sc.nextInt(), DocType.valueOf(sc.next()), sc.nextInt(), sc.nextInt());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен, пожалуйста, уточните данные и попытайтесь заново.");
                }
                System.out.println();
                call(ListOfContracts);

            } else if (n == 3) {
                try {
                    System.out.println("Введите номер договора");
                    System.out.println(ListOfContracts.getContractsList().get(sc.nextInt()).getListOfPayments());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен, пожалуйста, уточните данные и попытайтесь заново.");
                }
                System.out.println();
                call(ListOfContracts);

            } else if (n == 4) {
                try {
                    System.out.println("Введите номер договора");
                    System.out.println(ListOfContracts.getContractsList().get(sc.nextInt()).getSumOfPayments());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен, пожалуйста, уточните данные и попытайтесь заново.");
                }
                System.out.println();
                call(ListOfContracts);

            } else if (n == 5) {
                try {
                    System.out.println("Введите номер договора и номер платежа");
                    ListOfContracts.getContractsList().get(sc.nextInt()).deletePayment(sc.nextInt());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен, пожалуйста, уточните данные и попытайтесь заново.");
                }
                System.out.println();
                call(ListOfContracts);

            } else if (n == 6) {
                try {
                    System.out.println(ListOfContracts.getListOfContractsWithPayments());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен, пожалуйста, уточните данные и попытайтесь заново.");
                }
                System.out.println();
                call(ListOfContracts);

            } else if (n == 7) {
                try {
                    System.out.println(ListOfContracts.getListOfAllPayments());
                } catch (Exception e) {
                    System.out.println(ListOfContracts.getListOfAllPayments());
                }
                System.out.println();
                call(ListOfContracts);

            } else {
                System.out.println("Введенные данные неверны, пожалуйста, уточните данные и попытайтесь заново.");
                System.out.println();
                call(ListOfContracts);
            }
        }
        catch (Exception e){
            System.out.println("Формат введённых данных неверен, пожалуйста, уточните данные и попытайтесь заново.");
            System.out.println();
            call(ListOfContracts);
        }
    }
    public static void callMenu(){
        System.out.println("Система учёта платежей по договорам, (ввод дынных осуществлять через пробел)");
        System.out.println("1. Заключить договор");
        System.out.println("2. Регистрирование платежного документа");
        System.out.println("3. Поиск всех платежей по договору с заданным номером");
        System.out.println("4. Вычисление суммы всех платежей по договору с заданным номером");
        System.out.println("5. Удаление платежей с заданным номером, номером договора и датой");
        System.out.println("6. Получение списка всех договоров с их суммарными суммами платежей");
        System.out.println("7. Получить список всех платежей");
    }
}