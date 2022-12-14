package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BlueClose")
public class BlueClose extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MouseMain mouse = new MouseMain(hardwareMap);

        waitForStart();
        while (opModeIsActive()) {
            /*telemetry.addData("slide Left Ticks" , mouse.slideL.getCurrentPosition());
            telemetry.addData("slide Right Ticks" , mouse.slideR.getCurrentPosition());
            telemetry.update();*/
        }
        mouse.forward(6, 0.69);
        mouse.right(12, 0.69);
        mouse.forward(15, 0.69);
    }
}