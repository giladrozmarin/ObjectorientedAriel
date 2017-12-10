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
 * ׳³ג€÷׳³ֲ¨׳³ג€™׳³ֲ¢ : ׳³ג‚×׳³ג€¢׳³ֲ ׳³ֲ§׳³ֲ¦׳³ג„¢׳³ג€� ׳³ֲ©׳³ן¿½׳³ג€¢׳³ֲ§׳³ג€”׳³ֳ— ׳³ן¿½׳³ג€÷׳³ן¿½ ׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ֲ©׳³ג€˜׳³ג‚×׳³ג€¢׳³ֲ¨׳³ן¿½׳³ֻ� ׳³ֲ ׳³ֳ—׳³ג€¢׳³ֲ ׳³ג„¢׳³ן¿½ ׳³ן¿½׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ� ׳³ג€�׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢׳³ג„¢ ׳³ג€�׳³ג„¢׳³ן¿½ ׳³ֲ ׳³ֲ¢׳³ג€“׳³ֲ¨׳³ֳ— ׳³ג€˜׳³ג‚×׳³ג€¢׳³ֲ ׳³ֲ§׳³ֲ¦׳³ג„¢׳³ג€� ׳³ֲ©׳³ן¿½׳³ֲ©׳³ג„¢׳³ג€™׳³ג€� ׳³ן¿½׳³ג€� ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ— ׳³ג€÷׳³ג€�׳³ג„¢ ׳³ן¿½׳³ֲ¢׳³ֲ©׳³ג€¢׳³ֳ— ׳³ן¿½׳³ֳ— ׳³ג€“׳³ג€� 
 * ׳³ן¿½׳³ג€� ׳³ן¿½׳³ֲ ׳³ג„¢ ׳³ג€�׳³ג€¢׳³ן¿½׳³ן¿½ ׳³ן¿½׳³ֲ¢׳³ֲ©׳³ג€¢׳³ֳ— : ׳³ן¿½׳³ֲ§׳³ג€”׳³ֳ— ׳³ן¿½׳³ֳ— ׳³ג€÷׳³ן¿½ ׳³ג€�׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½ ׳³ג€�׳³ג€�׳³ג„¢׳³ֲ ׳³ן¿½׳³ן¿½׳³ג„¢ ׳³ֲ©׳³ן¿½׳³ג„¢ ׳³ֲ©׳³ן¿½׳³ג€÷׳³ג„¢׳³ן¿½ ׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ�׳³ג„¢׳³ן¿½ ׳³ֲ©׳³ן¿½ ׳³ג€¢׳³ג€¢׳³ג„¢ ׳³ג‚×׳³ג„¢ ׳³ג€¢׳³ג€˜׳³ֲ¢׳³ג€“׳³ֲ¨׳³ֳ—׳³ג€¢ ׳³ן¿½׳³ֲ ׳³ג„¢ ׳³ג€�׳³ג€¢׳³ן¿½׳³ן¿½ ׳³ן¿½׳³ֲ©׳³ג‚×׳³ג€¢׳³ן¿½ ׳³ג€�׳³ג€÷׳³ן¿½ ׳³ן¿½׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ן¿½׳³ג€”׳³ג€� ׳³ֲ©׳³ן¿½׳³ג€¢׳³ֳ—׳³ג€¢ ׳³ן¿½׳³ֲ ׳³ג„¢ ׳³ן¿½׳³ן¿½׳³ג„¢׳³ג„¢׳³ן¿½ ׳³ן¿½׳³ג‚×׳³ג„¢ ׳³ג€�׳³ג€�׳³ֲ¨׳³ג„¢׳³ֲ©׳³ג€¢׳³ֳ—
 *  ׳³ֲ©׳³ן¿½׳³ג€˜ ׳³ֲ©׳³ֲ ׳³ג„¢ : ׳³ן¿½׳³ֲ ׳³ג„¢ ׳³ג€�׳³ג€¢׳³ן¿½׳³ן¿½ ׳³ן¿½׳³ג€�׳³ג‚×׳³ג€¢׳³ן¿½ ׳³ן¿½׳³ֳ— ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ג€�׳³ג€“׳³ג€� ׳³ן¿½׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ֲ§׳³ג„¢׳³ג„¢ ׳³ן¿½׳³ן¿½ ׳³ן¿½׳³ן¿½ 
 *  
 * ׳³ֲ©׳³ן¿½׳³ן¿½׳³ג€¢׳³ֳ— ׳³ן¿½׳³ֲ¨׳³ג„¢׳³ג€÷׳³ג€¢׳³ג€“ 
 * ׳³ן¿½׳³ֲ§׳³ֲ¡׳³ג‚×׳³ֲ©׳³ג„¢׳³ן¿½, ׳³ן¿½׳³ג€� ׳³ג€�׳³ן¿½׳³ֲ©׳³ֲ¢׳³ן¿½׳³ג€¢׳³ֳ— ׳³ֲ©׳³ן¿½ ׳³ֲ¡׳³ֻ�׳³ֻ�׳³ג„¢׳³ֲ§ ׳³ג€˜׳³ג‚×׳³ג€¢׳³ֲ ׳³ֲ§׳³ֲ¦׳³ג„¢׳³ג€� ,׳³ג€�׳³ג€¢׳³ג€™׳³ן¿½׳³ן¿½ ׳³ן¿½׳³ג€™'׳³ן¿½׳³ג€¢׳³ג€¢׳³ג€� ׳³ג€�׳³ג€¢׳³ֲ§ ׳³ֲ ׳³ג€÷׳³ג€¢׳³ן¿½ ,׳³ן¿½׳³ֳ—׳³ֲ¨ ׳³ֲ ׳³ג€”׳³ן¿½׳³ג€� ׳³ן¿½׳³ן¿½׳³ג„¢׳³ן¿½׳³ג‚×׳³ג€¢׳³ֲ¨׳³ֻ�׳³ג„¢׳³ן¿½ 
 * 
 * 
 *  ׳³ג€�׳³ֲ©׳³ן¿½׳³ן¿½׳³ג€� ׳³ן¿½׳³ן¿½ ׳³ן¿½׳³ֲ§׳³ג€”׳³ֳ— ׳³ן¿½׳³ג€� ׳³ֲ©׳³ן¿½׳³ֲ ׳³ג„¢ ׳³ֲ¨׳³ג€¢׳³ֲ¦׳³ג€� ׳³ן¿½׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ן¿½׳³ג€¢ ׳³ן¿½׳³ן¿½׳³ג€”׳³ג€¢׳³ֲ§ ׳³ג€˜׳³ג€¢ ׳³ג€�׳³ג€˜׳³ֲ¨׳³ג„¢׳³ן¿½ ׳³ג€�׳³ן¿½׳³ן¿½ ׳³ג€˜׳³ג€÷׳³ן¿½׳³ן¿½ ׳³ן¿½׳³ג‚×׳³ֲ©׳³ֲ¨ ׳³ן¿½׳³ן¿½׳³ג€”׳³ג€¢׳³ֲ§ ׳³ג€�׳³ג€˜׳³ֲ¨׳³ג„¢׳³ן¿½ ׳³ן¿½׳³ג„¢׳³ן¿½ ׳³ן¿½׳³ג€�׳³ג€¢׳³ֲ¡׳³ג„¢׳³ֲ£ ׳³ן¿½׳³ֳ— ׳³ג€�׳³ן¿½׳³ג„¢׳³ג„¢׳³ג€�׳³ג„¢׳³ג„¢
 */

