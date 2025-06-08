package SOLID;

public class DIP_02 {

    public interface Notification {
        void doNotify();
    }

    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Email notification sent.");
        }
    }

    public static class Employee {
        private final Notification notifier;

        public Employee(Notification notifier) {
            this.notifier = notifier;
        }

        public void notifyEmployee() {
            notifier.doNotify();
        }
    }

    public static void main(String[] args) {
        Notification notifier = new EmailNotification();
        Employee emp = new Employee(notifier);
        emp.notifyEmployee();
    }
}
