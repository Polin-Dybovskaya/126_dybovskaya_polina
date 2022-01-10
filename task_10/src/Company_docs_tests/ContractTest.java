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
    public void registerPaymentDocument_RegisterDocumentToContract_DocumentRegistered() throws Exception {
            ContractManager ListOfContracts = ContractManager.create();
            ListOfContracts.addContract(1, 20220110);
            ListOfContracts.addContract(2, 20220111);
            ListOfContracts.registerPaymentDocument(100, 1, DocType.BankOrder, 1, 20220110);
            ListOfContracts.registerPaymentDocument(200, 1, DocType.PaymentOrder, 2, 20220111);
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
    public void getSum_getSumOfPaymentsOfContract_sumEquals1000() throws Exception {
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220101);
        ListOfContracts.registerPaymentDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerPaymentDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.addContract(2, 20220111);
        ListOfContracts.registerPaymentDocument(900, 1, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerPaymentDocument(100, 1, DocType.BankOrder, 2, 20220110);
        assertEquals(1000, ListOfContracts.getContractsList().get(1).getSumOfPayments());
        assertEquals(1000, ListOfContracts.getContractsList().get(2).getSumOfPayments());
    }
}
