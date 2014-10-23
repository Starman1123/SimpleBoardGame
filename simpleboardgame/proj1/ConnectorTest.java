import static org.junit.Assert.*;

import org.junit.Test;


public class ConnectorTest {

	@Test
	public void toConnectortest1() {
		Connector c1 = new Connector(3, 4);
		assertEquals(c1, Connector.toConnector("34"));
		assertEquals(c1, Connector.toConnector(" 43"));
		assertEquals(c1, Connector.toConnector("  43 "));
		assertEquals(c1, Connector.toConnector("43      "));
	}
	@Test
	public void toConnectortest2() {
		Connector c1 = new Connector(3, 4);
		try {c1.equals(Connector.toConnector("  4 3  "));
		} catch (IllegalArgumentException ex) {
			ex.getMessage().equals("No whitesapce between two points");
		}
	}
	
	@Test
	public void toConnectortest3() {
		try {Connector.toConnector("5 6");
		} catch (IllegalArgumentException ex1) {
			ex1.getMessage().equals("No whitesapce between two points");
		}
	}
	@Test
	public void toConnectortest4() {
		try {Connector.toConnector(" 123 "); 
		}	catch (IllegalArgumentException ex2) {
				ex2.getMessage().equals("Illegal Input");
			}
		try {Connector.toConnector(" 12352 "); 
		}	catch (IllegalArgumentException ex2) {
				ex2.getMessage().equals("Illegal Input");
			}
	}
	@Test
	public void toConnectortest5() {
		try {Connector.toConnector(" 19 "); 
		}	catch (IllegalArgumentException ex2) {
				ex2.getMessage().equals("The point should not be smaller than 1 or bigger than 6");
			}
		try {Connector.toConnector(" 0a "); 
		}	catch (IllegalArgumentException ex2) {
				ex2.getMessage().equals("The point should not be smaller than 1 or bigger than 6");
			}
		try {Connector.toConnector(" 12a "); 
		}	catch (IllegalArgumentException ex2) {
				ex2.getMessage().equals("The point should not be smaller than 1 or bigger than 6");
			}
	}
	@Test
	public void toConnectortest6() {
		try {Connector.toConnector(" 11 "); 
		}	catch (IllegalArgumentException ex2) {
				ex2.getMessage().equals("Two points cannot be the same");
			}
	}
}





/// try/catch clause

//within the catch clause, use the getmessage method to assert the message the exception contains
//equals the message you type in e.getme.euqlas("Dont'evkdjalskdjf")