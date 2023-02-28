package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private List<Month> months = Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String monthNumber = request.getHeader("monthNumber");
        if (StringUtils.isEmpty(monthNumber)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Month number is missing.");
            return false;
        }

        Optional<Month> month = months.stream()
                .filter(m -> Integer.toString(m.getMonthNumber()).equals(monthNumber))
                .findFirst();
        if (month.isPresent()) {
            request.setAttribute("month", month.get());
        } else {
            Month emptyMonth = new Month();
            emptyMonth.setEnglishName("nope");
            emptyMonth.setItalianName("nope");
            emptyMonth.setGermanName("nope");
            request.setAttribute("month", emptyMonth);
        }

        return true;
    }
}
