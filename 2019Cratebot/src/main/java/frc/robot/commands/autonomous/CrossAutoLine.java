package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.DriveStraightCommand;

public class CrossAutoLine extends CommandGroup{

    public CrossAutoLine(Robot robot){
        //addSequential(new DriveDistanceStraightCommand(robot, 0.5, 121));
        addSequential(new DriveStraightCommand(robot,0.5), 4.75);
    }
}

