package Company_docs_core;


public class CompanyDocs {
    private int contractsCount;
    private CompanyDocs(){
        contractsCount=0;
    }
    public void addContract(String number, String date){

    }
    public int getContractsCount(){
        return 0;
    }
    public static CompanyDocs create(){
        return new CompanyDocs();
    }
}