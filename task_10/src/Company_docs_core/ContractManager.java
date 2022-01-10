package Company_docs_core;

import java.util.HashMap;

public class ContractManager {
    private HashMap<String, Contract> ListOfContracts;

    private ContractManager(){
        ListOfContracts = new HashMap<String, Contract>();
    }

    public void addContract(String number, String date){
        if (number != null) {
            ListOfContracts.put(number, new Contract(date));
        }
    }

    public static ContractManager create(){
        return new ContractManager();
    }

    public int getContractsCount(){
        return ListOfContracts.size();
    }
}
