package com.wyz.manage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.CDATASection;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class ManageApplicationTests {
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}

	@Test
	void getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}

}
