package com.umwix1002.solution.lab.lab5.l5q5;

import com.umwix1002.solution.lab.CommonConstant;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The result of a search.
 * @author Ng Zhi Yang
 */
@Getter
public class SearchResult {
    @NotNull
    @Setter(AccessLevel.PRIVATE)
    private Integer numberOfLoops;
    
    @Nullable
    @Setter(AccessLevel.PUBLIC)
    private Integer result;
    
    @NotNull
    @Setter(AccessLevel.PRIVATE)
    private SearchCriteria searchCriteria;

    /**
     * Increment the number of loops.
     */
    public void loop() {
        numberOfLoops++;
    }

    /**
     * Create a new SearchResult.
     * @param searchCriteria the search criteria
     * @return the new SearchResult
     */
    public static SearchResult of(SearchCriteria searchCriteria) {
        SearchResult searchResult = new SearchResult();
        searchResult.setNumberOfLoops(CommonConstant.ZERO);
        searchResult.setSearchCriteria(searchCriteria);
        return searchResult;
    }
}
