/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.resource.system.service.util;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class HqlStringCreatorTest {

	@Test
	public void testForResources() {
		String actual;
		String expected;

		actual = HqlStringCreator.forResources(null, null, null, null);
		expected = "select r from Resources r";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", null, null, null);
		expected = "select r from Resources r where r.description=:description";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources(null, "bla", null, null);
		expected = "select r from Resources r where r.filename=:filename";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources(null, null, "400", null);
		expected = "select r from Resources r where r.filesize=:filesize";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources(null, null, null, "jpg");
		expected = "select r from Resources r where r.contentType=:contentType";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", "name", null, null);
		expected = "select r from Resources r where r.description=:description and r.filename=:filename";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", "name", "400", null);
		expected = "select r from Resources r where r.description=:description and r.filename=:filename and r.filesize=:filesize";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", "name", "400", "jpg");
		expected = "select r from Resources r where r.description=:description and r.filename=:filename and r.filesize=:filesize and r.contentType=:contentType";
		AssertJUnit.assertEquals(expected, actual);
	}

}
