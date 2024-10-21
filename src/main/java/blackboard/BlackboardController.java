/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackboard;

import pacemaker.ActivityStatusCalculator;
import pacemaker.BpmCalculator;
import pacemaker.PulseStatusCalculator;

/**
 *
 * @author Hector Espinoza
 */
public class BlackboardController {

    private static BpmCalculator bpm = new BpmCalculator();
    private static PulseStatusCalculator pulseStatus = new PulseStatusCalculator();
    private static ActivityStatusCalculator activityStatus = new ActivityStatusCalculator();

    // Loop through the following knowledge sources and have them update the 
    // knowledge written on the Blackboard.
    public static void loop() {
        bpm.updateBlackboard();
        pulseStatus.updateBlackboard();
        activityStatus.updateBlackboard();
    }
}
