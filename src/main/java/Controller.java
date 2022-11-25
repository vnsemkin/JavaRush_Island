import controller.IslandController;

/**
 * Game Controller
 **/
public class Controller {
    public static void main(String[] args) {
        new Thread(new IslandController()).start();
    }
}
