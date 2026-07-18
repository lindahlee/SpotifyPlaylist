/**
 * 
 */
package dailymixes;

/**
 * this is the Song class
 * 
 * @author linda
 * @version 03.30.2024
 */
public class Song {

    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    /**
     * this the constructor
     * 
     * @param name
     *            is a string
     * @param pop
     *            is an int
     * @param rock
     *            is an int
     * @param country
     *            is an int
     * @param suggested
     *            is a string
     */
    public Song(String name, int pop, int rock, int country, String suggested) {
        this.name = name;
        this.genreSet = new GenreSet(pop, rock, country);
        this.suggestedPlaylist = suggested;

    }


    /**
     * this the toString()
     * 
     * @return a string
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name).append(" Pop:").append(genreSet.getPop()).append(
            " Rock:").append(genreSet.getRock()).append(" Country:").append(
                genreSet.getCountry());

        if (suggestedPlaylist.length() > 0) {
            s.append(" Suggested: ").append(suggestedPlaylist);
        }
        else {
            s.insert(0, "No-Playlist ");
        }

        return s.toString();
    }


    /**
     * this the getPlaylistName()
     * 
     * @return suggested playlist
     */
    public String getPlaylistName() {
        return suggestedPlaylist;
    }


    /**
     * this the equals()
     * 
     * @param obj
     *            is the object
     * @return name equals
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Song)) {
            return false;
        }

        Song other = (Song)obj;
        return (this.name.equals(other.name)) && (this.suggestedPlaylist.equals(
            other.suggestedPlaylist)) && (this.genreSet.equals(other.genreSet));
    }


    /**
     * this the getName()
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * this the getGenreSet()
     * 
     * @return genreSet
     */
    public GenreSet getGenreSet() {
        return genreSet;
    }

}
