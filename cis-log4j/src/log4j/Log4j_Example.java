package log4j;
import org.apache.log4j.Logger;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
public class Log4j_Example {

	
		static Logger log = Logger.getLogger("SimpleLogs");
		public static void main(String[] args)
		throws IOException,SQLException{
		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");
		log.debug("Hello this is a debug message");
	}

}
