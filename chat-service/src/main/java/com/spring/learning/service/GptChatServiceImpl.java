package com.spring.learning.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GptChatServiceImpl implements ChatService{

	@Autowired
	private OpenAiChatModel chatModel;
	
	private RestTemplate restTemplate=new RestTemplate();
	private final String zipkinApiUrl="http://localhost:9411/api/v2/traces";
	private final String prometheusApiUrl="http://localhost:9090/api/v1/query?query=up";
	
	@Override
	public String askQuestionWithContext(String question) {
		String zipkinTraces=fetchZipkinTraces();
		String prometheusMetrics=fetchPrometheusMetrics();
		String context="""
				you are an observability assistant. here is the current state of the system:
				zipkin traces:
				%s
				
				prometheus metrics:
				%s
				
				based on this information, answer the following question:
				%s
				""".formatted(zipkinTraces, prometheusMetrics, question);
		return chatModel.call(context);
	}

	public String fetchZipkinTraces() {
		try {
			return restTemplate.getForObject(zipkinApiUrl, String.class);
		}
		catch(Exception e) {
			return "Failed to fetch zipkin traces: "+e.getMessage();
		}
	}
	public String fetchPrometheusMetrics() {
		try {
			return restTemplate.getForObject(prometheusApiUrl, String.class);
		}
		catch(Exception e) {
			return "Failed to fetch prometheus metrics: "+e.getMessage();
		}
	}
}
