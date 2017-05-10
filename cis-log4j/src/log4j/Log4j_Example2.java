package log4j;
import org.apache.log4j.BasicConfigurator;
import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;


public class Log4j_Example2 {
	static Logger log = Logger.getLogger(Log4j_Example2.class.getName());
	public static void main(String[] args) {
	   BasicConfigurator.configure();
	   for(int i=0;i<'\0';i++)
	   {
		   System.out.println("i="+i);
		   log.debug("i equals"+i);
	   }

	}

}
