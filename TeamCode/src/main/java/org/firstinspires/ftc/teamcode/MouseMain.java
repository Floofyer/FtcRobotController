package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.tools.javac.tree.DCTree;

public class MouseMain {
    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    Servo claw;
    CRServo fourBarLeft;
    CRServo fourBarRight;
    DcMotorEx slideL;
    DcMotorEx slideR;

    HardwareMap hardwareMap;

    final double TICKS_PER_ROTATION = 537.7;
    final double WHEEL_DIAMETER = 3.85827;
    final double TICKS_PER_INCH = TICKS_PER_ROTATION / (WHEEL_DIAMETER * Math.PI);

//last resort is preset
    // all of the hardware stored on this object/class
    public MouseMain(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
        frontLeft = this.hardwareMap.get(DcMotorEx.class, "frontleft");
        frontRight = this.hardwareMap.get(DcMotorEx.class, "frontright");
        backLeft = this.hardwareMap.get(DcMotorEx.class, "backleft");
        backRight = this.hardwareMap.get(DcMotorEx.class, "backright");
        claw = this.hardwareMap.get(Servo.class, "claw");
        slideL = this.hardwareMap.get(DcMotorEx.class, "slidel");
        slideR = this.hardwareMap.get(DcMotorEx.class, "slider");
        fourBarLeft = this.hardwareMap.get(CRServo.class, "fourbarleft");
        fourBarRight = this.hardwareMap.get(CRServo.class, "fourbarright");
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        fourBarRight.setDirection(CRServo.Direction.REVERSE);
    }
    public int inchesToTicks(double inches) {
        return (int) (inches * TICKS_PER_INCH);
    }
    public void forward(int inches, double power) {
        driveInches(inches, power, Drive.FORWARD);
    }
    public void backward(int inches, double power) {
        driveInches(inches, power, Drive.BACKWARD);
    }
    public void right(int inches, double power) {
        driveInches(inches, power, Drive.RIGHT);
    }
    public void left(int inches, double power) {driveInches(inches, power, Drive.LEFT);
    }
    public void goToSlidePosition(int ticks, double power) {
        slideL.setTargetPosition(ticks);
        slideR.setTargetPosition(ticks);
        slideL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideL.setPower(power);
        slideR.setPower(power);
        while (slideL.isBusy() && slideR.isBusy()) ;
        slideR.setPower(0);
        slideL.setPower(0);
    }
    public void moveFourBar(double power) {
        fourBarLeft.setPower(power);
        fourBarRight.setPower(power);
    }
    public void goToTickPosition(int ticks, double power, Drive direction) {

//        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if (direction == Drive.FORWARD) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()+ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()+ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()+ticks);
            backRight.setTargetPosition(backRight.getCurrentPosition()+ticks);
        } else if (direction == Drive.BACKWARD) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()-ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()-ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()-ticks);
            backRight.setTargetPosition(backRight.getCurrentPosition()-ticks);
        } else if (direction == Drive.RIGHT) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()+ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()-ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()+ticks);
            backRight.setTargetPosition(backRight.getCurrentPosition()-ticks);
        } else if (direction == Drive.LEFT) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()-ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()+ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()-ticks);
            backRight.setTargetPosition(backRight.getCurrentPosition()+ticks);
        }
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
        frontRight.setPower(power);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {} // isBusy will return true until the motor reaches the target position

        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        frontRight.setPower(0);
    }
    public void driveInches(int inches,double power, Drive direction) {
        goToTickPosition(inchesToTicks(inches), power, direction);
    }

    public void openClaw () {
        claw.setPosition(0.7);
    }
    public void closeClaw () {
        claw.setPosition(0.5);}
    public void pUp () {
    }

    enum Drive {
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT,
    }
}
