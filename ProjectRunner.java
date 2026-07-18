/**
 * 
 */
package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * this is the ProjectRunner class
 * 
 * @author linda
 * @version 2024.03.30
 */
public class ProjectRunner {
    /**
     * this the constructor
     */
    public ProjectRunner() {
        // empty
    }


    /**
     * this the main()
     * 
     * @param args
     * @throws DailyMixException
     * @throws FileNotFoundException
     * @thrwos ParseException
     */
    public static void main(String[] args)
        throws ParseException,
        DailyMixDataException,
        FileNotFoundException {
        if (args.length == 2) {
            String songsFileName = args[0];
            String playlistsFileName = args[1];
            PlaylistReader reader = new PlaylistReader(songsFileName,
                playlistsFileName);

        }
        else {
            PlaylistReader reader = new PlaylistReader("input.txt",
                "playlists.txt");
        }
    }
}
