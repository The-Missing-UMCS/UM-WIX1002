package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q3;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
public class OAIRecord {
    private String doi;
    private String title;
    private String subject;
    private List<String> authors;
    private String keyword;
    private String status;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAIRecord other = (OAIRecord) obj;
        return Objects.equals(doi, other.doi) &&
            Objects.equals(title, other.title) &&
            Objects.equals(subject, other.subject) &&
            Objects.equals(authors, other.authors) &&
            Objects.equals(keyword, other.keyword) &&
            Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doi, title, subject, authors, keyword, status);
    }
}
