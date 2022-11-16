package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MouseMain {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    HardwareMap hardwareMap;

    final double TICKS_PER_ROTATION = 537.7;
    final double WHEEL_DIAMETER = 3.85827;
    final double TICKS_PER_INCH = TICKS_PER_ROTATION / (WHEEL_DIAMETER * Math.PI);

    // all of the hardware stored on this object/class
    public MouseMain(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;

        frontLeft = this.hardwareMap.get(DcMotor.class, "frontleft");
        frontRight = this.hardwareMap.get(DcMotor.class, "frontright");
        backLeft = this.hardwareMap.get(DcMotor.class, "backleft");
        backRight = this.hardwareMap.get(DcMotor.class, "backright");
    }
    private int inchesToTicks(double inches) {
        return (int) (inches * TICKS_PER_INCH);
    }
    public void forward(int ticks) {
        frontLeft.setTargetPosition(-ticks);
        frontRight.setTargetPosition(-ticks);
        backLeft.setTargetPosition(-ticks);
        backRight.setTargetPosition(-ticks);
    }
    public void backward(int ticks) {
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);
    }
    public void right(int ticks) {
        frontLeft.setTargetPosition(-ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(-ticks);
        backRight.setTargetPosition(ticks);
    }
    public void left(int ticks) {
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(-ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(-ticks);
    }
    public void goToTickPosition(int ticks, double power, String direction) {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if (direction.equals("forward")) {
            forward(ticks);
        } else if (direction.equals("backward")) {
            backward(ticks);
        } else if (direction.equals("right")) {
            right(ticks);
        } else if (direction.equals("left")) {
            left(ticks);
        }

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
}
