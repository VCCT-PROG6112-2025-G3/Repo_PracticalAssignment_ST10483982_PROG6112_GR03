/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* REFERENCE CLASS (Reference.java)                                                                                                       /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package referenceapplication;

public abstract class Reference { 
    private final String[] authors;
    private final int publicationYear;
    private final String title;
    
    // CONSTRUCTOR
    public Reference(String[] authors, int publicationYear, String title){
        // for authors
        if (authors != null) {
            this.authors = new String[authors.length];
            
            for (int index = 0; index < authors.length; index++){
                this.authors[index] = authors[index];
            }
        } else{
            this.authors = new String[0];
        }
        // for publication year
        this.publicationYear = publicationYear;
        
        // for title
        if (title != null){
            this.title = title.trim();
        } else {
            this.title = "";
        }
    }
    
    // ABSTRACT METHOD
    // Method forces all subclasses to define how their references are formatted
    public abstract String formatReference();
    
    // OTHER METHODS
    public String [] getAuthors(){
        String[] authorsCopy = new String[authors.length];
        for (int index = 0; index < authors.length; index++){
            authorsCopy[index] = authors[index];
        }
        return authorsCopy;
    }
    
    public int getPublicationYear(){
        return publicationYear;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String findSortingAuthorKey(){
        // If there are no authors (i.e. authors.length == 0), return "~" since "~" character comes after all normal letters in Unicode/ASCII order (ChatGPT, 2025)
        if (authors.length == 0) return "~";    

        // Declaring variables
        String firstAuthor = authors[0];                                        // The first author in the list
        String surname;
        
        // Finding position of the comma (indexOf locates the character in the string and returns its position)
        int commaIndex = firstAuthor.indexOf(',');                              // If the comma is found the position is retuned as an integer (i.e. commaIndex); if comma not found then returns -1
        
        if (commaIndex > 0){                                                    // If there is a comma, take everything before it, i.e. the surname
            surname = firstAuthor.substring(0, commaIndex);
        } else {
            surname = firstAuthor;                                              // If no comma then take the whole string
        }
        return surname.trim().toLowerCase();           
    }
    
    public static String formatAuthors(String[] authors) {
        if (authors == null || authors.length == 0) return "";
        if (authors.length == 1) return authors[0];                             // One author
        if (authors.length == 2) return authors[0] + " and " + authors[1];      // Two authors
        
        // More than 2 authors
        StringBuilder formattedAuthors = new StringBuilder();
        for (int index = 0; index < authors.length; index++){
            if (index > 0){
                formattedAuthors.append(index == authors.length - 1 ? " and " : ", ");
            }
            formattedAuthors.append(authors[index]);
        }
        return formattedAuthors.toString();
    }
    
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
