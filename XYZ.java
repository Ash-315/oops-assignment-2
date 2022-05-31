package assignment_2;

import java.util.*;

public class XYZ { 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        Applicant a1  = new Applicant(); //Object of class Applicant
        String initial_documents = a1.getApplicantAttributes(); //Sets name, age, gender, phone number, email and nationality
        String all_valid = "Invalid"; //Variable to hold all documents validity (initialized to invalid)
        Assistant_Registration_Officer ar1 = new Assistant_Registration_Officer(); //Object of class Assistant_Registration_Officer
        
        String appl_nationality = a1.getNationality(); //Gets nationality 
        
        //all System.out.println(""); statement at any point in the code exists only to make the output screen look cleaner and make it easier to understand
        //all while() loops at any point in the code exists only to prevent user from inputting wrong/invalid information (such as 'null')
        String pass_validity = a1.getPassport(); //Gets passport validity
        String verifyPass = ar1.verifyPassport(pass_validity); //Checks and assigns passport validity
        if(verifyPass.equalsIgnoreCase("Valid")) { //Passport valid
            System.out.println("Valid passport, proceeding to vaccination certificate");
            System.out.println("");
        }
        else if(verifyPass.equalsIgnoreCase("Invalid")) { //Passport invalid
            while(verifyPass.equalsIgnoreCase("Invalid")) {
                System.out.println("Provide a valid passport and try again");
                System.out.println("");
                pass_validity = a1.getPassport();
                verifyPass = ar1.verifyPassport(pass_validity);
            }
            System.out.println("Valid passport, proceeding to vaccination certificate verification");
            System.out.println("");
        }
        
        String vacc_validity = a1.getVaccination(); //Gets vaccination validity
        String verifyVacc = ar1.verifyVaccination(vacc_validity); //Checks and assigns vaccination validity
        if(verifyVacc.equalsIgnoreCase("valid")) { //Vaccination certificate valid
            System.out.println("Valid vaccination certificate, proceeding to medical certificate verification");
            System.out.println("");
        }
        else if(verifyVacc.equalsIgnoreCase("Invalid")) { //Vaccination certificate invalid
            while(verifyVacc.equalsIgnoreCase("Invalid")) {
                System.out.println("Provide a valid vaccination certificate and try again");
                System.out.println("");
                vacc_validity = a1.getVaccination();
                verifyVacc = ar1.verifyVaccination(vacc_validity);
            }
            System.out.println("Valid vaccination certificate, proceeding to medical certificate verification");
            System.out.println("");
        }
        
        String medi_validity = a1.getMedical();  //Gets medical certificate validity
        String verifyMedi = ar1.verifyMedical(medi_validity); //Checks and assigns medical certificate validity
        if(verifyMedi.equalsIgnoreCase("Valid")) { //Medical certificate valid
            System.out.println("Valid medical certificate, proceeding to payment status check");
            System.out.println("");
        }
        else if(verifyMedi.equalsIgnoreCase("Invalid")) {
            while(verifyMedi.equalsIgnoreCase("Invalid")) { //Medical Certificate invalid
                System.out.println("Provide a valid medical certificate and try again");
                System.out.println("");
                medi_validity = a1.getMedical();
                verifyMedi = ar1.verifyMedical(medi_validity);
            }
            System.out.println("Valid medical certificate, proceeding to payment status check");
            System.out.println("");
        }
        
        //all_valid value is changed to 'valid' at different points in code, since if the condition is satisfied, all necessary documents have been submitted by user at said points
        String pay_validity = a1.getPayments(); //Gets payment status
        String verifyPay = ar1.verifyPayments(pay_validity); //Checks and assigns payment status
        if(verifyPay.equalsIgnoreCase("Valid")) { //Payments complete and nationality is equal to 'Local'
            System.out.println("Payments complete, submitting documents for approval");
            System.out.println("");
            all_valid = "Valid";
        }
        else if(verifyPay.equalsIgnoreCase("Invalid") && appl_nationality.equalsIgnoreCase("Local")) { //Payments incomplete and nationality is equal to 'Local'
            while(verifyPay.equalsIgnoreCase("Invalid")) {
                System.out.println("Pay off payables and try again");
                System.out.println("");
                pay_validity = a1.getPayments();
                verifyPay = ar1.verifyPayments(pay_validity);
            }
            System.out.println("Payments complete, submitting documents for approval");
            System.out.println("");
            all_valid = "Valid";
        }
        else if(verifyPay.equalsIgnoreCase("Valid") && (!"Local".equalsIgnoreCase(appl_nationality))) { //Payments complete and nationality is not equal to 'Local'
            System.out.println("Payments complete, proceeding to additional documents verfication (for international applicants only)");
            System.out.println("");
        }
        else if(verifyPay.equalsIgnoreCase("Invalid") && (!"Local".equalsIgnoreCase(appl_nationality))) { //Payments incomplete and nationality is not equal to 'Local'
            while(verifyPay.equalsIgnoreCase("Invalid")) {
                System.out.println("Pay off payables and try again");
                System.out.println("");
                pay_validity = a1.getPayments();
                verifyPay = ar1.verifyPayments(pay_validity);
            }
            System.out.println("Payments complete, proceeding to additional documents verfication");
            System.out.println("");
        }
        
