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
    @Test
    public void getSum_getSumOfPaymentsOfContract_sumEquals1000(){
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.addContract(2, 20220110);
        ListOfContracts.registerDocument(900, 1, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(100, 1, DocType.BankOrder, 2, 20220110);
        assertEquals(1000, ListOfContracts.getContractsList().get(1).getSumOfPayments());
        assertEquals(1000, ListOfContracts.getContractsList().get(2).getSumOfPayments());
    }
    @Test
    public void deletePayment_deletePayment_SummaOfPaymentsEqualsZero(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220110);
        contractsList.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        contractsList.registerDocument(100, 2, DocType.BankOrder, 1, 20220110);
        contractsList.registerDocument(300, 3, DocType.BankOrder, 1, 20220110);
        contractsList.getContractsList().get(1).deletePayment(1, 1, 20220110);
        contractsList.getContractsList().get(1).deletePayment(2, 1, 20220110);
        contractsList.getContractsList().get(1).deletePayment(3, 1, 20220110);
        assertEquals(0, contractsList.getContractsList().get(1).getSummaOfPayments());
    }
    @Test
    public void deletePayment_deletePayment_AmountOfPaymentsEqualsTheRightNumber(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        contractsList.registerDocument(500, 1, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(133, 2, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(333, 3, DocType.BankOrder, 1, 20220101);

        contractsList.addContract(2, 20220101);
        contractsList.registerDocument(11, 1, DocType.BankOrder, 2, 20220101);
        contractsList.registerDocument(22, 2, DocType.BankOrder, 2, 20220101);
        contractsList.registerDocument(33, 3, DocType.BankOrder, 2, 20220101);

        contractsList.getContractsList().get(1).deletePayment(1, 1, 20220101);
        assertEquals(2, contractsList.getContractsList().get(1).getSummaOfPayments());

        contractsList.getContractsList().get(2).deletePayment(3, 1, 20220101);
        contractsList.getContractsList().get(2).deletePayment(1, 1, 20220101);
        assertEquals(1, contractsList.getContractsList().get(2).getSummaOfPayments());
    }
}

