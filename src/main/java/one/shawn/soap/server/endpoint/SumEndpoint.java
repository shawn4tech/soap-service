package one.shawn.soap.server.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import one.shawn.soap.server.model.ObjectFactory;
import one.shawn.soap.server.model.Operands;
import one.shawn.soap.server.model.Result;

@Endpoint
public class SumEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SumEndpoint.class);

	@PayloadRoot(namespace = "http://shawn.one/types/sum", localPart = "operands")
	@ResponsePayload
	public Result sayHello(@RequestPayload Operands request) {
		LOGGER.info("Endpoint received operands = [firstNum = {},secondNum = {}]", request.getFirstNum(),
				request.getSecondNum());

		ObjectFactory factory = new ObjectFactory();
		Result response = factory.createResult();
		response.setSum(request.getFirstNum() + request.getSecondNum());

		LOGGER.info("Endpoint sending result = {}", response.getSum());
		return response;
	}

}