        String addDoc_validity; //Variable to hold additional document validity
        if(!"Local".equalsIgnoreCase(appl_nationality)) {
            addDoc_validity = a1.getAdditionalDocuments(); //Gets additional document validity
        }
        else {
            addDoc_validity = "n/a"; //Assigned a null value
        }
        String verifyAddDoc = ar1.verifyAddtionalDocument(addDoc_validity); //Checks if additional documents are valid
        if(!"Local".equalsIgnoreCase(appl_nationality)) { //Checks if nationality is not equal to local (additional documents is only for international applicants)
            if(verifyAddDoc.equalsIgnoreCase("Valid")) { //Addtional documents valid
                System.out.println("Valid additional documents, submitted documents for approval");
                System.out.println("");
                all_valid = "Valid";
            }
            else if(verifyAddDoc.equalsIgnoreCase("Invalid")) { //Additional documents invalid
                while(verifyAddDoc.equalsIgnoreCase("Invalid")) {
                    System.out.println("Provide valid additional documents and try again");
                    System.out.println("");
                    addDoc_validity = a1.getAdditionalDocuments();
                    verifyAddDoc = ar1.verifyAddtionalDocument(addDoc_validity);
                }
                System.out.println("Valid additional documents, submitted documents for approval");
                System.out.println("");
                all_valid = "Valid";
            }
        }
        ar1.setApplicantID(); //Sets applicant ID
        
        Registration_Officer ro1 = new Registration_Officer(); //Object of class Registration_Officer
        String approval = ro1.setApproval(all_valid); //Sets approval status of documents, based on the validity of all the documents submitted
        if(approval.equalsIgnoreCase("Approved")) { //If documents are approved
            System.out.println("All documents approved, proceeding to financial status verification");
            System.out.println("");
        }
        else if(approval.equalsIgnoreCase("invalid")) { //If documents are unapproved
            System.out.println("Error in entering details, please try again, exiting program");
            System.exit(0);
        }
        
        Account_Officer ao1 = new Account_Officer(); //Object of class Account_Officer
        boolean finance_status = ao1.setFinancialStatus(); //Sets financial status of applicant
        String finance_status_string;
        if(finance_status == true) {
            finance_status_string = "Good";
        }
        else {
            finance_status_string = "Bad";
        }
        System.out.println("");
        
        boolean trai_mode = a1.setTrainingMode(); //Sets the training mode of choice by applicant
        String trai_mode_string;
        if(trai_mode == true) {
            trai_mode_string = "Online";
        }
        else {
            trai_mode_string = "Offline";
        }
        System.out.println("");
        
        Training_Officer to1 = new Training_Officer(); //Object of class Training_Officer
        to1.setTravelingSchedule(); //Sets traveling schedule
        
        //Final print statement before exiting program
        System.out.println("Final statement of all documents and choices");
        System.out.println("");
        System.out.println("All initial documents: " + initial_documents);
        System.out.println("All extra documents: " + approval);
        System.out.println("Applicant Financial Status: " + finance_status_string);
        System.out.println("Choice of training mode: " + trai_mode_string);
        System.out.println("");
        
        System.out.println("Would you like to see the training session and traveling schedule? (Enter 'y' for yes/'n' for no)");
        String trai_view = sc.nextLine(); 
        if(trai_view.equalsIgnoreCase("y")) { //Traveling schedule and training session is displayed
            to1.getTravelingSchedule();
            System.out.println("");
            to1.displayTrainingSession();
        }
        else if(!"n".equalsIgnoreCase(trai_view)) { //If choice is not 'y'/'n'
            while( (!"n".equalsIgnoreCase(trai_view)) || (!"y.".equalsIgnoreCase(trai_view))) {
                System.out.println("Please enter a valid choice (y/n): ");
                trai_view = sc.nextLine();
                if(trai_view.equalsIgnoreCase("y")) {
                    to1.getTravelingSchedule();
                    to1.displayTrainingSession();
                }
            }
        }
        System.out.println("");
        System.out.println("If there is any discrepancy, please repeat procedure, exiting program");
        System.exit(0);
    }
}

