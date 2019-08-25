package cim.itsaky.jsoupexample;

import android.os.AsyncTask;
import java.io.IOException;
import org.jsoup.Jsoup;

public class GetVersionName extends AsyncTask<String, String, String>
{
	String newVersion = null;

	@Override
	protected String doInBackground(String... p1)
	{
		try {
			newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + p1[0] + "&hl=en")
                .timeout(30000)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("http://www.google.com")
                .get()
                .select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                .first()
                .ownText();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newVersion;
	}

}
