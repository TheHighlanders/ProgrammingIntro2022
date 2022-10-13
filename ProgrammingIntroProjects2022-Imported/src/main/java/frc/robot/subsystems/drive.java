// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drive extends SubsystemBase {
  /** Creates a new drive. */
  public WPI_TalonSRX left1;
  public WPI_TalonSRX left2;
  public WPI_TalonSRX right1;
  public WPI_TalonSRX right2;

  double ramp = 0.2;



  public drive() {
    left1 = new WPI_TalonSRX(Constants.kLeft1);
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
