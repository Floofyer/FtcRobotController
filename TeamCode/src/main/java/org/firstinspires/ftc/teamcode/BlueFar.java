package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.auton.AprilTagAutonomousInitDetectionExample;

@Autonomous(name = "BlueFar")
public class BlueFar extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MouseMain mouse = new MouseMain(hardwareMap);
        AprilTagAutonomousInitDetectionExample apriltag = new AprilTagAutonomousInitDetectionExample();
                
        waitForStart();
        mouse.forward(5, 0.69);
        mouse.right(25, 0.69);
        mouse.forward(30, 0.69);
        mouse.goToSlidePosition(20, 0.69);
        mouse.openClaw();
    }
}