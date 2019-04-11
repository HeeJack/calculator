package com.ljw.calculator;
import org.springframework.stereotype.Service;
@Service
public class Calculator{
	int sum(int a, int b){
		return a+b;
	}
	int sub(int a, int b){
		return a-b;
	}
	int mul(int a, int b){
		return a*b;
	}
	int div(int a, int b){
		if(a != 0){
			return a/b;
		}else{
			return 0;
		}
	}
}
