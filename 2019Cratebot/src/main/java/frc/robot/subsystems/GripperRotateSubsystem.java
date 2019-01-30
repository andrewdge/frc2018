package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultGripperRotateCommand;


public class GripperRotateSubsystem extends PIDSubsystem {

  private Robot robot;

  //IO
  public Spark motor = new Spark(IO.motorGrippperRotate);
  private AnalogInput potentiometer = new AnalogInput(IO.potentiometerGripperRotate);

  public GripperRotateSubsystem(Robot robotInstance) {
    super(0.0008,0,0);

    //control swing of arm
    //super(robotInstance.preferences.getDouble("kPGripperRotate", 0.0001), robotInstance.preferences.getDouble("kIGripperRotate", 0.000), robotInstance.preferences.getDouble("kDGripperRotate", 0.0));

    robot = robotInstance;

    
    //PID Controller options
    setAbsoluteTolerance(30);
    setInputRange(robot.preferences.getInt("limitGripperRotateDown", 320), robot.preferences.getInt("limitGripperRotateUp", 3940));
    resetSetpoint();

    // enable PID controller
    getPIDController().enable();
    
  }

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultGripperRotateCommand(robot));
  }

  
  protected double returnPIDInput() {
    return getPotentiometerValue();
  }

  protected void usePIDOutput(double output) {
    motor.pidWrite(-output);
  }
  
  public void resetSetpoint(){
    setSetpoint(getPotentiometerValue());
  }
  
  
  public void setSpeed(double speed){
    
    if(speed > 0.0){ 
      if(getPotentiometerValue() < robot.preferences.getInt("limitGripperGripOpen", 4000)){
        motor.set(speed);
      }else{
        motor.stopMotor();
      }
    }else if(speed < 0.0){ 
      if(getPotentiometerValue() > robot.preferences.getInt("limitGripperGripClosed", 6)){
        motor.set(speed);
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

  
  //set target position
  public void setTargetPosition(int position){
    setSetpoint(position);
  }
  public void setTargetPositionRelative(int delta){
    setSetpoint(getSetpoint() + delta);
  }

  
  //potentiometer
  public int getPotentiometerValue(){
    return potentiometer.getValue();
  }

  public double getMotorSpeed(){
    return motor.get();
  }

  public double getPotentiometerVoltage(){
    return potentiometer.getVoltage();
  }

  /*
  // Set PID Constants
	public void setP(double kP){
		getPIDController().setP(kP);
		//robot.preferences.putDouble("kPGripperRotate", kP);
	}
	public void setI(double kI){
		getPIDController().setI(kI);
		//robot.preferences.putDouble("kIGripperRotate", kI);
	}
	public void setD(double kD){
		getPIDController().setD(kD);
		//robot.preferences.putDouble("kDGripperRotate", kD);
  }
  /*
  // Convert a percentage of the rotation range to an absolute potentiometer value
	public int rangePercentageToAbsolute(double percentage){
		int downLimit = robot.preferences.getInt("limitGripperRotateDown", 4096);
		int upLimit = robot.preferences.getInt("limitGripperRotateUp", 336);
		return (int) Math.round(downLimit + ((upLimit - downLimit) * percentage));
	}

  */
}
