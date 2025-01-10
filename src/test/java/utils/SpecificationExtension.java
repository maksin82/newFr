package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecificationExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        final Logger logger = LoggerFactory.getLogger(SpecificationExtension.class);

        final int[] expCode = {200};
        context.getTestMethod().ifPresent(method -> {
            ExpectedStatusCode statusCodeAnnotation = method.getAnnotation(ExpectedStatusCode.class);
            if (statusCodeAnnotation != null) {
                expCode[0] = statusCodeAnnotation.value();
            }
        });

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        logger.debug("Setting expected status code to: {}", expCode[0]);

        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification(expCode[0]));
    }
}
