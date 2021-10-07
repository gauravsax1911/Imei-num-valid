package com.example.imei.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.imei.entity.entity;



@RestController
@RequestMapping("/imei")
public class Mycontrollers {


	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.POST)
     public String isVALID(@RequestBody entity num)
	{
		String x = num.imeinumber;
		
		String ans = isvalidimei(Long.parseLong(x));
				
//		entity res = new entity(ans);
//		return res;
		return ans;
     
	}
	
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
        int lastdigit = (int)(n%10);
        String ans = "";
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
        	sum -= lastdigit;
        	for(int i=0;i<=9;i++)
        	{
        		int x = sum;
        		if(((x+i)%10) == 0)
        		{
        			String str = String.valueOf(i);
        			ans +=  "This is not a valid IMEI number but can be converted to valid IMEI number if you replace the last digit with " + str ;
        			break;
        		}
        	}
        }
        
        return ans;
    }

	private String isvalidimei(long num) {
		
		return isvalid(num);
	}

	
	
}
