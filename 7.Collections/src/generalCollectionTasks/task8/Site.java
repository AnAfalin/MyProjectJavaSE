package generalCollectionTasks.task8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Site {
    private static Map<String, String> dataUserSite = new HashMap<>();
    private static final Administrator admin = new Administrator();
    static {
        dataUserSite.put(admin.LOGIN, admin.PASSWORD);
    }

    private static final class Administrator {
        private final String LOGIN = "admin";
        private final String PASSWORD = "admin";

        public Set<String> getAllUsers(){
            return dataUserSite.keySet();
        }

        public Set<String> getUsersStrongPassword(){
            Set<String> userStrongPassword = new HashSet<>();
            Set<Map.Entry<String, String>> entrySet = dataUserSite.entrySet();
            for (Map.Entry<String, String> entries:entrySet) {
                if(entries.getValue().matches("^(?=.*\\d)(?=.*[A-z]).{2,10}$")){
                    userStrongPassword.add(entries.getKey());
                }
            }
            return userStrongPassword;
        }

        public Set<String> getUsersEmailLogin(){
            Set<String> userEmailLogin = new HashSet<>();
            Set<Map.Entry<String, String>> entrySet = dataUserSite.entrySet();
            for (Map.Entry<String, String> entries:entrySet) {
                if(entries.getValue().matches("[A-z\\d]*@(mail.ru)|(yandex.ru)|(google.com)")){
                    userEmailLogin.add(entries.getKey());
                }
            }
            return userEmailLogin;
        }
    }

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
        return login.equalsIgnoreCase(admin.LOGIN) && password.equalsIgnoreCase(admin.PASSWORD);
    }

    public void functionAdmin(String numberChoice){
        if(numberChoice.equalsIgnoreCase("1")){
            System.out.println(admin.getAllUsers());
        }
        if(numberChoice.equalsIgnoreCase("2")){
            System.out.println(admin.getUsersStrongPassword());
        }
        if(numberChoice.equalsIgnoreCase("3")){
            System.out.println(admin.getUsersEmailLogin());
        }
    }



}
