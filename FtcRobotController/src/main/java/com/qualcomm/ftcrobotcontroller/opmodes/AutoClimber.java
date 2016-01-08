package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Ameya on 1/2/16.
 */
public class AutoClimber extends LinearOpMode {

    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;
    Servo Dropper;


    @Override
    public void runOpMode() throws InterruptedException {
        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");
        Dropper = hardwareMap.servo.get("Dropper");

        RightBack.setDirection(DcMotor.Direction.REVERSE);
        RightFront.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        RightBack.setPower(0);
        RightFront.setPower(0);
        LeftBack.setPower(1);
        LeftFront.setPower(1);

        sleep(1000);

        RightBack.setPower(1);
        RightFront.setPower(1);
        LeftBack.setPower(1);
        LeftFront.setPower(1);

        sleep(2450);


        RightBack.setPower(1);
        RightFront.setPower(1);
        LeftBack.setPower(0);
        LeftFront.setPower(0);

        sleep(700);

        RightBack.setPower(1);
        RightFront.setPower(1);
        LeftBack.setPower(1);
        LeftFront.setPower(1);

        sleep(200);

        RightBack.setPower(0);
        RightFront.setPower(0);
        LeftBack.setPower(0);
        LeftFront.setPower(0);
        Dropper.setPosition(0.4);

        sleep(3000);

        Dropper.setPosition(0.5);
    }
}
