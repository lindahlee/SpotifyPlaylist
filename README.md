# SpotifyPlaylist

🎧 Daily Mix Playlist Sorter

A GUI-based simulation that sorts a queue of songs into curated playlists based on genre composition — inspired by Spotify's Daily Mix algorithm. Songs are pulled from a queue one at a time and accepted or rejected into the best-fitting playlist based on genre percentage ranges.


🎓 Built for CS 2114: Software Design & Data Structures at Virginia Tech




🚀 What It Does

The program reads in a list of songs and a list of playlists (each with genre requirements and a capacity), then launches an interactive GUI where songs are processed one by one:


🎵 Each song has a genre breakdown: % Pop, % Rock, % Country
📻 Each playlist accepts songs only within its defined genre min/max ranges
✅ Accept — adds the current song to the best-matching, most space-constrained qualifying playlist
❌ Reject — skips the song and moves to the next one in queue
🖼️ The window visually updates song notes, playlists, and stats as songs are processed



🏗️ Architecture

FilePurposeProjectRunner.java🎬 Entry point — reads file args (or defaults) and starts the programPlaylistReader.java📖 Parses songs & playlists from comma-separated input filesPlaylistCalculator.java🧮 Core logic — matches songs to the best-fitting playlistPlaylistWindow.java🖥️ GUI layer — renders queue, playlists, and buttonsArrayQueue.java🔁 Custom circular-array queue implementationPlaylist.java📻 Playlist object with genre range, capacity, and song listSong.java🎵 Song object with name, genre breakdown, and suggested playlistGenreSet.java🎼 Represents a Pop/Rock/Country percentage breakdownDailyMixDataException.java⚠️ Custom exception for invalid input data


⚙️ How to Run

bashjavac dailymixes/*.java
java dailymixes.ProjectRunner songs.txt playlists.txt

If no arguments are given, it defaults to input.txt and playlists.txt.

Expected file formats:

text# songs.txt
SongName, popPercent, rockPercent, countryPercent[, suggestedPlaylist]

# playlists.txt
PlaylistName, minPop, minRock, minCountry, maxPop, maxRock, maxCountry, capacity


✅ Validation Rules


All genre percentages must fall between 0 and 100
Playlist files must contain exactly 3 playlists
Malformed rows or out-of-range values throw a ParseException or DailyMixDataException



🧠 Key Design Points


Custom circular ArrayQueue — no built-in Java Queue, implemented from scratch with dynamic resizing
Genre-range matching — songs are routed to the playlist with the tightest fit and least remaining space, not just the first match
Separation of concerns — parsing (PlaylistReader), matching logic (PlaylistCalculator), and rendering (PlaylistWindow) are fully decoupled



👩‍💻 Author

Built by Linda — Virginia Tech, CS 2114
