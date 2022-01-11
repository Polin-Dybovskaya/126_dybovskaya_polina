package Company_docs_tests;

import Company_docs_core.*;
import org.junit.*;

public class ContractTest extends Assert {
    @Test
    public void create_CreateContractsList_ContractsListSizeEqualsZero() {
        ContractManager ListOfContracts = ContractManager.create();
        assertEquals(0, ListOfContracts.getContractsCount());
    }

    @Test
    public void addContract_AddContractWithNumberAndDate_ContractsListSizeEqualsOne() throws Exception {
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.addContract(null, 20220110);
        assertEquals(1, ListOfContracts.getContractsCount());
    }

    @Test
    public void registerDocument_RegisterDocumentToContract_DocumentRegistered(){
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.addContract(2, 20770211);
        ListOfContracts.registerDocument(100, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(200, 1, DocType.PaymentOrder, 2, 20770211);
        assertEquals(1, ListOfContracts.getContractsList().get(1).getDocumentsListSize());
        assertEquals(1, ListOfContracts.getContractsList().get(2).getDocumentsListSize());
        }
    @Test
    public void getSum_getSumOfPaymentsOfContract_sumEqualsZero () throws Exception {
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        assertEquals(0, ListOfContracts.getContractsList().get(1).getSumOfPayments());
    }

}

