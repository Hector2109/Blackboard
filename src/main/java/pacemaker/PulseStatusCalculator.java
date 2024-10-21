/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacemaker;

import blackboard.Blackboard;
import blackboard.KnowledgeSource;
import java.util.ArrayList;

/**
 *
 * @author Hector Espinoza
 */
public class PulseStatusCalculator implements KnowledgeSource{


	@Override
	public void updateBlackboard() {
		// Return unknown if there are not enough datapoints to calculate the
		// heart's pulse status
		ArrayList<Long> timeStamps = Blackboard.getTimeStamps();
		if (timeStamps.size()<3) {
			Blackboard.setPulseStatus("Unknown");
			return;
		}

		Long time1 = timeStamps.get(timeStamps.size()-3);
		Long time2 = timeStamps.get(timeStamps.size()-2);
		Long time3 = timeStamps.get(timeStamps.size()-1);

		// Prevents the pulse status from returning "Arrhythmic" when the timestamps
		// array fails to log a heart pulse since the sensor crashed 
		if (Blackboard.getSensorDown() != null) {
			if ( time1 < Blackboard.getSensorDown() && time3 > Blackboard.getSensorUp()) {
			Blackboard.setPulseStatus("Unknown");
			return;
			}

		}

		Long baseline = time2 - time1;
		Long comparison = time3 - time2;
		if (comparison > baseline * 1.5 || comparison < baseline / 1.5) {
			Blackboard.setPulseStatus("Arrhythmic");
		}else {
			Blackboard.setPulseStatus("Normal");
		}

	}

	@Override
	public void activateController() {
		// TODO Auto-generated method stub

	}
}
