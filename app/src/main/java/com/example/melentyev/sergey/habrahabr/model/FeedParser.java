package com.example.melentyev.sergey.habrahabr.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeedParser {

    public static void xmlParser(String str) {
        try {
            boolean inDataItemTag= false;
            String currentTagName = "";
            Feed feed = null;
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(str));

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTagName = parser.getName();
                        if (currentTagName.equals("item")) {
                            inDataItemTag = true;
                            feed = new Feed();
                            FeedPool.addFeed(feed);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item"))
                            inDataItemTag = false;
                        currentTagName = "";
                        break;
                    case XmlPullParser.TEXT:
                        if (inDataItemTag) {
                            switch (currentTagName) {
                                case "title":
                                    feed.setTitle(parser.getText());
                                    break;
                                case "link":
                                    feed.setLinkToFullPost(parser.getText());
                                case "description":
                                    String rawDescription = parser.getText();

                                    String finalDescription = rawDescription;
                                    feed.setDescription(finalDescription);

                                    Pattern pattern = Pattern.compile("<img src=\"(.*?)\"");
                                    Matcher matcher = pattern.matcher(rawDescription);
                                    if (matcher.find()) {
                                        URL url = new URL(matcher.group(1));
                                        System.out.println("+++++++++++++++++" + url);
                                        HttpURLConnection http = (HttpURLConnection) url.openConnection();
                                        InputStream in = http.getInputStream();
                                        Bitmap image = BitmapFactory.decodeStream(in);
                                        feed.setImage(image);
                                        in.close();
                                    }


                                    break;
                                case "pubDate":
                                    feed.setPubDate(parser.getText());
                                    break;
                                case "category":
                                    feed.setCategory(parser.getText());
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}