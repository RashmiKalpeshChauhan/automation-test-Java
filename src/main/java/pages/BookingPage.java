package pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qa.pojo.Booking;
import com.qa.pojo.BookingResponse;
import com.qa.pojo.Dates;
import com.qa.pojo.Guest;
import com.qa.pojo.Room;


public class BookingPage {
	private static final String NEWLINE = System.getProperty("line.separator");
	private static String[] callHttpUrls(final URL url, final String requestJson){
		HttpURLConnection httpURL = null;
		String[] response = new String[2];
		PrintWriter writer = null;
		try {
			httpURL = (HttpURLConnection) url.openConnection();
			httpURL.setRequestMethod("POST");
			httpURL.setRequestProperty("Content-Type", "application/json");
			httpURL.setDoOutput(true);
			writer = new PrintWriter(httpURL.getOutputStream());
			writer.println(requestJson);
			writer.flush();
			int responseCode = httpURL.getResponseCode();
			response[0] = String.valueOf(responseCode);
			if (HttpURLConnection.HTTP_OK == responseCode || HttpURLConnection.HTTP_CREATED == responseCode) {
				response[1] = readResponse(httpURL.getInputStream());
			} else {
				response[1] = readResponse(httpURL.getErrorStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
			//			huc.getInputStream().close();
			//			huc.disconnect();
		}
		return response;
	}
	private static String readResponse(InputStream inputStream) {
		BufferedReader br = null;
		StringBuilder response = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				response.append(line).append(NEWLINE);
			}			
		}catch (Exception e) {
			// LOG.error("Exception occur:",e);
		}
		return response.toString();
	}

	private static Booking populateBookingReq(int room,int adult ,int kid) throws IOException {
		BasePage basePage=new BasePage();		
		Booking booking = new Booking();
		Dates bookingDate = new Dates();
		bookingDate.setCheckin(basePage.readPropertyData("checkin"));
		bookingDate.setCheckout(basePage.readPropertyData("chcekout"));
		booking.setDates(bookingDate);
		booking.setDestination(basePage.readPropertyData("destination"));
		List<Room> roomls = new ArrayList<Room>();
		Room r1 = new Room();
		List<Guest> guestsls = new ArrayList<Guest>();
		Guest g1 = new Guest();	
		Guest g3 = new Guest();
		for (int i=0;i<=1;i++) {			
			for (int j=0;j<2;j++) {
				g1.setType(basePage.readPropertyData("guestType1"));
				//guestsls.add(g1);
				for(int k=0;k<3;k++) {					
					g3.setType(basePage.readPropertyData("guestType3"));
					g3.setAge(3);
					guestsls.add(g3);
					break;
				}

				guestsls.add(g1);
				break;
			}
			roomls.add(r1);				
		}
		r1.setGuest(guestsls);
		roomls.add(r1);	
		booking.setRoom(roomls);

		booking.setPlaceId("ChIJD7fiBh9u5kcRYJSMaMOCCwQ");

		return booking;
	}

	public static BookingResponse bookingReponse(int roomsize,String endpoint) throws IOException {
		BasePage basePage=new BasePage();
		Gson gson = new GsonBuilder().create();
		Booking booking = populateBookingReq(Integer.parseInt(basePage.readPropertyData("room")),Integer.parseInt(basePage.readPropertyData("adult")),Integer.parseInt(basePage.readPropertyData("children")));
		System.out.println("booking -->"+booking);
		String requestJson = gson.toJson(booking);
		System.out.println("****  Request Json  **** " + requestJson);
		URL url = new URL(basePage.readPropertyData("url")+endpoint);
		String[] response = callHttpUrls(url,requestJson);
		String jsonResponse = response[1];		
		System.out.println("****  Responce Json  **** " + jsonResponse);		
		Gson gsonop = new GsonBuilder().create();
		BookingResponse bookingResponseJSon = gsonop.fromJson(jsonResponse, BookingResponse.class);
		return bookingResponseJSon;
	}

}
