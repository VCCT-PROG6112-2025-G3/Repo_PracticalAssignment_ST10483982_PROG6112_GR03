/* ======================================================================================================================================*/
/* Referencing Console Application
/* ======================================================================================================================================*/
/* Name: Voningo Flora Makhubele Pecego
/* Student Number: ST10483982
/* Assignment: Practical Assignment - Section B (Question 1)
/* Lecturer: Amakan Elisha Agoni (BCA1 GRO3)
/* Date: 04/09/2025
/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* MAIN METHOD (Main.java)                                                                                                                  
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package referenceapplication;

import java.util.Scanner;

public class Main {
    // Creating a scanner object in order to read all user input from the console
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Creating manager object for storing and organising the references
        ReferenceManager manager = new ReferenceManager();
        
        // Loops in order to keep showing the menu until user enters (0) to exit
        while (true){
            System.out.println("\n================= Referencing Application =================");
            System.out.println("Remaining slots: " + manager.getRemainingSlots());  // Displaying the number of slots that are remaining
            System.out.println("1) Add Book");
            System.out.println("2) Add Website");
            System.out.println("3) Print Reference List");
            System.out.println("0) Exit");
            System.out.print("\nPlease choose an option: ");
            
            // Reading the user's menu choice
            String menuChoice = scanner.nextLine().trim();
            
            // Using switch statement to handle the menu choice
            switch (menuChoice){
                case "1" -> addBook(manager);                                   // adding book reference
                case "2" -> addWebsite(manager);                                // adding website reference
                case "3" -> displayReferenceList(manager);                      // showing all the stored references
                case "0" -> {
                    System.out.println("Until next time!");
                    return;                                                     // exiting the application
                }
                default -> System.out.println("Invalid option. Please enter 0, 1, 2, or 3.");
            }
        }
    }
    
    // Method prompts user to enter the book details and adds the book reference to ReferenceManager if there is space available
    private static void addBook(ReferenceManager manager){
        // Checking if the space is full (max 50 references)
        if(manager.arrayIsFull()){
            System.out.println("List is full. Please print the list or exit the application.");
            return;
        }
        
        System.out.println("\n----------------- Add Book -----------------");
        String[] authors = captureAuthors();
        int year = checkIntegerInput("Year: ", true);
        String title = checkInput("Title: ", true);
        String placeOfPublication = checkInput("Place/City of Publication: ", true);
        String publisher = checkInput("Publisher: ", true);
        String edition = checkInput("Edition (e.g. 2nd ed.) [leave blank for 1st edition]: ", false);
        
        // Creating a book object and adding it to the reference manager
        Book newBook = new Book(authors, year, title, placeOfPublication, publisher, edition);
        boolean isAdded = manager.addNewReference(newBook);
        System.out.println(isAdded ? "Book reference added successfully!" : "Capacity is full. Could not add reference.");
    }
    
    // Method prompts user to enter the website details and adds the website reference to ReferenceManager if there is space available    
    private static void addWebsite(ReferenceManager manager){
        // Checking if the space is full (max 50 references)
        if (manager.arrayIsFull()){
            System.out.println("Capacity is full. Please print the list or exit the application");
            return;
        }
        
        System.out.println("\n----------------- Add Website -----------------");
        String[] authors = captureAuthors();
        int year = checkIntegerInput("Year: ", true);
        String title = checkInput("Page Title: ", true);
        String website = checkInput("Website Name: ", true);
        String url = checkInput("URL: ", true);
        String dateAccessed = checkInput("Date Accessed (e.g. 3 September 2025): ", false);
        
        // Creating a website object and adding it to the reference manager
        Website newWebsite = new Website(authors, year, title, website, url, dateAccessed);
        boolean isAdded = manager.addNewReference(newWebsite);
        System.out.println(isAdded ? "Website reference added successfully!" : "Capacity is full. Could not add reference.");
    }
    
    // Method sorts and displays all of the stored references in a numbered list
    private static void displayReferenceList(ReferenceManager manager){
        System.out.println("\n================= LIST OF REFERENCES =================");
        // Sorting the references before printing them
        manager.sortByAuthorThenYear();
        Reference[] allReferences = manager.getAllReferences();
        
        if (allReferences.length == 0){
            // Displaying an error message if no references exitst yet
            System.out.println("No references exist yet. Please add a Book or Website reference first.");
            return;
        }
        
        // Printing each reference
        for (Reference reference : allReferences) {
            System.out.println(reference.formatReference());
            System.out.println();                                               // Adding an extra blank line between references
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Total references: " + allReferences.length);
    }
    
    // USER INPUT METHODS
    private static String checkInput(String label, boolean isRequired){
        while (true){
            System.out.print(label);
            String value = scanner.nextLine().trim();
            
            if (!isRequired) return value;
            // Requres that the input is non-blank
            if (!value.isBlank()) return value;
            
            System.out.println("This field cannot be empty.");
        }
    }
    
    private static int checkIntegerInput(String label, boolean isPositive){
        while (true){
            System.out.print(label);
            String textInput = scanner.nextLine().trim();
            // Exception Handling
            try{
                int input = Integer.parseInt(textInput);
                
                if (isPositive && input < 0){
                    System.out.println("Please enter 0 or a positive number.");
                    continue;
                }
                return input;
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static String formatInitials(String authorNames){
        String formatted;
        if (authorNames == null){
            formatted = "";
        } else {
            formatted = authorNames.trim();
        }
        
        if (formatted.isEmpty()) return "";
        
        StringBuilder initials = new StringBuilder();
        String[] parts = formatted.split("\\s+");                                 // Regex obtained from ChatGPT (2025)
        for (String section : parts){
            initials.append(Character.toUpperCase(section.charAt(0))).append('.');
        }
        return initials.toString();
        
    }
    
    // BOOK REFERENCING METHODS
    private static String[] captureAuthors(){
        int authorCount = checkIntegerInput("Number of authors (0 for no author): ", true);
        if (authorCount == 0) return new String[0];
        
        String[] authors = new String[authorCount];
        for (int index = 0; index < authorCount; index++){
            System.out.println("Author " + (index + 1));
            String names = checkInput("Name(s): ", true);
            String surname    = checkInput("Surname: ", true);

            String initials = formatInitials(names);
            authors[index] = surname.trim() + ", " + initials; 
        }
        return authors;
    }
        
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
