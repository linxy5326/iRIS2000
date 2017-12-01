package com.iris.monitor.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MD5UtilsTest {

	@Before
	public void setUp() throws Exception {
		 System.out.println("---begin test---");
	}

	@After
	public void tearDown() throws Exception {
		 System.out.println("---end test---");
	}

	@Test
	public void testgetmd5String() {
		
	String pwd=	MD5Utils.getmd5String("xabg@1808");
	assertEquals("364933eeda3d200fbceb5f5f722b97e4",pwd);
	System.out.println(pwd);
	}

}
