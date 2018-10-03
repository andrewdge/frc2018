package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultGripperGripCommand extends Command {
  private Robot robot;
  public DefaultGripperGripCommand(Robot robotInstance) {
    robot = robotInstance;
    requires(robot.gripperGripSubsystem);
  }
  protected void execute() {
    if(robot.isOperatorControl()){
      if(Controls.gripperGripOpen()){
        robot.gripperGripSubsystem.setSpeed(0.85);
      } 
      else if(Controls.gripperGripClose()){
        robot.gripperGripSubsystem.setSpeed(-0.5);
      } 
      
      /*if(Controls.gripperGripOpen()) robot.gripperGripSubsystem.open();
			else if(Controls.gripperGripClose()) robot.gripperGripSubsystem.close();*/

    }
  }

  protected boolean isFinished() {
    return false;
  }

}
