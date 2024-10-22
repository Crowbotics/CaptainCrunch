
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Dumpy extends SubsystemBase {

private CANSparkMax intake = new CANSparkMax(3, MotorType.kBrushed);

    
    public Dumpy()
    {
        intake.setInverted(true);
    }

public void run_front_intake(double trigger){
    intake.set(trigger*1); 
}
public void run_back_intake(double trigger){
    intake.set(-trigger*1); 
}
public void stop_intake(){
    intake.set(0);
}
}
 

    


