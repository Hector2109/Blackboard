/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacemaker;

import blackboard.Blackboard;
import blackboard.KnowledgeSource;

/**
 *
 * @author Hector Espinoza
 */
public class ActivityStatusCalculator implements KnowledgeSource{

	@Override
	public void updateBlackboard() {
		Long bpm = Blackboard.getBpm();
		if (bpm <= 80) {
			Blackboard.setActivityLevel("Resting");
			return;
		} 
		
		if (bpm > 80 && bpm <= 150) {
			Blackboard.setActivityLevel("Moderate Activity");
			return;
		} 
		
		if (bpm > 150 && bpm <= 200) {
			Blackboard.setActivityLevel("Intense Activity");
			return;
		} 
		
		if (bpm > 200) {
			Blackboard.setActivityLevel("Danger!");
			return;
		} 
	}

	@Override
	public void activateController() {
		// TODO Auto-generated method stub
		
	}

}