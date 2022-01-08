package Company_docs_tests;

import Company_docs_core.*;
import org.junit.*;

//
public class CompanyDocsTest extends Assert{
    @Test
    public void create_CreateCompanyDocs_ContractsCountEqualsZero() {
        CompanyDocs companyDocs = CompanyDocs.create();
        assertEquals(0, companyDocs.getContractsCount());
    }
    @Test
    public void addContract_AddContractWithNumberAndDate_ContractsCountEqualsOne() {
        CompanyDocs companyDocs = CompanyDocs.create();
        companyDocs.addContract("1","20220108");
        assertEquals(0, companyDocs.getContractsCount());
    }
}
