package assignment_2;

import java.util.*;

public class XYZ { 
    public static void main(String args[]) {
        Applicant a1  = new Applicant(); //Object of class Applicant
        String initial_documents = a1.getApplicantAttributes(); //Sets name, age, gender, phone number, email and nationality
        String all_valid = "invalid"; //Variable to hold all documents validity (initialized to invalid)
        Assistant_Registration_Officer ar1 = new Assistant_Registration_Officer(); //Object of class Assistant_Registration_Officer
        
        String appl_nationality = a1.getNationality(); //Gets nationality 
        
        //all while() loops at any point in the code exist only to prevent user from inputting wrong/invalid information (such as 'null')
        String pass_validity = a1.getPassport(); //Gets passport validity
        String verifyPass = ar1.verifyPassport(pass_validity); //Checks and assigns passport validity
        if(verifyPass.equalsIgnoreCase("valid")) { //Passport valid
            System.out.println("Valid passport, proceeding to vaccination certificate");
        }
        else if(verifyPass.equalsIgnoreCase("invalid")) { //Passport invalid
            while(verifyPass.equalsIgnoreCase("invalid")) {
                System.out.println("Provide a valid passport and try again");
                System.out.println("");
                pass_validity = a1.getPassport();
                verifyPass = ar1.verifyPassport(pass_validity);
            }
            System.out.println("Valid passport, proceeding to vaccination certificate verification");
        }
        
        String vacc_validity = a1.getVaccination(); //Gets vaccination validity
        String verifyVacc = ar1.verifyVaccination(vacc_validity); //Checks and assigns vaccination validity
        if(verifyVacc.equalsIgnoreCase("valid")) { //Vaccination certificate valid
            System.out.println("Valid vaccination certificate, proceeding to medical certificate verification");
        }
        else if(verifyVacc.equalsIgnoreCase("invalid")) { //Vaccination certificate invalid
            while(verifyVacc.equalsIgnoreCase("invalid")) {
                System.out.println("Provide a valid vaccination certificate and try again");
                System.out.println("");
                vacc_validity = a1.getVaccination();
                verifyVacc = ar1.verifyVaccination(vacc_validity);
            }
            System.out.println("Valid vaccination certificate, proceeding to medical certificate verification");
        }
        
        String medi_validity = a1.getMedical();  //Gets medical certificate validity
        String verifyMedi = ar1.verifyMedical(medi_validity); //Checks and assigns medical certificate validity
        if(verifyMedi.equalsIgnoreCase("valid")) { //Medical certificate valid
            System.out.println("Valid medical certificate, proceeding to payment status check");
        }
        else if(verifyMedi.equalsIgnoreCase("invalid")) {
            while(verifyMedi.equalsIgnoreCase("invalid")) { //Medical Certificate invalid
                System.out.println("Provide a valid medical certificate and try again");
                System.out.println("");
                medi_validity = a1.getMedical();
                verifyMedi = ar1.verifyMedical(medi_validity);
            }
            System.out.println("Valid medical certificate, proceeding to payment status check");
        }
        
        //all_valid value is changed to 'valid' at different points in code, since if the condition is satisfied, all necessary documents have been submitted by user at said points
        String pay_validity = a1.getPayments(); //Gets payment status
        String verifyPay = ar1.verifyPayments(pay_validity); //Checks and assigns payment status
        if(verifyPay.equalsIgnoreCase("valid") && appl_nationality.equalsIgnoreCase("Local")) { //Payments complete and nationality is equal to 'Local'
            System.out.println("Payments complete, submitting documents for approval");
            all_valid = "valid";
        }
        else if(verifyPay.equalsIgnoreCase("invalid") && appl_nationality.equalsIgnoreCase("Local")) { //Payments incomplete and nationality is equal to 'Local'
            while(verifyPay.equalsIgnoreCase("invalid")) {
                System.out.println("Pay off payables and try again");
                System.out.println("");
                pay_validity = a1.getPayments();
                verifyPay = ar1.verifyPayments(pay_validity);
            }
            System.out.println("Payments complete, submitting documents for approval");
            all_valid = "valid";
        }
        else if(verifyPay.equalsIgnoreCase("valid") && (!"Local".equalsIgnoreCase(appl_nationality))) { //Payments complete and nationality is not equal to 'Local'
            System.out.println("Payments complete, proceeding to additional documents verfication (for international applicants only)");
        }
        else if(verifyPay.equalsIgnoreCase("invalid") && (!"Local".equalsIgnoreCase(appl_nationality))) { //Payments incomplete and nationality is not equal to 'Local'
            while(verifyPay.equalsIgnoreCase("invalid")) {
                System.out.println("Pay off payables and try again");
                System.out.println("");
                pay_validity = a1.getPayments();
                verifyPay = ar1.verifyPayments(pay_validity);
            }
            System.out.println("Payments complete, proceeding to additional documents verfication");
        }
        
        String addDoc_validity; //Variable to hold additional document validity
        if(!"Local".equalsIgnoreCase(appl_nationality)) {
            addDoc_validity = a1.getAdditionalDocuments(); //Gets additional document validity
        }
        else {
            addDoc_validity = "n/a"; //Assigned a null value
        }
        String verifyAddDoc = ar1.verifyAddtionalDocument(addDoc_validity); //Checks if additional documents are valid
        if(verifyAddDoc.equalsIgnoreCase("valid")) { //Addtional documents valid
            System.out.println("Valid additional documents, submitted documents for approval");
            all_valid = "valid";
        }
        else if(verifyAddDoc.equalsIgnoreCase("invalid")) { //Additional documents invalid
            while(verifyAddDoc.equalsIgnoreCase("invalid")) {
                System.out.println("Provide valid additional documents and try again");
                System.out.println("");
                addDoc_validity = a1.getAdditionalDocuments();
                verifyAddDoc = ar1.verifyAddtionalDocument(addDoc_validity);
            }
            System.out.println("Valid additional documents, submitted documents for approval");
            all_valid = "valid";
        }
        
        ar1.setApplicantID(); //Sets applicant ID
        
        Registration_Officer ro1 = new Registration_Officer(); //Object of class Registration_Officer
        String approval = ro1.setApproval(all_valid); //Sets approval status of documents, based on the validity of all the documents submitted
        if(approval.equalsIgnoreCase("approved")) { //If documents are approved
            System.out.println("All documents approved, proceeding to financial status verification");
        }
        else if(approval.equalsIgnoreCase("invalid")) { //If documents are unapproved
            System.out.println("Error in entering details, please try again, exiting program");
            System.exit(0);
        }
        
        Account_Officer ao1 = new Account_Officer(); //Object of class Account_Officer
        String finance_status = ao1.setFinancialStatus(); //Sets financial status of applicant
        
        Training_Officer to1 = new Training_Officer(); //Object of class Training_Officer
        to1.setTrainingSchedule(); //Sets training schedule
        to1.setTravelingSchedule(); //Sets traveling schedule
        boolean trai_mode = a1.setTrainingMode(); //Sets the training mode of choice by applicant
        String trai_mode_string;
        if(trai_mode == true) {
            trai_mode_string = "Online";
        }
        else {
            trai_mode_string = "Offline";
        }
        
        //Final print statement before exiting program
        System.out.println("Final statement of all documents and choices");
        System.out.println("");
        System.out.println("All initial documents: " + initial_documents);
        System.out.println("All extra documents: " + approval);
        System.out.println("Applicant Financial Status: " + finance_status);
        System.out.println("Choice of training mode: " + trai_mode_string);
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
        
        System.out.println("Enter the applicant gender: ");
        appl_gender = sc.nextLine();
        if(appl_gender.equals("")) {
            while(appl_gender.equals("")) {
                System.out.println("Please enter a valid name: ");
                appl_gender = sc.nextLine();
            }    
        }
        
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
        
        System.out.println("Enter the applicant email address: ");
        appl_email = sc.nextLine();
        if(appl_email.equals("")) {
            while(appl_email.equals("")) {
                System.out.println("Please enter a valid email address: ");
                appl_email = sc.nextLine();
            }
        }
        
        System.out.println("Enter the applicant nationality (type 'Local' if from home country): ");
        appl_nationality = sc.nextLine();
        if(appl_nationality.equals("")) {
            while(appl_nationality.equals("")) {
                System.out.println("Please enter a valid nationality: ");
                appl_nationality = sc.nextLine();
            }    
        }
        
        return "approved";
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
    }
    String verifyPassport(String pass_validity) { //Checks passport validity
        if(pass_validity.equalsIgnoreCase("y")) {
            return "valid";
        }
        else {
            return "invalid";
        }
    }
    String verifyVaccination(String vacc_validity) { //Checks vaccination validity
        if(vacc_validity.equalsIgnoreCase("y")) {
            return "valid";
        }
        else {
            return "invalid";
        }
    }
    String verifyMedical(String medi_validity) { //Checks medical certificate validity
        if(medi_validity.equalsIgnoreCase("y")) {
            return "valid";
        }
        else {
            return "invalid";
        }
    }
    String verifyPayments(String pay_validity) { //Checks payment status 
        if(pay_validity.equalsIgnoreCase("y")) {
            return "valid";
        }
        else {
            return "invalid";
        }
    }
    String verifyAddtionalDocument(String addDoc_validity) { //Checks additional documents validity
        if(addDoc_validity.equalsIgnoreCase("y")) {
            return "valid";
        }
        else {
            return "valid";
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
        if(all_validity.equalsIgnoreCase("valid")) {
            return "approved";
        }
        else {
            return "unapproved";
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
    String setFinancialStatus() { //Sets financial status of the applicant
        System.out.println("Enter financial status of the applicant (Enter 'good'/'bad'): ");
        String finance_status = sc.nextLine();
        return finance_status;
    }
}

class Training_Officer {
    //Attributes
    private String traOff_id;
    private String traOff_name;
    private int traOff_age;
    private String traOff_gender;
    private int traOff_phone_num;
    private String traOff_email;
    
    //Functions
    void setTrainingSchedule() { //Sets training schedule
        
    }
    void setTravelingSchedule() { //Sets traveling schedule
        
    }
}