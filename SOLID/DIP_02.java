package SOLID;

public class DIP_02 {

    /*
     * FIXED:
     * The Employee class now depends on the Notification interface (abstraction),
     * not the concrete EmailNotification class. This follows the DIP.
     */
    
    public static interface Notification {
        void doNotify();
    }

    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via email!");
        }
    }

    // High-level module depends on abstraction
    public static class Employee {
        private Notification notification;

        public Employee(Notification notification) {
            this.notification = notification;
        }

        public void notifyEmployee() {
            notification.doNotify();
        }
    }

    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification(); // programming to interface
        Employee employee = new Employee(emailNotification);
        employee.notifyEmployee();
    }
}
