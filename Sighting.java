
/**
 * Class objects store single record of an anial sighting, including name, numbers, when, where
 * and who sighted
 * @param include String: name, int: spotter ID, int: count, int: area id, int : time period
 **/
public class Sighting
{
    // instance variables - replace the example below with your own
    private final String animal;
    private final int spotterID;
    private final int count;
    private final int areaID;
    private final int periodID;

    /**
     * Constructor for objects of class Sighting
     */
    public Sighting(String animal, int spotterID, int count, int areaID, int periodID)
    {
        this.animal = animal;
        this.spotterID = spotterID;
        this.count = count;
        this.areaID = areaID;
        this.periodID = periodID;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getDetails()
    {
        return  animal + 
                ", count = " + count +
                ", area = " + areaID +
                ", spotter = " + spotterID +
                ", period = " + periodID;
    }
    /**
     * getAnimal returns the animal in the instance
     * @param none
     * @return String
     */
    public String getAnimal()
    {
        return animal;
    }
    /**
     * getSpotterID returns ID of the spotter for sighting instance
     * @param none
     * @return int spotterID
     */
    public int getSpotterID()
    {
        return spotterID;
    }
    /**
     * getCount returns number of animals seen in the instance sighting
     * @param none
     * @return int number of animal seen
     */
    public int getCount()
    {
        return count;
    }
    /**
     * getAreaID returns the ID of the area where the sighting happenned
     * @paran none
     * @return int areaID
     */
    public int getArea()
    {
        return areaID;
    }
    /**
     * getPeriodID returns the ID of the period during which sighting happenned.
     * @param none
     * @return int periodID
     */
    public int getPeriodID()
    {
        return periodID;
    }
}
