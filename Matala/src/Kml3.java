import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

public class Kml3 extends file2csv{
	



	// Function to cast Double to string
	public static String Dtostring(Double x){
		String DAsString = new Double(x).toString();
		return DAsString;
	}
		public static void ToKml(ArrayList<WiFiList> macs){	
			final Kml kml = new Kml();
			Document document = kml.createAndSetDocument();
			
			for (int i = 0; i < macs.size(); i++) {
				TimeStamp t = new TimeStamp();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				t.setWhen("yyyy-MM-dd HH:mm:ss").format((blabla.get(25).getList().get(1).getTime())));
				document.createAndAddPlacemark().withName(macs.get(i).getID()).withOpen(Boolean.TRUE)
				.withDescription(" Mac: "+macs.get(i).getMAC()+
			" Signal: "+macs.get(i).getRSSI()+" SSID: "+macs.get(i).getID()+" Frequency: "+macs.get(i).getChannel())
				.withTimePrimitive(t).createAndSetPoint().
				addToCoordinates(macs.get(i).getCLitude(),macs.get(i).getCLatitude());
			}

			try {
				kml.marshal(new File("C:\\Users\\Xcompany\\Documents\\CSV\\KML.kml"));
				System.out.println("completed");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}


	
		}
	

