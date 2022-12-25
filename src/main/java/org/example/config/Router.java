package org.example.config;

import io.javalin.Javalin;
import org.example.controllers.ContactController;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

/**
 * @author andreiserov
 */
public class Router {

    public static void register(Javalin app) {

        app.routes(() -> {
           path("contact", () -> {
               post(ContactController.create);
               get("{id}", ContactController::getById);
               get(ContactController::getAll);
           });
        });
    }
}