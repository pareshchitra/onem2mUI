package swm;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import RequestResponseFunctions.HTTPToOneM2MConverter;
import tojo.AE;
import tojo.AccessControlPolicy;
import tojo.AccessControlRule;
import tojo.Container;
import tojo.ContentInstance;
import tojo.EventNotificationCriteria;
import tojo.FilterCriteria;
import tojo.PrimitiveContent;
import tojo.RequestPrimitive;
import tojo.ResponsePrimitive;
import tojo.SetOfAcrs;
import tojo.Subscription;

public class Test {

	
	public static void create_ae()
	{
		AE ae1 = new AE();
		ae1.setAppID("123");
		ae1.isRequestReachability();
		ae1.setAppName("test_ae");
		ae1.setResourceName("test");
		PrimitiveContent content = new PrimitiveContent();
		content.setAny(ae1);
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R0");
		request.setFrom("C");
		request.setOperation(new BigInteger("1"));
		request.setRequestIdentifier("5678");
		request.setResourceType(new BigInteger("2"));
		request.setPrimitiveContent(content);
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ae1.getResourceID());
	}
	
	public static void delete_ae()
	{
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("C1697297");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("4"));
		request.setRequestIdentifier("1234");
		request.setResourceType(new BigInteger("2"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ae1.getResourceID());
	}
	
	public static void update_ae()
	{
		AE ae1 = new AE();
		//ae1.setResourceName("RaspberryPi_SWM");
		ae1.setRequestReachability(true);
		PrimitiveContent content = new PrimitiveContent();
		content.setAny(ae1);
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("C1697297");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("3"));
		request.setRequestIdentifier("1234");
		request.setPrimitiveContent(content);
		request.setResourceType(new BigInteger("2"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ae1.getResourceID());
	}
	

	
	public static void retreive_ae()
	{
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("C1697297");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("2"));
		request.setRequestIdentifier("1234");
		request.setResourceType(new BigInteger("2"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
	}
	
	
	public static void create_cnt()
	{
		Container cnt1=new Container();
		cnt1.setResourceName("RasberryPi");
		PrimitiveContent content = new PrimitiveContent();
		content.setAny(cnt1);
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("C1697297");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("1"));
		request.setRequestIdentifier("4545");
		request.setResourceType(new BigInteger("3"));
		request.setPrimitiveContent(content);
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void retreive_cnt()
	{
		
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1665939");
		request.setFrom("C1665796");
		request.setOperation(new BigInteger("2"));
		request.setRequestIdentifier("9898");
		//request.setResourceType(new BigInteger("1"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void delete_cnt()
	{
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1697366");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("4"));
		request.setRequestIdentifier("9898");
		//request.setResourceType(new BigInteger("4"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void create_acp()
	{
		AccessControlPolicy acp1 = new AccessControlPolicy();
		acp1.setResourceName("ACPWebUI");
		SetOfAcrs  abc = new SetOfAcrs(); 
		AccessControlRule abcd = new AccessControlRule();
		abcd.setAccessControlOperations(new BigInteger("63"));
		abcd.setAccessControlAuthenticationFlag(true);
		List<String> L2 = abcd.getAccessControlOriginators();
		L2.add("R01");
		L2.add("C1697297");
		List<AccessControlRule> L1 = abc.getAccessControlRule();
		L1.add(abcd);
		acp1.setPrivileges(abc);
		acp1.setSelfPrivileges(abc);
		
		PrimitiveContent content = new PrimitiveContent();
		content.setAny(acp1);
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("C1697297");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("1"));
		request.setRequestIdentifier("9898");
		request.setResourceType(new BigInteger("1"));
		request.setPrimitiveContent(content);
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void delete_acp()
	{
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1697870");
		request.setFrom("R1697366");
		request.setOperation(new BigInteger("4"));
		request.setRequestIdentifier("9898");
		request.setResourceType(new BigInteger("1"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			ResponsePrimitive responsePrimitive = convertor.sendRequest(request, "http://192.168.126.9:8080");
			System.out.println(responsePrimitive.getResponseStatusCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
	}
	
	public static void retreive_acp()
	{
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1698228");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("2"));
		request.setRequestIdentifier("9898");
		request.setResourceType(new BigInteger("1"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
	}
	
	public static void update_acp()
	{
		AccessControlPolicy acp1 = new AccessControlPolicy();

		SetOfAcrs  abc = new SetOfAcrs(); 
		AccessControlRule abcd = new AccessControlRule();
		abcd.setAccessControlOperations(new BigInteger("63"));
		abcd.setAccessControlAuthenticationFlag(true);
		List<String> L2 = abcd.getAccessControlOriginators();
		L2.add("C1769273");
		L2.add("R0");
		L2.add("C1697297");
		List<AccessControlRule> L1 = abc.getAccessControlRule();
		L1.add(abcd);
		acp1.setPrivileges(abc);
		acp1.setSelfPrivileges(abc);
		PrimitiveContent content = new PrimitiveContent();
		content.setAny(acp1);
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1698228");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("3"));
		request.setRequestIdentifier("9898");
		request.setResourceType(new BigInteger("1"));
		request.setPrimitiveContent(content);
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void create_cnt_instance()
	{
		ContentInstance ci = new ContentInstance();
		ci.setContent("LevelSub1");
		ci.setContentInfo("text/plain:0");
		PrimitiveContent content = new PrimitiveContent();
		content.setAny(ci);
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1697402");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("1"));
		request.setRequestIdentifier("4545");
		request.setResourceType(new BigInteger("4"));
		request.setPrimitiveContent(content);
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void delete_cnt_instance()
	{
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R2104350");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("4"));
		request.setRequestIdentifier("4545");
		request.setResourceType(new BigInteger("4"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void create_sub()
	{
		Subscription sub1=new Subscription();
		sub1.setResourceName("TotalVol");
		List<String> st1=sub1.getNotificationURI();
		st1.add("http://192.168.108.164:8080/webui/NotifHandler3");
		EventNotificationCriteria enc=new EventNotificationCriteria();
		List<BigInteger> l1=enc.getNotificationEventType();
		l1.add(new BigInteger("3"));
		sub1.setEventNotificationCriteria(enc);
		sub1.setNotificationContentType(new BigInteger("1"));
		PrimitiveContent content = new PrimitiveContent();
		content.setAny(sub1);
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1697411");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("1"));
		request.setRequestIdentifier("4545");
		request.setResourceType(new BigInteger("23"));
		request.setPrimitiveContent(content);
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	public static void retreive_sub()
	{
		RequestPrimitive request = new RequestPrimitive();
		request.setTo("R1913103");
		request.setFrom("C1697297");
		request.setOperation(new BigInteger("2"));
		request.setRequestIdentifier("4545");
		//request.setResourceType(new BigInteger("23"));
		HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
		//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
		try {
			convertor.sendRequest(request, "http://192.168.126.9:8080");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
	}
		public static void update_sub()
		{
			Subscription sub1=new Subscription();
			//ae1.setResourceName("RaspberryPi_SWM");
			List<String> st1=sub1.getNotificationURI();
			st1.add("http://192.168.108.164:8080/webui/NotifHandler2");
			EventNotificationCriteria enc=new EventNotificationCriteria();
			List<BigInteger> l1=enc.getNotificationEventType();
			l1.add(new BigInteger("3"));
			sub1.setEventNotificationCriteria(enc);
			sub1.setNotificationContentType(new BigInteger("1"));
			PrimitiveContent content = new PrimitiveContent();
			content.setAny(sub1);
			RequestPrimitive request = new RequestPrimitive();
			request.setTo("R2103935");
			request.setFrom("C1697297");
			request.setOperation(new BigInteger("3"));
			request.setRequestIdentifier("4545");
			request.setPrimitiveContent(content);
			request.setResourceType(new BigInteger("23"));
			HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
			//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
			try {
				convertor.sendRequest(request, "http://192.168.126.9:8080");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(ae1.getResourceID());
		
		}
	
		public static void motor_cnt_instance(String a)
		{
			ContentInstance ci = new ContentInstance();
			ci.setContent(a);
			ci.setContentInfo("text/plain:0");
			PrimitiveContent content = new PrimitiveContent();
			content.setAny(ci);
			RequestPrimitive request = new RequestPrimitive();
			request.setTo("R1697421");
			request.setFrom("C1697297");
			request.setOperation(new BigInteger("1"));
			request.setRequestIdentifier("4545");
			request.setResourceType(new BigInteger("4"));
			request.setPrimitiveContent(content);
			HTTPToOneM2MConverter convertor=new HTTPToOneM2MConverter();
			//convertor.onem2mToHTTPRequest("192.168.126.9:8080", request);
			try {
				convertor.sendRequest(request, "http://192.168.126.9:8080");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	
	public static void main(String [] args)
	{
				 // 	"ri"			"name"	
				//		C1697297  WaterFlowMeter1,    	C1769273, WebUI
	//create_cnt(); //  R1697379, WaterMeter2 	   R1697402, LevelSensor   R1697411,RelayIC	   R1697421,RasberryPi
	//update_ae();
	//delete_acp();
	//create_acp();  //   R1698228,  ACPWebUI		
	//retreive_ae();
	//retreive_acp();
	//update_acp();
	//retreive_cnt(); 
	//delete_ae();
	//create_cnt_instance(); //   , WaterMeter2 	 R1767815, LevelSensor    R1767825, RelayIC	    R1767837, RasberryPi    R1839987  ,WM2CI   R1913103 , Dummy45 
	//create_sub();      //           R1791704,   Wm2sub 	   R1791717, Lvsub		  R1791737, Relaysub	R1791761 , Raspberrysub     
	//update_sub();
	//retreive_sub();
	//delete_cnt();
	//delete_cnt_instance();
	//create_ae();
	//motor_cnt_instance("OFF");
		  
		
		
	}
	
	
}
