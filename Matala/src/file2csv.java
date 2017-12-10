import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.text.Format;

public class file2csv {
	 static ArrayList<WiFiList> blabla = new ArrayList();
	// this function get directoryPath and return the cvsFile in the Folder
	public static ArrayList<String> ReadDirectory(String directoryPath) {
		File directory = new File(directoryPath);
		ArrayList
		<String> csvFiles = new ArrayList<String>();
		if (!directory.isDirectory()) {//
			System.out.println("directory is not exist");// 
			return null;// 
		}
		File[] fileNames = directory.listFiles();// 
		if (fileNames.length == 0)// 
		{
			System.out.println("directory is empty");//
			return null;
		}
		for (File file : fileNames) {// 
			if (!file.isDirectory() && file.getAbsolutePath().endsWith(".csv")) {
				csvFiles.add(file.getAbsolutePath());// 
														// 
			} else if (file.isDirectory()) {// 
				csvFiles.addAll(ReadDirectory(file.getAbsolutePath()));
			}
		}
		return csvFiles;//
	}

	// the function get file path and return object wifi list
	private static ArrayList<WiFi> uniteWiFisFromFiles(ArrayList<String> fileNames) {// 
		ArrayList<WiFi> WifiList = new ArrayList<WiFi>();// 
		for (String fileName : fileNames) {// 
			if (fileName.contains("WigleWifi"))
				try {
					FileReader fr = new FileReader(fileName);// 
					BufferedReader br = new BufferedReader(fr);
					String line; //
					line = br.readLine(); // 1
					line = br.readLine();// 2
					line = br.readLine();// �
					while (line != null) {// 
						String[] values = line.split(",");// 
															//
						if (values[10].equals("WIFI")) {// 
							String MAC = values[0];//
							String SSID = values[1];//
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
							Date time = sdf.parse(values[3]);//
							int channel = Integer.parseInt(values[4]);
							int signal = Integer.parseInt(values[5]);
							double lat = Double.parseDouble(values[6]);
							double lon = Double.parseDouble(values[7]);
							double alt = Double.parseDouble(values[8]);
							WiFi wifi = new WiFi(time, lat, lon, alt, channel, signal, MAC, SSID);// 
							WifiList.add(wifi);//
						}
						line = br.readLine();// 
					}
					br.close();
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();
				}

		}
		if (WifiList.isEmpty()) {//
			System.out.println("The files don't contain WiFi's");
			return null;
		}

		return WifiList;//
	}

	// 
	public static String printUnionCSV(String path, ArrayList<WiFi> wifilist) {

		//
		String path1 = "C:/Mivne/UnionFile.csv";
		path = path1;
		PrintWriter pw = null; // 
		try {
			// creating print writer for new file. (like FileReader, can't do
			// much)
			pw = new PrintWriter(new File(path)); //
		} catch (FileNotFoundException e) { // 

			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder(); // Like BufferedReader, in
														// charge to build the
														// "text"
		builder.append("Time,Lat,Alt,Lon,Signal,Frequncy,SSID,MAC\n"); // Creating
																		// the
																		// headers.
											
		for (WiFi wifi : wifilist) {// 
			builder.append(wifi.toStringUnionFile() + "\n"); 
		}
		pw.write(builder.toString()); 
		pw.close();

		return path;
	}

	// the function sort and filter the xxxx.cvs file by the "matala 0
	// requirement
	// the function get path of union xxx.csv file and return sort&filter
	public static ArrayList<WiFiList> FilterAndMakeList(ArrayList<WiFi> list, Filter filter) {
		ArrayList<WiFiList> unionWiFiList = new ArrayList<WiFiList>();//
		WiFiList wifilist = new WiFiList();// 
		for (WiFi wiFi : list) {// 
			if ((filter == null || filter.isBelong(wiFi)) && !wifilist.add(wiFi)) {
				/// for unionWiFiList method
				unionWiFiList.add(wifilist);
				wifilist = new WiFiList(wiFi);
				wifilist.add(wiFi);
			}
		}
		for (WiFiList wiFiList : unionWiFiList) {
			wiFiList.Take10Signals();
		}
				return unionWiFiList;
	}

	public static void printBestListsAfterFilter(String Path, ArrayList<WiFiList> list) {
		PrintWriter pw = null;
		StringBuilder builder = new StringBuilder();
		Path = "C:/Mivne/UnionFile2.csv";
		try {
			pw = new PrintWriter(Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		builder.append("Time,ID,Lat,Alt,Lon,#WiFi Networks" + ",SSID1,MAC1,Frequncy1,Signal1"
				+ ",SSID2,MAC2,Frequncy2,Signal2" + ",SSID3,MAC3,Frequncy3,Signal3" + ",SSID4,MAC4,Frequncy4,Signal4"
				+ ",Signal5,Frequncy5,SSID2,MAC5" + ",Signal6,Frequncy6,SSID6,MAC6" + ",Signal7,Frequncy7,SSID7,MAC7"
				+ ",SSID8,MAC8,Frequncy8,Signal8" + ",SSID9,MAC9,Frequncy9,Signal9"
				+ ",SSID10,MAC10,Frequncy10,Signal10\n");
		for (WiFiList wiFiList : list) {
			builder.append(wiFiList.Make10toString() + "\n");
		}
		pw.write(builder.toString()); 
		pw.close();
	}

	public static void main(String[] args) {
	
		String directory = "C:/Mivne/";
		ArrayList<WiFi> wifilist = uniteWiFisFromFiles(ReadDirectory(directory));
		WiFi al = null;
	    for (WiFi wiFi : wifilist) {
		al = wiFi;
			//System.out.println(wiFi.toStringUnionFile());
		}
	
		printUnionCSV("C:/Mivne/UnionFile.csv", wifilist);
		Filter choice = null;
	//	choice.isBelong(al);
		choice = new FilterTime("2017-11-22 20:24:47", "2017-11-22 20:27:47");
		printBestListsAfterFilter("C:/Mivne/UnionFile2.csv", FilterAndMakeList(wifilist, null));
		blabla=FilterAndMakeList(wifilist, null);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		Date date2 = null;
		try {
		date2 = sdf.parse("2017-11-22 20:23:02");
		System.out.println(date2.before(sdf.parse("2016-11-22 20:23:02")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	 Scanner sc = new Scanner(System.in);

		// System.out.println(date2);
		Kml3.ToKml();
	}

}
