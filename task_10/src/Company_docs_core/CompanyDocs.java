package Company_docs_core;

public class CompanyDocs {
    private int contractCount;
    private CompanyDocs(){
        contractCount=0;
    }
    public void addContract(String number, String data) {
        if(number==null)
            throw new IllegalArgumentException("Number can't be null");
        if(data==null)
            throw new IllegalArgumentException("Data can't be null");
        contractCount++;

    }
    public int getContractsCount(){
        return contractCount;
    }

    public static CompanyDocs create(){
        return new CompanyDocs();
    }
}