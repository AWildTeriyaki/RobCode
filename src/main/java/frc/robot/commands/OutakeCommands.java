package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class OutakeCommands extends CommandBase{
    private boolean previous;    
    Intake intake = new Intake();

    public OutakeCommands(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
     
    }


    @Override
    public void execute(){
        previous = intake.getIsSpinning();
        intake.toggle();
    }

    @Override
    public void end(boolean interrupted){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        intake.makeDirectionFalse();
    }

    @Override
    public boolean isFinished(){
        System.out.println(previous);
        System.out.println(intake.getIsSpinning());
        System.out.println("WWWWWWWWWWWWWW");
        return previous != intake.getIsSpinning();
    }


}

    
