package Company_docs_tests;

import Company_docs_core.CompanyDocs;
import org.junit.*;

public class CompanyDocsTest extends Assert {
    @Test
    public void create_CreateCompanyDocs_ContractsCountEqualsZero() {
        CompanyDocs companyDocs = CompanyDocs.create();
        assertEquals(0, companyDocs.getContractsCount());
    }

    @Test
    public void addContract_AddContractsWithNumberAndData_ContractsCountEqualsOne() {
        CompanyDocs companyDocs = CompanyDocs.create();
        companyDocs.addContract("number", "data");
        assertEquals(1, companyDocs.getContractsCount());
    }

    @Test
    public void addContract_AddContractsWithNullNumber_ThrowsException() {
        CompanyDocs companyDocs = CompanyDocs.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> companyDocs.addContract(null, "date"));
        assertTrue(exc.getMessage().toLowerCase().contains("number can't be null"));
    }
    @Test
    public void addContract_AddContractsWithNullData_ThrowsException() {
        CompanyDocs companyDocs = CompanyDocs.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> companyDocs.addContract("number",null));
        assertTrue(exc.getMessage().toLowerCase().contains("data can't be null"));
    }
}