package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Ameya on 10/31/15.
 */
public class Drive_Test extends OpMode {
    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;

    @Override
    public void init() {
        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");
    }
    @Override
    public void loop()
    {

        RightFront.setPower(0.1);
        RightBack.setPower(0.1);
        LeftFront.setPower(0.1);
        LeftBack.setPower(0.1);

        telemetry.addData("time",getRuntime());
    }
}