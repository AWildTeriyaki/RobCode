package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class IntakeCommands extends CommandBase{

    private boolean isSpinning = false;
    Intake intake = new Intake();

    public IntakeCommands(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute(){
        intake.toggleSpinning();
        isSpinning = !isSpinning;
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        if(isSpinning){
            return false;
        }else if(!isSpinning){
            return true;
        }
        return true;
    }


}

    
