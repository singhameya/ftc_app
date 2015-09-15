package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Ameya on 9/12/15.
 */
public class RobotDrive8481 extends OpMode

{
    DcMotor motorRightFront;
    DcMotor motorRightBack;
    DcMotor motorLeftFront;
    DcMotor motorLeftBack;

    public RobotDrive8481
    {

    }

    @Override
    public void init()
    {
        motorRightBack = hardwareMap.dcMotor.get("Right_Back");
        motorRightFront = hardwareMap.dcMotor.get("Right_Front");
        motorLeftBack = hardwareMap.dcMotor.get("Left_Back");
        motorLeftFront = hardwareMap.dcMotor.get("Left_Front");
    }

    @Override
    public void loop()
    {

    }


}
