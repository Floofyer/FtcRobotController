//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.teamcode.auton.AprilTagAutonomousInitDetectionExample;
//import org.firstinspires.ftc.teamcode.auton.AprilTagDetectionPipeline;
//import org.openftc.apriltag.AprilTagDetection;
//import org.openftc.easyopencv.OpenCvCamera;
//import org.openftc.easyopencv.OpenCvCameraFactory;
//import org.openftc.easyopencv.OpenCvCameraRotation;
//import org.openftc.easyopencv.OpenCvInternalCamera;
//import org.openftc.easyopencv.OpenCvInternalCamera2;
//import org.openftc.easyopencv.OpenCvPipeline;
//
//@Autonomous(name = "RedClose")
//public class RedClose extends LinearOpMode {
//    @Override
//    public void runOpMode() throws InterruptedException {
//        MouseMain mouse = new MouseMain(hardwareMap);
//        AprilTagAutonomousInitDetectionExample apriltag = new AprilTagAutonomousInitDetectionExample(this);
//
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
//        OpenCvCamera camera1 = OpenCvCameraFactory.getInstance().createInternalCamera2(OpenCvInternalCamera2.CameraDirection.BACK, cameraMonitorViewId);
//        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
//        OpenCvCamera camera2 = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);
//        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
//        {
//            @Override
//            public void onOpened()
//            {
//                camera.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);
//                camera.startStreaming(800, 448, OpenCvCameraRotation.UPRIGHT);
//            }
//            @Override
//            public void onError(int errorCode)
//            {
//                /*
//                 * This will be called if the camera could not be opened
//                 */
//            }
//        });
//        camera.setPipeline(new AprilTagDetectionPipeline(0.166, 578.272, 578.272, 402.145, 221.506));
//        waitForStart();
//
//        apriltag.runDetection();
//    }
//}
