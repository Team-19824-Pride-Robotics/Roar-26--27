

package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="JustMechand", group="Linear OpMode")
@Disabled
public class JustMechand extends LinearOpMode {

    // Declare OpMode members.

    private DcMotorEx fly1;
    private DcMotorEx fly2;
    private DcMotor transfer;
    private DcMotor intake;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        fly1  = hardwareMap.get(DcMotorEx.class, "fly1");
        fly2 = hardwareMap.get(DcMotorEx.class, "fly2");
        intake = hardwareMap.get(DcMotor.class, "intake");
        transfer = hardwareMap.get(DcMotor.class, "transfer");

        //Motors may need to be reversed
        fly1.setDirection(DcMotor.Direction.FORWARD);
        fly2.setDirection(DcMotor.Direction.FORWARD);
        transfer.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses START)
        waitForStart();


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

//flywheel velocity
            double flyVelocity = 600;

            //intake
if(gamepad1.a){
    intake.setPower(1);
}else{
    intake.setPower(0);
}
//transfer
            if(gamepad1.b){
                transfer.setPower(1);
            }else{
                transfer.setPower(0);
            }



            //flywheel

            if(gamepad1.right_trigger > 0.1) {
                fly1.setVelocity(flyVelocity);
                fly2.setVelocity(flyVelocity);
            }else{
                fly1.setVelocity(0);
                fly2.setVelocity(0);
            }
            // Show the flywheel velocity.

            telemetry.addData("Flywheel 1 Velocity", fly1.getVelocity());
            telemetry.addData("Flywheel 2 Velocity", fly2.getVelocity());
            telemetry.addData("Velocity", flyVelocity);
            telemetry.update();
        }
    }
}
