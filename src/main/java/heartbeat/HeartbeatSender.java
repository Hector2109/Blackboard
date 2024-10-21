/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heartbeat;

/**
 *
 * @author Hector Espinoza
 */
public class HeartbeatSender implements Runnable {
	private int sendingInterval;

	public HeartbeatSender(int sendingInterval) {
		this.sendingInterval = sendingInterval;
	}
	
	public void sendHeartBeat(){
		long currentTime = System.currentTimeMillis();
		HeartbeatReciever.updateTime(currentTime);
	}

	@Override
	public void run() {
		// Send a heartbeat signal to heartbeat receiver at the sending interval
		while (true) {
			try {
				sendHeartBeat();
				Thread.sleep(sendingInterval);
			} catch (InterruptedException e) {
				System.err.println("Heartbeat sender appears to have crashed.");
				break;
			}
		} // End While
	}
}
