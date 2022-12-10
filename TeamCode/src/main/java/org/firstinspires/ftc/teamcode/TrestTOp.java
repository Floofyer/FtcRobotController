package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "TrestTOp")
public class TrestTOp extends OpMode {
    MouseMain mouse;
    @Override
    public void init() {
        MouseMain mouse = new MouseMain(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("slide Left Ticks" , mouse.slideL.getCurrentPosition());
        telemetry.addData("slide Right Ticks" , mouse.slideR.getCurrentPosition());
        telemetry.update();
    }
}

