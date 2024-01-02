package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    TalonSRX motor10;
    public double speed;
    public boolean isSpinning = true;

    public Intake(){
        motor10 = new TalonSRX(10);
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setIsSpinning(boolean spin){
        isSpinning = spin;
    }

    public void toggle(){
        isSpinning = !isSpinning;
    }

    public boolean getIsSpinning(){
        return isSpinning;
    }


    public void setMotors(){
        motor10.set(TalonSRXControlMode.PercentOutput, speed);
    }

    @Override
    public void periodic(){
        setMotors();
    }


}
