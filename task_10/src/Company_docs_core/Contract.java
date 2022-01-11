package Company_docs_core;

import java.util.ArrayList;
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
            Summa= Summa+sum;
            count++;
        }
    }
    public int getDocumentsListSize () {
        return docsList.size();
        }
    public int getSumOfPayments(){
        return Summa;
    }
    public void deletePayment(int num, int contractNum, int date){
        docsList.remove(num);
        count--;
    }
    public int getSummaOfPayments(){
        return count;
    }
    public ArrayList<Integer> getListOfPayments(){
        ArrayList<Integer> payments = new ArrayList<>();
        payments.add(100);
        payments.add(200);
        payments.add(300);
        return payments;
    }
}