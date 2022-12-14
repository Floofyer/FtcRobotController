package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.opencv.core.Scalar;

@TeleOp(name = "Tele")
public class GoldMainTeleOP extends OpMode {
    MouseMain mouse;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo claw;
    DcMotorEx slideL;
    DcMotorEx slideR;

    double DrivePower = 0.5;

    @Override
    public void init() { //init method runs once and is short for initialized//
        mouse = new MouseMain(hardwareMap);
        frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        frontRight = hardwareMap.get(DcMotor.class, "frontright");
        backLeft = hardwareMap.get(DcMotor.class, "backleft");
        backRight = hardwareMap.get(DcMotor.class, "backright");
        claw = hardwareMap.get(Servo.class, "claw");
        slideL = this.hardwareMap.get(DcMotorEx.class, "slidel");
        slideR= this.hardwareMap.get(DcMotorEx.class, "slider");
        telemetry.addData("Status", "Running");
        telemetry.update();
        frontRight.setDirection(DcMotor.Direction.REVERSE);
    }
    @Override
    public void loop() {
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.right_stick_x;
        double r = gamepad1.left_stick_y;

        double frontLeftPower = (y + r - x);
        double frontRightPower = (y - r - x);
        double backLeftPower = (y + r + x);
        double backRightPower = (y - r + x);

        if (gamepad1.right_trigger == 1) {
            DrivePower = Math.min(DrivePower + 0.05, 1);
        }
        if (gamepad1.left_trigger == 1) {
            DrivePower = Math.max(DrivePower - 0.05, 0.1);
        }
        if (gamepad2.x) {
            claw.setPosition(0.15);//open
        }
        if (gamepad2.y) {
            claw.setPosition(0);//close
        }
        if (gamepad2.left_stick_y > 0) {//down
            mouse.slideL.setPower(0.15);
            mouse.slideR.setPower(-0.15);
        }
        else if (gamepad2.left_stick_y < 0){//up
            mouse.slideL.setPower(-0.58);
            mouse.slideR.setPower(0.58);
        }
        else {
            mouse.slideL.setPower(0);
            mouse.slideR.setPower(0);
        }

        frontLeftPower *= DrivePower;
        frontRightPower *= DrivePower;
        backLeftPower *= DrivePower;
        backRightPower *= DrivePower;

        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);

        telemetry.addData("front left power = ", frontLeft.getPower());
        telemetry.addData("front right power = ", frontRight.getPower());
        telemetry.addData("back left power = ", backLeft.getPower());
        telemetry.addData("back left power = ", backRight.getPower());
        telemetry.addData("drive power = ", DrivePower);
        telemetry.addData("slide left power = ", slideL.getPower());
        telemetry.addData("slide right power = ", slideR.getPower());
        telemetry.update();
    }
}