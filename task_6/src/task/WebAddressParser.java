package task;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebAddressParser {
    private URL Url1;

    public WebAddressParser(String Url1){
        try{
            this.Url1= new URL (Url1);
        } catch (MalformedURLException e ){
            this.Url1=null;
        }
    }

    public boolean isValid(){
        if (Url1!=null)
            return true;
        else
            return false;
    }

    public String getLogin(){
        if (isValid()){
            String [] Authority= Url1.getAuthority().split("@");
            if (Authority.length>=2){
                String[] NameOfUser = Authority [0].split(":");
                if (NameOfUser.length>=2){
                    return NameOfUser[1];
                }
            }
        }
        return "";
    }

    public String getPassword(){
        if (isValid()){
            String [] Authority= Url1.getAuthority().split("@");
            if (Authority.length>=2){
                String[] NameOfUser = Authority [0].split(":");
                if (NameOfUser.length>=2){
                    return NameOfUser[1];
                }
            }
        }
        return "";
    }

    public String getScheme(){
        if(isValid()) {
            return Url1.getProtocol();
        }
        else {
            return "";
        }
    }
    public String getHost(){
        if(isValid()) {
            return Url1.getHost();
        }
        else{
            return "";
        }
    }public String getPort(){
        if(isValid() && Url1.getPort() != -1) {
            return Integer.toString(Url1.getPort());
        }
        else {
            return "";
        }
    }

    public String getUrl(){
        if(isValid()) {
            return Url1.getPath().replaceFirst("/", "");
        }
        else {
            return "";
        }
    }

    public HashMap<String, String> getParameters(){
        HashMap<String, String> parameters = new HashMap<>();

        if(isValid() && Url1.getQuery() != null) {

            String[] Par = Url1.getQuery().split("&");
            String p[];

            for (int i = 0; i < Par.length; i++) {
                p = Par[i].split("=");
                parameters.put(p[0], p[1]);
            }
        }
        return parameters;
    }

    public String getFragment(){
        if(isValid() && Url1.getRef() != null) {
            return Url1.getRef();
        }
        else {
            return "";
        }
    }

}