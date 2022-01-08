package Company_docs_tests;

import Company_docs_core.CompanyDocs;
import org.junit.*;


public class CompanyDocsTest extends Assert{
    @Test
    public void create_CreateCompanyDocs_ContractsCountEqualsZero() {
        CompanyDocs companyDocs = CompanyDocs.create();
        assertEquals(0, companyDocs.getContractsCount());
    }
}
