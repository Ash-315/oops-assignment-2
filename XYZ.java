package assignment_2;

import java.util.*;

public class XYZ { 
    public static void main(String args[]) {
        Applicant a1  = new Applicant(); //Object of class Applicant
        a1.getApplicantAttributes(); //Sets name, age, gender, phone number, email and nationality
        String initial_documents = "approved"; //Initial documents verfication status (initialized)
        String appl_nationality = a1.getNationality(); //Gets nationality 
        String pass_validity = a1.getPassport(); //Gets passport validity
        String vacc_validity = a1.getVaccination(); //Gets vaccination validity
        String medi_validity = a1.getMedical();  //Gets medical certificate validity
        String pay_validity = a1.getPayments(); //Gets payment status
        String addDoc_validity; //Variable to hold additional document validity
        if(!"Local".equalsIgnoreCase(appl_nationality)) {
            addDoc_validity = a1.getAdditionalDocuments(); //Gets additional document validity
        }
        else {
            addDoc_validity = "n/a"; //Assigned a null value
        }
        String all_valid = "invalid"; //Variable to hold all documents validity (initialized to invalid)
        
        Assistant_Registration_Officer ar1 = new Assistant_Registration_Officer(); //Object of class Assistant_Registration_Officer
        ar1.setApplicantID(); //Sets applicant ID
        String verifyPass = ar1.verifyPassport(pass_validity); //Checks passport validity
        if(verifyPass.equalsIgnoreCase("valid")) { // If passport is valid
            System.out.println("Valid passport, proceeding to vaccination verification");
            String verifyVacc = ar1.verifyVaccination(vacc_validity); //Checks vaccination validity 
            if(verifyVacc.equalsIgnoreCase("valid")) { //If vaccination is valid
                System.out.println("Valid vaccination certificate, proceeding to medical certification");
                String verifyMedi = ar1.verifyMedical(medi_validity); //Checks medical certificate validity
                if(verifyMedi.equalsIgnoreCase("valid")) {// If medical certificate is valid
                    System.out.println("Valid medical certificate, proceeding to payments verification");
                    String verifyPay = ar1.verifyPayments(pay_validity); //Checks payment status
                    if(verifyPay.equalsIgnoreCase("valid")) { //If payment is complete
                        if(appl_nationality.equalsIgnoreCase("Local")) { //If nationality is 'local'
                            all_valid = "valid"; //Set all documents to valid
                            System.out.println("Payments complete and all documents submitted, proceeding to approval");
                        }
                        else if(!"Local".equalsIgnoreCase(appl_nationality)) { //If nationality is not local
                            System.out.println("Payments complete, proceeding to additional documents verification (only for international applicants)");
                            String verifyAddDoc = ar1.verifyAddtionalDocument(addDoc_validity); //Checks if additional documents are valid
                        }
                    }
                    else if(verifyPay.equalsIgnoreCase("invalid")) { //If payment is incomplete
                        System.out.println("Pay the payables in full amount and try again");
                        System.out.println("");
                        pay_validity = a1.getPayments();//Gets payment status again
                        verifyPay = ar1.verifyPayments(pay_validity); //Repeats payment status check again
                    }
                    else {
                        System.out.println("No value available, please perform procedure again");
                        System.exit(0); 
                    }
                }
                else if(verifyMedi.equalsIgnoreCase("invalid")) { //If medical certificate is invalid
                    System.out.println("Provide valid medical certificates and try again");
                    System.out.println("");
                    medi_validity = a1.getMedical(); //Gets medical certificate validity again
                    verifyMedi = ar1.verifyMedical(medi_validity); //Repeats medical certificate validity check again
                }
                else {
                    System.out.println("No value available, please perform procedure again");
                    System.exit(0);
                }
            }
            else if(verifyVacc.equalsIgnoreCase("invalid")) { //If vaccination certificate is invalid
                System.out.println("Provide valid vaccination certificate and try again");
                System.out.println("");
                vacc_validity = a1.getVaccination(); //Gets vaccination validity again
                verifyVacc = ar1.verifyVaccination(vacc_validity); //Repeats vaccination validity check again
            }
            else {
                System.out.println("No value available, please perform procedure again");
                System.exit(0);
            }
        }
        else if(verifyPass.equalsIgnoreCase("invalid")) { //If vaccination certificate is invalid
            System.out.println("Provide a valid passport and try again");
            System.out.println("");
            pass_validity = a1.getPassport(); //Gets passport validity again
            verifyPass = ar1.verifyPassport(pass_validity); //Repeats passport validity check again
        }
        else {
            System.out.println("No value available, please perform procedure again");
            System.exit(0);
        }
        
        Registration_Officer ro1 = new Registration_Officer(); //Object of class Registration_Officer
        String approval = ro1.setApproval(all_valid); //Sets approval status of documents if all documents are valid
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
        String trai_mode = a1.setTrainingMode(); //Sets the training mode of choice by applicant
        
        //Final print statement before exiting program
        System.out.println("Final statement of all documents and choices");
        System.out.println("");
        System.out.println("All initial documents: " + initial_documents);
        System.out.println("All extra documents: " + approval);
        System.out.println("Applicant Financial Status: " + finance_status);
        System.out.println("Choice of training mode: " + trai_mode);
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
    void getApplicantAttributes() { //Applicant attributes are inputtted 
        System.out.println("Enter the applicant name: ");
        appl_name = sc.nextLine();
        if(appl_name.equals("")) {
            System.out.println("Please enter a valid name: ");
            appl_name = sc.nextLine();
        }
        
        System.out.println("Enter the applicant age: ");
        appl_age = sc.nextInt();
        sc.nextLine();
        if(appl_age == 0) {
            System.out.println("Please enter a valid age: ");
            appl_age = sc.nextInt();
            sc.nextLine();
        }
        
        System.out.println("Enter the applicant gender: ");
        appl_gender = sc.nextLine();
        if(appl_gender.equals("")) {
            System.out.println("Please enter a valid name: ");
            appl_gender = sc.nextLine();
        }
        
        System.out.println("Enter the applicant phone number: ");
        appl_phone_num = sc.nextInt();
        sc.nextLine();
        if(appl_phone_num == 0) {
            System.out.println("Please enter a valid phone number: ");
            appl_phone_num = sc.nextInt();
            sc.nextLine();
        }
        
        System.out.println("Enter the applicant email address: ");
        appl_email = sc.nextLine();
        if(appl_email.equals("")) {
            System.out.println("Please enter a valid email address: ");
            appl_email = sc.nextLine();
        }
        
        System.out.println("Enter the applicant nationality (type 'Local' if from home country): ");
        appl_nationality = sc.nextLine();
        if(appl_nationality.equals("")) {
            System.out.println("Please enter a valid nationality: ");
            appl_nationality = sc.nextLine();
        }
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
    String setTrainingMode() { //Sets applicants choice of training mode 
        System.out.println("Enter choice of online or offline training(Enter 'online'/'offline'): ");
        String trai_mode = sc.nextLine();
        return trai_mode;
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