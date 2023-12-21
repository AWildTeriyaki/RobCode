package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    TalonSRX motor10;
    public boolean isSpinning = true;

    public Intake(){
        motor10 = new TalonSRX(10);
    }

    public void setMotors(){
        if(isSpinning){
            motor10.set(TalonSRXControlMode.PercentOutput, 0.5);
        }

        else{
            motor10.set(TalonSRXControlMode.PercentOutput, 0);
        }
    }

    public void toggleSpinning(){
        isSpinning = !isSpinning;
    }

    @Override
    public void periodic(){
        if(isSpinning){
            System.out.println("set to 0.5");
            motor10.set(TalonSRXControlMode.PercentOutput, 0.5);
        }

        else{
            System.out.println("set to 0");
            motor10.set(TalonSRXControlMode.PercentOutput, 0);
        }
    }


}
