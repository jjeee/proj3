public class Art {
    int artistID,artID,value;
    String artTitle;

    public Art(int artistID, int artID, int value, String artTitle) {
        this.artistID = artistID;
        this.artID = artID;
        this.value = value;
        this.artTitle = artTitle;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public int getArtID() {
        return artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %5d",artID,artTitle,value);
    }
}
