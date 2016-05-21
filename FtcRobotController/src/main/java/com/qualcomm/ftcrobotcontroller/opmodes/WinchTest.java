package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Ameya on 1/17/16.
 */
public class WinchTest extends OpMode{

    DcMotor Winch;
    DcMotor Winch2;

    @Override
    public void init() {
        Winch = hardwareMap.dcMotor.get("Winch");
        Winch2 = hardwareMap.dcMotor.get("Winch2");
    }

    @Override
    public void loop(){

        if (gamepad1.left_trigger > 0){
            Winch.setPower(gamepad1.left_trigger);
        }
        if (gamepad1.right_trigger > 0){
            Winch.setPower(-gamepad1.right_trigger);
        }
    }
}
