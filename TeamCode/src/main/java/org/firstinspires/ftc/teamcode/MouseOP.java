package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Mouse")
public class MouseOP extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MouseMain mouse = new MouseMain(hardwareMap);

        waitForStart();
        mouse.forward(.5);
        sleep(100);
        mouse.right(0.65);
        sleep(450);
        mouse.forward(0.69);
        sleep(2200);
    }
}