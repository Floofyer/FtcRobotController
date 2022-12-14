package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "MouseLF")
public class RedFar extends LinearOpMode {
    @Override
    public void runOpMode() {
        MouseMain mouse = new MouseMain(hardwareMap);

        waitForStart();
        mouse.forward(6, 0.69);
        mouse.left(12, 0.69);
        mouse.forward(40, 0.69);
    }
}