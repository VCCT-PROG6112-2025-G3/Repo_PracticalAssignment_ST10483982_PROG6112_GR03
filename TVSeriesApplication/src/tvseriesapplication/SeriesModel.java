/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* SERIES MODEL CLASS (SeriesModel.java)                                                                                                  /
/*                                                                                                                                        /
/* Description: SeriesModel class that acts as a data model representing a single TV series. It encapsulates attributes (ID, Name, Age    /
/*              Restriction, Number of Episodes) and provides getter and setter methods, along with a toString() method for displaying.   /                                      /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package tvseriesapplication;


public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;
    
/* -------------------------------------------------------------CONSTRUCTOR-----------------------------------------------------------------*/
    public SeriesModel(String seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes){
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
    
/* ------------------------------------------------------------GETTER METHODS---------------------------------------------------------------*/
    public String getSeriesId(){
        return seriesId;
    }
    
    public String getSeriesName(){
        return seriesName;
    }
    
    public int getSeriesAge(){
        return seriesAge;
    }
    
    public int getSeriesNumberOfEpisodes(){
        return seriesNumberOfEpisodes;
    }
    
/* ------------------------------------------------------------SETTER METHODS---------------------------------------------------------------*/
    public void setSeriesId(String seriesId){
        this.seriesId = seriesId;
    }
    
    public void setSeriesName(String seriesName){
        this.seriesName = seriesName;
    }
    
    public void setSeriesAge(int seriesAge){
        this.seriesAge = seriesAge;
    }
    
    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes){
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
    
/* -----------------------------------------------------------toString() METHOD--------------------------------------------------------------*/
    @Override
    public String toString(){
        return "SERIES ID: " + seriesId +
               "\nSERIES NAME: " + seriesName +
               "\nSERIES AGE RESTRICTION: " + seriesAge +
               "\nSERIES NUMBER OF EPISODES: " + seriesNumberOfEpisodes; 
    }
    
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
