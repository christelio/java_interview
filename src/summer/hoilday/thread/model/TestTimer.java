package summer.hoilday.thread.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	private ArrayList<String> userBox = new ArrayList<>();

	{
		userBox.add("Å·Ñô°×Ñæ");
	}
	
	public void test() throws InterruptedException {
		Timer timer = new Timer();
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date firsttime = null;
		try {
			firsttime = adf.parse("2019-07-13 13:52:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer.schedule(new TimerTask()

		{
			public void run() {
				for (int i = 0; i < userBox.size(); i++) {
					System.out.println("+VX1594846");
				}
			}
		}, firsttime, (long)3000);
	}

}
