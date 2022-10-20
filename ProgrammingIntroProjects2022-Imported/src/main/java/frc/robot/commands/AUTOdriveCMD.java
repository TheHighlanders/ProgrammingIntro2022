// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.fasterxml.jackson.databind.node.DoubleNode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive;

public class AUTOdriveCMD extends CommandBase {
  public final drive driveSubsystem;
  public Timer timerSubsystem;

  private boolean done;


  /** Creates a new AUTOdriveCMD. */
  public AUTOdriveCMD(drive drive_subsystem) {
    driveSubsystem = drive_subsystem;
    addRequirements(driveSubsystem);

    done = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timerSubsystem = new Timer();
    timerSubsystem.reset();
    timerSubsystem.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timerSubsystem.get() < 5.0) {
        driveSubsystem.drivepower(0.75, -0.75);
    }
    else {
        driveSubsystem.drivestop();
        timerSubsystem.stop();
        done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
