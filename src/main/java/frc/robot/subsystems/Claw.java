package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
  private final Compressor compressor;
  private final DoubleSolenoid claw;

  public Claw() {
    compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    claw = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 0);
  }

  public void openClaw(){
    claw.set(DoubleSolenoid.Value.kForward);
    
  }
  public void closeClaw(){
    claw.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
  }
}