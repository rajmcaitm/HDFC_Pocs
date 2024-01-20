package com.hdfc;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hdfc.set5.CalculatorService;
import com.hdfc.set5.MathApplication;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   @InjectMocks 
   MathApplication mathApplication = new MathApplication();

   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
      when(calcService.add(10.0,20.0)).thenReturn(30.00);
		
      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
      verify(calcService).add(10.0, 20.0);
    
   }
   
	
}