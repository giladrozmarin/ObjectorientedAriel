import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterTime implements Filter {
	Date start, end;

	public FilterTime(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(start.getTime());
	}

	public FilterTime(String start, String end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.start = sdf.parse(start);
			this.end = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean isBelong(WiFi wifi) {
		Date time = wifi.getTime();
		if ((start.before(time) && end.after(time)) || (start.equals(time) || end.equals(time)))
			return true;
		return false;
	}

}
