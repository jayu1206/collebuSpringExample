package com.springboot.sqs;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SQSConfig {
	
	 @Value("https://sqs.us-east-2.amazonaws.com/061651292589")
	 private String endpoint = "https://sqs.us-east-2.amazonaws.com/061651292589";
	 
	 @Value("standard")
	 private String queueName = "standard";
	 
	 @Bean
	 public AmazonSQSClient createSQSClient() {
		 
		 AmazonSQSClient amazonSQSClient = new AmazonSQSClient(new BasicAWSCredentials("",""));
		 amazonSQSClient.setEndpoint(endpoint);
		 amazonSQSClient.createQueue(queueName);
		 return amazonSQSClient;
		 
	 }
}