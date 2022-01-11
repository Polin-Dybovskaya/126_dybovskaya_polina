package Company_docs_core;

import java.util.Scanner;

public class Programm {
    public void runProgramm() {
            ContractManager ListOfContract = ContractManager.create();
            call(ListOfContract);
    }
    public static void call (ContractManager ListOfContract){
        Scanner sc = new Scanner(System.in);
        CallMenuOfCommands();
        }

    private static void CallMenuOfCommands() {
    }
}

