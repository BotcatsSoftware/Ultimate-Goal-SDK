//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//
//package org.firstinspires.ftc.teamcode.OpModes.Autos;
//
//    public class RedAllianceAuto {
//    public class RedAllianceAuto extends LinearOpMode
//    {
//        DcMotor fl = null;
//        DcMotor fr = null;
//        DcMotor bl = null;
//        DcMotor br = null;
//        Servo servo = null;
//
//        public void runOpMode()
//        {
//            fl = hardwareMap.dcMotor.get("front_left_motor");
//            fr = hardwareMap.dcMotor.get("front_right_motor");
//            bl = hardwareMap.dcMotor.get("back_left_motor");
//            br = hardwareMap.dcMotor.get("back_right_motor");
//            servo = hardwareMap.servo.get("back_servo");
//
//            fl.setDirection(DcMotorSimple.Direction.REVERSE);
//            bl.setDirection(DcMotorSimple.Direction.REVERSE);
//
//            waitForStart ();
//            //push wobble goal forward
//            driveForwardDistance(0.5, 0);
//            //push wobble goal into box
//            driveRightDistance(0.5, 0);
//            //drive back to line
//            driveBackDistance(0.5, 0);
//            //drive infront of first target
//            driveLeftDistance(0.5, 0);
//            //shoot
//            //drive infront of second target
//            driveLeftDistance(0,5);
//            //shoot
//            //drive infront of third target
//            driveLeftDistance(0.5,0);
//            //shoot
//            //park on line
//            driveForwardDistance(0.5,0);
//}
//    private void driveForwardDistance(double power, int distance){
//        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        fl.setTargetPosition(distance);
//        fr.setTargetPosition(distance);
//        bl.setTargetPosition(distance);
//        br.setTargetPosition(distance);
//
//        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        driveForward(power);
//
//        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy())
//        {
//
//        }
//        stopDriving();
//        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
//
//        }
//    private void driveBackDistance(double power, int distance){
//        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        fl.setTargetPosition(-distance);
//        fr.setTargetPosition(-distance);
//        bl.setTargetPosition(-distance);
//        br.setTargetPosition(-distance);
//
//        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        driveForward(power);
//
//        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy())
//        {
//
//        }
//        stopDriving();
//        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
//
//}
//    private void driveRightDistance(double power, int distance)
//    {
//        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        fl.setTargetPosition(distance);
//        fr.setTargetPosition(-distance);
//        bl.setTargetPosition(-distance);
//        br.setTargetPosition(distance);
//
//        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        driveRight(power);
//
//        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy())
//        {
//
//        }
//        stopDriving();
//        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
//    private void driveLeftDistance(double power, int distance)
//    {
//        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        fl.setTargetPosition(-distance);
//        fr.setTargetPosition(distance);
//        bl.setTargetPosition(distance);
//        br.setTargetPosition(-distance);
//
//        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        driveLeft(power);
//
//        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy())
//        {
//
//        }
//        stopDriving();
//        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
//    private void driveForward(double power)
//    {
//        fl.setPower(power);
//        fr.setPower(power);
//        bl.setPower(power);
//        br.setPower(power);
//
//    }
//    private void driveRight(double power)
//    {
//        fl.setPower(power);
//        fr.setPower(-power);
//        bl.setPower(-power);
//        br.setPower(power);
//    }
//    private void driveLeft(double power)
//    {
//        fl.setPower(-power);
//        fr.setPower(power);
//        bl.setPower(power);
//        br.setPower(-power);
//    }
//    private void driveForward(double power)
//    {
//        fl.setPower(-power);
//        fr.setPower(-power);
//        bl.setPower(-power);
//        br.setPower(-power);
//
//    }
//    private void stopDriving()
//    {
//        fl.setPower(0);
//        fr.setPower(0);
//        bl.setPower(0);
//        br.setPower(0);
//    }
//    }