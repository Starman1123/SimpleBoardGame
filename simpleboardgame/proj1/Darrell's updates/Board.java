package proj1;


import java.awt.Color;
import java.util.*;
public class Board {

    public static boolean iAmDebugging = true;
    private ArrayList<Connector> red;
    private ArrayList<Connector> blue;
    private ArrayList<Connector> white;
    
    // Initialize an empty board with no colored edges.
    public Board ( ) {
        // You fill this in.
        red = new ArrayList<Connector>();
        blue = new ArrayList<Connector>();
        white = new ArrayList<Connector>();

        //looping to populate the board with all possible connections, ensuring valid connections
        for (int i = 1; i <= 6; i++){
            for (int j = i + 1; j <= 6; j++){
                if (i < j){
                    Connector temp = new Connector(i,j);
                    white.add(temp);
                    System.out.println(i + " , " +  j);
                }
            }
        }
    }

    // Add the given connector with the given color to the board.
    // Unchecked precondition: the given connector is not already chosen
    // as RED or BLUE.
    public void add (Connector cnctr, Color c) {
        // You fill this in.
        if (c.equals(Color.BLUE)) {
            blue.add(cnctr);
        }     
        else{
            if (c.equals(Color.RED)) {
                red.add(cnctr);
            }
        }
    }
    
    // Set up an iterator through the connectors of the given color,
    // which is either RED, BLUE, or WHITE.
    // If the color is WHITE, iterate through the uncolored connectors.
    // No connector should appear twice in the iteration.
    public Iterator<Connector> connectors (Color c) {
        // You fill this in.

        //As per the Proj1 PDF, this is how to construct an iterator from an ArrayList
        ArrayList<Connector> whiterator = new ArrayList<Connector>();
        Iterator<Connector> connectors = white.iterator();

        while(connectors.hasNext()){
            Connector item = connectors.next();
            if (colorOf(item) == c){
                whiterator.add(item);
            }

        }
        return whiterator.iterator();
    }

    // Set up an iterator through all the 15 connectors.
    // No connector should appear twice in the iteration.
    public Iterator<Connector> connectors ( ) {
        // You fill this in.
        return white.iterator();
    }

    // Return the color of the given connector.
    // If the connector is colored, its color will be RED or BLUE;
    // otherwise, its color is WHITE.
    public Color colorOf (Connector e) {
        // You fill this in.
        if (red.contains(e)) {
            return Color.RED;
        }
        else if (blue.contains(e)) {
            return Color.BLUE;
        }
        else return Color.WHITE;
    }

    // Unchecked prerequisite: cnctr is an initialized uncolored connector.
    // Let its endpoints be p1 and p2.
    // Return true exactly when there is a point p3 such that p1 is adjacent
    // to p3 and p2 is adjacent to p3 and those connectors have color c.

        public boolean formsTriangle (Connector cnctr, Color c) {
        // You fill this in.
        if (c == Color.RED) {
            for (int n = 0; n < red.size() - 1; n++) {
                for (int m = 1 ; m + n <= red.size() - 1; m++) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(red.get(n).endPt1());
                    list.add(red.get(n).endPt2());
                    if (list.contains(red.get(n+m).endPt1())){
                        list.add(red.get(n+m).endPt2());
                        if (list.contains(cnctr.endPt1()) && list.contains(cnctr.endPt2())){
                            return true;
                        } else {
                            list.remove(2);
                        }
                    }
                    else if (list.contains(red.get(n+m).endPt2())){
                        list.add(red.get(n+m).endPt1());
                        if (list.contains(cnctr.endPt1()) && list.contains(cnctr.endPt2())){
                            return true;
                        } else {
                            list.remove(2);
                        }
                    }
                }
            }
            return false;
        }
        if (c == Color.BLUE) {
            for (int n = 0; n < blue.size() - 1; n++) {
                for (int m = 1 ; m + n <= blue.size() - 1; m++) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(blue.get(n).endPt1());
                    list.add(blue.get(n).endPt2());
                    if (list.contains(blue.get(n+m).endPt1())){
                        list.add(blue.get(n+m).endPt2());
                        if (list.contains(cnctr.endPt1()) && list.contains(cnctr.endPt2())){
                            return true;
                        } else {
                            list.remove(2);
                        }
                    }
                    else if (list.contains(blue.get(n+m).endPt2())){
                        list.add(blue.get(n+m).endPt1());
                        if (list.contains(cnctr.endPt1()) && list.contains(cnctr.endPt2())){
                            return true;
                        } else {
                            list.remove(2);
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }


    // The computer (playing BLUE) wants a move to make.
    // The board is assumed to contain an uncolored connector, with no
    // monochromatic triangles.
    // There must be an uncolored connector, since if all 15 connectors are colored,
    // there must be a monochromatic triangle.
    // Pick the first uncolored connector that doesn't form a BLUE triangle.
    // If each uncolored connector, colored BLUE, would form a BLUE triangle,
    // return any uncolored connector.
    public Connector choice ( ) {

        for(int i = 0; i < white.size(); i++){
            if ( !red.contains(white.get(i)) && !blue.contains(white.get(i)) && !formsTriangle(white.get(i), Color.BLUE) ){
                return white.get(i);
            }
        }
        return null;
    }
    // Return true if the instance variables have correct and internally
    // consistent values.  Return false otherwise.
    // Unchecked prerequisites:
    //  Each connector in the board is properly initialized so that
    //  1 <= myPoint1 < myPoint2 <= 6.
    public boolean isOK ( ) {
        //Verify that no points are shared between ArrayList red and ArrayList blue
        //Verify that all points in both red and blue are Connector Objects
        //Verify that red is always 1 size() larger or equal to blue (since red goes first)
        //No need to verify that all Connector Objects possess a color since they are in separate ArrayLists
        //
        // You fill this in.
        return true;
    }
}