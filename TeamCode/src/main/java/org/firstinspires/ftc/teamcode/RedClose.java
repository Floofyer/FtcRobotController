package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.auton.AprilTagAutonomousInitDetectionExample;

@Autonomous(name = "RedClose")
public class RedClose extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MouseMain mouse = new MouseMain(hardwareMap);
        AprilTagAutonomousInitDetectionExample apriltag = new AprilTagAutonomousInitDetectionExample();


        waitForStart();
        mouse.moveFourBar(1);
        mouse.moveFourBar(0);
        mouse.forward(28,0.5);
        mouse.right(3, 0.5);
        mouse.goToSlidePosition(2235, 0.80);
        mouse.openClaw();
        mouse.goToSlidePosition(2235, -0.80);
    }
}
