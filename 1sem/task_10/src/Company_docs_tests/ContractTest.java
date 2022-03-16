package Company_docs_tests;

import Company_docs_core.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

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
    public void registerDocument_RegisterDocumentToContract_DocumentRegistered() throws Exception{
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.addContract(2, 20770211);
        ListOfContracts.registerDocument(100, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(123, 1, DocType.PaymentOrder, 2, 20220111);
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
    public void getSum_getSumOfPaymentsOfContract_sumEquals1000() throws Exception{//+
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.addContract(2, 20220110);
        //
        ListOfContracts.registerDocument(900, 1, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(100, 1, DocType.BankOrder, 2, 20220110);
        assertEquals(1000, ListOfContracts.getContractsList().get(1).getSumOfPayments());
        assertEquals(1000, ListOfContracts.getContractsList().get(2).getSumOfPayments());
    }
    @Test
    public void deletePayment_deletePayment_SummaOfPaymentsEqualsZero() throws Exception{//+
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(100, 2, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(300, 3, DocType.BankOrder, 1, 20220110);
        ListOfContracts.getContractsList().get(1).deletePayment(1);
        ListOfContracts.getContractsList().get(1).deletePayment(2);
        ListOfContracts.getContractsList().get(1).deletePayment(3);
        assertEquals(0, ListOfContracts.getContractsList().get(1).getSummaOfPayments());
    }
    //
    @Test
    public void deletePayment_deletePayment_SummaOfPaymentsEqualsTheRightNumber() throws Exception{
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220101);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(100, 2, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(300, 3, DocType.BankOrder, 1, 20220110);
//потом надо переписать с throws Exception?
        ListOfContracts.addContract(2, 20220101);
        //ПЕРЕПРОВЕРИТЬ ТЕСТ
        ListOfContracts.registerDocument(111, 1, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(222, 2, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(333, 3, DocType.BankOrder, 2, 20220110);
//упростить суммы
        ListOfContracts.getContractsList().get(1).deletePayment(1);
        assertEquals(2, ListOfContracts.getContractsList().get(1).getSummaOfPayments());
        ListOfContracts.getContractsList().get(2).deletePayment(3);
        ListOfContracts.getContractsList().get(2).deletePayment(1);
        assertEquals(1, ListOfContracts.getContractsList().get(2).getSummaOfPayments());
    }
    @Test
    public void getPayments_getListOfPaymentsOfContract_gotListOfPayments() throws Exception{
        ContractManager ListOfContracts= ContractManager.create();
        ListOfContracts.addContract(1, 20220101);
        ListOfContracts.registerDocument(111, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(222, 2, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(333, 3, DocType.BankOrder, 1, 20220110);
        ArrayList<Integer> payments = new ArrayList<>();
        payments.add(111);
        payments.add(222);
        payments.add(333);
        assertEquals(payments, ListOfContracts.getContractsList().get(1).getListOfPayments());
    }
    @Test
    public void getContracts_getListOfContractsWithTheirTotalSum_gotListOfContracts() throws Exception {
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220101);
        ListOfContracts.registerDocument(111, 1, DocType.BankOrder, 1, 20220101);
        ListOfContracts.registerDocument(222, 2, DocType.BankOrder, 1, 20220101);
        ListOfContracts.registerDocument(333, 3, DocType.BankOrder, 1, 20220101);

        ListOfContracts.addContract(2, 20220101);
        ListOfContracts.registerDocument(1, 1, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(2, 2, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(3, 3, DocType.BankOrder, 2, 20220110);

        HashMap<Integer, Integer> contracts = new HashMap<>();
        contracts.put(1, 666);
        contracts.put(2, 6);

        assertEquals(contracts, ListOfContracts.getListOfContractsWithPayments());
    }
        @Test
        public void getListOfAllPayments_getListOfAllPayments_gotListOfAllPayments() throws Exception {
            ContractManager ListOfContracts = ContractManager.create();
            ListOfContracts.addContract(1, 20220110);
            ListOfContracts.registerDocument(111, 1, DocType.BankOrder, 1, 20220110);
            ListOfContracts.registerDocument(222, 2, DocType.BankOrder, 1, 20220110);
            ListOfContracts.registerDocument(333, 3, DocType.BankOrder, 1, 20220110);

            ListOfContracts.addContract(2, 20220110);
            ListOfContracts.registerDocument(1, 1, DocType.BankOrder, 2, 20220110);
            ListOfContracts.registerDocument(2, 2, DocType.BankOrder, 2, 20220110);
            ListOfContracts.registerDocument(3, 3, DocType.BankOrder, 2, 20220110);

            ArrayList<Integer> pays = new ArrayList<>();
            pays.add(111);
            pays.add(222);
            pays.add(333);
            pays.add(1);
            pays.add(2);
            pays.add(3);

            assertEquals(pays, ListOfContracts.getListOfAllPayments());
        }
}

