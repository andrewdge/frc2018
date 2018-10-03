package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultElevatorCommand;


public class ElevatorSubsystem extends Subsystem {
  //reference main robot object
  private Robot robot;
  
  //Instantiate IO
  private VictorSP motor = new VictorSP(IO.motorElevator);
  private AnalogInput potentiometer = new AnalogInput(IO.potentiometerElevator);

  //private constructor
  public ElevatorSubsystem(Robot robotInstance){
		//super(robotInstance.preferences.getDouble("kPElevator", 0.009), robotInstance.preferences.getDouble("kIElevator", 0.0), robotInstance.preferences.getDouble("kDElevator", 0.0));
    robot = robotInstance;
    /*
    //PID controller Options
    setAbsoluteTolerance(15); //if pot is within +- this value, its on target
    setInputRange(robot.preferences.getInt("limitElevatorBottom", 6), robot.preferences.getInt("limitElevatorTop", 4096));// Set the input range, i.e. the limits of the potentiometer
    setSetpoint(getPotentiometerValue());// Set the initial target position to the current value so that the elevator does not move by default

    getPIDController().enable();
    */
  }

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultElevatorCommand(robot));
  }
  /*
  protected double returnPIDInput(){
    return getPotentiometerValue();
  }

  protected void usePIDOutput(double output){
    motor.pidWrite(output);
  }

  //set target position
  public void setTargetPosition(int position){
    setSetpoint(position);
  }

  public void setTargetPositionRelative(int delta){
    setSetpointRelative(delta);
  }

  // Set PID Constants
  public void setP(double kP){
    getPIDController().setP(kP);
    robot.preferences.putDouble("kPElevator", kP);
  }
  public void setI(double kI){
		getPIDController().setI(kI);
		robot.preferences.putDouble("kIElevator", kI);
	}
	public void setD(double kD){
		getPIDController().setD(kD);
		robot.preferences.putDouble("kDElevator", kD);
  }
  
  */

  //Motor
  public void setSpeed(double speed){
    if(speed > 0.0){ //up
      if(getPotentiometerValue() < robot.preferences.getInt("limiteElevatorTop", 2140)){
        motor.set(-speed);
      }else{
        motor.stopMotor();
      }
    }else if(speed < 0.0){ //down
      if(getPotentiometerValue() > robot.preferences.getInt("limitElevatorBottom", 110)){
        motor.set(-speed);
      }else{
        motor.stopMotor();
      }
    }else{
      motor.stopMotor();
    }
  }
  

  public void stopMotors(){
    motor.stopMotor();
  }

  //potentiometer
  public int getPotentiometerValue(){
    return potentiometer.getValue();
  }

  public double getPotentiometerVoltage(){
    return potentiometer.getVoltage();
  }

  public double getMotorSpeed(){
    return motor.get();
  }

  /*
  // Convert a percentage of the elevator range to an absolute potentiometer value
	public int rangePercentageToAbsolute(double percentage){
		int bottomLimit = robot.preferences.getInt("limitElevatorBottom", 0);
		int topLimit = robot.preferences.getInt("limitElevatorTop", 4096);
		return (int) Math.round(bottomLimit + ((topLimit - bottomLimit) * percentage));
	}
  */
}
