
/**
 * A Macintosh video.
 * 
 * @author Linda Jiang
 * @version 1.0 2017-01-04
 */
public class Video
{
    /* Class fields*/
    private int MAXIMUM_SCORE = 4;
 
    /* instance variables */
    private int contentScore;
    private int creativityScore; 
    private int layoutAndDesignScore;
    private int technicalElementsScore;
    private String videoTitle;

    /**
     * Constructs a video with default characteristics
     */
    public Video()
    {
        contentScore = 0;
        creativityScore = 0;
        layoutAndDesignScore = 0;
        technicalElementsScore = 0;
        videoTitle = "";
    } // end of constructor Video()

    /* mutators */
    /**
     * Sets the content score of this video
     * 
     * @param score this video's content score;<br><i>Pre-condition:</i> may not be negative and greater than <code>MAXIMUM_SCORE</code>
     */
    public void setContentScore(int score)
    {
        if (score >= 0 && score <= MAXIMUM_SCORE)
        {
            contentScore = contentScore + score;
        } // end of if (contentScore >= 0)
    }  // end of method setContentScore(int score)

    /**
     * Sets the creativity score of this video.
     * 
     * @param score this video's creativity score;<br><i>Pre-condition:</i> may not be negative and greater than <code>MAXIMUM_SCORE</code>
     */
    public void setCreativityScore(int score)
    {
        if (score >= 0 && score <= MAXIMUM_SCORE)
        {
            creativityScore = creativityScore + score;
        } // end of if (creativityScore >= 0)
    } // end of method setCreativityScore (int score)

    /**
     * Sets the layout and design score of this video.
     * 
     * @param score this video's layout and design score;<br><i>Pre-condition:</i> may not be negative and greater than <code>MAXIMUM_SCORE</code>
     */
    public void setLayoutAndDesignScore(int score)
    {
        if (score >= 0 && score <= MAXIMUM_SCORE)
        {
            layoutAndDesignScore = layoutAndDesignScore + score;
        } // end of if (layoutAndDesignScore >= 0)
    } // end of method setLayoutAndDesignScore(int score)

    /**
     * Sets the technical elements score of this video.
     * 
     * @param score this video's technical elements score;<br><i>Pre-condition:</i> may not be negative and greater than <code>MAXIMUM_SCORE</code>
     */
    public void setTechnicalElementsScore(int score)
    {
        if (score >= 0 && score <= MAXIMUM_SCORE)
        {
            technicalElementsScore = technicalElementsScore + score;
        } // end of if (technicalElementsScore >= 0)
    } // end of method setTechnicalElementsScore(int score)

    /**
     * Sets the title of this video.
     * 
     * @param title this video's title;<br><i>Pre-condition:</i> may not be null 
     */
    public void setTitle(String title)
    {
        if (title != null)
        {
            videoTitle = title;
        }
        else
        {
            videoTitle = "";
        } // end of if (contentScore >= 0)
    } // end of method setVideoTitle(String title)

    // accessors
    /**
     * Gets the content score of this video.
     * 
     * @return the content score of this video
     */
    public int getContentScore()
    {
        return contentScore;
    } // end of method getContentScore()

    /**
     * Gets the creativity score of this video.
     * 
     * @return the creativity score of this video
     */
    public int getCreativityScore ()
    {
        return creativityScore;
    } // end of method getCreativityScore ()

    /**
     * Gets the layout and design score of this video.
     * 
     * @return the layout and design score of this video
     */
    public int getLayoutAndDesignScore()
    {
        return layoutAndDesignScore;
    } // end of method getLayoutAndDesignScore()

    /**
     * Gets the technical elements score of this video.
     * 
     * @return the technical elements score of this video
     */
    public int getTechnicalElementsScore()
    {
        return technicalElementsScore;
    } // end of method getTechnicalElementsScore()

    /**
     * Gets the title of this video.
     * 
     * @return the title of this video
     */
    public String getTitle ()
    {
        return videoTitle;
    } // end of method getTitle ()

} // end of class Video
