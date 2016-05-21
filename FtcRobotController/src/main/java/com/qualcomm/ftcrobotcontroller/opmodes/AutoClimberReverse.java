package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Ameya on 1/2/16.
 */
public class AutoClimberReverse extends LinearOpMode {

    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;
    Servo Dropper;
    Servo lSide;
    Servo rSide;


    @Override
    public void runOpMode() throws InterruptedException {
        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");
        Dropper = hardwareMap.servo.get("Dropper");
        lSide = hardwareMap.servo.get("lSide");
        rSide = hardwareMap.servo.get("rSide");

        RightBack.setDirection(DcMotor.Direction.REVERSE);
        RightFront.setDirection(DcMotor.Direction.REVERSE);

        Dropper.setPosition(0.5);
        lSide.setPosition(0.5);
        rSide.setPosition(0.5);

        waitForStart();

        RightBack.setPower(1);
        RightFront.setPower(1);
        LeftBack.setPower(1);
        LeftFront.setPower(1);

        sleep(300);

        RightBack.setPower(0.5);
        RightFront.setPower(0.7);
        LeftBack.setPower(0);
        LeftFront.setPower(0);

        sleep(650);

        RightBack.setPower(0.60);
        RightFront.setPower(0.60);
        LeftBack.setPower(0.60);
        LeftFront.setPower(0.60);

        sleep(2450);

        RightBack.setPower(0.7);
        RightFront.setPower(0.7);
        LeftBack.setPower(0);
        LeftFront.setPower(0);

        sleep(2075);

        RightBack.setPower(0);
        RightFront.setPower(0);
        LeftBack.setPower(0);
        LeftFront.setPower(0);

        Dropper.setPosition(0.2);

        sleep(3000);

        Dropper.setPosition(0.7);

        sleep(3000);

        Dropper.setPosition(0.5);
    }
}
