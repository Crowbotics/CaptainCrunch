// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Dumpy;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Autonomous extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem m_drive;
  private final Dumpy m_intake; 
  private final double m_distance;
  private final double m_speed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Autonomous(double inches, double speed, DrivetrainSubsystem drive, Dumpy intake) {
    m_distance = inches;
    m_speed = speed;
    m_drive = drive; 
    m_intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
    addRequirements(m_intake);


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   // m_drive.resetEncoders(); 
    m_drive.arcadeDrive(m_speed, 0);
   
    m_intake.run_front_intake(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_speed, 0);
    m_intake.run_front_intake(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   // return Math.abs(m_drive.getAverageEncoderDistance()) >= m_distance;
   return Timer.getMatchTime() < 12;
  } 
}
