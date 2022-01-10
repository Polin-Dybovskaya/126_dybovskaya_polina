package Company_docs_tests;

import Company_docs_core.*;
import org.junit.*;

public class CompanyDocsTest extends Assert {
    @Test
    public void create_CreateCompanyDocs_ContractsCountEqualsZero() {
        CompanyContracts companyDocs = CompanyContracts.create();
        assertEquals(0, companyDocs.getContractsCount());
    }

    @Test
    public void addContract_AddContractsWithNumberAndData_ContractsCountEqualsOne() {
        CompanyContracts companyDocs = CompanyContracts.create();
        companyDocs.addContract("number", "date");
        assertEquals(1, companyDocs.getContractsCount());
    }

    @Test
    public void addContract_AddContractsWithNullNumber_ThrowsException() {
        CompanyContracts companyDocs = CompanyContracts.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> companyDocs.addContract(null, "date"));
        assertTrue(exc.getMessage().toLowerCase().contains("Number cannot be null"));
    }
    @Test
    public void addContract_AddContractsWithNullData_ThrowsException() {
        CompanyContracts companyDocs = CompanyContracts.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> companyDocs.addContract("number",null));
        assertTrue(exc.getMessage().toLowerCase().contains("Date cannot be null"));
    }
    @Test
    public void addContract_AddContractsWithNullDataAndNullNumber_ThrowsException() {
        CompanyContracts companyDocs = CompanyContracts.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> companyDocs.addContract(null,null));
        assertTrue(exc.getMessage().toLowerCase().contains("number and date can't be null"));
    }

}