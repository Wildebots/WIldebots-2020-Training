package org.usfirst.frc4902.Wildebots2020Training.subsystems;

import org.usfirst.frc4902.Wildebots2020Training.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class VisionSystem extends Subsystem {

    private final ColorSensorV3 sensor;
    private final ColorMatch matcher;

    private final Color Blue = ColorMatch.makeColor(0, 1, 1);
    private final Color Green = ColorMatch.makeColor(0, 1, 0);
    private final Color Red = ColorMatch.makeColor(1, 0, 0);
    private final Color Yellow = ColorMatch.makeColor(1, 1, 0);

    private final Color detect;

    public VisionSystem() {
        sensor = new ColorSensorV3(Robot.i2cport);
        matcher = new ColorMatch();
        matcher.addColourMatch(Blue);
        matcher.addColourMatch(Green);
        matcher.addColourMatch(Red);
        matcher.addColourMatch(Yellow);
    }

    public void initDefaultCommand() {  
    }

    public void periodic() {
        Color detected = sensor.getColor();
        ColorMatchResult match = matcher.matchClosestColor(detected);
        detect = match;
        String color = colorString(match);
        ShuffleBoard.putData(color);
    }

    public String colorString(ColorMatchResult cmr) {
        switch(cmr.color) {
            case Blue:
                return "Blue";
            case Green:
                return "Green";
            case Red:       
                return "Red";
            case Yellow:
                return "Yellow";
            case Default:
                return "None";
        }
    }

    public void rotations() {
        final Color temp = this.detect;
        int count = 0;
        while(count < 7) {
            if(this.detect == temp) {
                count += 1;
            }
            else{
            }
        }
    }

}