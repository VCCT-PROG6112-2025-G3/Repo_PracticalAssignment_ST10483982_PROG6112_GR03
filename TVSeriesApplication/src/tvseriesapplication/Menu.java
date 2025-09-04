/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* MENU CLASS (Menu.java)                                                                                                                 /
/*                                                                                                                                        /
/* Description: Menu class that provides methods for navigating the TV Series Management Application.                                     /
/*              It enables the welcome screen, main menu, and exit confirmation to be displayed, and contains the startRunning()          /
/*              method which delegates user actions (capture, search, update, delete, recieve report, exit) to the Series class.          /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package tvseriesapplication;

import javax.swing.*;

public class Menu {
    
    private final Series seriesApp = new Series();
    public void startRunning(){
        // Welcome screen ("1" to continue; any other key exits) 
        if (!showWelcomeMenu()){
            if (confirmExit()){
                // Calls exitSeriesApplication() method from Series class to display goodbye message if the user confirms that they want to exit
                seriesApp.exitSeriesApplication();  
                return;                                                         // User exits app completely
            }
        }
        
        boolean isRunning = true;                                               // i.e. if the user entered "1"
        while (isRunning){
            int userChoice = showMainMenu();
            
            switch (userChoice){
                case 0: seriesApp.captureSeries(); break;
                case 1: seriesApp.searchSeries(); break;
                case 2: seriesApp.updateSeries(); break;
                case 3: seriesApp.deleteSeries(); break;
                case 4: seriesApp.seriesReport(); break;
                case 5: // User pressed exit button
                case JOptionPane.CLOSED_OPTION:
                    if (confirmExit()){
                        seriesApp.exitSeriesApplication();
                        isRunning = false;
                    }
                    break;
                default: 
                    // defualt for any unexpeced value  
                    if (confirmExit()){
                        seriesApp.exitSeriesApplication();
                        isRunning = false;
                    }
                    break;
            }
        }
    }
    
    // Method displays welcome screen. User must enter (1) to continue (true); any other key returns false
    private boolean showWelcomeMenu(){
        String userInput = JOptionPane.showInputDialog(
                null,
                "Enter (1) to launch menu or any other key to exit",
                "LATEST SERIES - 2025",
                JOptionPane.QUESTION_MESSAGE
        );
        return userInput != null && userInput.trim().equals("1");
    }
    
    // Method allows user to choose what action they would like to perform (capture, search, update, delete, receive report, exit)
    private int showMainMenu(){
        // User of numbered buttons eliminates the need to validate user input (i.e do not have to ensure that the user enters an integer between 1 and 6)
        Object[] menuOptions = {"1", "2", "3", "4", "5", "6"};                  
        
        String optionsText = 
            "Please select one of the following menu items:\n\n" +
                "(1) Capture a new series\n" +
                "(2) Search for a series\n" +
                "(3) Update series\n" +
                "(4) Delete a series\n" +
                "(5) Print series report - 2025\n" +
                "(6) Exit Application";
        
        return JOptionPane.showOptionDialog(
                null,
                optionsText,
                "Manage TV Series",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                menuOptions,
                menuOptions[0]
        );
    }
    
    // Method confirms if the user wants to exit
    private boolean confirmExit(){
        int choice = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to exit?",        
            "Exit Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        return choice == JOptionPane.YES_OPTION;
    }
        
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //

