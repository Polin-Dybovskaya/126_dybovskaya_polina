package Company_docs_core;

public class CompanyDocs {
    private int contractCount;
    private CompanyDocs(){
        contractCount=0;
    }
    public void addContract(String number, String date) {
        if(number == null && date==null){
            throw new IllegalArgumentException("number and date cannot be null");
        }
        if(number==null)
            throw new IllegalArgumentException("Number can't be null");
        if(date==null)
            throw new IllegalArgumentException("Date can't be null");

            contractCount++;

    }
    public int getContractsCount(){
        return contractCount;
    }

    public static CompanyDocs create(){
        return new CompanyDocs();
    }
}