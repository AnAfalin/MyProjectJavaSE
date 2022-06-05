package generalCollectionTasks.task8;

import java.util.HashMap;
import java.util.Map;

public class Site {
    private static final Map<String, String> dataUserSite = new HashMap<>();
    static {
        dataUserSite.put("admin", "admin");
    }
    private static final FunctionalAdmin functionalAdmin = new FunctionalAdmin();

    public int enter(String login, String password){
        if(dataUserSite.containsKey(login)){
            if(dataUserSite.get(login).equals(password)){
                return 1;
            }else {
                return -1;
            }
        }
        return 0;
    }

    public boolean registration(String login, String password){
        if(!dataUserSite.containsKey(login)){
            dataUserSite.put(login, password);
            return true;
        }
        return false;
    }

    public boolean isAdmin(String login, String password){
        return login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
    }

    public void functionAdmin(String numberChoice){
        if(numberChoice.equalsIgnoreCase("1")){
            System.out.println(functionalAdmin.getAllUsers(dataUserSite));
        }
        if(numberChoice.equalsIgnoreCase("2")){
            System.out.println(functionalAdmin.getUsersStrongPassword(dataUserSite));
        }
        if(numberChoice.equalsIgnoreCase("3")){
            System.out.println(functionalAdmin.getUsersEmailLogin(dataUserSite));
        }
    }



}
