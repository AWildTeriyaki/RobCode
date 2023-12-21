package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class IntakeCommands extends CommandBase{

    private boolean isSpinning = true;
    Intake intake = new Intake();

    public IntakeCommands(Intake intake){
        this.intake = intake;
        //addRequirements(intake);
    }

    @Override
    public void execute(){
        intake.toggleSpinning();
    }

    public void end(){

    }

    @Override
    public boolean isFinished(){
        return false;
    }


}

    
