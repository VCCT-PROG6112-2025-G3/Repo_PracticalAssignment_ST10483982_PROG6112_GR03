/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* BOOK CLASS (Book.java)                                                                                                                 /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package referenceapplication;

public class Book extends Reference {
    private final String placeOfPublication;
    private final String publisher;
    private final String edition;
    
    // CONSTRUCTOR
    public Book(String[] authors, int publicationYear, String title, String placeOfPublication, String publisher, String edition){
        super(authors, publicationYear, title);
        
        // for place of publication
        if(placeOfPublication != null){
            this.placeOfPublication = placeOfPublication.trim();
        } else {
            this.placeOfPublication = "";
        }
        
        // for publisher
        if (publisher != null){
            this.publisher = publisher.trim();
        } else {
            this.publisher = "";
        }
        
        // for edition
        if (edition != null){
            this.edition = edition.trim();
        } else {
            this.edition = "";
        }
    }
    
    @Override
    public String formatReference(){
        boolean includeEdition = !edition.isBlank() && !edition.equalsIgnoreCase("1st ed.") && !edition.equals("1");
        
        String editionText;
        
        // Edition included in reference
        if (includeEdition){
            editionText = " " + edition;
        }
        else {
            editionText = "";
        }
        
        String formattedRef = String.format("%s %d. %s.%s %s: %s.",
                Reference.formatAuthors(getAuthors()),
                getPublicationYear(),
                getTitle(),
                editionText,
                placeOfPublication,
                publisher
        );
        
        // Line reccommended by ChatGPT (2025) to clean up accidental double dots
        return formattedRef.replace("..", ".").trim();
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
