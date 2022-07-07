package regex;

public class RCTest {
    
    public static void main(String[] args) {
        RC rc = new RC("850228/7772");
        //RC rc = new RC("846224/7776");
        System.out.printf("RC: %s, Date: %td.%<tm.%<tY, Female: %b", rc.getValue(), rc.getDate(), rc.isFemale());
    }    
}
