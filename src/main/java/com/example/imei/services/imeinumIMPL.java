package com.example.imei.services;

import org.springframework.stereotype.Service;

@Service
public class imeinumIMPL implements imeinum {

	 static int sumDig(int n)
	    {
	        int a = 0;
	        while (n > 0)
	        {
	            a = a + n % 10;
	            n = n / 10;
	        }
	        return a;
	    }
	 
	    static String isvalid(long n)
	    {
	        // Converting the number into String
	        // for finding length
	        String s = Long.toString(n);
	        int len = s.length();
	 
	 
	        int sum = 0;
	        for (int i = len; i >= 1; i--)
	        {
	            int d = (int)(n % 10);
	 
	            // Doubling every alternate digit
	            if (i % 2 == 0)
	                d = 2 * d;
	 
	            // Finding sum of the digits
	            sum += sumDig(d);
	            n = n / 10;
	        }
	 
	        if(sum % 10 == 0) {
	        	return "IMEI IS VALID";
	        }
	        
	        else
	        {
	        	return "";
	        }
	    }
	
	@Override
	public String isvalidimei(long n) {
		
		return  isvalid(n);
		
	}

}
