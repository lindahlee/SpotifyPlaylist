/**
 * 
 */
package dailymixes;

/**
 * this is the GenreSet class
 * 
 * @author linda
 * @version 03.30.2024
 */
public class GenreSet implements Comparable<GenreSet> {

    private int rock;
    private int pop;
    private int country;

    /**
     * this is the constructor
     * 
     * @param rock
     *            is an int
     * @param pop
     *            is an int
     * @param country
     *            is an int
     */
    public GenreSet(int pop, int rock, int country) {
        this.rock = rock;
        this.pop = pop;
        this.country = country;
    }


    /**
     * this is the getRock()
     * 
     * @return rock
     */
    public int getRock() {
        return rock;
    }


    /**
     * this is the getPop()
     * 
     * @return pop
     */
    public int getPop() {
        return pop;
    }


    /**
     * this the toString()
     * 
     * @return the toString
     */
    public String toString() {
        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;
    }


    /**
     * this the equals()
     * 
     * @return comparison
     * @param obj
     *            is the object
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GenreSet)) {
            return false;
        }
        GenreSet other = (GenreSet)obj;
        return this.pop == other.pop && this.rock == other.rock
            && this.country == other.country;
    }


    /**
     * this the isWithinRange()
     * 
     * @return range
     * @param minGenreSet
     *            is a GenreSet
     * @param maxGenreSet
     *            is a GenreSet
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet) {
        return this.pop >= minGenreSet.pop && this.pop <= maxGenreSet.pop
            && this.rock >= minGenreSet.rock && (this.rock <= maxGenreSet.rock
                && this.country >= minGenreSet.country)
            && (this.country <= maxGenreSet.country);
    }


    /**
     * compares this and other
     * 
     * @return comparison
     * @param other
     *            is a GenreSet
     */
    public boolean isLessThanOrEqualTo(GenreSet other) {
        return (this.pop <= other.pop) && (this.rock <= other.rock)
            && (this.country <= other.country);
    }


    /**
     * this the compareTo()
     * 
     * @return integer comparison
     * @param other is a GenreSet
     */
    public int compareTo(GenreSet other) {
        int sumThis = this.pop + this.rock + this.country;
        int sumOther = other.pop + other.rock + other.country;
        return Integer.compare(sumThis, sumOther);
    }


    /**
     * this the getCountry()
     * 
     * @return country
     */
    public int getCountry() {
        return country;
    }

}
