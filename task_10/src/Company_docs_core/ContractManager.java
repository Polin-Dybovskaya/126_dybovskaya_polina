package Company_docs_core;

import java.util.HashMap;

import java.util.ArrayList;

public class ContractManager {
    private HashMap<Integer, Contract> ListOfContract;

    public HashMap<Integer, Contract> getContractsList() {
        return ListOfContract;
    }


    private ContractManager() {
        ListOfContract = new HashMap<Integer, Contract>();
    }

    public void addContract(Integer number, Integer date) throws Exception{
        if (ListOfContract.containsKey(number)) {
            throw new Exception("Договор с таким номером уже заключён");
        } else {
            if (number > 0 && String.valueOf(date).length() == 8) {
                ListOfContract.put(number, new Contract(date));
                System.out.println("Договор №" + number + " был успешно заключён.");
            } else {
                throw new Exception("Введённые данные некорректны, пожалуйста, уточните данные.");
            }
        }
    }
    public static ContractManager create() {
        return new ContractManager();
    }

    public int getContractsCount() {
        return ListOfContract.size();
    }

    public void registerDocument(int sum, int number, DocType docType, int contractNumber, int date) throws Exception{
        if (ListOfContract.get(contractNumber).getListOfDocsNumbers().contains(number)) {
            throw new Exception("Документ с таким номером уже существует, пожалуйста, уточните данные.");
        }
        else {
            if (sum > 0 && number > 0 && contractNumber > 0 && String.valueOf(date).length() == 8) {
                ListOfContract.get(contractNumber).registerPaymentDocument(sum, number, docType, date);
                System.out.println(docType + " на сумму " + sum + " был успешно произведёно");
            } else {
                throw new Exception("Введённые данные некоректны, пожалуйста, уточните данные.");
            }
        }
        System.out.println();
    }


    public HashMap<Integer, Integer> getListOfContractsWithPayments() {
        HashMap<Integer, Integer> cons = new HashMap<>();
        ListOfContract.forEach((k ,v ) -> cons.put(k , v.getSumOfPayments()));
        return cons;
    }

    public ArrayList<Integer> getListOfAllPayments(){
        ArrayList<ArrayList<Integer>> pays = new ArrayList<>();
        ListOfContract.forEach((k ,v ) -> pays.add(v.getListOfPayments()));
        ArrayList<Integer> payments = new ArrayList<>();
        for (ArrayList<Integer> pay : pays) {
            payments.addAll(pay);
        }
        return payments;
    }
}