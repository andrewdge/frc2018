package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultGripperRotateCommand extends Command {

  private Robot robot;

  public DefaultGripperRotateCommand(Robot robotInstance){
    robot = robotInstance;
    requires(robot.gripperRotateSubsystem);
  }

  protected void execute() {
    if(robot.isOperatorControl()){
      if(Controls.gripperRotatePositionControl() > 0) robot.gripperRotateSubsystem.setTargetPositionRelative(20);
      else if(Controls.gripperRotatePositionControl() < 0) robot.gripperRotateSubsystem.setTargetPositionRelative(-20);
    }else{
      robot.gripperRotateSubsystem.stopMotors();
      

      /*if(Controls.gripperRotatePositionControl() > 0) robot.gripperRotateSubsystem.setTargetPositionRelative(20);
			else if(Controls.gripperRotatePositionControl() < 0) robot.gripperRotateSubsystem.setTargetPositionRelative(-20);*/
    }
  }

  protected boolean isFinished() {
    return false;
  }

}
