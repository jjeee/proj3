import java.util.ArrayList;

public class Artist {
    private int artistID;
    private String artistName;
    ArrayList<Art> art;

    public Artist(int iD, String name) {
        artistID = iD;
        artistName = name;
        art=new ArrayList<>();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    @Override
    public String toString() {
        return artistID + "\t" + artistName;
    }
}