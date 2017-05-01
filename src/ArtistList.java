public class ArtistList {
    static ArtistNode list,lastNode;
    static int totalEntries;
    int nextID;

    public ArtistList(){
        list=null;
        lastNode=null;
        totalEntries=0;
        nextID=0;
    }

    public int getNextID() {return nextID;}

    public void setNextID(int nextID) {this.nextID = nextID;}

    public static boolean isEmpty(){ return  totalEntries==0;}

    public static void addNode(int id,String name){
        ArtistNode newNode=new ArtistNode(id,name,null);
        if (isEmpty()){
            list =newNode;
            totalEntries++;
        }else {
            newNode.next=list;
            lastNode=newNode;
            list=lastNode;
            totalEntries++;
        }
    }

    public boolean delete(int id){
        boolean result=false;
        ArtistNode temp=getRef(id+1),replace;
        if (temp!=null){
            replace = temp.next.next;
            temp.next=replace;
            totalEntries--;
            result=true;
        }

        return result;
    }

    private ArtistNode getRef(int id){
        boolean found=false;
        ArtistNode current=lastNode;

        while (!found&&(current!=null)){
            if (id==current.getArtistID())
                found=true;
            else
                current=current.getNext();
        }return current;
    }

    public void print(ArtistNode node, java.io.PrintWriter output){

        if (node.next!=null){
            print(node.next,output);
        }
        output.println(node);
    }

    @Override
    public String toString() {
        return list+" ";
    }
}
