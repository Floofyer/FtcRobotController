package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedClose")
public class RedClose extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MouseMain mouse = new MouseMain(hardwareMap);

        waitForStart();
        mouse.forward(15, 0.69);
        mouse.left(25, 0.69);
        mouse.forward(15, 0.69);
    }
}
