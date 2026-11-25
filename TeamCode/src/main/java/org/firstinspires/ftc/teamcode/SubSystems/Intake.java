package org.firstinspires.ftc.teamcode.SubSystems;

public class Intake {

package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.config.Config;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Hardware.RobotHardware;

    @Config
    public class Intake extends SubsystemBase {
        public static double power_intake = 0.9;
        public static double power_transfer = 0.9;
        private final RobotHardware robot = RobotHardware.getInstance();
        private IntakeState currentIntakeState = IntakeState.IDLE;
        private Stage2State currentStage2State = Stage2State.IDLE;

        public enum Stage2State {
            IDLE,
            FORWARD,
            REVERSE,
        }

        public enum IntakeState {
            IDLE,
            FORWARD,
            REVERSE,
        }

        public void setIntakeState(IntakeState state) {
            currentIntakeState = state;
        }

        public void setStage2State(Stage2State state) {
            currentStage2State = state;
        }

        public void setBothStates(IntakeState stateIntake, Stage2State stateStage2) {
            currentIntakeState = stateIntake;
            currentStage2State = stateStage2;
        }

        public void updateIntakeState() {
            switch (currentIntakeState) {
                case IDLE:
                    robot.IntakeMotor.set(0);
                    break;
                case FORWARD:
                    robot.IntakeMotor.set(power_intake);
                    break;
                case REVERSE:
                    robot.IntakeMotor.set(-power_intake);
                    break;
            }
        }

        public void updateStage2State() {
            switch (currentStage2State) {
                case IDLE:
                    robot.TransferMotor.set(0);
                    break;
                case FORWARD:
                    robot.TransferMotor.set(power_transfer);
                    break;
                case REVERSE:
                    robot.TransferMotor.set(-power_transfer);
                    break;
            }

        }


        @Override
        public void periodic() {
            updateIntakeState();
            updateStage2State();
        }
    }

}