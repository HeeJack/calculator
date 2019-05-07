package com.ljw.calculator;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/**
 * This is Calculator Service Class
 * @author heejack
 */
@Service
public class Calculator{
	@Cacheable("sum")
	int sum(int a, int b){
		return a+b;
	}
	@Cacheable("sub")
	int sub(int a, int b){
		return a-b;
	}
	@Cacheable("mul")
	int mul(int a, int b){
		return a*b;
	}
	@Cacheable("div")
	int div(int a, int b){
		if(a != 0){
			return a/b;
		}else{
			return 0;
		}
	}
}
