package storage.impl;

import dto.User;
import loger.Loger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class UserRepoImpl implements UserRepo {
private  static  final Loger log = Loger.getInstance();
    private final String USER_FILE = "./resyrse/user.csv";
    private static UserRepo instance;
    private AtomicLong userIdCounter;

    private UserRepoImpl() {
        try {
            FileReader fileReader = new FileReader(USER_FILE);
            BufferedReader bufferedReader =  new BufferedReader(fileReader);

            OptionalLong max = bufferedReader.lines()
                    .map(line->line.split(",")[0])
                    .mapToLong(Long::parseLong)
                    .max();
            if (max.isPresent()){
                userIdCounter =new AtomicLong(max.getAsLong());
                log.debug(this.getClass(),"Created UserIdCounter with initial value: %d".formatted(userIdCounter.get()));
            }else {
                userIdCounter = new AtomicLong();
                log.debug(this.getClass()," Created empty UserIdCounter stared with 0");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        открыть файл для чтения
//        прочитать все строки
//        найти мах ид
//        userIdCounter = new AtomicLong(maxUserId);

    }

    public static UserRepo getInstance() {
        if (instance == null) {
            instance = new UserRepoImpl();
        }
        return instance;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
//    открыть фаил для чтения
//    прочитать строки
//    в строках найти пользователя с нужным юзер наме
//    и вернуть Optional<User>
//    если нет но Optional.empty
        return Optional.empty();
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            insert(user);
        } else {
            update(user);
        }
    }
    private void insert(User user) {
        //       long newUserId userIdCounter.incrementAndGet();
//       user.setId(newUserId);
//        открыть файл для вставки
//         получим следующий ид
//                вставляем ид в юзер
//         конвертируем в строку csv
//         добавляем к файлу
    }
    private void update(User user) {
//       открываем файл для чтения
//        прочитать все строки
//       найти нужного пользователя в строках, сохранить его индекс
//       удалить старого пользователя по индексу из этих строк
//       конвертируем нового пользователя и вставляем по индексу
//       открываем файл для перезаписи new FileWriter(FILE_PATH)
//       вставляем все строки в файл
    }


}
