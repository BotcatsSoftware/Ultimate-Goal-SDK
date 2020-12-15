package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name="BaseVuforia", group ="Concept")

public abstract class Vuforia extends LinearOpMode {

    public static final String TAG = "Vuforia Navigation Sample";

    OpenGLMatrix lastLocation = null;

    VuforiaLocalizer vuforia;

    @Override public void runOpMode() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);


        parameters.vuforiaLicenseKey = "AVop5Pr/////AAABmYh62mTDYUgSsC1tOVg8A0IjuyqMzLO1I9Ue7E0egk11CAzRZeX8GW2ytNBbBI96DbCQ306sVAjACJXwPhaiHFG5dHPRk3daxk2TPpzhXHEinXui59HAdySDhWwyxKSyBc7tkFk7cR2JOThtf5Qy7CJgp3qa8MxpZ2ZhCt433Iji1nMtL69cC9QVA260v7XJkWcXrGomJQYgrZl3w4AkQNrzkUSejo7LBHcaGyy2SHEMppAt8KXvSlDYJJgm737AVy27wgdGoMcS45F5VrAHhaUxy1os4ZDxfm2eNCFyCfzUc+M8jsewh2RZvk98rIbpGyAv7ZVqppF+G9HqQThn+lEGNm0Jy0nEHYajG0pHxVI4";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;


        vuforia = ClassFactory.getInstance().createVuforia(parameters);
        VuforiaTrackables ultimateGoal = this.vuforia.loadTrackablesFromAsset("ultimateGoal");


        //Initialising all trackables
        //set names of each target (white corresponds w white, green w green)
        VuforiaTrackable BlueTowerGoal = ultimateGoal.get(2); //example initialization of trackables
        BlueTowerGoal.setName("BlueTowerGoal");

        VuforiaTrackable RedTowerGoal = ultimateGoal.get(3);
        RedTowerGoal.setName("RedTowerGoal");

        VuforiaTrackable RedAlliance = ultimateGoal.get(4);
        RedAlliance.setName("RedAlliance");

        VuforiaTrackable BlueAlliance = ultimateGoal.get(5);
        BlueAlliance.setName("BlueAlliance");

        VuforiaTrackable FrontWall = ultimateGoal.get(6);
        FrontWall.setName("FrontWall");


        /** For convenience, gather together all the trackable objects in one easily-iterable collection */
        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>();
        allTrackables.addAll(ultimateGoal);

        float mmPerInch        = 25.4f;
        float mmBotWidth       = 18 * mmPerInch;            // ... or whatever is right for your robot
        float mmFTCFieldWidth  = (141) * mmPerInch;   // the FTC field is ~141" center-to-center of the glass panels



        //set the position and rotation of each trackable and the phone relative to the center of the robot
        OpenGLMatrix frontWallTarget = OpenGLMatrix

                // assuming front wall is negative y
                //x,y,z,u moves counterclockwise???,v makes it stand up facing towards the field if on the positive side (makes it roll away you) ,w
                //photos start facing up
                //x,y,z
                .translation(0, -mmFTCFieldWidth/2, 146.05f)
                .multiplied(Orientation.getRotationMatrix(

                        AxesReference.EXTRINSIC, AxesOrder.XZX,
                        //u, v, w
                        AngleUnit.DEGREES, -90, 90, 0));
        redTarget1.setLocation(redTarget1LocationOnField);
        RobotLog.ii(TAG, "front wall target =%s", format(redTarget1LocationOnField));

        //formerly Chris and Jeetesh's
        OpenGLMatrix redAllianceWall = OpenGLMatrix
                .translation(-mmFTCFieldWidth/2, 0, 146.05f)
                .multiplied(Orientation.getRotationMatrix(

                        AxesReference.EXTRINSIC, AxesOrder.XZX,
                        //u, v, w
                        AngleUnit.DEGREES, 0, 90, 0));
        redTarget1.setLocation(redTarget1LocationOnField);
        RobotLog.ii(TAG, "red alliance wall =%s", format(redTarget1LocationOnField));

        //Aidan
        OpenGLMatrix RedTowerGoal = OpenGLMatrix
                .translation(0, mmFTCFieldWidth/2, 146.05f)
                .multiplied(Orientation.getRotationMatrix(

                        AxesReference.EXTRINSIC, AxesOrder.XZX,
                        //u, v, w
                        AngleUnit.DEGREES, 90, 90, 0));
        redTarget1.setLocation(redTarget1LocationOnField);
        RobotLog.ii(TAG, "red goal target =%s", format(redTarget1LocationOnField));
        //Artem
        OpenGLMatrix BlueTowerGoal = OpenGLMatrix
                .translation(-mmFTCFieldWidth/4, mmFTCFieldWidth, 146.05f)
                .multiplied(Orientation.getRotationMatrix(

                        AxesReference.EXTRINSIC, AxesOrder.XZX,
                        //u, v, w
                        AngleUnit.DEGREES, 90, 90, 0));
        BlueTowerGoal.setLocation(BlueTowerGoalLocationOnField);
        RobotLog.ii(TAG, "blue goal target =%s", format(BlueTowerGoalLocationOnField));

        //William
        OpenGLMatrix blueAllianceWall = OpenGLMatrix
                .translation(0, -mmFTCFieldWidth/2, 146.05f)
                .multiplied(Orientation.getRotationMatrix(

                        AxesReference.EXTRINSIC, AxesOrder.XZX,
                        //u, v, w
                        AngleUnit.DEGREES, 90, -90, 0));
        redTarget1.setLocation(redTarget1LocationOnField);
        RobotLog.ii(TAG, "blue alliance wall =%s", format(redTarget1LocationOnField));


        //We need to describe where on the bot the phone is
        OpenGLMatrix phoneLocationOnRobot = OpenGLMatrix
                .translation(-7.25f,0,13.5f)
                .multiplied(Orientation.getRotationMatrix(
                        AxesReference.EXTRINSIC, AxesOrder.YZY,
                        AngleUnit.DEGREES, 180, 90, 0));
        RobotLog.ii(TAG, "phone=%s", format(phoneLocationOnRobot));


        // listeners for wall trackables
        ((VuforiaTrackableDefaultListener)BlueTowerGoal.getListener()).setPhoneInformation(phoneLocationOnRobot, parameters.cameraDirection);



        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();

        /** Start tracking the data sets we care about. */
        ultimateGoal.activate();

        while (opModeIsActive()) {

            for (VuforiaTrackable trackable : allTrackables) {
                /**
                 * getUpdatedRobotLocation() will return null if no new information is available since
                 * the last time that call was made, or if the trackable is not currently visible.
                 * getRobotLocation() will return null if the trackable is not currently visible.
                 */
                telemetry.addData(trackable.getName(), ((VuforiaTrackableDefaultListener)trackable.getListener()).isVisible() ? "Visible" : "Not Visible");    //

                OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener)trackable.getListener()).getUpdatedRobotLocation();
                if (robotLocationTransform != null) {
                    lastLocation = robotLocationTransform;
                }
            }
            /**
             * Provide feedback as to where the robot was last located (if we know).
             */
            if (lastLocation != null) {
                //  RobotLog.vv(TAG, "robot=%s", format(lastLocation));
                telemetry.addData("Pos", format(lastLocation));
            } else {
                telemetry.addData("Pos", "Unknown");
            }
            telemetry.update();
        }
    }

    /**
     * A simple utility that extracts positioning information from a transformation matrix
     * and formats it in a form palatable to a human being.
     */
    String format(OpenGLMatrix transformationMatrix) {
        return transformationMatrix.formatAsTransform();
    }
}