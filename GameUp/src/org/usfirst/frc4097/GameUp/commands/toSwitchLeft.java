// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4097.GameUp.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4097.GameUp.Robot;

/**
 *
 */
public class toSwitchLeft extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	int count=0;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public toSwitchLeft() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	String gameData;
    	gameData=DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.length() > 0)
        {
    		if(gameData.charAt(1) == 'L'){
    			count+=1;
    	    	SmartDashboard.putNumber("Time", count);
    	    	if(count<=650){
    	    		Robot.driveTrain.altdrive(0.8, 0.0);
    	    	}
    	    	else if(count<=750){
    	    		Robot.driveTrain.altdrive(0, 1);
    	    		Robot.elevator.linearMotor.set(1);
    	    	}
    	    	else{
    	    		Robot.elevator.linearMotor.set(0);
    	    		Robot.driveTrain.stop();
    	    		while (count<800){
    	    			Robot.boxTransfer.shootMotorLeft.set(0.5);
    	    			Robot.boxTransfer.shootMotorRight.set(0.5);
    	    		}
    	    		end();
    	    	}
    		} 
    		else if (gameData.charAt(0)=='L'){
    			count+=1;
    	    	SmartDashboard.putNumber("Time", count);
    	    	if(count<=325){
    	    		Robot.driveTrain.altdrive(0.8, 0.0);
    	    	}
    	    	else if(count<=375){
    	    		Robot.driveTrain.altdrive(0, 1);
    	    		Robot.elevator.linearMotor.set(1);
    	    	}
    	    	else{
    	    		Robot.elevator.linearMotor.set(0);
    	    		Robot.driveTrain.stop();
    	    		while (count<425){
    	    			Robot.boxTransfer.shootMotorLeft.set(0.5);
    	    			Robot.boxTransfer.shootMotorRight.set(0.5);
    	    		}
    	    		end();
    	    	}	
    		}
    		else {
    			new driveForward();
    		}
        }
    	else{
    		new driveForward();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    	Robot.elevator.stop();
    	Robot.boxTransfer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
