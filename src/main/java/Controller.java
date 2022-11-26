import task.StartTask;

/**
 * Game Controller
 **/
public class Controller {
    public static void main(String[] args) {
        new Thread(new StartTask()).start();
    }
}
