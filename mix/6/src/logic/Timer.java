package logic;

import gui.TimerGUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.Main;

public class Timer {

	public static final int SLEEP_TIME = 1000;
	public static final int COUNT_UP = 1;
	public static final int COUNT_DOWN = -1;

	// implement your code here
	private TimerGUI timerGUI;
	private int minute = 0;
	private int hour = 0;
	private int second = 0;
	private int countMode;
	private boolean isCounting = false;
	private Thread thread;

	public Timer(String name, int countMode) {

		timerGUI = new TimerGUI(name);
		this.countMode = countMode;
		minute = 0;
		hour = 0;
		if (countMode == 1)
			second = 0;
		else
			second = 30;
		setEventHandling();
		threadInitialize();
		updateGUI();

	}

	private void threadInitialize() {

		thread = new Thread(() -> {
			while (isCounting) {
				if (countMode == 1) {
					try {
						Main.timer.getThread().join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				try {
					updateGUI();
					updateTime();
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {

				}
				// }

			}
		});
		thread.start();

	}

	private void updateGUI() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				timerGUI.getDisplayPart().update(getTimeString());
			}
		});

	}

	private void updateTime() {

		// implement your code here
		if (countMode == -1) {
			second -= 1;
			if (second < 0) {
				second = 0;
				minute -= 1;
				if (minute < 0) {
					minute = 0;
					hour -= 1;

				}
			}
			hour = hour < 0 ? 0 : hour;

		} else if (countMode == 1) {
			second += 1;
			if (second > 60) {
				second = 1;
				minute += 1;
				if (minute > 60) {
					minute = 1;
					hour += 1;
				}
			}
		}

	}

	private String getTimeString() {
		// implement your code here
		String time = "";
		if (second < 10)
			time = time + ":0" + second;
		else
			time = time + ":" + second;
		if (minute < 10)
			time = ":0" + minute + time;
		else
			time = ":" + minute + time;
		if (hour < 10)
			time = "0" + hour + time;
		else
			time = "" + hour + time;
		return time;
	}

	private void resetHandle() {
		// System.out.println("resetclick");

		// implement your code here
		isCounting = false;
		second = 0;
		minute = 0;
		hour = 0;
		if (countMode == -1)
			second = 30;
		updateGUI();

	}

	private void startStopHandle() {
		// System.out.println("click");
		// implement your code here
		isCounting = !isCounting;
		System.out.println(Boolean.toString(isCounting));
		threadInitialize();
	}

	private void setEventHandling() {

		// implement your code here
		timerGUI.getControlPart().getStartStopButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				startStopHandle();

			}
		});
		timerGUI.getControlPart().getResetButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetHandle();
			}
		});

	}

	public TimerGUI getTimerGUI() {
		return timerGUI;
	}

	public Thread getThread() {
		return thread;
	}

	// Generate Getters

}
