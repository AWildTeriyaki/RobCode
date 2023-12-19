package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends SubsystemBase{
    
    TalonSRX motor4;
    TalonSRX motor5;

    public Arm (){
        motor4 = new TalonSRX(4);
        motor5 = new TalonSRX(5);
    }

    public void setMotors(int goal, double potPos){
        while(potPos != goal){
            motor4.set(TalonSRXControlMode.PercentOutput, 0.5);
            motor5.set(TalonSRXControlMode.PercentOutput, 0.5);
        }
    }

}
