import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatientProfInterface {

    private PatientProfDB database;
    private Scanner in;

    PatientProfInterface(String filename){
        this.database = new PatientProfDB(filename);

    }

    public void getUserChoice(){
        int numOfChoices = 8;
        boolean exit = false;
        in = new Scanner(System.in);

        do {
            System.out.println("Please enter a number to choose an option listed below");
            System.out.println("1: Enter a New Patient Profile");
            System.out.println("2: Delete a Patient Profile");
            System.out.println("3: Find a Patient Profile");
            System.out.println("4: Modify Patient Profile Info");
            System.out.println("5: Display all Patient Profiles");
            System.out.println("6: Write to database");
            System.out.println("7: Initialize database");
            System.out.println("0: Exit");
            System.out.print(">");

            boolean valid = false;
            int selection = 0;

            while (!valid) {
                String response = in.nextLine();
                try {
                    selection = Integer.parseInt(response);
                    valid = (selection >= 0 && selection < numOfChoices);
                } catch (NumberFormatException e) {
                }

                if (!valid) {
                    System.out.println("Invalid Choice please choose a number listed above");
                    System.out.print(">");
                }
            }

            switch (selection) {
                case 0:
                    System.out.println("Chose 0");
                    exit = true;
                    break;
                case 1:
                    System.out.println("Chose 1");
                    addNewPatient();
                    break;
                case 2:
                    System.out.println("Chose 2");
                    deletePatientProfile();
                    break;
                case 3:
                    System.out.println("Chose 3");
                    findPatientProfile();
                    break;
                case 4:
                    System.out.println("Chose 4");
                    break;
                case 5:
                    System.out.println("Chose 5");
                    displayAllPatientProf();
                    break;
                case 6:
                    System.out.println("Chose 6");
                    writeToDB();
                    break;
                case 7:
                    System.out.println("Chose 7");
                    initDB();
                    break;
                default:
                    throw new RuntimeException("Invalid Menu Choice");

            }


        }while(!exit);

        in.close();

    }

    public void deletePatientProfile(){
        String adminID;
        String lastName;
        boolean valid;

        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);

        valid = false;

        do{
            System.out.print("Enter Last Name: ");
            lastName =  in.nextLine();
            valid = Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName);
            if (!valid){
                System.out.println("Invalid Last Name. Please try again");
            }
        }while(!valid);

        if(!database.deleteProfile(adminID, lastName)){
            System.out.println("ERROR: Deletion could not be completed");
        }


    }

    public void findPatientProfile(){
        String adminID;
        String lastName;
        boolean valid;

        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);

        valid = false;

        do{
            System.out.print("Enter Last Name: ");
            lastName =  in.nextLine();
            valid = Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName);
            if (!valid){
                System.out.println("Invalid Last Name. Please try again");
            }
        }while(!valid);

        PatientProf profile = database.findProfile(adminID, lastName);
        if (profile != null){
            displayPatientProf(profile);
        }else{
            System.out.println("ERROR: Patient could not be found");
        }

    }

    public void updatePatientProf(){

        String adminID;
        String lastName;
        boolean valid;
        int numOfChoices = 10;

        System.out.println("Enter AdminID and Last Name of Patient you want to modify");

        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);

        valid = false;

        do{
            System.out.print("Enter Last Name: ");
            lastName =  in.nextLine();
            valid = Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName);
            if (!valid){
                System.out.println("Invalid Last Name. Please try again");
            }
        }while(!valid);

        PatientProf profile = database.findProfile(adminID, lastName);


            System.out.println("Please enter a number to choose an option listed below");
            System.out.println("1: Modify Address");
            System.out.println("2: Modify Phone number");
            System.out.println("3: Modify Insurance Type");
            System.out.println("4: Modify Co-pay");
            System.out.println("5: Modify Patient Type");
            System.out.println("Medical Condition Options");
            System.out.println("6: Modify Medical Contact");
            System.out.println("7: Modify Medical Contact Phone Number");
            System.out.println("8: Modify Allergy Type");
            System.out.println("9: Modify Illness Type");
            System.out.println("0: Exit");
            System.out.print(">");

            valid = false;
            int selection = 0;

            while (!valid) {
                String response = in.nextLine();
                try {
                    selection = Integer.parseInt(response);
                    valid = (selection >= 0 && selection < numOfChoices);
                } catch (NumberFormatException e) {
                }

                if (!valid) {
                    System.out.println("Invalid Choice please choose a number listed above");
                    System.out.print(">");
                }
            }

            System.out.print("Enter new value: ");
            String newValue = in.nextLine();

            switch (selection) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }





    }

    private void displayPatientProf(PatientProf profile){

        System.out.println("Patient Information");
        System.out.println("First Name: " + profile.getFirstName());
        System.out.println("Last Name: " + profile.getLastName());
        System.out.println("Admin ID: " + profile.getadminID());
        System.out.println("Address: " + profile.getAddress());
        System.out.println("Phone: " + profile.getPhone());
        System.out.println("Co-pay: " + profile.getCoPay());
        System.out.println("Insurance Type: " + profile.getInsuType());
        System.out.println("Patient Type: " + profile.getPatientType());
        System.out.println("Medical Condition Information");
        //TODO: Print MedCond info

        System.out.print("Hit <ENTER> to continue...");
        in.nextLine();


    }

    public void displayAllPatientProf(){
        String adminID;
        boolean valid;

        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);

        PatientProf curProfile = database.findFirstProfile(adminID);

        while(curProfile != null){
            displayPatientProf(curProfile);
            curProfile = database.findNextProfile();
        }

        System.out.println("End of Profiles for Admin ID: " + adminID);

        System.out.print("Hit <ENTER> to continue...");
        in.nextLine();

    }

    public void writeToDB(){
        System.out.println("Enter a filename to write to: ");

        String filename = in.nextLine();

        database.writeAllPatientProf(filename);

    }

    public void initDB(){

        System.out.println("Enter a filename:");
        String filename = in.nextLine();

        database.initializeDatabase(filename);
    }

    public void addNewPatient(){
        PatientProf newPatient = createNewPatientProf();
        database.insertNewProfile(newPatient);
    }

    public PatientProf createNewPatientProf(){
        String curInput;
        boolean valid;
        PatientProf newPatient = null;

        do {
            System.out.println("Fill in the information for the patient below");
            try {
                System.out.print("Admin ID: ");
                String adminID = in.nextLine();
                System.out.print("First Name: ");
                String firstName = in.nextLine();
                System.out.print("Last Name: ");
                String lastName = in.nextLine();
                System.out.print("Address: ");
                String address = in.nextLine();
                System.out.print("Phone: ");
                String phone = in.nextLine();
                System.out.print("Co-Pay: ");
                float coPay = Float.parseFloat(in.nextLine());
                System.out.print("Insurance Type: ");
                String insuType = in.nextLine();
                System.out.print("Patient Type: ");
                String patientType = in.nextLine();

                MedCond medCondInfo = createNewMedCond();

                newPatient = new PatientProf(adminID, firstName, lastName, address, phone,
                        coPay, insuType, patientType, medCondInfo);

                valid = true;

            } catch (NumberFormatException e) {
                valid = false;
                System.out.println("Invalid Input: ");
                System.out.println("Co-pay must be a number. Please Try again. ");
            } catch (RuntimeException e) {
                valid = false;
                System.out.println("Invalid Input: ");
                System.out.println(e.getMessage());
            }
        }while(!valid);

        return newPatient;
    }

    public MedCond createNewMedCond(){
        return null;
    }

    public static void main(String[] args){
        PatientProfInterface test = new PatientProfInterface("file");
        test.getUserChoice();

    }

}
