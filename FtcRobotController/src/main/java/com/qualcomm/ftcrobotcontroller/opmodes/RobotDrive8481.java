package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/*
  Created by Ameya on 9/12/15.
 */
public class RobotDrive8481 extends OpMode

{
    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;
    DcMotor LinearSlides;
    DcMotor SlidesBack;
    DcMotor SlideAngle;
    DcMotor Intake;
    Servo Movement1;
    Servo Movement2;
    Servo Movement3;
    Servo Stopper;

    @Override
    public void init()
    {
        System.out.println("Robot Drive 8481");
        RightBack = hardwareMap.dcMotor.get("Right_Back");
        RightFront = hardwareMap.dcMotor.get("Right_Front");
        LeftBack = hardwareMap.dcMotor.get("Left_Back");
        LeftFront = hardwareMap.dcMotor.get("Left_Front");
        LinearSlides = hardwareMap.dcMotor.get("Linear_Slides");
        SlidesBack = hardwareMap.dcMotor.get("Slides_Back");
        SlideAngle = hardwareMap.dcMotor.get("Slide_Angle");
        Intake = hardwareMap.dcMotor.get("Intake");
        Movement1 = hardwareMap.servo.get("Movement_1");
        Movement2 = hardwareMap.servo.get("Movement_2");
        Movement3 = hardwareMap.servo.get("Movement_3");
        Stopper = hardwareMap.servo.get("Stopper");
    }

    @Override
    public void loop() {
        float right = -gamepad1.right_stick_y;
        float left = gamepad1.left_stick_y;
        double SlidesAngleL = gamepad1.left_trigger;
        double SlidesAngleR = gamepad1.right_trigger;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);
        SlidesAngleL = Range.clip(SlidesAngleL, 0, 0.15);
        SlidesAngleR = Range.clip(SlidesAngleR, 0, 0.15);

        RightFront.setPower(right);
        RightBack.setPower(right);
        LeftFront.setPower(left);
        LeftBack.setPower(left);

        telemetry.addData("left pwr", String.format("%.2f", left));
        telemetry.addData("right pwr", String.format("%.2f", right));
        telemetry.addData("time", getRuntime());

        if (SlidesAngleL != 0) {
            SlideAngle.setPower(SlidesAngleL);
        }
        else if (SlidesAngleR != 0) {
            SlideAngle.setPower(-SlidesAngleR);
        }
        else {
            SlideAngle.setPower(0.00);
        }

        if (gamepad1.left_bumper) {
            LinearSlides.setPower(0.20);
            SlidesBack.setPower(1.00);
        }
        else if (gamepad1.right_bumper) {
            LinearSlides.setPower(-0.20);
            SlidesBack.setPower(-1.00);
        }
        else {
            LinearSlides.setPower(0.00);
            SlidesBack.setPower(0.00);
        }

        if (gamepad1.a){
            Intake.setPower(-0.60);
            Stopper.setPosition(0.55);
        }
        if (gamepad1.x){
            Intake.setPower(0.70);
        }
        if (gamepad1.b){
            Intake.setPower(0.00);
        }

        if (gamepad1.dpad_right){
            Movement1.setPosition(1.00);
            Movement2.setPosition(1.00);
            Movement3.setPosition(1.00);
        }
        else if (gamepad1.dpad_left){
            Movement1.setPosition(0.00);
            Movement2.setPosition(0.00);
            Movement3.setPosition(0.00);
        }
        else {
            Movement1.setPosition(0.50);
            Movement2.setPosition(0.50);
            Movement3.setPosition(0.50);
        }

        if (gamepad1.dpad_up){
            Stopper.setPosition(0.40);
        }
        if (gamepad1.dpad_down){
            Stopper.setPosition(0.85);
        }
        if (gamepad1.start){
            Stopper.setPosition(0.68);
        }
    }
}