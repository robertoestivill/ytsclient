/*
 * Copyright (C) 2015 Roberto Estivill
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yts.module;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import yts.response.YtsResponse;
import yts.response.YtsStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestModuleTest extends ModuleTest {

    @Ignore
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