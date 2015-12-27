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
    DcMotor Hook;
    DcMotor Catapult;
    Servo Dropper;

    @Override
    public void init() {
        System.out.println("Robot Drive 8481");
        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");
        Hook = hardwareMap.dcMotor.get("Hook");
        Catapult = hardwareMap.dcMotor.get("Catapult");
        Dropper = hardwareMap.servo.get("Dropper");
    }

    @Override
    public void loop() {
        double right = -gamepad1.right_stick_y;
        double left = gamepad1.left_stick_y;
        double HookL = gamepad1.left_trigger;
        double HookR = gamepad1.right_trigger;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1 , 1);

        RightFront.setPower(right);
        RightBack.setPower(right);
        LeftFront.setPower(left);
        LeftBack.setPower(left);

        if (HookL != 0){
            Hook.setPower(HookL);
        }
        else if (HookR != 0){
            Hook.setPower(-HookR);
        }
        else{
            Hook.setPower(0);
        }

        if (gamepad1.left_bumper){
            Catapult.setPower(1);
        }
        else if (gamepad1.right_bumper){
            Catapult.setPower(-1);
        }
        else{
            Catapult.setPower(0);
        }

        if (gamepad1.a){
            Dropper.setPosition(0.4);
        }
        else if (gamepad1.b){
            Dropper.setPosition(0.6);
        }
        else {
            Dropper.setPosition(0.5);
        }
    }
}
