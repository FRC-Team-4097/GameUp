// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4097.GameUp.subsystems;

import org.usfirst.frc4097.GameUp.Robot;
import org.usfirst.frc4097.GameUp.RobotMap;
import org.usfirst.frc4097.GameUp.commands.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class boxTransfer extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	int count=0;
	int h=0;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController shootMotorRight = RobotMap.boxTransfershootMotorRight;
    private final SpeedController shootMotorLeft = RobotMap.boxTransfershootMotorLeft;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void joystickInput(Joystick main){
    	if (RobotMap.elevatorscaleSwitch.get()==false){
    		RobotMap.elevatorlinearMotor.set(0.0);
    	}
    	if (main.getRawButton(2)){
    		shootMotorRight.set(0.8);
    		shootMotorLeft.set(0.8);
    	}
    	else if (main.getRawButton(4)){
    		shootMotorRight.set(-1);
    		shootMotorLeft.set(-1);
    	}
    	else if (main.getRawButton(5)){
    		shootMotorRight.set(-0.5);
    		shootMotorLeft.set(-0.5);
    	}
    	else if (main.getRawAxis(2)!=0){
    		shootMotorRight.set(-0.75);
    		shootMotorLeft.set(0.75);
    	}
    	else if (main.getRawAxis(3)!=0){
    		shootMotorRight.set(0.75);
    		shootMotorLeft.set(-0.75);
    	}
    	else{
    		shootMotorRight.stopMotor();
        	shootMotorLeft.stopMotor();
    	}
    }
    
    public void stop(){
    	shootMotorRight.stopMotor();
    	shootMotorLeft.stopMotor();
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new boxChange());
    }
}