public class file2csv {
	 static ArrayList<WiFiList> blabla = new ArrayList();
	// this function get directoryPath and return the cvsFile in the Folder
	public static ArrayList<String> ReadDirectory(String directoryPath) {// ׳³ג€�׳³ג‚×׳³ג€¢׳³ֲ ׳³ֲ§׳³ֲ¦׳³ג„¢׳³ג€�
																			// ׳³ֳ—׳³ג€”׳³ג€“׳³ג„¢׳³ֲ¨
																			// ׳³ֲ¨׳³ֲ©׳³ג„¢׳³ן¿½׳³ג€�
																			// ׳³ֲ©׳³ן¿½
																			// ׳³ֲ§׳³ג€˜׳³ֲ¦׳³ג„¢
																			// ׳³ֲ¡׳³ג„¢׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג„¢
																			// ׳³ג€¢׳³ֳ—׳³ֲ§׳³ג€˜׳³ן¿½
																			// ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ—
		File directory = new File(directoryPath);// ׳³ג‚×׳³ג„¢׳³ג„¢׳³ן¿½ ׳³ג€“׳³ג€�׳³ג€¢ ׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ֲ§׳³ֻ� ׳³ג€˜׳³ג€™'׳³ן¿½׳³ג€¢׳³ג€¢׳³ג€�
													// ׳³ג„¢׳³ֲ¦׳³ֲ¨׳³ֲ ׳³ג€¢ ׳³ן¿½׳³ֲ©׳³ֳ—׳³ֲ ׳³ג€� ׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג€™ ׳³ג€“׳³ג€� ׳³ֲ©׳³ן¿½׳³ֲ§׳³ג€˜׳³ן¿½
													// ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ—
		ArrayList
		<String> csvFiles = new ArrayList<String>();// ׳³ֲ¨׳³ֲ©׳³ג„¢׳³ן¿½׳³ג€� ׳³ן¿½׳³ֲ§׳³ג€¢׳³ֲ©׳³ֲ¨׳³ֳ— ׳³ֲ©׳³ן¿½
																// ׳³ֲ¡׳³ג„¢׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג„¢ ׳³ֲ©׳³ֳ—׳³ֲ§׳³ג€˜׳³ן¿½
																// ׳³ן¿½׳³ֳ—׳³ג€¢׳³ג€÷׳³ג€� ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ג€¢׳³ֳ—
																// ׳³ג€÷׳³ֲ¡׳³ֻ�׳³ֲ¨׳³ג„¢׳³ֲ ׳³ג€™ ׳³ֲ©׳³ן¿½
																// ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ג€¢׳³ֳ— ׳³ֲ©׳³ן¿½
																// ׳³ֳ—׳³ֲ§׳³ג„¢׳³ג€¢׳³ֳ—
		if (!directory.isDirectory()) {// ׳³ן¿½׳³ן¿½ ׳³ג€�׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ— ׳³ג€�׳³ג„¢׳³ן¿½ ׳³ן¿½׳³ן¿½ ׳³ֳ—׳³ֲ§׳³ג„¢׳³ג„¢׳³ג€� ׳³ג€“׳³ֲ¨׳³ג€¢׳³ֲ§ ׳³ן¿½׳³ן¿½ ׳³ג€�׳³ן¿½׳³ג€¢׳³ג€™
			System.out.println("directory is not exist");// ׳³ג€�׳³ג€�׳³ג‚×׳³ֲ¡׳³ג€�
			return null;// ׳³ג€�׳³ג€”׳³ג€“׳³ֲ¨׳³ג€� ׳³ג€÷׳³ן¿½׳³ג€¢׳³ן¿½
		}
		File[] fileNames = directory.listFiles();// ׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½ ׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג€™ ׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ� "׳³ג‚×׳³ג„¢׳³ג„¢׳³ן¿½"
													// ׳³ן¿½׳³ֲ§׳³ג€˜׳³ן¿½ ׳³ֲ¨׳³ֲ©׳³ג„¢׳³ן¿½׳³ג€� ׳³ֲ©׳³ן¿½ ׳³ג€�׳³ֲ§׳³ג€˜׳³ֲ¦׳³ג„¢׳³ן¿½
		if (fileNames.length == 0)// ׳³ג€˜׳³ג€�׳³ג€¢׳³ֲ§ ׳³ֲ©׳³ג€�׳³ֳ—׳³ֲ§׳³ג„¢׳³ג„¢׳³ג€� ׳³ן¿½׳³ן¿½ ׳³ֲ¨׳³ג„¢׳³ֲ§׳³ג€�
		{
			System.out.println("directory is empty");// ׳³ג€˜׳³ג€¢׳³ג€�׳³ֲ§ ׳³ֲ©׳³ג€�׳³ֳ—׳³ג„¢׳³ֲ§׳³ג€� ׳³ן¿½׳³ן¿½ ׳³ֲ¨׳³ג„¢׳³ֲ§׳³ג€�
			return null;
		}
		for (File file : fileNames) {// ׳³ֲ¦׳³ג€¢׳³ֲ¨׳³ֳ— ׳³ג€÷׳³ֳ—׳³ג„¢׳³ג€˜׳³ג€� ׳³ֲ©׳³ן¿½ ׳³ג‚×׳³ג€¢׳³ֲ¨ ׳³ן¿½׳³ֲ§׳³ג€¢׳³ֲ¦׳³ֲ¨ ׳³ג„¢׳³ג€¢׳³ֲ¦׳³ֲ¨ ׳³ג‚×׳³ג„¢׳³ג„¢׳³ן¿½=0 ׳³ג€÷׳³ן¿½׳³ג€¢
										// ׳³ן¿½׳³ג„¢׳³ג„¢ ׳³ג€˜׳³ג‚×׳³ג€¢׳³ֲ¨ ׳³ֲ¨׳³ג€™׳³ג„¢׳³ן¿½ ׳³ג€¢׳³ג€“׳³ג€� ׳³ֲ¨׳³ֲ¥ ׳³ֲ¢׳³ג€� ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ג€�׳³ן¿½׳³ג€”׳³ֲ¨׳³ג€¢׳³ן¿½
			if (!file.isDirectory() && file.getAbsolutePath().endsWith(".csv")) {// ׳³ן¿½׳³ן¿½
																					// ׳³ג€“׳³ג€�
																					// ׳³ן¿½׳³ן¿½
																					// ׳³ֳ—׳³ֲ§׳³ג„¢׳³ג„¢׳³ג€�
																					// ׳³ג€¢׳³ג€™׳³ן¿½
																					// ׳³ג€¢׳³ג€™׳³ן¿½
																					// ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥
																					// ׳³ֲ ׳³ג€™׳³ן¿½׳³ֲ¨
																					// ׳³ג€˜׳³ֲ¡׳³ג„¢׳³ג€¢׳³ן¿½׳³ֳ—
																					// ׳³ג€�׳³ֲ ׳³ג€÷׳³ג€¢׳³ֲ ׳³ג€�
				csvFiles.add(file.getAbsolutePath());// ׳³ֳ—׳³ג€¢׳³ֲ¡׳³ג„¢׳³ֲ£ ׳³ן¿½׳³ֳ— ׳³ג€�׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ— ׳³ֲ©׳³ן¿½ ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥
														// ׳³ן¿½׳³ֳ—׳³ג€¢׳³ן¿½ ׳³ג€�׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½
			} else if (file.isDirectory()) {// ׳³ן¿½׳³ן¿½ ׳³ג€“׳³ג€� ׳³ֳ—׳³ֲ§׳³ג„¢׳³ג„¢׳³ג€�
				csvFiles.addAll(ReadDirectory(file.getAbsolutePath()));// ׳³ֳ—׳³ג€˜׳³ֲ¦׳³ֲ¢
																		// ׳³ן¿½׳³ֳ—
																		// ׳³ג€�׳³ג‚×׳³ג€¢׳³ֲ ׳³ֲ§׳³ֲ¦׳³ג„¢׳³ג€�
																		// ׳³ֲ¢׳³ן¿½
																		// ׳³ג€�׳³ֳ—׳³ֲ§׳³ג„¢׳³ג„¢׳³ג€�
			}
		}
		return csvFiles;// ׳³ג€�׳³ג€”׳³ג€“׳³ֲ¨ ׳³ן¿½׳³ֳ— ׳³ג€�׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½
	}

