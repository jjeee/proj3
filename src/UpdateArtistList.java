import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateArtistList {
    java.io.PrintWriter output = new java.io.PrintWriter(new File("p3artists.txt"));
    ArtistList artistList = new ArtistList();
    Scanner fileChange;
    ReadArtistList artistListFile = new ReadArtistList();
    ArrayList<Artist> artists=new ArrayList<>();

    public UpdateArtistList() throws IOException{
        long startTime=System.nanoTime();

        artistList=artistListFile.readFile(artistList);
        artistListFile.closeFile();
        changes();
        long stopTime=System.nanoTime();
        long elapsedTime=stopTime-startTime;

        artistList.print(ArtistList.lastNode,output);
        output.close();
        arts();

        output.println("\nStartTime = " + startTime + " StopTime = " + stopTime
                + " ElapsedTime = " + elapsedTime);
        output.close();

    }

    public void changes() throws IOException {
        fileChange=new Scanner(new File("p2changes.txt"));
        int i=artistList.totalEntries+1;

        while (fileChange.hasNext()){
            String sample=fileChange.nextLine();
            String[] sample2=sample.split("\t");
            String codeStr = sample2[0];

            if (codeStr.charAt(0) == 'D'||codeStr.charAt(0) == 'd') {
                int id = Integer.parseInt(sample2[1]);
                artistList.delete(id);
            } else if (codeStr.charAt(0) == 'A'||codeStr.charAt(0) == 'a') {
                String itemname=sample2[1];
                artistList.addNode(i,itemname);
                i++;
            }
        }fileChange.close();

    }

    public void arts() throws IOException {
        Scanner read=new Scanner(new File("p3artists.txt"));

        read.useDelimiter("\t|\r\n");
        while (read.hasNext()){
            int id=read.nextInt();
            String name=read.next();

            artists.add(new Artist(id,name));
        }read.close();

        Scanner artFile=new Scanner(new File("p1arts.txt"));

        artFile.useDelimiter("\t|\r\n");
        while (artFile.hasNext()){
            int artID=artFile.nextInt();
            String title=artFile.next();
            int id=artFile.nextInt();
            int value=artFile.nextInt();

            for (Artist artist:artists){
                if (artist.getArtistID()==id){
                    artist.art.add(new Art(id,artID,value,title));
                }
            }
        }artFile.close();

        java.io.PrintWriter artlist=new java.io.PrintWriter(new File("p3artists_arts.txt"));
        for(Artist artist:artists) {
            artlist.print(artist);
            for (Art art:artist.art)
                artlist.println("\t\t"+art);
        }

        artlist.close();
    }


}
