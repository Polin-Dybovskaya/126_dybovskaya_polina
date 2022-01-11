package Company_docs_core;

import java.util.HashMap;

public class Contract {
    private final int date;
    private int Summa;
    private int count = 0;
    private HashMap<Integer, PaymentDocs> docsList = new HashMap<Integer, PaymentDocs>();


    public Contract(int date) {
        this.date = date;
    }

    public void registerPaymentDocument(int sum, int number, DocType docType, int date) {
        if (sum > 0 && number > 0 && String.valueOf(date).length() == 8) {
            docsList.put(number, new PaymentDocs(sum, docType, date));
        }
    }
    public int getDocumentsListSize () {
        return docsList.size();
        }
    public int getSumOfPayments(){
        return 0;
    }
}