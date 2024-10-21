/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heartbeat;

import pacemaker.PacemakerController;

/**
 *
 * @author Hector Espinoza
 */
public class FaultMonitor {
 
    public static void notify(String errorMessage) {
		switch (errorMessage) {
		case "Heartbeat sender is dead":
			System.err.println("Fault monitor: Heartbeat sender dead status received. Initiating recovery mode...");
			PacemakerController.initiateRecovery();
			PacemakerController.updateGUI();
			break;
		}
	}
    
}
