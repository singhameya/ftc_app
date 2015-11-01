package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Ameya on 9/12/15.
 */
public class RobotDrive8481 extends OpMode

{
    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;
    DcMotor LinearSlides;
    DcMotor Intake;
    int LinearSlide = 1;

    @Override
    public void init()
    {
        System.out.println("Robot Drive 8481");
        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");
        LinearSlides = hardwareMap.dcMotor.get("Linear_Slides");
        Intake = hardwareMap.dcMotor.get("Intake");
    }

    @Override
    public void loop() {
        float right = -gamepad1.right_stick_y;
        float left = gamepad1.left_stick_y;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

        RightFront.setPower(right);
        RightBack.setPower(right);
        LeftFront.setPower(left);
        LeftBack.setPower(left);

        System.out.println("right power is " + right);
        System.out.println("left power is " + left);

        telemetry.addData("left pwr", String.format("%.2f", left));
        telemetry.addData("right pwr", String.format("%.2f", right));
        telemetry.addData("time", getRuntime());

        if (gamepad1.left_bumper) {
            LinearSlides.setPower(.8);
        }
        else{
            LinearSlides.setPower(0);
        }
        if (gamepad1.left_trigger > 0){
            LinearSlides.setPower(-gamepad1.left_trigger);
        }
        else{
            LinearSlides.setPower(0);
        }
        if (gamepad1.a){
            Intake.setPower(1);
        }
        if (gamepad1.b){
            Intake.setPower(0);
        }
    }
}
