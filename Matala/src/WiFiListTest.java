import static org.junit.Assert.*;
import org.junit.Test;

public class WiFiListTest {
	
	@Test
	public void nullShouldntAdded() {
		WiFiList wifilist = new WiFiList();
		wifilist.add(null);
		assertEquals(wifilist.getSize(),0);
	}

	@Test
	public void testEqualsWiFi() {
		fail("Not yet implemented");
	}

	@Test
	public void testTake10Signals() {
		fail("Not yet implemented");
	}

	@Test
	public void testMake10toString() {
		fail("Not yet implemented");
	}

}
