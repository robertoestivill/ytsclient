package yts.module;

import yts.response.YtsResponse;
import yts.response.YtsStatus;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestModuleTest extends ModuleTest {

    @Test
    public void testCreateSuccess() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("request_message", "This is a testing request, please disregard");

        YtsResponse response = CLIENT.requests()
                .create(APPLICATION_KEY,
                        USER_KEY,
                        "Test movie Title",
                        options);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
    }
}