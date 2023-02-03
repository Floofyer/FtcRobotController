package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedClose")
public class RedClose extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MouseMain mouse = new MouseMain(hardwareMap);

        waitForStart();
        mouse.goToSlidePosition(20, 0.69);
    }
}
