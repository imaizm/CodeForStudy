package com.example;

import java.nio.charset.Charset;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvocationType;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

public class MyLambdaClient {

	private String awsAccessKeyId;
	private String awsSecretAccessKey;
	
	public MyLambdaClient(
		String awsAccessKeyId,
		String awsSecretAccessKey) {
		this.awsAccessKeyId = awsAccessKeyId;
		this.awsSecretAccessKey = awsSecretAccessKey;
	}
	
	public void invokeLambdaFunction() {
		AWSCredentials credentials =
			new BasicAWSCredentials(
				this.awsAccessKeyId,
				this.awsSecretAccessKey);
		
		String targetFunctionArn =
			"arn:aws:lambda:us-west-2:255118296686:function:code-for-study_java-aws-lambda-01";
		String functionInputJson =
			"{\"firstName\":\"john\", \"lastName\":\"doe\"}";
		InvokeRequest request = new InvokeRequest()
			.withFunctionName(targetFunctionArn)
			.withPayload(functionInputJson);
		
		request.setInvocationType(InvocationType.RequestResponse);
		
		AWSLambda lambda =
			AWSLambdaClientBuilder
				.standard()
				.withRegion(Regions.US_WEST_2)
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
		
		InvokeResult result = lambda.invoke(request);
		String resultJson =
			new String(
				result.getPayload().array(), Charset.forName("UTF-8"));
		
		System.out.println(resultJson);
	}
	
	public static void main(String[] args) {
		
		if (args.length == 2) {
			MyLambdaClient client = new MyLambdaClient(args[0], args[1]);
			client.invokeLambdaFunction();
		} else {
			System.out.println("エラー：引数の指定が間違っています");
		}
	}

}
