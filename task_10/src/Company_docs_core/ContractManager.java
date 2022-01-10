package Company_docs_core;

import java.util.HashMap;

public class ContractManager {
    private HashMap<Integer, Contract>  ListOfContract;

    public HashMap<Integer, Contract> getContractsList(){
        return ListOfContract;
    }


    private ContractManager(){
        ListOfContract = new HashMap<Integer, Contract>();
    }

    public void addContract(Integer number, Integer date){
        if (number != null) {
            ListOfContract.put(number, new Contract(date));
        }
    }

    public static ContractManager create(){
        return new ContractManager();
    }

    public int getContractsCount(){
        return ListOfContract.size();
    }
    public void registerPaymentDocument(int sum, int number, DocType docType, int contractNumber, int date) {
        ListOfContract.get(contractNumber).registerPaymentDocument(sum, number, docType, date);

    }

}