import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

public class Kml3 extends file2csv{
	



	// Function to cast Double to string
	public static String Dtostring(Double x){
		String DAsString = new Double(x).toString();
		return DAsString;
	}
		public static void ToKml(){	
			final Kml kml = new Kml();
			Document document = kml.createAndSetDocument();
			
			for (int i = 1; i < blabla.size(); i++) {
				for (int j = 0; j < blabla.get(i).getList().size(); j++) {
				System.out.println(blabla.size());
				TimeStamp t = new TimeStamp();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				t.setWhen(sdf.format((blabla.get(i).getList().get(j).getTime())));
				document.createAndAddPlacemark().withName(blabla.get(i).getList().get(j).getSSID()).withOpen(Boolean.TRUE)
				.withDescription(" Mac: "+(blabla.get(i).getList().get(j).getMAC())+
			" Signal: "+(blabla.get(i).getList().get(j).getSignal())+" SSID: "+(blabla.get(i).getList().get(j).getSSID())+" Frequency: "+(blabla.get(i).getList().get(j).getFrequency()))
				.withTimePrimitive(t).createAndSetPoint().
				addToCoordinates((blabla.get(i).getAlt()),(blabla.get(i).getLat()));
			}}

			try {
				kml.marshal(new File("C:\\Users\\gilad22\\Desktop\\KML.kml"));
				System.out.println("completed");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}


	
		}
	

