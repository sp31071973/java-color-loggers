import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColorLogXmlTest {

	public static String getTargetDir() {
		URL url = ColorLogXmlTest.class.getResource("/");
		if (null == url)
			return ".";

		try {
			return url.toURI().getPath();
		} catch (URISyntaxException e) {
		}

		return ".";
	}

	@Test
	public void testColorLogging() {
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log-log4j");

		DOMConfigurator.configure(getTargetDir() + "log4j.xml");

		System.out.println("===================================================");
		System.out.println("===== Color logger - log4j - XML configuration ====");
		System.out.println("===================================================");

		logger.fatal("fatal with XML");
		logger.error("error with XML");
		logger.warn("warn with XML");
		logger.info("info with XML");
		logger.debug("debug with XML");
		logger.trace("trace with XML");
	}

	public static void main(String[] argv) {
		JUnitCore.runClasses(new Class[] { ColorLogXmlTest.class });
	}
}