	// the function get file path and return object wifi list
	private static ArrayList<WiFi> uniteWiFisFromFiles(ArrayList<String> fileNames) {// ׳³ג€˜׳³ן¿½׳³ֲ§׳³ֲ¨׳³ג€�
																						// ׳³ֲ©׳³ן¿½׳³ֲ ׳³ג€¢
																						// ׳³ן¿½׳³ֲ§׳³ג€˜׳³ן¿½
																						// ׳³ן¿½׳³ֳ—
																						// ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥
																						// ׳³ֲ©׳³ג€�׳³ג‚×׳³ג€¢׳³ֲ ׳³ֲ§׳³ֲ¦׳³ג„¢׳³ג€�
																						// ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€�׳³ן¿½׳³ֳ—
																						// ׳³ג€�׳³ג€”׳³ג€“׳³ג„¢׳³ֲ¨׳³ג€�
		ArrayList<WiFi> WifiList = new ArrayList<WiFi>();// ׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½ ׳³ג€�׳³ג„¢׳³ֲ ׳³ן¿½׳³ן¿½׳³ג„¢ ׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג€™
															// ׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ� ׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢
		for (String fileName : fileNames) {// ׳³ג‚×׳³ג€¢׳³ֲ¨ ׳³ן¿½׳³ֲ§׳³ג€¢׳³ֲ¦׳³ֲ¨ ׳³ֲ¨׳³ֲ¥ ׳³ֲ¢׳³ן¿½ ׳³ג€÷׳³ן¿½ ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ— ׳³ג€�׳³ֲ§׳³ג€˜׳³ֲ¦׳³ג„¢׳³ן¿½
											// ׳³ֲ©׳³ן¿½׳³ֲ¦׳³ן¿½׳³ֲ ׳³ג€¢
			if (fileName.contains("WigleWifi"))
				try {
					FileReader fr = new FileReader(fileName);// ׳³ן¿½׳³ֲ©׳³ֳ—׳³ֲ ׳³ג€� ׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג€™ "׳³ֲ§׳³ג€¢׳³ֲ¨׳³ן¿½
																// ׳³ֲ§׳³ג€˜׳³ֲ¦׳³ג„¢׳³ן¿½" ׳³ג€¢׳³ן¿½׳³ג€÷׳³ֲ ׳³ג„¢׳³ֲ¡
																// ׳³ן¿½׳³ֳ—׳³ג€¢׳³ג€÷׳³ג€¢ ׳³ן¿½׳³ֳ—
																// ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ג€÷׳³ן¿½ ׳³ג‚×׳³ֲ¢׳³ן¿½
																// ׳³ן¿½׳³ג‚×׳³ג„¢ ׳³ג€�׳³ן¿½׳³ג€¢׳³ן¿½׳³ן¿½׳³ג€�
					BufferedReader br = new BufferedReader(fr);
					String line; // ׳³ן¿½׳³ֲ©׳³ן¿½׳³ֲ© ׳³ן¿½׳³ג€¢׳³ֳ—׳³ֲ ׳³ג€¢ ׳³ן¿½׳³ֲ§׳³ֲ¨׳³ג€¢׳³ן¿½ ׳³ֲ©׳³ג€¢׳³ג€¢׳³ֲ¨׳³ג€¢׳³ֳ—
					line = br.readLine(); // ׳³ג€�׳³ג„¢׳³ן¿½׳³ג€¢׳³ג€™ ׳³ֲ©׳³ג€¢׳³ֲ¨׳³ג€� 1
					line = br.readLine();// ׳³ג€�׳³ג„¢׳³ן¿½׳³ג€¢׳³ג€™ ׳³ֲ©׳³ג€¢׳³ֲ¨׳³ג€� 2
					line = br.readLine();// ׳³ג€÷׳³ֲ¨׳³ג€™׳³ֲ¢ ׳³ן¿½׳³ֲ ׳³ג„¢ ׳³ג€˜׳³ֲ©׳³ג€¢׳³ֲ¨׳³ג€� 3
					while (line != null) {// ׳³ג€÷׳³ן¿½ ׳³ֲ¢׳³ג€¢׳³ג€� ׳³ג€�׳³ֲ©׳³ג€¢׳³ֲ¨׳³ג€� ׳³ן¿½׳³ן¿½ ׳³ֲ¨׳³ג„¢׳³ֲ§׳³ג€�
						String[] values = line.split(",");// ׳³ֲ§׳³ג€” ׳³ן¿½׳³ג€¢׳³ֳ—׳³ג€� ׳³ג€¢׳³ג‚×׳³ֲ¦׳³ן¿½ ׳³ן¿½׳³ג€¢׳³ֳ—׳³ג€�
															// ׳³ן¿½׳³ג‚×׳³ג„¢ ׳³ג€�׳³ג‚×׳³ֲ¡׳³ג„¢׳³ֲ§׳³ג„¢׳³ן¿½
						if (values[10].equals("WIFI")) {// ׳³ג‚×׳³ג„¢׳³ן¿½׳³ֻ�׳³ֲ¨ ׳³ֲ¢׳³ן¿½ ׳³ֲ¨׳³ֲ©׳³ֳ—׳³ג€¢׳³ֳ— ׳³ג€�׳³ג€™'׳³ֲ¡׳³ן¿½
							String MAC = values[0];// ׳³ֲ¢׳³ן¿½׳³ג€�׳³ג€¢׳³ג€�׳³ג€� 0 ׳³ן¿½-
							String SSID = values[1];// ׳³ֲ¢׳³ן¿½׳³ג€¢׳³ג€�׳³ג€� 1 ׳³ן¿½
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ׳³ֳ—׳³ג€™׳³ג€�׳³ג„¢׳³ֲ¨
																								// ׳³ֻ�׳³ג„¢׳³ג‚×׳³ג€¢׳³ֲ¡
																								// ׳³ג€”׳³ג€�׳³ֲ©
																								// ׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג€™
																								// "׳³ֲ¡׳³ג€�׳³ג‚×"
																								// ׳³ג€¢׳³ֳ—׳³ג€÷׳³ֲ ׳³ג„¢׳³ֲ¡
																								// ׳³ן¿½׳³ֳ—׳³ג€¢׳³ג€÷׳³ג€¢
																								// ׳³ן¿½׳³ֳ—
																								// ׳³ג€�׳³ג‚×׳³ג€¢׳³ֲ¨׳³ן¿½׳³ֻ�
																								// ׳³ג€�׳³ג€˜׳³ן¿½
							Date time = sdf.parse(values[3]);// ׳³ֲ¢׳³ן¿½׳³ג€¢׳³ג€�׳³ג€� 3 ׳³ן¿½
							int channel = Integer.parseInt(values[4]);
							int signal = Integer.parseInt(values[5]);
							double lat = Double.parseDouble(values[6]);
							double lon = Double.parseDouble(values[7]);
							double alt = Double.parseDouble(values[8]);
							WiFi wifi = new WiFi(time, lat, lon, alt, channel, signal, MAC, SSID);// ׳³ֳ—׳³ג€÷׳³ֲ ׳³ג„¢׳³ֲ¡
																									// ׳³ן¿½׳³ֳ—׳³ג€¢׳³ן¿½
																									// ׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ�
																									// ׳³ג€�׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢
																									// ׳³ן¿½׳³ֳ—
																									// ׳³ג€�׳³ֲ¨׳³ֲ©׳³ג„¢׳³ן¿½׳³ג€�
							WifiList.add(wifi);// ׳³ג€�׳³ג€¢׳³ֲ¡׳³ג‚×׳³ג€� ׳³ן¿½׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½ ׳³ג€�׳³ג€�׳³ג„¢׳³ֲ ׳³ן¿½׳³ן¿½׳³ג„¢
						}
						line = br.readLine();// ׳³ג€�׳³ן¿½׳³ג€™ ׳³ן¿½׳³ֲ©׳³ג€¢׳³ֲ¨׳³ג€� ׳³ג€�׳³ג€˜׳³ן¿½׳³ג€�
					}
					br.close();
				} catch (IOException | ParseException e) {// ׳³ֲ©׳³ג€™׳³ג„¢׳³ן¿½׳³ג€� ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ן¿½׳³ן¿½
															// ׳³ן¿½׳³ג€�׳³ֲ¡׳³ג€¢׳³ג€™ ׳³ג€�׳³ֲ ׳³ג€÷׳³ג€¢׳³ן¿½ ׳³ן¿½׳³ג€¢
															// ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ???*
					// TODO Auto-generated catch block

					e.printStackTrace();
				}

		}
		if (WifiList.isEmpty()) {// ׳³ג€�׳³ֲ¨׳³ֲ©׳³ג„¢׳³ן¿½׳³ג€� ׳³ֲ¨׳³ג„¢׳³ֲ§׳³ג€� ׳³ג€÷׳³ג„¢ ׳³ן¿½׳³ן¿½ ׳³ג€�׳³ג„¢׳³ג€� ׳³ג€÷׳³ן¿½׳³ג€¢׳³ן¿½ ׳³ג€˜׳³ֳ—׳³ג„¢׳³ֲ§׳³ג„¢׳³ג€�
			System.out.println("The files don't contain WiFi's");
			return null;
		}

		return WifiList;// ׳³ֳ—׳³ג€”׳³ג€“׳³ג„¢׳³ֲ¨ ׳³ן¿½׳³ֳ— ׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ� ׳³ג€�׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½ ׳³ג€�׳³ג€�׳³ג„¢׳³ֲ ׳³ן¿½׳³ן¿½׳³ג„¢
	}

