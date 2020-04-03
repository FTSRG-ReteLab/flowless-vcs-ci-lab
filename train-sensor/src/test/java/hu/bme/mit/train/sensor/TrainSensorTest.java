package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import javax.swing.undo.AbstractUndoableEdit;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    public TrainController tc;
    public TrainUser tu;
    public TrainSensorImpl ts;


    @Before
    public void before() {
        tc = Mockito.mock(TrainController.class);
        tu = Mockito.mock(TrainUser.class);
        ts = new TrainSensorImpl(tc, tu);
    }

    @Test
    public void BetweenMargins()
    {
        ts.overrideSpeedLimit(400);
        verify(tu, times(0)).setAlarmState(false);
    }
    @Test
    public void AbsMinMargin() {
        ts.overrideSpeedLimit(-1);
        verify(tu, times(1)).setAlarmState(true);
    }
    @Test
    public void AbsMaxMargin() {
        ts.overrideSpeedLimit(501);
        verify(tu, times(1)).setAlarmState(true);
    }
    @Test
    public void RelMargin() {
        ts.overrideSpeedLimit(1);
        verify(tu, times(0)).setAlarmState(true);
    }


}
