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


public class WiFiList {
	private static int id = 0;
	private int UID;
	private Date time;
	private double lat,lon,alt;
	private boolean init;
	private ArrayList<WiFi> list;
	public WiFiList(){
		list = new ArrayList<WiFi>();
		init = false;
		UID = id++;
	}
	public WiFiList(Date time,double lat,double lon,double alt){
		this.time = new Date(time.getTime());
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		list = new ArrayList<WiFi>();
		init = true;
		UID = id++;
	}
	public WiFiList(WiFi wiFi) {
		this(wiFi.getTime(),wiFi.getLat(),wiFi.getLon(),wiFi.getAlt());
	}
	public boolean add(WiFi wifi){
		if (wifi == null)
			return false;
		if (this.equals(wifi)){
			if(init ==true){
			this.alt=wifi.getAlt();
		    this.lat=wifi.getLat();
			this.lon= wifi.getLon();
			this.time = wifi.getTime();
			}
				list.add(wifi);
				init = true;
				return true;
		}
		return false;
	}
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		WiFiList.id = id;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public boolean isInit() {
		return init;
	}
	public void setInit(boolean init) {
		this.init = init;
	}
	public ArrayList<WiFi> getList() {
		return list;
	}
	public void setList(ArrayList<WiFi> list) {
		this.list = list;
	}
	
	public boolean equals(WiFi wifi){
		if (init == false)
			return init=true;
		return wifi.getAlt() == this.alt && wifi.getLat() == this.lat && wifi.getTime().equals(this.time) && wifi.getLon() == this.lon;
	}
	public void Take10Signals() {
		Collections.sort(this.list);
		ArrayList<WiFi> newarr = new ArrayList<WiFi>();
		for (int i = 0; i < this.list.size() && i < 10; i++) {
			newarr.add(this.list.get(i));
		}
		this.list = newarr;
	}
	public String Make10toString(){
		Take10Signals();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ans = sdf.format(time) + ","+ UID + "," + lat +"," + alt +"," + lon + "," + list.size() +",";
		for (int i = 0 ; i < list.size() ; i++) {
			WiFi wiFi = list.get(i);
			ans += wiFi;
			if (i < list.size() - 1)
				ans+=",";
		}
		return ans;
	}
	public int getSize(){
		return list.size();
	}
}
