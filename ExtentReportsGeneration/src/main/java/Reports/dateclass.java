package Reports;

import java.io.File;
import java.util.Date;

public class dateclass {

	public static void main(String[] args) {
	System.out.println(System.getProperty("user.dir"));
		Date d = new Date();
		System.out.println(d.toString().replaceAll(":", "-"));
		
		String reportsfolder = d.toString().replaceAll(":", "-")+"//ScreenShots";
		String path = System.getProperty("user.dir")+"//reports//"+reportsfolder;
		File f = new File (path);
	    f.mkdirs();
		  

	} 

}
