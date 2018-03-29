package com.epam.brest.course.web_app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Rest controller for error page.
 */
@RestController
public class ErrorController {

    @RequestMapping(path = "/error")
    public ModelAndView handle(HttpServletRequest request) {
        ModelAndView errorPage = new ModelAndView("error");
        String errorMsg = "Http Error Code " +
                request.getAttribute("javax.servlet.error.status_code") + ": ";

        switch (getErrorCode(request)) {
            case 500:
                errorMsg += "Internal Server Error";
                break;
            case 501:
                errorMsg += "Not Implemented";
                break;
            case 502:
                errorMsg += "Bad Gateway";
                break;
            case 503:
                errorMsg += "Service Unavailable";
                break;
            case 504:
                errorMsg += "Gateway Timeout";
                break;
            case 505:
                errorMsg += "HTTP Version Not Supported";
                break;
            case 506:
                errorMsg += "Variant Also Negotiates";
                break;
            case 507:
                errorMsg += "Insufficient Storage";
                break;
            case 508:
                errorMsg += "Loop Detected";
                break;
            case 509:
                errorMsg += "Bandwidth Limit Exceeded";
                break;
            case 510:
                errorMsg += "Not Extended";
                break;
            case 511:
                errorMsg += "Network Authentication Required";
                break;
            default:
                errorMsg += request
                        .getAttribute("javax.servlet.error.message");
        }

        errorPage.addObject("text", errorMsg);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest request) {
        return (int) request
                .getAttribute("javax.servlet.error.status_code");
    }
}
