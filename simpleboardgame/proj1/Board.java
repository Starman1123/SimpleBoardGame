import java.awt.Color;
import java.util.*;
public class Board {
	
	public static boolean iAmDebugging = true;
	private ArrayList<Connector> red;
	private ArrayList<Connector> blue;
	private ArrayList<Connector> white;
	private ArrayList<Connector> smart;
	// Initialize an empty board with no colored edges.
	public Board ( ) {
		// You fill this in.
		red = new ArrayList<Connector>();
		blue = new ArrayList<Connector>();
		white = new ArrayList<Connector>();
		smart = new ArrayList<Connector>();
		white.add(new Connector(1,2));
		white.add(new Connector(1,3));
		white.add(new Connector(1,4));
		white.add(new Connector(1,5));
		white.add(new Connector(1,6));
		white.add(new Connector(2,3));
		white.add(new Connector(2,4));
		white.add(new Connector(2,5));
		white.add(new Connector(2,6));
		white.add(new Connector(3,4));
		white.add(new Connector(3,5));
		white.add(new Connector(3,6));
		white.add(new Connector(4,5));
		white.add(new Connector(4,6));
		white.add(new Connector(5,6));
		smart.add(new Connector(1,6));
		smart.add(new Connector(1,2));
		smart.add(new Connector(2,3));
		smart.add(new Connector(3,4));
		smart.add(new Connector(4,5));
		smart.add(new Connector(5,6));
		smart.add(new Connector(1,4));
		smart.add(new Connector(2,5));
		smart.add(new Connector(3,6));
		
	
	
	
	}
	
	// Add the given connector with the given color to the board.
	// Unchecked precondition: the given connector is not already chosen 
	// as RED or BLUE.
	public void add (Connector cnctr, Color c) {
		// You fill this in.
		if (c.equals(Color.BLUE)) {
			blue.add(cnctr);
			
			
		} 
		else if (c.equals(Color.RED)) {
			red.add(cnctr);
				
				
		}
	}
	
	// Set up an iterator through the connectors of the given color, 
	// which is either RED, BLUE, or WHITE. 
	// If the color is WHITE, iterate through the uncolored connectors.
	// No connector should appear twice in the iteration.  
	public Iterator<Connector> connectors (Color c) {
		// You fill this in.
		class ConIterRed implements Iterator<Connector> {
			private int index = 0;
			public boolean hasNext() {
				return (index < red.size());
			}
			public Connector next() {
				index++;
				return red.get(index - 1);
			}
			public void remove() {
			}	
		}
		class ConIterBlue implements Iterator<Connector> {
			private int index = 0;
			public boolean hasNext() {
				return (index < blue.size());
			}
			public Connector next() {
				index++;
				return blue.get(index - 1);
			}
			public void remove() {
			}	
		}
		class ConIterWhite implements Iterator<Connector> {
			private int index = 0;
			public boolean hasNext() {
				return (index < white.size());
			}
			public Connector next() {
				index++;
				return white.get(index - 1);
			}
			public void remove() {
			}	
		}
		class ConIterSmartMoves implements Iterator<Connector> {
			private int index = 0;
			public boolean hasNext() {
				return (index < smart.size());
			}
			public Connector next() {
				index++;
				return smart.get(index - 1);
			}
			public void remove() {
			}	
		}
		if (c.equals(Color.RED)){
			ConIterRed iter = new ConIterRed();
			return iter;
		}
		else if (c.equals(Color.BLUE)){
			ConIterBlue iter = new ConIterBlue();
			return iter;
		}
		else if (c.equals(Color.WHITE)){
			ConIterWhite iter = new ConIterWhite();
			return iter;
		}
		else if (c.equals(Color.GREEN)){
			ConIterSmartMoves iter = new ConIterSmartMoves();
			return iter;
		}
		else return null;
	}
	
	// Set up an iterator through all the 15 connectors.
	// No connector should appear twice in the iteration.  
	public Iterator<Connector> connectors ( ) {
		// You fill this in.
		
		class ConIterAll implements Iterator<Connector> {
			private int index = 0;
			public boolean hasNext() {
				return (index <= 14);
			}
			public Connector next() {
				return white.get(index++);
			}
			public void remove() {
			}	
		}
		ConIterAll iter = new ConIterAll();
		return iter;
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
		// You fill this in.
		Iterator<Connector> iter = this.connectors (Color.WHITE);
		Iterator<Connector> iterrr = this.connectors (Color.WHITE);
		Iterator<Connector> iterSmart = this.connectors (Color.GREEN);
		
		while (iterSmart.hasNext() == true) {
			Connector temp = iterSmart.next();
			if (!this.formsTriangle(temp, Color.BLUE) && this.colorOf(temp) == Color.WHITE) {
				return temp;
			}
		}
		while (iter.hasNext() == true) {
			Connector temp = iter.next();
			if (!this.formsTriangle(temp, Color.BLUE) && this.colorOf(temp) == Color.WHITE) {
				return temp;
			}
		}
		while (iterrr.hasNext() == true) {
			Connector temp = iterrr.next();
			if (this.colorOf(temp) == Color.WHITE) {
				return temp;
			}
		}
		return null;
	}

	// Return true if the instance variables have correct and internally
	// consistent values.  Return false otherwise.
	// Unchecked prerequisites:
	//	Each connector in the board is properly initialized so that 
	// 	1 <= myPoint1 < myPoint2 <= 6.
	public boolean isOK ( ) {
		// You fill this in.
		for (int i = 0; i < red.size() - 1; i++) {
			if (1 <= red.get(i).endPt1() && red.get(i).endPt1() < red.get(i).endPt2() && red.get(i).endPt2() <= 6) {
			}
			else return false;
		}
		for (int i = 0; i < blue.size() - 1; i++) {
			if (1 <= blue.get(i).endPt1() && blue.get(i).endPt1() < blue.get(i).endPt2() && blue.get(i).endPt2() <= 6) {
			}
			else return false;
		}
		for (int i = 0; i < white.size() - 1; i++) {
			if (1 <= white.get(i).endPt1() && white.get(i).endPt1() < white.get(i).endPt2() && white.get(i).endPt2() <= 6) {
			}
			else return false;
		}
		return true;
	}
}
