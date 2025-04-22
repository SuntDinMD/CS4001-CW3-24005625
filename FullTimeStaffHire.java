public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private int weeklyFractionalHours;

    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType,
                            String staffName, String joiningDate, String qualification,
                            String appointedBy, boolean joined, double salary,
                            int weeklyFractionalHours) {
        // Call the parent class constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Getter methods for the new attributes
    public double getSalary() {
        return salary;
    }

    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    public void setSalary(double salary) {
        if (isJoined()) {
            this.salary = salary;
        } else {
            System.out.println("Sorry, there is no staff appointed to set the salary.");
        }
    }

    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    private boolean terminated = false;
    
    public boolean isTerminated() {
        return terminated;
    }
    
    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff is already terminated.");
        } else {
            // Clear staff details
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            this.terminated = true;
        }
    }

    @Override
    public void display() {
        // Call the parent class display method
        super.display();
        
        // Display additional information specific to full-time staff
        if (isJoined() && !terminated) {
            System.out.println("Salary: " + salary);
            System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
            System.out.println("Terminated: No");
        } else if (terminated) {
            System.out.println("Staff has been terminated.");
        }
    }
}
