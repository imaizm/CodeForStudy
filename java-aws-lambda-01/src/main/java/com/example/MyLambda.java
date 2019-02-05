package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyLambda implements RequestHandler<MyLambdaInput, MyLambdaOutput> {

	@Override
	public MyLambdaOutput handleRequest(MyLambdaInput input, Context context) {

		final MyLambdaOutput out = new MyLambdaOutput();
		out.in = input;
		out.fullName = input.lastName + ", " + input.firstName; 
		
		return out;
	}
}
