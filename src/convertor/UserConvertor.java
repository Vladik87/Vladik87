package convertor;

import dto.Sex;
import dto.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserConvertor {
    private UserConvertor(){}

    public static String toCsvSring(final User user) {
       StringBuilder sb = new StringBuilder();
       sb.append(user.getId()).append(",");
       sb.append(user.getUserName()).append(",");
       sb.append(user.getPassword()).append(",");
       sb.append(user.getFirstName()).append("'");
       sb.append(user.getLastName()).append(",");
       sb.append(user.getBirthDate()).append(",");
       sb.append(user.getSex()).append(",");
       sb.append(user.getEmail()).append(",");
       return sb.toString();
    }
    public static User toObject(final String cvsString ){
        String[] strings =cvsString.split(",");
        int i =0;
        User user= new User();
        user.setId(Long.parseLong(strings[i++]));
        user.setUserName(strings[i++]);
        user.setPassword(strings[i++]);
        user.setFirstName(strings[i++]);
        user.setLastName(strings[i++]);
        user.setBirthDate(LocalDate.parse(strings[i++], DateTimeFormatter.ISO_LOCAL_DATE));
        user.setSex(Sex.valueOf(strings[i++]));
        user.setEmail(strings[i++]);

        return user;
    }

}
