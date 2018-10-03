package fr.aubin.opiyou;


import java.math.BigInteger;

import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domaine.Youtuber;
import fr.aubin.opiyou.service.Channels;


public class App 
{
	
	
    public static void main( String[] args )
    {
       Channels channel = new Channels();
       channel.getSubsCount("Dirtyphonics");
       
       Youtuber myTestYt = new Youtuber(0, "Tony", "Johnny", "Dirtyphonics", "Dirtyphonics", channel.getSubsCount("Dirtyphonics"), "dirty", "phonics", "https://www.youtube.com/user/Dirtyphonics");
       YoutuberDAO myYtDaoCo = new YoutuberDAO();
       myYtDaoCo.createYoutuber(myTestYt);
    }
}
