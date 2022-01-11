package Company_docs_core;

import java.util.ArrayList;//
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
    public void deletePayment(int num){
        if (!docsList.containsKey(num)){
            System.out.println("Документа с таким номером не существует, пожалуйста, уточните данные. ");
        }
        else {
            Summa = Summa - docsList.get(num).getSumma();
            docsList.remove(num);
            count--;
            System.out.println("Платёж был удалён");
        }
    }
    public int getSummaOfPayments(){
        return count;
    }
    public ArrayList<Integer> getListOfPayments(){//
        ArrayList<Integer> payments = new ArrayList<>();
        for (PaymentDocs doc : docsList.values()) {
            payments.add(doc.getSumma());
        }
        return payments;
    }
}