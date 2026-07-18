/**
 * 
 */
package dailymixes;

import java.util.Arrays;
import java.util.Objects;

/**
 * this is the playlist class
 * 
 * @author linda
 * @version 2024.03.30
 */
public class Playlist implements Comparable<Playlist> {

    /**
     * these are the fields
     */
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    /**
     * this is the constructor
     * 
     * @param playlistName
     *            is a playlist name
     * @param minPop
     *            is the min pop
     * @param minRock
     *            is the min rock
     * @param minCountry
     *            is the min country
     * @param maxPop
     *            is the max pop
     * @param maxRock
     *            is the max rock
     * @param maxCountry
     *            is the max country
     * @param playlistCap
     *            is the playlist cap
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)

    {
        this.name = playlistName;
        this.minGenreSet = new GenreSet(minPop, minRock, minCountry);
        this.maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.capacity = playlistCap;
        this.songs = new Song[playlistCap];
        this.numberOfSongs = 0;

    }


    /**
     * this is the getMinGenreSet()
     * 
     * @return min genre set
     */
    public GenreSet getMinGenreSet() {
        return minGenreSet;
    }


    /**
     * this is the setName()
     * 
     * @param playlistName
     *            is a String
     */
    public void setName(String playlistName) {
        this.name = playlistName;
    }


    /**
     * this is the getSpacesLeft()
     * 
     * @return capacity minus numOfSongs
     */
    public int getSpacesLeft() {
        return capacity - numberOfSongs;
    }


    /**
     * this is the getMaxGenreSet()
     * 
     * @return max
     */
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }


    /**
     * this is the compareTo()
     * 
     * @param other
     *            is the playlist
     * @return this name compared to other
     */
    public int compareTo(Playlist other) {

        if (this.capacity != other.getCapacity()) {
            return this.capacity - other.getCapacity();
        }
        if (this.getSpacesLeft() != other.getSpacesLeft()) {
            return other.getSpacesLeft() - this.getSpacesLeft();
        }
        if (!this.minGenreSet.equals(other.minGenreSet)) {
            return this.minGenreSet.compareTo(other.minGenreSet);
        }
        if (!this.maxGenreSet.equals(other.maxGenreSet)) {
            return this.maxGenreSet.compareTo(other.maxGenreSet);
        }
        else {
            return this.name.compareTo(other.name);
        }
    }


    /**
     * this is the getNumberOfSongs()
     * 
     * @return number of songs
     */
    public int getNumberOfSongs() {
        return numberOfSongs;
    }


    /**
     * this is the addSong()
     * 
     * @param newSong
     *            is the song
     * @return false
     */
    public boolean addSong(Song newSong) {
        if (!isFull() && isQualified(newSong)) {
            songs[numberOfSongs++] = newSong;
            return true;
        }
        return false;
    }


    /**
     * this is the toString()
     * 
     * @return string builder
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(name).append(", # of songs: ").append(
            numberOfSongs).append(" (cap: ").append(capacity).append(
                "), Requires: ").append("Pop:").append(minGenreSet.getPop())
            .append("%-").append(maxGenreSet.getPop()).append("%, ").append(
                "Rock:").append(minGenreSet.getRock()).append("%-").append(
                    maxGenreSet.getRock()).append("%, ").append("Country:")
            .append(minGenreSet.getCountry()).append("%-").append(maxGenreSet
                .getCountry()).append("%");
        return sb.toString();
    }


    /**
     * this is the isFull()
     * 
     * @return number of songs is the capacity
     */
    public boolean isFull() {
        return numberOfSongs == capacity;
    }


    /**
     * this is the equals()
     * 
     * @param obj
     *            is the object
     * @return objects
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist)obj;
        return Objects.equals(this.name, other.name) && Objects.equals(
            this.minGenreSet, other.minGenreSet) && Objects.equals(
                this.maxGenreSet, other.maxGenreSet) && Arrays.equals(
                    this.songs, other.songs) && this.capacity == other.capacity
            && this.numberOfSongs == other.numberOfSongs;
    }


    /**
     * this is the getSongs()
     * 
     * @return songs
     */
    public Song[] getSongs() {
        return songs;
    }


    /**
     * this is the getCapacity()
     * 
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * this is the getName()
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * this is the isQualified
     * 
     * @param song
     *            is the song
     * @return song genre
     */
    public boolean isQualified(Song song) {
        GenreSet songGenre = song.getGenreSet();
        return songGenre.isWithinRange(minGenreSet, maxGenreSet);
    }
}
