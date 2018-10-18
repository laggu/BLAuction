package test;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {
		Long timestamp = System.currentTimeMillis();
		String due_date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분").format(new Date(1539930480000L));
		System.out.println("due_date : " + due_date);
		
//		String date = "2018-10-19";
//		String time = " 15:28";
//		
//		SimpleDateFormat form = new SimpleDateFormat(
//                "yyyy-MM-dd hh:mm");
//		
//		Date newdate = form.parse(date+time);
//		
//		System.out.println(newdate.getTime());
		
		
	}

}
