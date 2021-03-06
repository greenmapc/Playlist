package util;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import playlist.Mp3Track;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Anna Kuzmenko
 */
public class Mp3Reader implements DataReader {
    private List<Mp3Track> store = new ArrayList<>();

    @Override
    public List<Mp3Track> readFile() throws IOException, InvalidDataException, UnsupportedTagException {
        File folder = new File("data/AllSongs");
        File[] files = folder.listFiles();
        return transformToMp3(files);
    }

    private List<Mp3Track> transformToMp3(File[] files) throws InvalidDataException, IOException, UnsupportedTagException {
        for(File x : files) {
            store.add(new Mp3Track(x.getPath()));
        }
        return store;
    }
}
