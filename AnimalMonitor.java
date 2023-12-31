import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
/**
 * Add sighting read from a given filename to the current list
 * @author M M Habib
 * @version 20231230
 */
public class AnimalMonitor
{
    private ArrayList<Sighting> sightings;
    private ArrayList<String> endangered;
    private HashSet<String> animalSet;
    /**
     * Create an animal monitor
     * @param none
     * @return none
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
        this.endangered = new ArrayList<>();
        this.animalSet = new HashSet<>();
    }

    /**
     * addSightings adds sightings recorded in a given filename to the current list
     */
    public void addSightings(String filename)
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings(filename));
    }
    /**
     * printList prints all sightings in the ArrayList
     */
    public void printList()
    {
        sightings.stream()
                        .map(s->s.getDetails())
                        .forEach(s->System.out.println(s));
    }
    /**
     * printSightingsOf prints details of a particular animal
     * @param animal
     * @return none
     */
    public void printSightingsAnimal(String animal)
    {
        sightings.stream()
                        .filter(s->animal.equals(s.getAnimal()))
                        .forEach(s->System.out.println(s.getDetails()));
    }
    /**
     * printEndangered prints list of animals considered endangered
     * @param threshold count
     * @return none
     */
    public void printEndangered(int threshold)
    {
        makeAnimalSet();
        animalSet.stream()
                        .filter(s->threshold > getCount(s))
                        .forEach(System.out::println);
        /*for (String s : animalSet) {
            int num = getCount(s);
            if (num < threshold) {
                System.out.println(s + " : " + num);
            }
        }*/
    }
    /**
     * makeAnimalSet makes an set of all animals seen
     * @param none
     * @return HashSet of animal names
     */
    public void makeAnimalSet()
    {
        sightings.stream()
                        .map(s->s.getAnimal())
                        .forEach(s->animalSet.add(s));
        /*animalSet.stream()
                    .forEach(s->System.out.println(s));*/
    }
    /**
     * printSightingsAnimalCount prints count in each sighting of a particular animal
     * @param animal
     * @return none
     */
    public void printSightingsAnimalCount(String animal)
    {
        sightings.stream()
                        .filter(s->animal.equals(s.getAnimal()))
                        .map(s->s.getCount())
                        .forEach(s->System.out.println(s));
    }
    /**
     * printSightingsBy prints sighting by a particular spotter
     * @param spotterID
     * @return none
     */
    public void printSightingsSpotter(int spotterID)
    {
        sightings.stream()
                        .filter(s->spotterID == s.getSpotterID())
                        .map(s->s.getDetails())
                        .forEach(System.out::println);
    }
    /**
     * printSightingsArea prints sighting by particular area
     * @param areaID
     * @return none
     */
    public void printSightingsArea(int area)
    {
        sightings.stream()
                        .filter(s->area == s.getArea())
                        .forEach(s->System.out.println(s.getDetails()));
    }
    /**
     * printSigtingsPeriod prints sightings in given period
     * @param periodID
     * @return none
     */
    public void printSightingsPeriod(int period)
    {
        sightings.stream()
                        .filter(s->period == s.getPeriodID())
                        .forEach(s->System.out.println(s.getDetails()));
    }
    /**
     * printSightingsAnimalPerid prints particular animal on a particular day
     *@param String animal and int periodID
     *@return none
     */
    public void printSightingsAnimalPeriod(String animal, int period)
    {
        sightings.stream()
                        .filter(s->animal.equals(s.getAnimal()))
                        .filter(s->period == s.getPeriodID())
                        .forEach(s->System.out.println(s.getDetails()));
    }
    /**
     * getCount returns number of sightings of given animal
     * @param animal
     * @return int number of sightings
     */
    public int getCount(String animal)
    {
        return sightings.stream()
                        .filter(s->animal.equals(s.getAnimal()))
                        .map(s->s.getCount())
                        .reduce(0, (total, count) ->total + count);
        /*int count = 0;
        for (Sighting sighting : sightings){
            if (sighting.getAnimal().equals(animal)) {
                count++;
            }
            return sightings.stream()
                        .filter(s->animal.equals(s.getAnimal()))
                        .map(s->s.getCount())
                        .reduce(0,(total,s)->  total + s);
        }*/
        
    }
    /**
     * removeZeroCounts removes sightings where animal count was zero.
     * @parameter none
     * @return none
     */
    public void removeZeroCounts()
    {
        Iterator<Sighting> it = sightings.iterator();
        while (it.hasNext()) {
            Sighting record = it.next();
            if (record.getCount()==0) {
                it.remove();
            }
        }
        
    }
}   