package com.epam.brest.course.web_app.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller for error page.
 */
@ControllerAdvice
public class ErrorController extends RuntimeException {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Exception handler.
     *
     * @param exc   Exception.
     * @param model model.
     * @return template name.
     */
    @ExceptionHandler(Exception.class)
    public final String exceptionHandler(final Exception exc,
                                         final Model model) {
        LOGGER.debug("exceptionHandler({})", exc.getMessage());
        model.addAttribute("text", exc.getLocalizedMessage());
        return "error";
    }
}