package frc.robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.autonomous.CrossAutoLine;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.GripperGripSubsystem;
import frc.robot.subsystems.GripperRotateSubsystem;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;


public class Robot extends TimedRobot{

  public Preferences preferences = Preferences.getInstance();

  //Instantiate subsystems
  public DriveSubsystem driveSubsystem = new DriveSubsystem(this);
  public ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem(this);
  public GripperGripSubsystem gripperGripSubsystem = new GripperGripSubsystem(this);
  public GripperRotateSubsystem gripperRotateSubsystem = new GripperRotateSubsystem(this);

  public void robotInit(){
    //Creates new USBCamera with name 0, starts recording
    UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0); 
    camera1.setResolution(320, 240);

    //PDP value fetching
    PowerDistributionPanel pdp = new PowerDistributionPanel();
    
    
    
  }

  //Every Periodic method needs to get instance from scheduler
  public void robotPeriodic(){
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("elevatorpot", elevatorSubsystem.getPotentiometerValue());
    SmartDashboard.putNumber("GripperRotatePotValue", gripperRotateSubsystem.getPotentiometerValue());
    SmartDashboard.putNumber("GripperGripPotValue", gripperGripSubsystem.getPotentiometerValue());
    SmartDashboard.putNumber("elevatorVoltValue", elevatorSubsystem.getPotentiometerVoltage());
    SmartDashboard.putNumber("GripperRotateVoltValue", gripperRotateSubsystem.getPotentiometerVoltage());
    SmartDashboard.putNumber("GripperGripVoltValue", gripperGripSubsystem.getPotentiometerVoltage());
    SmartDashboard.putNumber("Spark", gripperRotateSubsystem.motor.get());

  }
  
  public void autonomousInit(){
    //SideAutoLineSwitchDeposit command = new SideAutoLineSwitchDeposit(this, AutonomousSide.RIGHT);
    CrossAutoLine command = new CrossAutoLine(this);
		command.start();
  }

  public void autonomousPeriodic(){
    Scheduler.getInstance().run();
  }

  public void teleopInit(){
      gripperRotateSubsystem.resetSetpoint();
  }

  public void teleopPeriodic(){
    Scheduler.getInstance().run();
  }

  public void disabledInit(){
    
  }

  public void disabledPeriodic(){
    Scheduler.getInstance().run();
  }


}
