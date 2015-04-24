package com.zdnuist.gps;
public class GPSUtils {
	
	/** 
	 * google maps的脚本里代码 
	 */    
	private final static double EARTH_RADIUS = 6378.137; 
	private static double rad(double d) 
	{ 
	     return d * Math.PI / 180.0; 
	}  

	/** 
	 * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米 
	 */ 
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) 
	{ 
	    double radLat1 = rad(lat1); 
	    double radLat2 = rad(lat2); 
	    double a = radLat1 - radLat2; 
	    double b = rad(lng1) - rad(lng2); 
	    double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
	    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2))); 
	    s = s * EARTH_RADIUS; 
	    s = Math.round(s * 10000) / 10000; 
	    return s; 
	} 
	
	private static long getDistance2(double lat1, double lng1, double lat2, double lng2) {
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLon = Math.toRadians(lng2 - lng1);
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
	            + Math.cos(Math.toRadians(lat1))
	            * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
	            * Math.sin(dLon / 2);
	    double c = 2 * Math.asin(Math.sqrt(a));
	    long distanceInMeters = Math.round(6371000 * c);
	    return distanceInMeters;
	}
	
	//http://api.map.baidu.com/direction?origin=31.988188,118.787025&destination=32.047616,118.790609&mode=driving&output=
//	http://api.map.baidu.com/direction?origin=31.98819,118.787026&destination=32.210504,118.729578&mode=driving&output=
	public static void main(String[] args) {
		double s = getDistance(31.988188d,118.787026d,32.210504d,118.729578d);
		System.out.println(s);
	}

}