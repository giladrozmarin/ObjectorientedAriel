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

/*
 * כרגע : פונקציה שלוקחת מכל קובץ שבפורמט נתונים לאובייקט הוויפיי היא נעזרת בפונקציה שמשיגה לה כתובת כדי לעשות את זה 
 * מה אני הולך לעשות : לקחת את כל המערך הדינאמי שלי שמכיל אובייקטים של ווי פי ובעזרתו אני הולך לשפוך הכל לקובץ אחד שאותו אני אמיין לפי הדרישות
 *  שלב שני : אני הולך להפוך את הקובץ הזה לקובץ קיי אמ אל 
 *  
 * שאלות לריכוז 
 * אקספשין, מה המשעמות של סטטיק בפונקציה ,דוגמא לג'אווה דוק נכון ,אתר נחמד לאימפורטים 
 * 
 * 
 *  השאלה אם לקחת מה שאני רוצה מהקובץ או למחוק בו דברים האם בכלל אפשר למחוק דברים איך להוסיף את האיידיי
 */

public class file2csv {
	 static ArrayList<WiFiList> blabla = new ArrayList();
	// this function get directoryPath and return the cvsFile in the Folder
	public static ArrayList<String> ReadDirectory(String directoryPath) {// הפונקציה
																			// תחזיר
																			// רשימה
																			// של
																			// קבצי
																			// סיאסוי
																			// ותקבל
																			// כתובת
		File directory = new File(directoryPath);// פייל זהו אוביקט בג'אווה
													// יצרנו משתנה מסוג זה שמקבל
													// כתובת
		ArrayList<String> csvFiles = new ArrayList<String>();// רשימה מקושרת של
																// סיאסוי שתקבל
																// לתוכה כתובות
																// כסטרינג של
																// כתובות של
																// תקיות
		if (!directory.isDirectory()) {// אם הכתובת היא לא תקייה זרוק אל הלוג
			System.out.println("directory is not exist");// הדפסה
			return null;// החזרה כלום
		}
		File[] fileNames = directory.listFiles();// מערך מסוג אובייקט "פייל"
													// מקבל רשימה של הקבצים
		if (fileNames.length == 0)// בדוק שהתקייה לא ריקה
		{
			System.out.println("directory is empty");// בודק שהתיקה לא ריקה
			return null;
		}
		for (File file : fileNames) {// צורת כתיבה של פור מקוצר יוצר פייל=0 כמו
										// איי בפור רגיל וזה רץ עד הקובץ האחרון
			if (!file.isDirectory() && file.getAbsolutePath().endsWith(".csv")) {// אם
																					// זה
																					// לא
																					// תקייה
																					// וגם
																					// וגם
																					// הקובץ
																					// נגמר
																					// בסיומת
																					// הנכונה
				csvFiles.add(file.getAbsolutePath());// תוסיף את הכתובת של הקובץ
														// לתוך המערך
			} else if (file.isDirectory()) {// אם זה תקייה
				csvFiles.addAll(ReadDirectory(file.getAbsolutePath()));// תבצע
																		// את
																		// הפונקציה
																		// על
																		// התקייה
			}
		}
		return csvFiles;// החזר את המערך
	}

	// the function get file path and return object wifi list
	private static ArrayList<WiFi> uniteWiFisFromFiles(ArrayList<String> fileNames) {// במקרה
																						// שלנו
																						// מקבל
																						// את
																						// הקובץ
																						// שהפונקציה
																						// הקודמת
																						// החזירה
		ArrayList<WiFi> WifiList = new ArrayList<WiFi>();// מערך דינאמי מסוג
															// אובייקט וויפי
		for (String fileName : fileNames) {// פור מקוצר רץ על כל כתובת הקבצים
											// שמצאנו
			if (fileName.contains("WigleWifi"))
				try {
					FileReader fr = new FileReader(fileName);// משתנה מסוג "קורא
																// קבצים" ומכניס
																// לתוכו את
																// הקובץ כל פעם
																// לפי הלולאה
					BufferedReader br = new BufferedReader(fr);
					String line; // משמש אותנו לקרוא שוורות
					line = br.readLine(); // דילוג שורה 1
					line = br.readLine();// דילוג שורה 2
					line = br.readLine();// כרגע אני בשורה 3
					while (line != null) {// כל עוד השורה לא ריקה
						String[] values = line.split(",");// קח אותה ופצל אותה
															// לפי הפסיקים
						if (values[10].equals("WIFI")) {// פילטר על רשתות הג'סמ
							String MAC = values[0];// עמדודה 0 ל-
							String SSID = values[1];// עמודה 1 ל
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // תגדיר
																								// טיפוס
																								// חדש
																								// מסוג
																								// "סדפ"
																								// ותכניס
																								// לתוכו
																								// את
																								// הפורמט
																								// הבא
							Date time = sdf.parse(values[3]);// עמודה 3 ל
							int channel = Integer.parseInt(values[4]);
							int signal = Integer.parseInt(values[5]);
							double lat = Double.parseDouble(values[6]);
							double lon = Double.parseDouble(values[7]);
							double alt = Double.parseDouble(values[8]);
							WiFi wifi = new WiFi(time, lat, lon, alt, channel, signal, MAC, SSID);// תכניס
																									// לתוך
																									// אובייקט
																									// הוויפי
																									// את
																									// הרשימה
							WifiList.add(wifi);// הוספה למערך הדינאמי
						}
						line = br.readLine();// דלג לשורה הבאה
					}
					br.close();
				} catch (IOException | ParseException e) {// שגיאה הקובץ לא
															// מהסוג הנכון או
															// הקובץ ???*
					// TODO Auto-generated catch block

					e.printStackTrace();
				}

		}
		if (WifiList.isEmpty()) {// הרשימה ריקה כי לא היה כלום בתיקיה
			System.out.println("The files don't contain WiFi's");
			return null;
		}

		return WifiList;// תחזיר את אובייקט המערך הדינאמי
	}

