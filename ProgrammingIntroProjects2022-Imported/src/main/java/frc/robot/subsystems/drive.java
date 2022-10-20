// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
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
    left1 = new WPI_TalonSRX(Constants.kleft1);
    left2 = new WPI_TalonSRX(Constants.kleft2);
    right1 = new WPI_TalonSRX(Constants.kright1);
    right2 = new WPI_TalonSRX(Constants.kright2);


    left1.configOpenloopRamp(ramp,0);
    left2.configOpenloopRamp(ramp,0);
    right1.configOpenloopRamp(ramp,0);
    right2.configOpenloopRamp(ramp,0);

    left1.setNeutralMode(NeutralMode.Coast);
    left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);
    right2.setNeutralMode(NeutralMode.Coast);

    left2.follow(left1);
    right2.follow(right1);



  }

  public void drivepower(double left_power, double right_power) {
    left1.set(left_power);
    right1.set(right_power);
  }

  public void drivestop() {
    drivepower(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
