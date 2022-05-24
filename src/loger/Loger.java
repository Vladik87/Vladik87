package loger;

import storage.impl.UserRepoImpl;

import java.io.*;
import java.time.Instant;

public class Loger {
    private  static  Loger instance;
    private final String LOG_FILE_PATH = "./resyrse/log.txt";
    private  Loger(){}
    public static Loger getInstance(){
        if(instance==null){
            instance = new Loger();
        }
        return instance;
    }
    public void  log(final Class clazz, final LogLevel logleval, final String message){
         try(FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);

         ){
             // TODO try create MessageBuilder
             StringBuilder sb = new StringBuilder();
             sb.append("[").append(logleval).append("] ");
             sb.append("[").append(clazz.getName()).append("] ");
             sb.append("[").append(Instant.now().toString()).append("] ");
             sb.append((message));

             printWriter.println(sb);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }

    public void debug(Class<? extends UserRepoImpl> aClass, String formatted) {
    }
}
