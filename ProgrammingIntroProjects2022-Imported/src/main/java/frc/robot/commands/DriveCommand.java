// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drive;

public class DriveCommand extends CommandBase {
  // creates an EPIC drive command with proper variable naming thanks LUMEN FOR THE EPIC EDITION!!! :D

  public final Drive DriveSubsystem;
  public XboxController controller = new XboxController(0);



  public DriveCommand(Drive drive_Subsystem) {
    DriveSubsystem = drive_Subsystem;
    addRequirements(DriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSubsystem.DrivePower(controller.getLeftY(), controller.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
