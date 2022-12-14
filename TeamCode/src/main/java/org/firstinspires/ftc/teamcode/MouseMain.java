package org.firstinspires.ftc.teamcode;

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
    DcMotorEx slideL;
    DcMotorEx slideR;
    Servo claw;
    Servo foreBarLeft;
    Servo foreBarRight;

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
        slideL = this.hardwareMap.get(DcMotorEx.class, "slideL");
        slideR = this.hardwareMap.get(DcMotorEx.class, "slideR");
        foreBarLeft = this.hardwareMap.get(Servo.class, "forebarleft");
        foreBarRight = this.hardwareMap.get(Servo.class, "forebarright");
        frontRight.setDirection(DcMotor.Direction.REVERSE);
    }
    public int inchesToTicks(double inches) {
        return (int) (inches * TICKS_PER_INCH);
    }
    public void forward(int inches, double power) {
        driveInches(inches, power, "forward");
    }
    public void backward(int inches, double power) {
        driveInches(inches, power, "backward");
    }
    public void right(int inches, double power) {
        driveInches(inches, power, "right");
    }
    public void left(int inches, double power) {driveInches(inches, power, "left");}
    public void goToSlidePosition(int ticks, double power) {
        slideL.setTargetPosition(ticks);
        slideR.setTargetPosition(ticks);
        slideL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideL.setPower(power);
        slideR.setPower(power);
        while (slideL.isBusy() && slideR.isBusy());
        slideR.setPower(0);
        slideL.setPower(0);
    }

    public void goToTickPosition(int ticks, double power, String direction) {

//        frontLeft.setMo/de(DcMotor.RunMode.STOP_AND_RESET_ENCODER);/

        if (direction.equals("forward")) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()-ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()+ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()-ticks);
            backRight.setTargetPosition(backRight.getCurrentPosition()+ticks);
        } else if (direction.equals("backward")) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()+ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()-ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()+ticks);
            backRight.setTargetPosition(backRight.getCurrentPosition()-ticks);
        } else if (direction.equals("right")) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()-ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()-ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()-ticks);
            backRight.setTargetPosition(backRight.getCurrentPosition()-ticks);
        } else if (direction.equals("left")) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition()+ticks);
            frontRight.setTargetPosition(frontRight.getCurrentPosition()+ticks);
            backLeft.setTargetPosition(backLeft.getCurrentPosition()+ticks);
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
    public void driveInches(int inches,double power, String direction) {
        goToTickPosition(inchesToTicks(inches), power, direction);
    }

    public void openClaw () {
        claw.setPosition(0.1);
    }
    public void closeClaw () {
        claw.setPosition(0);
    }
    public void pUp () {}
}
