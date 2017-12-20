package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.PortMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public CANTalon leftMotor, rightMotor;
	public final int CURRENTLIMIT = 12;
	public final int VOLTAGERAMP = 6;
	double speed = 0;
	
	public DriveSubsystem(){
		leftMotor = new CANTalon(PortMap.LEFT_TALON);
		rightMotor = new CANTalon(PortMap.RIGHT_TALON);

		leftMotor.ChangeControlMode(CANTalon.TalonControlMode Current);
		rightMotor.ChangeControlMode(CANTalon.TalonControlMode Current);
		
		leftMotor.setCurrentLimit(CURRENTLIMIT);
		rightMotor.setCurrentLimit(CURRENTLIMIT);
		
		leftMotor.EnableCurrentLimit(true);
		rightMotor.EnableCurrentLimit(false);
		
		leftMotor.setVoltageRampRate(VOLTAGERAMP);
		rightMotor.setVoltageRampRate(VOLTAGERAMP);
		
	}
	
	public void setSpeed(double s){ //joystick
		speed = s*CURRENTLIMIT;
		leftMotor.set(speed);
		rightMotor.set(speed);
	}
	
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
