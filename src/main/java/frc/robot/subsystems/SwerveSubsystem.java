// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.SwerveConstants.*;

import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveSubsystem extends SubsystemBase {
  private SwerveModule flModule = new SwerveModule(kFlDrive, kFlTurn, kFlEncoder, kFlOffset);
  private SwerveModule frModule = new SwerveModule(kFrDrive, kFrTurn, kFrEncoder, kFrOffset);
  private SwerveModule blModule = new SwerveModule(kBlDrive, kBlTurn, kBlEncoder, kBlOffset);
  private SwerveModule brModule = new SwerveModule(kBrDrive, kBrTurn, kBrEncoder, kBrOffset);


  /*private double rot;

  public void setRot(double in) {
    rot -= in;
  }

  public Rotation2d getRot() {
    return Rotation2d.fromDegrees(rot);
  }

  private Pigeon2 gyro = new Pigeon2(8); */

  public SwerveSubsystem() {
    /*new Thread(() -> {
      try {
        Thread.sleep(1000);
        resetHeading();
      } catch (Exception e) {}}
    ).start();*/
  }

  /*public void resetHeading() {
    gyro.reset();
  }

  public double getHeading() {
    return IEEEremainder(gyro.getAngle(), 360);
  }

  public Rotation2d getRot2d() {
    return Rotation2d.fromDegrees(getHeading());
  }*/

  public void stopModules() {
    flModule.stop();
    frModule.stop();
    blModule.stop();
    brModule.stop();
  }

  public void setModuleStates(SwerveModuleState[] states) {
    SwerveDriveKinematics.desaturateWheelSpeeds(states, kMaxMeterPerSec);
    blModule.setState(states[0]);
    brModule.setState(states[1]);
    flModule.setState(states[2]);
    frModule.setState(states[3]);
  }

  @Override
  public void periodic() {
    //double rotation = rot;
    SmartDashboard.putNumber("flDesired", flModule.current.angle.getRadians());
    SmartDashboard.putNumber("flCUrrent", flModule.getTurnPosition());
    SmartDashboard.putNumber("flPid", flModule.pidOut);
  }
}
