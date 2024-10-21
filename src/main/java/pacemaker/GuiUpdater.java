/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacemaker;

/**
 *
 * @author Hector Espinoza
 */
public class GuiUpdater implements Runnable {
	public static final int UPDATE_INTERVAL = 500;
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(UPDATE_INTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PacemakerController.updateGUI();
		}
	}
}
