import dto.Sex;
import dto.User;
import storage.impl.UserRepo;
import storage.impl.UserRepoImpl;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        UserRepo repo = UserRepoImpl.getInstance();

       //  create user example
        User u1 = new User("andreiklim132", "123", "Andrei123", "Klimovich123", LocalDate.of(1978, 5 ,9), Sex.M, "333@mail.com");
        repo.save(u1);
       //  update user example
        User u2 = new User(2L, "andreiklim", "243212", "Andrei1", "Klimovich1", LocalDate.of(2000, 5 ,9), Sex.M, "upd@mail.com");
        repo.save(u2);

        repo.findByUserName("andreiklim").ifPresent(u -> System.out.println(u.getFirstName() + " " + u.getLastName()));
    }
}
