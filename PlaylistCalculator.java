/**
 * 
 */
package dailymixes;

import java.util.Arrays;

import list.AList;

/**
 * this is the PlaylistCalculator class
 * 
 * @author linda
 * @version 2024.03.30
 */
public class PlaylistCalculator {

    /**
     * these the fields
     */
    private Playlist[] playlists;
    /**
     * these r the static final
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * these r the static final
     */
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    /**
     * these r the static final
     */
    public static final int MAX_PERCENT = 100;
    private ArrayQueue<Song> songQueue;

    /**
     * this is the constructor
     * 
     * @param songQueue
     *            is the arrayQueue
     * @param playlists
     *            is the array playlists
     */
    public PlaylistCalculator(
        ArrayQueue<Song> songQueue,
        Playlist[] playlists) {
        if (songQueue == null || playlists == null) {
            throw new IllegalArgumentException("");
        }
        this.songQueue = songQueue;
        this.playlists = playlists;
        this.rejectedTracks = new AList<>();
    }


    /**
     * this the reject()
     */
    public void reject() {
        if (!songQueue.isEmpty()) {
            rejectedTracks.add(songQueue.dequeue());
        }
    }


    /**
     * this the getPlaylistWithMaximumCapacity()
     * 
     * @param aSong
     *            is the song
     * @return null
     */
    private Playlist getPlaylistWithMaximumCapacity(Song aSong) {
        Playlist[] sortedPlaylists = Arrays.copyOf(playlists, playlists.length);
        Arrays.sort(sortedPlaylists);
        for (Playlist playlist : sortedPlaylists) {
            if (!playlist.isFull() && playlist.isQualified(aSong)) {
                return playlist;
            }
        }
        return null;
    }


    /**
     * this the addSongToPlaylist()
     * 
     * @return false
     */
    public boolean addSongToPlaylist() {
        if (!songQueue.isEmpty()) {
            Song nextSong = songQueue.dequeue();
            Playlist playlist = getPlaylistForSong(nextSong);
            if (playlist != null) {
                playlist.addSong(nextSong);
                return true;
            }
        }
        return false;
    }


    /**
     * this the getPlaylistForSong()
     * 
     * @param nextSong
     *            is the song
     * @return null
     */
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }

        Playlist maxCapacityPlaylist = getPlaylistWithMaximumCapacity(nextSong);
        if (maxCapacityPlaylist != null && canAccept(maxCapacityPlaylist,
            nextSong)) {
            return maxCapacityPlaylist;
        }

        return null;
    }


    /**
     * this is the getQueue()
     * 
     * @return songQueue
     */
    public ArrayQueue<Song> getQueue() {
        return songQueue;
    }


    /**
     * this the canAccept()
     * 
     * @return not full
     */
    private boolean canAccept(Playlist playlist, Song song) {
        return !playlist.isFull() && playlist.isQualified(song);
    }


    /**
     * this the getPlaylisIndex()
     * 
     * @param playlist
     *            is a string
     * @return i
     */
    public int getPlaylistIndex(String playlist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i].getName().equals(playlist)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * this the getPlaylists()
     * 
     * @return playlists
     */
    public Playlist[] getPlaylists() {
        return playlists;
    }

}
