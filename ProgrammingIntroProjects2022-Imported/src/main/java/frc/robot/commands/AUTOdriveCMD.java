// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive;
import edu.wpi.first.wpilibj.Timer;

public class AUTOdriveCMD extends CommandBase {
  /** Creates a new AUTOdriveCMD. */
  public final drive DriveSubsystem;
  public Timer TimerSubsystem;
  boolean commandDone;
  
  public AUTOdriveCMD(drive drive_subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    DriveSubsystem = drive_subsystem;
    addRequirements(DriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    TimerSubsystem = new Timer();
    TimerSubsystem.reset();
    TimerSubsystem.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (TimerSubsystem.get()< 5) {
      DriveSubsystem.drivepower(0.75, -0.75);
    } else {
      DriveSubsystem.drivestop();
      TimerSubsystem.stop();
      commandDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return commandDone;
  }
}
