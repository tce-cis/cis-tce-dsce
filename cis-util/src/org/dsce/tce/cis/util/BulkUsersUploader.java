package org.dsce.tce.cis.util;

import java.io.IOException;

public class BulkUsersUploader {

	private JDBCUtil jdbcUtil;

	public BulkUsersUploader() {
		jdbcUtil = new JDBCUtil();
	}

	public static void main(String[] args) throws IOException {
		BulkUsersUploader bulkUsersUploader = new BulkUsersUploader();
		bulkUsersUploader.jdbcUtil.populateAuthenticatedUsers();
	}

}
