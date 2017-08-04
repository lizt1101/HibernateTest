package SHTestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class dateTime {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
		String dstr="2017-06-02 10:35:13";  
		Date date=sdf.parse(dstr);  
		System.out.println(date.getTime());

	}

}
