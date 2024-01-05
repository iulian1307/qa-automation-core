package com.qaitsolutions.qa.automation.core.assertion;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Entity tracks errors from assertions and stores them.
 */
public class ErrorTracker {

    @Getter
    private final List<ErrorDTO> errors = new ArrayList<>();

    /**
     * Inserts error to tracker
     *
     * @param message Description of error
     * @param e       Actual thrown error
     */
    public void addError(String message, Throwable e) {
        errors.add(new ErrorDTO(message, e));
    }

    /**
     * Inserts error to tracker
     *
     * @param message Description of error
     */
    public void addError(String message) {
        var errorDto = new ErrorDTO();
        errorDto.setDescription(message);

        errors.add(errorDto);
    }

    /**
     * Inserts error to tracker
     *
     * @param e Actual thrown error
     */
    public void addError(Throwable e) {
        var errorDto = new ErrorDTO();
        errorDto.setException(e);

        errors.add(errorDto);
    }

    /**
     * Retrieves all errors and returns them as a String
     *
     * @return {@link String} containing all errors
     */
    public String getErrorsAsString() {
        return errors
                .stream()
                .map(ErrorDTO::toString)
                .collect(Collectors.joining("\n"));
    }

    /**
     * @return True if tracker contains errors, False if tracker doesn't contain errors
     */
    public boolean containsErrors() {
        return !errors.isEmpty();
    }

    /**
     * Removes all stored errors
     */
    public void clear() {
        errors.clear();
    }
}
