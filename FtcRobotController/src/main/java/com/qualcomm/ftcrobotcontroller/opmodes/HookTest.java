package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Ameya on 12/20/15.
 */
public class HookTest extends OpMode {

    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;
    DcMotor Winch;
    DcMotor Winch2;
    DcMotor Catapult;
    Servo Dropper;
    Servo lSide;
    Servo rSide;

    @Override
    public void init() {
        System.out.println("Robot Drive 8481");
        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");
        Winch = hardwareMap.dcMotor.get("Winch");
        Winch2 = hardwareMap.dcMotor.get("Winch2");
        Catapult = hardwareMap.dcMotor.get("Catapult");
        Dropper = hardwareMap.servo.get("Dropper");
        lSide = hardwareMap.servo.get("lSide");
        rSide = hardwareMap.servo.get("rSide");

        RightBack.setDirection(DcMotor.Direction.REVERSE);
        RightFront.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        double right = gamepad1.right_stick_y;
        double left = gamepad1.left_stick_y;
        double WinchL = gamepad1.right_trigger;
        double WinchR = gamepad1.left_trigger;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1 , 1);

        RightFront.setPower(right);
        RightBack.setPower(right);
        LeftFront.setPower(left);
        LeftBack.setPower(left);

        if (WinchL < 0.50){
            WinchL = Range.clip(WinchL, -0.25, 0.25);
        }
        if (WinchR < 0.50){
            WinchR = Range.clip(WinchR, -0.25, 0.25);
        }

        if (WinchL != 0){
            Winch.setPower(WinchL);
            Winch2.setPower(-WinchL);
        }
        else if (WinchR != 0){
            Winch.setPower(-WinchR);
            Winch2.setPower(WinchR);
        }
        else{
            Winch.setPower(0);
            Winch2.setPower(0);
        }

        if (gamepad1.right_bumper){
            Catapult.setPower(0.5);
        }
        else if (gamepad1.left_bumper){
            Catapult.setPower(-0.5);
        }
        else{
            Catapult.setPower(0);
        }

        if (gamepad1.b){
            Dropper.setPosition(0.3);
        }
        else if (gamepad1.x){
            Dropper.setPosition(0.7);
        }
        else {
            Dropper.setPosition(0.5);
        }

        if (gamepad1.a){
            rSide.setPosition(0.6);
        }
        else if (gamepad1.y){
            rSide.setPosition(0.4);
        }
        else{
            rSide.setPosition(0.5);
        }

        if (gamepad1.dpad_up){
            lSide.setPosition(0.6);
        }
        else if (gamepad1.dpad_down){
            lSide.setPosition(0.4);
        }
        else{
            lSide.setPosition(0.5);
        }
    }
}
