package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Ameya on 12/5/15.
 */
public class Auto8481_2 extends LinearOpMode{

    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;

    @Override
    public void runOpMode() throws InterruptedException {

        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");

        waitForStart();

        while (opModeIsActive()) {
            RightBack.setPower(-1);
            RightFront.setPower(-1);
            LeftBack.setPower(1);
            LeftFront.setPower(1);

            sleep(2000);

            RightBack.setPower(0);
            RightFront.setPower(0);
            LeftBack.setPower(1);
            LeftFront.setPower(1);

            sleep(600);

            RightBack.setPower(-1);
            RightFront.setPower(-1);
            LeftBack.setPower(1);
            LeftFront.setPower(1);

            sleep(10000);
        }
    }
}
