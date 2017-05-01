import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadArtistList {
    private Scanner fileArtist;

    public ReadArtistList(){
        try {
            fileArtist=new Scanner(new File("p1artists.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArtistList readFile(ArtistList list){
        fileArtist.useDelimiter("\t|\r\n");
        while (fileArtist.hasNext()){
            int id=fileArtist.nextInt();
            String name=fileArtist.next();

            list.addNode(id,name);

        }
        return list;
    }

    public void closeFile(){
        fileArtist.close();
    }
}
