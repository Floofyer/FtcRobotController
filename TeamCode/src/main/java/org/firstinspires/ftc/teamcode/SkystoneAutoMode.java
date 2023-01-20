package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name= "Skystone Detector", group="Auto")
public class SkystoneAutoMode extends LinearOpMode {
    OpenCvCamera phoneCam;
    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId",
                "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance()
                .createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
        SkystoneDetector detector = new SkystoneDetector();
        phoneCam.setPipeline(detector);
        phoneCam.openCameraDeviceAsync(
                () -> phonecam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT)
        );
    }
}