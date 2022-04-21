package HomeWork11 ;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    String name;
    static String surname;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {

        return  surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
  //  }

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Vlad", "Romanovich", 30),
                new Person("Sergej","Ivanov",15),
                new Person("Igor", "Mitrofanovich", 17),
                new Person("Sasha","Petron",27),
                new Person("Oleg", "Krotov", 24),
                new Person("Vladimir", "Ranovich", 29),
                new Person("Nikita","Zayac",26),
                new Person("Olga", "Gais", 16),
                new Person("Genya","Petrov",15),
                new Person("Gena", "Sidorov", 25),
                new Person("Slava", "Kozyn", 17),
                new Person("Stepan","Isaev",22),
                new Person("Vika", "Malyshka", 19),
                new Person("Petr","Ivanchik",23),
                new Person("Tanya", "Krotova", 24),
                new Person("Yuri", "Mitronovich", 27),
                new Person("Sergej","Ivakin",16),
                new Person("Kostya", "Savko", 21),
                new Person("Myxamed","Sayk",18),
                new Person("Oleg", "Kantorovich", 24),
                new Person("Vadim", "Fedin", 19),
                new Person("Slava","Xruschev",20),
                new Person("Gena", "El'cin", 23),
                new Person("Pavel","Pytin",19),
                new Person("Stepan", "Bajden", 29),
                new Person("Sveta", "Golub", 24),
                new Person("Ira","Ivanova",16),
                new Person("Galya", "Romanovich", 26),
                new Person("Yana","Kisel",15),
                new Person("Vadim", "Krovichev", 24),
                new Person("Valera", "Xomovich", 17),
                new Person("Sergej","Zanav",27),
                new Person("Kiril", "Pushkin", 25),
                new Person("Sasha","Sobol'",23),
                new Person("Yuri", "Davydov", 24),
                new Person("Oksana", "Kolichev", 19),
                new Person("Yulya","Sat'ya",21),
                new Person("Abram", "Linkol'n", 28),
                new Person("Moisej","Vershinin",27),
                new Person("Pavel", "Dyron", 24),
                new Person("Lev", "Zaicev", 26),
                new Person("Genya","Ivachov",15),
                new Person("Gena", "Kolochev", 25),
                new Person("Sergej","Rykevich",24),
                new Person("Rita", "Gatov", 24),
                new Person("Marta", "Stepancova", 23),
                new Person("Masha","Guk",18),
                new Person("Vika", "Savkovich", 19),
                new Person("Nikaj","Suchko",16),
                new Person("Oleg", "Bich", 26),
                new Person("Vladimir", "Sapega", 29),
                new Person("Sergej","Gal'cev",21),
                new Person("Vlad", "Vetrov", 30),
                new Person("Kostya","IRoschinvanov",22),
                new Person("Olesya", "Buyak", 24),
                new Person("Viktor", "Sarokin", 29),
                new Person("Sebostyan","Bax",19),
                new Person("Kira", "Zydina", 16),
                new Person("Lera","Merkel'",25),
                new Person("Ilona", "Solomovaya", 24),
                new Person("Zaxar", "Gorbach", 19),
                new Person("Andrej","Mushin",24),
                new Person("Yarik", "Gusev", 18),
                new Person("Tom","Ivanov",29),
                new Person("Liza", "Krotova", 21),
                new Person("Zlata", "Romanchuk", 22),
                new Person("Kira","Roschina",16),
                new Person("Danil", "fedin", 27),
                new Person("Tolik","Zoschij",19),
                new Person("Fedya", "Meshin", 26),
                new Person("Lesha", "Mesin", 28),
                new Person("Zina","Ivashova",22),
                new Person("Vlad", "Kodchev", 18),
                new Person("Boris","Dgons",15),
                new Person("Nina", "Spevak", 24),
                new Person("Marina", "Alexno", 26),
                new Person("Sergej","Kunda",16),
                new Person("Sveta", "Deshuk", 17),
                new Person("Snezana","Kucheva",15),
                new Person("Olga", "Krotova", 27),
                new Person("Vera", "Shishkina", 29),
                new Person("Kazik","Stolypin",18),
                new Person("Slavik", "Rudko", 24),
                new Person("Dima","Guk",18),
                new Person("Vladimir", "Vol'skij", 26),
                new Person("Yarik", "Xormash", 19),
                new Person("Angela","Stol'naya",15),
                new Person("Taisa", "Paplavskaya", 16),
                new Person("Nadya","Zayac",17),
                new Person("Oleg", "Kuchuk", 28),
                new Person("Vitya", "Lagun", 27),
                new Person("Denis","Lishik",25),
                new Person("Sasha", "Maksimchik", 26),
                new Person("Vasya","Rud'ko",22),
                new Person("Kolya", "Titov", 24),
                new Person("Valera", "Semeschuk", 17),
                new Person("Anna","Sholc",18),
                new Person("Ira", "Guseva", 19),
                new Person("Galya","Gudina",20),
                new Person("Dima", "Mosin", 24));

        persons.stream().filter(x -> x.getAge() < 21)
                .map(x -> x.getName() + " " + x.getSurname() + " " + x.getAge())
                .peek((e) -> System.out.println("," +e))
                .sorted(Comparator.comparing(Person::getSurname)
                       .thenComparing(Person::getName))
                .toList()
                       .forEach(System.out::println);



    }

}


