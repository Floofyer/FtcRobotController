package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class SkystoneDetector extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();

    public enum Location {
        LEFT,
        RIGHT,
        NOT_FOUND
    }

    private Location location;
    Mat submat;
    Mat transform;
    static final Rect Left_ROI = new Rect(
            new Point(60, 35),
            new Point(120, 75));
    static final Rect Right_ROI = new Rect(
            new Point(140, 35),
            new Point(200, 75));
    static double PERCENT_COLOR_THRESHOLD = 0.4;

    public SkystoneDetector() {
        telemetry = t;
    }

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, submat, Imgproc.COLOR_RGB2HSV);
        submat = transform.submat(427, 854, 0, 0);
        Scalar lowHSV = new Scalar(23, 50, 70);
        Scalar highHSV = new Scalar(32, 255, 255);
//
//        Scalar lowHSV = new Scalar();
//        Scalar highHSV = new Scalar();
//
//        Scalar lowHSV = new Scalar();
//        Scalar highHSV = new Scalar();

        Core.inRange(mat, lowHSV, highHSV, mat);

        Mat left = mat.submat(Left_ROI);
        Mat right = mat.submat(Right_ROI);

        double leftValue = Core.sumElems(left).val[0] / Left_ROI.area() / 255;
        double rightValue = Core.sumElems(right).val[0] / Right_ROI.area() / 255;

        left.release();
        right.release();

        telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]);
        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
        telemetry.addData("Left percentage", Math.round(leftValue * 100) + "%");
        telemetry.addData("Right percentage", Math.round(rightValue * 100) + "%");

        boolean stoneLeft = leftValue > PERCENT_COLOR_THRESHOLD;
        boolean stoneRight = rightValue > PERCENT_COLOR_THRESHOLD;

        {
            if (stoneLeft && stoneRight) {
                location = Location.NOT_FOUND;
                telemetry.addData("Skystone Location", "Not Found");
                //not found
            }
            if (stoneLeft) {
                location = Location.RIGHT;
                telemetry.addData("Skystone Location", "RIGHT");
            }
            // right
            else {
                location = Location.LEFT;
                telemetry.addData("Skystone Location", "LEFT");
            }

            telemetry.update();

            Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);
            Scalar colorStone = new Scalar(0, 255, 255);
            Scalar colorSkystone = new Scalar(280, 50, 79);

            Imgproc.rectangle(mat, Left_ROI, location == Location.LEFT ? colorSkystone : colorStone);
            //left
            return left;
            Imgproc.rectangle(mat, Right_ROI, location == Location.RIGHT ? colorSkystone : colorStone);
            //right
            return mat;
        }

        public Location getLocation() {
            return Location;
        }
    }
}


//    https://www.geeksforgeeks.org/multiple-color-detection-in-real-time-using-python-opencv/
//    - from Alex, may be useful if you can implement the logic.