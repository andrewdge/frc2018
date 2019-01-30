package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultGripperGripCommand;



public class GripperGripSubsystem extends Subsystem {
 
  private Robot robot;

  //IO
  private Spark motor = new Spark(IO.motorGripperGrip);
  private AnalogInput potentiometer = new AnalogInput(IO.potentiometerGripperGrip);

  //constructor

  public GripperGripSubsystem(Robot robotInstance){
    //super(robotInstance.preferences.getDouble("kPGripperGrip", 0.009), robotInstance.preferences.getDouble("kIGripperGrip", 0.0), robotInstance.preferences.getDouble("kDGripperGrip", 0.0));
    robot = robotInstance;

    /*
    // PID Controller Options
		setAbsoluteTolerance(10);// If the potentiometer is within +- this value it is considered on target
		setInputRange(robot.preferences.getInt("limitGripperGripClosed", 0), robot.preferences.getInt("limitGripperGripOpen", 3200));// Set the input range, i.e. the limits of the potentiometer
		//setOutputRange(-0.5, 0.75);// Set the maximum speed for opening and closing
    resetSetpoint();// Set the initial target position to the closed limit so that the gripper grips by default
    
    getPIDController().enable();
    */
  }

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultGripperGripCommand(robot));
  }

  /*
  protected double returnPIDInput(){
		return getPotentiometerValue();
	}
	
	protected void usePIDOutput(double output){
		motor.pidWrite(output);
  }
  
  public void resetSetpoint(){
    setSetpoint(getPotentiometerValue());
  }
  
  
	// Set Target Position
	public void setTargetPosition(int position){
		setSetpoint(position);
	}
	
	public void open(){
		setTargetPosition(robot.preferences.getInt("limitGripperGripOpen", 3000));
	}
	public void close(){
		setTargetPosition(robot.preferences.getInt("limitGripperGripClosed", 2700));
	}
	
	// Set PID Constants
	public void setP(double kP){
		getPIDController().setP(kP);
		robot.preferences.putDouble("kPGripperGrip", kP);
	}
	public void setI(double kI){
		getPIDController().setI(kI);
		robot.preferences.putDouble("kIGripperGrip", kI);
	}
	public void setD(double kD){
		getPIDController().setD(kD);
		robot.preferences.putDouble("kDGripperGrip", kD);
  }
  */

  public void setSpeed(double speed){
    
    if(speed > 0.0){ //open
      if(getPotentiometerValue() < robot.preferences.getInt("limitGripperGripOpen", 3020)){
        motor.set(speed);
      }else{
        motor.stopMotor();
      }
    }else if(speed < 0.0){ //close
      if(getPotentiometerValue() > robot.preferences.getInt("limitGripperGripClosed", 2000)){
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

}
