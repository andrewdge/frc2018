package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;

public class DriveStraightCommand extends PIDCommand {

  private Robot robot;
  
  // speed assuming 0 degree angle
  private double speed;

  public DriveStraightCommand(Robot robotInstance, double speed) {
		super(robotInstance.preferences.getDouble("kPKeepStraight", 0.09), robotInstance.preferences.getDouble("kIKeepStraight", 0.0), robotInstance.preferences.getDouble("kDKeepStraight", 0.0));
    robot = robotInstance;
    this.speed = speed;

    requires(robot.driveSubsystem);
  }

  public void initialize() {
    //robot.driveSubsystem.gyroZeroYaw();
    setSetpoint(0.0);
  }

  

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  public void end() {
  }

  public double returnPIDInput(){
		return robot.driveSubsystem.getGyroYaw();
	}
	
	public void usePIDOutput(double output){
    //robot.driveSubsystem.arcadeDrive(speed, 0.0);// Drive using arcade drive at the specified speed and the output of the PID for the angle
    robot.driveSubsystem.tankDrive(speed,speed);// Drive using arcade drive at the specified speed and the output of the PID for the angle
  }
  
}
