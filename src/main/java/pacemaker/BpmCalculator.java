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
public class BpmCalculator implements KnowledgeSource{

	@Override
	public void updateBlackboard() {
		ArrayList<Long> timeStamps = Blackboard.getTimeStamps();
		// Set bpm to zero if there are not enough datapoints to calculate it
		// Otherwise, calculate bpm by counting the number of datapoints in 
		// timeStamps array, and dividing by the total elapsed time of the first
		// point and the last point in the array(making sure to convert from milliseconds to minutes first). 
		if (timeStamps.size()<2) {
			Blackboard.setBpm((long) 0); 
		}else {
			Long elapsedTime;
			Long startTime = timeStamps.get(0);
			Long endTime = timeStamps.get(timeStamps.size()-1);
			elapsedTime = endTime - startTime;
			
			Long bpm = (timeStamps.size()*60*1000)/elapsedTime;

			Blackboard.setBpm(bpm); 
		}
	}

	@Override
	public void activateController() {
		// TODO Auto-generated method stub

	}

}
