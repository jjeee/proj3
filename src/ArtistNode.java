public class ArtistNode extends Artist{
        public ArtistNode next;
        int totalEntries;

        public ArtistNode(int id, String name, ArtistNode next) {
            super(id, name);
            this.next=next;
        }

        public boolean isEmpty(){return totalEntries==0;}

        public ArtistNode getNext() {
            return next;
        }

        public void setNext(ArtistNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return getArtistID() + "\t" + getArtistName();
        }
    }