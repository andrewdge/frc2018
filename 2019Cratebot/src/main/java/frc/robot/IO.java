package frc.robot;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public final class IO{
    private IO(){}

    //PWM
    public static final int motorDriveLeft = 0;
    public static final int motorDriveRight = 1;
    public static final int motorElevator = 2;
    public static final int motorGripperGrip = 3;
    public static final int motorGrippperRotate = 4;
    public static final int motorElevatorBrake = 5;
    public static final int motorClimber = 6;

    //analog
    public static final int potentiometerElevator = 0;
    public static final int potentiometerGripperRotate = 1;
    public static final int potentiometerGripperGrip = 2;

    //digital
    public static final int limitSwitchElevatorBottom = 0;
    public static final int limitSwitchElevatorTop = 1;
    public static final int encoderDriveLeftA = 2;
    public static final int encoderDriveLeftB = 3;
    public static final int encoderDriveRightA = 4;
    public static final int encoderDriveRightB = 5;

    //USB
    public static final SerialPort.Port gyro = SerialPort.Port.kUSB;

}