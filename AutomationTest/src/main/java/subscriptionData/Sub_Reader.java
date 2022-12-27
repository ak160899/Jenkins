package subscriptionData;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

public class Sub_Reader {

	Properties pro;

	public Sub_Reader() throws IOException {

		pro = new Properties();

		File f = new File(System.getProperty("user.dir") + "\\subscriptionProperty\\Subscription.properties");

		FileInputStream fs = new FileInputStream(f);

		pro.load(fs);

	}

	public String Subscribe() {

		String plandetail = pro.getProperty("plan");
		return plandetail;

	}

	public String addUser() {

		String adduser = pro.getProperty("name");
		return adduser;

	}

	public String firstname() {

		String name = pro.getProperty("Firstname");
		return name;

	}

	public String lastname() {

		String lname = pro.getProperty("Lastname");
		return lname;

	}

	public String phonenumber() {
		String phn = pro.getProperty("Phonenumber");
		return phn;

	}

	public String $lte$useremail() {
		String eml = pro.getProperty("useremail");
		return eml;
	}

	public String $lte$dremail() {

		String dcmail = pro.getProperty("dremail");
		return dcmail;

	}

	public String $bas$drmail() {
		String basdrmail = pro.getProperty("basdrmail");
		return basdrmail;

	}

	public String $bas$usmail() {
		String basusmail = pro.getProperty("basusmail");
		return basusmail;

	}

	public String $pre$drmail() {
		String predrmail = pro.getProperty("predrmail");
		return predrmail;
	}

	public String $pre$usmail() {
		String preusmail = pro.getProperty("preusmail");
		return preusmail;
	}

	public String $prepls$drmail() {

		String preplsdrmail = pro.getProperty("preplsdrmail");
		return preplsdrmail;

	}

	public String $prepls$usmail() {
		String preplsusmail = pro.getProperty("preplsusmail");
		return preplsusmail;
	}

	public String $trialUserEmail() {

		String usermail = pro.getProperty("trUsermail");
		return usermail;

	}

	public String $trialDrEmail() {

		String drEmail = pro.getProperty("trDremail");
		return drEmail;
	}

}
