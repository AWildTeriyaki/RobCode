package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Potentiometer;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.ProfiledPIDController;

public class ArmCommand extends CommandBase{
    Arm arm = new Arm();
    Potentiometer pot;
    Supplier<Double> joystick;
    double targetPos;
    double kDt;
    ProfiledPIDController mController;
    TrapezoidProfile.Constraints m_constraints;

    public ArmCommand(Arm arm, Potentiometer pot, Supplier<Double> joystick) {
        this.arm = arm;
        this.pot = pot;
        this.joystick = joystick;
        this.targetPos = -10;
        this.kDt = 0.5;
        this.m_constraints = new TrapezoidProfile.Constraints(1, 1);
        this.mController = new ProfiledPIDController(0.5, 0.0, 0.0, m_constraints, kDt);
        addRequirements(arm);
    }

    public void initialize(){
        System.out.print("SJIHUDVUGSHI");
        arm.setMotors(100 , mController.calculate(pot.readPot()));
    }

    @Override
    public void execute() {

        //private final Joystick m_joystick = new Joystick(1);
        //private final Encoder m_encoder = new Encoder(1, 2);

        // Create a PID controller whose setpoint's change is subject to maximum
        // velocity and acceleration constraints.
        
        
       
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished() {
        return false;
    }
}