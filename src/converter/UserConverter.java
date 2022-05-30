package converter;

import dto.Sex;
import dto.User;
import service.UserValidationRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserConverter {

    private UserConverter() {}

    public static String toCsvString(final User user) {
        // TODO can be replaced with UserCsvBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(user.getId()).append(",");
        sb.append(user.getUserName()).append(",");
        sb.append(user.getPassword()).append(",");
        sb.append(user.getFirstName()).append(",");
        sb.append(user.getLastName()).append(",");
        sb.append(user.getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE)).append(",");
        sb.append(user.getSex()).append(",");
        sb.append(user.getEmail());

        return sb.toString();
    }

    public static User toObject(final String csvString) {
        String[] strings = csvString.split(",");
        int i = 0;

        User user = new User();
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
    public static User toObject(final UserValidationRequest request){
        User user = new User();
        user.setUserName(request.userName());
        user.setPassword(request.password());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setBirthDate(LocalDate.parse(request.birthDate(),DateTimeFormatter.ISO_LOCAL_DATE));
        user.setSex(Sex.valueOf(request.sex()));
        user.setEmail(request.email());
        return user;
    }

    private class UserCsvBuilder {
        private final StringBuilder sb;

        public UserCsvBuilder() {
            sb = new StringBuilder();
        }

        public String build() {
            return sb.toString();
        }

        public UserCsvBuilder id(final Long userId) {
            sb.append(userId).append(",");
            return this;
        }

        public UserCsvBuilder userName(final String username) {
            sb.append(username).append(",");
            return this;
        }

        public UserCsvBuilder firstName(final String firstName) {
            sb.append(firstName).append(",");
            return this;
        }

        public UserCsvBuilder lastName(final String lastName) {
            sb.append(lastName).append(",");
            return this;
        }

        public UserCsvBuilder birthDate(final LocalDate birthDate) {
            sb.append(birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE)).append(",");
            return this;
        }

        public UserCsvBuilder sex(final Sex sex) {
            sb.append(sex).append(",");
            return this;
        }

        public UserCsvBuilder email(final String email) {
            sb.append(email);
            return this;
        }
    }
}
