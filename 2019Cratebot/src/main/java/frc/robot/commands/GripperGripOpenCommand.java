/*package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GripperGripOpenCommand extends Command {

  private Robot robot;

  public GripperGripOpenCommand(Robot robotInstance) {
    robot = robotInstance;
    requires(robot.gripperGripSubsystem);
  }

  protected void initialize(){
		robot.gripperGripSubsystem.open();
	}
	
	protected boolean isFinished(){
		return robot.gripperGripSubsystem.onTarget();
	}
}
*/
