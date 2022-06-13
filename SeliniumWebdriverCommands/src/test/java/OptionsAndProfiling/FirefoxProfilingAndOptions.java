package OptionsAndProfiling;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxProfilingAndOptions {

	// set binary profile
	// notifications
	// maximize the browser
	// certificate errors
	// work with proxy
	@Test
	public void Firefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		FirefoxOptions options = new FirefoxOptions();
		// to get all profiles
		ProfilesIni allprof = new ProfilesIni();
		// to get a particular profile
		FirefoxProfile prof = allprof.getProfile("june2020");
		// manage notifications
		prof.setPreference("dom.webnotifications.enabled", false);// to disable the notifications in firefox
		// to manage ssl
		prof.setAcceptUntrustedCertificates(true);
		prof.setAssumeUntrustedCertificateIssuer(false);
		//
		prof.setPreference("network.proxy.type", 1);
		prof.setPreference("network.proxy.socks", "83.778.81.11");
		prof.setPreference("network.proxy.scoks_port", 1827);

		options.setProfile(prof);
		FirefoxDriver fd = new FirefoxDriver(options);

	}
}
