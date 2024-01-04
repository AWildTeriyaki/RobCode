package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtenderCMD extends CommandBase {
  private final Extender extender;
  private boolean isOpen = true;

  public ExtenderCMD(Extender extender) {
    this.extender = extender;
    addRequirements(extender);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    if(isOpen){
      extender.forward();
    }
    else{
      extender.backward();
    }
    isOpen = !isOpen;
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}