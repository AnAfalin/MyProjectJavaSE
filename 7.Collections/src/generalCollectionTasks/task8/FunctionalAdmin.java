package generalCollectionTasks.task8;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FunctionalAdmin {
    public Set<String> getAllUsers(Map<String, String> dataUserSite){
        return dataUserSite.keySet();
    }

    public Set<String> getUsersStrongPassword(Map<String, String> dataUserSite){
        Set<String> userStrongPassword = new HashSet<>();
        Set<Map.Entry<String, String>> entrySet = dataUserSite.entrySet();
        for (Map.Entry<String, String> entries:entrySet) {
            if(entries.getValue().matches("^(?=.*\\d)(?=.*[A-z]).{2,10}$")){
                userStrongPassword.add(entries.getKey());
            }
        }
        return userStrongPassword;
    }

    public Set<String> getUsersEmailLogin(Map<String, String> dataUserSite){
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
