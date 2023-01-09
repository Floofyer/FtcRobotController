//package org.firstinspires.ftc.teamcode;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.opencv.core.Mat;
//import org.opencv.imgproc.Imgproc;
//import org.openftc.easyopencv.OpenCvPipeline;
//
//class Pipeline extends OpenCvPipeline
//{
//    Telemetry telemetry;
//    submat = new Mat();
//    Mat submat;
//
//
//    @Override
//    public Mat processFrame(Mat input)
//    {
//        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2YCrCb);
//        submat = transform.submat(427,854,0,0);
//
//        if (lastresult == Color.GOLD) {
//        }
//        else if (lastresult == Color.HEART){
//        }
//        else if (lastresult == Color.AUGBERGINE){
//    }
//        return submat;
//    }
//
//    enum Color {
//        GOLD,
//        HEART,
//        AUGBERGINE,
//        NONE,
//    }
//
//    https://www.geeksforgeeks.org/multiple-color-detection-in-real-time-using-python-opencv/
//    - from Alex, may be useful if you can implement the logic.
//}
