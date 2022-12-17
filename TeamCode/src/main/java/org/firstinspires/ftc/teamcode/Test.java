//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.opencv.core.Mat;
//import org.opencv.imgproc.Imgproc;
//import org.openftc.easyopencv.OpenCvCamera;
//import org.openftc.easyopencv.OpenCvCameraFactory;
//import org.openftc.easyopencv.OpenCvCameraRotation;
//import org.openftc.easyopencv.OpenCvPipeline;
//
//@Autonomous(name = "Tezt")
//public class Test extends LinearOpMode {
//    @Override
//    public void runOpMode() throws InterruptedException {
//        MouseMain mouse = new MouseMain(hardwareMap);
//        Pipeline pipeline = new Pipeline();
//
//
//        WebcamName webcamName = hardwareMap.get(WebcamName.class, "cam");
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);
//
//        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
//        {
//            @Override
//            public void onOpened()
//            {
//                // Usually this is where you'll want to start streaming from the camera (see section 4)
//            }
//            @Override
//            public void onError(int errorCode)
//            {
//
//            }            camera.openCameraDevice();
//        camera.setPipeline(Pipeline);
//        });
//        waitForStart();
//        camera.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);
//
//        camera.startStreaming(1280, 780, OpenCvCameraRotation.UPRIGHT);
//        camera.setViewportRenderingPolicy(OpenCvCamera.ViewportRenderingPolicy.OPTIMIZE_VIEW);
//    }
//}
