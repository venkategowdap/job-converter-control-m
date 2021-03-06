/*
 * Copyright 2011 Vincent Behar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rundeck.api.parser;

import java.io.InputStream;
import org.dom4j.Document;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the {@link StringParser}
 * 
 * @author Vincent Behar
 */
public class StringParserTest {

    @Test
    public void parseJob() throws Exception {
        InputStream input = getClass().getResourceAsStream("message.xml");
        Document document = ParserHelper.loadDocument(input);

        String message = new StringParser("result/success/message").parseXmlNode(document);

        Assert.assertEquals("Job was successfully deleted: [1] /job-name", message);
    }

}
