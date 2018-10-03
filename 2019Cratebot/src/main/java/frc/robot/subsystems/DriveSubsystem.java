package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.commands.DefaultDriveCommand;


public class DriveSubsystem extends Subsystem {
  private Robot robot;

  
  public void initDefaultCommand() {
    setDefaultCommand(new DefaultDriveCommand(robot));
  }

  //Instantiate IO
  private Spark motorLeft = new Spark(IO.motorDriveLeft);
  private Spark motorRight = new Spark(IO.motorDriveRight);
  private Encoder encoderLeft = new Encoder(IO.encoderDriveLeftA, IO.encoderDriveLeftB);
  private Encoder encoderRight = new Encoder(IO.encoderDriveRightA, IO.encoderDriveRightB);
  private AHRS gyro = new AHRS(IO.gyro);

  //differential drive 
  private DifferentialDrive drive = new DifferentialDrive(motorLeft, motorRight);

  //constructor
  public DriveSubsystem(Robot robotInstance){
    robot = robotInstance;

    //Encoder settings
    encoderLeft.setDistancePerPulse((6 * Math.PI) / 2048);
    encoderRight.setDistancePerPulse((6 * Math.PI) / 2048);
    encoderRight.setReverseDirection(true);
  }

  //drive motors using left and right speeds
  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed, false);
  }

  //Drive motors using angle to calculate left and right speeds
  public void arcadeDrive(double speed, double angle){}

  //stop motors
  public void stopMotors(){
    drive.stopMotor();
  }

  //Gyro
  public boolean isGyroConnected(){
		return gyro.isConnected();
	}
	
	public boolean isGyroCalibrating(){
		return gyro.isCalibrating();
	}
	
	public double getGyroYaw(){
		return gyro.getYaw();
	}
	
	public void gyroZeroYaw(){
		gyro.zeroYaw();
	}

  // Encoders
	public double getLeftEncoderRate(){
		return encoderLeft.getRate();
	}

	public double getRightEncoderRate(){
		return encoderRight.getRate();
	}

	public double getLeftEncoderDistance(){
		return encoderLeft.getDistance();
	}

	public double getRightEncoderDistance(){
		return encoderRight.getDistance();
	}

	public void resetEncoders(){
		encoderLeft.reset();
		encoderRight.reset();
	}
}
