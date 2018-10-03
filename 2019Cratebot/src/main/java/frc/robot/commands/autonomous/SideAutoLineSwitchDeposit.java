/*package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.DriveDistanceStraightCommand;
import frc.robot.commands.ElevatorPositionCommand;
import frc.robot.commands.GripperGripOpenCommand;
import frc.robot.commands.GripperRotatePositionCommand;
import frc.robot.commands.RotateCommand;

public class SideAutoLineSwitchDeposit extends CommandGroup{
    public SideAutoLineSwitchDeposit(Robot robot, AutonomousSide robotSide){

        String gameData = DriverStation.getInstance().getGameSpecificMessage();

        if(gameData.length() > 0){
            AutonomousSide switchSide = null;
            if(gameData.charAt(0) == 'R') switchSide = AutonomousSide.RIGHT;
            else if(gameData.charAt(0) == 'L') switchSide = AutonomousSide.LEFT;

            if(robotSide == switchSide){

                addSequential(new DriveDistanceStraightCommand(robot, 0.5, 121));
				//addSequential(new DriveStraightCommand(robot, 0.5), 4.75);
				addParallel(new ElevatorPositionCommand(robot, 40.0));
				if(switchSide == AutonomousSide.LEFT) addSequential(new RotateCommand(robot, 90.0));
				else if(switchSide == AutonomousSide.RIGHT) addSequential(new RotateCommand(robot, -90.0));
				addSequential(new GripperRotatePositionCommand(robot, 100.0));
				addSequential(new GripperGripOpenCommand(robot));
				
				Timer.delay(2.0);
				
				addParallel(new GripperRotatePositionCommand(robot, 0));
				addSequential(new ElevatorPositionCommand(robot, 0));
            }
        }

    }
}
*/
