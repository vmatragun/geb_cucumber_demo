/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.UnexpectedAlertBehaviour
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.os.ExecutableFinder
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.slf4j.LoggerFactory
import spock.lang.Specification

import java.sql.Driver

import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS


File findDriverExecutable() {
  def defaultExecutable = new ExecutableFinder().find("chromedriver")
  if (defaultExecutable) {
    new File(defaultExecutable)
  } else {
    new File("drivers").listFiles().findAll {
      !it.name.endsWith(".version")
    }.find {
      if (IS_OS_LINUX) {
        it.name.contains("linux")
      } else if (IS_OS_MAC) {
        it.name.contains("mac")
      } else if (IS_OS_WINDOWS) {
        it.name.contains("windows")
      }
    }
  }
}


driver = { new HtmlUnitDriver() }

environments {
  chrome:
  {
    ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder()
            .usingAnyFreePort()
            .usingDriverExecutable(findDriverExecutable())
    driver = {
      new ChromeDriver(serviceBuilder.build())
    }
  }
}

baseUrl = "http://gebish.org"
