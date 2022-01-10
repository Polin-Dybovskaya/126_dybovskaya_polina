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


}
