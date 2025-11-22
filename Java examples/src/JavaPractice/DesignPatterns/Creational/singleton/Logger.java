package JavaPractice.DesignPatterns.singleton;

public class Logger {

    private static final Logger instance = new Logger();

    // Constructor has to be private
    private Logger(){
        System.out.println("Logger initialized");
    }

    public static Logger getInstance(){
        return instance;
    }

}
