package com.android.commontools.util;

import com.android.commontools.constant.Constant;

import java.util.Random;
import java.util.UUID;

public class CommonUtil {
	/**
	 * get double compare  result 
	 * @param result
	 * @return
	 */
	public static int compare(double result){
		return (result> Constant.ZERO_OF_DOUBLE_BOUNDARY)?(1):((result<(-Constant.ZERO_OF_DOUBLE_BOUNDARY))?(-1):(0));
	}
	
	/**
	 * get double compare  result 
	 * @param result
	 * @return
	 */
	public static int compare(long result){
		return (result>Constant.ZERO_OF_LONG)?(1):((result<Constant.ZERO_OF_LONG)?(-1):(0));
	}
	
	/**
	 * Judge whether the value is true
	 * @param value
	 * @return
	 */
	public static boolean isTrue(int value){
	    return (Constant.ZERO_OF_INTEGER!=value);
	}
	
	/**
	 * Judge whether the value is false
	 * @param value
	 * @return
	 */
	public static boolean isFalse(int value){
	    return !isTrue(value);
	}
	
	/**
	 * switch value of int to value of boolean
	 * @param value
	 * @return
	 */
	public static boolean getBoolean(int value){
	    
	    return (Constant.ZERO_OF_INTEGER!=value);
	}
	
	/**
	 * switch value of boolean to value of int
	 * @param value
	 * @return
	 */
	public static int getInteger(boolean value){
	    return (false==value)?(Constant.FALSE):(Constant.TRUE);
	}
	
	/**
	 * judge  whether the value is zero
	 * @param value
	 * @return
	 */
	public static boolean isZero(double value){
		boolean isZero=false;
		if((value>-Constant.ZERO_OF_DOUBLE_BOUNDARY)&&(value<Constant.ZERO_OF_DOUBLE_BOUNDARY)){
			isZero=true;
		}
		return isZero;
	}

    /**
     * judge  whether the value is equal
     * @param src
     * @param dst
     * @return
     */
    public static boolean isEqual(double src, double dst) {
        return CommonUtil.isZero(src - dst);
    }
	
	/**
	 * judge whether the value is null or empty
	 * @param value
	 * @return
     */
	public static boolean isEmpty(String value){
        boolean empty=true;
        
        if(value == null || value.length() <= 0){
            empty=true;
        }else{
            empty=false;
        }
        
        return empty;
    }

    /**
	 * udge whether the value is null,empty or "null"
	 * @param value
	 * @return
     */
	public static boolean isEmptyString(String value){
		 boolean empty=true;
	        
	        if(CommonUtil.isEmpty(value)||value.equals(Constant.NULL)){
	            empty=true;
	        }else{
	            empty=false;
	        }
	        
	        return empty;
	}

	/**
	 * https://www.cnblogs.com/heyuxiu/p/5972187.html
	 * @param str
	 * @return
	 */
	public static boolean isDigit(String str){
		boolean digit=false;
		do{
			if(true==CommonUtil.isEmpty(str)){
				break;
			}

			int strLen=str.length();
			digit=true;
			for (int i=0;i<strLen;i++) {
				if(false==Character.isDigit(str.charAt(i))){
					digit=false;
					break;
				}
			}
		}while (false);
		return digit;
	}
    /**
     * whether the value in the all-close range [minValue, MaxValue].
     * 
     * @param minValue
     * @param MaxValue
     * @param value
     * @return
     */
    public static boolean isInRange(int minValue,int MaxValue,int value){
        boolean inRange=false;
        int min=Math.min(minValue, MaxValue);
        int max=Math.max(minValue, MaxValue);
        if(value>=min&&(value<=max)){
            inRange=true;
        }
        return inRange;
    }

	/**
	 * whether the value in the all-close range [minValue, MaxValue].
	 *
	 * @param minValue
	 * @param MaxValue
	 * @param value
	 * @return
	 */
	public static boolean isInRange(long minValue,long MaxValue,long value){
		boolean inRange=false;
		long min=Math.min(minValue, MaxValue);
		long max=Math.max(minValue, MaxValue);
		if(value>=min&&(value<=max)){
			inRange=true;
		}
		return inRange;
	}

	/**
	 * whether the value in the all-close range [minValue, MaxValue].
	 *
	 * @param minValue
	 * @param MaxValue
	 * @param value
	 * @return
	 */
	public static boolean isInRange(double minValue,double MaxValue,double value){
		boolean inRange=false;
		double min=Math.min(minValue, MaxValue);
		double max=Math.max(minValue, MaxValue);
		if(value>=min&&(value<=max)){
			inRange=true;
		}
		return inRange;
	}

    /**
     * Returns a pseudo-random uniformly distributed int in the all-close range [min, max].
     * @param min
     * @param max
     * @return
     */
    public static int random(int min,int max){
        int minValue=min;
        int maxValue=max;
        
        if(min>max){
            minValue=max;
            maxValue=min;
        }
        
        Random random = new Random();

        int randomNum = random.nextInt(maxValue+1)%(maxValue-minValue+1) + minValue;
        
        return randomNum;
    }

	/**
	 *
	 * @return true or false by random
	 */
	public static boolean random(){
		return (CommonUtil.random(Constant.ONE_OF_INTEGER,Constant.HUNDRED_OF_INTEGER)%2==0);
	}

	/**
	 *
	 * @return
	 * reference:https://blog.csdn.net/xingxiupaioxue/article/details/79565775
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}

