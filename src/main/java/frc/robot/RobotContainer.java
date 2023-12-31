// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Extender;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Joystick joystick = new Joystick(OperatorConstants.kDriverControllerPort);
  public final Drivetrain rob = new Drivetrain();
  private final Claw claw = new Claw();
  private final Extender extender = new Extender();
  public final Intake intake = new Intake();



  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    rob.setDefaultCommand(new JoystickCMD(
      rob,
      () -> joystick.getRawAxis(0),
      () -> joystick.getRawAxis(1)
    ));

    
    
    
  
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    ClawCMD open = new ClawCMD(claw);
    IntakeCommands toggle = new IntakeCommands(intake);
    ExtenderCMD extend = new ExtenderCMD(extender);
    OutakeCommands outtake = new OutakeCommands(intake);
    new JoystickButton(joystick, 1).toggleOnTrue(open);//Button LB
    new JoystickButton(joystick, 2).toggleOnTrue(toggle);
    new JoystickButton(joystick, 3).toggleOnTrue(extend);
    new JoystickButton(joystick, 4).toggleOnTrue(outtake);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
