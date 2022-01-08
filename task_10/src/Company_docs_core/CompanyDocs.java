package Company_docs_core;

public class CompanyDocs {
    private int contractCount;
    private CompanyDocs(){
        contractCount=0;
    }
    public void addContract(String number, String data){
        contractCount++;

    }
    public int getContractsCount(){
        return contractCount;
    }

    public static CompanyDocs create(){
        return new CompanyDocs();
    }
}