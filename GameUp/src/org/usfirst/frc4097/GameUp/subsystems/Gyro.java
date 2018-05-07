package org.usfirst.frc4097.GameUp.subsystems;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.*;
/**
 *
 */
public class Gyro extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AHRS gyro = new AHRS(SPI.Port.kMXP);
	public double getAngle(){
		return gyro.getAngle();
	}
	public double getYaw(){
		return gyro.getYaw();
	}
	public void resetGyro(){
		gyro.reset();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

