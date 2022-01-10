package Company_docs_core;
import java.util.HashMap;

public class CompanyContracts {

    private final String date ;

    public CompanyContracts(String date) {
        this.date = date;
    }
    CompanyContracts() {
        HashMap<Object, Object> contractCount = new HashMap<>();
    }
    public void addContract(String number, String date) {
        StringBuilder error = new StringBuilder();
        if (number == null) {
            error.append("Number cannot be null\n");
        }
        if (date == null) {
            error.append("Date cannot be null\n");
        }
        if (!error.isEmpty()) {
            throw new IllegalArgumentException(error.toString());
        } else {
            contractCount.put(number, date);
        }
    }
    public int getContractsCount(){
        return 0;
    }

    public static CompanyContracts create () {
        return new CompanyContracts();
    }
}
