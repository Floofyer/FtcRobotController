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
    double DrivePower = 0.5;

    @Override
    public void init() { //init method runs once and is short for initialized//
        this.mouse = new MouseMain(hardwareMap);
        telemetry.addData("Status", "Running");
        telemetry.update();
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
            mouse.claw.setPosition(1);//close
        }
        if (gamepad2.y) {
            mouse.claw.setPosition(0.7);//open
        }
        if (gamepad2.left_stick_y > 0) {//down
            mouse.slideL.setPower(0.25);
            mouse.slideR.setPower(-0.25);
        }
        else if (gamepad2.left_stick_y < 0){//up
            mouse.slideL.setPower(-0.80);
            mouse.slideR.setPower(0.80);
        }
        else {
            mouse.slideL.setPower(0);
            mouse.slideR.setPower(0);
        }
        if (gamepad2.right_stick_y > 0) {
            mouse.moveFourBar(-1);
        }
        else if (gamepad2.right_stick_y < 0) {
            mouse.moveFourBar(1);
        }
        else {
            mouse.moveFourBar(0);
        }

        frontLeftPower *= DrivePower;
        frontRightPower *= DrivePower;
        backLeftPower *= DrivePower;
        backRightPower *= DrivePower;

        mouse.frontLeft.setPower(frontLeftPower);
        mouse.frontRight.setPower(frontRightPower);
        mouse.backLeft.setPower(backLeftPower);
        mouse.backRight.setPower(backRightPower);

        telemetry.addData("front left power = ", mouse.frontLeft.getPower());
        telemetry.addData("front right power = ", mouse.frontRight.getPower());
        telemetry.addData("back left power = ", mouse.backLeft.getPower());
        telemetry.addData("back left power = ", mouse.backRight.getPower());
        telemetry.addData("drive power = ", DrivePower);
        telemetry.addData("slide left power = ", mouse.slideL.getPower());
        telemetry.addData("slide right power = ", mouse.slideR.getPower());
        telemetry.update();
    }
}