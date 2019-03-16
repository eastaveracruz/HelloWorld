package edu.films.service;

import edu.films.model.RatedBook;

/**
 *
 */
public enum Filter {
    MYRATED {
        public boolean satisfy(RatedBook ratedBook) {
            return ratedBook != null && ratedBook.getRating() != null;
        }
    };

    public boolean satisfy(RatedBook ratedBook) {
        return ratedBook != null;
    }
}
