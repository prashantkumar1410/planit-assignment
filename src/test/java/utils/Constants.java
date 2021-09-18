package utils;


import org.apache.commons.lang3.RandomStringUtils;

public class Constants {
    public static String random=RandomStringUtils.random(10, true, false);
    public static String feedbackMessage="We welcome your feedback - but we won't get it unless you complete the form correctly.";
    public static String forename="John";
    public static String email= random+"@random.com";
    public static String message="Feedback message";
    public static String invalidEmail=random;
    public static String forenameError="Forename is required";
    public static String emailError="Please enter a valid email";
    public static String messageError="Message is required";
}
