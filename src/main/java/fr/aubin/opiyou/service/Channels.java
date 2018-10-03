package fr.aubin.opiyou.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;

public class Channels {
	
	public BigInteger getSubsCount(String username) {
		BigInteger subs=null;
		HttpRequestInitializer httpRequestInitializer = new HttpRequestInitializer() {
		    public void initialize(HttpRequest request) throws IOException {
		    }
		};
		YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), httpRequestInitializer).setApplicationName("Op4you").build();
		try {
			YouTube.Channels.List search = youtube.channels().list("statistics");
			search.setForUsername(username);
			search.setKey("AIzaSyBH5cpvnKUmCysF2zVuFnV2dL47saO8bo4");
			ChannelListResponse response = search.execute();
			List<Channel> channels = response.getItems();
			for (Channel channel : channels) {
				subs = channel.getStatistics().getSubscriberCount();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(subs.toString());
		return subs;
	}
}
