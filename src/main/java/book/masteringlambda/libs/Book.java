package book.masteringlambda.libs;

import java.time.Year;
import java.util.List;

/**
 * Created by Rahul on 10/4/20
 */
public class Book {
    public enum TOPIC {
        HISTORY, PROGRAMMING, COMPUTING, MEDICINE, FICTION,
    };

    String title;
    List<String> authors;
    int[] pageCounts;
    Year pubDate;
    Double height;
    TOPIC topic;

    Book referredTo;
    boolean referred;


    public Book(String title, List<String> authors, int[] pageCounts, Year pubDate, Double height, TOPIC topic) {
        this.title = title;
        this.authors = authors;
        this.pageCounts = pageCounts;
        this.pubDate = pubDate;
        this.height = height;
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int[] getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(int[] pageCounts) {
        this.pageCounts = pageCounts;
    }

    public Year getPubDate() {
        return pubDate;
    }

    public void setPubDate(Year pubDate) {
        this.pubDate = pubDate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public TOPIC getTopic() {
        return topic;
    }

    public void setTopic(TOPIC topic) {
        this.topic = topic;
    }


    public Book getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(Book referredTo) {
        this.referredTo = referredTo;
    }

    public boolean isReferred() {
        return referred;
    }

    public void setReferred(boolean referred) {
        this.referred = referred;
    }
}