class Applicant {
    Scanner sc = new Scanner(System.in);
    //Attributes
    private String appl_name;
    private int appl_age;
    private String appl_gender;
    private int appl_phone_num;
    private String appl_email;
    private String appl_nationality;
    
    //Functions
    String getApplicantAttributes() { //Applicant attributes are inputtted 
        System.out.println("Enter the applicant name: ");
        appl_name = sc.nextLine();
        if(appl_name.equals("")) {
            while(appl_name.equals("")) {
                System.out.println("Please enter a valid name: ");
                appl_name = sc.nextLine();
            }    
        }
        System.out.println("");
        
        System.out.println("Enter the applicant age: ");
        appl_age = sc.nextInt();
        sc.nextLine();
        if(appl_age == 0) {
            while(appl_age == 0) {
                System.out.println("Please enter a valid age: ");
                appl_age = sc.nextInt();
                sc.nextLine();
            }
        }
        System.out.println("");
        
        System.out.println("Enter the applicant gender: ");
        appl_gender = sc.nextLine();
        if(appl_gender.equals("")) {
            while(appl_gender.equals("")) {
                System.out.println("Please enter a valid name: ");
                appl_gender = sc.nextLine();
            }    
        }
        System.out.println("");
        
        System.out.println("Enter the applicant phone number: ");
        appl_phone_num = sc.nextInt();
        sc.nextLine();
        if(appl_phone_num == 0) {
            while(appl_phone_num == 0) {
                System.out.println("Please enter a valid phone number: ");
                appl_phone_num = sc.nextInt();
                sc.nextLine();
            }
        }
        System.out.println("");
        
        System.out.println("Enter the applicant email address: ");
        appl_email = sc.nextLine();
        if(appl_email.equals("")) {
            while(appl_email.equals("")) {
                System.out.println("Please enter a valid email address: ");
                appl_email = sc.nextLine();
            }
        }
        System.out.println("");
        
        System.out.println("Enter the applicant nationality (type 'Local' if from home country): ");
        appl_nationality = sc.nextLine();
        if(appl_nationality.equals("")) {
            while(appl_nationality.equals("")) {
                System.out.println("Please enter a valid nationality: ");
                appl_nationality = sc.nextLine();
            }    
        }
        System.out.println("");
        
        return "Approved"; //Returns only if all other variables above have valid values
    }
    String getNationality() { //Gets applicant nationality
        return appl_nationality;
    }
    String getPassport() { //Gets applicant passport validity
        System.out.println("Is the applicant passport valid? (Enter 'y'/'n')");
        String pass_validity = sc.nextLine();
        return pass_validity;
    }
    String getVaccination() { //Gets applicant vaccination validity
        System.out.println("Is the applicant vaccination valid? (Enter 'y'/'n')");
        String vacc_validity = sc.nextLine();
        return vacc_validity;
    }
    String getMedical() { //Gets applicant medical certificate validity
        System.out.println("Is the applicant medical certificate valid? (Enter 'y'/'n')");
        String medi_validity = sc.nextLine();
        return medi_validity;
    }
    String getPayments() { //Gets applicant payment status
        System.out.println("Is the required payments by the applicant completed? (Enter 'y'/'n')");
        String pay_validity = sc.nextLine();
        return pay_validity;
    }
    String getAdditionalDocuments() { //Gets additional documents validity
        System.out.println("Are the additional documents by the international applicant valid? (Enter 'y'/'n')");
        String addDoc_validity = sc.nextLine();
        return addDoc_validity;
    }
    boolean setTrainingMode() { //Sets applicants choice of training mode 
        System.out.println("Enter choice of online or offline training(Enter 'y' for online/'n' for offline): ");
        String trai_mode_string = sc.nextLine();
        if(trai_mode_string.equalsIgnoreCase("y")) { //'True' value for online
            return true;
        }
        else if(trai_mode_string.equalsIgnoreCase("n")) { //'False' value for offline
            return false;
        }
        else {
            while( (!"y".equalsIgnoreCase(trai_mode_string)) || (!"n".equalsIgnoreCase(trai_mode_string))) { //If choice typed in is not 'y'/'n'
                System.out.println("Please enter a valid choice (y/n): ");
                trai_mode_string = sc.nextLine();
                if(trai_mode_string.equalsIgnoreCase("y")) {
                    return true;
                }
                else if(trai_mode_string.equalsIgnoreCase("n")) {
                    return false;
                }
            }
        }
        return false; //Returning false because a return statement is required (will not execute at all and is only there to prevent no return statement error)
    }
}

class Assistant_Registration_Officer {
    Scanner sc = new Scanner(System.in);
    
    //Attributes
    private String asstOff_id;
    private String asstOff_name;
    private int asstOff_age;
    private String asstOff_gender;
    private int asstOff_phone_num;
    private String asstOff_email;
    private String appl_id;
    
