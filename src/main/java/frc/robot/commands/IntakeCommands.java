package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class IntakeCommands extends CommandBase{

    Intake intake = new Intake();

    public IntakeCommands(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
     
    }


    @Override
    public void execute(){
        intake.toggle();
        System.out.println("WWWWWWWWWWWWWW");
        intake.setSpeed(0.5);

    }

    @Override
    public void end(boolean interrupted){
        intake.setSpeed(0);
    }

    @Override
    public boolean isFinished(){
        if(intake.getIsSpinning()){
            return true;
        }else if(!intake.getIsSpinning()){
            return false;
        }
        return false;
    }


}

    
