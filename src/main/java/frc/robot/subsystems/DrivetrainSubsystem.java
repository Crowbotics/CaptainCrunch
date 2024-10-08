
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    private WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(1);
    private WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(2);
    private DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    
    public DrivetrainSubsystem()
    {
     m_rightMotor.setInverted(true);   
    }

    public void arcadeDrive(double speed, double rotation)
    {
        m_drive.arcadeDrive(speed, rotation);
    }

}
