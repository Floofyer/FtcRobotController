package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name= "Skystone Detecotor", group="Auto")
public class Skystone_AutoMode extends LinearOpMode {
    OpenCvCamera phonecam;
    @Override
    public void runOpMode() throws InterruptedException {
    int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId",
            "id", hardwareMap.appContext.getPackageName());
            phonecam = OpenCvCameraFactory.getInstance()
                    .createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
            SkystoneDetector detector = new SkystoneDetector(telemetry);
        phonecam.setPipeline(detector);
        phonecam.openCameraDeviceAsync(
                () -> phonecam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT)
        );
    }
}
