package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultElevatorCommand extends Command {

  //reference main robot object
  private Robot robot;

  public DefaultElevatorCommand(Robot robotInstance) {
    robot = robotInstance;
    requires(robot.elevatorSubsystem);
  }


  protected void execute() {
    if(robot.isOperatorControl()){
      robot.elevatorSubsystem.setSpeed(Controls.elevator());
      /*if(Controls.elevator() > 0) robot.elevatorSubsystem.setTargetPositionRelative(20);
			else if(Controls.elevator() < 0) robot.elevatorSubsystem.setTargetPositionRelative(-20);*/
    }
  }

  protected boolean isFinished() {
    return false;
  }

}
