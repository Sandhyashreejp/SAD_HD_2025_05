package SOLID;

public class ISP_02 {

    public interface Workable {
        void work();
    }

    public interface Restable {
        void rest();
    }

    public static class Developer implements Workable, Restable {
        @Override
        public void work() {
            System.out.println("Developer is coding...");
        }

        @Override
        public void rest() {
            System.out.println("Developer is taking a break.");
        }
    }

    public static class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Robot is working tirelessly...");
        }
    }

    public static void workingCycle(Workable worker) {
        worker.work();
        if (worker instanceof Restable) {
            ((Restable) worker).rest();
        }
    }

    public static void main(String[] args) {
        workingCycle(new Developer());
        workingCycle(new Robot());
    }
}
