package com.example.melentyev.sergey.habrahabr.model;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

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
                        if (inDataItemTag && feed != null) {
                            switch (currentTagName) {
                                case "title":
                                    feed.setTitle(parser.getText());
                                    break;
                                case "link":
                                    feed.setLinkToFullPost(parser.getText());
                                case "description":
                                    feed.setDescription(parser.getText());
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