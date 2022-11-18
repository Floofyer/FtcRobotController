package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "MouseLF")
public class MouseLF extends LinearOpMode {
    @Override
    public void runOpMode() {
        MouseMain mouse = new MouseMain(hardwareMap);

        waitForStart();
        mouse.forward(12, 0.5);
//        mouse.left(12, 1);
//        mouse.forward(12, 1);
    }
}