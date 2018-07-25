package com.hackathon.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.hackathon.restws.exceptions.RewardBusinessException;

@Provider
public class RewardBusinessExceptionMapper implements ExceptionMapper<RewardBusinessException> {

	@Override
	public Response toResponse(RewardBusinessException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"Try Again Later\"");
		sb.append("}");

		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
