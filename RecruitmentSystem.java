import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

public class RecruitmentSystem extends JFrame {
    // ArrayList to store StaffHire objects
    private ArrayList<StaffHire> staffList;
    
    // GUI Components
    private JTextField txtVacancyNumber, txtDesignation, txtJobType, txtStaffName;
    private JTextField txtJoiningDate, txtQualification, txtAppointedBy;
    private JTextField txtSalary, txtWeeklyFractionalHours;
    private JTextField txtWorkingHour, txtWagesPerHour, txtShifts;
    private JTextField txtDisplayNumber, txtTerminateNumber;
    private JCheckBox chkJoined;
    
    // Search and Filter Components
    private JTextField txtSearchKeyword;
    private JComboBox<String> cmbSearchField;
    private JComboBox<String> cmbFilterJobType;
    private JRadioButton rdoFullTime, rdoPartTime, rdoAllStaff;
    
    private JButton btnAddFullTimeStaff, btnAddPartTimeStaff;
    private JButton btnSetSalary, btnSetWorkingShifts;
    private JButton btnTerminateStaff, btnTerminateAllStaff, btnDisplayNumber, btnClear;
    
    private JTextArea displayArea;
    
    public RecruitmentSystem() {
        // Set title and close operation
        super("Staff Recruitment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Initialize the list
        staffList = new ArrayList<>();
        
        // Set smaller size and positioning
        setSize(650, 500);
        setLocationRelativeTo(null); // Center on screen
        
        // Show welcome message
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null,
                    "Welcome to Staff Recruitment System\n\n" +
                    "This application allows you to manage staff recruitment details\n" +
                    "including full-time and part-time staff information.\n\n" +
                    "Click OK to continue.",
                    "Welcome", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        setVisible(true);
        // Main panel with BorderLayout and streamlined styling
        JPanel mainPanel = new JPanel(new BorderLayout(2, 2));
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(2, 2, 2, 2),
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 100, 100), 1, false),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
            )
        ));
        mainPanel.setBackground(new Color(245, 245, 250));
        
        // Main input panel with better organization
        JPanel inputPanel = new JPanel(new BorderLayout(2, 2));
        
        // Create three separate panels for common, full-time, and part-time fields
        JPanel commonFieldsPanel = new JPanel(new GridLayout(0, 4, 1, 1));
        commonFieldsPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 102, 204), 1, false),
            "Common Staff Details",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 11),
            new Color(0, 102, 204)
        ));
        commonFieldsPanel.setBackground(new Color(240, 248, 255)); // Light blue background
        
        JPanel fullTimePanel = new JPanel(new GridLayout(0, 4, 1, 1));
        fullTimePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(51, 153, 102), 1, false),
            "Full-Time Staff Details",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 10),
            new Color(51, 153, 102)
        ));
        fullTimePanel.setBackground(new Color(240, 255, 240)); // Light green background
        
        JPanel partTimePanel = new JPanel(new GridLayout(0, 4, 1, 1));
        partTimePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(153, 102, 0), 1, false),
            "Part-Time Staff Details",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 10),
            new Color(153, 102, 0)
        ));
        partTimePanel.setBackground(new Color(255, 248, 220)); // Light tan background
        
        JPanel operationsPanel = new JPanel(new GridLayout(0, 4, 1, 1));
        operationsPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(102, 0, 153), 1, false),
            "Operations",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 10),
            new Color(102, 0, 153)
        ));
        operationsPanel.setBackground(new Color(245, 240, 255)); // Light purple background
        
        // Style for labels
        Font labelFont = new Font("Arial", Font.BOLD, 11);
        Color labelColor = new Color(51, 51, 51);
        
        // Add components to common fields panel
        JLabel lblVacancyNumber = new JLabel("Vacancy Number:");
        lblVacancyNumber.setFont(labelFont);
        lblVacancyNumber.setForeground(labelColor);
        commonFieldsPanel.add(lblVacancyNumber);
        
        txtVacancyNumber = new JTextField();
        styleTextField(txtVacancyNumber);
        commonFieldsPanel.add(txtVacancyNumber);
        
        JLabel lblDesignation = new JLabel("Designation:");
        lblDesignation.setFont(labelFont);
        lblDesignation.setForeground(labelColor);
        commonFieldsPanel.add(lblDesignation);
        
        txtDesignation = new JTextField();
        styleTextField(txtDesignation);
        commonFieldsPanel.add(txtDesignation);
        
        JLabel lblJobType = new JLabel("Job Type:");
        lblJobType.setFont(labelFont);
        lblJobType.setForeground(labelColor);
        commonFieldsPanel.add(lblJobType);
        
        txtJobType = new JTextField();
        styleTextField(txtJobType);
        commonFieldsPanel.add(txtJobType);
        
        JLabel lblStaffName = new JLabel("Staff Name:");
        lblStaffName.setFont(labelFont);
        lblStaffName.setForeground(labelColor);
        commonFieldsPanel.add(lblStaffName);
        
        txtStaffName = new JTextField();
        styleTextField(txtStaffName);
        commonFieldsPanel.add(txtStaffName);
        
        JLabel lblJoiningDate = new JLabel("Joining Date:");
        lblJoiningDate.setFont(labelFont);
        lblJoiningDate.setForeground(labelColor);
        commonFieldsPanel.add(lblJoiningDate);
        
        txtJoiningDate = new JTextField();
        styleTextField(txtJoiningDate);
        commonFieldsPanel.add(txtJoiningDate);
        
        JLabel lblQualification = new JLabel("Qualification:");
        lblQualification.setFont(labelFont);
        lblQualification.setForeground(labelColor);
        commonFieldsPanel.add(lblQualification);
        
        txtQualification = new JTextField();
        styleTextField(txtQualification);
        commonFieldsPanel.add(txtQualification);
        
        JLabel lblAppointedBy = new JLabel("Appointed By:");
        lblAppointedBy.setFont(labelFont);
        lblAppointedBy.setForeground(labelColor);
        commonFieldsPanel.add(lblAppointedBy);
        
        txtAppointedBy = new JTextField();
        styleTextField(txtAppointedBy);
        commonFieldsPanel.add(txtAppointedBy);
        
        JLabel lblJoined = new JLabel("Joined:");
        lblJoined.setFont(labelFont);
        lblJoined.setForeground(labelColor);
        commonFieldsPanel.add(lblJoined);
        
        chkJoined = new JCheckBox();
        commonFieldsPanel.add(chkJoined);
        
        // Add components to full-time panel
        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setFont(labelFont);
        lblSalary.setForeground(labelColor);
        fullTimePanel.add(lblSalary);
        
        txtSalary = new JTextField();
        styleTextField(txtSalary);
        fullTimePanel.add(txtSalary);
        
        JLabel lblWeeklyFractionalHours = new JLabel("Weekly Hours:");
        lblWeeklyFractionalHours.setFont(labelFont);
        lblWeeklyFractionalHours.setForeground(labelColor);
        fullTimePanel.add(lblWeeklyFractionalHours);
        
        txtWeeklyFractionalHours = new JTextField();
        styleTextField(txtWeeklyFractionalHours);
        fullTimePanel.add(txtWeeklyFractionalHours);
        
        // Add components to part-time panel
        JLabel lblWorkingHour = new JLabel("Working Hours:");
        lblWorkingHour.setFont(labelFont);
        lblWorkingHour.setForeground(labelColor);
        partTimePanel.add(lblWorkingHour);
        
        txtWorkingHour = new JTextField();
        styleTextField(txtWorkingHour);
        partTimePanel.add(txtWorkingHour);
        
        JLabel lblWagesPerHour = new JLabel("Wages Per Hour:");
        lblWagesPerHour.setFont(labelFont);
        lblWagesPerHour.setForeground(labelColor);
        partTimePanel.add(lblWagesPerHour);
        
        txtWagesPerHour = new JTextField();
        styleTextField(txtWagesPerHour);
        partTimePanel.add(txtWagesPerHour);
        
        JLabel lblShifts = new JLabel("Shifts:");
        lblShifts.setFont(labelFont);
        lblShifts.setForeground(labelColor);
        partTimePanel.add(lblShifts);
        
        txtShifts = new JTextField();
        styleTextField(txtShifts);
        partTimePanel.add(txtShifts);
        
        // Add components to operations panel
        JLabel lblDisplayNumber = new JLabel("Display Number:");
        lblDisplayNumber.setFont(labelFont);
        lblDisplayNumber.setForeground(labelColor);
        operationsPanel.add(lblDisplayNumber);
        
        txtDisplayNumber = new JTextField();
        styleTextField(txtDisplayNumber);
        operationsPanel.add(txtDisplayNumber);
        
        JLabel lblTerminateNumber = new JLabel("Terminate Number:");
        lblTerminateNumber.setFont(labelFont);
        lblTerminateNumber.setForeground(labelColor);
        operationsPanel.add(lblTerminateNumber);
        
        txtTerminateNumber = new JTextField();
        styleTextField(txtTerminateNumber);
        operationsPanel.add(txtTerminateNumber);
        
        // Create search and filter panel
        JPanel searchPanel = new JPanel(new GridLayout(2, 4, 1, 1));
        searchPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(70, 130, 180), 1, false),
            "Search & Filter",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 10),
            new Color(70, 130, 180)
        ));
        searchPanel.setBackground(new Color(240, 248, 255)); // Light blue background
        
        // Search Field Label
        JLabel lblSearchField = new JLabel("Search In:");
        lblSearchField.setFont(labelFont);
        lblSearchField.setForeground(labelColor);
        searchPanel.add(lblSearchField);
        
        // Search Field Dropdown
        cmbSearchField = new JComboBox<>(new String[] {
            "All Fields", "Vacancy Number", "Staff Name", "Designation", "Job Type",
            "Qualification", "Appointed By"
        });
        styleComboBox(cmbSearchField);
        searchPanel.add(cmbSearchField);
        
        // Search Keyword Label
        JLabel lblSearchKeyword = new JLabel("Search Keyword:");
        lblSearchKeyword.setFont(labelFont);
        lblSearchKeyword.setForeground(labelColor);
        searchPanel.add(lblSearchKeyword);
        
        // Search Keyword Text Field
        txtSearchKeyword = new JTextField();
        styleTextField(txtSearchKeyword);
        searchPanel.add(txtSearchKeyword);
        
        // Filter Job Type Label
        JLabel lblFilterJobType = new JLabel("Job Type Filter:");
        lblFilterJobType.setFont(labelFont);
        lblFilterJobType.setForeground(labelColor);
        searchPanel.add(lblFilterJobType);
        
        // Filter Job Type Dropdown
        cmbFilterJobType = new JComboBox<>(new String[] {
            "All Job Types", "Manager", "Developer", "Tester", "Designer", "HR", "Admin"
        });
        styleComboBox(cmbFilterJobType);
        searchPanel.add(cmbFilterJobType);
        
        // Staff Type Filter Label
        JLabel lblStaffTypeFilter = new JLabel("Staff Type:");
        lblStaffTypeFilter.setFont(labelFont);
        lblStaffTypeFilter.setForeground(labelColor);
        searchPanel.add(lblStaffTypeFilter);
        
        // Staff Type Radio Buttons
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        radioPanel.setBackground(searchPanel.getBackground());
        
        rdoAllStaff = new JRadioButton("All");
        rdoAllStaff.setSelected(true);
        rdoAllStaff.setBackground(searchPanel.getBackground());
        
        rdoFullTime = new JRadioButton("Full-Time");
        rdoFullTime.setBackground(searchPanel.getBackground());
        
        rdoPartTime = new JRadioButton("Part-Time");
        rdoPartTime.setBackground(searchPanel.getBackground());
        
        ButtonGroup staffTypeGroup = new ButtonGroup();
        staffTypeGroup.add(rdoAllStaff);
        staffTypeGroup.add(rdoFullTime);
        staffTypeGroup.add(rdoPartTime);
        
        radioPanel.add(rdoAllStaff);
        radioPanel.add(rdoFullTime);
        radioPanel.add(rdoPartTime);
        
        searchPanel.add(radioPanel);
        
        // Create a panel to hold all the field panels with smaller layout
        JPanel allFieldsPanel = new JPanel(new GridLayout(5, 1, 1, 1));
        allFieldsPanel.add(commonFieldsPanel);
        allFieldsPanel.add(fullTimePanel);
        allFieldsPanel.add(partTimePanel);
        allFieldsPanel.add(operationsPanel);
        allFieldsPanel.add(searchPanel);
        
        // Add the fields panel to the main input panel
        inputPanel.add(allFieldsPanel, BorderLayout.CENTER);
        
        // Button panels with compact organization
        JPanel buttonPanel = new JPanel(new BorderLayout(2, 2));
        
        // Top button panel for staff management
        JPanel topButtonPanel = new JPanel(new GridLayout(0, 3, 1, 1));
        topButtonPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 102, 153), 1, false),
            "Staff Management",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 10),
            new Color(0, 102, 153)
        ));
        topButtonPanel.setBackground(new Color(230, 240, 250));
        
        // Bottom button panel for utility operations
        JPanel bottomButtonPanel = new JPanel(new GridLayout(0, 3, 1, 1));
        bottomButtonPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(102, 51, 153), 1, false),
            "Utilities",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 10),
            new Color(102, 51, 153)
        ));
        bottomButtonPanel.setBackground(new Color(240, 235, 250));
        
        // Style the buttons 
        btnAddFullTimeStaff = createStyledButton("Add Full Time Staff", new Color(0, 102, 204));
        topButtonPanel.add(btnAddFullTimeStaff);
        
        btnAddPartTimeStaff = createStyledButton("Add Part Time Staff", new Color(0, 102, 204));
        topButtonPanel.add(btnAddPartTimeStaff);
        
        btnSetSalary = createStyledButton("Set Salary", new Color(51, 153, 102));
        topButtonPanel.add(btnSetSalary);
        
        btnSetWorkingShifts = createStyledButton("Set Working Shifts", new Color(51, 153, 102));
        topButtonPanel.add(btnSetWorkingShifts);
        
        btnTerminateStaff = createStyledButton("Terminate Staff", new Color(204, 51, 51));
        topButtonPanel.add(btnTerminateStaff);
        
        btnTerminateAllStaff = createStyledButton("Terminate All Staff", new Color(153, 0, 0));
        topButtonPanel.add(btnTerminateAllStaff);
        
        btnDisplayNumber = createStyledButton("Display Staff", new Color(153, 102, 0));
        topButtonPanel.add(btnDisplayNumber);
        
        // Add new buttons for additional functionality
        JButton btnDisplayAll = createStyledButton("Display All Staff", new Color(153, 102, 0));
        topButtonPanel.add(btnDisplayAll);
        btnDisplayAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayStaffList();
            }
        });
        
        // Add search button
        JButton btnSearch = createStyledButton("Search Staff", new Color(70, 130, 180));
        topButtonPanel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStaff();
            }
        });
        
        // Add staff statistics button
        JButton btnStats = createStyledButton("Staff Statistics", new Color(0, 153, 153));
        topButtonPanel.add(btnStats);
        btnStats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStaffStatistics();
            }
        });
        
        // Add export data button
        JButton btnExport = createStyledButton("Export Data", new Color(153, 51, 102));
        topButtonPanel.add(btnExport);
        btnExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportStaffData();
            }
        });
        
        JButton btnAbout = createStyledButton("About", new Color(102, 0, 153));
        bottomButtonPanel.add(btnAbout);
        btnAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RecruitmentSystem.this, 
                    "Staff Recruitment System\nVersion 1.0\n\nDeveloped for CS4001 CW3\n" +
                    "© " + Calendar.getInstance().get(Calendar.YEAR) + " - All Rights Reserved", 
                    "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton btnHelp = createStyledButton("Help", new Color(102, 0, 153));
        bottomButtonPanel.add(btnHelp);
        btnHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RecruitmentSystem.this, 
                    "How to use:\n" +
                    "1. Add staff using 'Add Full Time Staff' or 'Add Part Time Staff'\n" +
                    "2. Update salary using 'Set Salary' for full-time staff\n" +
                    "3. Update shifts using 'Set Working Shifts' for part-time staff\n" +
                    "4. Terminate part-time staff using 'Terminate Staff'\n" +
                    "5. View specific staff information using 'Display Staff'\n" +
                    "6. View all staff using 'Display All Staff'\n" +
                    "7. Search for staff using the 'Search & Filter' panel:\n" +
                    "   - Enter keywords to search in specific fields\n" +
                    "   - Filter by job type using the dropdown\n" +
                    "   - Filter by staff type (Full-Time/Part-Time/All)\n" +
                    "   - Click 'Search Staff' to show the results\n" +
                    "8. View staff statistics using 'Staff Statistics':\n" +
                    "   - See counts of different staff types\n" +
                    "   - View financial metrics like average salaries\n" +
                    "   - Analyze job type distribution\n" +
                    "9. Export all staff data using 'Export Data':\n" +
                    "   - Creates a formatted text file with all staff information\n" +
                    "   - File can be viewed or printed with any text editor\n" +
                    "10. Clear all fields using 'Clear'", 
                    "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Add sample data button
        JButton btnSampleData = createStyledButton("Load Sample Data", new Color(50, 120, 50));
        bottomButtonPanel.add(btnSampleData);
        btnSampleData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadSampleData();
            }
        });
        
        btnClear = createStyledButton("Clear", new Color(102, 102, 102));
        bottomButtonPanel.add(btnClear);
        
        // Add both button panels to the main button panel
        buttonPanel.add(topButtonPanel, BorderLayout.NORTH);
        buttonPanel.add(bottomButtonPanel, BorderLayout.SOUTH);
        
        // Display area
        displayArea = new JTextArea(12, 50);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        displayArea.setBackground(new Color(252, 252, 252));
        displayArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));
        
        // Create a scroll pane for the display area
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(70, 130, 180), 1, false),
            "Staff Information Display",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 10),
            new Color(70, 130, 180)
        ));
        scrollPane.getViewport().setBackground(new Color(252, 252, 252));
        
        // Add panels to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Display welcome message on startup
        showWelcomeMessage();
        
        // Add action listeners to buttons
        btnAddFullTimeStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFullTimeStaff();
            }
        });
        
        btnAddPartTimeStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPartTimeStaff();
            }
        });
        
        btnSetSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSalary();
            }
        });
        
        btnSetWorkingShifts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setWorkingShifts();
            }
        });
        
        btnTerminateStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                terminateStaff();
            }
        });
        
        btnDisplayNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayStaff();
            }
        });
        
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        
        btnTerminateAllStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                terminateAllStaff();
            }
        });
    }
    
    //Method to terminate all staff (both full-time and part-time)
    private void terminateAllStaff() {
        if (staffList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No staff records to terminate.", 
                                         "Operation Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Ask for confirmation before terminating all staff
        int response = JOptionPane.showConfirmDialog(
            this,
            "This will terminate ALL staff (both full-time and part-time). Continue?",
            "Confirm Terminate All Staff",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (response != JOptionPane.YES_OPTION) {
            return;
        }
        
        int fullTimeTerminatedCount = 0;
        int partTimeTerminatedCount = 0;
        
        // Go through each staff and terminate
        for (StaffHire staff : staffList) {
            if (staff instanceof FullTimeStaffHire) {
                FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                if (!fullTimeStaff.isTerminated()) {
                    fullTimeStaff.terminateStaff();
                    fullTimeTerminatedCount++;
                }
            } else if (staff instanceof PartTimeStaffHire) {
                PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                if (!partTimeStaff.isTerminated()) {
                    partTimeStaff.terminateStaff();
                    partTimeTerminatedCount++;
                }
            }
        }
        
        int totalTerminated = fullTimeTerminatedCount + partTimeTerminatedCount;
        
        // Show success message
        if (totalTerminated > 0) {
            JOptionPane.showMessageDialog(this, 
                "Successfully terminated " + totalTerminated + " staff" +
                " (" + fullTimeTerminatedCount + " full-time, " + partTimeTerminatedCount + " part-time).", 
                "Staff Terminated", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, 
                "No active staff found to terminate.", 
                "No Action Taken", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Display updated list
        displayStaffList();
    }
    
    
    //Method to add a full-time staff
    //Creates a new FullTimeStaffHire object and adds it to the staffList
    private void addFullTimeStaff() {
        try {
            // Get values from input fields
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            String designation = txtDesignation.getText();
            String jobType = txtJobType.getText();
            String staffName = txtStaffName.getText();
            String joiningDate = txtJoiningDate.getText();
            String qualification = txtQualification.getText();
            String appointedBy = txtAppointedBy.getText();
            boolean joined = chkJoined.isSelected();
            double salary = Double.parseDouble(txtSalary.getText());
            int weeklyFractionalHours = Integer.parseInt(txtWeeklyFractionalHours.getText());
            
            // Validate inputs
            if (designation.isEmpty() || jobType.isEmpty() || staffName.isEmpty() ||
                joiningDate.isEmpty() || qualification.isEmpty() || appointedBy.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Create new FullTimeStaffHire object
            FullTimeStaffHire fullTimeStaff = new FullTimeStaffHire(
                vacancyNumber, designation, jobType, staffName, joiningDate,
                qualification, appointedBy, joined, salary, weeklyFractionalHours
            );
            
            // Add to list
            staffList.add(fullTimeStaff);
            
            // Show success message
            JOptionPane.showMessageDialog(this, "Full Time Staff added successfully!");
            
            // Clear fields
            clearFields();
            
            // Display updated list
            displayStaffList();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Vacancy Number, Salary, and Weekly Fractional Hours.", 
                                         "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     //Method to add a part-time staff
     //Creates a new PartTimeStaffHire object and adds it to the staffList
    private void addPartTimeStaff() {
        try {
            // Get values from input fields
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            String designation = txtDesignation.getText();
            String jobType = txtJobType.getText();
            String staffName = txtStaffName.getText();
            String joiningDate = txtJoiningDate.getText();
            String qualification = txtQualification.getText();
            String appointedBy = txtAppointedBy.getText();
            boolean joined = chkJoined.isSelected();
            int workingHour = Integer.parseInt(txtWorkingHour.getText());
            double wagesPerHour = Double.parseDouble(txtWagesPerHour.getText());
            String shifts = txtShifts.getText();
            
            // Validate inputs
            if (designation.isEmpty() || jobType.isEmpty() || staffName.isEmpty() ||
                joiningDate.isEmpty() || qualification.isEmpty() || appointedBy.isEmpty() || shifts.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Create new PartTimeStaffHire object
            PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(
                vacancyNumber, designation, jobType, staffName, joiningDate,
                qualification, appointedBy, joined, workingHour, wagesPerHour, shifts
            );
            
            // Add to list
            staffList.add(partTimeStaff);
            
            // Show success message
            JOptionPane.showMessageDialog(this, "Part Time Staff added successfully!");
            
            // Clear fields
            clearFields();
            
            // Display updated list
            displayStaffList();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Vacancy Number, Working Hours, and Wages Per Hour.", 
                                         "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //Method to set the salary of a full-time staff
    //Finds the staff with the given vacancy number and sets the salary
    private void setSalary() {
        try {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            double newSalary = Double.parseDouble(txtSalary.getText());
            
            boolean found = false;
            
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff instanceof FullTimeStaffHire) {
                    // Cast to FullTimeStaffHire
                    FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                    fullTimeStaff.setSalary(newSalary);
                    found = true;
                    JOptionPane.showMessageDialog(this, "Salary updated successfully!");
                    break;
                }
            }
            
            if (!found) {
                JOptionPane.showMessageDialog(this, "No full-time staff found with vacancy number " + vacancyNumber, 
                                             "Not Found", JOptionPane.ERROR_MESSAGE);
            }
            
            // Display updated list
            displayStaffList();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Vacancy Number and Salary.", 
                                         "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
     //Method to set the working shifts of a part-time staff
     //Finds the staff with the given vacancy number and sets the shifts
    
    private void setWorkingShifts() {
        try {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            String newShifts = txtShifts.getText();
            
            if (newShifts.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter shifts.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            boolean found = false;
            
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff instanceof PartTimeStaffHire) {
                    // Cast to PartTimeStaffHire
                    PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                    partTimeStaff.setShifts(newShifts);
                    found = true;
                    JOptionPane.showMessageDialog(this, "Shifts updated successfully!");
                    break;
                }
            }
            
            if (!found) {
                JOptionPane.showMessageDialog(this, "No part-time staff found with vacancy number " + vacancyNumber, 
                                             "Not Found", JOptionPane.ERROR_MESSAGE);
            }
            
            // Display updated list
            displayStaffList();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid vacancy number.", 
                                         "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //Method to terminate a part-time staff
    //Finds the staff with the given vacancy number and terminates them
    
    private void terminateStaff() {
        try {
            int terminateNumber = Integer.parseInt(txtTerminateNumber.getText());
            
            boolean found = false;
            
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == terminateNumber && staff instanceof PartTimeStaffHire) {
                    // Cast to PartTimeStaffHire
                    PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                    partTimeStaff.terminateStaff();
                    found = true;
                    JOptionPane.showMessageDialog(this, "Staff terminated successfully!");
                    break;
                }
            }
            
            if (!found) {
                JOptionPane.showMessageDialog(this, "No part-time staff found with vacancy number " + terminateNumber, 
                                             "Not Found", JOptionPane.ERROR_MESSAGE);
            }
            
            // Display updated list
            displayStaffList();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid vacancy number to terminate.", 
                                         "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Method to display a specific staff
    //Finds the staff with the given index and displays their details
    
    private void displayStaff() {
        try {
            int displayNumber = Integer.parseInt(txtDisplayNumber.getText());
            
            // Check if the display number is valid
            if (displayNumber < 0 || displayNumber >= staffList.size()) {
                JOptionPane.showMessageDialog(this, "Invalid display number. Please enter a number between 0 and " + (staffList.size() - 1), 
                                             "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Get the staff at the specified index
            StaffHire staff = staffList.get(displayNumber);
            
            // Clear the display area
            displayArea.setText("");
            
            // Create a custom display method to append to the display area
            displayStaffToTextArea(staff);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid display number.", 
                                         "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "No staff found at the specified index.", 
                                         "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //Method to display the details of a staff to the text area
    private void displayStaffToTextArea(StaffHire staff) {
        // Create a formatted display with consistent spacing and headers
        displayArea.append("\n╔══════════════════════════════════════════════════╗\n");
        displayArea.append("║              STAFF DETAILS                       ║\n");
        displayArea.append("╠══════════════════════════════════════════════════╣\n");
        
        // Format common details
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Vacancy Number", staff.getVacancyNumber()));
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Designation", staff.getDesignation()));
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Job Type", staff.getJobType()));
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Staff Name", staff.getStaffName()));
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Joining Date", staff.getJoiningDate()));
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Qualification", staff.getQualification()));
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Appointed By", staff.getAppointedBy()));
        displayArea.append(String.format("║ %-20s: %-27s ║\n", "Joined", (staff.isJoined() ? "Yes" : "No")));
        
        if (staff instanceof FullTimeStaffHire) {
            FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
            
            // Add full-time specific header
            displayArea.append("╠──────────────────────────────────────────────────╣\n");
            displayArea.append("║              FULL-TIME DETAILS                   ║\n");
            displayArea.append("╠──────────────────────────────────────────────────╣\n");
            
            // Format full-time specific details
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Salary", fullTimeStaff.getSalary()));
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Weekly Hours", fullTimeStaff.getWeeklyFractionalHours()));
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Terminated", (fullTimeStaff.isTerminated() ? "Yes" : "No")));
            
        } else if (staff instanceof PartTimeStaffHire) {
            PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
            
            // Add part-time specific header
            displayArea.append("╠──────────────────────────────────────────────────╣\n");
            displayArea.append("║              PART-TIME DETAILS                   ║\n");
            displayArea.append("╠──────────────────────────────────────────────────╣\n");
            
            // Format part-time specific details
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Working Hours", partTimeStaff.getWorkingHour()));
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Wages Per Hour", partTimeStaff.getWagesPerHour()));
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Shifts", partTimeStaff.getShifts()));
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Income Per Day", 
                (partTimeStaff.getWorkingHour() * partTimeStaff.getWagesPerHour())));
            displayArea.append(String.format("║ %-20s: %-27s ║\n", "Terminated", (partTimeStaff.isTerminated() ? "Yes" : "No")));
        }
        
        // Close the details box
        displayArea.append("╚══════════════════════════════════════════════════╝\n");
    }
    
    
     // Method to display all staff in the list
     //Displays basic information for each staff in a tabular format
     
    private void displayStaffList() {
        displayArea.setText("");
        
        if (staffList.isEmpty()) {
            displayArea.append("\n\n   No staff records found in the system.\n   Use 'Add Full Time Staff' or 'Add Part Time Staff' to add new records.\n\n");
            return;
        }
        
        // Header for staff list
        displayArea.append("\n╔═══════════════════════════════════════════════════════════════════════════╗\n");
        displayArea.append("║                             STAFF LIST                                     ║\n");
        displayArea.append("╠═════╦═══════════════╦════════════════════════╦══════════════╦═════════════╣\n");
        displayArea.append("║ IDX ║ VACANCY NO.   ║ STAFF NAME             ║ DESIGNATION   ║ STAFF TYPE  ║\n");
        displayArea.append("╠═════╬═══════════════╬════════════════════════╬══════════════╬═════════════╣\n");
        
        // Display each staff member in a nicely formatted row
        for (int i = 0; i < staffList.size(); i++) {
            StaffHire staff = staffList.get(i);
            String staffType = staff instanceof FullTimeStaffHire ? "Full Time" : "Part Time";
            
            // Format each row with consistent spacing
            displayArea.append(String.format("║ %3d ║ %-13d ║ %-22s ║ %-12s ║ %-11s ║\n", 
                i, staff.getVacancyNumber(), staff.getStaffName(), staff.getDesignation(), staffType));
        }
        
        // Footer
        displayArea.append("╚═════╩═══════════════╩════════════════════════╩══════════════╩═════════════╝\n");
        displayArea.append("\nTotal staff: " + staffList.size() + 
                          " (Full-time: " + countFullTimeStaff() + ", Part-time: " + countPartTimeStaff() + ")\n");
    }
    
    
     //Helper method to count full-time staff
    private int countFullTimeStaff() {
        int count = 0;
        for (StaffHire staff : staffList) {
            if (staff instanceof FullTimeStaffHire) {
                count++;
            }
        }
        return count;
    }
    
    
     //Helper method to count part-time staff
    private int countPartTimeStaff() {
        int count = 0;
        for (StaffHire staff : staffList) {
            if (staff instanceof PartTimeStaffHire) {
                count++;
            }
        }
        return count;
    }
    
    
    //Method to clear all input fields
    private void clearFields() {
        txtVacancyNumber.setText("");
        txtDesignation.setText("");
        txtJobType.setText("");
        txtStaffName.setText("");
        txtJoiningDate.setText("");
        txtQualification.setText("");
        txtAppointedBy.setText("");
        chkJoined.setSelected(false);
        txtSalary.setText("");
        txtWeeklyFractionalHours.setText("");
        txtWorkingHour.setText("");
        txtWagesPerHour.setText("");
        txtShifts.setText("");
        txtDisplayNumber.setText("");
        txtTerminateNumber.setText("");
        txtSearchKeyword.setText("");
        cmbSearchField.setSelectedIndex(0);
        cmbFilterJobType.setSelectedIndex(0);
        rdoAllStaff.setSelected(true);
    }
    
    
    //Method to search for staff based on given criteria
    //Filters the staffList based on the search parameters and displays the results
      
    private void searchStaff() {
        // Get search parameters
        String searchField = (String) cmbSearchField.getSelectedItem();
        String searchKeyword = txtSearchKeyword.getText().trim().toLowerCase();
        String jobTypeFilter = (String) cmbFilterJobType.getSelectedItem();
        
        // If search keyword is empty but job type or staff type filters are selected, just apply those filters
        if (searchKeyword.isEmpty() && jobTypeFilter.equals("All Job Types") && rdoAllStaff.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please enter a search keyword or select filter criteria.", 
                                         "Search Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Clear display area
        displayArea.setText("");
        
        // Filter variables
        boolean filterByJobType = !jobTypeFilter.equals("All Job Types");
        boolean filterFullTime = rdoFullTime.isSelected();
        boolean filterPartTime = rdoPartTime.isSelected();
        
        // Counter for found results
        int resultsFound = 0;
        displayArea.append("Search Results:\n");
        displayArea.append("---------------------------------------------------------------------\n");
        
        // Go through each staff in the list
        for (StaffHire staff : staffList) {
            boolean matches = true;
            
            // Filter by staff type if full-time or part-time is selected
            if (filterFullTime && !(staff instanceof FullTimeStaffHire)) {
                continue;
            }
            if (filterPartTime && !(staff instanceof PartTimeStaffHire)) {
                continue;
            }
            
            // Filter by job type if selected
            if (filterByJobType && !staff.getJobType().equalsIgnoreCase(jobTypeFilter)) {
                continue;
            }
            
            // Apply search keyword based on selected field
            if (!searchKeyword.isEmpty()) {
                switch(searchField) {
                    case "All Fields":
                        // Search in all text fields
                        matches = (String.valueOf(staff.getVacancyNumber()).toLowerCase().contains(searchKeyword) ||
                                  staff.getStaffName().toLowerCase().contains(searchKeyword) ||
                                  staff.getDesignation().toLowerCase().contains(searchKeyword) ||
                                  staff.getJobType().toLowerCase().contains(searchKeyword) ||
                                  staff.getQualification().toLowerCase().contains(searchKeyword) ||
                                  staff.getAppointedBy().toLowerCase().contains(searchKeyword));
                        break;
                    case "Vacancy Number":
                        matches = String.valueOf(staff.getVacancyNumber()).toLowerCase().contains(searchKeyword);
                        break;
                    case "Staff Name":
                        matches = staff.getStaffName().toLowerCase().contains(searchKeyword);
                        break;
                    case "Designation":
                        matches = staff.getDesignation().toLowerCase().contains(searchKeyword);
                        break;
                    case "Job Type":
                        matches = staff.getJobType().toLowerCase().contains(searchKeyword);
                        break;
                    case "Qualification":
                        matches = staff.getQualification().toLowerCase().contains(searchKeyword);
                        break;
                    case "Appointed By":
                        matches = staff.getAppointedBy().toLowerCase().contains(searchKeyword);
                        break;
                    default:
                        matches = false;
                }
            }
            
            // If staff matches all criteria, display it
            if (matches) {
                displayStaffToTextArea(staff);
                displayArea.append("---------------------------------------------------------------------\n");
                resultsFound++;
            }
        }
        
        // Show message if no results found
        if (resultsFound == 0) {
            displayArea.append("No matching staff found.\n");
        } else {
            displayArea.append("\nTotal results found: " + resultsFound + "\n");
        }
    }
    
    private void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(new Color(50, 50, 50));
        comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
            BorderFactory.createEmptyBorder(3, 5, 3, 5)
        ));
        
        // Set renderer for items
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JComponent comp = (JComponent) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                if (isSelected) {
                    comp.setBackground(new Color(210, 230, 255));
                    comp.setForeground(new Color(0, 0, 100));
                } else {
                    comp.setBackground(Color.WHITE);
                    comp.setForeground(new Color(50, 50, 50));
                }
                
                comp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                return comp;
            }
        });
    }
    
    
    //Shows a welcome message in the display area
    
    private void showWelcomeMessage() {
    
        displayArea.setText("Welcome to the Staff Recruitment System!\n\n" +
            "Use the input fields above to add, update, or display staff details.\n" +
            "The Search & Filter panel allows you to quickly find staff based on various criteria.\n" +
            "Click on 'Help' for detailed instructions on how to use all features of the system.\n\n" +
            "TIP: Click 'Load Sample Data' to populate the system with demo staff records.");
    }
    
    
     //Loads sample data into the system for demonstration purposes
     //Creates a set of full-time and part-time staff with various attributes

    private void loadSampleData() {
        // Check if there's already data in the system
        if (!staffList.isEmpty()) {
            // Ask for confirmation before overwriting existing data
            int response = JOptionPane.showConfirmDialog(
                this,
                "This will add sample staff records to the existing data. Continue?",
                "Confirm Load Sample Data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (response != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
        try {
            // Sample full-time staff
            staffList.add(new FullTimeStaffHire(
                101, "Software Developer", "IT", "John Smith", "01/03/2023",
                "BSc Computer Science", "HR Department", true, 75000.0, 40
            ));
            
            staffList.add(new FullTimeStaffHire(
                102, "Senior Manager", "Management", "Emily Johnson", "15/08/2022",
                "MBA", "CEO", true, 95000.0, 38
            ));
            
            staffList.add(new FullTimeStaffHire(
                103, "Financial Analyst", "Finance", "Robert Chen", "12/01/2023",
                "MSc Finance", "Finance Director", true, 65000.0, 35
            ));
            
            staffList.add(new FullTimeStaffHire(
                104, "HR Specialist", "Human Resources", "Sarah Williams", "20/11/2022",
                "BSc Human Resources", "HR Director", true, 58000.0, 40
            ));
            
            // Sample part-time staff
            PartTimeStaffHire part1 = new PartTimeStaffHire(
                201, "Research Assistant", "Research", "Michael Brown", "05/02/2023",
                "PhD Candidate", "Research Director", true, 20, 18.50, "Morning"
            );
            staffList.add(part1);
            
            staffList.add(new PartTimeStaffHire(
                202, "Teaching Assistant", "Education", "Jessica Lee", "10/09/2022",
                "MSc Education", "Department Head", true, 15, 22.75, "Afternoon"
            ));
            
            PartTimeStaffHire part3 = new PartTimeStaffHire(
                203, "Customer Service Rep", "Support", "David Wilson", "15/12/2022",
                "High School Diploma", "Support Manager", true, 25, 16.50, "Evening"
            );
            staffList.add(part3);
            
            // Terminate one of the part-time staff
            part3.terminateStaff();
            
            // Add different job types
            staffList.add(new FullTimeStaffHire(
                105, "Marketing Specialist", "Marketing", "Patricia Garcia", "03/04/2023",
                "BSc Marketing", "Marketing Director", true, 62000.0, 38
            ));
            
            staffList.add(new PartTimeStaffHire(
                204, "Graphic Designer", "Creative", "Thomas Moore", "22/01/2023",
                "BA Design", "Creative Director", true, 18, 25.00, "Flexible"
            ));
            
            // Display success message and update display
            JOptionPane.showMessageDialog(this, 
                "Successfully loaded 9 sample staff records (5 full-time, 4 part-time).", 
                "Sample Data Loaded", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // Show the data
            displayStaffList();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error loading sample data: " + e.getMessage(), 
                "Sample Data Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
     //Method to show statistics about the staff in the system
     //Calculates and displays various metrics such as counts, averages, etc.
    
    private void showStaffStatistics() {
        if (staffList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No staff records to analyze.", 
                                         "Statistics Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Clear display area
        displayArea.setText("");
        
        // Counter variables
        int fullTimeCount = 0;
        int partTimeCount = 0;
        int terminatedCount = 0;
        double totalFullTimeSalary = 0;
        double totalPartTimeWages = 0;
        double totalPartTimeHours = 0;
        
        // Count job types
        java.util.Map<String, Integer> jobTypeCounts = new java.util.HashMap<>();
        
        // Analyze staff data
        for (StaffHire staff : staffList) {
            // Count by job type
            String jobType = staff.getJobType();
            jobTypeCounts.put(jobType, jobTypeCounts.getOrDefault(jobType, 0) + 1);
            
            if (staff instanceof FullTimeStaffHire) {
                FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                fullTimeCount++;
                totalFullTimeSalary += fullTimeStaff.getSalary();
            } else if (staff instanceof PartTimeStaffHire) {
                PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                partTimeCount++;
                totalPartTimeWages += partTimeStaff.getWagesPerHour();
                totalPartTimeHours += partTimeStaff.getWorkingHour();
                
                if (partTimeStaff.isTerminated()) {
                    terminatedCount++;
                }
            }
        }
        
        // Calculate averages
        double avgFullTimeSalary = fullTimeCount > 0 ? totalFullTimeSalary / fullTimeCount : 0;
        double avgPartTimeWages = partTimeCount > 0 ? totalPartTimeWages / partTimeCount : 0;
        double avgPartTimeHours = partTimeCount > 0 ? totalPartTimeHours / partTimeCount : 0;
        
        // Display statistics
        displayArea.append("╔══════════════════════════════════════════════════╗\n");
        displayArea.append("║              STAFF STATISTICS                    ║\n");
        displayArea.append("╠══════════════════════════════════════════════════╣\n");
        
        // Overall statistics
        displayArea.append(String.format("║ %-20s: %-27d ║\n", "Total Staff", staffList.size()));
        displayArea.append(String.format("║ %-20s: %-27d ║\n", "Full-Time Staff", fullTimeCount));
        displayArea.append(String.format("║ %-20s: %-27d ║\n", "Part-Time Staff", partTimeCount));
        displayArea.append(String.format("║ %-20s: %-27d ║\n", "Terminated Staff", terminatedCount));
        
        // Salary statistics
        displayArea.append("╠══════════════════════════════════════════════════╣\n");
        displayArea.append("║              FINANCIAL METRICS                   ║\n");
        displayArea.append("╠══════════════════════════════════════════════════╣\n");
        displayArea.append(String.format("║ %-20s: %-27.2f ║\n", "Avg Full-Time Salary", avgFullTimeSalary));
        displayArea.append(String.format("║ %-20s: %-27.2f ║\n", "Avg Part-Time Wages", avgPartTimeWages));
        displayArea.append(String.format("║ %-20s: %-27.2f ║\n", "Avg Part-Time Hours", avgPartTimeHours));
        
        // Job type distribution
        displayArea.append("╠══════════════════════════════════════════════════╣\n");
        displayArea.append("║              JOB TYPE DISTRIBUTION               ║\n");
        displayArea.append("╠══════════════════════════════════════════════════╣\n");
        
        for (java.util.Map.Entry<String, Integer> entry : jobTypeCounts.entrySet()) {
            displayArea.append(String.format("║ %-20s: %-27d ║\n", entry.getKey(), entry.getValue()));
        }
        
        displayArea.append("╚══════════════════════════════════════════════════╝\n");
    }
    
    
     //Method to export staff data to a text file
     //Creates a formatted text file with all staff information
     
    private void exportStaffData() {
        if (staffList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No staff records to export.", 
                                         "Export Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        try {
            // Create a file to write data
            java.io.File file = new java.io.File("staff_data_export.txt");
            java.io.PrintWriter writer = new java.io.PrintWriter(file);
            
            // Write header
            writer.println("=======================================================");
            writer.println("                 STAFF DATA EXPORT                     ");
            writer.println("=======================================================");
            writer.println("Export Date: " + java.time.LocalDate.now());
            writer.println("Total Records: " + staffList.size());
            writer.println("=======================================================");
            writer.println();
            
            // Write data for each staff member
            int index = 0;
            for (StaffHire staff : staffList) {
                writer.println("RECORD #" + index++);
                writer.println("-------------------------------------------------------");
                writer.println("Vacancy Number: " + staff.getVacancyNumber());
                writer.println("Staff Name: " + staff.getStaffName());
                writer.println("Designation: " + staff.getDesignation());
                writer.println("Job Type: " + staff.getJobType());
                writer.println("Joined: " + (staff.isJoined() ? "Yes" : "No"));
                writer.println("Joining Date: " + staff.getJoiningDate());
                writer.println("Qualification: " + staff.getQualification());
                writer.println("Appointed By: " + staff.getAppointedBy());
                
                // Write type-specific information
                if (staff instanceof FullTimeStaffHire) {
                    FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                    writer.println("Staff Type: Full-Time");
                    writer.println("Salary: " + fullTimeStaff.getSalary());
                    writer.println("Weekly Hours: " + fullTimeStaff.getWeeklyFractionalHours());
                } else if (staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                    writer.println("Staff Type: Part-Time");
                    writer.println("Working Hours: " + partTimeStaff.getWorkingHour());
                    writer.println("Wages Per Hour: " + partTimeStaff.getWagesPerHour());
                    writer.println("Shifts: " + partTimeStaff.getShifts());
                    writer.println("Terminated: " + (partTimeStaff.isTerminated() ? "Yes" : "No"));
                }
                
                writer.println();
                writer.println("-------------------------------------------------------");
                writer.println();
            }
            
            // Close the writer
            writer.close();
            
            // Show success message
            JOptionPane.showMessageDialog(this, "Staff data exported successfully to: " + file.getAbsolutePath(), 
                                         "Export Successful", JOptionPane.INFORMATION_MESSAGE);
            
            // Display message in the display area
            displayArea.setText("Staff data has been exported to: " + file.getAbsolutePath() + "\n\n" +
                              "The file contains detailed information about all " + staffList.size() + " staff members.\n" +
                              "You can open this file with any text editor to view or print the data.");
            
        } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error exporting staff data: " + e.getMessage(), 
                                         "Export Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void styleTextField(JTextField textField) {
        try {
            // Set basic properties
            textField.setFont(new Font("Arial", Font.PLAIN, 12));
            textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                BorderFactory.createEmptyBorder(4, 6, 4, 6)
            ));
            
            // Add focus listener for highlight effect
            textField.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    textField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(51, 153, 255), 2),
                        BorderFactory.createEmptyBorder(3, 5, 3, 5)
                    ));
                }
                
                public void focusLost(FocusEvent e) {
                    textField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(180, 180, 180)),
                        BorderFactory.createEmptyBorder(4, 6, 4, 6)
                    ));
                }
            });
        } catch (Exception e) {
            // Fallback to default style if custom styling fails
            System.out.println("Using default text field style due to Look & Feel constraints");
        }
    }
    //Button Styles
    private JButton createStyledButton(String text, final Color backgroundColor) {
        final JButton button = new JButton(text);
        
        try {
            // Set visual properties
            button.setBackground(backgroundColor);
            button.setForeground(Color.BLACK);
            button.setFont(new Font("Arial", Font.BOLD, 12));
            
            // These might not work
            try {
                button.setFocusPainted(false);
                button.setBorderPainted(true);
            } catch (Exception e) {
            }
            
            button.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    
                    int r = Math.min(255, backgroundColor.getRed() + 20);
                    int g = Math.min(255, backgroundColor.getGreen() + 20);
                    int b = Math.min(255, backgroundColor.getBlue() + 20);
                    Color brighterColor = new Color(r, g, b);
                    button.setBackground(brighterColor);
                }
                
                public void mouseExited(MouseEvent evt) {
                    button.setBackground(backgroundColor);
                }
            });
        } catch (Exception e) {
            // Fallback to default button style if custom styling fails
            System.out.println("Using default button style due to Look & Feel constraints");
        }
        
        return button;
    }
    
    
     //Main method to start the application

    public static void main(String[] args) {
        
        // Create and display the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RecruitmentSystem gui = new RecruitmentSystem();
                gui.setVisible(true);
                System.out.println("GUI launched successfully!");
            }
        });
    }
}
