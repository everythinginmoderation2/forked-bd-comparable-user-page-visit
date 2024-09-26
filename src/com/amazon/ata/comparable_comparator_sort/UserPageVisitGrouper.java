package com.amazon.ata.comparable_comparator_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides grouping functionality for UserPageVisits that is used by UserPageVisitAggregator.
 * The only grouping functionality that's currently available is based on UserPageVisit natural order.
 */
public class UserPageVisitGrouper {
    /**
     * Returns a sorted list of UserPageVisits based on their natural order. Original list is not modified.
     * @param userPageVisits List of UserPageVisits
     * @return sorted list of userPageVisits
     */
    public List<UserPageVisit> groupUserPageVisits(List<UserPageVisit> userPageVisits) {
        // PARTICIPANTS: add logic to implement groupUserPageVisits here
        int comparison = 0;
        List<UserPageVisit> userPageVisitsCopy = new ArrayList<>();
        if (userPageVisits.size() == 1) userPageVisitsCopy.add(userPageVisits.get(0));
        for (int i = 0; i < userPageVisits.size() - 1; i++) {
            UserPageVisit thisVisit = userPageVisits.get(i);
            UserPageVisit nextVisit = userPageVisits.get(i + 1);
            int lastVisit = userPageVisits.size();
            comparison = thisVisit.compareTo(nextVisit);
            if (userPageVisits.size() == 2) {
                if (comparison < 0) {
                    userPageVisitsCopy.add(thisVisit);
                    userPageVisitsCopy.add(nextVisit);
                    return userPageVisitsCopy;
                }
                if (comparison > 0) {
                    userPageVisitsCopy.add(nextVisit);
                    userPageVisitsCopy.add(thisVisit);
                    return userPageVisitsCopy;
                }
                else {
                    userPageVisitsCopy.add(thisVisit);
                    userPageVisitsCopy.add(nextVisit);
                    return userPageVisitsCopy;
                }
            }

            if (comparison == 0) return userPageVisitsCopy;
            if (comparison < 0) {
                userPageVisitsCopy.add(thisVisit);
            }
            if (comparison > 0) {
                userPageVisitsCopy.add(nextVisit);
            }
        }

        return userPageVisitsCopy;
    }
}
