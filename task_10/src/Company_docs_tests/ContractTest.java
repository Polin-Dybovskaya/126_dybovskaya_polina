package Company_docs_tests;

import Company_docs_core.*;
import org.junit.*;

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
    public void getSum_getSumOfPaymentsOfContract_sumEquals1000(){//потом надо переписать с исключениями!!!!!
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.addContract(2, 20220110);
        //throws Exception НЕ ЗАБЫТЬ
        ListOfContracts.registerDocument(900, 1, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(100, 1, DocType.BankOrder, 2, 20220110);
        assertEquals(1000, ListOfContracts.getContractsList().get(1).getSumOfPayments());
        assertEquals(1000, ListOfContracts.getContractsList().get(2).getSumOfPayments());
    }
    @Test
    public void deletePayment_deletePayment_SummaOfPaymentsEqualsZero(){//потом надо переписать с исключениями
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220110);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(100, 2, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(300, 3, DocType.BankOrder, 1, 20220110);
        ListOfContracts.getContractsList().get(1).deletePayment(1, 1, 20220110);
        ListOfContracts.getContractsList().get(1).deletePayment(2, 1, 20220110);
        ListOfContracts.getContractsList().get(1).deletePayment(3, 1, 20220110);
        assertEquals(0, ListOfContracts.getContractsList().get(1).getSummaOfPayments());
    }
    //
    @Test
    public void deletePayment_deletePayment_SummaOfPaymentsEqualsTheRightNumber(){
        ContractManager ListOfContracts = ContractManager.create();
        ListOfContracts.addContract(1, 20220101);
        ListOfContracts.registerDocument(500, 1, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(100, 2, DocType.BankOrder, 1, 20220110);
        ListOfContracts.registerDocument(300, 3, DocType.BankOrder, 1, 20220110);
//потом надо переписать с throws Exception?
        ListOfContracts.addContract(2, 20220101);
        //ПЕРЕПРОВЕРИТЬ ТЕСТ
        ListOfContracts.registerDocument(100, 1, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(200, 2, DocType.BankOrder, 2, 20220110);
        ListOfContracts.registerDocument(300, 3, DocType.BankOrder, 2, 20220110);
//упростить суммы
        ListOfContracts.getContractsList().get(1).deletePayment(1, 1, 20220110);
        assertEquals(2, ListOfContracts.getContractsList().get(1).getSummaOfPayments());
        ListOfContracts.getContractsList().get(2).deletePayment(3, 1, 20220110);
        ListOfContracts.getContractsList().get(2).deletePayment(1, 1, 20220110);
        assertEquals(1, ListOfContracts.getContractsList().get(2).getSummaOfPayments());
    }
    @Test
    public void getPayments_getListOfPaymentsOfContract_gotListOfPayments(){//??? not work???
        ContractManager ListOfContracts= ContractManager.create();
        ListOfContracts.addContract(1, 20220101);
        ListOfContracts.registerDocument(100, 1, DocType.BankOrder, 1, 20220110);
        PaymentDocs one = new PaymentDocs(100, DocType.BankOrder, 20220110);
        ListOfContracts.registerDocument(200, 2, DocType.BankOrder, 1, 20220110);
        PaymentDocs two = new PaymentDocs(200, DocType.BankOrder, 20220110);
        ListOfContracts.registerDocument(300, 3, DocType.BankOrder, 1, 20220110);
        PaymentDocs three = new PaymentDocs(300, DocType.BankOrder, 20220110);
        HashMap<Integer, PaymentDocs> docsList = new HashMap<Integer, PaymentDocs>();
        docsList.put(1, one);
        docsList.put(2, two);
        docsList.put(3, three);
        assertEquals(docsList, ListOfContracts.getContractsList().get(1).getListOfPayments());
    }
}

