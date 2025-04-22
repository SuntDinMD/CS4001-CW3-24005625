
public class PartTimeStaffHire extends StaffHire {
    
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                            String staffName, String joiningDate, String qualification,
                            String appointedBy, boolean joined, int workingHour,
                            double wagesPerHour, String shifts) {
        // Call the parent class constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; // Initially, the staff is not terminated
    }

    // Getter methods for the new attributes
    public int getWorkingHour() {
        return workingHour;
    }

    public double getWagesPerHour() {
        return wagesPerHour;
    }

    public String getShifts() {
        return shifts;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setShifts(String shifts) {
        if (isJoined() && !terminated) {
            this.shifts = shifts;
        } else {
            System.out.println("Staff has not joined or is terminated. Cannot set shifts.");
        }
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
        
        // Display additional information specific to part-time staff
        if (isJoined() && !terminated) {
            System.out.println("Working Hours per Day: " + workingHour);
            System.out.println("Wages per Hour: " + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Income per Day: " + (workingHour * wagesPerHour));
            System.out.println("Terminated: No");
        } else if (terminated) {
            System.out.println("Staff has been terminated.");
        }
    }
}
