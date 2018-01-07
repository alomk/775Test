package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.PortMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public TalonSRX leftMotor, rightMotor;
	public final int CONTCURRENTLIMIT = 10; //amps
	public final int PEAKCURRENTLIMIT = 13;
	public final int PEAKCURRENTDURATION = 100; //ms
	public final int VOLTAGERAMP = 6;
	
	public DriveSubsystem(){
		leftMotor = new TalonSRX(PortMap.LEFT_TALON);
		rightMotor = new TalonSRX(PortMap.RIGHT_TALON);
		rightMotor.follow(leftMotor);

		leftMotor.configContinuousCurrentLimit(CONTCURRENTLIMIT, 0);
		leftMotor.configPeakCurrentLimit(PEAKCURRENTLIMIT, 0);
		leftMotor.configPeakCurrentDuration(PEAKCURRENTDURATION, 0);
		leftMotor.enableCurrentLimit(true);
		
		leftMotor.configOpenloopRamp(VOLTAGERAMP, 0);
		
		/*rightMotor.configContinuousCurrentLimit(CONTCURRENTLIMIT, 0);
		rightMotor.configPeakCurrentLimit(PEAKCURRENTLIMIT, 0);
		rightMotor.configPeakCurrentDuration(PEAKCURRENTDURATION, 0);
		rightMotor.enableCurrentLimit(true);
		
		leftMotor.setCurrentLimit(CURRENTLIMIT);
		rightMotor.setCurrentLimit(CURRENTLIMIT);
		
		leftMotor.EnableCurrentLimit(true);
		rightMotor.EnableCurrentLimit(false);
		
		leftMotor.setVoltageRampRate(VOLTAGERAMP);
		rightMotor.setVoltageRampRate(VOLTAGERAMP);*/
		
	}
	
	public void setSpeed(Joystick j){ //joystick
		leftMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, j.getY());
		//rightMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, j.getY());
	}
	
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
