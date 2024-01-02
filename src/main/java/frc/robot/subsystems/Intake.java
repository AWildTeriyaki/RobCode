package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    TalonSRX motor10;
    public boolean isSpinning = false;

    public Intake(){
        motor10 = new TalonSRX(10);
    }

    public void setMotors(){
        if(isSpinning){
            motor10.set(TalonSRXControlMode.PercentOutput, 0.5);
        }
        else if(!isSpinning){
            motor10.set(TalonSRXControlMode.PercentOutput, 0);
        }
    }

    public boolean getSpinning(){
        return isSpinning;
    }

    public void toggleSpinning(){
        isSpinning = !isSpinning;
    }

    @Override
    public void periodic(){
        setMotors();
    }


}
