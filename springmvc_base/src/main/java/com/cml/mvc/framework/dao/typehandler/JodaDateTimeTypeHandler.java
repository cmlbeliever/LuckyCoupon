package com.cml.mvc.framework.dao.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;

public class JodaDateTimeTypeHandler implements TypeHandler<DateTime> {

	@Override
	public void setParameter(PreparedStatement ps, int i, DateTime parameter,
			JdbcType jdbcType) throws SQLException {

		java.sql.Timestamp timestamp = null;

		if (parameter != null) {
			timestamp = new java.sql.Timestamp(parameter.getMillis());
		}

		ps.setTimestamp(i, timestamp);

	}

	@Override
	public DateTime getResult(ResultSet rs, String columnName)
			throws SQLException {

		Object o = rs.getObject(columnName);

		if (rs.wasNull()) {
			return null;
		}

		if (o instanceof Date || o instanceof String) {
			return new DateTime(o);
		} else {
			return null;
		}

	}

	@Override
	public DateTime getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		
		Object o = cs.getObject(columnIndex);

		if (cs.wasNull()) {
			return null;
		}

		if (o instanceof Date || o instanceof String) {
			return new DateTime(o);
		} else if (o instanceof java.sql.Timestamp) {
			java.sql.Timestamp t = (java.sql.Timestamp) o;
			return new DateTime(t.getTime());
		} else {
			return null;
		}

	}

	@Override
	public DateTime getResult(ResultSet rs, int columnIndex)
			throws SQLException {
		Object o = rs.getObject(columnIndex);

		if (rs.wasNull()) {
			return null;
		}

		if (o instanceof Date || o instanceof String) {
			return new DateTime(o);
		} else {
			return null;
		}
	}

}
