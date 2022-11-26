package task;

import controller.IslandController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartTask implements Runnable {
    private final IslandController islandController = new IslandController();
    private final EatTask eatTask = new EatTask();
    private final GrassGrowTask grassGrowTask = new GrassGrowTask();
    private final MoveTask moveTask = new MoveTask();
    private final ReproductionTask reproductionTask = new ReproductionTask();

    @Override
    public void run() {
        islandController.printInitialIsland();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(eatTask, 0, 9, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(grassGrowTask, 3, 12, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(moveTask, 6, 15, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(reproductionTask, 9, 18, TimeUnit.SECONDS);
    }
}
