package com.hyz.hex.otp;

import static org.junit.Assert.assertEquals;

import com.hyz.hex.crypto.otp.MOTPTest;
import com.hyz.hex.encoding.EncodingException;
import com.hyz.hex.encoding.Hex;

import org.junit.Test;

public class MotpInfoTest {
    @Test
    public void testMotpInfoOtp() throws OtpInfoException, EncodingException {
        for (MOTPTest.Vector vector : MOTPTest.VECTORS) {
            MotpInfo info = new MotpInfo(Hex.decode(vector.Secret), vector.Pin);
            assertEquals(vector.OTP, info.getOtp(vector.Time));
        }
    }
}