	// מכין קובץ אחד גדול
	public static String printUnionCSV(String path, ArrayList<WiFi> wifilist) {

		// הכתובת הולכת להיות הקובץ החדש
		String path1 = "C:\\Users\\gilad22\\Desktop\\UnionFile.csv";
		path = path1;
		PrintWriter pw = null; // טיפוס מסוג פרינט ווריטר
		try {
			// creating print writer for new file. (like FileReader, can't do
			// much)
			pw = new PrintWriter(new File(path)); // הטיפוס (אובייקט) מקבל כתובת
		} catch (FileNotFoundException e) { // כתובת לא נכונה ????*

			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder(); // Like BufferedReader, in
														// charge to build the
														// "text"
		builder.append("Time,Lat,Alt,Lon,Signal,Frequncy,SSID,MAC\n"); // Creating
																		// the
																		// headers.
																		// חשוב
																		// שיתאים
																		// לשפיכה
																		// של
																		// האובייקט?
		for (WiFi wifi : wifilist) {// פור מקוצר רץ על כל האובייקט
			builder.append(wifi.toStringUnionFile() + "\n"); // שופך את
																// האובייקטים
																// לתוך סטרינג
																// בילדר ורד
																// שורה
		}
		pw.write(builder.toString()); // כותב את תוכן סטרינג בילדר בקובץ שמוחזק
										// על ידי פי דאבליו
		pw.close();

		return path;
	}

	// the function sort and filter the xxxx.cvs file by the "matala 0
	// requirement
	// the function get path of union xxx.csv file and return sort&filter
	public static ArrayList<WiFiList> FilterAndMakeList(ArrayList<WiFi> list, Filter filter) {// מקבלים
																								// מערך
																								// דינאמי
																								// של
																								// וויפי
																							// ומכינים
																								// רשימה
																								// מפולטרת
		ArrayList<WiFiList> unionWiFiList = new ArrayList<WiFiList>();// יצירת
																		// מערך
																		// של
																		// וויפיליסט
		WiFiList wifilist = new WiFiList();// יצירת טיפוס מסוג וויפי ליסט
		for (WiFi wiFi : list) {// הפיכת כל הוויפים לוויפי ליסט לפי קבוצות של 10
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
		Path = "C:\\Users\\gilad22\\Desktop\\UnionFile2.csv";
		try {
			pw = new PrintWriter(Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		builder.append("Time,ID,Lat,Alt,Lon,#WiFi Networks" + ",Signal1,Frequncy1,SSID1,MAC1"
				+ ",Signal2,Frequncy2,SSID2,MAC2" + ",Signal3,Frequncy3,SSID3,MAC3" + ",Signal4,Frequncy4,SSID4,MAC4"
				+ ",Signal5,Frequncy5,SSID2,MAC5" + ",Signal6,Frequncy6,SSID6,MAC6" + ",Signal7,Frequncy7,SSID7,MAC7"
				+ ",Signal8,Frequncy8,SSID8,MAC8" + ",Signal9,Frequncy9,SSID9,MAC9"
				+ ",Signal10,Frequncy10,SSID10,MAC10\n");
		for (WiFiList wiFiList : list) {
			builder.append(wiFiList.Make10toString() + "\n");
		}
		pw.write(builder.toString()); // כותב את תוכן סטרינג בילדר בקובץ שמוחזק
		
							// על ידי פי דאבליו
		pw.close();
	}

	public static void main(String[] args) {
	
		String directory = "C:\\Users\\gilad22\\Desktop\\New folder";
		ArrayList<WiFi> wifilist = uniteWiFisFromFiles(ReadDirectory(directory));
		WiFi al = null;
	    for (WiFi wiFi : wifilist) {
		al = wiFi;
			//System.out.println(wiFi.toStringUnionFile());
		}
	
		printUnionCSV("C:\\Users\\gilad22\\Desktop\\UnionFile.csv", wifilist);
		Filter choice = null;
	//	choice.isBelong(al);
		choice = new FilterTime("2017-11-22 20:24:47", "2017-11-22 20:27:47");
		printBestListsAfterFilter("C:\\Users\\gilad22\\Desktop\\UnionFile2.csv", FilterAndMakeList(wifilist, null));
		
		blabla=FilterAndMakeList(wifilist, null);
		System.out.println(blabla.get(25).getList().get(1).getMAC());
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
