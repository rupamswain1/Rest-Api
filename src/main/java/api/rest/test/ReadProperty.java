package api.rest.test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty 
{
	static Properties prop=null;
	
	public static String read(String data)
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//url.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop.getProperty(data);
	}
}
