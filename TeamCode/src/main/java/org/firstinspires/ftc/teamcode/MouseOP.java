package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Mouse")
public class MouseOP extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MouseMain mouse = new MouseMain(hardwareMap);

        waitForStart();
        mouse.forward(12, 0.69);
        mouse.right(12, 0.69);
        mouse.forward(12, 0.69);
    }
}