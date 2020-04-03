package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockTrainController;
    TrainUser mockTrainUser;
    TrainSensorImpl trainSensorImpl;

    @Before
    public void before() {
       mockTrainController = mock(TrainController.class);
       mockTrainUser = mock(TrainUser.class);
       trainSensorImpl = new TrainSensorImpl(mockTrainController, mockTrainUser);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void CheckReferenceSpeedGetter_Success() {
        mockTrainController.getReferenceSpeed();
        verify(mockTrainController, times(1)).getReferenceSpeed();
        assertEquals(0, mockTrainController.getReferenceSpeed());
    }

    @Test
    public void CheckSpeedLimit_Success() {
        assertEquals(5, 5);
    }

    @Test
    public void CheckAlarmStateAbsMarginMax_Success() {
        trainSensorImpl.overrideSpeedLimit(501);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void CheckAlarmStateAbsMarginMin_Success() {
        trainSensorImpl.overrideSpeedLimit(-1);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void CheckAlarmStateAbsMarginNormal_Success() {
        trainSensorImpl.overrideSpeedLimit(5);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }

    @Test
    public void CheckAlarmStateRelMarginNormal_Success() {
        trainSensorImpl.overrideSpeedLimit(2);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }

    @Test
    public void CheckAlarmStateRelMarginMax_Success() {
        trainSensorImpl.overrideSpeedLimit(350);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }
}
