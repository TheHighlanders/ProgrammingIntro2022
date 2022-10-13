/** Copyright (c) FIRST and other WPILib contributors.
Open Source Software; you can modify and/or share it under the terms of
the WPILib BSD license file in the root directory of this project. */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  /** Creates a new drive. */

  // SUPER EPIC CODE BY LUMEN!!!! :D EPIC AWESOME GAMING EDITION EPIC EDITION

  public WPI_TalonSRX left0;
  public WPI_TalonSRX left1;
  public WPI_TalonSRX right0;
  public WPI_TalonSRX right1;

  double ramp = 0.2;

  public Drive() {
    left0 = new WPI_TalonSRX(Constants.constLeft0);
    left1 = new WPI_TalonSRX(Constants.constLeft1);
    right0 = new WPI_TalonSRX(Constants.constRight0);
    right1 = new WPI_TalonSRX(Constants.constRight1);

    left0.configOpenloopRamp(ramp, 0);
    left1.configOpenloopRamp(ramp, 0);
    right0.configOpenloopRamp(ramp, 0);
    right1.configOpenloopRamp(ramp, 0);

    left0.setNeutralMode(NeutralMode.Coast);
    left1.setNeutralMode(NeutralMode.Coast);
    right0.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);
    
    left1.follow(left0);
    right1.follow(right0);
  }

  public void DrivePower(double leftPower, double rightPower) {
    left0.set(leftPower);
    right0.set(rightPower);
  }

  public void DriveStop() {
    DrivePower(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
