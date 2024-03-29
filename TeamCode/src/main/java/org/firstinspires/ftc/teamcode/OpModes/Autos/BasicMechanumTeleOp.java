package org.firstinspires.ftc.teamcode.OpModes.Autos;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.math.Vector2d;


@TeleOp(name = "Mechanum")public class BasicMechanumTeleOp extends LinearOpMode {
    public void runOpMode() {
        //Variables
        double encoderRatio = 952.5/2259;
        /* encoderRatio = encoderTicksPerRotation/(gearRatio * wheelCircumference); */


        DcMotor fl = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor fr = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor bl = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor br = hardwareMap.dcMotor.get("back_right_motor");
        DcMotor intakeMotor = hardwareMap.dcMotor.get("intake_motor");
        DcMotor shootMotor = hardwareMap.dcMotor.get("shoot_motor");
        CRServo intakeServo = hardwareMap.crservo.get("intake_servo");
        

        BNO055IMU imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters param = new BNO055IMU.Parameters();

        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Motors
        fl.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.FORWARD);
        br.setDirection(DcMotor.Direction.FORWARD);

        // Gyro init

        param.loggingEnabled = false;
        param.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        param.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imu.initialize(param);


        waitForStart();
        double currentX = 0;
        double currentY = 0;
        double initialAngle = 0;
        double angle;
        double lastfr = 0;
        double lastfl = 0;
        double lastbr = 0;
        double lastbl = 0;
        double goRightMotors;
        double goLeftMotors;
        double dx;
        double dy;

        while (opModeIsActive()) {
            Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);


            if (gamepad1.left_bumper) {
                intakeMotor.setPower(1);
                intakeServo.setPower(1);
            }
            else{
                intakeMotor.setPower(0);
                intakeServo.setPower(0);
            }

            if (gamepad1.right_bumper) {
                shootMotor.setPower(1);
            }
            else{
                shootMotor.setPower(0);
            }


          //motor setting for drivetrain
            Vector2d input = new Vector2d(gamepad1.left_stick_y / 2, gamepad1.left_stick_x / 2);
            double rot = gamepad1.right_trigger - gamepad1.left_trigger;
            fl.setPower(input.x - input.y - rot);
            fr.setPower(input.x + input.y + rot);
            bl.setPower(input.x + input.y - rot);
            br.setPower(input.x - input.y + rot);

            goRightMotors = (fl.getCurrentPosition() - lastfl + br.getCurrentPosition() - lastbr) / (2 * encoderRatio);
            goLeftMotors =  (fr.getCurrentPosition() - lastfr + bl.getCurrentPosition() - lastbl) / (2 * encoderRatio);

            dx =  -goRightMotors + goLeftMotors;
            dy = -goRightMotors - goLeftMotors;

            angle = angles.firstAngle + initialAngle;
            double xChangeInPosRelativeToField = (Math.cos(angle) * dx - Math.sin(angle) * dy);
            currentX = currentX + xChangeInPosRelativeToField;
            currentY = currentY + (Math.cos(angle) * dy + Math.sin(angle) * dx);

            lastfl = fl.getCurrentPosition();
            lastfr = fr.getCurrentPosition();
            lastbl = bl.getCurrentPosition();
            lastbr = br.getCurrentPosition();


        }
    }
}
