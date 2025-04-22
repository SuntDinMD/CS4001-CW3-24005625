------------------------------------------------------------------------
			STAFF RECRUITMENT SYSTEM
------------------------------------------------------------------------

PROJECT TITLE: Staff Recruitment System
PURPOSE OF PROJECT: To manage full-time and part-time staff hiring using object-oriented principles
VERSION: 1.0
DEVELOPED FOR: BlueJ
DATE: March 2025

------------------------------------------------------------------------
HOW TO START THIS PROJECT IN BLUEJ:
------------------------------------------------------------------------
1. Open the project folder in BlueJ
2. Right-click on the RecruitmentSystem class and select "new RecruitmentSystem()" 
3. An object will be created in the object bench
------------------------------------------------------------------------
DATA ENTRY INSTRUCTIONS:
------------------------------------------------------------------------
COMMON FIELDS (Required for all staff):
- Vacancy Number: Unique ID number for the position (integer)
- Designation: Job title or position name
- Job Type: Category of employment
- Staff Name: Full name of the employee
- Joining Date: Date when employment begins (format: DD-MM-YYYY)
- Qualification: Education or certification held
- Appointed By: Name of hiring manager
- Joined: Check this box if the staff has joined

FULL-TIME STAFF FIELDS:
- Salary: Annual salary amount (numeric)
- Weekly Hours: Number of working hours per week (integer)

PART-TIME STAFF FIELDS:
- Working Hours: Number of hours per week (integer)
- Wages Per Hour: Hourly pay rate (numeric)
- Shifts: Working shift pattern (e.g., "Morning", "Evening", "Weekend")

OPERATION FIELDS:
- Display Number: Staff index number to display (integer)
- Terminate Number: Vacancy number of part-time staff to terminate (integer)

------------------------------------------------------------------------
BUTTON FUNCTIONS:
------------------------------------------------------------------------
STAFF MANAGEMENT:
- Add Full Time Staff: Creates a new full-time employee record
- Add Part Time Staff: Creates a new part-time employee record
- Set Salary: Updates salary for existing full-time staff
- Set Working Shifts: Changes shift pattern for part-time staff
- Terminate Staff: Ends employment for a part-time staff member
- Display Staff: Shows details for a specific staff by index
- Display All Staff: Lists all staff currently in the system
- Search Staff: Find staff matching specific criteria
- Staff Statistics: View counts, averages, and distributions
- Export Data: Save all staff records to a text file

UTILITIES:
- Load Sample Data: Populate the system with demo staff records
- Help: Displays usage instructions
- About: Shows application information
- Clear: Resets all input fields

------------------------------------------------------------------------
CLASS DESCRIPTIONS:
------------------------------------------------------------------------
1. StaffHire (Parent class)
   - Common attributes for all staff types
   - Handles basic staff information management

2. FullTimeStaffHire (Subclass)
   - Extends StaffHire for full-time employment
   - Includes salary and weekly hours management
   - Allows salary adjustments

3. PartTimeStaffHire (Subclass)
   - Extends StaffHire for part-time employment
   - Handles hourly wages, work hours and shifts
   - Supports shift changes and termination

4. RecruitmentSystem (Main GUI class)
   - Provides interactive interface for the recruitment system
   - Manages staff data collection and display
   - Includes validation and error handling
   - Features advanced functionality like statistics and data export
  

