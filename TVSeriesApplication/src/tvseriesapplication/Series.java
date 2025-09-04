/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* SERIES CLASS (Series.java)                                                                                                             /
/*                                                                                                                                        /
/* Description: Series class that contains methods for managing TV series, including capture, search, update, delete, report,             /
/*              and exit. It also includes helper and validation methods (e.g., age restriction, positive integer checks)                 /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package tvseriesapplication;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Series {
    // Declaring in-memory store (i.e. list for holding all SeriesModel objects (each individual series))
    private final List<SeriesModel> seriesList = new ArrayList<>();
    
/* --------------------------------------------------------MANDATORY METHODS-------------------------------------------------------------*/
    // Method for capturing new TV series each with the following attributes: ID, name, age restriction and episode count
    public void captureSeries(){
        String id = captureIsNotEmpty("Enter the series ID");
        if (id == null) return;                                                 // ID capture cancelled
        
        String name = captureIsNotEmpty("Enter the series name");
        if (name == null) return;                                               // Name capture cancelled
        
        int age = captureAgeRestriction();
        if (age == -1) return;                                                  // Age restriction capture cancelled
        
        int episodes = captureEpisodeCount(name);
        if (episodes == -1) return;                                             // Episode count capture cancelled
        
        SeriesModel newSeries = new SeriesModel(id.trim(), name.trim(), age, episodes);
        seriesList.add(newSeries);
        
        JOptionPane.showMessageDialog(null, "Series processed successfully!!!");
    }
    
    // Method searches for the series by ID and diplays the result to the user
    public void searchSeries(){
        String id = captureIsNotEmpty("Enter the series ID to search");
        if (id == null) return;                                                 // Search cancelled
        
        // Calling method that loops through array until the matching ID is found
        SeriesModel foundSeries = searchByID(id.trim()); 
        
        if (foundSeries != null){
            JOptionPane.showMessageDialog(
                    null,
                    "Series found:\n\n" + foundSeries.toString(),
                    "Search Result",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else{
            JOptionPane.showMessageDialog(
                    null,
                    "Series with series ID " + id + " was not found!",
                    "Search Result",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
    
    // Method allows user to update the details of a series by ID (name, age restriction, episode count)
    public void updateSeries(){
        String id = captureIsNotEmpty("Enter the series ID to update");
        if (id == null) return;                                                 // Update cancelled
        
        SeriesModel series = searchByID(id.trim());
        if (series == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Series with series ID " + id + " was not found!",
                    "Update Result",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        if (!confirmUpdate(series)){
            JOptionPane.showMessageDialog(null, "Update cancelled.");
            return;
        }
        
        // Updating the tv series details by calling helper methods
        updateName(series);
        updateAge(series);
        updateEpisodeCount(series);
        
        JOptionPane.showMessageDialog(
                null,
                "Series with ID " + id + " has been successfully updated!",
                "Update Successful",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void deleteSeries(){
        String id = captureIsNotEmpty("Enter the series ID to delete");
        if (id == null) return;                                                 // Delete cancelled
        
        SeriesModel series = searchByID(id.trim());
        
        if (series == null){
            JOptionPane.showMessageDialog(
                    null,
                    "Series with series ID " + id + " was not found!",
                    "Delete Result",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        // Confirming if the user wants to delete the series and removing it from the list
        if (confirmDelete(series)){
            seriesList.remove(series);
            JOptionPane.showMessageDialog(
                    null,
                    "Series with ID " + id + " was deleted.",
                    "Delete Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(null, "Deletion of series cancelled.", "Delete Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Method for diplaying a report of all of the captured series (uses HTML formatting (ChatGPT, 2025))
    public void seriesReport(){
        // Returning an error message if the list is empty
        if (seriesList.isEmpty()){
            JOptionPane.showMessageDialog(null, "No series have been captured.", "Series Report", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Making use of HTML text formatting
        StringBuilder report = new StringBuilder("<html>");
        report.append("<h2>Series Report</h2>");                                // Title of report uses <h2> to make the report title bigger and in bold
        
        int seriesNum = 1;
        for (SeriesModel series : seriesList) {
            report.append("<hr>")                                               // Inserting horizontal line separator (<hr>)
                  .append("<b>Series ").append(seriesNum++).append("</b><br>")  // Bold text (<b>)
                  .append("<hr>")
                  .append("ID: ").append(series.getSeriesId()).append("<br>")
                  .append("Name: ").append(series.getSeriesName()).append("<br>")
                  .append("Age Restriction: ").append(series.getSeriesAge()).append("<br>")
                  .append("Episodes: ").append(series.getSeriesNumberOfEpisodes()).append("<br>");
        }
        
        // Total series count 
        report.append("<hr>")
          .append("<b>Total Series: ").append(seriesList.size()).append("</b>")
          .append("</html>");
        
        JOptionPane.showMessageDialog(null, report.toString(), "Series Report", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void exitSeriesApplication(){
        JOptionPane.showMessageDialog(null, "Exiting the TV Series Management Application. Until next time!");
    }
    
/* --------------------------------------------------------VALIDATION METHODS------------------------------------------------------------*/
    // Method that validates that the value input by the user is a positive integer (i.e. non-negative)
    public int checkPositiveInt(String userInput){
        // Exception Handling
        try{
            int number = Integer.parseInt(userInput);
            // ternary operator that returns the userInput if true or -1 if false
            return (number >= 0) ? number : -1;
        } catch (NumberFormatException e) {
            return -1;                                                          // Invalid number
        }
    }
    
    // Method that validates the age restriction input by the user
    public int checkAgeRestriction(String userInput){
        // Exeption Handling
        try{
            int age = Integer.parseInt(userInput);
            // ternary operator that returns the userInput (age) if true (valid input = age input is between 2 and 18) or -1 if false
            return (age >= 2 && age <= 18) ? age : -1;
        } catch (NumberFormatException e) {
            return -1;                                                          // Invalid number 
        }
    }
    
/* ---------------------------------------------------------HELPER METHODS--------------------------------------------------------------- */
    SeriesModel searchByID(String id){                                  // id is the ID input by the user
        // Loops until all of the items on the list have been checked/searched
        for (int index = 0; index < seriesList.size(); index++){
            // Getting the element at the index called "index"
            SeriesModel series = seriesList.get(index);
            if (series.getSeriesId().equalsIgnoreCase(id)){                     // Case of the ID entered by the user is ignored (i.e. not case-sensitive)
                return series;                                                  // Return series (object) immediately if the matching ID is found
            }
        }
        return null;                                                            // No matching ID is found
    }
    
    private String captureIsNotEmpty(String text){
        // While loop to keep prompting the user until the user cancels or enters something that is not blank (valid input)
        while (true){
            String userInput = JOptionPane.showInputDialog(text);
            if (userInput == null) return null;                                 // Capture cancelled
            if (!userInput.trim().isEmpty()) return userInput;
            JOptionPane.showMessageDialog(null, "This field cannot be empty.");
        }
    }
    
    // Method prompts user to enter the age restriction (age between 2 and 18) and captures it
    private int captureAgeRestriction(){
        while (true){
            String userInput = JOptionPane.showInputDialog("Enter the series age restriction:");
            if (userInput == null) return -1;                                   // Capture cancelled
            // Calling helper method checkAgeRestriction that checks the age is between 2 and 18
            int age = checkAgeRestriction(userInput.trim());
            if (age != -1) return age;
            JOptionPane.showMessageDialog(null, "You have entered an incorrect series age restriction!!!\nPlease re-enter the series age restriction (2-18)");
        }
    }
    
    // Method prompts user to enter the number of episodes (number >=0) and captures it
    private int captureEpisodeCount(String seriesName){
        while (true){
            String userInput = JOptionPane.showInputDialog("Enter the number of episodes for " + seriesName);
            if (userInput == null) return -1;                                   // Capture cancelled
            int episodeCount = checkPositiveInt(userInput.trim());
            if (episodeCount != -1) return episodeCount;
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive integer.");
        }
    }
    
    // HELPER METHODS FOR UPDATING SERIES 
    // Method confirms if the user want to update the series
    private boolean confirmUpdate(SeriesModel series){
        // Confirming if the user wants to update the series
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Would you like to proceed to updating this series?\n\n" + series.toString(),
                "Confirm Update",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return choice == JOptionPane.YES_OPTION;
    }

    // Method for updating the name of a captured TV series 
    private void updateName(SeriesModel series){
        // Confirming if the user wants to update the name
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Do you want to update series name?",
                "Update Name",
                JOptionPane.YES_NO_OPTION
        );
        
        if (choice == JOptionPane.YES_OPTION){
            String newName = JOptionPane.showInputDialog(
                    null,
                    "Enter the new series name (Current series name: " + series.getSeriesName() + "): ",
                    "Update Series Name",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (newName != null && !newName.trim().isEmpty()) {
                series.setSeriesName(newName.trim());
            }   
        }       
    }
    
    // Method for updating the age restriction of a captured TV series 
    private void updateAge(SeriesModel series){
        // Confirming if the user wants to update the age restriction
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Do you want to update Age Restriction? (Current age restriction: " + series.getSeriesAge() + ")",
                "Update Age",
                JOptionPane.YES_NO_OPTION
        );
        
        if (choice == JOptionPane.YES_OPTION){
            int age = captureAgeRestriction();
            if (age != -1 ) {
                series.setSeriesAge(age);
            }
        }
    }

    // Method for updating the number of episodes of a captured TV series 
    private void updateEpisodeCount(SeriesModel series){
    // Confirming if the user wants to update the age restriction
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Do you want to update the number of episodes? (Current episode count: " + series.getSeriesNumberOfEpisodes() + ")",
                "Update Number of Episodes",
                JOptionPane.YES_NO_OPTION
        );
        
        if (choice == JOptionPane.YES_OPTION){
            int episodes = captureEpisodeCount(series.getSeriesName());
            if (episodes != -1 ) {
                series.setSeriesNumberOfEpisodes(episodes);
            }
        }    
    }

    // HELPER METHOD FOR DELETING SERIES 
    private boolean confirmDelete(SeriesModel series){
        // Confirming if the user wants to delete the series
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete series " + series.getSeriesId() + " from the system?\n\n" + series.toString(),
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        return choice == JOptionPane.YES_OPTION;
    }
/* --------------------------------------------------HELPER METHODS FOR UNIT TESTING----------------------------------------------------- */
    // Capture series method that doesnt use dialogs (suitable for unit testing)
    void addSeriesForTest(SeriesModel series) { 
        seriesList.add(series); 
    }
    
    // Update series method that doesnt use dialogs (suitable for unit testing)
    boolean updateSeriesForTest(String id, String newName, int newAge, int newEpisodes) {
        SeriesModel series = searchByID(id);
        if (series == null) return false;

        if (newName != null && !newName.trim().isEmpty()) {                     // Checks if name is not blank or null
            series.setSeriesName(newName.trim());
        }
        if (newAge >= 2 && newAge <= 18) {                                      // Checks if age is witin range
            series.setSeriesAge(newAge);
        }
        if (newEpisodes >= 0) {            
            series.setSeriesNumberOfEpisodes(newEpisodes);
        }
        return true;
    }
    
    // Delete series (delete by ID) method that doesnt use dialogs (suitable for unit testing)
    boolean deleteSeriesForTest(String id) {
        SeriesModel series = searchByID(id);
        return (series != null) && seriesList.remove(series);                   // Method returns true if series is deleted and false if series is not found 
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
