package com.amazon.ata.comparable_comparator_sort;

import java.util.Objects;

/**
 * This class contains information for a particular user page visit, including unique userId,
 * visited page and time spent on the page expressed in seconds.
 */
public class UserPageVisit implements Comparable<UserPageVisit> {
    private long userId;
    private String page;
    private int timeOnPageInSeconds;

    /**
     * Constructs a UserPageVisit object.
     * @param userId unique userId
     * @param page page that the user has visited
     * @param timeOnPageInSeconds time (in seconds) that user spent on the page
     */
    public UserPageVisit(long userId, String page, int timeOnPageInSeconds) {
        this.userId = userId;
        this.page = page;
        this.timeOnPageInSeconds = timeOnPageInSeconds;
    }

    public long getUserId() {
        return userId;
    }

    public String getPage() {
        return page;
    }

    public int getTimeOnPageInSeconds() {
        return timeOnPageInSeconds;
    }

    /**
     * The method that checks if this object is equal to another object. If the object is of same type,
     * the fields that are compared for equality are userId and page. Field timeOnPageInSeconds is ignored.
     * @param o - object to compare this object against.
     * @return true if objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // PARTICIPANTS: implement equals method here (hint: you can use intellij's auto-generate).
        boolean isSameObject = false;
        if (this.getClass() == o.getClass()) {
            boolean sameUserIds = this.getUserId() == ((UserPageVisit) o).getUserId();
            boolean samePage = Objects.equals(this.getPage(), ((UserPageVisit) o).getPage());
            isSameObject = sameUserIds && samePage;
        }
        return isSameObject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, page);
    }

    /**
     * Compares with another UserPageVisit.
     *
     * Ordering logic:
     * 1 Sort by userId, ascending
     * 2 if userId is equal, sort by page, ascending
     * @param other user page visit which is being compared to this one
     * @return < 0 if this UserPageVisit orders before other
     *         0 if this UserPageVisit is equal to other
     *         > 0 if this UserPageVisit orders after other
     */
    @Override
    public int compareTo(UserPageVisit other) {
        // PARTICIPANTS: implement compareTo method here
        int result = 0;
        if (this.getUserId() < other.getUserId()) result = -1;
        else if (this.getUserId() > other.getUserId()) result = 1;
        else if (this.getUserId() == other.getUserId()) {
            if (this.getPage().compareTo(other.getPage()) > 0) result = 1;
            else if (this.getPage().compareTo(other.getPage()) < 0) result = -1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "UserPageVisit{" +
               "userId=" + userId +
               ", page='" + page + '\'' +
               ", timeOnPageInSeconds=" + timeOnPageInSeconds +
               '}';
    }
}
