package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "TrestTOp")
public class TrestTOp extends OpMode {
    MouseMain mouse;
    @Override
    public void init() {
        mouse = new MouseMain(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("slide Left Ticks" , mouse.slideL.getCurrentPosition());
        telemetry.addData("slide Right Ticks" , mouse.slideR.getCurrentPosition());
        telemetry.addData("LinearSlideL Power", mouse.slideL.getPower());
        telemetry.addData("LinearSlideR Power", mouse.slideR.getPower());

        telemetry.update();

        if (gamepad2.left_stick_y > 0) {
            mouse.slideL.setPower(0.1);
            mouse.slideR.setPower(0.1);
        }
        else if (gamepad2.left_stick_y < 0){
            mouse.slideL.setPower(-0.1);
            mouse.slideR.setPower(-0.1);
        }
        else {
            mouse.slideL.setPower(0);
            mouse.slideR.setPower(0);
        }
        if (gamepad2.right_stick_y > 0) {
            mouse.moveFourBar(0.1);
        }
        else if (gamepad2.right_stick_y < 0) {
            mouse.moveFourBar(-0.1);
        }
    }
}