    //Functions
    void setApplicantID() { //Sets applicant's ID
        System.out.println("Enter the applicant ID: ");
        appl_id = sc.nextLine();
        System.out.println();
    }
    String verifyPassport(String pass_validity) { //Checks passport validity
        if(pass_validity.equalsIgnoreCase("y")) {
            return "Valid";
        }
        else {
            return "Invalid";
        }
    }
    String verifyVaccination(String vacc_validity) { //Checks vaccination validity
        if(vacc_validity.equalsIgnoreCase("y")) {
            return "Valid";
        }
        else {
            return "Invalid";
        }
    }
    String verifyMedical(String medi_validity) { //Checks medical certificate validity
        if(medi_validity.equalsIgnoreCase("y")) {
            return "Valid";
        }
        else {
            return "Invalid";
        }
    }
    String verifyPayments(String pay_validity) { //Checks payment status 
        if(pay_validity.equalsIgnoreCase("y")) {
            return "Valid";
        }
        else {
            return "Invalid";
        }
    }
    String verifyAddtionalDocument(String addDoc_validity) { //Checks additional documents validity
        if(addDoc_validity.equalsIgnoreCase("y")) {
            return "Valid";
        }
        else {
            return "Invalid";
        }
    }
}

class Registration_Officer {
    Scanner sc = new Scanner(System.in);
    
    //Attributes
    private String regOff_id;
    private String regOff_name;
    private int regOff_age;
    private String regOff_gender;
    private int regOff_phone_num;
    private String regOff_email;
    
    //Functions
    String setApproval(String all_validity){ //Sets applicant documents approval status
        if(all_validity.equalsIgnoreCase("Valid")) {
            return "Approved";
        }
        else {
            return "Unapproved";
        }
    }
}

class Account_Officer {
    Scanner sc = new Scanner(System.in);
    
    //Attributes
    private String accOff_id;
    private String accOff_name;
    private int accOff_age;
    private String accOff_gender;
    private int accOff_phone_num;
    private String accOff_email;
    
    //Functions
    boolean setFinancialStatus() { //Sets financial status of the applicant
        System.out.println("Enter financial status of the applicant (Enter 'y' for good/'n' for bad): ");
        String finance_status = sc.nextLine();
        if(finance_status.equalsIgnoreCase("y")) {
            return true;
        }
        else if(finance_status.equalsIgnoreCase("n")) {
            return false;
        }
        else {
            while( (!"y".equalsIgnoreCase(finance_status)) || (!"n".equalsIgnoreCase(finance_status)) ) {
                System.out.println("Please enter a valid choice (y/n): ");
                finance_status = sc.nextLine();
                if(finance_status.equalsIgnoreCase("y")) {
                    return true;
                }
                else if(finance_status.equalsIgnoreCase("n")) {
                    return false;
                }
            }
        }
        System.out.println("");
        return false; //Returning false because a return statement is required (will not execute at all and is only there to prevent no return statement error)
    }
}

class Training_Officer {
    Scanner sc = new Scanner(System.in);
    
    //Attributes
    private String traOff_id;
    private String traOff_name;
    private int traOff_age;
    private String traOff_gender;
    private int traOff_phone_num;
    private String traOff_email;
    
    private int trai_days;
    private String trai_date;
    private String trai_time;
    private String trai_loc;
    
    //Functions
    void displayTrainingSession() { //Displays training sessions
        System.out.println("1. Preparation and Intention");
        System.out.println("2. Tawaf (7 times)");
        System.out.println("3. Safa and Marwa");
        System.out.println("4. Resting and Praying");
        System.out.println("5. Day of Arafah");
        System.out.println("6. Muzdalifah"); 
        System.out.println("7. Rami (repeating)");
        System.out.println("8. Qurbani");
        System.out.println("9. Tawaf al-Ifadha");
        System.out.println("10. Tawaf al-Wida");
    }
    void setTravelingSchedule() { //Sets traveling schedule
        System.out.println("Enter the number of days for training: ");
        trai_days = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        System.out.println("Enter the training date ((DD/MM/YYYY) Format): ");
        trai_date = sc.nextLine();
        System.out.println("");
        System.out.println("Enter the training time (in 24-hour format, Example:- 15:00 - 19:00): ");
        trai_time = sc.nextLine();
        System.out.println("");
        System.out.println("Enter the training location: ");
        trai_loc = sc.nextLine();
        System.out.println("");
    }
    void getTravelingSchedule() { //Displays traveling schedule
        System.out.println("Number of days of training: " + trai_days);
        System.out.println("Training Date: " + trai_date);
        System.out.println("Training Time: " + trai_time);
        System.out.println("Training Location: " + trai_loc);
    }
}