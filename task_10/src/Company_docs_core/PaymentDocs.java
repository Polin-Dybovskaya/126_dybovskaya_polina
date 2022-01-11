package Company_docs_core;

public class PaymentDocs {
    private int sum;
    private DocType docType;
    private int date;

    public PaymentDocs (int sum, DocType docType, int date){
        this.sum = sum;
        this.docType = docType;
        this.date = date;
    }

    public int getSumma(){
        return sum;
    }
}
