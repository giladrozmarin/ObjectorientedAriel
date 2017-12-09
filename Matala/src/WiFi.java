import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.text.Format;


public class WiFi implements Comparable<WiFi> {
	private Date time;
	private double lat,lon,alt;
	private int frequency,signal;
	private String MAC,SSID;
	public WiFi(Date time, double lat, double lon, double alt, int channel, int signal, String MAC, String SSID){
		this.time = new Date(time.getTime());
		this.lat = lat;
		this.alt = alt;
		this.lon = lon;
		this.signal = signal;
		this.frequency = channel;
		this.MAC = new String(MAC);
		this.SSID = new String(SSID);
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getSignal() {
		return signal;
	}
	public void setSignal(int signal) {
		this.signal = signal;
	}
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public String getSSID() {
		return SSID;
	}
	public void setSSID(String sSID) {
		SSID = sSID;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public Date getTime() {
		return time;
	}
	
	public double getLat() {
		return lat;
	}
	public double getLon() {
		return lon;
	}
	public double getAlt() {
		return alt;
	}
	public String toStringUnionFile(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		String ans = sdf.format(time) + "," + lat +"," + alt +"," + lon + "," + signal +","+frequency + "," + MAC + "," +SSID;
		return ans;
	}
	public String toString(){//Tempt
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		String ans =  SSID +"," + MAC +"," + frequency + "," + signal ;
		return ans;
	
	}
		
	@Override
	public int compareTo(WiFi other) {
		if (this.signal > other.signal)
			return -1;
		else if (this.signal < other.signal)
			return 1;
		return 0;
	}
}
