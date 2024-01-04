package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    TalonSRX motor10;
    public static boolean isSpinning = false;
    public static boolean checkDirection = true;

    public Intake(){
        motor10 = new TalonSRX(10);
    }

    public void setIsSpinning(boolean spin){
        isSpinning = spin;
    }

    public void toggle(){
        isSpinning = !isSpinning;
    }

    public void makeDirectionTrue(){
        checkDirection = true;
    }

    public void makeDirectionFalse(){
        checkDirection = false;
    }

    public boolean getIsSpinning(){
        return isSpinning;
    }



    @Override
    public void periodic(){
        System.out.println(isSpinning && checkDirection);
        if(isSpinning == true){
            motor10.set(TalonSRXControlMode.PercentOutput , -0.5);
        }else if(isSpinning && !checkDirection){
            motor10.set(TalonSRXControlMode.PercentOutput , 0.5);
        }else{
            motor10.set(TalonSRXControlMode.PercentOutput , 0);
        }
    }


}
