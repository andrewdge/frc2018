package frc.robot.commands;

import frc.robot.Robot;

public class DriveDistanceStraightCommand extends DriveStraightCommand {

  private Robot robot;

  private double distance;
  public DriveDistanceStraightCommand(Robot robotInstance, double speed, double distance) {
    super(robotInstance, speed);
    robot = robotInstance;
    this.distance = distance;
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return robot.driveSubsystem.getRightEncoderDistance() > distance;
  }

}
