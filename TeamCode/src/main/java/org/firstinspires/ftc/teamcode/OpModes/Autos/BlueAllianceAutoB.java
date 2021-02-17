package org.firstinspires.ftc.teamcode.OpModes.Autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class BlueAllianceAutoB extends LinearOpMode {
    DcMotor fl = null;
    DcMotor fr = null;
    DcMotor bl = null;
    DcMotor br = null;
    Servo servo = null;
    double WHEELCIRCUMFERENCE = 301.59;//mm
    double ENCODERTICKS = 134.4;
    double GEARRATIO = 1;
    double TICKSTOMMTRAVELED= (WHEELCIRCUMFERENCE/ENCODERTICKS) * GEARRATIO;



    public void runOpMode() {
        fl = hardwareMap.dcMotor.get("front_left_motor");
        fr = hardwareMap.dcMotor.get("front_right_motor");
        bl = hardwareMap.dcMotor.get("back_left_motor");
        br = hardwareMap.dcMotor.get("back_right_motor");
        servo = hardwareMap.servo.get("back_servo");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);

        servo.setPosition(.0);

        waitForStart();
        //push wobble goal forward
        driveForwardDistance(0.5, (int) x/TICKSTOMMTRAVELED);
        //push wobble goal into box
        driveRightDistance(0.5, (int) x/TICKSTOMMTRAVELED);
        //drive back to line
        driveBackDistance(0.5, (int) x/TICKSTOMMTRAVELED);
        //drive infront of first target
        driveRightDistance(0.5, (int) x/TICKSTOMMTRAVELED);
        //shoot
        //drive infront of second target
        driveRightDistance(0.5, (int) x/TICKSTOMMTRAVELED);
        //shoot
        //drive infront of third target
        driveRightDistance(0.5, (int) x/TICKSTOMMTRAVELED);
        //shoot
        //park on line
        driveForwardDistance(0.5, (int) x/TICKSTOMMTRAVELED);


    }

    private void driveForwardDistance(double power, int distance){
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setTargetPosition(distance);
        fr.setTargetPosition(distance);
        bl.setTargetPosition(distance);
        br.setTargetPosition(distance);

        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        driveForward(power);

        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy()) {
        }

        stopDriving();
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void driveBackDistance(double power, int distance){
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setTargetPosition(-distance);
        fr.setTargetPosition(-distance);
        bl.setTargetPosition(-distance);
        br.setTargetPosition(-distance);

        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        driveBack(power);

        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy())
        {

        }
        stopDriving();
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void driveLeftDistance(double power, int distance){
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setTargetPosition(-distance);
        fr.setTargetPosition(distance);
        bl.setTargetPosition(distance);
        br.setTargetPosition(-distance);

        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        driveLeft(power);

        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy())
        {

        }
        stopDriving();
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void driveRightDistance(double power, int distance){
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setTargetPosition(distance);
        fr.setTargetPosition(-distance);
        bl.setTargetPosition(-distance);
        br.setTargetPosition(distance);

        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        driveRight(power);

        while(fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy())
        {

        }
        stopDriving();
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void driveForward(double power) {
        fl.setPower(power);
        fr.setPower(power);
        bl.setPower(power);
        br.setPower(power);
    }
    private void driveBack(double power){
        fl.setPower(-power);
        fr.setPower(-power);
        bl.setPower(-power);
        br.setPower(-power);
    }
    private void driveRight(double power) {
        fl.setPower(power);
        fr.setPower(-power);
        bl.setPower(-power);
        br.setPower(power);
    }
    private void driveLeft(double power) {
        fl.setPower(-power);
        fr.setPower(power);
        bl.setPower(power);
        br.setPower(-power);
    }
    private void stopDriving() {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
    }
    private void turnLeft(double power) {
        fl.setPower(-power);
        fr.setPower(power);
        bl.setPower(-power);
        br.setPower(power);
    }
    private void turnRight(double power) {
        fl.setPower(power);
        fr.setPower(-power);
        bl.setPower(power);
        br.setPower(-power);
    }
}

