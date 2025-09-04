/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* WEBSITE CLASS (Webstie.java)                                                                                                           /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package referenceapplication;

public class Website extends Reference {
    private final String websiteName;
    private final String url;
    private final String dateAccessed;
    
    // CONSTRUCTOR
    public Website(String[] authors, int publicationYear, String title, String websiteName, String url, String dateAccessed){
        super(authors, publicationYear, title);
        
        // for website name
        if (websiteName != null){
            this.websiteName = websiteName.trim();
        } else {
            this.websiteName = "";
        }
        
        // for url
        if (url != null){
            this.url = url.trim();
        } else {
            this.url = "";
        }
        
        // for date accessed
        if (dateAccessed != null){
            this.dateAccessed = dateAccessed.trim();
        } else {
            this.dateAccessed = "";
        }
    }
    
    @Override
    public String formatReference(){
        String accessedText = dateAccessed.isBlank() ? "" : " [Accessed " + dateAccessed + "]";
        return String.format("%s %d. %s. %s. Available at: %s%s.",
              Reference.formatAuthors(getAuthors()),
              getPublicationYear(),
              getTitle(), 
              websiteName,
              url,
              accessedText
        ).trim();
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
