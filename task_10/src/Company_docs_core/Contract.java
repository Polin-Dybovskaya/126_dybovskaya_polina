package Company_docs_core;

public class Contract {
    private final int date;
    public int getDocumentsListSize;

    public Contract(int date) {
            this.date = date;
    }
    public void registerPaymentDocument(int sum, int number, String docType, int date){

    }
    public int getDocumentsListSize (){
        return 1;
    }

}