	// ׳³ן¿½׳³ג€÷׳³ג„¢׳³ן¿½ ׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ן¿½׳³ג€”׳³ג€� ׳³ג€™׳³ג€�׳³ג€¢׳³ן¿½
	public static String printUnionCSV(String path, ArrayList<WiFi> wifilist) {

		// ׳³ג€�׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ— ׳³ג€�׳³ג€¢׳³ן¿½׳³ג€÷׳³ֳ— ׳³ן¿½׳³ג€�׳³ג„¢׳³ג€¢׳³ֳ— ׳³ג€�׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ג€�׳³ג€”׳³ג€�׳³ֲ©
		String path1 = "C:/Mivne/UnionFile.csv";
		path = path1;
		PrintWriter pw = null; // ׳³ֻ�׳³ג„¢׳³ג‚×׳³ג€¢׳³ֲ¡ ׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג€™ ׳³ג‚×׳³ֲ¨׳³ג„¢׳³ֲ ׳³ֻ� ׳³ג€¢׳³ג€¢׳³ֲ¨׳³ג„¢׳³ֻ�׳³ֲ¨
		try {
			// creating print writer for new file. (like FileReader, can't do
			// much)
			pw = new PrintWriter(new File(path)); // ׳³ג€�׳³ֻ�׳³ג„¢׳³ג‚×׳³ג€¢׳³ֲ¡ (׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ�) ׳³ן¿½׳³ֲ§׳³ג€˜׳³ן¿½ ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ—
		} catch (FileNotFoundException e) { // ׳³ג€÷׳³ֳ—׳³ג€¢׳³ג€˜׳³ֳ— ׳³ן¿½׳³ן¿½ ׳³ֲ ׳³ג€÷׳³ג€¢׳³ֲ ׳³ג€� ????*

			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder(); // Like BufferedReader, in
														// charge to build the
														// "text"
		builder.append("Time,Lat,Alt,Lon,Signal,Frequncy,SSID,MAC\n"); // Creating
																		// the
																		// headers.
																		// ׳³ג€”׳³ֲ©׳³ג€¢׳³ג€˜
																		// ׳³ֲ©׳³ג„¢׳³ֳ—׳³ן¿½׳³ג„¢׳³ן¿½
																		// ׳³ן¿½׳³ֲ©׳³ג‚×׳³ג„¢׳³ג€÷׳³ג€�
																		// ׳³ֲ©׳³ן¿½
																		// ׳³ג€�׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ�?
		for (WiFi wifi : wifilist) {// ׳³ג‚×׳³ג€¢׳³ֲ¨ ׳³ן¿½׳³ֲ§׳³ג€¢׳³ֲ¦׳³ֲ¨ ׳³ֲ¨׳³ֲ¥ ׳³ֲ¢׳³ן¿½ ׳³ג€÷׳³ן¿½ ׳³ג€�׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ�
			builder.append(wifi.toStringUnionFile() + "\n"); // ׳³ֲ©׳³ג€¢׳³ג‚×׳³ן¿½ ׳³ן¿½׳³ֳ—
																// ׳³ג€�׳³ן¿½׳³ג€¢׳³ג€˜׳³ג„¢׳³ג„¢׳³ֲ§׳³ֻ�׳³ג„¢׳³ן¿½
																// ׳³ן¿½׳³ֳ—׳³ג€¢׳³ן¿½ ׳³ֲ¡׳³ֻ�׳³ֲ¨׳³ג„¢׳³ֲ ׳³ג€™
																// ׳³ג€˜׳³ג„¢׳³ן¿½׳³ג€�׳³ֲ¨ ׳³ג€¢׳³ֲ¨׳³ג€�
																// ׳³ֲ©׳³ג€¢׳³ֲ¨׳³ג€�
		}
		pw.write(builder.toString()); // ׳³ג€÷׳³ג€¢׳³ֳ—׳³ג€˜ ׳³ן¿½׳³ֳ— ׳³ֳ—׳³ג€¢׳³ג€÷׳³ן¿½ ׳³ֲ¡׳³ֻ�׳³ֲ¨׳³ג„¢׳³ֲ ׳³ג€™ ׳³ג€˜׳³ג„¢׳³ן¿½׳³ג€�׳³ֲ¨ ׳³ג€˜׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ֲ©׳³ן¿½׳³ג€¢׳³ג€”׳³ג€“׳³ֲ§
										// ׳³ֲ¢׳³ן¿½ ׳³ג„¢׳³ג€�׳³ג„¢ ׳³ג‚×׳³ג„¢ ׳³ג€�׳³ן¿½׳³ג€˜׳³ן¿½׳³ג„¢׳³ג€¢
		pw.close();

		return path;
	}

	// the function sort and filter the xxxx.cvs file by the "matala 0
	// requirement
	// the function get path of union xxx.csv file and return sort&filter
	public static ArrayList<WiFiList> FilterAndMakeList(ArrayList<WiFi> list, Filter filter) {// ׳³ן¿½׳³ֲ§׳³ג€˜׳³ן¿½׳³ג„¢׳³ן¿½
																								// ׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½
																								// ׳³ג€�׳³ג„¢׳³ֲ ׳³ן¿½׳³ן¿½׳³ג„¢
																								// ׳³ֲ©׳³ן¿½
																								// ׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢
																							// ׳³ג€¢׳³ן¿½׳³ג€÷׳³ג„¢׳³ֲ ׳³ג„¢׳³ן¿½
																								// ׳³ֲ¨׳³ֲ©׳³ג„¢׳³ן¿½׳³ג€�
																								// ׳³ן¿½׳³ג‚×׳³ג€¢׳³ן¿½׳³ֻ�׳³ֲ¨׳³ֳ—
		ArrayList<WiFiList> unionWiFiList = new ArrayList<WiFiList>();// ׳³ג„¢׳³ֲ¦׳³ג„¢׳³ֲ¨׳³ֳ—
																		// ׳³ן¿½׳³ֲ¢׳³ֲ¨׳³ן¿½
																		// ׳³ֲ©׳³ן¿½
																		// ׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢׳³ן¿½׳³ג„¢׳³ֲ¡׳³ֻ�
		WiFiList wifilist = new WiFiList();// ׳³ג„¢׳³ֲ¦׳³ג„¢׳³ֲ¨׳³ֳ— ׳³ֻ�׳³ג„¢׳³ג‚×׳³ג€¢׳³ֲ¡ ׳³ן¿½׳³ֲ¡׳³ג€¢׳³ג€™ ׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢ ׳³ן¿½׳³ג„¢׳³ֲ¡׳³ֻ�
		for (WiFi wiFi : list) {// ׳³ג€�׳³ג‚×׳³ג„¢׳³ג€÷׳³ֳ— ׳³ג€÷׳³ן¿½ ׳³ג€�׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢׳³ן¿½ ׳³ן¿½׳³ג€¢׳³ג€¢׳³ג„¢׳³ג‚×׳³ג„¢ ׳³ן¿½׳³ג„¢׳³ֲ¡׳³ֻ� ׳³ן¿½׳³ג‚×׳³ג„¢ ׳³ֲ§׳³ג€˜׳³ג€¢׳³ֲ¦׳³ג€¢׳³ֳ— ׳³ֲ©׳³ן¿½ 10
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
		pw.write(builder.toString()); // ׳³ג€÷׳³ג€¢׳³ֳ—׳³ג€˜ ׳³ן¿½׳³ֳ— ׳³ֳ—׳³ג€¢׳³ג€÷׳³ן¿½ ׳³ֲ¡׳³ֻ�׳³ֲ¨׳³ג„¢׳³ֲ ׳³ג€™ ׳³ג€˜׳³ג„¢׳³ן¿½׳³ג€�׳³ֲ¨ ׳³ג€˜׳³ֲ§׳³ג€¢׳³ג€˜׳³ֲ¥ ׳³ֲ©׳³ן¿½׳³ג€¢׳³ג€”׳³ג€“׳³ֲ§
		
							// ׳³ֲ¢׳³ן¿½ ׳³ג„¢׳³ג€�׳³ג„¢ ׳³ג‚×׳³ג„¢ ׳³ג€�׳³ן¿½׳³ג€˜׳³ן¿½׳³ג„¢׳³ג€¢
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
