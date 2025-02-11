# Hospital Admin Menu

## Overview
This is a simple **Java-based Hospital Administration System** that allows managing patients, doctors, and their associated data using basic file storage.

## Features
- **Manage Patients**: Add, view, and update patients.
- **Manage Doctors**: Add, view, and assign doctors to patients.
- **Billing System**: Update and track patient bills.
- **File Storage**: Data is saved and loaded from text files (`patients.txt`, `doctors.txt`).
- **Simple Console Menu**: Easy-to-use terminal-based interface.

## How to Run
### **Compile and Run **
1. **Compile all Java files:**
   ```sh
   javac src/*.java
   ```
2. **Run the program:**
   ```sh
   java -cp src HospitalAdminMain
   ```

## File Storage Details
- **patients.txt** → Stores patient data (`ID, Name, Age, Ailment, Bill Amount`).
- **doctors.txt** → Stores doctor data (`ID, Name, Specialty`).



